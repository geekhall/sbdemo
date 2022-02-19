package cn.geekhall.sbdemo.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * AppInfoContributor
 *
 * @author yiny
 */
@Component
public class AppInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg", "你好")
                .withDetail("hello", "geekhall")
                .withDetails(Collections.singletonMap("world", "aaaaaa"));
    }
}
