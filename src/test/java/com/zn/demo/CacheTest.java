/**
 * 测试一二级缓存
 */
package com.zn.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zn.demo.mapper.PrivilegeMapper;
import com.zn.demo.model.Privilege;

/**
 * @author zhengnan
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheTest {
	@Autowired
	private PrivilegeMapper mp;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testCacheLevelOne(){
		Privilege p = mp.findById(1L);
		System.out.println(p.getId()+":"+p.getName());
		p.setName("修改名字");
		Privilege p1=mp.findById(1L);
		System.out.println("重新获取对象，并未输出查询语句，且名称为：『修改名字』。说明直接从1级缓存中获取对象");
		System.out.println("新对象名称为："+p1.getName());
		assertEquals(p, p1);
	}
}
