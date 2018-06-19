# springboot-security-demo4 [![Build Status](https://travis-ci.org/origoni/springboot-security-demo4.svg?branch=master)](https://travis-ci.org/origoni/springboot-security-demo4)

springboot-security-demo4

- Spring Boot 2 & Spring Security 5
- User Join (with @Valid)
- User Login (with RememberMe)
- Use simple(single) Role
- Method level security (@PreAuthorize)
- XSS & CSRF TEST

NEXT
- User authentication management
  
## Reference

- http://spring.io/guides/gs/securing-web/
- http://spring.io/guides/topicals/spring-security-architecture/
- https://docs.spring.io/spring-security/site/docs/current/guides/html5/helloworld-boot.html
- https://spring.io/blog/2013/07/04/spring-security-java-config-preview-method-security/
- https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
- https://docs.spring.io/spring-security/site/docs/current/reference/html/remember-me.html#remember-me-persistent-token

## Quick Start
Pre Installed
- JDK 1.8 (or Java 10)
- Maven 3.5
- Git

Run
```
git clone https://github.com/origoni/springboot-security-demo4.git
cd springboot-security-demo4
mvn spring-boot:run
```

## Test

http://localhost:9094

- id = admin
- pw = adminPassword

http://localhost:9094/h2-console

### Tested
- STS(Eclipse) 3.8.4
- IntelliJ IDEA 2018.1.5

```
//@formatter:off & //@formatter:on
eclipse : Preferences -> Java -> Code style -> Formatter -> Edit... (or New...) > Off/On Tags
intellij : Preferences -> Editor -> Code Style > Formatter Control > Enable formatter markers in comments
```


## Dependency

### Spring Boot 2.0.3.RELEASE
- spring-boot-starter-web
- spring-boot-starter-security

#### Environment
- Java version: 8 Update 172 or 10.0.1
- Spring Boot version: 2.0.3
- Maven version: 3.5.2
- Lombok version: 1.16.22
- Default Encoding: UTF-8
- Default SCM : git
