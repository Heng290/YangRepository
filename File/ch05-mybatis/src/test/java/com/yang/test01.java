package com.yang;

import com.yang.Domain.dao.StudneDao;
import com.yang.Domain.student;
import com.yang.utils.MyUtils;
import com.yang.vo.param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test01 {
    @Test
    public void tst01(){

        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        student s = dao.selectStudne(452);
        System.out.println(s);


    }
    @Test
    public void tst02(){
         SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        List<student> s = dao.selectStudne2(452,"yang");
        for (student a:s
             ) {
            System.out.println(a);
        }
        sqlsession.close();
    }

    @Test
    public void tst03(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        int i  = dao.contStudent();
        System.out.println(i);
        sqlsession.close();
    }

    @Test
    public void tst04(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        Map<Object,Object> map = dao.selctmapstudent(452);
        System.out.println("map="+map);
        sqlsession.close();
    }
//
//    @Test
//    public void tst05(){
//        SqlSession sqlsession = MyUtils.getSqlsession();
//        StudneDao dao = sqlsession.getMapper(StudneDao.class);
//        //调用dao的方法 竞选数据库的操作
//        //准备好 模糊查询的内容
//        String name = "%ch%";
//        List<student> map = dao.seletresultmap3(name);
//        for (student s:map
//             ) {
//            System.out.println(s);
//        }
//        sqlsession.close();
//    }

    @Test
    public void tst06(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        //准备好 模糊查询的内容
        String name = "ch";
        List<student> map = dao.seletresultmap3(name);
        for (student s:map
        ) {
            System.out.println(s);
        }
        sqlsession.close();
    }
}
