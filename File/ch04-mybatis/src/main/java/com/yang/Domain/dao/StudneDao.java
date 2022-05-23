package com.yang.Domain.dao;

import com.yang.Domain.student;
import com.yang.vo.param;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudneDao {
    //查询（传入一个简单参数 ）
    public  student selectStudne(Integer id);
    /*
        多个参数
            在形参前面加入 @Param（“自定义名字“）
     */
    List<student> selectStudne2(@Param("myid") Integer id, @Param("myname") String name);

    /*
        多个参数  使用javva对象作为参数
     */
    List<student> selectStudne3(param p);

    /*
       多个参数 按位置传值
    */
    List<student> selectStudne4(String name, Integer age);

    /*
       多个参数 使用map
    */
    List<student> selectStudne5(Map<String, Object> map);
}
