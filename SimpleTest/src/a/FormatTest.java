package a;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatTest {
	public static void main(String[] args) {
		int x = 1000;
		
		NumberFormat arabic = NumberFormat.getInstance(new Locale("ar", "UE"));		
		System.out.println(arabic.format(x));
		
		NumberFormat curr = NumberFormat.getCurrencyInstance(new Locale("ar", "SY"));		
		System.out.println(curr.format(x));
		
		LocalDate date = LocalDate.of(2017, 2, 21);		
		System.out.println(date.getMonthValue());
		System.out.println(date.getMonth());
		
		date = LocalDate.of(2017, Month.FEBRUARY, 21);		
		System.out.println(date.getMonthValue());
		System.out.println(date.getMonth());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		System.out.println(LocalDateTime.now().format(dtf));
		System.out.println(LocalDate.now().format(dtf));
		System.out.println(LocalTime.now().format(dtf));
	}
}
