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


  //修改
  @Test
  public void testUpdate() throws IOException {
    int status=1;
    String companyName="锤子手机";
    String brandName="锤子";
    int ordered =300;
    String description ="超级无敌的手机";
    int id=3;

    Brand brand=new Brand(id,brandName,companyName,ordered,description,status);

    String resource = "mybatis-config.xml";
    InputStream inputStream= Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
    int update = mapper.update(brand);
    sqlSession.commit();

    System.out.println(update);
    sqlSession.close();
  }

  //删除
  @Test
  public void testDeleteById() throws IOException {

    int id=3;

    Brand brand=new Brand();
    brand.setId(id);

    String resource = "mybatis-config.xml";
    InputStream inputStream= Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
    mapper.deleteById(brand);
    sqlSession.commit();
    sqlSession.close();
  }
}
