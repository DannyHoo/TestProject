
在 Java 的动态代理中, 主要涉及 2 个类,java.lang.reflect.Proxy和java.lang.reflect.InvocationHandler
我们需要一个实现 InvocationHandler 接口的中间类, 这个接口只有一个方法 invoke 方法, 方法的每个参数的注释如下代码。

我们对处理类中的所有方法的调用都会变成对 invoke 方法的调用，这样我们可以在 invoke 方法中添加统一的处理逻辑（也可以根据 method 参数判断是哪个方法）。中间类 (实现了 InvocationHandler 的类) 有一个委托类对象引用, 在 Invoke 方法中调用了委托类对象的相应方法，通过这种聚合的方式持有委托类对象引用，把外部对 invoke 的调用最终都转为对委托类对象的调用。