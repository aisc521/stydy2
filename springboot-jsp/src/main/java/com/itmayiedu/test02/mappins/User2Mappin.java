
package com.itmayiedu.test02.mappins;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface User2Mappin {

	@Insert("insert into users values(null,#{name},#{age});")
	public int addUser(@Param("name") String name, @Param("age") Integer age);

}
