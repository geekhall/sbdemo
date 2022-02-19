package cn.geekhall.sbdemo.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * MyComHealthIndicator
 *
 * @author yiny
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {

    /**
     * 真实的检查方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String, Object> map = new HashMap<>();
        // mysql check
        if ( false ) {
//            builder.up();
            // or
            builder.status(Status.UP);
            map.put("count", 1);
            map.put("ms", 100);

        } else {
//            builder.down();
            builder.status(Status.OUT_OF_SERVICE);
            map.put("err", "连接超时");
            map.put("ms", 3000);
        }
        builder.withDetail("code", 100)
                .withDetails(map);
    }
}
