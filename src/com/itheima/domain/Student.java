package com.itheima.domain;

public class Student extends Person {
    //调用父类的构造方法
    public Student() {
    }

    public Student(int id, String name, String sex, String birthday, int age) {
        super(id, name, sex, birthday, age);
    }

    @Override
    public String getType() {
        return "学生";
    }

    @Override
    public String getWork() {
        return "学习java";
    }
}
