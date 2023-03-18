package LinkedList;

public class LinkedListTest 
{
	public static void main(String[] args) 
	{
		LinkedList ll=new LinkedList();
		ll.InsertLast(10);
		ll.InsertLast(80);
		ll.InsertLast(30);
		System.out.println(ll);

		LinkedList ll1=new LinkedList();
		ll1.InsertLast(30);
		ll1.InsertLast(50);
		ll1.InsertLast(60);
		System.out.println(ll1);

		//LinkedList.mergeTwoLLinSortedOrder(ll,ll1);

		/*19.
		 * cycle detection program 
		 * ll.insertCycle(50); Node cycle=ll.findCycle(ll);
		 * System.out.println("cycle at this node but not 100% causing node:"+cycle);
		 * int len=ll.findCyclelength(cycle);
		 * System.out.println("total length of ll is :"+len);
		 * System.out.println("ll after removing causing node :"+ll);
		 */
		 /*20.
		 * Node it=ll.findNthLastNode(5); 
		 * System.out.println("you entered numbred last node in ll is "+it); 
		 */
	}

}
