package config;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.NotFoundException;

import org.jboss.logging.Logger;


public class PropertiesReader {
	
	private static final Logger LOGGER = Logger.getLogger( PropertiesReader.class.getName() );
	
	//SINGLETON (currently not used)
	private static PropertiesReader _INSTANCE;
	
	public static PropertiesReader getInstance() throws NotFoundException {
			return new PropertiesReader();
	}
	
	
	private PropertiesReader() throws NotFoundException {
		this.readProperties();
	}
	
	private Properties properties;
	
	public Properties getProperties(){
		return this.properties;
	}
	
	private void readProperties() throws NotFoundException{
		try {
			String arquivo = System.getProperty("properties.file");
			LOGGER.info("Properties File: " + arquivo);
			InputStream inputStream = arquivo != null ? new FileInputStream(new File (arquivo)) : this.getClass().getResourceAsStream("rh-senior-service.properties");
			properties = new Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			throw new NotFoundException("Error Reading Properties File: ["+e.getMessage()+"]", e);
		}
	}

}