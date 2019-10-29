package v1;

import java.io.*;

public class Student {
    private int id;
    private String stuName;
    private String sex;
    private int age;
    public Student(){}
    public Student(int id,String stuName,int age,String sex){
        this.id=id;
        this.age=age;
        this.sex=sex;
        this.stuName=stuName;
    }
    public void setStuName(String name){
        this.stuName=name;
    }

    public String getStuName(){
        return this.stuName;
    }
    public void setSex(String sex1){
        this.sex=sex1;
    }
    public String getSex(){
        return this.sex;
    }
    public void setId(int id1){
        this.id=id1;
    }
    public int getId(){
        return this.id;
    }
    public void setAge(int age1){
        this.age=age1;
    }
    public int getAge(){
        return this.age;
    }
    public boolean equals(Student s){
        if(this.stuName.equals(s.getStuName())&&this.sex.equals(s.sex)&&(this.id==s.getId())&&(this.age==s.getAge())){
            return true;
        }
        return false;


    }
    public boolean compare(Student stu){
        if(stu==null){
            return false;
        }
        if(this==stu){return true;}else{return false;}


    }
    public String toString(){
        return " 姓名："+stuName+" 年龄："+age+" 性别："+sex+"  ID:"+id;
    }
    public String switchInputStringToStriong(InputStream inputStream) throws IOException {
        InputStream in = inputStream;
        Reader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        if((temp=bufferedReader.readLine())!=null){
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
