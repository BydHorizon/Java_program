package com.itheima.Utils;

import com.itheima.domain.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    //创建一个id变量 static修饰延长变量生存周期
    public static int id;// 100个对象， 程序停止在启动
    {
        id=0;//以后可以读取文件中记录的id值，可以赋为初值
    }
    //根据生日计算年龄
    public static int birthdayTOAge(String birthday){
        //思路
        //1.获取当前对象的日期
        Date nowDate = new Date();
        //2.创建日期格式化对象，指定日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //3.调用parseInt()解析方法对字符串生日进行解析成Date类型
        Date birthdayDate = null;
        try {
             birthdayDate = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //4 比较出生日期是否在当前日期之后，如果是，返回-1；
         if (birthdayDate.after(nowDate)){
             return -1;
         }
        //5.获取当前时间的日历对象
        Calendar cal =  Calendar.getInstance();
        //6.获取当前时间的月，日，年
        int nowYear = cal.get(Calendar.YEAR);
        int nowMonth = cal.get(Calendar.MONTH);
        int nowDay = cal.get(Calendar.DAY_OF_MONTH);
        //7.通过日历对象调用setTime(Date data)方法，设置日历对象的时间为出生日期的时间
        cal.setTime(birthdayDate);
        //8.通过设置之后的日历对象获取生日的年，月，日
        int birthdayYear = cal.get(Calendar.YEAR);
        int birthdayMonth = cal.get(Calendar.MONTH);
        int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
        //9.使用当前时间的年-生日时间的年得到一个初步的年龄
        int age = nowYear-birthdayYear;
        //10.如果当前时间的月小于生日时间的月，那么初步年龄-1
        if (birthdayMonth<nowMonth){
            age--;
        }
        //11.如果当前时间的月等于生日时间的月，但当前时间的日小于生日时间的日，那么初步年龄-1
        if(birthdayMonth==nowMonth){
            if (birthdayDay<nowDay){
                age--;
            }
        }
        //12.返回年龄
        return age;

    }

    //打印对象
    public static void printPerson(Person person){
        System.out.println(person.getId()+"\t\t"+person.getName()+"\t\t"+person.getSex()+"\t\t"+person.getBirthday()+"\t\t"+person.getAge()+"\t\t"+person.show());
    }

    //打印集合所有对象
    public static void printArrayList(ArrayList list){
        System.out.println("**********************************************************************");
        System.out.println("编号\t\t姓名\t\t性别\t\t生日\t\t\t\t年龄\t\t描述");
        //循环遍历集合 list.size.for
        for (int i = 0; i < list.size(); i++) {
            //获取结合元素   list.get(i).varF生成返回值 返回的是object 类型
          //  Object o = list.get(i);向下转型
            Person person= (Person) list.get(i);//父类可以引用子类对象
            printPerson(person);
        }
        System.out.println("**********************************************************************");
    }
}
