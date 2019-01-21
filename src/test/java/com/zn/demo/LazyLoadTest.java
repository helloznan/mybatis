/**
 * 
 */
package com.zn.demo;

import java.util.List;

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
public class LazyLoadTest {
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 直接嵌入resultMap的方式并不是懒加载属性查询。
	 * 即使配置了fatchType=lazy
	 */
	@Test
	public void testNotLazyLoad(){
		System.out.println("notLazyLoad:开始查询角色");
		Role r= roleMapper.findById(1L);
		System.out.println("查询完毕，输出角色基本信息==");
		System.out.println(r.getId()+":"+r.getName());
		System.out.println("角色基本信息输出完毕，接下来输出权限信息，发现『不是』懒加载");
		List<Privilege> ps = r.getPrivileges();
		for (Privilege p : ps) {
			System.out.println(p.getId()+":"+p.getName());
		}
	}
	
	@Test
	public void testLazyLoad(){
		System.out.println("lazyLoad:开始查询角色");
		Role r= roleMapper.findByIdLazyLoadPrivilege(1L);
		System.out.println("查询完毕，输出角色基本信息==");
		System.out.println(r.getId()+":"+r.getName());
		System.out.println("角色基本信息输出完毕，接下来输出权限信息，发现『是』懒加载");
		List<Privilege> ps = r.getPrivileges();
		for (Privilege p : ps) {
			System.out.println(p.getId()+":"+p.getName());
		}
	}
}
