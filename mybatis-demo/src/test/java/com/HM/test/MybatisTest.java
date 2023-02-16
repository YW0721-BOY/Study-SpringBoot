package com.HM.test;

import com.HM.mapper.BrandMapper;
import com.HM.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
  @Test
    public void testSelectAll() throws IOException {
      //1. 获取SqlSessionFactory
      String resource = "mybatis-config.xml";
      InputStream inputStream= Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      SqlSession sqlSession = sqlSessionFactory.openSession();
      BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
      List<Brand> brandList = mapper.selectAll();
      System.out.println(brandList);
      sqlSession.close();
  }

  @Test
  public void testSelectById() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream= Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
    Brand brand = mapper.selectById(1);
    System.out.println(brand.toString());
    sqlSession.close();
  }
}
