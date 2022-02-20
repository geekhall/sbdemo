package cn.geekhall.geekhallbootdemo.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MyCommandLineRunner
 *
 * @author yiny
 */
@Order(2)
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner.... run ....");
    }
}
