package com.cong.project.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		
		return " Hello World ";
		
	}
}
