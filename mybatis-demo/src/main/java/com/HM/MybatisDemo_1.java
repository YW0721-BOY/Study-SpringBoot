package com.HM;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * Mybatis 快速入门
 */
public class MybatisDemo_1 {
    public static void main(String[] args) throws IOException {

        String resource ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<Object> account = sqlSession.selectList("demo.selectAll");
        System.out.println(account);

        sqlSession.close();

    }
}
