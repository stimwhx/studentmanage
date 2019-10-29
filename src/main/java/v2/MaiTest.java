package v2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MaiTest {
    private static Scanner scanner = new Scanner(System.in);
    private static Student student = new Student();
    private static StudentList studentList = new StudentList();
    private static List<Student> students = new ArrayList<Student>();

    //从文件中把数据读到程序里来
 public static List<String> rederStu(String pathFile){
        File rederFileStu = new File("D:\\student\\studentmanage.txt");
        List<String> list = new ArrayList<String>();
        try {
            Reader reader = new FileReader(rederFileStu);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp = null;
            while((temp=bufferedReader.readLine())!=null){
                temp.trim();
                list.add(temp);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
    //把文件中读到的string转student存放在列表中
    public static void wirterStu(String pathFile){
        students.clear();
        List<String> listStu=rederStu(pathFile);
      //  List<Student> students = new ArrayList<Student>();
        for(int listi =0;listi<listStu.size();listi++){
            String strline = listStu.get(listi);
           // System.out.println("读入数据有原始格式："+strline);
            String [] strings=strline.split(" ");
            String arr0 = strings[0];
           // System.out.println("arr0: 0"+ arr0);
            String name = arr0.split("：")[1];

            String arr1 = strings[1];
            String age = arr1.split("：")[1];

            String arr2 = strings[2];
            String sex = arr2.split("：")[1];

            String arr3 = strings[3];
            String id = arr3.split("：")[1];

            Student student = new Student();
            student.setId(id);
            student.setStuName(name);
            student.setAge(Integer.parseInt(age));
            student.setSex(sex);
            students.add(student);
        }

    }
    //向文件中保存数据
    public static void saveStu(Student student) {
        File file = new File("D:\\student\\studentmanage.txt");
        OutputStream outputStream;

        {
            try {
                outputStream = new FileOutputStream(file,true);
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
                String string = student.toString();
                printWriter.print(string+"\r\n");

                printWriter.flush();
                printWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

//修改后向文件中从新保存数据
    public static void saveList(String p) throws FileNotFoundException {
        //把文件内容清空，重新保存一次Students列表里的内容
        File f = new File(p);
        OutputStream outputStream = new FileOutputStream(f);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
        for(int t =0;t<students.size();t++){
            String str = students.get(t).toString();
            printWriter.println(str);
        }
        printWriter.flush();
        printWriter.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("欢迎使用学生管理系统V1.0");
        opritionMenu();
//        menu();
//        for(int i =0;i<v1.StudentList.cont;i++){
//            studentList.prinf();
//        }
    }

    public static void menu() throws FileNotFoundException {

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
                Student stu = addStu();
                if (stu != null) {
                    saveStu(stu);
                }
                opritionMenu();
                break;

            case 2:
                System.out.println("*****2、查询学生*****");
                System.out.println("*****************************");
                System.out.println("*****                   *****");
                System.out.println("*****    1、按ID查询    *****");
                System.out.println("*****    2、按年龄查询    *****");
                System.out.println("*****    3、按姓名查询    *****");
                System.out.println("*****    4、按姓别查询    *****");
                System.out.println("*****                   *****");
                System.out.println("*****************************");


                int findParam = scanner.nextInt();
                findStu(findParam);
                opritionMenu();
                break;
            case 3:
                System.out.println("*****3、修改学生*****");
                System.out.println("*****************************");
                System.out.println("*****                   *****");
                System.out.println("*****    1、按ID修改    *****");
                System.out.println("*****    2、按年龄修改    *****");
                System.out.println("*****    3、按姓名修改    *****");
                System.out.println("*****    4、按姓别修改    *****");
                System.out.println("*****                   *****");
                System.out.println("*****************************");
                int xuanze = scanner.nextInt();
                opritionStu(xuanze);
                /*System.out.println("1.继续修改，2退出程序");
                int hh = scanner.nextInt();
                opStu(hh);*/
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

    public static void opritionMenu() throws FileNotFoundException {
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

    public static void findStuParam(int i){

        switch(i){
            case 1:
                System.out.println("*****************************");
                System.out.println("*****                   *****");
                System.out.println("*****    1、按ID查询    *****");
                System.out.println("*****    2、按年龄查询    *****");
                System.out.println("*****    3、按姓名查询    *****");
                System.out.println("*****    4、按姓别查询    *****");
                System.out.println("*****                   *****");
                System.out.println("*****************************");
                int paramStuFind = scanner.nextInt();
                findStu(paramStuFind);
                break;
            case 2:
                System.out.println("欢迎使用查询，再见~~");
                break;


        }
    }
    //查询学生
    public static void findStu(int i) {

        wirterStu("D:\\student\\studentmanage.txt");
        switch(i){
            case 1:
                System.out.println("请输入你要查询的学生ID号");
                String stuID= scanner.next();
                boolean paduan1 =false;
                for(int f = 0;f<students.size();f++){
                    if(stuID.equals(students.get(f).getId())){
                        System.out.println(students.get(f).toString());
                        paduan1=true;
                    }
                }
                if(!paduan1){
                    System.out.println("没有找到你要的学生");
                }
               /* System.out.println("1、继续查询，2退出程序");
                int p1 = scanner.nextInt();
                findStuParam(p1);*/
                break;
            case 2:
                System.out.println("请输入你要查询的学生年龄号");
                boolean paduan2 =false;
                int ageStu= scanner.nextInt();
                for(int f = 0;f<students.size();f++){
                    if(ageStu==students.get(f).getAge()){
                        System.out.println(students.get(f).toString());
                        paduan2=true;
                    }
                }
                if (!paduan2){
                    System.out.println("没有找到你要的学生");
                }

                /*System.out.println("1、继续查询，2退出程序");
                int p2 = scanner.nextInt();
                findStuParam(p2);*/
                break;
            case 3:
                System.out.println("请输入你要查询的学生姓名");
                boolean paduan3 = false;
                String nameStu= scanner.next();
                for(int f = 0;f<students.size();f++){
                    if(students.get(f).getStuName().contains(nameStu)){
                        System.out.println(students.get(f).toString());
                        paduan3=true;
                    }
                }
                if(!paduan3){
                    System.out.println("没有找到你要的学生");
                }
                /*System.out.println("1、继续查询，2退出程序");
                int p3 = scanner.nextInt();
                findStuParam(p3);*/
                break;
            case 4:
                System.out.println("请输入你要查询的学生性别");
                boolean paduan4 = false;
                String sexStu= scanner.next();
                for(int f = 0;f<students.size();f++){
                    if(sexStu.equals(students.get(f).getSex())){
                        System.out.println(students.get(f).toString());
                        paduan4=true;
                    }
                }
                if(!paduan4){
                    System.out.println("没有找到你要的学生");
                }
               /* System.out.println("1、继续查询，2退出程序");
                int p4 = scanner.nextInt();
                findStuParam(p4);*/
                break;

        }

    }
//删除学生
    public static void deleStu() throws FileNotFoundException {
        wirterStu("D:\\student\\studentmanage.txt");
        Student s1 = new Student();
        System.out.println("*****************************");
        System.out.println("*****                   *****");
        System.out.println("*****    1、按ID删除    *****");
        System.out.println("*****    2、按年龄删除    *****");
        System.out.println("*****    3、按姓名删除    *****");
        System.out.println("*****    4、按姓别删除    *****");
        System.out.println("*****                   *****");
        System.out.println("*****************************");
        int studentDele= scanner.nextInt();
        switch(studentDele){
            case 1:
                System.out.println("请输入要删除的学生ID");
                String strStu= scanner.next();
                for(int z=0 ;z<students.size();z++){
                    if(strStu.equals(students.get(z).getId())){
                        students.remove(z);
                    }
                }
                saveList("D:\\student\\studentmanage.txt");
                break;
            case 2:
                System.out.println("请输入要删除学生的年龄");
                int intStuAge = scanner.nextInt();
                for(int u =0;u<students.size();u++){
                    if(intStuAge==students.get(u).getAge()){
                        students.remove(u);
                    }
                }
                saveList("D:\\student\\studentmanage.txt");
                break;
            case 3:
                System.out.println("请输入要删除学生的姓名");
                String strStuName=scanner.next();
                for(int y =0;y<students.size();y++){
                    if(strStuName.equals(students.get(y).getStuName())){
                        students.remove(y);
                    }
                }
                saveList("D:\\student\\studentmanage.txt");
                break;
            case 4:
                System.out.println("请输入要删除学生的性别");
                String strStuSex = scanner.next();
                for(int w=0;w<students.size();w++){
                    if(strStuSex.equals(students.get(w).getSex())){
                        students.remove(w);
                    }
                }
                saveList("D:\\student\\studentmanage.txt");
                break;
        }



    }
//修改学生
    public static void opritionStu(int i) throws FileNotFoundException {

        wirterStu("D:\\student\\studentmanage.txt");
        String name1= null;
        int age1=0;
        String sex1=null;
        String id1= null;
        Student xuigaihouStu = new Student();
        switch(i){
            case 1:
                boolean paduan1=false;
                System.out.println("请输入你要修改学生的ID");
                String stuID= scanner.next();
                for(int f = 0;f<students.size();f++){
                    if(stuID.equals(students.get(f).getId())){

                        paduan1=true;
                    }
                }
                if(!paduan1){
                    System.out.println("没有找到你要的学生");
                    opritionMenu();
                    return;
                }
                System.out.println("*****************************");
                System.out.println("*****                   *****");
                System.out.println("*****    1、修改ID修改    *****");
                System.out.println("*****    2、修改年龄  *****");
                System.out.println("*****    3、修改姓名   *****");
                System.out.println("*****    4、修改姓别    *****");
                System.out.println("*****                   *****");
                System.out.println("*****************************");
                int xuigaiStu= scanner.nextInt();

                for(int a =0 ;a<students.size();a++){
                    if(stuID.equals(students.get(a).getId())){
                        switch(xuigaiStu){
                            case 1:
                                System.out.println("请输入ID");
                                String strId1= scanner.next();
                                students.get(a).setId(strId1);
                                break;
                            case 2:
                                System.out.println("请输入年龄");
                                int strId2= scanner.nextInt();
                                students.get(a).setAge(strId2);

                                break;
                            case 3:
                                System.out.println("请输入姓名");
                                String strId3= scanner.next();
                                students.get(a).setStuName(strId3);

                                break;
                            case 4:
                                System.out.println("请输入性别");
                                String strId4= scanner.next();
                                students.get(a).setStuName(strId4);

                                break;
                        }

                        id1= students.get(a).getId();
                        sex1=students.get(a).getSex();
                        name1=students.get(a).getStuName();
                        age1=students.get(a).getAge();
                    }
                }

                xuigaihouStu.setStuName(name1);
                xuigaihouStu.setAge(age1);
                xuigaihouStu.setId(id1);
                xuigaihouStu.setSex(sex1);
                saveStu(xuigaihouStu);
                saveList("D:\\student\\studentmanage.txt");
                /*System.out.println("1、继续修改，2退出程序");
                int p1 = scanner.nextInt();
                opStu(p1);*/

                break;
            case 2:
                System.out.println("请输入你要修改的学生年龄");
                boolean paduan2 =false;
                int ageStu= scanner.nextInt();
                for(int f = 0;f<students.size();f++){
                    if(ageStu==students.get(f).getAge()){

                        paduan2=true;
                    }
                }
                if(!paduan2){
                    System.out.println("没有找到你要的学生");
                    opritionMenu();
                    return;
                }
                System.out.println("*****************************");
                System.out.println("*****                   *****");
                System.out.println("*****    1、修改ID修改    *****");
                System.out.println("*****    2、修改年龄  *****");
                System.out.println("*****    3、修改姓名   *****");
                System.out.println("*****    4、修改姓别    *****");
                System.out.println("*****                   *****");
                System.out.println("*****************************");
                int ageModifile = scanner.nextInt();
                for(int f = 0;f<students.size();f++){
                    if(ageStu==students.get(f).getAge()){

                        switch(ageModifile){
                            case 1:
                                System.out.println("请输入ID");
                                String strId1= scanner.next();
                                students.get(f).setId(strId1);
                                break;
                            case 2:
                                System.out.println("请输入年龄");
                                int strId2= scanner.nextInt();
                                students.get(f).setAge(strId2);

                                break;
                            case 3:
                                System.out.println("请输入姓名");
                                String strId3= scanner.next();
                                students.get(f).setStuName(strId3);

                                break;
                            case 4:
                                System.out.println("请输入性别");
                                String strId4= scanner.next();
                                students.get(f).setStuName(strId4);

                                break;

                        }
                        id1= students.get(f).getId();
                        sex1=students.get(f).getSex();
                        name1=students.get(f).getStuName();
                        age1=students.get(f).getAge();
                        paduan2=true;
                    }
                }
                xuigaihouStu.setStuName(name1);
                xuigaihouStu.setAge(age1);
                xuigaihouStu.setId(id1);
                xuigaihouStu.setSex(sex1);
                saveStu(xuigaihouStu);
                saveList("D:\\student\\studentmanage.txt");


               /* System.out.println("1、继续修改，2退出程序");
                int ageMo = scanner.nextInt();
                opStu(ageMo);*/
                break;
            case 3:
                System.out.println("请输入你要修改的学生姓名");
                boolean paduan3 = false;
                String nameStu= scanner.next();
                for(int f = 0;f<students.size();f++){
                    if(students.get(f).getStuName().contains(nameStu)){

                        paduan3=true;
                    }
                }
                if(!paduan3){
                    System.out.println("没有找到你要的学生");
                    opritionMenu();
                    return;
                }
                System.out.println("*****************************");
                System.out.println("*****                   *****");
                System.out.println("*****    1、修改ID修改    *****");
                System.out.println("*****    2、修改年龄  *****");
                System.out.println("*****    3、修改姓名   *****");
                System.out.println("*****    4、修改姓别    *****");
                System.out.println("*****                   *****");
                System.out.println("*****************************");
                int ageModifile3 = scanner.nextInt();

                for(int f = 0;f<students.size();f++){
                    if(students.get(f).getStuName().contains(nameStu)){
                        switch(ageModifile3){
                            case 1:
                                System.out.println("请输入ID");
                                String strId1= scanner.next();
                                students.get(f).setId(strId1);
                                break;
                            case 2:
                                System.out.println("请输入年龄");
                                int strId2= scanner.nextInt();
                                students.get(f).setAge(strId2);

                                break;
                            case 3:
                                System.out.println("请输入姓名");
                                String strId3= scanner.next();
                                students.get(f).setStuName(strId3);

                                break;
                            case 4:
                                System.out.println("请输入性别");
                                String strId4= scanner.next();
                                students.get(f).setStuName(strId4);

                                break;

                        }
                        id1= students.get(f).getId();
                        sex1=students.get(f).getSex();
                        name1=students.get(f).getStuName();
                        age1=students.get(f).getAge();
                        paduan3=true;
                    }
                    }
                xuigaihouStu.setStuName(name1);
                xuigaihouStu.setAge(age1);
                xuigaihouStu.setId(id1);
                xuigaihouStu.setSex(sex1);
                saveStu(xuigaihouStu);
                saveList("D:\\student\\studentmanage.txt");


               /* System.out.println("1、继续修改，2退出程序");
                int ageMo3 = scanner.nextInt();
                opStu(ageMo3);*/
                break;
            case 4:
                System.out.println("请输入你要修改的学生性别");
                boolean paduan4 = false;
                String sexStu= scanner.next();
                for(int f = 0;f<students.size();f++){
                    if(sexStu.equals(students.get(f).getSex())){

                        paduan4=true;
                    }
                }
                if(!paduan4){
                    System.out.println("没有找到你要的学生");
                    opritionMenu();
                    return;
                }
                System.out.println("*****************************");
                System.out.println("*****                   *****");
                System.out.println("*****    1、修改ID修改    *****");
                System.out.println("*****    2、修改年龄  *****");
                System.out.println("*****    3、修改姓名   *****");
                System.out.println("*****    4、修改姓别    *****");
                System.out.println("*****                   *****");
                System.out.println("*****************************");
                int ageModifile4 = scanner.nextInt();
                for(int f = 0;f<students.size();f++){
                    if(sexStu.equals(students.get(f).getSex())){
                        switch(ageModifile4){
                            case 1:
                                System.out.println("请输入ID");
                                String strId1= scanner.next();
                                students.get(f).setId(strId1);
                                break;
                            case 2:
                                System.out.println("请输入年龄");
                                int strId2= scanner.nextInt();
                                students.get(f).setAge(strId2);

                                break;
                            case 3:
                                System.out.println("请输入姓名");
                                String strId3= scanner.next();
                                students.get(f).setStuName(strId3);

                                break;
                            case 4:
                                System.out.println("请输入性别");
                                String strId4= scanner.next();
                                students.get(f).setStuName(strId4);
                                break;
                    }
                        id1= students.get(f).getId();
                        sex1=students.get(f).getSex();
                        name1=students.get(f).getStuName();
                        age1=students.get(f).getAge();
                        paduan4=true;
                    }
                }
                xuigaihouStu.setStuName(name1);
                xuigaihouStu.setAge(age1);
                xuigaihouStu.setId(id1);
                xuigaihouStu.setSex(sex1);
                saveStu(xuigaihouStu);
                saveList("D:\\student\\studentmanage.txt");


                /*System.out.println("1、继续修改，2退出程序");
                int ageMo4 = scanner.nextInt();
                opStu(ageMo4);*/
                break;
                }
        }

    public static void opStu(int i) throws FileNotFoundException {
        switch(i){
            case 1:
                System.out.println("*****************************");
                System.out.println("*****                   *****");
                System.out.println("*****    1、按ID修改    *****");
                System.out.println("*****    2、按年龄修改    *****");
                System.out.println("*****    3、按姓名修改    *****");
                System.out.println("*****    4、按姓别修改    *****");
                System.out.println("*****                   *****");
                System.out.println("*****************************");
                int paramStuFind = scanner.nextInt();
                opritionStu(paramStuFind);
                break;
            case 2:
                System.out.println("欢迎使用修改~~");
                break;


        }

}}