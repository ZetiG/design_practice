package com.example.demo.builder_Type5.prototype;

/**
 * 原型模式
 * 原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，
 * 该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 *
 * 优点：
 * 1、如果创建新的对象比较复杂时，可以利用原型模式简化对象的创建过程，同时也能够提高效率。
 * 2、可以使用深克隆保持对象的状态。
 * 3、原型模式提供了简化的创建结构。
 *
 * 缺点：
 * 1、在实现深克隆的时候可能需要比较复杂的代码。
 * 2、需要为每一个类配备一个克隆方法，而且这个克隆方法需要对类的功能进行通盘考虑，
 *    这对全新的类来说不是很难，但对已有的类进行改造时，不一定是件容易的事，必须修改其源代码，违背了“开闭原则”。
 *
 * 一个原型类，只需要实现Cloneable接口，覆写clone方法，此处clone方法可以改成任意的名称，因为Cloneable接口是个空接口，
 * 你可以任意定义实现类的方法名，如cloneA或者cloneB，因为此处的重点是super.clone()这句话，super.clone()调用的是Object的clone()方法，而在Object类中，clone()是native的
 *
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 *
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 * 详见-> example
 */
public class Prototype implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }
}
