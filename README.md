# SpringBoot2

## 环境
### 开发导入starter场景启动器

`spring-boot-starter-*` 中的 `*` 就表示各种场景，

会自动引入各个场景的常用依赖包，例如：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

* 自定义使用场景不能以 `spring-boot-starter` 开头。

### SpringBoot2中的jar包版本

SpringBoot2中使用父项目定义好的各个常用软件jar包的版本，自动版本仲裁。所以子项目中的依赖可以不写版本号。

可以使用在项目的properties节点中定义自己想要的版本号来替换SpringBoot2中定义的版本。

```xml
	<properties>
		<java.version>1.8</java.version>
		<mysql.version>5.1.43</mysql.version>
	</properties>
```


### 改变扫描包的路径

可以使用如下方式改变项目扫描包的默认路径：

方式1：

```
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.geekhall")
public class MainApplication{
    // ...
}
```

方式2：

使用 `@ComponentScan` 注解修改默认扫描路径， `@ComponentScan`被 `SpringBootApplication` 引用

### 各种配置基本都有默认值

* 默认配置最终都是映射到 `MultipartProperties` 中；
* 配置文件的值最终会绑定到某个配置类上，这个类会在容器中创建对象；

### 按需加载所有的自动配置项

* 引入了哪些场景，哪些场景的自动配置才会开启。
* 

### @Configuration(proxyBeanMethods = true) 
SpringBoot2 中的 `@Configuration` 注解增加了proxyBeanMethods参数：

```
@Configuration(proxyBeanMethods = true)
```

* Full模式 : @Configuration(proxyBeanMethods = true)
* Lite模式 : @Configuration(proxyBeanMethods = false)

最佳实践：

* 配置类组件之间没有依赖关系，使用Lite mode可以加速启动过程，减少判断。
* 配置类组件之间存在依赖关系，使用Full mode，方法会被调用得到容器中的单实例组件。
  
### 条件装配

常用注解：

```
@ConditionalOnBean
@ConditionalOnMissingBean
@ConditionalOnMissingClass
@ConditioinalOnResource
```


### 配置绑定

方式一：在实体bean类上加上 `@ConfigurationProperties`注解，prefix设置为配置文件中的名字，

注意这个bean同时还需要使用 `@Component` 放到Spring容器中才可以。

```
@Component
@ConfigurationProperties(prefix = "mycar")
class Car {
    // ....
}
```

方式二：在配置类加上`@EnableConfigurationProperties(Car.class)` 注解
即可开启Car类的属性绑定，并自动注入到容器中。

### 自动配置

`@SpringBootApplication` 注解相当于使用了：

```
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("cn.geekhall")
```

`@SpringBootConfiguration` 中使用了 `@Configuration` 表示SpringBoot的入口类也是一个配置类。

`@ComponentScan("cn.geekhall")`指定扫描哪个包

`@EnableAutoConfiguration` 注解



### 静态资源

Spring Boot 的默认静态资源目录在类路径（resources）目录下的：
* `/static`
* `/public`
* `/resources`
* `/META-INF/resources`

```
└── resources
    ├── META-INF
    │   └── resources
    │       └── 1.png
    ├── public
    │   └── 2.png
    ├── resources
    │   └── 3.png
    ├── static
    │   └── 4.png
    └── ...
```
源码：

WebProperties.java:

```java
public static class Resources {

private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/META-INF/resources/",
        "classpath:/resources/", "classpath:/static/", "classpath:/public/"};
/**
 * Locations of static resources. Defaults to classpath:[/META-INF/resources/,
 * /resources/, /static/, /public/].
 */
private String[] staticLocations = CLASSPATH_RESOURCE_LOCATIONS;
}
```


使用 `SpringMVC` 的 `ResourceHttpRequestHandler`来处理。

原理：静态映射`/**`

请求进来，先去找 `Controller` 看能不能处理，
不能处理的所有请求又都交给静态资源处理器，
静态资源也找不到则404

* 静态资源默认无前缀，为了方便过滤器统一处理，推荐增加前缀，配置方法：
```yaml
spring:
  mvc:
    static-path-pattern: /res/**
```

当前项目 + static-path-pattern + 静态资源名 = 静态资源文件夹下找

这样原本访问 `http://localhost:8888/4.png` 的资源
URL就变成了 `http://localhost:8888/res/4.png` 


可以使用下面的配置来修改静态资源的默认存储位置：

```yaml
spring:
  web:
    resources:
      static-locations: classpath:/haha/
```

上面这样修改后，所有静态资源就只能放到/resources/haha里面才会生效

注意，下面的写法已经过时：

```yaml
spring:
  resources:
    static-locations: [classpath:/haha/]
```

### 资源加载相关源码解析

主要由 `WebMvcAutoConfigurationAdapter` 类来实现，其构造函数中使用了下面类作为参数：
* WebMvcProperties==spring.mvc(配置文件的相关属性和XXX进行了绑定)
* ResourceProperties==spring.resources(配置文件的相关属性和XXX进行了绑定)
* ListableBeanFactory (bean factory)
* HttpMessageConverters  (找到所有的HttpMessageConverters)
* ResourceHandlerRegistrationCustomizer  （资源处理器的自定义器）
* DispatcherServletPath
* ServletRegistrationBean    (给应用注册Servlet，Filter)

资源加载相关处理主要由 `addResourceHandlers` 方法来处理的

使用下面方式禁用静态资源：
```yaml
spring:
  web:
    resources:
      add-mappings: false
```

原因：

```
public void addResourceHandlers(ResourceHandlerRegistry registry){
    if(!this.resourceProperties.isAddMappings()){
        logger.debug("Default resource handling disabled");
        return;
    }
}
```


### 表单使用REST风格

打开隐藏method配置：

```yaml
spring:
  mvc:
    hiddenmethod:
      filter:
        enabled: true
```
1. 表单提交上来会带上 `_method=PUT`
2. 请求过来被 `HiddenHttpMethodFilter` 拦截
3. 获取 `_method` 的值作为真正的请求方式


### RequestMapping原理

1. 所有请求都会经过 `DispatcherServlet` 类

DispatcherServlet的继承树：

```txt
Object (java.lang)
  GenericServlet (javax.servlet)
    HttpServlet (javax.servlet.http)
      HttpServletBean (org.springframework.web.servlet)
        FrameworkServlet (org.springframework.web.servlet)
          DispatcherServlet (org.springframework.web.servlet)
            TestDispatcherServlet (org.springframework.test.web.servlet)

```



## 数据操作

### 导入依赖

导入启动依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>
```

导入JDBC驱动

spring-data 官方仲裁的默认版本是8.0.28，如果使用5.x版本有两种方法：
1. 可以在项目pom文件中直接指定版本。（maven的就近依赖原则）
2. 使用`properties`重新声明`<mysql.version>`指定版本。（maven的属性的就近优先原则）
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

```
## 配置Druid数据源



## 配置Mybatis
* 导入mybatis官方starter
* 在application.yaml中指定Mapper配置文件的位置，以及指定全局配置文件的信息
* 编写mapper接口。标准`@Mapper`注解
* 编写sql映射文件并绑定mapper接口


## 配置Mybatis-plus

自动配置：

* `MybatisPlusAutoConfiguration`配置类，`MybatisPlusProperties`配置项绑定。
* `sqlSessionFactory`自动配置好的。
* `mapperLocations`自动配置好的，有默认值。classpath:*:/mapper/**/*.xml; 
  任意包的类路径下的所有`mapper`文件夹下任意路径下的所有xml都是sql映射文件。
* 容器中也自动配置了`sqlSessionTemplate`
* `@Mapper`标注的接口也会被自动扫描;建议使用`@MapperScan`注解自动扫描。


## 整合配置Redis

添加依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

* RedisAutoConfiguration: Redis 的自动配置类，使用`"spring.redis.xxx"`进行配置
* 连接工厂是准备好的：LettuceConnectionConfiguration、JedisConnectionConfiguration。
* 容器中自动注入了RedisTemplate<Object, Object> 和SpringRedisTemplate

配置：

```yaml
spring:
  redis:
#    url: redis://127.0.0.1:6379
    host: 127.0.0.1
    port: 6379
    client-type: lettuce  # or jedis
    lettuce:
      pool:
        max-active: 10
        min-idle: 4
        
```

## JUnit5
Spring 2.4 开始将JUnit默认升级到了JUnit5，单元测试更加方便了：
1. 编写测试方法，加上`@Test`注解（注意需要使用JUnit5版本的注解）
2. JUnit类具有Spring的功能，`@Autowired` 自动装配，比如`@Transactional`标注测试方法，测试完成后自动回滚。

### Junit5常用注解
```java
public class Test{
      
  @ParameterizedTest  // 表示方法是参数化测试
  @RepeatedTest       // 表示方法可重复执行
  @DisplayName        // 为测试类或者测试方法展示名称
  @BeforeEach         // 表示在每个单元测试之前执行
  @AfterEach          // 表示在每个单元测试之后执行
  @BeforeAll          // 表示在所有单元测试之前执行
  @AfterAll           // 表示在所有单元测试之后执行
  @Tag                // 表示单元测试类别，类似JUnit4中的@Categories
  @Disabled           // 表示测试类或者测试方法不执行，类似JUnit4中的@Ignore
  @Timeout            // 表示测试方法如果超过了指定时间将会返回错误
  @ExtendWith         // 为测试类或者测试方法提供扩展类引用
  public void test(){
    // something.
  }
}
```


## SpringBoot Actuator 指标监控功能

每个SpringBoot微服务在云上部署以后，我们都需要对其进行监控、追踪、审计、控制等。
SpringBoot就抽取了Actuator场景，获得生产级别的应用监控、审计等功能。

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

```

### 使用

访问  [http://localhost:8888/actuator/**](http://localhost:8888/actuator/**)


### 常用Endpoint

* Health: 监控状况
* Metrics： 运行时指标
* Loggers： 日志

