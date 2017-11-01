import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DurationAndPeriod {
	public static void main(String[] args) {
		System.out.println(Period.of(0, 0, 0));						//Prints: P0D
		System.out.println(Period.of(1, 0, 0));						//Prints: P1Y
		System.out.println(Period.of(0, 1, 0));						//Prints: P1M
		System.out.println(Period.of(0, 0, 1));						//Prints: P1D
		System.out.println(Period.of(1, 1, 0));						//Prints: P1Y1M
		System.out.println(Period.of(1, 0, 1));						//Prints: P1Y1D
		System.out.println(Period.of(0, 1, 1));						//Prints: P1M1D
		System.out.println(Period.of(1, 1, 1));						//Prints: P1Y1M1D
		System.out.println(Period.of(100, 100, 100));				//Prints: P100Y100M100D
		System.out.println(Period.ofYears(1));						//Prints: P1Y
		System.out.println(Period.ofMonths(1));						//Prints: P1M
		System.out.println(Period.ofWeeks(1));						//Prints: P7D
		System.out.println(Period.ofWeeks(100));					//Prints: P700D
		System.out.println(Period.ofDays(1));						//Prints: P1D
		System.out.println(Period.ofDays(100));						//Prints: P100D
		
		//System.out.println(Duration.of(1, ChronoUnit.YEARS)); 	//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unit must not have an estimated duration
		//System.out.println(Duration.of(1, ChronoUnit.MONTHS));	//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unit must not have an estimated duration
		//System.out.println(Duration.of(1, ChronoUnit.WEEKS));		//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unit must not have an estimated duration
		System.out.println(Duration.of(1, ChronoUnit.DAYS));		//Prints: PT24H	
		System.out.println(Duration.of(1, ChronoUnit.HOURS));		//Prints: PT1H
		System.out.println(Duration.of(24, ChronoUnit.HOURS));		//Prints: PT24H
		System.out.println(Duration.of(1, ChronoUnit.MINUTES));		//Prints: PT1M
		System.out.println(Duration.of(60, ChronoUnit.MINUTES));	//Prints: PT1H
		System.out.println(Duration.of(120, ChronoUnit.MINUTES));	//Prints: PT2H
		System.out.println(Duration.of(61, ChronoUnit.MINUTES));	//Prints: PT1H1M
		System.out.println(Duration.of(1, ChronoUnit.SECONDS));		//Prints: PT1S
		System.out.println(Duration.of(60, ChronoUnit.SECONDS));	//Prints: PT1M
		System.out.println(Duration.of(3600, ChronoUnit.SECONDS));	//Prints: PT1H
		System.out.println(Duration.of(3661, ChronoUnit.SECONDS));	//Prints: PT1H1M1S
		System.out.println(Duration.of(1, ChronoUnit.MILLIS));	    //Prints: PT0.0001S
		System.out.println(Duration.of(1000, ChronoUnit.MILLIS));	//Prints: PT1S
		System.out.println(Duration.of(1001, ChronoUnit.MILLIS));	//Prints: PT1.0001S
		System.out.println(Duration.of(1, ChronoUnit.NANOS));	 	//Prints: PT0.000000001S
		//System.out.println(Duration.ofYears(1));					//Compilations fails. The method ofYears(int) is undefined for the type Duration
		//System.out.println(Duration.ofMonths(1));					//Compilations fails. The method ofMonths(int) is undefined for the type Duration
		System.out.println(Duration.ofDays(1));						//Prints: PT24H
		System.out.println(Duration.ofHours(1));	 				//Prints: PT1H
		System.out.println(Duration.ofHours(100));	 				//Prints: PT100H
		System.out.println(Duration.ofMinutes(1));  				//Prints: PT1M
		System.out.println(Duration.ofMinutes(60));  				//Prints: PT1H
		System.out.println(Duration.ofMinutes(120));  				//Prints: PT2H
		System.out.println(Duration.ofMinutes(100));  				//Prints: PT1H40M		
		System.out.println(Duration.ofSeconds(1));  				//Prints: PT1S
		System.out.println(Duration.ofSeconds(100));  				//Prints: PT1M40S
		System.out.println(Duration.ofSeconds(3600));  				//Prints: PT1H
		System.out.println(Duration.ofSeconds(3661));  				//Prints: PT1H1M1S
		System.out.println(Duration.ofMillis(1));  					//Prints: PT0.0001S
		System.out.println(Duration.ofMillis(1000));	  			//Prints: PT1S
		System.out.println(Duration.ofMillis(1001));	  			//Prints: PT1.001S
		System.out.println(Duration.ofNanos(1));	  				//Prints: PT0.000000001S
		
	}
}
