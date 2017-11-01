import java.time.*;
import java.time.temporal.ChronoUnit;

public class PlusMinus {
	public static void main(String[] args) {
		LocalDate localDate;
		LocalTime localTime;
		LocalDateTime localDateTime;
		ZonedDateTime zonedDateTime;
		
		//Handling overflow
		localDate = LocalDate.of(2020, 1, 15);
		System.out.println(localDate);					//Prints: 2020-01-15
		
		localDate.plusMonths(2);
		System.out.println(localDate);					//Prints: 2020-01-15
		
		localDate = localDate.plusMonths(2);
		System.out.println(localDate);					//Prints: 2020-03-15
		
		localDate = localDate.of(2020, 1, 31);			//It is a leapyear
		System.out.println(localDate);					//Prints: 2020-01-31
		localDate = localDate.plusMonths(1);
		System.out.println(localDate);					//Prints: 2020-02-29
		localDate = localDate.plusMonths(1);
		System.out.println(localDate);					//Prints: 2020-03-29
		
		localDate = localDate.of(2021, 1, 31);			//It is not a leapyear
		System.out.println(localDate);					//Prints: 2021-01-31
		localDate = localDate.plusMonths(1);
		System.out.println(localDate);					//Prints: 2020-02-28
		localDate = localDate.plusMonths(1);
		System.out.println(localDate);					//Prints: 2020-03-28
		
		localDate = LocalDate.of(2020, 1, 15);
		System.out.println(localDate);					//Prints: 2020-01-15
		localDate = localDate.plusDays(-1);
		System.out.println(localDate);					//Prints: 2020-01-14
		localDate = localDate.minusDays(-1);
		System.out.println(localDate);					//Prints: 2020-01-15
		
		
		//plus/minus for LocalDate
		//LocalDate	plusYears(long yearsToAdd)
		//LocalDate	plusMonths(long monthsToAdd)
		//LocalDate	plusWeeks(long weeksToAdd)			//equivalent to plusDays(7)
		//LocalDate	plusDays(long daysToAdd)
		//LocalDate	plus(long amountToAdd, TemporalUnit unit)
		localDate.plus(1, ChronoUnit.DAYS);
//		localDate.plus(1, ChronoUnit.SECONDS);			//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
		//LocalDate	minusYears(long yearsToSubtract)
		//LocalDate	minusMonths(long monthsToSubtract)
		//LocalDate	minusWeeks(long weeksToSubtract)	//equivalent to minusDays(7)
		//LocalDate	minusDays(long daysToSubtract)
		//LocalDate	minus(long amountToSubtract, TemporalUnit unit)
		
		
		//plus/minus for LocalTime
		//LocalTime	plusHours(long hoursToAdd)
		//LocalTime	plusMinutes(long minutesToAdd)
		//LocalTime	plusSeconds(long secondstoAdd)
		//LocalTime	plusNanos(long nanosToAdd)
		//LocalTime	plus(long amountToAdd, TemporalUnit unit)
		localTime = LocalTime.of(16, 45);
		System.out.println(localTime);					//Prints: 16:45
		localTime = localTime.plus(1, ChronoUnit.SECONDS);
		System.out.println(localTime);					//Prints: 16:45:01
		localTime = localTime.plus(1, ChronoUnit.MILLIS);
		System.out.println(localTime);					//Prints: 16:45:01.001
		localTime = localTime.plus(2000, ChronoUnit.MILLIS);
		System.out.println(localTime);					//Prints: 16:45:03.001
		localTime = localTime.plus(1, ChronoUnit.MICROS);
		System.out.println(localTime);					//Prints: 16:45:03.001001
		localTime = localTime.plus(1, ChronoUnit.NANOS);
		System.out.println(localTime);					//Prints: 16:45:03.001001001
//		localTime = localTime.plus(1, ChronoUnit.DAYS);	//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Days
		//LocalTime	minusHours(long hoursToSubtract)
		//LocalTime	minusMinutes(long minutesToSubtract)
		//LocalTime	minusSeconds(long secondsToSubtract)
		//LocalTime	minusNanos(long nanosToSubtract)
		//LocalTime	minus(long amountToSubtract, TemporalUnit unit)
		
		
		//plus/minus for LocalDateTime
		//LocalDateTime plusMonths(long monthsToAdd)
		//LocalDateTime plusWeeks(long weeksToAdd)			//equivalent to plusDays(7)
		//LocalDateTime plusDays(long daysToAdd)
		//LocalDateTime plusHours(long hoursToAdd)
		//LocalDateTime plusMinutes(long minutesToAdd)
		//LocalDateTime plusSeconds(long secondstoAdd)
		//LocalDateTime plusNanos(long nanosToAdd)
		//LocalDateTime plus(long amountToAdd, TemporalUnit unit)
		//LocalDateTime minusMonths(long monthsToAdd)
		//LocalDateTime minusWeeks(long weeksToAdd)			//equivalent to minusDays(7)
		//LocalDateTime minusDays(long daysToAdd)
		//LocalDateTime minusHours(long hoursToAdd)
		//LocalDateTime minusMinutes(long minutesToAdd)
		//LocalDateTime minusSeconds(long secondstoAdd)
		//LocalDateTime minusNanos(long nanosToAdd)
		//LocalDateTime minus(long amountToAdd, TemporalUnit unit)
	}
}
