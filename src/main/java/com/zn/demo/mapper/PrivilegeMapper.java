package com.zn.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zn.demo.model.Privilege;

@Mapper
public interface PrivilegeMapper {
	List<Privilege> findAllByRoleId(Long roleId);
	
	List<Privilege> findAll();
	
	Privilege findById(@Param("id") Long id);
}
