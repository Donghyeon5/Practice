package algorithm.ch00;

import java.util.Arrays;
import java.util.Random;

public class 배열의최대값찾기 {

	public static void main(String[] args) {
		
		int[] num = new int[1000];
		Random r = new Random();
		for(int i =0; i<num.length; i++) {
			num[i] = r.nextInt(1000);
		}
		Arrays.sort(num); // 오름차순 정렬
		// 파괴함수
		for(int x :num) {
			System.out.println(x);
		}
		System.out.println("제일 큰 수 >>>" + num[num.length-1]);
		System.out.println("제일 작은 수 >>> " + num[0]);
	}

}
