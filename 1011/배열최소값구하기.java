package algorithm.ch00;

import java.util.Arrays;
import java.util.Random;

public class 배열최소값구하기 {

	public static void main(String[] args) {
		
		int[] s =new int[1000];
		
		Random r = new Random();
		
		for(int i=0; i<s.length; i++) {
			s[i]= r.nextInt(999) + 1; // 0~998 -> 1~999
		}  // r.nextInt(size) + start Integer -> start ~ start+size
		System.out.println(Arrays.toString(s));
		
		// 최솟값
//		int min = s[0];
//		for(int x : s) {
//			if(x < min) {
//				min=x;
//			}
//		}
		
		int max = s[0];
		for(int x :s) {
			if (x > max) {
				max = x;
			}
		}
		System.out.println("최댓값 >> " + max);
		
		// 최대값이 몇 개인지 카운트
		int count =0;
		for(int x :s) {
			if(x== max) {
				count++;
			}
		}
		System.out.println("최대값의 개수는" + count + "개");
	}

}
