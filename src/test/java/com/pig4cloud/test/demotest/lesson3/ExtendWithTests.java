package com.pig4cloud.test.demotest.lesson3;

import com.pig4cloud.test.demotest.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author lengleng
 * @date 2021/2/10
 */
@ExtendWith(MockitoExtension.class)
public class ExtendWithTests {

	@Mock
	private DemoService demoService;

	@Test
	public void testExtendWith() {
		System.out.println(demoService.demo());
	}
}
