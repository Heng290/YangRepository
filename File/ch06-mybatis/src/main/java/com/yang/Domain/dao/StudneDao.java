package com.yang.Domain.dao;


import com.yang.Domain.student;

import java.util.List;

public interface StudneDao {
    //动态sql语句  IF ， 使用java对象作为参数
    List<student> selcetIF(student student);

    //动态sql语句  where， 使用java对象作为参数
    List<student> selcetWhere(student student);

    //动态sql语句  foreach 用法一
    List<student> selcetForeach1(List<Integer> idlist);

    //动态sql语句  foreach 用法二  参数是 对象
    List<student> selcetForeach2(List<student> students);

    //pageHlper 进行数据分页
    List<student> selcetPageHlper();
}
