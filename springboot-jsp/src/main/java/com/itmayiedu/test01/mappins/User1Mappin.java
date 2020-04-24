
package com.itmayiedu.test01.mappins;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.itmayiedu.entity.UserEntity;
import com.itmayiedu.test01.entity.User1Entity;

@CacheConfig(cacheNames = "baseCache")
public interface User1Mappin {

	@Insert("insert into users values(null,#{name},#{age});")
	public int addUser(@Param("name") String name, @Param("age") Integer age);

	@Select(" select * from users where id = #{id} ")
	@Cacheable
	public User1Entity selectUser(@Param("id") Integer id);
}
