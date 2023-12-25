package ch02._03_anno._03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//本範例說明如何建構子使用@Autowired          
//本類別的Bean id為toDisk
@Component("toDisk")
//本類別的範圍為prototype
@Scope("prototype")
public class WriteReportToStorage implements Report {
	private String message;
	private File folder;
	private String filename;
	
	//對Constructor採用@Autowired時，參數名稱非常非常重要，Spring會依參數名稱來注入資料
	@Autowired
	public WriteReportToStorage(File folder, String filename, String message) {
		System.out.println("in WriteReportToStorage, 用在三個參數的建構子上 (File, String, String)");
		this.folder = folder;
		this.filename = filename;
		this.message = message;
		if (!folder.exists()) folder.mkdirs();
	}

	@Override
	public void sayHello() {
		File file = new File(folder, filename);
		try (
			PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		) 
		{
			pw.println(message);
			System.out.println(message);
		} catch (IOException e) {
			System.out.println("發生錯誤: " + e.getMessage());
		}
	}
}

