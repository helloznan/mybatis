/**
 * 
 */
package com.zn.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengnan
 *
 */
@RestController
public class IndexController {
	@RequestMapping("/")
	public String home(){
		return "hello world212";
	}
	
	@RequestMapping("bye")
	public String goodbye(){
		return "bye~1";
	}
	
	@RequestMapping("hello")
	public String hello(){
		return "hello";
	}
}
