import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itmayiedu.service.UserService;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
		UserService userService = (UserService) app.getBean("userService");
		userService.add();
	}

}
