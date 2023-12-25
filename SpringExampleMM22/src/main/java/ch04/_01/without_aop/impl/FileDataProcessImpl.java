package ch04._01.without_aop.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ch04._01.without_aop.interfaces.FileDataProcess;

public class FileDataProcessImpl implements FileDataProcess {

	@Override
	public long byteStreamProcess(File in, File out) {
		long size = 0;
		try(
			FileInputStream fis = new FileInputStream(in); 
			FileOutputStream fos = new FileOutputStream(out);	
		)
		{
			byte[] b = new byte[819200];
			int len = 0 ;
			while ((len=fis.read(b))!= -1){
				fos.write(b, 0, len);
				size += len;
			}
		} 
		catch (IOException e) {
			System.out.println("發生例外：" + e);
		}
		return size;
	}

	@Override
	public long characterStreamProcess(File in, String inEncoding, File out, String outEncoding) {
		long size = 0;
		try(
			FileInputStream fis = new FileInputStream(in); 
			FileOutputStream fos = new FileOutputStream(out);
			InputStreamReader isr = new InputStreamReader(fis, inEncoding);
			OutputStreamWriter osw = new OutputStreamWriter(fos, outEncoding);		
		) {
			
			char[] b = new char[819200];
			int len = 0 ;
			while ((len=isr.read(b))!= -1){
				osw.write(b, 0, len);
				size += len;
			}
		} 
		catch (IOException e) {
			System.out.println("發生例外：" + e);
		}
		return size;
	}

}

