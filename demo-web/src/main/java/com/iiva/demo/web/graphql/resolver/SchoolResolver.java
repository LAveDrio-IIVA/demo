package com.iiva.demo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.iiva.demo.web.graphql.entity.School;
import com.iiva.demo.web.graphql.entity.Teacher;
import com.iiva.demo.web.graphql.service.DemoService;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.context.GraphQLContext;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class SchoolResolver implements GraphQLResolver<School> {

    public CompletableFuture<List<Teacher>> teachers(School school, DataFetchingEnvironment dfe) {
        Optional<DataLoaderRegistry> registry = ((GraphQLContext) dfe.getContext()).getDataLoaderRegistry();
        if (registry.isPresent()) {
            DataLoader<Integer, List<Teacher>> teacherLoader = registry.get().getDataLoader("teacherDataLoader");

            return teacherLoader.load(school.getId());
        }
        throw new IllegalStateException("No teacher data loader found");
    }

//    public List<Teacher> teachers(School school){
//
//        return demoService.getTeachersBySchoolId(school.getId());
//    }

    // To test FieldResolverScanner rule
//    {
//
//        Teacher teacher = new Teacher();
//        teacher.setName("李博博");
//        this.teachers = new ArrayList<>();
//        this.teachers.add(teacher);
//    }
//    private List<Teacher> teachers;

    // To test FieldResolverScanner rule
//    public List<Teacher> getTeachers(School school){
//
//        return demoService.getTeachersBySchoolId(school.getId());
//    }

    @Autowired
    private DemoService demoService;
}
