package ch02._03_anno._01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
// 本範例對實例變數使用@Autowired        
// 本類別的Bean id為toFile
// 效果等同 組態檔內的  <bean id='toFile' ..../>
@Component("toFile")
@Scope("singleton")                
public class SendLogToFile implements Event {
	@Autowired
	private String message;   // Hello, 大家好(toFile)
 
	File folder;   
	@Autowired
	String filename;   // message.txt;
	public SendLogToFile() {
		System.out.println("在 SendLogToFile類別的預設建構子中...");
	}
	@Autowired
	@Qualifier("folderA")
	public void setFolder(File folder) {   // C:\_spring\data01
		this.folder = folder;
		if (!folder.exists()) {
			folder.mkdirs();
		} 
	}

	@Override
	public void writeLog() {
		File file = new File(folder, filename); // C:\_spring\data01\message.txt
		try (PrintWriter pw = new PrintWriter(new FileWriter(file, true));) {
			pw.println(message);   // Hello, 大家好(toFile)
			System.out.println("已經將資料寫入檔案..." + message);
		} catch (IOException e) {
			System.out.println("發生錯誤: " + e.getMessage());
		}
	}
}