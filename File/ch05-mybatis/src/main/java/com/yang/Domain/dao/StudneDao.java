package com.yang.Domain.dao;

import com.yang.Domain.student;
import com.yang.vo.param;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudneDao {

    public  student selectStudne(Integer id);


    List<student> selectStudne2(@Param("myid") Integer id, @Param("myname") String name);

    //查询总的数据条数
    int contStudent();


    //返回 map  只能最多返回一行记录
    Map<Object,Object> selctmapstudent(Integer id);

    /*
        使用resulymap 定义映射关系
     */
    List<student> seletresultmap();

    List<student> seletresultmap2();

    /*
        第一种模糊查询 :在java代码中 指定 like的内容
     */
    List<student> seletresultmap3(@Param("name1") String name);


    /*
        第二种模糊查询 :
            name就是 模糊查询的值  在mapper中拼接 like %ch%
     */
    List<student> seletresultmap4(@Param("name") String name);
}
