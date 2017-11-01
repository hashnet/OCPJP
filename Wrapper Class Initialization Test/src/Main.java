
public class Main {
	public static void main(String[] args) {
		System.out.println(new Boolean(true));			//true
		System.out.println(new Boolean("true"));		//true
		System.out.println(new Boolean("false"));		//false
		System.out.println(new Boolean("tRuE"));		//true
		System.out.println(new Boolean("fAlSe"));		//false
		System.out.println(new Boolean("yes"));			//false
		System.out.println(new Boolean("no"));			//false
		
		//System.out.println(new Byte(1));				//Compilation fails. The constructor Byte(int) is undefined
		//System.out.println(new Byte(1.1));				//The constructor Byte(double) is undefined
		System.out.println(new Byte((byte) 1));			//1
		System.out.println(new Byte((byte) 1.1));		//1
		System.out.println(new Byte("127"));			//127
		//System.out.println(new Byte("128"));	 		//java.lang.NumberFormatException: Value out of range. Value:"128" Radix:10
		System.out.println(new Byte(Byte.MAX_VALUE));	//127
		//System.out.println(new Byte("1.1"));		 	//Exception in thread "main" java.lang.NumberFormatException: For input string: "1.1"
	
		//System.out.println(new Short(1));				//Compilation fails. The constructor Short(int) is undefined
		System.out.println(new Short((short) 1));	 	//1
		System.out.println(new Short("32767")); 		//32767
		//System.out.println(new Short("32768")); 		//Exception in thread "main" java.lang.NumberFormatException: Value out of range. Value:"32768" Radix:10
	
		System.out.println(new Integer(1));				//1
		System.out.println(new Integer((byte) 1));		//1
		//System.out.println(new Integer((long) 1));	//Compilation fails. The constructor Integer(long) is undefined
		System.out.println("1");						//1
		
		System.out.println(new Long(1));				//1
		System.out.println(new Long((int) 1));			//1
		System.out.println(new Long("1"));				//1
		
		System.out.println(new Float(1));				//1.0
		System.out.println(new Float(1.1));				//1.1
		System.out.println(new Float(1.1F));			//1.1
		System.out.println(new Float(1.1D));			//1.1
		
		System.out.println(new Double(1));				//1.0
		System.out.println(new Double(1.1));			//1.1
		System.out.println(new Double(1.1F));			//1.100000023841858
		System.out.println(new Double(1.1D));			//1.1
		
		System.out.println(new Character('a'));			//a
		System.out.println(new Character('\u0061')); 	//a
		//System.out.println(new Character("a"));		//Compilation fails. The constructor Character(String) is undefined
	}
}
