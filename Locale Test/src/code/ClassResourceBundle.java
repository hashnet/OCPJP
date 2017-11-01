package code;

import java.util.Locale;
import java.util.ResourceBundle;

public class ClassResourceBundle {
	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		Locale oman = new Locale("ar", "OM");
	
		printGoodbye(us);
		printGoodbye(oman);
	}
	
	private static void printGoodbye(Locale locale) {
		ResourceBundle rb = ResourceBundle.getBundle("resourcebundles.Goodbye", locale);
		
		rb.keySet()
			.stream()
			.sorted()
			.forEach(k -> System.out.println(k + "=" + rb.getObject(k)));
		System.out.println();
	}
}
