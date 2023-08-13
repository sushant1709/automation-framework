package com.dmg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static Properties props = new Properties();
    TestUtils utils = new TestUtils();

    public Properties getProps()  {
        InputStream is = null;
        String propsFileName = "config.properties";
        try{
        if(props.isEmpty()){

                utils.log().info("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            }}
            catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load config properties. ABORT!!" + e.toString());

            }

       /* finally {
            if(is != null){
                is.close();
            }
        }*/


        return props;
    }
}
