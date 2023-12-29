package _000.examples;
import java.util.Arrays;
import java.util.TimeZone;

//Europe/London
//Australia/Perth

public class TimeZoneDemo {
	public static void main(String[] args) {
		String[] tzs = TimeZone.getAvailableIDs();
		for(String s : tzs) {
			Arrays.sort(tzs);
			System.out.println(s);
		}
	}
}
