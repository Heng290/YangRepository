package com.yang.Domain.dao;

import com.yang.Domain.student;

import java.util.List;

public interface StudneDao {
    //查询
    List<student> selectstudent();
    int insertStudent(student student);

}
