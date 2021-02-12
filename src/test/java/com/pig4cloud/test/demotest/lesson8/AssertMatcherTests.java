package com.pig4cloud.test.demotest.lesson8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 *
 * @author lengleng
 * @date 2021/2/12
 */

@ExtendWith(MockitoExtension.class)
public class AssertMatcherTests {

	@Test
	public void testEq() {
		int i = 10;
		assertThat(i, equalTo(10));
	}

	@Test
	public void testNot() {
		int i = 100;
		assertThat(i, not(10));
		assertThat(i, not(equalTo(10)));
	}

	@Test
	@DisplayName("二者选一  either or")
	public void testEither() {
		int i = 10;
		assertThat(i, either(not(10)).or(not(20)));
	}

	@Test
	@DisplayName("并集  both and")
	public void testBoth() {
		int i = 10;
		assertThat(i, both(equalTo(10)).and(not(20)));
	}

	@Test
	public void testAnyOf() {
		int i = 10;
		assertThat(i, anyOf(equalTo(10), equalTo(20)));
	}

	@Test
	public void testAllOf() {
		int i = 10;
		assertThat(i, allOf(not(equalTo(20)), not(equalTo(30))));
	}
}
