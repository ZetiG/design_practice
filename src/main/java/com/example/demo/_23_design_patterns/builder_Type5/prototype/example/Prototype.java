package com.example.demo._23_design_patterns.builder_Type5.prototype.example;

import java.io.*;

/**
 * 浅复制，深复制
 * example
 */
public class Prototype implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String string;

    private SerializableObject object;

    public void setString(String tring) {
        this.string = string;
    }
    public String getString() {
        return string;
    }

    public void setObject(SerializableObject object) {
        this.object = object;
    }
    public SerializableObject getObject() {
        return object;
    }

    /**
     * 浅复制
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深复制
     */
    public Object deepClone() throws IOException, ClassNotFoundException {

        /**写入当前对象的二进制流*/
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        new ObjectOutputStream(bos).writeObject(this);

        /**读出二进制流产生的新对象*/
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        return new ObjectInputStream(bis).readObject();
    }

}
