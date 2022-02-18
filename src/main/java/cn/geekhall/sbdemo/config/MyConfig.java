package cn.geekhall.sbdemo.config;

import cn.geekhall.sbdemo.bean.Car;
import cn.geekhall.sbdemo.bean.Pet;
import cn.geekhall.sbdemo.bean.TestUser;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * MyConfig
 * Full模式 : @Configuration(proxyBeanMethods = true)
 * Lite模式 : @Configuration(proxyBeanMethods = false)
 *
 * 最佳实践：
 *   - 配置类组件之间没有依赖关系，使用Lite mode可以加速启动过程，减少判断。
 *   - 配置类组件之间存在依赖关系，使用Full mode，方法会被调用得到容器中的单实例组件。
 *
 * @author yiny
 */
@Configuration(proxyBeanMethods = true)  // 告诉SpringBoot这是一个配置类 == 配置文件
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * 给容器中添加组件，
     * 以方法名作为组件的id
     * 返回类型就是组件类型
     * 返回的值就是组件在容器中的实例。
     *
     * 外部无论对配置类中的这个组件注册方法调用多少次，获取的都是之前注册容器中的单实例对象。
     *
     * @return
     */
    @Bean
    public TestUser user02() {
        TestUser zhangsan = new TestUser("user02", 20);
        zhangsan.setPet(jerryPet());
        return zhangsan;
    }

    @Bean
    public Pet jerryPet() {
        return new Pet("Jerry", 11.11);
    }
}
