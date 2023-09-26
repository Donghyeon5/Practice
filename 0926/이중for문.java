package algorithm.ch00;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class 이중for문 {

	public static void main(String[] args) {
//		for(int i = 0; i<10; i++) {
//			for(int j=0; j<10; j++) {
//				System.out.println(j + " ");
//			}
//			System.out.println();
//		}
//
		
//		int[] ages= {60,50,30,20,10};
//		
//		double[] weight = new double[5];
//		weight[0]=77.8;
//		weight[1]=45.5;
//		weight[2]=88.5;
//		weight[3]=99.5;
//		weight[4]=35.5;
//		
//		for(int i = 0; i<weight.length; i++) {
//			System.out.println(ages[i] + " : " + weight[i]);
//		}
//		for(double d: weight) {
//			System.out.println(d);
//		}
		
		// 램덤하게 배열값 넣기
//		Random r = new Random(100); // 시드값(100)을 주었기 때문에 여러번 돌려도 같은 값이 나옴
//		int[] numbers = new int[1000];
//		for(int i = 0; i < numbers.length; i++) {
//			numbers[i] = r.nextInt(101);
//		}
//		for(int i =0; i<numbers.length; i++) {
//			System.out.println(i +":" + numbers[i]);
//		}
		
		// 배열에 있는 값 카운트
//		Scanner sc = new Scanner(System.in);
//		double[] numbers = new double[5];
//		
//		for(int i =0; i< numbers.length; i++) {
//			numbers[i] = sc.nextDouble();
//		}
//		sc.close();
//		
//		for(double x : numbers) {
//			System.out.println(x);
//		}
//		int count = 0; // 카운트 초기화
//		for(int i = 0; i<numbers.length; i++) {
//			if(numbers[i] ==22.2) {
//				count++;
//				}
//			}
//		System.out.println("22.2.의 개수는" + count);
		
		// 각 숫자가 몇개씩 있는지 카운트 하기
		double[] numbers = {11.1,22.2,22.2,55.5,22.2,11.1,40.2};
		
		// 맵에서 key는 중복되면 안됨
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		
		for(double n :numbers) {
			 Integer count = map.get(n);
			 if(count == null) { // 처음 등장한 숫자
				 map.put(n, 1); // 초기값 1주고 저장
			 }else {
				 map.put(n,count+1);
			 }
		 }
		 // 결과 출력
		 for(double n : map.keySet()) {
			 System.out.printf("%.1f :%d개\n", n, map.get(n));
		 }
		}
	
		
	}


