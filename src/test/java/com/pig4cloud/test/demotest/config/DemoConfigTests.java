package com.pig4cloud.test.demotest.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lengleng
 * @date 2021/1/26
 */
class DemoConfigTests {

	private AnnotationConfigApplicationContext context;

	@BeforeEach
	public void setup(){
		this.context = new AnnotationConfigApplicationContext();
		this.context.register(DemoConfig.class);
		this.context.refresh();
	}


	@Test
	public void testGetBean(){
		DemoConfig bean = context.getBean(DemoConfig.class);

		assertNotNull(bean);
	}
}
