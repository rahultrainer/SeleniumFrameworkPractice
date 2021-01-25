package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propertyfile {
	
	public String callpropertyfile(String key, String path) throws Exception
	{
		Properties prop = new Properties();
		InputStream input = new FileInputStream(path);
		prop.load(input);
		return prop.getProperty(key);
	}
}
