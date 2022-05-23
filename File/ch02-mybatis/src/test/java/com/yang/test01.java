package com.yang;

import com.yang.Domain.dao.StudneDao;
import com.yang.Domain.dao.impl.studentImpl;
import com.yang.Domain.student;
import org.junit.Test;

import java.util.List;

public class test01 {
    @Test
    public void tst01(){
        StudneDao dao = new studentImpl();
        List<student> list = dao.selectstudent();
        for (student a:list
             ) {
            System.out.println(a);
        }
    }
    @Test
    public void tst02(){
        StudneDao dao = new studentImpl();
        student student1 = new student();
        student1.setName("ahadt");
        student1.setId(1534);
        student1.setEmail("51383@qq.com");
        student1.setAge(30);
        int i = dao.insertStudent(student1);
        System.out.println(i);
    }
}
