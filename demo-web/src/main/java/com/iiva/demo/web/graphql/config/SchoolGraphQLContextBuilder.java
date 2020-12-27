package com.iiva.demo.web.graphql.config;

import com.iiva.demo.web.graphql.entity.Teacher;
import com.iiva.demo.web.graphql.service.DemoService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

import graphql.servlet.context.*;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchoolGraphQLContextBuilder implements GraphQLContextBuilder {

  @Autowired
  private DemoService demoService;

  @Override
  public GraphQLContext build(HttpServletRequest req, HttpServletResponse response) {

    return DefaultGraphQLServletContext.createServletContext(buildDataLoaderRegistry(), null).with(req).with(response)
            .build();
  }

  @Override
  public GraphQLContext build(Session session, HandshakeRequest request) {
    return DefaultGraphQLWebSocketContext.createWebSocketContext(buildDataLoaderRegistry(), null).with(session)
        .with(request).build();
  }

  @Override
  public GraphQLContext build() {
    return new DefaultGraphQLContext(buildDataLoaderRegistry(), null);
  }

  private DataLoaderRegistry buildDataLoaderRegistry() {
    DataLoaderRegistry dataLoaderRegistry = new DataLoaderRegistry();
    dataLoaderRegistry.register("teacherDataLoader",
        new DataLoader<Integer, List<Teacher>>(schoolIds ->
            CompletableFuture.supplyAsync(() ->
                    demoService.getTeachersBySchoolIds(schoolIds))));
    return dataLoaderRegistry;
  }

}
