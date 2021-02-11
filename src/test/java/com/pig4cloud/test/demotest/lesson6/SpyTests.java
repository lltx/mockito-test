package com.pig4cloud.test.demotest.lesson6;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author lengleng
 * @date 2021/2/11
 */
@ExtendWith(MockitoExtension.class)
public class SpyTests {

	@Mock
	List<String> listMock = new ArrayList<>()  ;

	@Spy
	List<String> listSpy = new ArrayList<>();

	@Test
	@DisplayName("mock 单元测试 会覆盖原有的实际值,把原值设置为NULL")
	public void testMock() {
		listMock.add("a");
		listMock.add("b");
		Assertions.assertNull(listMock.get(0));
	}

	@Test
	@DisplayName("spy 单元测试 会有限原有的实际值")
	public void testSpy() {
		listSpy.add("a");
		listSpy.add("b");
		Assertions.assertEquals("a", listSpy.get(0));
	}
}
