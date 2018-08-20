package task1;

@FunctionalInterface
public interface Logger {

	void log(String message);
	
	default void defaultHello() {
		System.out.println("Hello from default method in interface");
	}
	static void staticHello() {
		System.out.println("Hello from static method in interface");
	}
}
