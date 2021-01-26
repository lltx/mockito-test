package com.pig4cloud.test.demotest.controller;

import com.pig4cloud.test.demotest.service.DemoService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lengleng
 * @date 2021/1/26
 */
@RestController
@RequiredArgsConstructor
public class Demo2Controller {

	private final DemoService demoService;


	@GetMapping("/get2")
	public String get2(){
		return demoService.demo();
	}

}
