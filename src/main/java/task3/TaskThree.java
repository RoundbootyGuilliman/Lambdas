package task3;

public class TaskThree {
	
	
	
	public static void main(String[] args) {
		
		ThreeFunction concatenator = (str1, str2, str3) -> str1 + ", " + str2 + ", " + str3;
		ThreeFunction multiplier = (str1, str2, str3) -> String.valueOf(Integer.parseInt(str1) * Integer.parseInt(str2)
				* Integer.parseInt(str3));
		
		System.out.println(concatenator.execute("one", "two", "three"));
		System.out.println(multiplier.execute("5", "4", "6"));
	}
}
