package com.pig4cloud.test.demotest.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.pig4cloud.test.demotest.service.DemoService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;

/**
 *
 * @author lengleng
 * @date 2021/1/26
 */
@WebMvcTest(Demo2Controller.class)
class Demo2ControllerTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private DemoService demoService;


	@Test
	@SneakyThrows
	void get2() {

		// 生产数据
		when(demoService.demo()).thenReturn("success");

		// 执行测试
		mvc.perform(get("/get2")).andExpect(content().string("success"));
	}
}
