package com.pig4cloud.test.demotest.lesson10;

import lombok.Setter;

/**
 *
 * @author lengleng
 * @date 2021/2/13
 */
public class DemoService {

	@Setter
	private DemoDao demoDao ;

	public void service() {
		boolean exsit = demoDao.getUserByName("a");

		if (exsit) {
			demoDao.updateUser();
		}
		else {
			demoDao.createUser();
		}
	}
}
