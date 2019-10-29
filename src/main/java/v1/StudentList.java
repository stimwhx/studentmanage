package v1;

import v1.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentList {
    private Student stu;
    public static int cont=0;
    public StudentList(){}
    public StudentList(Student stu){
        this.stu=stu;
    }
    List<Student> studentList = new ArrayList<Student>();
    //添加学生
    public void addStudent(Student stu){
        studentList.add(stu);
        cont++;
    }
    //删除学生
    public void deleStudent(int obj){
        for(int i =0;i<studentList.size();i++){
            if(studentList.get(i).getId()==obj){

            }
        }
    }
    //查询学生
    public boolean checkStudent(int id){
        for(int i =0;i<studentList.size();i++){
            if(studentList.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }
    //查询指定学生的信息，关键字是ID
    public String pointCheckStudentID(int id){
        for(int i =0;i<studentList.size();i++){
            if(studentList.get(i).getId()==id){
                return studentList.get(i).toString();
            }
        }
        return "没有你要找的学生";
    }
    //按性别查用户
    public List<Student> pointCheckStuSex(String str){
        List<Student> listSexMan = new ArrayList<Student>();
        List<Student> listSexWom = new ArrayList<Student>();
        for(int i =0 ;i<studentList.size();i++){
            if(studentList.get(i).getSex().equals("男")){
                listSexMan.add(studentList.get(i));
            }else if(studentList.get(i).getSex().equals("女")){
                listSexWom.add(studentList.get(i));
            }
        }
        if(str.equals("男")){
            return listSexMan;
        }else if(str.equals("女")) {
            return listSexWom;
        }
        return null;
    }
    //输出用户所有信息
    public void prinf(){
        Iterator iterator = studentList.iterator();
        while(iterator.hasNext())
        {
            Object student = iterator.next();
            System.out.println(student.toString());
        }
    }
    //按照年龄查学生
    public String pointCheckAge(int t){
        for(int i=0;i<studentList.size();i++){
            if(studentList.get(i).getAge()==t){
                System.out.println(studentList.get(i).toString());
            }
        }
        return null;
    }
//便利得到学生的姓名
    public Student findCheckName(String str){
        for(int i =0;i<studentList.size();i++){
            Student s = studentList.get(i);
            if(s.getStuName().contains(str)){}
           return s;
        }
        return null;
    }

}
