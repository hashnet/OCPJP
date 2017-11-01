package code;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertyFileResourceBundle {
	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		Locale oman = new Locale("ar", "OM");
		
		printWelcome(us);
		
		printWelcome(oman);
	}
	
	private static void printWelcome(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("resourcebundles.Welcome", locale);
		
		Set<String> keySet = rb.keySet();
		for(String key : keySet) {
			System.out.println(key + "=" + rb.getString(key));
		}
		System.out.println();
		
		rb.keySet()
			.stream()
			.map(k -> k + "=" + rb.getString(k))
			.forEach(System.out::println);
		System.out.println();
		
		//System.out.println(rb.getString("name"));	//Exception for locale oman
		
		Properties props = new Properties();
		rb.keySet()
			.stream()
			.forEach(k->props.put(k, rb.getString(k)));
		System.out.println();
		
		props.keySet()
		.stream()
		.forEach(k -> System.out.println(k + ":" + props.getProperty((String)k)));
		System.out.println();
		
		System.out.println(props.get("name"));		//Prints: null for locale oman
		System.out.println();
		
		System.out.println(props.getProperty("name", "Unknown Person"));	//Prints: Unknown Person for locale oman
		System.out.println();
	}
}
