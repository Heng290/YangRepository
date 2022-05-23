package com.yang;

import com.yang.Domain.dao.StudneDao;
import com.yang.Domain.student;
import com.yang.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
        List<student> s = dao.selectstudent();
        for (student a:s
             ) {
            System.out.println(a);
        }


    }
    @Test
    public void tst02(){
        SqlSession sqlsession = MyUtils.getSqlsession();
        StudneDao studneDao = sqlsession.getMapper(StudneDao.class);
        student student1 = new student();
        student1.setName("aagadt");
        student1.setId(15224);
        student1.setEmail("53483@qq.com");
        student1.setAge(99);
        int i = studneDao.insertStudent(student1);
        sqlsession.commit();
        System.out.println(i);
    }
}
