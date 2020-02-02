package com.kurshit.Raw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Raw2 {


	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1,3,4);
		List<Integer> l2 = Arrays.asList(5,2,9);
		List<Integer> l3 = Arrays.asList(8,7,6);
		
		List<List<Integer>> input = new ArrayList<>();
		input.add(l1);
		input.add(l2);
		input.add(l3);
		
		System.out.println(countSpecialElements(input));
		
		
	}

	static int countSpecialElements(List<List<Integer>> matrix) {

		int m = matrix.size();
        int n = matrix.get(0).size();
        
		int[][] arr = new int[m][n];
        
        int row=0;

        for(List<Integer> list : matrix) {

            int col = 0;

            for(int item: list) {
                arr[row][col] = item;
                col++;
            }

            row++;
        }

        int rowmax[] = new int[m];
        int rowmin[] = new int[m];
        int colmax[] = new int[n];
        int colmin[] = new int[n];

        for(int i=0; i<m; i++) {
            int rmin = Integer.MAX_VALUE;
            int rmax = Integer.MIN_VALUE;

            for(int j=0; j<n; j++){
                if(arr[i][j] > rmax) 
                    rmax = arr[i][j];
                
                if(arr[i][j] < rmin)
                    rmin = arr[i][j];
            }

            rowmax[i] = rmax;
            rowmin[i] = rmin;
        }

        for(int j=0; j< n; j++) {
            int cmin = Integer.MAX_VALUE;
            int cmax = Integer.MIN_VALUE;

            for(int i=0; i<m; i++) {
                if(arr[i][j] > cmax)
                    cmax = arr[i][j];

                if(arr[i][j] < cmin)
                    cmin = arr[i][j];
            }

            colmax[j] = cmax;
            colmin[j] = cmin;
        }

        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if((arr[i][j] == rowmax[i])
                    || arr[i][j] == rowmin[i]
                    || arr[i][j] == colmax[j]
                    || arr[i][j] == colmin[j])
                    count++;
            }
        }

        return count;
	}

	


}

