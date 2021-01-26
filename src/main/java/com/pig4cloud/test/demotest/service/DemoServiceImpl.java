package com.pig4cloud.test.demotest.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author lengleng
 * @date 2021/1/26
 */
@Service
public class DemoServiceImpl implements DemoService {
	@Override
	public String demo() {
		return "success";
	}
}
