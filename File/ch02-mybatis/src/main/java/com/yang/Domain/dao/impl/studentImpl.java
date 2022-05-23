package com.yang.Domain.dao.impl;

import com.yang.Domain.dao.StudneDao;
import com.yang.Domain.student;
import com.yang.utils.MyUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class studentImpl implements StudneDao {
    @Override
    public List<student> selectstudent() {
        //获取sqlsessi对象
        SqlSession sqlsession = MyUtils.getSqlsession();
        String sqlId = "com.yang.Domain.dao.StudneDao.selectstudent";
        //执行sql语句
        List<student> s = sqlsession.selectList(sqlId);
        //关闭
        sqlsession.close();

        return s;
    }

    @Override
    public int insertStudent(student student) {
        //获取sqlsessi对象
        SqlSession sqlsession = MyUtils.getSqlsession();
        String sqlId = "com.yang.Domain.dao.StudneDao.insertStudent";
        //执行sql语句

        int insert = sqlsession.insert(sqlId, student);
        //提交事务
        sqlsession.commit();
        //关闭
        sqlsession.close();

        return insert;
    }
}
