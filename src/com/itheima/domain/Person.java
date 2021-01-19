package com.itheima.domain;
//含有抽象方法一定是个抽象类
public  abstract class Person {
    //成员变量
    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 年龄
     */
    private int age;

    //构造方法

    public Person() {
    }

    public Person(int id, String name, String sex, String birthday, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.age = age;
    }

    //set和get方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //成员方法

    /**
     * 返回类型
     * @return
     */
    public abstract String getType();

    /**
     * 返回工作
     * @return
     */
    public abstract  String getWork();

    /**
     * 按照指定格式返回数据信息
     * @return
     */
    public String show (){
        return "我是一名"+getType()+",我的工作是"+getWork();
    }
}
