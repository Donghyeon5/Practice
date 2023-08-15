package java_study.chapter10.exception;

public class BalancelnsufficientException extends Exception {
	public BalancelnsufficientException() {
	}

	public BalancelnsufficientException(String message) {
		super(message); // 잔액 부족 이유 설명
	}

}
