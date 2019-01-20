/**
 * 
 */
package com.zn.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zn.demo.mapper.RoleMapper;
import com.zn.demo.model.Privilege;
import com.zn.demo.model.Role;

/**
 * @author zhengnan
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleTest {
	@Autowired
	private RoleMapper roleMapper;
	
	@Test
	public void testRoleFindById(){
		Role r = roleMapper.findById(1L);
		System.out.println("privilegeBaseMap所有字段都映射的情况下。");
		System.out.println("name="+r.getName());
		for (Privilege p : r.getPrivileges()) {
			System.out.println("p==="+p.getId()+":"+p.getName());
		}
	}
	
	@Test
	public void testRoleFindById2(){
		Role r = roleMapper.findById2(1L);
		System.out.println("省略privilegeBaseMap基础字段都映射的情况下，会造成name无法映射，所以习惯上要把所有基础字段都映射");
		System.out.println("name="+r.getName());
		for (Privilege p : r.getPrivileges()) {
			System.out.println("p==="+p.getId()+":"+p.getName());
		}
	}
}
