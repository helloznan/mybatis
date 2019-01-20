package com.zn.demo;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zn.demo.mapper.PrivilegeMapper;
import com.zn.demo.model.Privilege;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PrivilegeTest {
	@Autowired
	private PrivilegeMapper privilegeMapper;
	
	@Test
	public void testFindAll(){
		System.out.println("查询所有权限====");
		List<Privilege> privileges = privilegeMapper.findAll();
		for (Privilege privilege : privileges) {
			System.out.println("name="+privilege.getName());
		}
	}
	
	@Test
	public void testFindAllByRoleId(){
		System.out.println("findAllByRoleId========");
		List<Privilege> ps = privilegeMapper.findAllByRoleId(1L);
		for (Privilege p : ps) {
			System.out.println(p.getId()+":"+p.getName());
		}
	}
	
	
	
}
