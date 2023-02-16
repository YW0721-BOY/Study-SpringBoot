package com.HM;

import com.HM.mapper.AccountMapper;
import com.HM.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * Mybatis 代理开发
 */
public class MybatisDemo_2 {

    public static void main(String[] args) throws IOException {

        String resource ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<Object> account = sqlSession.selectList("demo.selectAll");

        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accounts = accountMapper.selectAll();
        System.out.println(accounts);

        sqlSession.close();

    }
}
