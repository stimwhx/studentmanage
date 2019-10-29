package v4;


import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","王洪晓");
        jsonObject.put("int",2);
        jsonObject.put("boolean",true);
        List<Integer> integers = Arrays.asList(1,2,3,4);
        jsonObject.put("list",integers);
        jsonObject.put("null",null);
        System.out.println(jsonObject);
        String strJSONObject = jsonObject.toJSONString();
        System.out.println("json转数组"+strJSONObject);
        JSONObject jsonObject1 = JSONObject.parseObject(strJSONObject);
        System.out.println("从字符串中解析JSON"+jsonObject1);
        String str = jsonObject.getString("name");
        System.out.println("从json中拿字符串"+str);
        int i = jsonObject.getIntValue("int");
        System.out.println("从json中拿int"+i);
        boolean b = jsonObject.getBoolean("boolean");
        System.out.println("boolean"+b);
        List<Integer> integers1 = JSONObject.parseArray(jsonObject.getJSONArray("list").toJSONString(),Integer.class);



    }
}
