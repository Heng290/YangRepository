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
       /*
            使用mybatis的动态代理机制  使用sqlsession.getmapper(dao借口)
            getMapper能获取到dao借口对于的实现类对象

        */
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
        param p = new param();
        p.setPage(30);
        p.setPname("chang");
        List<student> s = dao.selectStudne3(p);
        for (student a:s
        ) {
            System.out.println(a);
        }
        sqlsession.close();
    }
    @Test
    public void tst04(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        List<student> s = dao.selectStudne4("chang",30);
        for (student a:s
        ) {
            System.out.println(a);
        }
        sqlsession.close();
    }

    @Test
    public void tst05(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao dao = sqlsession.getMapper(StudneDao.class);
        //调用dao的方法 竞选数据库的操作
        Map<String, Object> s = new HashMap<>();
        s.put("mname","yang");
        s.put("mage","30");
        List<student> s1 = dao.selectStudne5(s);
        for (student a:s1
        ) {
            System.out.println(a);
        }
        sqlsession.close();
    }
}
