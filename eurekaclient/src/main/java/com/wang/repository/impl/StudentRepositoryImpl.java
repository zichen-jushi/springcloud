package com.wang.repository.impl;

import com.wang.entity.Student;
import com.wang.repository.StudentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1L, new Student(1L,"张三",22));
        studentMap.put(2L, new Student(2L,"李四",23));
        studentMap.put(3L, new Student(3L,"王五",24));
        studentMap.put(4L, new Student(4L,"赵六",25));
        studentMap.put(5L, new Student(5L,"钱七",26));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(Long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(Long id) {
        studentMap.remove(id);
    }
}
