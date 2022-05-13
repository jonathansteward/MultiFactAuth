package MFA_proj;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Jonathan Steward
 * This class pulls credentials from configuration file to access database or
 * send a text code to the User for login
 */
public class GetProperties {

    public String[] getPropValues(int propertyType) {
        String[] properties;
                
        if (propertyType == 0) {
            properties = new String[3];

            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {

                Properties prop = new Properties();

                if (inputStream == null) {
                    System.out.println("Unable to find config.properties");
                    return null;
                }

                // get the property value
                properties[0] = prop.getProperty("db.url");
                properties[1] = prop.getProperty("db.username");
                properties[2] = prop.getProperty("db.password");

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }

            return properties;
        }
        else{
            properties = new String[2];
            
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {

                Properties prop = new Properties();

                if (inputStream == null) {
                    System.out.println("Unable to find config.properties");
                    return null;
                }

                // get the property value
                properties[0] = prop.getProperty("twilio.ACCOUNT_SID");
                properties[1] = prop.getProperty("twilio.AUTH_TOKEN");

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }

            return properties;
        }
    }
}
