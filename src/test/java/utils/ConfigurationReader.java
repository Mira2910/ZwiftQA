package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties;

    public static void readFile(String fileName){

        String path = "src\\test\\resources\\"+fileName+".properties";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static String getProperty(String fileName, String key) {
        readFile(fileName);
        return properties.getProperty(key);

    }


}
