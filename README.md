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

```java
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

```java
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

```java
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

```java
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