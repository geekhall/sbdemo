package cn.geekhall.geekhallbootdemo.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MyApplicationRunner
 * 应用启动时一次性执行某些事情的时候可以使用这个。
 * @author yiny
 */
@Order(1)
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner....run....");
    }
}
