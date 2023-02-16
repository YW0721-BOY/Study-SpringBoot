package com.HM.mapper;

import com.HM.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    //查询所有
    List<Brand> selectAll();

    Brand selectById(int id);
}
