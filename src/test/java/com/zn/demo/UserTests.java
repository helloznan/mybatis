package com.zn.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zn.demo.mapper.UserMapper;
import com.zn.demo.model.Privilege;
import com.zn.demo.model.Role;
import com.zn.demo.model.School;
import com.zn.demo.model.User;

/**
 * 单表增删改查
 * @author zhengnan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		User user = userMapper.findById(1L);
		System.out.println(user.getName()+":"+user.getPwd());
	}
	
	@Test
	public void testFindInfo(){
		User u = userMapper.findInfo(1L);
		System.out.println("查询用户下到所有角色+权限");
		System.out.println(u.getId()+":"+u.getName());
		System.out.println("开始查询：lazy的school数据=");
		School s=u.getSchool();
		System.out.println("school="+s.getId()+":"+s.getName());
		System.out.println("查询结束：lazy的school数据=");
		List<Role> roles =  u.getRoles();
		for (Role role : roles) {
			System.out.println("role==="+role.getId()+":"+role.getName());
			List<Privilege> ps = role.getPrivileges();
			for (Privilege p : ps) {
				System.out.println("privilege--"+p.getId()+":"+p.getName());
			}
		}
	}
	
	@Test
	public void testFindUserSchool(){
		User u = userMapper.findUserSchool(1L);
		System.out.println("查询用户所在学校，方式1===");
		School s= u.getSchool();
		System.out.println(s.getId()+":"+s.getName());
	}
	
	@Test
	public void testFindUserSchool2(){
		User u = userMapper.findUserSchool(1L);
		System.out.println("查询用户所在学校，方式2===");
		School s= u.getSchool();
		System.out.println(s.getId()+":"+s.getName());
	}
	
	@Test
	public void testFindUserSchool3(){
		User u = userMapper.findUserSchool(1L);
		System.out.println("查询用户所在学校，方式3===");
		School s= u.getSchool();
		System.out.println(s.getId()+":"+s.getName());
	}
	
	@Test
	public void testFindUserSchool4(){
		System.out.println("查询用户所在学校，方式4===并未查询学校数据，输出查询User数据的sql语句=");
		User u = userMapper.findUserSchool(1L);
		System.out.println(u.getId()+":"+u.getName());
		System.out.println("开始获取学校数据，再执行一次sql，输出sql语句=");
		School s= u.getSchool();
		System.out.println(s.getId()+":"+s.getName());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateUser(){
		User u = userMapper.findById(1L);
		System.out.println("修改前："+u.getName());
		String n="jim_"+System.currentTimeMillis();
		u.setName(n);
		userMapper.update(u);
		
		User u2=userMapper.findOne(u);
		System.out.println("根据"+n+"查找到点用户ID依旧=1L:"+u2.getId());
		assertEquals(1L, u2.getId().longValue());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave(){
		User u=new User();
		u.setName("hanmeimei");
		u.setPwd("123456");
		
		userMapper.save(u);
		System.out.println("新增用户id="+u.getId());
		User newOne = userMapper.findOne(u);
		System.out.println("新增用户名称："+newOne.getName());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave2(){
		User u=new User();
		u.setName("city");
		u.setPwd("123456");
		
		userMapper.save2(u);
		System.out.println("save2的id="+u.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDel(){
		userMapper.delById(1L);
	}
}

