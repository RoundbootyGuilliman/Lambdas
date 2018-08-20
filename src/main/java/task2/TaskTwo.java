package task2;

import java.util.*;
import java.util.stream.Stream;

public class TaskTwo {
	
	public static void main(String[] args) {
		
		Author author1 = new Author("Bob", (short)55, new ArrayList<>());
		Author author2 = new Author("Tom", (short)40, new ArrayList<>());
		Author author3 = new Author("Rob", (short)30, new ArrayList<>());
		
		Book book1  = new Book("Dune", new ArrayList<>(), 600);
		Book book2  = new Book("Bible", new ArrayList<>(), 500);
		Book book3  = new Book("Kolobok", new ArrayList<>(), 40);
		Book book4  = new Book("Harry Potter", new ArrayList<>(), 300);
		Book book5  = new Book("Lord of Flies", new ArrayList<>(), 150);
		
		author1.getBooks().add(book1);
		author2.getBooks().add(book2);
		author2.getBooks().add(book3);
		author3.getBooks().add(book3);
		author3.getBooks().add(book4);
		author3.getBooks().add(book5);
		
		book1.getAuthors().add(author1);
		book2.getAuthors().add(author2);
		book3.getAuthors().add(author2);
		book3.getAuthors().add(author3);
		book4.getAuthors().add(author3);
		book5.getAuthors().add(author3);
		
		Author[] authors = new Author[]{author1, author2, author3};
		Book[] books = new Book[]{book1, book2, book3, book4, book5};
		
		System.out.println("Does any of the books have more than 200 pages? " +
				Stream.of(books).anyMatch((book -> book.getNumberOfPages() > 200)));
		
		System.out.println("Do all of the books have more than 200 pages? " +
				Stream.of(books).allMatch((book -> book.getNumberOfPages() > 200)));
		
		System.out.println("The smallest book is " +
				Stream.of(books).min(Comparator.comparingInt(Book::getNumberOfPages)).get());
		
		System.out.println("The largest book is " +
				Stream.of(books).max(Comparator.comparingInt(Book::getNumberOfPages)).get());
		
		System.out.println("Books with only one author: " +
				Arrays.toString(Stream.of(books).filter(book -> book.getAuthors().size() == 1).toArray()));
		
		System.out.println("Sorted by number of pages: " +
				Arrays.toString(Stream.of(books).sorted(Comparator.comparingInt(Book::getNumberOfPages)).toArray()));
		
		System.out.println("Sorted by title: " +
				Arrays.toString(Stream.of(books).sorted(Comparator.comparing(Book::getTitle)).toArray()));
		
		System.out.println("All titles: ");
		Stream.of(books).parallel().forEach(System.out::println);
		
		System.out.println("All authors: " +
				Arrays.toString(Stream.of(books).flatMap(book -> book.getAuthors().stream()).distinct().toArray()));
	}
}
