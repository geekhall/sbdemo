package cn.geekhall.sbdemo;

import cn.geekhall.sbdemo.bean.Person;
import cn.geekhall.sbdemo.bean.Pet;
import cn.geekhall.sbdemo.bean.User;
import cn.geekhall.sbdemo.config.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbdemoApplication {

	public static void testContainer(ConfigurableApplicationContext context){


		// 2. 查看容器里面的组件
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}

		// 3. 从容器中获取组件
		Pet jerry = context.getBean("jerryPet", Pet.class);
		System.out.println(jerry);

		// 从容器中获取的组件是单实例的
		Pet jerry01 = context.getBean("jerryPet", Pet.class);
		System.out.println("从容器中获取的组件是单实例的：" + (jerry == jerry01));

		// 配置类本身也是组件
		// cn.geekhall.sbdemo.config.MyConfig$$EnhancerBySpringCGLIB$$5c5172f1@69cac930
		MyConfig configBean = context.getBean(MyConfig.class);
		System.out.println("=====================");
		System.out.println(configBean);
		System.out.println("=====================");

		User user01 = configBean.user02();
		User user02 = configBean.user02();
		System.out.println(user01 == user02); // 当 @Configuration(proxyBeanMethods = true) 时，保持组件单实例。返回true
		System.out.println(user01 == user02); // 当 @Configuration(proxyBeanMethods = false) 时，不保持组件单实例。返回false

		User user021 = context.getBean("user02", User.class); // 这里的getBean方法的第一个参数为Config配置类中的方法名。
		Pet jerryPet = context.getBean("jerryPet", Pet.class);
		System.out.println("===========1==========");
		System.out.println(user021.getPet() == jerryPet);
		System.out.println("=====================");


		System.out.println("=====================");
		// 在配置类前添加 @ImportResource("classpath:beans.xml")的话就返回 true，否则为false。
		boolean haha = context.containsBean("haha");
		boolean hehe = context.containsBean("hehe");
		System.out.println(haha);
		System.out.println(hehe);
		System.out.println("=====================");

		System.out.println("============ Person ============");

		System.out.println("============ Person ============");
	}

	public static void dataSourceTest(ConfigurableApplicationContext context){

	}
	public static void main(String[] args) {
		// 1. 返回我们的IoC容器
		ConfigurableApplicationContext context = SpringApplication.run(SbdemoApplication.class, args);
		dataSourceTest(context);
	}

}
