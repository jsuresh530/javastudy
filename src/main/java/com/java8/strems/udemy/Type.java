package com.java8.strems.udemy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Book {
    private String author;
    private String title;
    private int pages;
    private Type type;

    public Book(String author, String title, int pages, Type type) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", type=" + type +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<> ();
        names.add ("Suresh");
        names.add ("babu");
        names.add ("bro");

        // final Stream<String> stream = names.stream ();

        List<Book> books = new ArrayList<> ();
        books.add (new Book ("Being and Time", "HS", 45, Type.HORROR));
        books.add (new Book ("ALone and Time", "KS", 560, Type.COMEDY));
        books.add (new Book ("FLY", "HS", 222, Type.FICTION));


        List<String> titles = new ArrayList<> ();
        books.stream ().forEach (System.out::println);

        //max no of pages
        books.stream ().map (Book::getPages).reduce (Integer::max)
                .ifPresent (System.out::println);

        //longest book
        final Optional<Book> longest = books.stream ()
                .reduce ((b1, b2) -> b1.getPages () > b2.getPages () ? b1 : b2);
        longest.ifPresent (System.out::println);

        final int sumPages = books.stream ().mapToInt (Book::getPages).sum ();

        final IntStream intStream = books.stream ().mapToInt (Book::getPages);

        final Stream<Integer> boxed = intStream.boxed ();


        final OptionalInt max = books.stream ().mapToInt (Book::getPages).max ();
        //maptodouble, maptolong

        System.err.println (max.orElse (0));

        final boolean result = books.stream ().allMatch (b -> b.getPages () > 1000);
        System.out.println (result);

        // Short circut : oprtaions that dont need to proces the whole stream tp produce the result
        final boolean noneMatch = books.stream ().noneMatch (b -> b.getPages () > 100);
        System.out.println (noneMatch);

        //parallelization findany returns arbitary elment
        //findFirst -- sequential
        //findAny -- with parallelization
        books.stream ().filter (b -> b.getType () == Type.HORROR).findAny ()
                .ifPresent (System.out::println);


        //external iteration
        // sequential internal movement
        final Iterator<Book> iterator = books.iterator ();
        while (iterator.hasNext ()) {
            titles.add (iterator.next ().getTitle ());
        }
        //parallel stream

        final List<Type> collect1 = books.stream ().map (Book::getType).collect (Collectors.toList ());

        collect1.forEach (e -> System.out.println (e));

        // final List<Book> collect = books.stream ().filter (t -> t.getType () == Type.COMEDY).collect (Collectors.toList ());
        //final List<Book> collect = books.stream ().filter (t -> t.getType () == Type.COMEDY).sorted (Comparator.comparing (Book::getAuthor)).collect (Collectors.toList ());


        final List<String> collect = books.stream ().filter (t -> t.getType () == Type.COMEDY)
                .sorted (Comparator.comparing (Book::getAuthor))
                .map (Book::getTitle)
                .collect (Collectors.toList ());

        collect.stream ().forEach (System.out::println);
        System.err.println (Arrays.toString (collect.toArray ()));


        final Map<String, List<Book>> booksByAUthor = books.stream ().
                collect (Collectors.groupingBy (Book::getAuthor));
        booksByAUthor.entrySet ().stream ().forEach (System.out::println);

        final List<String> longestBooks = books.stream ().filter (p -> p.getPages () > 500)
                .map (Book::getAuthor)
                .limit (2)
                .collect (Collectors.toList ());

        longestBooks.stream ().forEach (System.out::println);


        books.stream ().filter (b -> b.getTitle ().split (" ").length == 2)
                .collect (Collectors.toList ()).forEach (System.out::println);


        books.stream ().filter (p -> {
                    System.out.println ("FIltering " + p.getTitle ());
                    return p.getPages () > 500;
                })
                .map (b -> {
                    System.out.println ("Mapping " + b.getTitle ());
                    return b.getTitle ();
                }).limit (2).collect (Collectors.toList ());
    }
}

public enum Type {

    NOVEL, FICTION, COMEDY, HORROR;
}
