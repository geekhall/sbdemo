package cn.geekhall.sbdemo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Utils
 *
 * @author yiny
 */
public class Util {
    public static void getProperties() throws IOException {
        System.out.println("-------------------------");
        Properties pps = new Properties();
        pps.load(new FileInputStream("src/config.properties"));
        Enumeration properties = pps.propertyNames(); // 得到配置文件的名字

        while (properties.hasMoreElements()) {
            String key = (String) properties.nextElement();
            String value = pps.getProperty(key);
            System.out.println("----------");
            System.out.println(key);
            System.out.println(value);
            System.out.println("----------");
        }
        System.out.println("-------------------------");
    }
    public static void main(String[] args) {
        try {
            Util.getProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
