package v5;

import v4.OprintionStudent;
import v4.PrintMenu;
import v4.StudentDataUtils;

import java.util.Scanner;

public class TestMenu {
    private static Scanner scanner = new Scanner(System.in);
    public static void menuDataPrint(){
        System.out.println("*****************************");
        System.out.println("*****                   *****");
        System.out.println("*****    1、添加学生    *****");
        System.out.println("*****    2、查询学生    *****");
        System.out.println("*****    3、修改学生    *****");
        System.out.println("*****    4、删除学生    *****");
        System.out.println("*****                   *****");
        System.out.println("*****************************");
    }
    public static void findDataPrint(){
        System.out.println("*****************************************");
        System.out.println("*****                               *****");
        System.out.println("*****        1、按姓名查询            *****");
        System.out.println("*****        2、按姓别查询          *****");
        System.out.println("*****        3、按ID查询          *****");
        System.out.println("*****        4、按年龄查询         *****");
        System.out.println("*****        5、查询所有学生信息    *****");
        System.out.println("*****                               *****");
        System.out.println("*****************************************");
    }
    public static void deleDataPrint(){
        System.out.println("*****************************");
        System.out.println("*****                   *****");
        System.out.println("*****    1、按ID删除    *****");
        System.out.println("*****    2、按年龄删除    *****");
        System.out.println("*****    3、按姓名删除    *****");
        System.out.println("*****    4、按姓别删除    *****");
        System.out.println("*****                   *****");
        System.out.println("*****************************");
    }
    public static void  opritionDataPrint(){
        System.out.println("*****************************");
        System.out.println("*****                   *****");
        System.out.println("*****    1、按ID修改学生姓名    *****");
        System.out.println("*****    2、按ID修改学生性别   *****");
        System.out.println("*****    3、按ID修改学生年龄    *****");
        System.out.println("*****    4、按ID修改全部信息    *****");
        System.out.println("*****                   *****");
        System.out.println("*****************************");
    }
    public static void opritionMenu() {
        System.out.println("*****0、列出菜单**********9、退出菜单*****");
        int o = scanner.nextInt(); // TODO: 变量命名不规范
        switch (o) {

            case 0:
                menu();
                break;
            case 9:
                System.out.print("退出成功");
                break;
        }
    }
    public static void menu() {
        menuDataPrint();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("*****1、添加学生*****");
                Student student = new Student();
                System.out.println("请输入学生姓名");
                String name = scanner.next();
                student.setName(name);
                System.out.println("请输入学生性别");
                String sex = scanner.next();
                student.setSex(sex);
                System.out.println("请输入学生ID");
                int id = scanner.nextInt();
                student.setId(id);
                System.out.println("请输入学生年龄");
                int age= scanner.nextInt();
                student.setAge(age);
                if (student != null) {
                    StudentDataDao.addStu(student);
                }
                opritionMenu();
                break;

            case 2:

                findDataPrint();
                System.out.println("*****选择查询类型*****");
                int find = scanner.nextInt();
                StudentSwitch.findStuSwitch(find);
                opritionMenu();
                break;
            case 3:

                opritionDataPrint();
                System.out.println("*****3、选择修改类型*****");
                int upInt = scanner.nextInt();
                StudentSwitch.upStu(upInt);
                opritionMenu();
                break;
            case 4:
                System.out.println("*****选择删除类型*****");
                deleDataPrint();
                int deleInt =scanner.nextInt();
                StudentSwitch.deleStu(deleInt );
                opritionMenu();
                break;
            case 0:
                menu();
                break;
            case 9:
                System.out.print("退出成功");
                break;
        }
    }
}
