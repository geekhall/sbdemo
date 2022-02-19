package cn.geekhall.adminserverdemo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAdminServer // 启动Admin监控功能
@SpringBootApplication
public class AdminServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerDemoApplication.class, args);
    }

}
