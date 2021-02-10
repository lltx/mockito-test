package com.pig4cloud.test.demotest.lesson4;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author lengleng
 * @date 2021/2/10
 */
@ExtendWith(MockitoExtension.class)
public class StubbingTests {

	@Mock
	private List<String> list;


	@Test
	@DisplayName("testGetListFirstEle 测试 当获取list 第一个元素时 返回 first")
	public void testGetListFirstEle() {
		when(list.get(0)).thenReturn("first");
		Assertions.assertEquals("first", list.get(0));
	}

	@Test
	@DisplayName("stub 不做任何事情返回 doNothing 校验执行了几次")
	public void testDoNothing() {
		doNothing().when(list).clear();
		list.clear();
		verify(list, times(1)).clear();
	}

	@Test
	@DisplayName("stub 执行报错")
	public void test() {
		doThrow(RuntimeException.class).when(list).clear();
		assertThrows(RuntimeException.class,()-> list.clear());
	}

}
