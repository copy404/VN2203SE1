package exception;

public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException{
        if (age<0||age>100){
            this.age = age;
//            throw new RuntimeException("年龄不合法");
            throw new IllegalAgeException("年龄超过范围："+age);
        }

    }
}
