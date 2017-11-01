import java.time.*;

public class TimeZoneFinder {
	public static void main(String[] args) {
		ZoneId.getAvailableZoneIds().stream()
			.filter(x -> x.contains("Kiri"))
			.sorted()
			.forEach(System.out::println);
	}
}
