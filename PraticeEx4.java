package java_study.chapter04;

import java.util.Scanner;

public class PraticeEx4 {

	public static void main(String[] args) {
		int sum = 0;
		float average = 0;
		int[] score = { 100, 88, 100, 100, 90 };

		for (int i = 0; i < score.length; i++) {
			sum += score[i];

		}
		average = sum / (float) score.length;
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + average);

		System.out.println("---------------------------------------------------");

		int[] score2 = { 79, 88, 91, 33, 100, 55, 95 };
		int max = score2[0];
		int min = score2[0];
		for (int i = 1; i < score2.length; i++) {
			if (max < score2[i]) {
				max = score2[i];
			} else if (min > score2[i]) {
				min = score2[i];
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

		System.out.println("---------------------------------------------------");

		int[] score3 = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < score3.length; i++) {
			System.out.print("점수 입력 >> ");
			score3[i] = sc.nextInt();

		}

	}

}
