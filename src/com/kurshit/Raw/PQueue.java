package com.kurshit.Raw;

/**
 * Linked implementation of PriorityQueue
 * @author Tyler Stinson
 *
 * @param <T>
 */

class PQueue<T extends Comparable<T>> {

	private Node root;
	private int size;


	public PQueue() {
		root = null;
		size = 0;
	}

	/**
	 * Primary sort method. Check left and right children, swap with lowest weighted node.
	 * called recursively.	 * 
	 */
	private void sort(Node root) {

		if (root == null) return;

		//finds minimum weighted node
		Node child = getMinNode(root.left, root.right);

		//if child node < parent swap and recursively calls sort
		if (child != null && root.data.compareTo(child.data) > 0) {
			T temp = child.data;
			child.data = root.data;
			root.data = temp;
		}
	}

	/**
	 * Enques new data onto queue.	 
	 */

	public void push(T data) {
		size++;
		String bits = getCurBinary(size);
		this.root = push(data, root, bits);
	}

	//gets the minimum node amongst left and right child

	private Node getMinNode(Node first, Node second) {
		if (first == null) return null;
		if (second == null) return first; //dont need to check first as it SHOULD be the left child
		return first.data.compareTo(second.data) < 0 ? first : second;
	}

	private Node push(T data, Node root, String bits) {
		if (root == null) {
			return new Node(data);
		} else if (bits.charAt(0) == '0') {
			root.left = push(data, root.left, bits.substring(1));
		} else {
			root.right = push(data, root.right, bits.substring(1));
		}
		sort(root);
		return root;
	}

	/**
	 * Get binary value first empty slot in tree.
	 */

	private String getCurBinary(int size) {
		String bin = "";
		int temp = size;

		while(temp > 1) {
			bin = temp % 2 + bin;
			temp /= 2;
		}

		return bin;
	}


	public T poll() {
		if (size <= 0) return null;
		String bits = getCurBinary(this.size);
		this.size--;
		T data = root.data;
		this.root = pollUtil(root, bits);
		return data;
	}

	private Node pollUtil(Node root, String bits) {
		if (bits.length() == 0) {
			this.root.data = root.data;
			return null;
		} else if (bits.charAt(0) == '0') {
			root.left = pollUtil(root.left, bits.substring(1));
		} else {
			root.right = pollUtil(root.right, bits.substring(1));
		}

		sort(root);
		return root;
	}


	private class Node {
		T data;
		Node left;
		Node right;

		Node(T data) {
			this.data = data;
			this.left = null;
		}
	}

	public int size() {	
		return size;

	}
}