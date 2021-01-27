package com.kurshit.Raw;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while(T-- > 0) {
			s.solve(sc);
			System.out.println();
		}

		sc.close();
	}

	public void solve(Scanner sc) {

		int N = sc.nextInt();

		if(N == 0) {
			System.out.print(0);
			return;
		}
		int[] a = new int[N+1];
		int[] b = new int[N+1];
		int[] c = new int[N+1];

		for(int i=0; i< N; i++) {
			a[i] = sc.nextInt();
		}

		for(int i=0; i< N; i++) {
			b[i] = sc.nextInt();
		}

		for(int i=0; i< N; i++) {
			c[i] = sc.nextInt();
		}

		int p[] = new int[N];
		p[0] = a[0];
		for(int i=1;i<N;i++) {
			if(a[i] == p[i-1]) {
				if(b[i] == p[i-1]) {
					p[i] = c[i];
				}
				else {
					p[i] = b[i];
				}
			}
			else {
				p[i] = a[i];
			}

			if(a[N-1] == p[0] || a[N-1] == p[N-2]) {
				if(b[N-1] == p[0] || b[N-1] == p[N-2]) {
					p[N-1] = c[i];
				}
				else {
					p[N-1] = b[i];
				}
			}
			else {
				p[N-1] = a[i];
			}
		}


		for(int i=0;i<N;i++) {
			System.out.print(p[i] + " ");
		}
	}

}
