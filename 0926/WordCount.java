package algorithm.ch00;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
	public static void main(String[] args){
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("일,월,화 날씨를 순서대로 정해보세요.(흐림,맑음)-----------------------------");
//		String data = sc.next();
//		String[] data2 = data.split(",");
//		Map <String, Integer> map = new HashMap<String, Integer>();
//		
//		for(String w :data2) {
//			 Integer count = map.get(w);
//			 if(count == null) { // 처음 등장한 숫자
//				 map.put(w, 1); // 초기값 1주고 저장
//			 }else {
//				 map.put(w,count+1);
//			 }
//		 }
//		
//		 for(String w : map.keySet()) {
//			 System.out.println("날씨는" + w);
//		 }
		 
//		 String all = "국어, 영어, 수학, 컴퓨터";
//		 // 1. String[]으로 바꾸기
//		 String[] all2 =all.split(",");
//		 // 공백 제거
//		 System.out.println(all2.length);
//		 System.out.println(all2[1]);
//		 for(int i = 0; i< all2.length; i++) {
//			 if(all2[i].contains(" ")){
//				 all2[i].replace(" ", "");
//			 }
//		 }
//		 // 과목수?
//		 int count = all2.length;
//		 System.out.println("과목수는? >> " + count);
//		 
//		 // 컴퓨터의 위치는?
//		 for(int i=0; i<all2.length; i++) {
//			 if(all2[i].equals("컴퓨터")) {
//				 System.out.println("컴퓨터의 인덱스 위치는 >> " + i);
//			 }
//		 }
		Scanner sc = new Scanner(System.in);
		System.out.println("전화번호 입력 >> ");
		String data = sc.next();
		String[] data2 = data.split(",");
		
		// 양쪽 공백을 제거
		System.out.println(data2.length);
		for(int i =0; i<data2.length; i++) {
			if(data2[i].contains(" ")) {
				data2[i].replace(" ", "");
			}
		}
		
		// -을 기준으로 분리해내기
		String[] data3 = data2.split("-");
		
		// 첫번째 문자열이 011이면 sk, 019이면 LG, 나머지이면 apple
		
		// 두번째 문자열의 길이가 4개 이상이면 최신폰 , 아니면 올드폰
		
		// 전체 전화번호의 길이가 10글자 이상이면 유효한 전화번호, 아니면 유효하지 않은 전화번호
		
		
		
		
	}
}
