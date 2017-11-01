
public class Main {
	public static void main(String[] args) {
		byte b1 = 1;
		byte b2 = 2;
		
		short s1 = 1;
		short s2 = 2;
		
		int i1 = 1;
		int i2 = 2;
		
		long l1 = 1;
		long l2 = 2;
		
		char c1 = 'a';
		char c2 = 'b';
		
		float f1 = 1.0f;
		float f2 = 2.0f;
		//float f3 = 3.0;		//Compilation fails. Type mismatch: cannot convert from double to float
		
		double d1 = 1.0;
		double d2 = 1.0;
		
		//byte b3 = b1 + b2;	//Compilation fails. Type mismatch: cannot convert from int to byte
		byte b3 = (byte)(b1 + b2);
		//short s3 = s1 + s2;	//Compilation fails. Type mismatch: cannot convert from int to short
		//char c3 = c1 + c2;	//Compilation fails. Type mismatch: cannot convert from int to short
		
		int i3 = i1 + b1;
		int i4 = i1 + s1;
		long l3 = i1 + l1;
		long l4 = i1 + i2;
		
		float f3 = f1 + f2;
		float f4 = f1 + i1;
		//float f5 = f1 + d2;	//Compilation fails. Type mismatch: cannot convert from double to float
		float f6 = 1 + 1.2f;
		
		double d3 = f1 + d1;
		double d4 = d1 + d2;
		double d5 = d1 + i1;
		
		Integer I1 = 1;
		Integer I2 = 2;
		
		Integer I3 = I1 + I2;
		Integer I4 = I1 + i1;
		
		Double D1 = d1 + I1;		
	}
}
