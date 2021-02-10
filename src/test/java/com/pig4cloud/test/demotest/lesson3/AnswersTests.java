package com.pig4cloud.test.demotest.lesson3;

import com.pig4cloud.test.demotest.service.DemoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author lengleng
 * @date 2021/2/10
 */
@ExtendWith(MockitoExtension.class)
public class AnswersTests {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private DemoService demoService1;

	@Mock
	private DemoService demoService2;

	@Test
	@DisplayName("测试 deep 情况，此清楚期望能够正常执行")
	public void testDeep() {
		demoService1.demo1().foo();
	}

	@Test
	@DisplayName("测试 默认 情况，此清楚期望能够抛出异常")
	public void testDefault() {
		assertThrows(NullPointerException.class, () -> {
			demoService2.demo1().foo();
		});
	}

}
