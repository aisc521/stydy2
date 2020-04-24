
package com.itmayiedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmayiedu.entity.UserEntity;
import com.itmayiedu.repository.UserRepository;

@RestController
public class IndexController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/index")
	public String index(Integer id) {
		UserEntity userEntity = userRepository.findOne(id);
		return userEntity.toString();
	}

}
