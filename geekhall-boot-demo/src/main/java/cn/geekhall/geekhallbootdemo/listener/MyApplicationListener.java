package cn.geekhall.geekhallbootdemo.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * MyApplicationListener
 *
 * @author yiny
 */
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener.... onApplicationEvent ....");
    }
}
