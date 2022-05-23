package com.yang;

import com.github.pagehelper.PageHelper;
import com.yang.Domain.dao.StudneDao;
import com.yang.Domain.student;
import com.yang.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test01 {
    @Test
    public void tst01(){

        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        student s = new student();
        s.setAge(10);
        s.setName("chang");
        List<student> students = dao.selcetIF(s);
        for (student a : students){
            System.out.println(a);
        }
    }
    @Test
    public void tst02(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        student s = new student();
        s.setAge(10);
        s.setName("chang");
        List<student> students = dao.selcetWhere(s);
        for (student a : students){
            System.out.println(a);
        }
    }
    @Test
    public void tst03(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        List<Integer> list = new ArrayList<>();
        list.add(452);
        list.add(1534);
        List<student> students = dao.selcetForeach1(list);
        for (student a : students){
            System.out.println(a);
        }
    }

    @Test
    public void tst04(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        List<student> list = new ArrayList<>();
        student s1 =new student();
        s1.setId(452);
        list.add(s1);
        student s2 =new student();
        s1.setId(1534);
        list.add(s2);
        List<student> students = dao.selcetForeach2(list);
        for (student a : students){
            System.out.println(a);
        }
    }


    @Test
    public void tst05(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        //加入PageHelper的方法 分页
        //pageNum:表示第几页  从第一页开始
        //pageSzie：表示每页3个数据
        PageHelper.startPage(1,3);

       List<student> students = dao.selcetPageHlper();
        for (student a : students){
            System.out.println(a);
        }
    }
}
