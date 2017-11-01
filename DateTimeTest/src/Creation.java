import java.time.*;


public class Creation {
	static ZoneId zoneId = ZoneId.of("Pacific/Kiritimati");
	
	public static void main(String[] args) {
		//LocalDate
		
		//Instantiation
//		LocalDate localDate = new LocalDate();		//The constructor LocalDate() is undefined
		
		//public static LocalDate now()
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);				//Prints: 2017-10-30
		
		//public static LocalDate now(ZoneId zone)
		localDate = LocalDate.now(zoneId);
		System.out.println(localDate); 				//Prints: 2017-10-31
		
		//public static LocalDate of(int year, int month, int dayOfMonth)
		localDate = LocalDate.of(2017, 10, 30);
		System.out.println(localDate);				//Prints: 2017-10-30
//		localDate = LocalDate.of(2017, 10, 0);		//java.time.DateTimeException: Invalid value for DayOfMonth (valid values 1 - 28/31)
//		localDate = LocalDate.of(2017, 0, 1);		//java.time.DateTimeException: Invalid value for MonthOfYear (valid values 1 - 12)
		localDate = LocalDate.of(0, 1, 1);
		System.out.println(localDate); 				//Prints: 0000-01-01
		localDate = LocalDate.of(-1, 1, 1);
		System.out.println(localDate); 				//Prints: -0001-01-01
		localDate = LocalDate.of(10000, 1, 1);
		System.out.println(localDate); 				//Prints: +10000-01-01
//		localDate = LocalDate.of(2020, 2, 30);		//Exception in thread "main" java.time.DateTimeException: Invalid date 'FEBRUARY 30'
		localDate = LocalDate.of(2020, 2, 29);
		System.out.println(localDate); 				//Prints: 2020-02-29
//		localDate = LocalDate.of(2021, 2, 29);		//Exception in thread "main" java.time.DateTimeException: Invalid date 'February 29' as '2021' is not a leap year
		localDate = LocalDate.of(2021, 2, 28);	
		System.out.println(localDate); 				//Prints: 2020-02-28
				
		//public static LocalDate of(int year, Month month, int dayOfMonth)
		localDate = LocalDate.of(2017, Month.OCTOBER, 30);
		System.out.println(localDate);				//Prints: 2017-10-30
		
		
		
		
		//LocalTime
		
		//Instantiation
//		LocalTime localTime = new LocalTime();		//2017-10-30T13:15:20.999999999
		
		//public static LocalTime now()
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);				//Prints: 15:06:09.832
		
		localTime = LocalTime.now(zoneId) ;			
		System.out.println(localTime);				//Prints: 01:06:09.832
		
		//static LocalTime	of(int hour, int minute)
		localTime = LocalTime.of(13, 15);
		System.out.println(localTime); 				//Prints: 13:15
//		localTime = LocalTime.of(24, 15);			//Exception in thread "main" java.time.DateTimeException: Invalid value for HourOfDay (valid values 0 - 23)
//		localTime = LocalTime.of(13, 60);			//Exception in thread "main" java.time.DateTimeException: Invalid value for MinuteOfHour (valid values 0 - 59)
				
		//static LocalTime	of(int hour, int minute, int second)
		localTime = LocalTime.of(13, 15, 20);
		System.out.println(localTime);				//Prints: 13:15:20
		
		//static LocalTime	of(int hour, int minute, int second, int nanoOfSecond)
		localTime = LocalTime.of(13, 15, 20, 400000000);
		System.out.println(localTime);				//Prints: 13:15:20.400
		localTime = LocalTime.of(13, 15, 20, 400500000);
		System.out.println(localTime);				//Prints: 13:15:20.400500
		localTime = LocalTime.of(13, 15, 20, 400500600);
		System.out.println(localTime);				//Prints: 13:15:20.400500600
//		localTime = LocalTime.of(13, 15, 20, 1000000000);	//Exception in thread "main" java.time.DateTimeException: Invalid value for NanoOfSecond (valid values 0 - 999999999)
		localTime = LocalTime.of(13, 15, 20, 999999999);
		System.out.println(localTime);				//Prints: 13:15:20.999999999
		
		
		
		
		//LocalDateTime
		
		//Instantiation
//		LocalDateTime localDateTime = new LocalDateTime();	//2017-10-30T13:15:20.999999999
		
		//static LocalDateTime	now()
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime); 			//Prints: 2017-10-30T15:17:40.296
		
		//static LocalDateTime	now(ZoneId zone)
		localDateTime = LocalDateTime.now(zoneId);
		System.out.println(localDateTime); 			//Prints: 2017-10-31T01:19:25.581
		
		//static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute)
		localDateTime = LocalDateTime.of(2017, 10, 30, 16, 10);
		System.out.println(localDateTime); 			//Prints: 2017-10-30T16:10
		
		//static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second)
		localDateTime = LocalDateTime.of(2017, 10, 30, 16, 10, 20);
		System.out.println(localDateTime); 			//2017-10-30T16:10:20
		
		//static LocalDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)
		localDateTime = LocalDateTime.of(2017, 10, 30, 16, 10, 20, 400000000);
		System.out.println(localDateTime); 			//2017-10-30T16:10:20.400
		localDateTime = LocalDateTime.of(2017, 10, 30, 16, 10, 20, 999999999);
		System.out.println(localDateTime); 			//2017-10-30T16:10:20.999999999
		
		//static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute)
		localDateTime = LocalDateTime.of(2017, Month.OCTOBER, 30, 16, 10);
		System.out.println(localDateTime); 			//Prints: 2017-10-30T16:10
		
		//static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute, int second)
		localDateTime = LocalDateTime.of(2017, Month.OCTOBER, 30, 16, 10, 20);
		System.out.println(localDateTime); 			//2017-10-30T16:10:20
		
		//static LocalDateTime	of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)
		localDateTime = LocalDateTime.of(2017, Month.OCTOBER, 30, 16, 10, 20, 400000000);
		System.out.println(localDateTime); 			//2017-10-30T16:10:20.400
		
		//static LocalDateTime	of(LocalDate date, LocalTime time)
		System.out.println(localDate);				//Prints: 2017-10-30
		System.out.println(localTime);				//Prints: 13:15:20.999999999
		localDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println(localDateTime);			//Prints: 2017-10-30T13:15:20.999999999
		
	
		
		
		//ZonedDateTime
		
		//Instantiation
//		ZonedDateTime zonedDateTime = new ZonedDateTime();	//2017-10-30T13:15:20.999999999
		
		//static ZonedDateTime	now()
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime); 			//2017-10-30T16:18:08.406+04:00[Asia/Muscat]
		
		//static ZonedDateTime	now(ZoneId zone)
		zonedDateTime = ZonedDateTime.now(zoneId);
		System.out.println(zonedDateTime); 			//2017-10-31T02:19:49.455+14:00[Pacific/Kiritimati]
				
		//static ZonedDateTime	of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond, ZoneId zone)
		zonedDateTime = ZonedDateTime.of(2017, 10, 30, 16, 22, 0, 0, zoneId);
		System.out.println(zonedDateTime);			//Prints: 2017-10-30T16:22+14:00[Pacific/Kiritimati]
		zonedDateTime = ZonedDateTime.of(2017, 10, 30, 16, 22, 15, 0, zoneId);
		System.out.println(zonedDateTime);			//Prints: 2017-10-30T16:22:15+14:00[Pacific/Kiritimati]
		zonedDateTime = ZonedDateTime.of(2017, 10, 30, 16, 22, 15, 400000000, zoneId);
		System.out.println(zonedDateTime);			//Prints: 2017-10-30T16:22:15.400+14:00[Pacific/Kiritimati]
		zonedDateTime = ZonedDateTime.of(2017, 10, 30, 16, 22, 15, 999999999, zoneId);
		System.out.println(zonedDateTime);			//Prints: 2017-10-30T16:22:15.999999999+14:00[Pacific/Kiritimati]
				
		//static ZonedDateTime	of(LocalDate date, LocalTime time, ZoneId zone)
		System.out.println(localDate);				//Prints: 2017-10-30
		System.out.println(localTime);				//Prints: 13:15:20.999999999
		zonedDateTime = ZonedDateTime.of(localDate, localTime, zoneId);
		System.out.println(zonedDateTime);			//Prints: 2017-10-30T13:15:20.999999999+14:00[Pacific/Kiritimati]
		
		//static ZonedDateTime	of(LocalDateTime localDateTime, ZoneId zone)
		System.out.println(localDateTime); 			//Prints: 2017-10-30T13:15:20.999999999
		zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		System.out.println(zonedDateTime);			//Prints: 2017-10-30T13:15:20.999999999+14:00[Pacific/Kiritimati]
		
	}
}
