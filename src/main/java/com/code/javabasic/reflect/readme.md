创建一个类有几种方法?

（1）使用new关键字 → 调用了构造函数

（2）使用Class类的newInstance方法 → 调用了构造函数
```
Employee emp2 = (Employee)Class.forName("org.programming.mitra.exercises.Employee").newInstance();
```

（3）使用Constructor类的newInstance方法 → 调用了构造函数
```
Constructor<Employee> constructor = Employee.class.getConstructor(); 
Employee emp3 = constructor.newInstance();
```


（4）使用clone方法 → 没有调用构造函数

（5）使用反序列化→ 没有调用构造函数
```
ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj")); Employee emp5 = (Employee) in.readObject();
```