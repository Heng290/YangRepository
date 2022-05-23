package cim.yang.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //方位mybatis读取student数据
        //1. 定义mybatis主配置文件的名称，从类路径的根开始
        String config="mybatis.xml";
        //2. 读取config文件
        InputStream in = Resources.getResourceAsStream(config);
        //3. 创建sqlsessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4. 创建sqlsessionfactory对象
        SqlSessionFactory factory = builder.build(in);
        //5. (重要！！)获取sqlsession对象，从sqlsessionfactory中获取
        SqlSession session =  factory.openSession();
        //6. (重要！！)指定要执行的sql语句的标识  sql映射文件中的namespace+“.”+标签的id值
        String sql = "cim.yang.domain.dao.studentDao"+"."+"sletcstuden";
        //7. 执行sql 语句 通过sqlId语句执行
        List<student> students = session.selectList(sql);
        // 8 . 输出结果
        students.forEach(student -> System.out.println(student));
        //9. 关闭流
        session.close();

    }
}
