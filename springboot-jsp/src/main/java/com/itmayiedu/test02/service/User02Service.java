
package com.itmayiedu.test02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmayiedu.test02.mappins.User2Mappin;


@Service
public class User02Service {
    @Autowired
	private User2Mappin user2Mappin;
	
	public int addUser(String name,Integer age){
		return user2Mappin.addUser(name, age);
	}

}
