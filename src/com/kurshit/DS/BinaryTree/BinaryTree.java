package com.kurshit.DS.BinaryTree;

public class BinaryTree
{
	static class Node
	{
		int key;
		Node left,right;
	
		Node(int key)
		{
			this.key = key;
			left = right = null;
		}
	}
	
	Node root;
	
	BinaryTree(int key)
	{
		root = new Node(key);
	}
	
	BinaryTree()
	{
		root = null;
	}
	
	void printPreOrder()
	{
		printPreOrder(root);
	}
	
	void printPreOrder(Node node)
	{
		if(node == null)
			return;
		
		System.out.print(node.key + " ");
		
		printPreOrder(node.left);
		printPreOrder(node.right);
		
	}
	
	void printInOrder()
	{
		printInOrder(root);
	}
	
	void printInOrder(Node node)
	{
		if(node == null)
			return;
		
		printInOrder(node.left);
		System.out.print(node.key + " ");
		printInOrder(node.right);
	}
	
	void printPostOrder()
	{
		printPostOrder(root);
	}
	
	void printPostOrder(Node node)
	{
		if(node == null)
			return;
		
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.key + " ");
	}
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		System.out.println("Preorder traversal of tree is :");
		tree.printPreOrder();
		System.out.println();
		System.out.println("Inorder traversal of tree is :");
		tree.printInOrder();
		System.out.println();
		System.out.println("Postorder traversal of tree is :");
		tree.printPostOrder();
	}
	
	
		
	

}


