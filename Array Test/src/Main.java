public class Main {
	public static void main(String[] args) {
		//One dimensional arrays
		//----------------------
		//int[] a1 = new int[];	//Variable must provide either dimension expressions or an array initializer
		int[] a2 = new int[0];
		int[] a3 = new int[3];
		//int[] a4 = new int[-1];	//Compilation ok, Exception in runtime: NegativeArraySizeException
		int[] a5 = new int[] {1, 2, 3};
		//int[] a6 = new int[3] {1, 2, 3};	//Cannot define dimension expressions when an array initializer is provided
		//int[] a7 = new int {1, 2, 3};	//compilation fails
		int[] a8 = {1, 2, 3};
			
		//int[] a9 = new [3]int;	//compilation fails
		//int[] a10 = new [3]int {1, 2, 3};	//compilation fails
		
		int a11[] = new int[3];
		int a12[] = new int[] {1, 2, 3};		
		int a13[];
		a13 = new int[3];
		a13 = new int[] {1, 2, 3};
		//a13 = new int[3] {1, 2, 3};	//Cannot define dimension expressions when an array initializer is provided
		//a13 = new int {1, 2, 3};	//compilation fails
		//a13 = {1, 2, 3};	//Array constants can only be used in initializers (In contrast to a8)
		
		
		//Object arrays
		//----------------------
		Integer[] i1 = new Integer[] {new Integer(1), new Integer(2)};
		//Integer[] i2 = new Integer[] {new Integer(1), new Double(2)};	//Compilation fails. Type mismatch: cannot convert from Double to Integer
		Integer[] i3 = new Integer[] {1, 2};
		//Integer[] i4 = new Integer[] {1, 2.0};	//Compilation fails. Type mismatch: cannot convert from double to Integer
		Number[] i5 = new Integer[] {new Integer(1), 2};
			System.out.println(i5.getClass());		//class [Ljava.lang.Integer;
			System.out.println(i5[0].getClass());	//class java.lang.Integer
			System.out.println(i5[1].getClass());	//class java.lang.Integer
		Number[] i6 = new Number[] {1, 2.0};
			System.out.println(i6.getClass());		//class [Ljava.lang.Number;
			System.out.println(i6[0].getClass());	//class java.lang.Integer
			System.out.println(i6[1].getClass());	//class java.lang.Double
		Number[] i7 = {1, 2.0};
		
		
		//Two dimensional arrays
		//----------------------
		//int[][] d1 = new int[][];	//Variable must provide either dimension expressions or an array initializer
		int[][] d2 = new int[2][3];
		int[][] d3 = new int[2][];
			d3[0] = new int[] {1, 2, 3};
			//d3[0] = {1, 2, 3};	//Array constants can only be used in initializers
			d3[1] = new int[] {1};	//Each inner array can have variable dimension
		int[][] d4 = new int[2][];
			System.out.println(d4[0]);	 	//null
			//System.out.println(d4[0][0]);	//NullPointerException
			//d4[0][0] = 0;					//NullPointerException
			String s1 = null;
			System.out.println(s1);			//null
		int[][] d5 = new int[][]{{1, 2, 3}, {1}};
		//int[][] d6 = new int[2][]{{1, 2, 3}, {1}};	//Cannot define dimension expressions when an array initializer is provided
		//int[][] d7 = new int[2][1]{{1, 2, 3}, {1}};	//Cannot define dimension expressions when an array initializer is provided
		//int[][] d8 = new [2][3]int;					//compilation fails. Syntax error
		int [] d9 [] = new int[2][3];
		int[][] d10 = {
			{1, 2, 3}, 
			{4, 5}
		};
		//int[][] d11 = {1, 2, 3};	//compilation fails. Type mismatch: cannot convert from int to int[]

		
		//Array assignment to reference variable
		//--------------------------------------
		int[] a = { 1, 2, 3 };
		int[] b = { 1, 2, 3, 4, 5 };
			System.out.println(a.length);	//prints 3
			a = b;
			System.out.println(a.length);	//prints 5
		
		int[] ii = {1, 2};
		double[] dd = {1.0, 2.0};
		short[] ss = {1, 2};
			//ii = dd;	//Compilation fails as ii is of type int[] and dd is of type double[]
			//ii = ss;	//Compilation fails as ii is of type int[] and ss is of type short[]
			
		int[] pi = {1, 2};
		Integer[] wi = {1, 2};
			//pi = wi;	//Compilation fails as pi is of type int[] (primitive int array) and wi is of type Integer[] (Wrapper Integer array)
			//wi = pi;	//Compilation fails. Type mismatch: cannot convert from int[] to Integer[]
		Number[] numArr = new Number[]{1, 2};
		Integer[] intArr = {1, 2};
			System.out.println(numArr.getClass());	//class [Ljava.lang.Number;
			numArr = intArr;	//Ok
			System.out.println(numArr.getClass());	//class [Ljava.lang.Integer;
			//intArr = numArr;	//Compilation fails. Type mismatch: cannot convert from Number[] to Integer[]
		
		
		//Array access
		//-------------------
		int[] x;
			//System.out.println(x.length);	//compilaion fails: The local variable x may not have been initialized
			x = new int[1];
			System.out.println(x.length); 	//prints 1
		
		int[] l1, r1;
			l1 = new int[2];
			r1 = new int[3];
			System.out.println(l1.length);	//prints 2
			System.out.println(r1.length);	//prints 3
		
		int l2[], r2;
			l2 = new int[2];
			//r2 = new int[3];	//Compilation fails as r2 is of type int (primitive type int) and not of type int[] (array of primitive type int);
			
		int[][] l3, r3;
			l3 = new int[1][2];
			r3 = new int[3][4];
		
		int[] l4[], r4[];
			l4 = new int[1][2];
			r4 = new int[3][4];
			
		int[] l5[], r5;
			l5 = new int[1][2];
			//r5 = new int[3][4];	//Compilaiton fails as r5 is of type int[] (one dimensional array) and not of type int[][] (two diemnsional array);
			r5 = new int[3];
			
			
		//Array initial values
		//--------------------
		int[] i = new int[2];
		System.out.println(i[0]);	//prints 0
		System.out.println(i[1]);	//prints 0
		//System.out.println(i[2]);	//ArrayIndexOutOfBoundsException
		
		double[] d = new double[2];
		System.out.println(d[0]); 	//prints 0.0
		System.out.println(d[1]);	//prints 0.0
		
		String[] s = new String[2];
		System.out.println(s[0]);	//prints null
		System.out.println(s[1]);	//prints null
	}
}
