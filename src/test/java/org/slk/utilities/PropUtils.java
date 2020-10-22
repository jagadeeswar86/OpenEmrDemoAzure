package org.slk.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	public static String getValueFromProperties(String path,String key) throws IOException {
		FileInputStream file = new FileInputStream(path);

		Properties pro = new Properties(); 

		pro.load(file);
       String value=pro.getProperty(key);
         return value;
	}

}
