package ch02._03_anno._02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
        
// 本範例展示如何對屬性使用@Autowired

//本類別的Bean id為messageToFile
@Component("messageToFile")
public class SendMessageToFile implements IRegard {
	// 注意：沒有對應的Setter
	// 下列的@Autowire會尋找id為message的Bean來注入
	@Autowired
	private String message;

	File folder;
	
	// 下列的@Autowired會尋找型態為File的Bean來注入	
	@Autowired  	
	public void setFolder(File folder) {
		this.folder = folder;
	}

	// 下列的@Autowired會尋找id為filename的Bean來注入	
	@Autowired
	String filename;
	
	public SendMessageToFile() {
		System.out.println("in SendMessageToFile(用在屬性上) <init>()");
	}
	
	@Override
	public void sayHello() {
		if (!folder.exists()) {
			folder.mkdirs();
		}
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