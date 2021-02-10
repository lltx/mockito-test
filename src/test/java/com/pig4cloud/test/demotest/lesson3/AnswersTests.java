package com.pig4cloud.test.demotest.lesson3;

import com.pig4cloud.test.demotest.service.DemoService;
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
	public void testDeep() {
		demoService1.demo1().foo();
	}

	@Test
	public void testDefault() {
		assertThrows(NullPointerException.class, () -> {
			demoService2.demo1().foo();
		});
	}

}
