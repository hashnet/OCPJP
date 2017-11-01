package a;

import java.time.LocalDateTime;
import java.util.Locale;

public class DateTimeTest {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		
		Locale myLocale = Locale.getDefault();
		
		System.out.println(myLocale);
		
		Locale l = new Locale.Builder().setRegion("us").build();
		System.out.println(l);
		
		Locale.setDefault(l);
		
		System.out.println(Locale.getDefault());
	}
}
