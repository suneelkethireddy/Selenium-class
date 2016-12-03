package testcase;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
public class SendingEmails {

	static InputStream input=null;
	static Properties prop=null;

	public String userId1, userId2,pass1,pass2;
	public  void main (String args[]){
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (input != null) {
				prop.load(input);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			// get the property value and print it out
			userId1 = prop.getProperty("EmailId1");
			pass1 = prop.getProperty("password1");
			userId2 = prop.getProperty("EmailId2");
			pass2 = prop.getProperty("password2");
		}catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}




