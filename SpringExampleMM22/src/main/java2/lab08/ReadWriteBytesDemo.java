package lab08;
/*
   本程式展示如何由輸入檔一次讀入一個位元組陣列，然後此將位元組陣列寫出到輸出檔，
   為傳統Java程式的寫法。 請以SpringFramework 的風格來改寫本程式。
       
     請以組態檔來定義需要受Spring IoC容器控管的Java物件。
      改寫步驟 : 
   1. 新建組態檔，利用<Bean>標籤定義兩個表示輸入檔與輸出檔之File類別的物件。 另外還要
             利用<Bean>標籤定義java.io.FileInputStream與java.io.FileOutputStream類別的物件。
                             
   2. 修改main方法，建立Spring IoC容器後，經由它的getBean()來取得 IoC容器控管的Java物件，
             然後執行相關的方法。   
   
*/
import java.io.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadWriteBytesDemo {
	public static void main(String[] args) throws IOException {
		long s = 0, e = 0;
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("lab08/Beans.xml");
		InputStream fis = ctx.getBean(InputStream.class);
		OutputStream fos = ctx.getBean(OutputStream.class);
		try {
			System.out.println("每次讀/寫8192個位元組");
			s = System.currentTimeMillis();
			// 以下五行必須記憶
			int len = 0;
			byte[] b = new byte[8192];
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			e = System.currentTimeMillis();
			System.out.println("時間差(每次讀/寫多個位元組)=" + (e - s));
		} finally {
			fis.close();
			fos.close();
		} 
		((ConfigurableApplicationContext)ctx).close();
	}
}