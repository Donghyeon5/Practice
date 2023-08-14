package java_study.Pratice3.Pen;

public class penMain {

	public static void main(String[] args) {

		sharpPencil sharpPencil = new sharpPencil(10, 1);
		System.out.println("sharpPencil : " + sharpPencil.getInfo());

		BallPen ballPen = new BallPen(15, 2, "black");
		ballPen.refill(10);
		System.out.println("Ballpen : " + ballPen.getInfo());

		FountainPen fountainPen = new FountainPen(15, 2, "blue");
		System.out.println("FountainPen: " + fountainPen.getInfo());

	}

}
