package java_study.chapter10;

public class CatchByExceptionKindExample {

	public static void main(String[] args) {
		System.out.println(args);
		System.out.println(args.length);
		System.out.println(args[0]);
		System.out.println(args[1]);

		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("실행 매개값의 수가 부족합니다.");
		} catch (Exception e) { // 보통 exception으로 퉁치고 ↓ 아래 정보로 확인
			System.out.println(e);
			e.printStackTrace();
			System.err.println("문제가 있는 듯 합니당~");
		} finally {
			System.out.println("다시 실행하세요.");
		}

	}

}
