import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
		
		System.out.println(date.format(DateTimeFormatter.ISO_DATE));
		//System.out.println(date.format(DateTimeFormatter.ISO_TIME));		//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: HourOfDay
		//System.out.println(date.format(DateTimeFormatter.ISO_DATE_TIME));	//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: HourOfDay
	
		//System.out.println(time.format(DateTimeFormatter.ISO_DATE));		//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: Year
		System.out.println(time.format(DateTimeFormatter.ISO_TIME));
		//System.out.println(time.format(DateTimeFormatter.ISO_DATE_TIME));	//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: Year
	
		System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		
		
		
		DateTimeFormatter shortDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter shortTime= DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		
		System.out.println(date.format(shortDate));
		//System.out.println(date.format(shortTime));						//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: ClockHourOfAmPm
		//System.out.println(date.format(shortDateTime));					//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: ClockHourOfAmPm
		
		//System.out.println(time.format(shortDate));						//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: MonthOfYear
		System.out.println(time.format(shortTime));						
		//System.out.println(time.format(shortDateTime));					//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: MonthOfYear
		
		System.out.println(dateTime.format(shortDate));
		System.out.println(dateTime.format(shortTime));					
		System.out.println(dateTime.format(shortDateTime));
		
		System.out.println(shortDate.format(date));
		//System.out.println(shortDate.format(time));						//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: MonthOfYear				
		System.out.println(shortDate.format(dateTime));
		
		//System.out.println(shortTime.format(date));						//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: ClockHourOfAmPm
		System.out.println(shortTime.format(time));
		System.out.println(shortTime.format(dateTime));
		
		//System.out.println(shortDateTime.format(date));					//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: ClockHourOfAmPm	
		//System.out.println(shortDateTime.format(time));					//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: MonthOfYear
		System.out.println(shortDateTime.format(dateTime));		
	}
}
