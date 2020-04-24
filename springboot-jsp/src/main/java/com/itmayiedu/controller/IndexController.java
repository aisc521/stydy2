
package com.itmayiedu.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmayiedu.test01.mappins.User1Mappin;
import com.itmayiedu.test01.service.User01Service;
import com.itmayiedu.test02.service.User02Service;

@RestController
public class IndexController {
	private static Logger log = Logger.getLogger(IndexController.class);
	@Autowired
	private User01Service user01Service;
	@Autowired
	private User02Service user02Service;
	@Autowired
	private User1Mappin user1Mappin;

	@Autowired
	private CacheManager cacheManager;

	@Value("${name}")
	private String name;

	@RequestMapping("/add")
	public String add() {

		user01Service.addUser("test001", 19);
		user02Service.addUser("test002", 19);
		return "success";
	}

	@RequestMapping("/addUser1AndUser2")
	public String addUser1AndUser2() {
		user01Service.addUser1AndUser2();
		return "success";
	}

	@RequestMapping("/log")
	public String log() {
		log.info("test log");
		return "success";
	}

	@ResponseBody
	@RequestMapping("/addUserName")
	public String addUserName(String name) {

		return "success";
	}

	@ResponseBody
	@RequestMapping("/getUserName")
	public String getUserName(int id) {
		return user1Mappin.selectUser(id).toString();

	}

	@ResponseBody
	@RequestMapping("/remo")
	public String remo() {
		cacheManager.getCache("baseCache").clear();
		return "success";
	}

	@ResponseBody
	@RequestMapping("/sedSms")
	public String sedSms() {
		System.out.println("###indexController### 1");
		user01Service.sedSms();
		System.out.println("###indexController### 4");
		return "success";
	}
	@ResponseBody
	@RequestMapping("/getName")
	public String getName() {
		return name;
	}
}
