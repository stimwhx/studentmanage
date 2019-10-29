package v1;

import java.util.Iterator;
import java.util.Scanner;

public class MaiTest {
    private static Scanner scanner = new Scanner(System.in);
    private static Student student = new Student();
    private static StudentList studentList = new StudentList();

    public static void main(String[] args) {
        System.out.println("欢迎使用学生管理系统V1.0");
        opritionMenu();
//        menu();
//        for(int i =0;i<v1.StudentList.cont;i++){
//            studentList.prinf();
//        }
    }

    public static void menu() {

        System.out.println("*****************************");
        System.out.println("*****                   *****");
        System.out.println("*****    1、添加学生    *****");
        System.out.println("*****    2、查询学生    *****");
        System.out.println("*****    3、修改学生    *****");
        System.out.println("*****    4、删除学生    *****");
        System.out.println("*****                   *****");
        System.out.println("*****************************");
//        if (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println("*****1、添加学生*****");
                    addStu();

                    opritionMenu();
                    break;

                case 2:
                    System.out.println("*****2、查询学生*****");
                    findStu();
                    opritionMenu();
                    break;
                case 3:
                    System.out.println("*****3、修改学生*****");
                    opritionStu();
                    opritionMenu();
                    break;
                case 4:
                    System.out.println("*****4、删除学生*****");
                    deleStu();
                    opritionMenu();
                    break;
                case 0:
                    menu();
                    break;
                case 9:
                    System.out.print("退出成功");
                    break;
            }
//        }
    }

    public static void opritionMenu() {
        System.out.println("*****0、列出菜单**********9、退出菜单*****");
        int o = scanner.nextInt();
        switch (o) {

            case 0:
                menu();
                break;
            case 9:
                System.out.print("退出成功");
                break;
        }
    }

    public static Student addStu() {
        System.out.println("请输入学生姓名：");

        Object obj1 = scanner.next();
        if (obj1 instanceof String) {
            student.setStuName(String.valueOf(obj1));
        }
        System.out.println("请输入学生年龄：");
        if (scanner.hasNextInt()) {
            student.setAge(scanner.nextInt());
        }
        System.out.println("请输入学生姓别：");
        Object obj2 = scanner.next();
        if (obj2 instanceof String) {
            student.setSex(String.valueOf(obj2));
        }
        System.out.println("请输入学生ID");
        if (scanner.hasNextInt()) {
            student.setId(scanner.nextInt());
        }
        return student;
    }

    public static void findStu() {
    }

    public static void deleStu() {
    }

    public static void opritionStu() {
    }

}