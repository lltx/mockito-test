package com.pig4cloud.test.demotest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


/**
 *
 * @author lengleng
 * @date 2021/1/26
 */
@WebMvcTest(DemoController.class)
class DemoControllerTests {

	@Autowired
	private MockMvc mvc;

	@Test
	@SneakyThrows
	void testGet() {
		mvc.perform(get("/get")).andExpect(content().string("hello"));
	}
}
