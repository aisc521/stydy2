
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
	 * @methodDesc: ��������:(����û�)
	 * @author: ��ʤ��
	 * @param:
	 * @createTime:2017��9��12�� ����9:23:44
	 * @returnType: void
	 * @copyright:�Ϻ�ÿ�ؽ����Ƽ����޹�˾
	 * @QQ:644064779
	 */
	public void addUser(String name,Integer age) {
		String sql="INSERT INTO users(NAME, age) VALUES(?, ?);";
		jdbcTemplate.update(sql, name,age);
		System.out.println("������ݳɹ�!.......");
	}

}
