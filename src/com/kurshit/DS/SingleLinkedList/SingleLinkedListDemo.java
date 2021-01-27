package com.kurshit.DS.SingleLinkedList;

import java.util.Scanner;

import javax.activity.InvalidActivityException;

public class SingleLinkedListDemo
{
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args)
	{
		while (true)
		{
			System.out.println("****Single Linked LIst program ******");
			System.out.println("1. Insert in Linked List");
			System.out.println("2. Delete from Linked List");
			System.out.println("4. Travers the SIngle Linked List");
			System.out.println("Please select operation : ");

			int ch = s.nextInt();
			
			

			switch (ch)
			{
				case 1:
					System.out.println("***Single Linked List insertion****");
					insertInLinkedList();
					break;
				case 2 : 
					System.out.println("*** Single Linked List deletions***");
					deleteFromLinkedList();
					break;
				case 4:
					System.out.println("**Elements of Single Linked List are :");
					SingleLL.traverseSinleLL();
					break;
				case 5 :
					System.out.println("Size of Single Linked List is : " + SingleLL.getSize());
					break;
				case 6:
					System.exit(0);
					break;
			}		

		}

	}

	public static void insertInLinkedList()
	{
		System.out.println("***Insertion Menu****");
		System.out.println("1. At first");
		System.out.println("2. At Last");
		System.out.println("3. At given position");
		System.out.println("6. Exit");
		int ch = s.nextInt();
		switch (ch)
		{
		case 1:
			System.out.println("***Insert at First in Linked List***");
			System.out.println("Enter element : ");
			int data = s.nextInt();
			SingleLL.insertFirst(data);
			break;
		case 2 : 
			System.out.println("***Insert at Last in Linked List***");
			System.out.println("Enter elemt : ");
			data = s.nextInt();
			SingleLL.insertLast(data);
			break;
		case 3 :
			System.out.println("***Insert at given location in Linked List***");
			System.out.println("Enter element : ");
			data = s.nextInt();
			System.out.println("Enter position : ");
			int pos = s.nextInt();
			SingleLL.insertAtGivenPosition(pos, data);
			break;
		case 6 : 
			System.exit(0);
			break;
		}
	}
	
	public static void deleteFromLinkedList()
	{
		System.out.println("***Deletion Menu****");
		System.out.println("1. From first");
		System.out.println("2. From Last");
		System.out.println("3. From given position");
		System.out.println("6. Exit");
		int ch = s.nextInt();
		switch (ch)
		{
		case 1 :
			System.out.println("***Delete First in Linked List***");
			SingleLL.removeFirst();
			break;
		case 2 :
			System.out.println("** Delete Last from Linked List ***");
			SingleLL.removeLast();
			break;
		case 3 :
			System.out.println("***Delete from given position***");
			System.out.println("Enter position : ");
			int pos = s.nextInt();
			SingleLL.removeAtPosition(pos);
			break;
		}
	}

}

class SingleLL
{
	static class Node
	{
		static Node head;
		int data;

		Node next;

		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	static void insertFirst(int data)
	{
		Node newNode = new Node(data);
		newNode.next = Node.head;
		Node.head = newNode;
	}

	static void traverseSinleLL()
	{
		Node ptr = Node.head;
		while (ptr != null)
		{
			System.out.print(ptr.data + ">>");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	static void insertLast(int data)
	{
		Node newNode = new Node(data);
		
		if(isEmpty())
		{
			Node.head = newNode;
			return;
		}
		
		Node ptr = Node.head;
		while(ptr.next != null)
		{
			ptr = ptr.next;
		}
		
		ptr.next = newNode;
	}
	
	//adds element before a lcoated node
	// if there are 10 elemtns in LL and loc = 10, then new node would be second last node, not the last node
	// if loc = 1. new node would be first node, i.e head node
	static void insertAtGivenPosition(int loc, int data) 
	{
		if(loc > getSize())
		{
			System.out.println("Location is invalid");
		}
		
		if(loc == 1)
		{
			insertFirst(data);
			return;
		}
		
		Node newNode = new Node(data);
		Node prevNode = null;
		Node ptr = Node.head;
		int currentLoc = 0;
		
		while(ptr != null)
		{
			currentLoc++;
			if(currentLoc == loc)
			{
				break;
			}
			prevNode = ptr;
			ptr = ptr.next;
			
		}
		
		newNode.next = ptr;
		prevNode.next = newNode;
		
		
	}
	
	
	//for delete
	
	public static void removeFirst()
	{
		Node ptr = Node.head;
		Node.head = ptr.next;
		ptr.next = null;
	}
	
	public static void removeLast()
	{
		Node ptr = Node.head;
		
		if(isEmpty())
		{
			System.out.println("List is empty");
			return;
		}
		
		//check if it has only one node
		
		if(ptr.next == null)
		{
			Node.head = null;
			return;
		}
		
		Node prevNode = null;
		while(ptr.next != null)
		{
			prevNode = ptr;
			ptr = ptr.next;
		}
		
		prevNode.next = null;
		
	}
	
	static void removeAtPosition(int loc)
	{
		if(Node.head == null)
		{
			System.out.println("List is EMPTY");
		}
		if(loc == 1)
		{
			removeFirst();
			return;
		}
		
		if(loc == getSize() )
		{
			removeLast();
			return;
		}
		
		int currentLoc = 0;
		Node prevNode = null;
		Node ptr = Node.head;
		while(ptr.next != null)
		{
			currentLoc++;
			
			if(currentLoc == loc)
			{
				break;
			}
			prevNode = ptr;
			ptr = ptr.next;
		}
		
		prevNode.next = ptr.next;
		ptr.next = null;
		
	}
	
	static int getSize()
	{
		int result = 0;
		Node ptr = Node.head;
					
		while(ptr != null)
		{
			result++;
			ptr = ptr.next;
		}		
		
		return result;
	}
	
	public static boolean isEmpty()
	{
		return Node.head == null;
	}

}
