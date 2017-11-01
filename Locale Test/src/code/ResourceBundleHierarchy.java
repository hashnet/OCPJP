package code;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleHierarchy {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("fr", "FR"));
		System.out.println(Locale.getDefault());
		
		ResourceBundle rb = ResourceBundle.getBundle("resourcehierarchy.Hierarchy", new Locale("en", "US"));		
		System.out.println(rb.getBaseBundleName());		
		System.out.println(rb.getLocale());
		
		rb.keySet()
			.stream()
			.sorted()
			.forEach(k -> System.out.println(k + "=" + rb.getString(k)));
	}
}
