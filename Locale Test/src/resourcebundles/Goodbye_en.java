package resourcebundles;

import java.util.ListResourceBundle;

public class Goodbye_en extends ListResourceBundle {
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"hi", "Hi There,"},
			{"sua", "See you again"}
		};
	}
}
