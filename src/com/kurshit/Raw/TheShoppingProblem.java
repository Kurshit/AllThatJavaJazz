package com.hackerrank.datastructure.arrays;

import java.util.List;
import java.util.Scanner;

public class TheShoppingProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int price[],id[];
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		price = new int[n];
		id = new int[n];
		
		for(int i=0;i<n;i++){
			price[i] = sc.nextInt();
			id[i] = sc.nextInt();
		}
		
		int balance = m,k=0, temp, prevBoughtPrice=0, prevBoughtId=0;
		
		int itemsBought[] = new int[n];
		
		
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(price[j]>price[j+1]){
					temp = price[j];
					price[j] = price[j+1];
					price[j+1] = temp;
					
					temp = id[j];
					id[j] = id[j+1];
					id[j+1] = temp;
				}
			}
		}
		
		
		//for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(prevBoughtPrice==price[j] && id[j]>prevBoughtId){
				itemsBought[k-1]=id[j];
				prevBoughtId=id[j];
			}
			else if(price[j]<=balance){
				balance-=price[j];
				itemsBought[k++]=id[j];
				prevBoughtPrice=price[j];
				prevBoughtId=id[j];
			}
		}
		//}
		
		for(int i=0;i<n && itemsBought[i]>0;i++)
			System.out.println(itemsBought[i]);	
	}

}
