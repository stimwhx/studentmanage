package v5;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesUtil {
    //private static Properties properties;
    static ResourceBundle bundle;
    public static boolean loadFile(String filename){
       // properties = new Properties();
        bundle = ResourceBundle.getBundle(filename);
        System.out.println(bundle);

//            System.out.println(PropertiesUtil.class.getResourceAsStream(filename));
//            properties.load(PropertiesUtil.class.getResourceAsStream(filename));


        return true;
    }
    public static String getPropertiesValue(String key){
//      return  properties.getProperty(key);
        return bundle.getString(key);
    }
}
