package resourcebundles;

import java.util.ListResourceBundle;

public class Goodbye_ar extends ListResourceBundle {
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"hi", "مرحبا,"},
			{"sua", "نراكم مرة أخرى"}
		};
	}
}
