package algorithm.ch00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 배열원소의길이 {
	
	public static void main(String[] args) {
		int[]num = {11,55,33,22,44};
		int[]answer = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int x :num) {
			list.add(x);
		}
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
}
}