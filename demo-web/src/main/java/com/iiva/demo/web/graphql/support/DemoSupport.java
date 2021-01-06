package com.iiva.demo.web.graphql.support;

import com.iiva.demo.web.graphql.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DemoSupport {

    // <注意：此方法废弃也并未完善排序工作！！！>
    // 由于dataloader将父子元素关联的机制,默认是通过“队列”顺序对应的，
    // 故需要手动地将子元素的集合根据传入的id集合的顺序进行排序(但排序工作在此方法中并未实现！)，
    // 关于这个机制，官方（dataloader的github）是如下说明：
    // There are a few constraints this function must uphold:
    //      1.The Array of values must be the same length as the Array of keys.
    //      2.Each index in the Array of values must correspond to the same index in the Array of keys.
    // 更完善的解法参见外部SchoolGraphQLContextBuilder类（见：java-dataloader官方github说明）：
    // 其中有关于MappedBatchLoader的应用（可以通过键值对的方式映射）
    @Deprecated
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
