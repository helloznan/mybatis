package com.zn.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zn.demo.model.Role;

@Mapper
public interface RoleMapper {
	Role findById(Long id);
	
	Role findById2(Long id);
}
