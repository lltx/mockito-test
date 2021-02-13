package com.pig4cloud.test.demotest.lesson9;

import org.junit.jupiter.api.Test;


import static com.pig4cloud.test.demotest.lesson9.CustomMatcher.ge;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author lengleng
 * @date 2021/2/13
 */
public class CustomMatcherTests {

	@Test
	public void testCustomMatcher(){
		assertThat(1,ge(1));
	}
}
