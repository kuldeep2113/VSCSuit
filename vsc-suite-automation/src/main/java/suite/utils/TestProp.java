package suite.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

 

 

public class TestProp {

	private String username;
	private String password;
	Properties prop = new Properties();
	String projectPath = System.getProperty("user.dir");

    private static final String PROPERTIES_FILE = "/src/test/java/suite/config/test.properties";
    private static Properties properties = new Properties();

 

    /**
     * static method to get Instance of class AutProperties
     * @return
     */
    public static TestProp getInstance() {
        final TestProp me = new TestProp();
        me.loadProperties(me.getPropertiesFile());
        return me;
    }

 

    /**
     * Step 1
     *
     * Get the Property file as input stream
     * @return
     */
    private InputStream getPropertiesFile() {
        return this.getClass().getResourceAsStream(PROPERTIES_FILE);
    }

 

    /**
     * Step 2
     *
     * Load Properties
     * @param propertiesStream
     */
    private void loadProperties(InputStream propertiesStream) {
        try {
            properties.load(propertiesStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

 

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

 

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
    
    
    public String  getProperties(String key) {
		try {
		InputStream input = new FileInputStream(projectPath+"/src/test/java/suite/config/test.properties");
		prop.load(input);
		//String username = 	prop.getProperty("username");	
	//	return getProperties(key);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return getProperties(key);
	}

}

