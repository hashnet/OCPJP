package extra;

public class Extra {
	public int publicI;
	protected int protectedI;
	int defaultI;
	private int privateI;
	
	public void publicFunc(){}
	protected void protectedFunc(){}
	void defaultFunc(){}
	private void privateFunc(){}
	
	public static void main(String[] args) {
		Extra extra = new Extra();
		
		extra.publicI = 10;
		extra.protectedI = 20;
		extra.defaultI = 30;
		extra.privateI = 40;
		
		extra.publicFunc();
		extra.protectedFunc();
		extra.defaultFunc();
		extra.privateFunc();
	}
}
