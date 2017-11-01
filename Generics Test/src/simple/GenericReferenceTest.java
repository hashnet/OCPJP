package simple;

import java.util.*;

class M {} 
class N {}
//class Objec{}

class Box<T> {
	public T content;
	
	public Box(T content) {
		this.content = content;
	}
	
	public void put(T content) {
		this.content = content;
	}
	
	public T get() {
		return content;
	}
}

class Crate<T> {
	public T content;
	
	public Crate() {};
	
	public void put(T content) {
		this.content = content;
	}
	
	public T get() {
		return content;
	}
}

public class GenericReferenceTest {
	public static void main(String[] args) {
		//Possible new
		new Box<M>(new M());
		//new Box<M>(new N());					//The constructor Box<M>(N) is undefined
		new Box(new M());
		new Box(new M());
		new Crate<M>();
		new Crate<N>();
		new Crate();
		
		
		//Possible assignment
		Box<M> m1 = new Box<M>(new M());
		Box<M> m2 = new Box<>(new M());			//same as above line. Diamond operator
		//Box<M> m3 = new Box<>(new N());		//Cannot infer type arguments for Box<>
		Crate<M> m3 = new Crate<>();
		//Box<> m4 = new Box<>(new M());		//incorrect number of arguments for type Box<T>; it cannot be parameterized with arguments <>
		//Box<M> m5 = new Box<N>(new N());		//Type mismatch: cannot convert from Box<N> to Box<M>
		//Crate<M> m6 = new Crate<N>();			//Type mismatch: cannot convert from Crate<N> to Crate<M>
		
		Box<M> m7 = new Box(new M());
		Box<M> m8 = new Box(new N());
		Crate<M> m9 = new Crate();
		
		Box m10 = new Box<>(new N());
		System.out.println(m10.getClass()); 		//class simple.Box
		System.out.println(m10.get().getClass());//class a.N
		
		Box m11 = new Box(new N());
		System.out.println(m11.getClass()); 		//class simple.Box
		System.out.println(m11.get().getClass());//class a.N
		
		Crate m12 = new Crate<>();
		m12.put(new N()); 						//void simple.Crate.put(Object content)
		//N n1 = m12.get();						//Type mismatch: cannot convert from Object to N
		N n1 = (N) m12.get();
		
		Crate m13 = new Crate();
		m13.put(new N()); 						//void simple.Crate.put(Object content)
		//N n2 = m3.get();						//Type mismatch: cannot convert from Object to N
		N n2 = (N) m13.get();
		
		Crate m14 = new Crate<M>();
		m14.put(new N()); 						//void simple.Crate.put(Object content)
		//N n3 = m14.get();						//Type mismatch: cannot convert from Object to N
		N n3 = (N) m14.get();
		
		
		//Transfer
		Crate cg = new Crate();
		Crate<M> cm = new Crate<M>();
		Crate<N> cn = new Crate<N>();
		
		cg = cm;
		cg = cn;
		cm = cg;
		//cm = cn;								//Type mismatch: cannot convert from Crate<N> to Crate<M>
		cn = cg;
		//cn = cm								//Type mismatch: cannot convert from Crate<M> to Crate<N>
		
		
		Box bg;
		Box<M> bm;
		Box<N> bn;
		
		bg = new Box(new Object());
		System.out.println(bg.content.getClass());	//class java.lang.Object
		bg = new Box(new M());
		System.out.println(bg.content.getClass());	//class simple.M
		bg = new Box(new N());						//class simple.N
		System.out.println(bg.content.getClass());
		//bg = new Box<M>(new Object());			//The constructor Box<M>(Object) is undefined
		bg = new Box<M>(new M());					//class simple.M
		System.out.println(bg.content.getClass());
		//bg = new Box<M>(new N());					//The constructor Box<M>(N) is undefined
		
		
		bm = new Box(new Object());
		//M m = bm.content;							//java.lang.ClassCastException: java.lang.Object cannot be cast to simple.M
		//System.out.println(bm.content.getClass());//java.lang.ClassCastException: java.lang.Object cannot be cast to simple.M
		bm = new Box(new M());
		System.out.println(bm.content.getClass());	//class simple.M
		bm = new Box(new N());
		//M m = bm.content;							//java.lang.ClassCastException: simple.N cannot be cast to simple.M
		//System.out.println(bm.content.getClass());java.lang.ClassCastException: simple.N cannot be cast to simple.M
		//bm = new Box<M>(new Object());			//The constructor Box<M>(Object) is undefined
		bm = new Box<M>(new M());
		System.out.println(bm.content.getClass());	//class simple.M
		//bm = new Box<M>(new N());					//The constructor Box<M>(N) is undefined
		//bm = new Box<N>(new Object());			//Type mismatch: cannot convert from Box<N> to Box<M>
		//bm = new Box<N>(new M());					//Type mismatch: cannot convert from Box<N> to Box<M>
		//bm = new Box<N>(new N())					//Type mismatch: cannot convert from Box<N> to Box<M>
	
		Crate crg;
		Crate<M> crm;
		Crate<N> crn;
		
		crg = new Crate();
		crg.put(new String("crg.content"));
		String str = (String)crg.get();
		System.out.println(str);					//crg.content
		System.out.println(str.getClass());			//class java.lang.String
		
		crg = new Crate<M>();
		crg.put(new String("crg.content"));
		str = (String)crg.get();					//Object simple.Crate.get()
		System.out.println(str);					//crg.content		
		System.out.println(str.getClass());			//class java.lang.String
		
		crm = new Crate();
		//crm.put(new String("crm.content"));		//The method put(M) in the type Crate<M> is not applicable for the arguments (String)
		crm.put(new M());
		//String str = crm.get();					//Type mismatch: cannot convert from M to String
		M m = crm.get();			
		System.out.println(m);						//simple.M@15db9742	
		System.out.println(m.getClass());			//class simple.M
	}
}
