package algorithm.ch00;

import java.util.Scanner;

public class String처리 {
	public static void main(String[] args){


	String s = "나는 프로그래머야";
	String s2 = "진짜!!";
	
	System.out.println(s+s2);
	System.out.println(s.concat(s2));
	System.out.println(s.charAt(0));
	System.out.println(s.endsWith("야"));
	System.out.println(s.substring(3));
	System.out.println(s.substring(3,8));
	System.out.println(s.contains(s2));
	System.out.println(s.lastIndexOf("프"));
	System.out.println(s.toUpperCase());
	System.out.println(s.toLowerCase());
	System.out.println(s.length());
	System.out.println(s.replace("나","너"));
	
	String s3="참좋다";
	String s4="진짜좋다";
	System.out.println(s3.equals(s4));
	if(s3.length() > s4.length()) {
		System.out.println("s3가 더 많은 글자수");
	}else {
		System.out.println("s4가 더 많은 글자수");
	}
	
	String s5="나는 진짜 java programmer가 되었어";
	System.out.println(s5.toUpperCase());
	
	String s6="205621";
	if(s6.charAt(0)=='1') {
		System.out.println("남자");
	}else if (s6.charAt(0)=='2'){
		System.out.println("여자");
	}else {
		System.out.println("?");
		}
	
	
	String v ="감자,고구마,양파";
	String[] v2 = v.split(","); //{"감자", "고구마", "양파"}
	
	
	Scanner sc = new Scanner(System.in);
	System.out.println("일,월,화 날씨를 순서대로 정해보세요.(흐림,맑음)-----------------------------");
	String data = sc.next();
	String[] data2 = data.split(",");
	int count1 = 0, count2 = 0;
	for(int i=0; i<data2.length; i++) {
		if(data2[i].equals("흐림")) {
			count1++;
		}else {
			count2++;
		}
	}
	System.out.println("흐림의 개수" + count1);
	System.out.println("맑음의 개수" + count2);
	}
}
