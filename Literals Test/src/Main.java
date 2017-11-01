
public class Main {
	public static void main(String[] args) {
		int i1 = 26;
		//int i2 = 2.6;
		int i3 = 032;		//Octal literal
		int i4 = 0b11010;	//binary literal
		int i5 = 0x1A;		//Hex literal
		int i6 = 0xa1;		//Small or Capital A to F
		int i7 = 0X1a;		//Small or Capital x
		int i8 = 1_234;
		//int i9 = 999999999999999L;
		//int i10 = 999999999999999;
		//int i11 = 1E5;
		
		byte b = 1;
		byte b1 = -1;
		//byte b2 = 1.1;
		//byte b3 = 99999999;
		byte b4 = 0x7F;
		//byte b5 = 0xA1;
		
		
		short s = 1;
		short s1 = -1;
		//short s2 = 1.0;
		short s3 = 0xA1;
		
		long l = 1;
		//long l1 = 1.1;
		long l2 = 999999999999999L;
		long l3 = 0xA1;
		long l4 = 1l;
		
		double d = 1;
		double d1 = 1.0;
		double d2 = 0.0000000001;
		double d3 = 1_23.1_23;
		double d4 = 1E5;
		double d5 = 1.2E5;
		double d6 = 1E-5;
		double d7 = 1.2E-5;
		double d8 = 1.2e5;
		double d9 = 1.1f;
		double d10 = 999999999999999L;
		double d11 = 1.1D;
		double d12 = 1d;
		
		float f = 1;
		//float f1 = 1.1;
		float f2 = 1.1f;
		float f3 = 0.0000001f;
		float f4 = 1.1F;
		float f5 = 1_23.1_23f;
		//float f6 = 1E5;
		float f7 = 1E5f;
		//float f8 = 1.2E5;
		float f9 = 1.2E5f;
		float f10 = 1.2E-5f;
		float f11 = 1.2e5f;
		
		char c = 'a';
		char c1 = 0;
		char c2 = '\u0061';
		char c3 = 97;
		//char c4 = -1;
		char c5 = '\u0000';
		//char c6 = 1.1;
		
		
		String str = "a";
		//String str1 = 1;
		String str2 = String.valueOf(1);
		String str3 = "a" + 1;
		//String str4 = 1 + 1;
		//String str5 = 'a';
		String str6 = "a".concat("1");
		//String str7 = "a".concat(1);
		
		//StringBuilder sb = "a";
		StringBuilder sb1 = new StringBuilder("a");
		StringBuilder sb2 = new StringBuilder("a"+1);
		//StringBuilder sb3 = new StringBuilder(1);	this is to mention initial capacity of 1
		//StringBuilder sb4 = new StringBuilder(1 + 1); this is to mention initial capacity of 2
		
		System.out.println("");
		
	}
}
