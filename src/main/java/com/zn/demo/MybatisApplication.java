package com.zn.demo;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.zn.demo.mapper.UserMapper;
import com.zn.demo.model.User;

@SpringBootApplication
@ComponentScan(basePackages={"com.zn.demo"})
public class MybatisApplication implements CommandLineRunner{
	@Autowired
	private UserMapper userMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	}
}

