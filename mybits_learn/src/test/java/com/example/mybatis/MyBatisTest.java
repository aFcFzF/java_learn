package com.example.mybatis;

import jdk.internal.module.Resources;
import java.io.InputStream;

/**
 * 测试
 */
public class MyBatisTest {
    public static void main(String[] params) {
        // 1. 读取配置文件
        // 2. 创建sqlSessionFactory工厂
        // SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 使用工厂生产sqlSession对象
        // 4. 使用sqlSession创建Dao代理对象
        // 5. 使用代理对象执行方法
        // 6. 释放资源


        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("myBatis-conf.xmll"));
        SqlSession sqlSession = factory.openSession();
        User user = (User) sqlSession.selectOne("org.javaboy.mymapper.getUserById", 3);
        System.out.println(user);
        sqlSession.close();
    }
}
