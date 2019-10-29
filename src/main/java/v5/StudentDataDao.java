package v5;

import java.sql.*;

public class StudentDataDao {

   private static ConnectUtil connectUtil;
   private static Connection connection;
  private static   PreparedStatement sqlStatement = null;
  private static  ResultSet resultSet = null;

  private static Connection getConnection() {
      if (connectUtil == null) {
          connectUtil = new ConnectUtil();
      }

      if (connection == null) {
          connection = connectUtil.getConnection();
      }
      return connection;
  }
    //对学生的查询操作
    //查询全部
    public static void getAll(){
        String strsql = "select * from student";
        try {
            sqlStatement = getConnection().prepareStatement(strsql);
            resultSet = sqlStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(4)+"  "+resultSet.getString(3)+"  "+resultSet.getString(2)+"  "+resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    //按姓名查询学生
    public static void getNameStu(String stuName){
        String strName ="select * from student where name = ?";
        String [] strPara = {stuName};

        try {

            sqlStatement = getConnection().prepareStatement(strName);
            sqlStatement.setString(1,stuName);
            resultSet = sqlStatement.executeQuery();
            //System.out.println("这是执行的sql语句"+sqlStatement);
            //System.out.println(resultSet.toString());
            while(resultSet.next()){
                System.out.println(resultSet.getInt(4)+"  "+resultSet.getString(3)+"  "+resultSet.getString(2)+"  "+resultSet.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    //按性别查询
    public static void getStuBySex(String sex){
        String sexSql = "select * from student where sex = ?";
        try {
            sqlStatement = getConnection().prepareStatement(sexSql);
            sqlStatement.setString(1,sex);
            resultSet=sqlStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("result: " + resultSet.getInt(4)+"  "+resultSet.getString(3)+"  "+resultSet.getString(2)+"  "+resultSet.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql exception");
        } finally {

        }

    }
    //按ID查询
    public static void getIdStu(int i){
        String idSql = "select * from student where id="+i;
        try {
            sqlStatement = getConnection().prepareStatement(idSql);
            resultSet = sqlStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(4)+"  "+resultSet.getString(3)+"  "+resultSet.getString(2)+"  "+resultSet.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //按钮age查询学生
    public static void getAgeStu(int i){
        String ageSql = "select * from student where age="+i;
        try {
            sqlStatement = getConnection().prepareStatement(ageSql);
            resultSet = sqlStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt(4)+"  "+resultSet.getString(3)+"  "+resultSet.getString(2)+"  "+resultSet.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    //关闭连接的资源
    public static void closes(){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(sqlStatement!=null){
            try {
                sqlStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //添加学生
    public static void addStu(Student student){
      String addSql = "insert into student (id,name,sex,age) VALUES(?,?,?,?)";
        try {
            sqlStatement = getConnection().prepareStatement(addSql);
            sqlStatement.setInt(1,student.getId());
            sqlStatement.setString(2,student.getName());
            sqlStatement.setString(3,student.getSex());
            sqlStatement.setInt(4,student.getAge());
            //System.out.println(sqlStatement);
            sqlStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //根据ID进行删除
    public static void deleteStuById(int id){
      String deleStr = "delete from student where id=?";
        try {
            sqlStatement=getConnection().prepareStatement(deleStr);
            sqlStatement.setInt(1,id);
            sqlStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //根据年龄进行删除
    public static void deleteStuByAge(int age){
        String deleStrAge = "delete from student where age=?";
        try {
            sqlStatement=getConnection().prepareStatement(deleStrAge);
            sqlStatement.setInt(1,age);
            sqlStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //按姓名删除
    public static void deleteStuByName(String name){
        String deleStrName = "delete from student where name =?";
        try {
            sqlStatement=getConnection().prepareStatement(deleStrName);
            sqlStatement.setString(1,name);
            sqlStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //按性别删除
    public static void deleteStuBySex(String sex){
        String deleStrSex = "delete from student where sex =?";
        try {
            sqlStatement=getConnection().prepareStatement(deleStrSex);
            sqlStatement.setString(1,sex);
            sqlStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //修改学生全部信息
   public static void updataStuByAll(int id,String strName,String sex,int age){
      String upStr="update student set name =?,age=?,sex=? where id=?";
       try {
           sqlStatement=getConnection().prepareStatement(upStr);
           sqlStatement.setString(1,strName);
           sqlStatement.setInt(2,age);
           sqlStatement.setString(3,sex);
           sqlStatement.setInt(4,id);
           sqlStatement.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   //按ID修改学生姓名
   public static void updataStuByName(int id,String strName){
       String upStr="update student set name =? where id=?";
       try {
           sqlStatement=getConnection().prepareStatement(upStr);
           sqlStatement.setString(1,strName);
           sqlStatement.setInt(2,id);
           sqlStatement.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   //按ID修改学生性别
   public static void updataStuBySex(int id,String sex){
       String upStr="update student set sex =? where id=?";
       try {
           sqlStatement=getConnection().prepareStatement(upStr);
           sqlStatement.setString(1,sex);
           sqlStatement.setInt(2,id);
           sqlStatement.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   //按钮ID修改学生年龄
   public static void updataStuByAge(int id,int age){
       String upStr="update student set age =? where id=?";
       try {
           sqlStatement=getConnection().prepareStatement(upStr);
           sqlStatement.setInt(1,age);
           sqlStatement.setInt(2,id);
           sqlStatement.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
