package com.iiva.demo.web.graphql.dataLoader;

import com.iiva.demo.web.graphql.dao.DemoDao;
import com.iiva.demo.web.graphql.entity.Teacher;
import com.iiva.demo.web.graphql.service.DemoService;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public class TeacherDataLoader implements BatchLoader<Integer, Teacher> {

    @Override
    public CompletionStage<List<Teacher>> load(List<Integer> schoolIds) {

        return CompletableFuture.supplyAsync(() -> demoService.getTeachersBySchoolIds(schoolIds));
    }

    @Autowired
    private DemoService demoService;
}
