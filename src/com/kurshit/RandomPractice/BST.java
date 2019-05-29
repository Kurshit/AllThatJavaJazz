package com.kurshit.RandomPractice;

import java.util.Stack;

public class BST {

	public static class Node {
		public Node left,right;
		public int data;

		public Node(int data) {
			this.data = data;
		}

	}

	public Node root;

	public void insert(int data) {
		root = insert(root,data);
	}

	public Node insert(Node newRoot, int data) {

		Node node = new Node(data);

		if(newRoot == null) {
			newRoot = node;
			return newRoot;
		}

		if(data < newRoot.data)
			newRoot.left = insert(newRoot.left,data);
		else
			newRoot.right = insert(newRoot.right,data);

		return newRoot;
	}

	public boolean hasNode(int data) {
		return hasNode(root,data);

	}

	public boolean hasNode(Node newRoot, int data) {

		boolean found = false;

		while(newRoot != null) {
			if(newRoot.data == data)
				return true;

			if(data<newRoot.data)
				newRoot = newRoot.left;
			else
				newRoot = newRoot.right;
		}

		return false;

	}

	public Node convertToBST(int[] pre, int size ) {
		Node root = new Node(pre[0]);

        Stack<Node> s = new Stack<Node>();

        // Push root
        s.push(root);

        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < size; ++i) {
            Node temp = null;

            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new Node(pre[i]);
                s.push(temp.left);
            }
        }

        return root;
	}


}
