
package com.itmayiedu.test01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itmayiedu.test01.mappins.User1Mappin;
import com.itmayiedu.test02.mappins.User2Mappin;

@Service
public class User01Service {
	@Autowired
	private User1Mappin user1Mappin;
	@Autowired
	private User2Mappin user2Mappin;

	public int addUser(String name, Integer age) {
		return user1Mappin.addUser(name, age);
	}

	@Transactional
	public int addUser1AndUser2() {
		user2Mappin.addUser("test002", 19);
		int i = 1 / 0;
		System.out.println("数据库01插入完毕..");
		user1Mappin.addUser("test001", 19);
		;
		return 0;
	}

	@Async
	public void sedSms() {
		System.out.println("##sedSms##开始执行..  2");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("i:" + i);
		}
		System.out.println("##sedSms##结束执行..  3");
	}

	class ThreadDemo extends Thread {
		@Override
		public void run() {

			System.out.println("##sedSms##开始执行..  2");
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("i:" + i);
			}
			System.out.println("##sedSms##结束执行..  3");

		}
	}

}
