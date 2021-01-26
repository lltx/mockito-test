package com.pig4cloud.test.demotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lengleng
 * @date 2021/1/26
 */
@RestController
public class DemoController {

	@GetMapping("/get")
	public String get() {
		return "hello";
	}
}
