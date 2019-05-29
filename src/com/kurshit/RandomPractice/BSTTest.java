package com.kurshit.RandomPractice;

public class BSTTest {

	public static void main(String[] args) {

		BST bst = new BST();

		bst.insert(50);
		bst.insert(80);
		bst.insert(90);

		System.out.println(bst.hasNode(90));
		System.out.println(bst.hasNode(50));
		System.out.println(bst.hasNode(80));
		System.out.println(bst.hasNode(8));
		System.out.println(bst.hasNode(-90));
		System.out.println(bst.hasNode(79));
	}

}
