package lab08.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:EEIT73/ch03_EEIT73.properties")

public class JavaConfig {
	@Value("${lab08.inFileName}")
	String inFileName;
	
	@Value("${lab08.outFileName}")
	String outFileName;
	
	@Bean
	public File infile() {
		File file = new File(inFileName);
		
		return file;	
	}
	@Bean
	public File outfile() {
		File file = new File(outFileName);
		
		return file;	
	}
	@Bean
	public FileInputStream fis() throws FileNotFoundException {
		FileInputStream fi = new FileInputStream(infile());	
		return fi;	
	}
	@Bean
	public FileOutputStream fos() throws FileNotFoundException {
		FileOutputStream fo = new FileOutputStream(outfile());	
		return fo;	
	}
	
}
