/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Bradley
 */
public class settings {
    
    Properties prop;
    private InputStream input = null;
    private boolean fileLocated;
    
    public void openSettingsFile()
    {
        try {
                while(!fileLocated){
                    String filename = "config.properties";
                    input = getClass().getClassLoader().getResourceAsStream(filename);
                    if (input == null)
                            createSettingsFile();
                    else { fileLocated = true; }
                }

		prop.load(input);
        } catch (IOException ex) {
	} 
        finally {
            if (input != null) {
		try {
                    input.close();
		} catch (IOException e) {
		}
            }
        }
    }
    
    private void createSettingsFile()
    {
        prop = new Properties();
	OutputStream output = null;

	try {

		output = new FileOutputStream("config.properties");

		// set the properties value
		prop.setProperty("database", "localhost");
		prop.setProperty("dbuser", "user");
		prop.setProperty("dbpassword", "password"); //Need to encrypt

		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io){ 
        } finally {
            if (output != null) {
		try {
                    output.close();
                } catch (IOException e) {
		}
            }
        }
    }
    
    public void changeSettings()
    {
        // find and change 
    }
    
    public String readSettings(String setting)
    {
        return "lol";
    }
    
}
