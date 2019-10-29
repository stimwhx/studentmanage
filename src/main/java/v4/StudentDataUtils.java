package v4;

import v2.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataUtils {

    private static List<Student> students = new ArrayList<Student>();

    public static List<Student> getStudents() {
        return students;
    }

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
    public static void getStudentsByFile(String pathFile){
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
}
