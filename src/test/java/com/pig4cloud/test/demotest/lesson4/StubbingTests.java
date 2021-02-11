package com.pig4cloud.test.demotest.lesson4;

import java.util.List;

import com.pig4cloud.test.demotest.service.DemoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
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
	public void testDoThrow() {
		doThrow(RuntimeException.class).when(list).clear();
		assertThrows(RuntimeException.class, () -> list.clear());
	}

	@Test
	@DisplayName("迭代器的模拟,每次获取的值都不一样")
	public void testDoIterator() {
		when(list.size()).thenReturn(1, 2, 3, 4);
		assertEquals(1, list.size());
		assertEquals(2, list.size());
		assertEquals(3, list.size());
		assertEquals(4, list.size());
	}

	@Test
	@DisplayName("迭代器的模拟，anyInt")
	public void testDoIteratorAnyInt() {
		when(list.get(anyInt())).thenReturn("a", "b", "c", "d");
		assertEquals("a", list.get(1));
		assertEquals("b", list.get(2));
		assertEquals("c", list.get(3));
		assertEquals("d", list.get(4));
	}

	@Test
	@DisplayName("迭代器的业务逻辑模拟 使用 thenAnswer invocation")
	public void testDoAnswer() {
		when(list.get(anyInt())).thenAnswer(invocation -> {
			Integer argument = invocation.getArgument(0, Integer.class);
			return argument.toString();
		});

		assertEquals("1", list.get(1));
		assertEquals("2", list.get(2));
		assertEquals("3", list.get(3));
		assertEquals("4", list.get(4));
	}

	@Test
	@DisplayName("call real method")
	public void testCallRealMethod() {
		DemoServiceImpl service = Mockito.mock(DemoServiceImpl.class);
		when(service.demo()).thenCallRealMethod();
		System.out.println(service.demo());
		System.out.println(service.demo1());
	}

}
