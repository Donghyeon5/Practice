package java_study.chapter13.seco1;

public class SerializableWriter {

	public static void main(String[] args) {
		ClassA classA = new ClassA();

		classA.field1 = 1;
		classA.field2.field1 = 2;
		classA.field3 = 3;
		classA.field4 = 4;

		try {
			Serializer.save("c:/temp/object2.dat", classA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

//// TODO Auto-generated method stub
//try (FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);) {
//	ClassA classA = new ClassA();
//
//	classA.field1 = 1;
//	classA.field2.field1 = 2;
//	classA.field3 = 3;
//	classA.field4 = 4;
//
//	oos.writeObject(classA);
//	oos.flush();
//} catch (Exception e) {
//	e.printStackTrace();
//}
//}
