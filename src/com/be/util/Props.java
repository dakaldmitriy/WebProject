package com.be.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {

    private Properties prop;

    public Props() {
        prop = new Properties();
    }

    public String getProperty(String propName) {
        try {
            prop.load(new FileInputStream("src/config/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(propName);
    }
}
