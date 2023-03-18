package LinkedList;

public class Node 
{
	private Node next;
	private int data;
	
	//parameterized constructore
	public Node(int data) 
	{
		this.next=next;
		this.data=data;
	}
	
	//getter setters
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	//to string
	public String toString()
	{
		String str=" "+data;
		return str;
	}

}
