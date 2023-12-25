package lab08.solution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	@Bean
	public File inFile() {
		File file = new File("data/SamplePictures.zip");
		return file;
	}

	@Bean
	public File outFile() {
		File file = new File("data/SamplePicturesC.zip");
		return file;
	}

	@Bean
	public FileInputStream fis() {
		FileInputStream fis0 = null;
		try {
			fis0 = new FileInputStream(inFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fis0;
	}
	@Bean
	public FileOutputStream fos() {
		FileOutputStream fos0 = null;
		try {
			fos0 = new FileOutputStream(outFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fos0;
	}
	
	
	
	
	
	
	
}
