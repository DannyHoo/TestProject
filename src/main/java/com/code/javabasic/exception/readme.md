

![](java%20exception.png)

Java 提供了两类主要的异常 ：runtime exception 和 checked exception 

checked 异常也就是我们经常遇到的 IO 异常，以及 SQL 异常都是这种异常。对于这种异常， JAVA 编译器强制要求我们必需对出现的这些异常进行 catch 。所以，面对这种异常不管我们是否愿意，只能自己去写一大堆 catch 块去处理可能的异常。

runtime exception ，也称运行时异常，我们可以不处理。当出现这样的异常时，总是由虚拟机 接管。比如：我们从来没有人去处理过 NullPointerException 异常，它就是运行时异常，并且这种异常还是最常见的异常之一。