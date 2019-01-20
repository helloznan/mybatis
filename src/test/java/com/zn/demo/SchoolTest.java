package com.zn.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zn.demo.mapper.SchoolMapper;
import com.zn.demo.model.School;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SchoolTest {
	@Autowired
	private SchoolMapper mapper;
	
	@Test
	public void testFindAll(){
		List<School> ss = mapper.findAll();
		for (School s : ss) {
			System.out.println(s.getId()+":"+s.getName());
		}
	}
}
