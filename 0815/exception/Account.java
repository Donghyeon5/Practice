package java_study.chapter10.exception;

public class Account {
	private long balance; // 현재 잔액

	public Account() { // 생성자,매개변수 초기화
	}

	public long getBalance() {// 잔액 알려주는 호출
		return balance;
	}

	public void deposit(int money) { // 입금하기
		balance += money;
	}

	public void withdraw(int money) throws BalancelnsufficientException {
		if (balance < money) {
			throw new BalancelnsufficientException("잔고부족:" + (money - balance) + " 모자람");
		}
		balance -= money;
	}

}
