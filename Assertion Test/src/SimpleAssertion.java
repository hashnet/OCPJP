/**
 * 
 * @author HasanS
 * Go to the menu Run, and then to the menu item Run Configurations.
 * In the left panel, go to Java Application, and then go to the relevant Class.
 * In the right panel, choose the tab Arguments.
 * Under the field for VM arguments, type -ea to enable assertions.
 * Click on the Apply and then Run button.
 */



public class SimpleAssertion {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		
		assert b1;
		assert b2 : "b2 is false";
	}
}
