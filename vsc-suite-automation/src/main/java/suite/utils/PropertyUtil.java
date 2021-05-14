package suite.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	
	private String username;
	private String password;
	Properties prop = new Properties();
	String projectPath = System.getProperty("user.dir");
	
		public String  getPropertiesUsername() {
		try {
		InputStream input = new FileInputStream(projectPath+"/src/test/java/suite/config/config.properties");
		prop.load(input);
		String username = 	prop.getProperty("username");	
		return username;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return username;
	}
	public String  getPropertiesPassword() {
		try {
		InputStream input = new FileInputStream(projectPath+"/src/test/java/suite/config/config.properties");
		prop.load(input);
		String password = 	prop.getProperty("password");
		return password;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return password;
	}
	
	 public String  getProperties(String key) {
			try {
			InputStream input = new FileInputStream(projectPath+"/src/test/java/suite/config/config.properties");
			prop.load(input);
			//String username = 	prop.getProperty("username");	
			return key;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				e.printStackTrace();
			}
			return key;
		}

	
	
	
	
	}
	

	