package com.code.javabasic.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 被Serializable接口声明的类的对象的内容都将被序列化，如果现在用户希望自己指定序列化的内容，则可以让一个类实现Externalizable接口
 */
public class Bean02 implements Externalizable {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public Bean02 setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bean02 setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 在此方法中指定要保存的属性信息，对象序列化时调用。
     * @param out
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);//只序列化name
    }

    /**
     * 在此方法中读取被保存的信息，对象反序列化时调用。
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name=(String)in.readObject();
    }
}
