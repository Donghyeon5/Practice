package algorithm.ch00;

public class Solution {
	
	public int[] solution(int money) {
		int[] answer = {0,0};
		int price = 5500;
		answer[0] = money / price;
		answer[1] = money % price;
		return answer;
	}
}
