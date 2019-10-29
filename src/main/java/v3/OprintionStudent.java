package v3;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultAttribute;
import v2.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;
import java.util.Scanner;

public class OprintionStudent {
    private static Scanner scanner = new Scanner(System.in);
   // private static Student student = new Student();
    //修改学生
    public static void opritionStu(int i) {
//从XML文件中读取学生对象
//        StudentDataUtils.getStudents();
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
    //添加学生XML
    public static void addStu() { // TODO: 方法要有注释
        List<Student> studentListAdd= StudentDataUtils.getStudents();
        Student student = new Student();
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
        if (student != null) {
            studentListAdd.add(student);
            StudentDataUtils.saveList(studentListAdd);
        }

    }

    //查询学生
    public static void findStu(int i) {

        StudentDataUtils.getStudents();
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
        StudentDataUtils.getStudents();
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
                 addStu();

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
//按ID修改学生XML
    private static void opritionStuById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要修改学生的ID");
        String stuID = scanner.next();
        /*File file = new File("src\\main\\java\\v3\\student.xml");
        SAXReader saxReader = new SAXReader();
       //Student student = new Student();*/
        List<Student> studentList = StudentDataUtils.getStudents();
        Student stu = new Student();
        for(int i =0;i<studentList.size();i++){
            if(studentList.get(i).getId().equals(stuID)){
                stu.setId(studentList.get(i).getId());
                stu.setAge(studentList.get(i).getAge());
                stu.setStuName(studentList.get(i).getStuName());
                stu.setSex(studentList.get(i).getSex());
                System.out.println("请输入你选择你要修改的内容1、姓名，2、年龄 3、性别");
                int testSwitch = scanner.nextInt();
//                String strName=null; // TODO: 在最近的地方声明
//                int intAge=0;
//                String strSex=null;
                switch(testSwitch){
                    case 1:
                        System.out.println("输入修改的姓名");
                        String strName= scanner.next();
                        stu.setStuName(strName);
                        break;
                    case 2:
                        System.out.println("输入修改的年龄");
                        int intAge= scanner.nextInt();
                        stu.setAge(intAge);
                        break;
                    case 3:
                        System.out.println("输入修改的性别");
                        String strSex= scanner.next();
                        stu.setSex(strSex);

                }
            }
        }
        System.out.println(studentList);
        for (Student tempStu : studentList) {
            if (tempStu.getId().equals(stu.getId())) {
                tempStu.setStuName(stu.getStuName());
                tempStu.setSex(stu.getSex());
                tempStu.setAge(stu.getAge());
            }
        }
        System.out.println(studentList);
        StudentDataUtils.saveList(studentList);

    }
//按照年龄修改XML
    private static void oprintionStuAge(){
Scanner scanner = new Scanner(System.in);
System.out.println("请输入你要修改的年龄");
int ageStu = scanner.nextInt();
List<Student> studentListAge = StudentDataUtils.getStudents();
Student studentAge = new Student();
System.out.println(studentListAge);
for(int i =0;i<studentListAge.size();i++){
    if(studentListAge.get(i).getAge()==ageStu){
        studentAge.setId(studentListAge.get(i).getId());
        studentAge.setSex(studentListAge.get(i).getSex());
        studentAge.setStuName(studentListAge.get(i).getStuName());
        studentAge.setAge(studentListAge.get(i).getAge());
        System.out.println("请输入你要修改的选项1、姓名 2、年龄、3、性别、 4、id");
        int switchAge = scanner.nextInt();
        switch(switchAge){
            case 1:
                System.out.println("请输入你要修改的姓名");
                String ageName= scanner.next();
                studentAge.setStuName(ageName);
                break;
            case 2:
                System.out.println("请输入你要修改的年龄");
                int ageAge= scanner.nextInt();
                studentAge.setAge(ageAge);
                break;
            case 3:
                System.out.println("请输入你要修改的性别");
                String ageSex= scanner.next();
                studentAge.setSex(ageSex);
                break;
            case 4:
                System.out.println("请输入你要修改的性别");
                String ageId= scanner.next();
                studentAge.setSex(ageId);
                break;
        }
    }
}
for(int t =0;t<studentListAge.size();t++){
    if(studentListAge.get(t).getAge()==ageStu){
        studentListAge.get(t).setAge(studentAge.getAge());
        studentListAge.get(t).setId(studentAge.getId());
        studentListAge.get(t).setSex(studentAge.getSex());
        studentListAge.get(t).setStuName(studentAge.getStuName());

    }
}
StudentDataUtils.saveList(studentListAge);
           }


    //按照姓名修改学生XML
    private static void opritionStuName(){
        System.out.println("请输入你要修改的学生姓名");
        String nameStu = scanner.next();
        List<Student> studentListName = StudentDataUtils.getStudents();
        Student studentName = new Student();
        for(int i =0;i<studentListName.size();i++){
            if(studentListName.get(i).getStuName().equals(nameStu)){
                studentName.setId(studentListName.get(i).getId());
                studentName.setSex(studentListName.get(i).getSex());
                studentName.setStuName(studentListName.get(i).getStuName());
                studentName.setAge(studentListName.get(i).getAge());
                System.out.println("请输入你要修改的选项1、姓名 2、年龄、3、性别、 4、id");
                int switchAge = scanner.nextInt();
                switch(switchAge){
                    case 1:
                        System.out.println("请输入你要修改的姓名");
                        String ageName= scanner.next();
                        studentName.setStuName(ageName);
                        break;
                    case 2:
                        System.out.println("请输入你要修改的年龄");
                        int ageAge= scanner.nextInt();
                        studentName.setAge(ageAge);
                        break;
                    case 3:
                        System.out.println("请输入你要修改的性别");
                        String ageSex= scanner.next();
                        studentName.setSex(ageSex);
                        break;
                    case 4:
                        System.out.println("请输入你要修改的性别");
                        String ageId= scanner.next();
                        studentName.setSex(ageId);
                        break;
                }
            }
        }
        for(int t =0;t<studentListName.size();t++){
            if(studentListName.get(t).getStuName().equals(nameStu)){
                studentListName.get(t).setAge(studentName.getAge());
                studentListName.get(t).setId(studentName.getId());
                studentListName.get(t).setSex(studentName.getSex());
                studentListName.get(t).setStuName(studentName.getStuName());

            }
        }
        StudentDataUtils.saveList(studentListName);

    }
    //按照性别修改学生XML
    private static void opritionStuSex(){
        System.out.println("请输入你要修改的学生性别");
        String sexStu = scanner.next();
        List<Student> studentListSex = StudentDataUtils.getStudents();
        Student studentSex = new Student();
        for(int i =0;i<studentListSex.size();i++){
            if(studentListSex.get(i).getSex().equals(sexStu)){
                studentSex.setId(studentListSex.get(i).getId());
                studentSex.setSex(studentListSex.get(i).getSex());
                studentSex.setStuName(studentListSex.get(i).getStuName());
                studentSex.setAge(studentListSex.get(i).getAge());
                System.out.println("请输入你要修改的选项1、姓名 2、年龄、3、性别、 4、id");
                int switchAge = scanner.nextInt();
                switch(switchAge){
                    case 1:
                        System.out.println("请输入你要修改的姓名");
                        String ageName= scanner.next();
                        studentSex.setStuName(ageName);
                        break;
                    case 2:
                        System.out.println("请输入你要修改的年龄");
                        int ageAge= scanner.nextInt();
                        studentSex.setAge(ageAge);
                        break;
                    case 3:
                        System.out.println("请输入你要修改的性别");
                        String ageSex= scanner.next();
                        studentSex.setSex(ageSex);
                        break;
                    case 4:
                        System.out.println("请输入你要修改的性别");
                        String ageId= scanner.next();
                        studentSex.setSex(ageId);
                        break;
                }
            }
        }
        for(int t =0;t<studentListSex.size();t++){
            if(studentListSex.get(t).getSex().equals(sexStu)){
                studentListSex.get(t).setAge(studentSex.getAge());
                studentListSex.get(t).setId(studentSex.getId());
                studentListSex.get(t).setSex(studentSex.getSex());
                studentListSex.get(t).setStuName(studentSex.getStuName());

            }
        }
        StudentDataUtils.saveList(studentListSex);
    }
    //按ID查询学生XML
    private static void findStuById(){
        System.out.println("请输入你要查询的学生ID号");
        String stuID = scanner.next();
        boolean paduan1 = false;
        List<Student> studentListFind = StudentDataUtils.getStudents();
        for(int i =0;i<studentListFind.size();i++){
            if(studentListFind.get(i).getId().equals(stuID)){
                System.out.println(studentListFind.get(i).toString());
                paduan1=true;
            }
        }
        if (!paduan1) {
            System.out.println("没有找到你要的学生");
        }
    }
    //按年龄查询学生XML
    private static void findStuByAge(){
        System.out.println("请输入你要查询的学生年龄号");
        boolean paduan2 = false;
        int ageStu = scanner.nextInt();
        List<Student> studentListFindAge =StudentDataUtils.getStudents();
        for(int i =0;i<studentListFindAge.size();i++){
            if(studentListFindAge.get(i).getAge()==ageStu){
                System.out.println(studentListFindAge.get(i).toString());
                paduan2=true;
            }
        }
        if (!paduan2) {
            System.out.println("没有找到你要的学生");
        }
    }
    //按姓名查询学生XML
    private static void findStuByName(){
        System.out.println("请输入你要查询的学生姓名");
        boolean paduan3 = false;
        String nameStu = scanner.next();
        List<Student> studentListFindName =StudentDataUtils.getStudents();
        for(int i =0;i<studentListFindName.size();i++){
            if(studentListFindName.get(i).getStuName().equals(nameStu)){
                System.out.println(studentListFindName.get(i).toString());
                paduan3=true;
            }
        }
        if (!paduan3) {
            System.out.println("没有找到你要的学生");
        }
    }
    //按性别查询学生XML
    private static void findStuBySex(){
        System.out.println("请输入你要查询的学生性别");
        boolean paduan4 = false;
        String sexStu = scanner.next();
        List<Student> studentListFindSex =StudentDataUtils.getStudents();
        for(int i =0;i<studentListFindSex.size();i++){
            if(studentListFindSex.get(i).getSex().equals(sexStu)){
                System.out.println(studentListFindSex.get(i).toString());
                paduan4=true;
            }
        }
        if (!paduan4) {
            System.out.println("没有找到你要的学生");
        }
    }
    //按ID删除学生XML
    private static void deleteStuById(){
        System.out.println("请输入要删除的学生ID");
        String strStu = scanner.next();
        List<Student> list = StudentDataUtils.getStudents();
        for (int z = 0; z < list.size(); z++) {
            if (strStu.equals(list.get(z).getId())) {
                list.remove(z);
            }
        }
        System.out.println(list);

        StudentDataUtils.saveList(list);

    }
    //按年龄删除学生XML
    private static void deleteStuByAge(){
        System.out.println("请输入要删除学生的年龄");
        int intStuAge = scanner.nextInt();
        List<Student> list = StudentDataUtils.getStudents();
        for (int u = 0; u < list.size(); u++) {
            if (intStuAge == list.get(u).getAge()) {
                list.remove(u);
            }
        }

        StudentDataUtils.saveList(list);

    }
    //按姓名删除学生XML
    private static void deleteStuByName(){
        System.out.println("请输入要删除学生的姓名");
        String strStuName = scanner.next();
        List<Student> list = StudentDataUtils.getStudents();
        for (int y = 0; y < list.size(); y++) {
            if (strStuName.equals(list.get(y).getStuName())) {
                list.remove(y);
            }
        }

        StudentDataUtils.saveList(list);
    }
    //按性别删除学生XML
    private static void deleteStuBySex(){
        System.out.println("请输入要删除学生的性别");
        String strStuSex = scanner.next();
        List<Student> list = StudentDataUtils.getStudents();
        for (int w = 0; w < list.size(); w++) {
            if (strStuSex.equals(list.get(w).getSex())) {
                list.remove(w);
            }
        }

            StudentDataUtils.saveList(list);

    }
}
