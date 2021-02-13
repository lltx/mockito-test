package com.pig4cloud.test.demotest.lesson9;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.jupiter.api.TestFactory;

/**
 *
 * @author lengleng
 * @date 2021/2/13
 */
public class CustomMatcher<T> extends BaseMatcher<T> {

	private Object expectValue;

	public CustomMatcher(T obj) {
		this.expectValue = obj;
	}

	@Override
	public boolean matches(Object actual) {
		return expectValue.equals(actual);
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("自定义测试规则");
	}

	/**
	 * 指定获取实例的方法
	 * @param obj basematcher 获取原参数的值
	 * @return 返回匹配器
	 */
	@TestFactory
	public static BaseMatcher<Object> ge(Object obj) {
		return new CustomMatcher<>(obj);
	}
}
