package com.zn.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zn.demo.model.School;

@Mapper
public interface SchoolMapper {
	public List<School> findAll();
}
