package algorithm.ch00;

import java.util.Arrays;

public class SortEx3 {

	public static void main(String[] args) {
		int[] array= {6,4,2,1,3,5};
		System.out.println(Arrays.toString(array));
		for(int i=1; i<array.length; i++) {
			int j=i;
			int tmp = array[i];
			
			while(j>0 && array[j-1] > tmp) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = tmp;
			System.out.println(Arrays.toString(array));
		}
		
	}

}
