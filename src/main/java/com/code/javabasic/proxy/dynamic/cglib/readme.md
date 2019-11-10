当我们只有类没有接口的时候就需要使用另一种动态代理技术 CGLIB 动态代理。首先 CGLIB 动态代理是第三方框架实现的，在 maven 工程中我们需要引入 cglib 的包, 如下:

```
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib</artifactId>
    <version>2.2</version>
</dependency>
```

CGLIB 代理是针对类来实现代理的，原理是对指定的委托类生成一个子类并重写其中业务方法来实现代理。代理类对象是由 Enhancer 类创建的。CGLIB 创建动态代理类的模式是:

查找目标类上的所有非 final 的 public 类型的方法 (final 的不能被重写)

将这些方法的定义转成字节码

将组成的字节码转换成相应的代理的 Class 对象然后通过反射获得代理类的实例对象

实现 MethodInterceptor 接口, 用来处理对代理类上所有方法的请求

