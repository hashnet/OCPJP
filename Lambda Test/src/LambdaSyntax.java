
public class LambdaSyntax {
	interface ReturnVoid {
		void method(int a, int b);
	}
	
	interface ReturnInt {
		int method(int a, int b);
	}
	
	interface ParamZero {
		void method();
	}
	
	interface  ParamOne {
		void method(int a);
	}
	
	interface ParamMulti {
		void method(int a, int... b);
	}
	
	public static void main(String[] args) {
		ReturnVoid rv;
		rv = (a, b) -> {};
		rv = (int a, int b) -> {};
//		rv = (int a, b) -> {};	//Syntax error, insert "... VariableDeclaratorId" to complete FormalParameter
//		rv = (a, int b) -> {};	//Syntax error on tokens, delete these tokens
//		rv = (a) -> {};			//Lambda expression's signature does not match the signature of the functional interface method voidMethod(int, int)
//		rv = () -> {};			//Lambda expression's signature does not match the signature of the functional interface method voidMethod(int, int)
//		rv = (a, b) -> a > b;	//Void methods cannot return a value
		rv = (a, b) -> {boolean var = a == b;};
//		rv = (a, b) -> a == b;	//Void methods cannot return a value
//		rv = (a, b) -> a;		//Void methods cannot return a value
//		rv = (a, b) -> 0;		//Void methods cannot return a value
//		rv = (a, b) -> null;	//Void methods cannot return a value
		rv = (a, b) -> System.out.println("");
		rv = (a, b) -> String.valueOf(a);
//		rv = (a, b) -> {return String.valueOf(a);};	//Void methods cannot return a value
		rv = (a, b) -> a = b;
//		rv = (a, b) -> a + b;	//Void methods cannot return a value
//		rv = (a, b) -> int c = a + b;	//Syntax error, insert ";" to complete Statement
//		rv = (a, b) -> {int c = a + b};	//Syntax error, insert ";" to complete BlockStatements
		rv = (a, b) -> {int c = a + b;};
//		rv = (a, b) -> return;	//Syntax error on token "->", { expected after this token
		rv = (a, b) -> {return;};
		rv = (a, b) -> {a = b;};
		rv = (a, b) -> {a = b; return;};
//		rv = (a, b) -> {a = b; return 0;};	//Void methods cannot return a value
		
		
		ReturnInt ri;
//		ri = (a, b) -> {};		//This method must return a result of type int
		ri = (a, b) -> 0;
//		ri = (a, b) -> "";		//Type mismatch: cannot convert from String to int
//		ri = (a, b) -> a > b;	//Type mismatch: cannot convert from boolean to int
		ri = (a, b) -> a = b;
		ri = (a, b) -> a + b;
		ri = (a, b) -> a;
//		ri = (a, b) -> {int c = a + b;};	//This method must return a result of type in
		ri = (a, b) -> {int c = a + b; return c;};
//		ri = (a, b) -> {return;};	//This method must return a result of type int
//		ri = (a, b) -> return 0;	//Syntax error on token(s), misplaced construct(s)
		ri = (a, b) -> {return 0;};
//		ri = (a, b) -> System.out.println("");	//Cannot return a void result
		ri = (a, b) -> {System.out.println(""); return 0;};
		
		
		ParamZero pz;
		pz = () -> {};
//		pz = -> {};		//Syntax error on token "=", TypeElidedFormalParameter expected after this token
//		pz = (a) -> {};	//Lambda expression's signature does not match the signature of the functional interface method method()
		
		
		ParamOne po;
		po = (a) -> {};
		po = (int a) -> {};
		po = a -> {};
		
		
		ParamMulti pm;
		pm = (a, b) -> {};
//		pm = (a, b, c) -> {};	//Lambda expression's signature does not match the signature of the functional interface method method(int, int[])
//		pm = (a) -> {};			//Lambda expression's signature does not match the signature of the functional interface method method(int, int[])
		
	}
}
