package v4;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestJson {
    public static void main(String[]args){
        File file = new File("src\\main\\java\\v4\\testjsonFile.json");
        List<JsonData> jsonDataList = new ArrayList<JsonData>();

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((str=bufferedReader.readLine())!=null){
               stringBuilder.append(str);
            }
            JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for(int i =0;i<jsonArray.size();i++){
                JSONObject jsonObjectArray = JSONObject.parseObject(jsonArray.get(i).toString());
              //  System.out.println(jsonObjectArray);
                JsonData jsonData = new JsonData();
                jsonData.setId((Integer) jsonObjectArray.get("id"));
                jsonData.setName((String) jsonObjectArray.get("name"));
                jsonData.setOrder((Integer)jsonObjectArray.get("order"));
                jsonData.setCourseId((Integer)jsonObjectArray.get("courseId"));
                jsonData.setParentChapterId((Integer)jsonObjectArray.get("parentChapterId"));
                jsonData.setVisible((Integer)jsonObjectArray.get("visible"));
                jsonData.setUserControlSetTop(jsonObjectArray.getBoolean("userControlSetTop"));
               // System.out.println(jsonObjectArray.get("userControlSetTop").getClass());

                jsonDataList.add(jsonData);
                }
            }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i =0;i<jsonDataList.size();i++){
            System.out.println(jsonDataList.get(i).toString());
        }
        }
    }

