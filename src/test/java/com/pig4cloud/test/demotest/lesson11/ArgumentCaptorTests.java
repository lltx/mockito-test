package com.pig4cloud.test.demotest.lesson11;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author lengleng
 * @date 2021/2/14
 *
 * 快照测试
 */
@ExtendWith(MockitoExtension.class)
public class ArgumentCaptorTests {

	@Mock
	private List list;

	@Captor
	private ArgumentCaptor captor;

	@Test
	public void testCaptor() {
		list.add("aaa");
		verify(list, times(1)).add(captor.capture());
		System.out.println(captor.getAllValues());
		assertThat(captor.getValue(), equalTo("aaa"));
	}

}
