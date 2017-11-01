package classmodifier;

public class Classes {}
//protected class ClassesProtected {}	//Illegal modifier for the class ClassesProtected; only public, abstract & final are permitted
class ClassesDefault {}
//private class ClassesPrivate {}		//Illegal modifier for the class ClassesPrivate; only public, abstract & final are permitted

abstract class ClassesAbstract {}
final class ClassesFinal {}
//abstract final class ClassesAbsFinal {} //The class ClassesAbsFinal can be either abstract or final, not both

//public abstract class Classes {}		//Also OK
//public final class Classes {}			//Also OK