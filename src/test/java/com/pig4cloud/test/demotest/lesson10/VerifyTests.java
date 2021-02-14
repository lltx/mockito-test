package com.pig4cloud.test.demotest.lesson10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author lengleng
 * @date 2021/2/13
 */
@ExtendWith(MockitoExtension.class)
public class VerifyTests {
	@Mock
	private DemoDao demoDao;

	@InjectMocks
	private DemoService demoService;

	@Captor
	private ArgumentCaptor captor;

	@Test
	public void testService() {
		DemoService demoService = new DemoService();
		demoService.setDemoDao(demoDao);
		when(demoDao.getUserByName("a")).thenReturn(false, true);
		demoService.service();
		verify(demoDao, times(1)).getUserByName("a");
		verify(demoDao, times(1)).createUser();
		demoService.service();
		verify(demoDao, times(1)).updateUser();
	}

	@Test
	public void testInjectMocks() {
		demoService.service();
		verify(demoDao, times(1)).getUserByName((String) captor.capture());
	}

}
