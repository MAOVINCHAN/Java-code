package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertiesUtils {
    private static DBPropertiesUtils dbPropertiesUtils;
    private Properties properties;
    private DBPropertiesUtils() {
        try {
            properties = new Properties();
            InputStream ras = DBPropertiesUtils.class.getResourceAsStream("jdbc.properties");
            properties.load(ras);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DBPropertiesUtils getDbPropertiesUtils() {
        if(dbPropertiesUtils == null) {
            dbPropertiesUtils = new DBPropertiesUtils();
        }
        return dbPropertiesUtils;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
