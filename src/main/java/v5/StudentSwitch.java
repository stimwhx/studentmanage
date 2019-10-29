package v5;

import java.util.Scanner;

public class StudentSwitch {
    private static Scanner scanner = new Scanner(System.in);
    //选择查询
    public static void findStuSwitch(int i){

        switch (i){
            case 1:
                System.out.println("请输入你要查询的学生姓名");
                String stuName = scanner.next();
                StudentDataDao.getNameStu(stuName);
                break;
            case 2:
                System.out.println("请输入你要查询的学生性别");
                String stuSex = scanner.next();
                StudentDataDao.getStuBySex(stuSex);
                break;
            case 3:
                System.out.println("请输入你要查询的学生ID");
                int id = scanner.nextInt();
                StudentDataDao.getIdStu(id);
                break;
            case 4:
                System.out.println("请输入你要查询的学生年龄");
                int age = scanner.nextInt();
                StudentDataDao.getAgeStu(age);
                break;
            case 5:
                StudentDataDao.getAll();
        }
    }
    public static void deleStu(int i ){
        switch (i){
            case 1:
                System.out.println("请输入要删除的ID");
                int id = scanner.nextInt();
                StudentDataDao.deleteStuById(id);
                break;
            case 2:
                System.out.println("请输入要删除的年龄");
                int age = scanner.nextInt();
                StudentDataDao.deleteStuByAge(age);
                break;
            case 3:
                System.out.println("请输入要删除的姓名");
                String  name = scanner.next();
                StudentDataDao.deleteStuByName(name);
                break;
            case 4:
                System.out.println("请输入要删除的性别");
                String  sex = scanner.next();
                StudentDataDao.deleteStuBySex(sex);
                break;
        }

    }
    public static void upStu(int i){
        switch(i){
            case 1:

                System.out.println("请输入ID");
                int id = scanner.nextInt();
                System.out.println("请输入姓名");
                String name = scanner.next();
                StudentDataDao.updataStuByName(id,name);
                break;
            case 2:
                System.out.println("请输入ID");
                int idSex = scanner.nextInt();
                System.out.println("请输入性别");
                String strSex = scanner.next();
                StudentDataDao.updataStuBySex(idSex,strSex);
                break;
            case 3:
                System.out.println("请输入ID");
                int idAge = scanner.nextInt();
                System.out.println("请输入性别");
                int ageInt = scanner.nextInt();
                StudentDataDao.updataStuByAge(idAge,ageInt);
                break;
            case 4:
                System.out.println("请输入ID");
                int idall= scanner.nextInt();
                System.out.println("请输入name");
                String strName = scanner.next();
                System.out.println("请输入sex");
                String sexStu = scanner.next();
                System.out.println("请输入age");
                int ageI = scanner.nextInt();
                StudentDataDao.updataStuByAll(idall,strName,sexStu,ageI);


        }
    }
}
