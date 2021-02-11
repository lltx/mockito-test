package com.pig4cloud.test.demotest.lesson7;

import java.util.List;

import com.pig4cloud.test.demotest.vo.DeepVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author lengleng
 * @date 2021/2/11
 */
@ExtendWith(MockitoExtension.class)
public class ArgmatcherTests {

	@Mock
	private List<String> list;

	@Test
	public void testEq() {
		when(list.get(eq(0))).thenReturn("aaa");
		Assertions.assertEquals("aaa", list.get(0));
	}

	@Test
	public void testIsA() {
		when(list.get(isA(Integer.class))).thenReturn("bbb");
		Assertions.assertEquals("bbb", list.get(0));
	}

	@Test
	public void testAny() {
		when(list.get(any(Integer.class))).thenReturn("ccc");
		Assertions.assertEquals("ccc", list.get(0));
	}

	@Test
	public void testAnyXxx() {
		DeepVo vo = mock(DeepVo.class);
		when(vo.foo2(anyString(), anyString())).thenReturn("hello");
		Assertions.assertEquals("hello", vo.foo2("a", "b"));
	}

	@Test
	public void testAnyXxx2() {
		DeepVo vo = mock(DeepVo.class);
		when(vo.foo2(anyString(), eq("固定参数"))).thenReturn("hello");
		Assertions.assertEquals("hello", vo.foo2("a", "固定参数"));
	}

	@Test
	public void testAnyXx3() {
		DeepVo vo = mock(DeepVo.class);
		// 放在最上边
		when(vo.foo2(anyString(), anyString())).thenReturn("anyString");
		// 具体值覆盖
		when(vo.foo2("a", "b")).thenReturn("aaabbb");

		Assertions.assertEquals("anyString",vo.foo2("aaa","bbb"));
		Assertions.assertEquals("aaabbb",vo.foo2("a","b"));
	}

}
