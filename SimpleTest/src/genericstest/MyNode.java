package genericstest;

public class MyNode extends Node<Integer>{

	public MyNode(Integer data) {
		super(data);
	}
	
	@Override
	public void setData(Integer data) {
		System.out.println("MyNode.setData");
		
		super.setData(data);
	}
	
	public static void main(String[] args) {
		MyNode mn = new MyNode(1);
		
		Node n = mn;
		
		System.out.println(n.data);
		n.setData("Hello");
		
		System.out.println(n.data);
		
		//Integer x = mn.data;
	}
}
