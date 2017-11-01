import java.time.*;

public class PeriodDuration {
	public static void main(String[] args) {
		Duration hms = Duration.ofHours(1);
		System.out.println(hms);			//Prints: PT1H
		
		hms = hms.plusMinutes(1);
		System.out.println(hms);			//Prints: PT1H1M
		
		hms = hms.plusMillis(1);
		System.out.println(hms);			//Prints: PT1H1M0.001S
		
	}
}
