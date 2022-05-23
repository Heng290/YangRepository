package cim.yang;

import cim.yang.domain.student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test01 {
    //测试方法
    @Test
    public void test01() throws IOException {
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
        String sql = "cim.yang.domain.dao.studentDao"+"."+"insertstudent";

        //7. 执行sql 语句 通过sqlId语句执行
        student student = new student();
        student.setId(1534);
        student.setName("hatatae");
        student.setEmail("15343@qq.com");
        student.setAge(30);
        int num = session.insert(sql,student);

        //mybatis默认不是自动提交事务的，所以inser，updat，delete之后需要手动提交事务
        session.commit();

        // 8 . 输出结果
        System.out.println(num);

        //9. 关闭流
        session.close();
    }


}
