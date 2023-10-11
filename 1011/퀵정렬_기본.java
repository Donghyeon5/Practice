package algorithm.ch00;

import java.util.Arrays;

public class 퀵정렬_기본 {

	public static void main(String[] args) {
		int[]x= {5,7,1,4,6,2,3,9,8};
		quickSort(x,0,x.length-1);
		System.out.println(Arrays.toString(x));
	}
	public static void quickSort(int[]x, int left, int right) {
		int pl=left;
		int pr=right;
		int pivot=x[(pl+pr)/2];
		
		do {
			while(x[pl] < pivot) {
				pl++;
			}
			while(x[pr] > pivot) {
				pr--;
			}
			if(pl <= pr) {
				Util.swap(x, pl++, pr--);
			}
			
		}while(pl <=pr);
		if(left <pr) {
			quickSort(x,left,pr);
		}
		if(pl<right) {
			quickSort(x,pl,right);
		}
	}

}
