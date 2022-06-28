package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author 老安
 * @data 2022/6/16 19:50
 * 使用当前类测试对象流的序列化和反序列化操作
 * 对象序列化:将一个java对象按照其结构转换为一组字节的过程
 * 序列化一个对象时,底层会为当前的Person生成一个版本号serialVersionUID
 * 在读取对象,会先比对被序列化对象的版本号,和还原的对象类型的版本是否一致,
 * 不一致,会抛出异常
 * 如何解决?
 * 开启兼容模式:自己指定一个版本号
 *  static final long serialVersionUID = 1L;
 */
public class Person implements Serializable {
    //控制死当前类的版本号是1,将来如何改当前类的内容,版本号都不会发生改变
    static final long serialVersionUID = 1L;
    private String name;//姓名
    //transient 当一个属性被transient修饰时,序列化时,就会忽略这个属性的值
    //transient 转瞬即逝的,短暂的
    private transient int age;//年龄
    private String gender;//性别
    private transient String[] otherInfo;//其他信息
    //private int salary;//薪资
    //全参构造
    //alt+insert/右键 Generate-->Constructor crtl+A全选属性
    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }
    //get和set方法
    //alt+insert/右键 Generate-->getter and setter crtl+A全选属性
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String[] getOtherInfo() {
        return otherInfo;
    }
    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }
    //toString
    //alt+insert/右键 Generate-->toString()
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}
