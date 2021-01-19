package com.itheima.main;

import com.itheima.Utils.Utils;
import com.itheima.domain.Student;
import com.itheima.domain.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class MaInApp {
    public static void main(String[] args) {
        //创建一个集合存储所有学生对象
        ArrayList<Student> studentArrayList = new ArrayList<>();
        //创建一个集合存储所有老师对象
        ArrayList<Teacher> TeacherArrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
     //制作一级菜单
        while(true){
            System.out.println("1.学生管理系统      2.教师管理系统    3.退出系统 ");

            System.out.println("请选择菜单");
            int op = sc.nextInt();
            switch (op){
                case 1:
                    //进入学生管理信息系统
                    studentMange(studentArrayList,sc);
                    break;
                case 2:
                    //进入教师信息管理系统
                    TeacherMange(TeacherArrayList,sc);
                    break;
                case 3:
                    System.out.println("谢谢，欢迎下次使用");
                    System.exit(0);
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    /**
     *
     * @param teacherArrayList 进入教师管理系统
     */
    private static void TeacherMange(ArrayList<Teacher> teacherArrayList,Scanner scanner) {
    }

    /**
     *
     * @param studentArrayList 进入学生管理系统
     */
    private static void studentMange(ArrayList<Student> studentArrayList,Scanner scanner) {
        //制作二级菜单
        while (true){
            System.out.println("-------------------------------------------------------");
            System.out.println("1.添加学生  2.查询学生  3.修改学生  4.删除学生    5.返回");
            System.out.println();
            System.out.println("请输入功能序号：");
            int OP = scanner.nextInt();
            switch (OP){
                case 1:
                    //添加学生
                    addStudent(studentArrayList,scanner);
                    break;
                case 2:
                    //查询学生
                    selectStudent(studentArrayList);
                    break;
                case 3:
                   //修改学生
                    updateStudent(studentArrayList,scanner);
                    break;
                case 4:
                    //删除学生
                    deleteStudent(studentArrayList,scanner);
                    break;
                case 5:
                    //返回
                    return;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }

        }
    }

    /**
     * 删除学生
     * @param studentArrayList
     * @param scanner
     */
    private static void deleteStudent(ArrayList<Student> studentArrayList, Scanner scanner) {
        System.out.println("请输入您要删除的学生编号：");
        int index =scanner.nextInt();
        for (int i = 0; i < studentArrayList.size(); i++) {
           Student stu = studentArrayList.get(i);
           if(stu.getId()==index){
                System.out.println("请确认您是否要删除"+stu.getId()+"的学生信息y确认n不确任");
                String next = scanner.next();
                        if("y".equals(next)){
                            studentArrayList.remove(i);
                            System.out.println("删除成功");
                        }
                        else {
                            System.out.println("删除取消");
                        }
                        return;
            }

        }
        System.out.println("您删除的id，有误请重新输入");
    }

    /**
     * 修改学生
     * @param studentArrayList
     */
    private static void updateStudent(ArrayList<Student> studentArrayList,Scanner scanner) {
        System.out.println("请输入要修改的学生编号：");
        int index = scanner.nextInt();
        for (int i = 0; i < studentArrayList.size(); i++) {
           Student student = studentArrayList.get(i);
           if (student.getId()==index){
               System.out.println("请输入新的姓名，保留原值请按0");
               String name = scanner.next();
               System.out.println("请输入新的性别，保留原值请按0");
               String sex = scanner.next();
               System.out.println("请输入新的生日，格式为yyyy-MM-dd，保留原值请按0");
               String birthday = scanner.next();
               //判断输入的信息
               if(!"0".equals(name)){
                   student.setName(name);
               }
               if(!"0".equals(sex)){
                   student.setSex(sex);
               }
               if(!"0".equals(birthday)){
                   student.setBirthday(birthday);
                   student.setAge(Utils.birthdayTOAge(birthday));
               }

               return;
           }
        }
        System.out.println("您输入的id有误");
    }

    /**
     * 查询学生
     * @param studentArrayList
     */
    private static void selectStudent(ArrayList<Student> studentArrayList) {
        System.out.println("[查询结果]");
        //如果没有学生，就提示信息
        if(studentArrayList.size()==0){
            System.out.println("没有数据");
        }
        //如果有学生，就显示学生信息
        Utils.printArrayList(studentArrayList);
    }

    /**
     * 添加学生
     * @param studentArrayList
     * @param scanner
     */
    private static void addStudent(ArrayList<Student> studentArrayList, Scanner scanner) {
        //输入学生信息
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入性别：");
        String sex = scanner.next();
        System.out.println("请输入生日");
        String birthday = scanner.next();
        System.out.println();
        //创建学生对象
        Student stu = new Student();
        //把输入信息赋值给学生对象
        Utils.id++;
        stu.setId( Utils.id);
        stu.setName(name);
        stu.setSex(sex);
        stu.setBirthday(birthday);
        stu.setAge(Utils.birthdayTOAge(birthday));

        //把学生对象封装到集合中
        studentArrayList.add(stu);
        //打印学生对象
        System.out.println("添加学生成功");
    }


}
