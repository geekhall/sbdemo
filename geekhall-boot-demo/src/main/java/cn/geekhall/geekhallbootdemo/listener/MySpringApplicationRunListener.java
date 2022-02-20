package cn.geekhall.geekhallbootdemo.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * MySpringApplicationRunListener
 *
 * @author yiny
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private SpringApplication application;

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
    }


    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
//        SpringApplicationRunListener.super.starting(bootstrapContext);
        System.out.println("MySpringApplicationRunListener.... starting ....");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
//        SpringApplicationRunListener.super.environmentPrepared(bootstrapContext, environment);
        System.out.println("MySpringApplicationRunListener.... environmentPrepared ....");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
//        SpringApplicationRunListener.super.contextPrepared(context);
        System.out.println("MySpringApplicationRunListener.... contextPrepared ....");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
//        SpringApplicationRunListener.super.contextLoaded(context);
        System.out.println("MySpringApplicationRunListener.... contextLoaded ....");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
//        SpringApplicationRunListener.super.started(context, timeTaken);
        System.out.println("MySpringApplicationRunListener.... started ....");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
//        SpringApplicationRunListener.super.ready(context, timeTaken);
        System.out.println("MySpringApplicationRunListener.... ready ....");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
//        SpringApplicationRunListener.super.failed(context, exception);
        System.out.println("MySpringApplicationRunListener.... failed ....");
    }
}
