# micro-service-governing
服务治理

#### 1.test-eureka-server
用于拦截2的注册请求，拦截的方法使用aop
com.netflix.eureka.resources是重写的源码，在ApplicationsResource类中加入了自定义注解selfFilter，但总是报错，非filter错误，而是源码包里边不能注入bean之类的

#### 2. test-micro-service01
微服务，用于注册

#### 3. test-service-gocerning
用于拦截后处理，暂时没有结合起来
