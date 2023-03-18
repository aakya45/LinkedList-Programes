package LinkedList;

public class LinkedList 
{
	private Node head;
	private int nodecount;

	//constructore
	public LinkedList()
	{
		this.head=null;
		this.nodecount=0;
	}

	//to string
	public String toString()
	{
		String str="";
		Node x=head;
		while(x!=null)
		{
			str=str+" --> "+x;
			x=x.getNext();
		}
		return str;
	}

	//1.insert first 
	public void InsertFirst(int data)
	{
		Node temp=new Node(data);
		nodecount++;

		if(head==null)
		{
			head=temp;
		}
		else
		{
			temp.setNext(head);
			head=temp;
		}
	}

	//2.insert last
	public void InsertLast(int data)
	{
		Node temp=new Node(data);
		nodecount++;

		if(head==null)
		{
			head=temp;
		}
		else
		{
			Node it=head;
			while(it.getNext()!=null)
			{
				it=it.getNext();
			}
			it.setNext(temp);
		}
	}

	//3.insert by position
	public void InsertByPos(int data,int pos)
	{	
		if(pos==1)
			InsertFirst(data);
		else if(pos==nodecount+1)
			InsertLast(data);
		else if(pos<=0 || pos>nodecount+1)
			System.out.println("invalid position cannot insert node into ll");
		else
		{
			Node temp=new Node(data);
			nodecount++;

			Node it=head;
			int x=1;
			while(x<pos-1)
			{
				it=it.getNext();
				x++;   
			}
			temp.setNext(it.getNext());
			it.setNext(temp);
		}
	}

	//4.delete first
	public void DeleteFirst()
	{
		if(head==null)
			System.out.println("Linked List is Empty");
		else
		{
			Node it=head;
			head=it.getNext();
			it.setNext(null);
		}
		nodecount--;
	}

	//5.detlete last
	public void DeleteLast()
	{
		if(head==null)
			System.out.println("Linked List is Empty");
		else
		{
			if(head.getNext()==null)
				head=null;
			else
			{
				Node it=head;
				Node itp=null;
				while(it.getNext()!=null)
				{
					itp=it;
					it=it.getNext();
				}
				itp.setNext(null);
			}
			nodecount--;
		}
	}

	//6.delete by position
	public void DeleteByPos(int pos)
	{	
		if(pos==1)
			DeleteFirst();
		else if(pos==nodecount+1)
			DeleteLast();
		else if(pos<=0 || pos>nodecount+1)
			System.out.println("invalid position cannot insert node into ll");
		else
		{
			Node it=head;
			Node itp=null;
			int x=1;
			while(x<pos)
			{
				itp=it;
				it=it.getNext();
				x++;
			}
			itp.setNext(it.getNext());
			it.setNext(null);
		}
		nodecount--;
	}

	//7.Reverse the linkedlist using 3 references
	public void ReverseLL()
	{
		Node itp=null;
		Node it=head;
		Node itn=head;

		while(it!=null)
		{
			itn=it.getNext();
			it.setNext(itp);
			itp=it;
			it=itn;
		}
		head=itp;
	}

	//8.Reverse the linkedlist using recursion
	public void reverseUsingRecursion()
	{
		reverseUsingRecursion1(head);
	}

	private void reverseUsingRecursion1(Node it)
	{
		if(it.getNext()==null)
		{
			head=it;
			return;
		}
		reverseUsingRecursion1(it.getNext());
		it.getNext().setNext(it);
		it.setNext(null);
	}

	//9.reverse print using recursion
	public void ReversePrintLL()
	{
		RecursivelyReverePrintLL(head);
	}

	private void RecursivelyReverePrintLL(Node it)
	{
		if(it==null)   //if(it.getNext()!=null)  or
			return;
		RecursivelyReverePrintLL(it.getNext());
		System.out.print("-->"+it.getData());
	}

	//10. print alternate node in ll odd
	public void OddAlternateNodePrint()
	{
		Node it=head;
		while(it!=null)
		{
			System.out.print(it.getData()+" -->");
			if(it.getNext()==null)
				break;
			it=it.getNext().getNext();
		}
	}

	//11. print alternate node in ll even
	public void EvenAlternateNodePrint()
	{
		Node it=head;
		while(it!=null)
		{
			System.out.print(it.getNext().getData()+"-->");
			if(it.getNext()==null)
				break;
			it=it.getNext().getNext();
		}
	}

	//12. Delete Even alternate node in linked list
	public void DeleteEvenAlternateNode()
	{
		Node it1=head;
		Node it2=head.getNext();
		while(it1!=null && it2!=null)
		{
			if(it2.getNext()==null)
			{
				it1.setNext(null);
				break;	
			}
			it1.setNext(it2.getNext());
			it2.setNext(null);
			it1=it1.getNext();
			it2=it1.getNext();	
		}	
	}

	//14. Delete odd alternate node in linked list
	public void DeleteOddAlternateNode()
	{
		head=head.getNext();
		Node it1=head;
		Node it2=head;
		Node itp=null;
		while(it1!=null && it2!=null)
		{
			it2=it1.getNext();
			itp=it1;
			if(it2!=null)
			{
				it1=it2.getNext();
				itp.setNext(it1);
				it2.setNext(null);
			}
		}
	}

	//15.isEvenNoOfNodes check floyed warshaw algoritham rabbit and tortoise
	public boolean isEvenNoOfNodes()
	{
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.getNext()!=null)
		{
			slow=slow.getNext();
			fast=fast.getNext().getNext();
		}
		if(fast==null)
			return true;
		else
			return false;
	}

	//16.is identical two linked lists
	public boolean isIdenticalLL(LinkedList h1, LinkedList h2)
	{
		Node it1=h1.head;
		Node it2=h2.head;
		while(it1!=null && it2!=null)
		{
			if(it1.getData()!=it2.getData())
				return false;
			it1=it1.getNext();
			it2=it2.getNext();
		}
		if(it1==null && it2==null)
		{
			return true;
		}
		else
			return false;
	}

	//17.finding middle node of ll(floyed warshwal algo)
	public Node findMiddleNodeValue()
	{
		Node slow=head;
		Node fast=head;
		int count=0;
		while(fast.getNext()!=null)
		{
			if(count==0)
			{
				fast=fast.getNext();
				count++;
			}
			else
			{
				fast=fast.getNext();
				slow=slow.getNext();
				count--;
			}
		}
		return slow;
	}

	//18.is palindrome check
	public boolean isPalindromeLL(LinkedList ll1)
	{
		Node slow=ll1.head;
		Node fast=ll1.head;
		Node prev=ll1.head;

		while(fast.getNext()!=null && fast.getNext().getNext()!=null)
		{
			slow=slow.getNext();
			prev=slow;
			fast=fast.getNext().getNext();
		}

		//creating new linkedlist for check identical
		LinkedList ll2=new LinkedList();  
		ll2.head=slow.getNext();
		prev.setNext(null);
		System.out.println("new ll2 :"+ll2);
		System.out.println("new ll1 :"+ll1);

		//reverse the l2 linkedlist
		if(ll2.head!=null)
			ll2.reverseUsingRecursion1(ll2.head);

		System.out.println("after reversing ll2 :"+ll2);
		System.out.println("ll1 same as first :"+ll1);

		//checking identical or not
		boolean identical=isIdenticalLL(ll1, ll2);

		//making ll2 and ll1 as single ll1 before returning
		if(ll2.head!=null)
			ll2.reverseUsingRecursion1(ll2.head);

		System.out.println("ll2 same as origional :"+ll2);
		prev.setNext(ll2.head);
		ll2.head=null;
		System.out.println("ll2 is dead :"+ll2);

		//returning o/p 
		if(identical)
			return true;
		else
			return false;	

	}

	//19.create internal cycle if not present, detect it and remove(internal loop)
	//1.creating cycle
	public void insertCycle(int data)
	{
		Node temp=null;
		Node it=head;
		Node itp=null;

		while(it!=null)
		{
			itp=it;
			if(it.getData()==data)
			{
				temp=it;
				it=it.getNext();
			}
			else
				it=it.getNext();	
		}
		itp.setNext(temp);	
	}	

	//2.finding cycle
	public Node findCycle(LinkedList ll)
	{
		Node slow=ll.head;
		Node fast=ll.head;
		while(fast!=null && fast.getNext()!=null)
		{
			slow=slow.getNext();
			fast=fast.getNext().getNext();
			if(fast==slow)
			{
				return slow;
			}
		}
		return null;
	}

	//3.finding length of cycle,remaining length and removing cycle
	public int findCyclelength(Node cycle)
	{
		int cyclelength=0,remeninglength=0,length;
		Node p1=cycle;
		Node p2=cycle;
		do
		{
			cyclelength++;
			p2=p2.getNext();

		}while(p1!=p2);

		System.out.println("Cycle length is : "+cyclelength);
		p1=head;
		while(p1!=p2)
		{
			remeninglength++;
			p1=p1.getNext();
			p2=p2.getNext();	
		}
		length=cyclelength+remeninglength;
		System.out.println("cycle caused at node "+p2);
		//      Node it=head;
		//		for(int i=1;i<length;i++)
		//		{
		//			it=it.getNext();
		//		}
		//		it.setNext(null);

		Node it=p2;
		Node itp=p2;
		while(it.getNext()!=itp)
		{
			it=it.getNext();
		}
		System.out.println("cycle causing node is :"+it);
		it.setNext(null);
		return length;
	}

	//20.finding nth last node
	public Node findNthLastNode(int n)
	{
		Node it1=head;
		Node it2=head;
		Node it3=head;
		int count=0;
		while(it1!=null)
		{
			it1=it1.getNext();
			count++;
		}

		//checking user entered noded are present or not
		if(n>0 && n<=count)
		{
			//itreting it2 upto nth last node
			for(int i=1;i<n;i++)
			{
				it2=it2.getNext();
			}
			//now setting it3 upto last n th node
			while(it2.getNext()!=null)
			{
				it2=it2.getNext();
				it3=it3.getNext();
			}
			return it3;
		}
		else
			System.out.println("plz enter valid range / Node not avilable");
		return null;
	}

	//21.merge two ll in sorted order
//	public static void mergeTwoLLinSortedOrder(LinkedList l1,LinkedList l2)
//	{
//		LinkedList l3=new LinkedList();
//		Node it1=l1.head;
//		Node it2=l2.head;
//		//both same ll sizewise
//		while(it1!=null && it2!=null)
//		{
//			if(it1.getData()<it2.getData())
//			{
//				l3.InsertLast(it1.getData());
//				it1=it1.getNext();
//			}
//			else if(it2.getData()<it1.getData())
//			{
//				l3.InsertLast(it2.getData());
//				it2=it2.getNext();
//			}
//			else
//			{
//				l3.InsertLast(it1.getData());
//				it1=it1.getNext();  
//				it2=it2.getNext();
//			}
//		}
//		//if l1 is larger
//		while(it1!=null && it2==null)
//		{
//			l3.InsertLast(it1.getData());
//			it1=it1.getNext();
//		}
//		//if l1 is larger
//		while(it2!=null && it1==null)
//		{
//			l3.InsertLast(it2.getData());
//			it2=it2.getNext();
//		}
//		
//		System.out.println("merged linkedlist is :"+l3);
//	}
















}
