
package com.itmayiedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @methodDesc: 功能描述:(添加用户)
	 * @author: 余胜军
	 * @param:
	 * @createTime:2017年9月12日 下午9:23:44
	 * @returnType: void
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	public void addUser(String name,Integer age) {
		String sql="INSERT INTO users(NAME, age) VALUES(?, ?);";
		jdbcTemplate.update(sql, name,age);
		System.out.println("添加数据成功!.......");
	}

}
