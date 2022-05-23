package cim.yang.domain.dao;

import cim.yang.domain.student;

import java.util.List;

public interface studentDao {
    //查询表单的所有数据
   public List<student> sletcstuden();
   // 插入方法
    public int insertstudent(student student);
}
