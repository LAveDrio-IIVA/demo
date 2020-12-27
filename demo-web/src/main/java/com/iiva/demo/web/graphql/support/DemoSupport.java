package com.iiva.demo.web.graphql.support;

import com.iiva.demo.web.graphql.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DemoSupport {

    public List<List<Teacher>> combineTeachersBySchoolId(List<Teacher> teachers){

        Map<Integer,List<Teacher>> teachersCombineMap = new HashMap<>();

        for (Teacher teacher:teachers) {

            if(teachersCombineMap.get(teacher.getSchoolId()) == null){

                List<Teacher> ts = new ArrayList<>();
                ts.add(teacher);
                teachersCombineMap.put(teacher.getSchoolId(),ts);
                continue;
            }
            teachersCombineMap.get(teacher.getSchoolId()).add(teacher);
        }

        return new ArrayList<>(teachersCombineMap.values());
    }
}
