package cn.geekhall.sbdemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class SbdemoApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
//		jdbcTemplate.queryForList("select * from t_department");
		Long count = jdbcTemplate.queryForObject("select count(*) from t_department", Long.class);
		System.out.println("Count: " + count);

		System.out.println("数据源类型：" + dataSource.getClass());
	}

}
