package com.zn.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zn.demo.mapper.UserMapper;
import com.zn.demo.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageHelperTest {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 1.配置maven jar依赖
	 * 2.mybatis-config.xml中配置plugin
	 * 3.使用
	 */
	@Test
	public void testPageHelper(){
		Page<User> page = PageHelper.startPage(2, 2, true);
		List<User> lst = userMapper.findAll();
		System.out.println("total="+page.getTotal());
		System.out.println("pages="+page.getPages());
		System.out.println("result Size="+lst.size());
		for (User user : lst) {
			System.out.println(user.getId()+":"+user.getName());
		}
	}
}
