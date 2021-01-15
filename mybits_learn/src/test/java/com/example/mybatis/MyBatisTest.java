package com.example.mybatis;
import com.example.dao.IUserDao;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 测试
 */
public class MyBatisTest {
    public static void main(String[] params) throws IOException {
        // 1. 读取配置文件
        // 2. 创建sqlSessionFactory工厂
        // SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 使用工厂生产sqlSession对象
        // 4. 使用sqlSession创建Dao代理对象
        // 5. 使用代理对象执行方法
        // 6. 释放资源

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("myBatis-conf.xml"));
        SqlSession sqlSession = factory.openSession();
        IUserDao user = sqlSession.getMapper(IUserDao.class);
        List<User> userList = user.findAll();
        for (User userItem: userList) {
            System.out.println(userItem.getName());
        }
        sqlSession.close();
    }
}
