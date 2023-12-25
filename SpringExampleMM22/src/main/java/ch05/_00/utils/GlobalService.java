package ch05._00.utils;

import java.util.ArrayList;
import java.util.List;

import ch05.ex00.entity.Member;

public class GlobalService {
	static private List<Member> members = new ArrayList<Member>();
    
	static String dbType = "M"; 
//	static String dbType = "S"; 
	
	public static List<Member> getMembers() {
		return members;
	}

	public static void setMembers(List<Member> members) {
		GlobalService.members = members;
	}

	public String getDbType() {
		return dbType;
	}

}
