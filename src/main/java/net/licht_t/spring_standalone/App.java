package net.licht_t.spring_standalone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

/**
 * Hello world!
 *
 */

@ContextConfiguration(classes = {AppConfig.class})
@SpringBootApplication
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");

		App p = context.getBean(App.class);
		p.start(args);
	}

	@Autowired
	private UserRepository userRepository;

	private void start(String[] args) {
		List<User> users = userRepository.findAll();
		
		for (User user: users){
			System.out.println(user.toString());
		}
		
	}
}
