package test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManger {
    public static void main(String[] args) {

        //搭建主菜单界面

        Scanner sc = new Scanner(System.in);

        //创建学生集合
        ArrayList <Student> list = new ArrayList<>();
        Student stu1 = new Student("heima001","张三",23,"1998-01-03");
        Student stu2 = new Student("heima002","李四",23,"1998-05-03");
        Student stu3= new Student("heima003","王五",23,"1998-06-03");
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        //标号起别名跳出外层循环
        lo:while (true){
            System.out.println("-----------欢迎来到学生管理系统-----------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择");

            String choice = sc.next();

            switch (choice){
                case "1":
                    //System.out.println("添加成功")
                    addStudent(list);
                    break;
                case "2":
                    //System.out.println("删除成功");
                    deleteStudent(list);
                    break;
                case "3":
                    // System.out.println("修改成功");
                    updataStudent(list);
                    break;
                case "4":
                    //System.out.println("查看成功");
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("感谢您的使用");
                    break lo;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;


            }
        }


    }
    //修改信息的方法
    private static void updataStudent(ArrayList<Student> list) {
        //给出提示信息 （请输入您要修改的学号）
        System.out.println("请输入您要修改的学号");
        //键盘接收要删除的学号
        Scanner sc = new Scanner(System.in);
        String studentSid = sc.next();
        //调用getindex方法找到要删除的索引号
        int index = getIndex(list,studentSid);
        //根据索引判断，学号在集合中是否存在
        if(index!=-1){
            //存在:执行set方法
            Scanner sc1 = new Scanner(System.in);
            System.out.println("输入您要修改的学号：");
            list.get(index).setSid(sc.next());
            System.out.println("输入您要修改的姓名：");
            list.get(index).setName(sc.next());
            System.out.println("输入您要修改的年龄：");
            list.get(index).setAge(sc.nextInt());
            System.out.println("输入您要修改的生日：");
            list.get(index).setBirthday(sc.next());
            System.out.println("修改成功！");
        }
        else {
            //不存在：给出提示
            System.out.println("您要修改的学号有误！");
        }
    }
     //删除学生的方法
    private static void deleteStudent(ArrayList<Student> list) {
        //给出提示信息 （请输入您要删除的学号）
        System.out.println("请输入您要删除的学号");
        //键盘接收要删除的学号
        Scanner sc = new Scanner(System.in);
        String studentSid = sc.next();
        //调用getindex方法找到要删除的索引号
        int index = getIndex(list,studentSid);
        //根据索引判断，学号在集合中是否存在
        if(index!=-1){
            //存在:执行remove方法
            list.remove(index);
            System.out.println("删除成功！");
        }
        else {
            //不存在：给出提示
            System.out.println("您删除的学号有误！");
        }
    }

    //查询学生方法
    private static void queryStudent(ArrayList<Student> list) {
         //1.判断集合是否存在信息，如果不存在直接给出提示
        if (list.size()==0){
            System.out.println("无信息，请添加后再查询");
            return;
        }
        //2.存在展示表头数据
        System.out.println("学号\t姓名\t年龄\t生日");
        //3.遍历集合，获取每一个学生信息，打印在控制台上
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getSid()+"\t\t"+stu.getName()+"\t"+stu.getAge()+"\t\t"+stu.getBirthday());
        }

    }

    //添加学生的方法
    private static void addStudent(ArrayList <Student> list) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            //1.给出录入的提示信息
            System.out.println("请输入学号");
            String sid = sc.next();
            int index = getIndex(list, sid);
            if (index == -1) {
                System.out.println("请输入姓名");
                String name = sc.next();
                System.out.println("请输入年龄");
                int age = sc.nextInt();
                System.out.println("请输入生日");
                String birthday = sc.next();

                //2.将键盘录入的信息封装为学生对象
                Student stu = new Student(sid, name, age, birthday);
                //3.将封装好学生对象放入集合中
                list.add(stu);
                //4.给出添加成功的提示信息
                System.out.println("添加成功");
                break;
            } else {
                System.out.println("您输入的学号已存在请重新输入：");
            }
        }
    }

    /* getIndex 接收一个对象，接收一个学生学号
       查找这个学号在集合中索引位置
     */
    public static int getIndex(ArrayList <Student> list, String sid) {
        //1.假设传入的学号在集合中不存在
        int index = -1;
        //2.遍历集合获取每一个学生对象，准备查找
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            //3，获取每个学生对象的学号
            String studentSid = stu.getSid();
            //4.使用获取的学生的学号，与传入的学号进行比对
            if (studentSid.equals(sid)) {
                //5.存在则让变量记录正确索引位置
                index = i;
            }

        }
        return index;
    }


}
