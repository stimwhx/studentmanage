package v2.v2_2;

import v2.Student;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class OprintionStudent {
    private static Scanner scanner = new Scanner(System.in);
    private static Student student = new Student();
    //修改学生
    public static void opritionStu(int i) {

        StudentDataUtils.getStudentsByFile("D:\\student\\studentmanage.txt");
        switch (i) {
            case 1:
                opritionStuById();
                break;
            case 2:
                oprintionStuAge();
                break;
            case 3:
                opritionStuName();
                break;
            case 4:
                opritionStuSex();
                break;
        }
    }
    //添加学生
    public static Student addStu() { // TODO: 方法要有注释
        System.out.print("请输入学生姓名:");
        Object obj1 = scanner.next();
        if (obj1 instanceof String) {
            student.setStuName(String.valueOf(obj1));
        }
        System.out.print("请输入学生年龄:");
        if (scanner.hasNextInt()) {
            student.setAge(scanner.nextInt());
        }
        System.out.print("请输入学生姓别:");
        Object obj2 = scanner.next();
        if (obj2 instanceof String) {
            student.setSex(String.valueOf(obj2));
        }
        System.out.print("请输入学生学号:");
        if (scanner.hasNextInt()) {
            student.setId(String.valueOf(scanner.nextInt()));
        }
        return student;
    }

    //查询学生
    public static void findStu(int i) {

        StudentDataUtils.getStudentsByFile("D:\\student\\studentmanage.txt");
        if (StudentDataUtils.getStudents() == null || StudentDataUtils.getStudents().size() <= 0) {
            System.out.println("============暂无学生，请添加后再查询~~======================");
            return;
        }
        switch (i) {
            case 1:
                findStuById();
                break;
            case 2:
                findStuByAge();
                break;
            case 3:
                findStuByName();
                break;
            case 4:
                findStuBySex();
                break;

            case 5:
                //查询所有学生
                for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
                    System.out.println(StudentDataUtils.getStudents().get(f).toString());
                }
                break;
        }
    }

    //删除学生
    public static void deleStu() {
        StudentDataUtils.getStudentsByFile("D:\\student\\studentmanage.txt");
        Student s1 = new Student();
        PrintMenu.deleDataPrint();
        int studentDele = scanner.nextInt();
        switch (studentDele) {
            case 1:
                deleteStuById();
                break;
            case 2:
                deleteStuByAge();
                break;
            case 3:
                deleteStuByName();
                break;
            case 4:
                deleteStuBySex();
                break;
        }
}
    public static void menu() {
        PrintMenu.menuDataPrint();
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("*****1、添加学生*****");
                Student stu = addStu();
                if (stu != null) {
                    StudentDataUtils.saveStu(stu);
                }
                opritionMenu();
                break;

            case 2:
                System.out.println("*****2、查询学生*****");
                PrintMenu.findDataPrint();

                int findParam = scanner.nextInt();
                findStu(findParam);
                opritionMenu();
                break;
            case 3:
                System.out.println("*****3、修改学生*****");
                PrintMenu.opritionDataPrint();
                int xuanze = scanner.nextInt();
                OprintionStudent.opritionStu(xuanze);
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
//按ID修改学生
    private static void opritionStuById(){
        boolean paduan1 = false;
        System.out.println("请输入你要修改学生的ID");
        String stuID = scanner.next();
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (stuID.equals(StudentDataUtils.getStudents().get(f).getId())) {

                paduan1 = true;
            }
        }
        if (!paduan1) {
            System.out.println("没有找到你要的学生");
            opritionMenu();
            return;
        }
        PrintMenu.opritionDataPrint();
        int xuigaiStu = scanner.nextInt();
        Student tempStu = null;
        for (int a = 0; a < StudentDataUtils.getStudents().size(); a++) {
            if (stuID.equals(StudentDataUtils.getStudents().get(a).getId())) {
                switch (xuigaiStu) {
                    case 1:
                        System.out.println("请输入ID");
                        String strId1 = scanner.next();
                        StudentDataUtils.getStudents().get(a).setId(strId1);
                        break;
                    case 2:
                        System.out.println("请输入年龄");
                        int strId2 = scanner.nextInt();
                        StudentDataUtils.getStudents().get(a).setAge(strId2);

                        break;
                    case 3:
                        System.out.println("请输入姓名");
                        String strId3 = scanner.next();
                        StudentDataUtils.getStudents().get(a).setStuName(strId3);

                        break;
                    case 4:
                        System.out.println("请输入性别");
                        String strId4 = scanner.next();
                        StudentDataUtils.getStudents().get(a).setStuName(strId4);
                        break;
                }

                tempStu = StudentDataUtils.getStudents().get(a);

            }
        }
        if (tempStu != null) {
            StudentDataUtils.saveStu(tempStu);
        }
        try {
            StudentDataUtils.saveList("D:\\student\\studentmanage.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============== 系统异常！！文件丢失~ ==============");
        }
    }
//按照年龄修改
    private static void oprintionStuAge(){
        System.out.println("请输入你要修改的学生年龄");
        boolean paduan2 = false;
        int ageStu = scanner.nextInt();
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (ageStu == StudentDataUtils.getStudents().get(f).getAge()) {

                paduan2 = true;
            }
        }
        if (!paduan2) {
            System.out.println("没有找到你要的学生");
            opritionMenu();
            return;
        }
        PrintMenu.opritionDataPrint();
        int ageModifile = scanner.nextInt();
        Student tempStu2 = null;
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (ageStu == StudentDataUtils.getStudents().get(f).getAge()) {

                switch (ageModifile) {
                    case 1:
                        System.out.println("请输入ID");
                        String strId1 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setId(strId1);
                        break;
                    case 2:
                        System.out.println("请输入年龄");
                        int strId2 = scanner.nextInt();
                        StudentDataUtils.getStudents().get(f).setAge(strId2);

                        break;
                    case 3:
                        System.out.println("请输入姓名");
                        String strId3 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setStuName(strId3);

                        break;
                    case 4:
                        System.out.println("请输入性别");
                        String strId4 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setStuName(strId4);

                        break;

                }
                tempStu2 = StudentDataUtils.getStudents().get(f);
            }
        }
        if (tempStu2 != null) {
            StudentDataUtils.saveStu(tempStu2);
        }
        try {
            StudentDataUtils.saveList("D:\\student\\studentmanage.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============== 系统异常！！文件丢失~ ==============");
        }

    }
    //按照姓名修改学生
    private static void opritionStuName(){
        System.out.println("请输入你要修改的学生姓名");
        boolean paduan3 = false;
        String nameStu = scanner.next();
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (StudentDataUtils.getStudents().get(f).getStuName().contains(nameStu)) {

                paduan3 = true;
            }
        }
        if (!paduan3) {
            System.out.println("没有找到你要的学生");
            opritionMenu();
            return;
        }
        PrintMenu.opritionDataPrint();
        int ageModifile3 = scanner.nextInt();
        Student tempStu3 = null;
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (StudentDataUtils.getStudents().get(f).getStuName().contains(nameStu)) {
                switch (ageModifile3) {
                    case 1:
                        System.out.println("请输入ID");
                        String strId1 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setId(strId1);
                        break;
                    case 2:
                        System.out.println("请输入年龄");
                        int strId2 = scanner.nextInt();
                        StudentDataUtils.getStudents().get(f).setAge(strId2);

                        break;
                    case 3:
                        System.out.println("请输入姓名");
                        String strId3 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setStuName(strId3);

                        break;
                    case 4:
                        System.out.println("请输入性别");
                        String strId4 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setStuName(strId4);

                        break;

                }
                tempStu3 = StudentDataUtils.getStudents().get(f);
            }
        }
        if (tempStu3 != null) {
            StudentDataUtils.saveStu(tempStu3);
        }
        try {
            StudentDataUtils.saveList("D:\\student\\studentmanage.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============== 系统异常！！文件丢失~ ==============");
        }

    }
    //按照性别修改学生
    private static void opritionStuSex(){
        System.out.println("请输入你要修改的学生性别");
        boolean paduan4 = false;
        String sexStu = scanner.next();
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (sexStu.equals(StudentDataUtils.getStudents().get(f).getSex())) {

                paduan4 = true;
            }
        }
        if (!paduan4) {
            System.out.println("没有找到你要的学生");
            opritionMenu();
            return;
        }
        PrintMenu.opritionDataPrint();
        int ageModifile4 = scanner.nextInt();
        Student tempStu4 = null;
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (sexStu.equals(StudentDataUtils.getStudents().get(f).getSex())) {
                switch (ageModifile4) {
                    case 1:
                        System.out.println("请输入ID");
                        String strId1 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setId(strId1);
                        break;
                    case 2:
                        System.out.println("请输入年龄");
                        int strId2 = scanner.nextInt();
                        StudentDataUtils.getStudents().get(f).setAge(strId2);

                        break;
                    case 3:
                        System.out.println("请输入姓名");
                        String strId3 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setStuName(strId3);

                        break;
                    case 4:
                        System.out.println("请输入性别");
                        String strId4 = scanner.next();
                        StudentDataUtils.getStudents().get(f).setStuName(strId4);
                        break;
                }
                tempStu4 = StudentDataUtils.getStudents().get(f);
            }
        }
        if (tempStu4 != null) {
            StudentDataUtils.saveStu(tempStu4);
        }
        try {
            StudentDataUtils.saveList("D:\\student\\studentmanage.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============== 系统异常！！文件丢失~ ==============");
        }
    }
    //按ID查询学生
    private static void findStuById(){
        System.out.println("请输入你要查询的学生ID号");
        String stuID = scanner.next();
        boolean paduan1 = false;
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (stuID.equals(StudentDataUtils.getStudents().get(f).getId())) {
                System.out.println(StudentDataUtils.getStudents().get(f).toString());
                paduan1 = true;
            }
        }
        if (!paduan1) {
            System.out.println("没有找到你要的学生");
        }
    }
    //按年龄查询学生
    private static void findStuByAge(){
        System.out.println("请输入你要查询的学生年龄号");
        boolean paduan2 = false;
        int ageStu = scanner.nextInt();
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (ageStu == StudentDataUtils.getStudents().get(f).getAge()) {
                System.out.println(StudentDataUtils.getStudents().get(f).toString());
                paduan2 = true;
            }
        }
        if (!paduan2) {
            System.out.println("没有找到你要的学生");
        }
    }
    //按姓名查询学生
    private static void findStuByName(){
        System.out.println("请输入你要查询的学生姓名");
        boolean paduan3 = false;
        String nameStu = scanner.next();
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (StudentDataUtils.getStudents().get(f).getStuName().contains(nameStu)) {
                System.out.println(StudentDataUtils.getStudents().get(f).toString());
                paduan3 = true;
            }
        }
        if (!paduan3) {
            System.out.println("没有找到你要的学生");
        }
    }
    //按性别查询学生
    private static void findStuBySex(){
        System.out.println("请输入你要查询的学生性别");
        boolean paduan4 = false;
        String sexStu = scanner.next();
        for (int f = 0; f < StudentDataUtils.getStudents().size(); f++) {
            if (sexStu.equals(StudentDataUtils.getStudents().get(f).getSex())) {
                System.out.println(StudentDataUtils.getStudents().get(f).toString());
                paduan4 = true;
            }
        }
        if (!paduan4) {
            System.out.println("没有找到你要的学生");
        }
    }
    //按ID删除学生
    private static void deleteStuById(){
        System.out.println("请输入要删除的学生ID");
        String strStu = scanner.next();
        for (int z = 0; z < StudentDataUtils.getStudents().size(); z++) {
            if (strStu.equals(StudentDataUtils.getStudents().get(z).getId())) {
                StudentDataUtils.getStudents().remove(z);
            }
        }
        try {
            StudentDataUtils.saveList("D:\\student\\studentmanage.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============== 系统异常！！文件丢失~ ==============");
        }
    }
    //按年龄删除学生
    private static void deleteStuByAge(){
        System.out.println("请输入要删除学生的年龄");
        int intStuAge = scanner.nextInt();
        for (int u = 0; u < StudentDataUtils.getStudents().size(); u++) {
            if (intStuAge == StudentDataUtils.getStudents().get(u).getAge()) {
                StudentDataUtils.getStudents().remove(u);
            }
        }
        try {
            StudentDataUtils.saveList("D:\\student\\studentmanage.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============== 系统异常！！文件丢失~ ==============");
        }
    }
    //按姓名删除学生
    private static void deleteStuByName(){
        System.out.println("请输入要删除学生的姓名");
        String strStuName = scanner.next();
        for (int y = 0; y < StudentDataUtils.getStudents().size(); y++) {
            if (strStuName.equals(StudentDataUtils.getStudents().get(y).getStuName())) {
                StudentDataUtils.getStudents().remove(y);
            }
        }
        try {
            StudentDataUtils.saveList("D:\\student\\studentmanage.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============== 系统异常！！文件丢失~ ==============");
        }
    }
    //按性别删除学生
    private static void deleteStuBySex(){
        System.out.println("请输入要删除学生的性别");
        String strStuSex = scanner.next();
        for (int w = 0; w < StudentDataUtils.getStudents().size(); w++) {
            if (strStuSex.equals(StudentDataUtils.getStudents().get(w).getSex())) {
                StudentDataUtils.getStudents().remove(w);
            }
        }
        try {
            StudentDataUtils.saveList("D:\\student\\studentmanage.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("============== 系统异常！！文件丢失~ ==============");
        }
    }
}
