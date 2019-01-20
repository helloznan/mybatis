package com.zn.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zn.demo.model.User;

@Mapper
public interface UserMapper {
	List<User> findAll();
	
	User findById(@Param("id")Long id);
	
	//推荐在参数前加@param，养成习惯
	User findOne(@Param("user")User user);
	
	User findInfo(Long id);
	
	User findUserSchool(Long id);
	User findUserSchool2(Long id);
	User findUserSchool3(Long id);
	User findUserSchool4(Long id);
	
	int update(User user);
	
	int save(User user);
	
	int save2(User user);
	
	int delById(Long id);
	
}
