package task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TaskOne {
	
	public static void main(String[] args) {
		
		// sorting people
		
		Person person1 = new Person("Bob", 50);
		Person person2 = new Person("Rob", 25);
		Person person3 = new Person("Tom", 30);
		
		Person[] people = new Person[]{person1, person2, person3};
		
		Arrays.sort(people, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
		System.out.println("By age: " + Arrays.toString(people));
		
		Arrays.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println("By name: " + Arrays.toString(people));
		
		Arrays.asList(people).forEach(System.out::println);
		
		
		
		// standard interfaces
		
		Consumer<String> consumer = str -> System.out.println("Consumer says " + str);
		consumer.accept("what");
		
		Predicate<Person> personPredicate = person -> {
			Person testPerson = new Person("Bob", 50);
			return testPerson.equals(person);
		};
		System.out.println(personPredicate.test(person2));
		
		Function<Integer, Integer> plus10 = number -> number + 10;
		System.out.println(plus10.apply(10));
		
		
		// my own interface
		
		Logger anonymousLogger = new Logger() {
			@Override
			public void log(String string) {
				System.out.println("VIA ANONYMOUS CLASS: " + string);
			}
		};
		
		Logger lambdaLogger = message -> System.out.println("VIA LAMBDA EXPRESSION: " + message);
		
		anonymousLogger.log("Message to log");
		lambdaLogger.log("Message to log");
		
		anonymousLogger.defaultHello();
		Logger.staticHello();
		
		
		// Runnable
		
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("IN A THREAD");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("IN A SECOND THREAD");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		thread1.start();
	}
}
