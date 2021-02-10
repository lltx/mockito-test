package com.pig4cloud.test.demotest.lesson3;

import com.pig4cloud.test.demotest.service.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author lengleng
 * @date 2021/2/10
 */
public class MockAnnotationsTests {

	@BeforeEach
	public void test(){
		MockitoAnnotations.openMocks(this);
	}

	@Mock
	private DemoService demoService;

	@Test
	public void testAnnotions(){
		demoService.demo();
	}
}
