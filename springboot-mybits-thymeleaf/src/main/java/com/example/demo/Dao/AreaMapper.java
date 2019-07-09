package com.example.demo.Dao;

import com.example.demo.Entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    //这个方式我自己加的
    List<Area> findAll();

    @Select(value="select * from tb_area where area_id=#{id}")
    Area findOne(Integer id);

}