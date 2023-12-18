package org.example;
import javax.print.attribute.standard.Copies;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.example.Main.lib;
import static org.example.Main.mem;

class Book {
    int book_ID;
    String[] title1;
    String title;
    String author;
    int total_copies;
    long start_time;
    long end_time;
    int due_date;
    public static HashMap<String, Integer> title_copies = new HashMap<>();
    public static HashMap<String, String> title_author = new HashMap<>();
    public static HashMap<Integer, String> bookID_title = new HashMap<>();
    public static HashMap<String, Integer> title_bookID = new HashMap<>();

    public void add_B_mem2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Book title: ");
        title = sc.nextLine();
        System.out.println("Author: ");
        author = sc.nextLine();
        System.out.println("Copies: ");
        total_copies = sc.nextInt();
        for (int i = 1; i < total_copies + 1; i++) {
            bookID_title.put(i, title + "(" + i + ")");
        }
        for (Map.Entry<Integer, String> f : bookID_title.entrySet()) {
            title_bookID.put(f.getValue(), f.getKey());
        }
        title_author.put(title, author);
        title_copies.put(title, total_copies);
        System.out.println("Book added successfully");
        Main.lib();
    }

    public void remove_B_mem2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Book title: ");
        title = sc.nextLine();
        System.out.println("Author: ");
        author = sc.nextLine();
        System.out.println("Copy ");
        total_copies = sc.nextInt();
        for(int i=1;i<total_copies+1;i++){
        if(title_bookID.containsKey(title + "(" + i + ")")) {
            title_bookID.remove(title + "(" + i + ")");
        }
        }
        if (title_copies.containsValue(total_copies)) {
            if (title_author.containsValue(author)) {
                title_author.remove(title);
                title_copies.remove(title);
                title_bookID.remove(title);
                System.out.println("Book removed from library");
                Main.lib();
            }
        }
    }

    public  void view_book() {
        for (Map.Entry<String,Integer> f : title_bookID.entrySet()) {
            System.out.println("BOOK: " + f.getKey() + " BOOK ID: " + f.getValue());
        }
        Main.lib();
}
    public void view_book_2() {
        for (Map.Entry<String,Integer> f : title_bookID.entrySet()) {
            System.out.println("BOOK: " + f.getKey() + " BOOK ID: " + f.getValue());
        }
        Main.mem();
    }
    public void view_book_3() {
        for (Map.Entry<String,Integer> f : title_bookID.entrySet()) {
            System.out.println("BOOK: " + f.getKey() + " BOOK ID: " + f.getValue());
        }
    }

    public void Due_date(){
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(10); // Calculate a due date 10 days from today
        System.out.println("Due date: " + dueDate);
    }
}
class Member{
    public static HashMap<Integer, String> ID_BookIssued = new HashMap<>();
    public static HashMap<String,Integer> BookIssued_ID = new HashMap<>();
    Library ok=new Library();
    LocalDateTime aok;
    String name;
    int fine_time;

    int books_holding=0;
    String issued_books;
    int book_id;
    int fines;
    static long a11;
    long a123;

    public void setStart_time(){
        a123=System.currentTimeMillis();
    }
    public long getStart_time(){
        return a123;
    }
    public void pay_fine2(long start_time,long end_time){
        LocalDateTime dateTime = LocalDateTime.now();
        Date d=new Date();
        Book a1=new Book();
        Member a=new Member();
        long T3=((end_time-start_time)/1000);
        if(T3>10){
            long fine_t=T3-10;
            long fines=fine_t*3;
            System.out.println("Successfully paid  " + fines +" rupees for the delay of " + fine_t + " days");
            T3=0;
        }else {
            System.out.println("NO FINE");
        }
        mem();
    }
    public void issue_book(){
        LocalDateTime dateTime = LocalDateTime.now();
        Date d=new Date();
        Book a=new Book();
        Scanner sc=new Scanner(System.in);
        if(books_holding>2){
            System.out.println("Members can hold at most 2 books at a time");
            mem();
        }
        a.view_book_3();
        System.out.println("Name of the book to be issued");
        issued_books =sc.nextLine();
        System.out.println("ID of the book to be issued");
        book_id=sc.nextInt();
        if(Book.title_bookID.containsValue(book_id)){
            if(Book.title_bookID.containsKey(issued_books + "(" + book_id + ")")){
                System.out.println("Book issued successfully");
                Main.start_T();




                books_holding++;
                BookIssued_ID.put(issued_books + "(" + book_id + ")",book_id);
                Book.title_bookID.remove(issued_books + "(" + book_id + ")");
                LocalDateTime a5=LocalDateTime.now();
                Main.mem();
            }
        }else {
            System.out.println("Book not available");
            mem();
        }

    }
    public void my_books(){
        for (Map.Entry< String,Integer> f : BookIssued_ID.entrySet()) {
            System.out.println("BOOK : " + f.getKey() + " BOOK ID: " + f.getValue());
        }
        mem();
    }
    public void return_book(){
        LocalDateTime dateTime=LocalDateTime.now();
        Member a3=new Member();
        Date d=new Date();
        Scanner sc=new Scanner(System.in);
        System.out.println("name of the book to be returned: ");
        issued_books=sc.nextLine();
        System.out.println("BOOK ID: ");
        book_id=sc.nextInt();
        //end_time= dateTime.getSecond();
        if(BookIssued_ID.containsKey(issued_books + "(" + book_id + ")" )){
            if(BookIssued_ID.containsValue(book_id)){
                System.out.println("book returned");
                Main.end_T();
                Book.title_bookID.put(issued_books + "(" + book_id + ")",book_id);
                BookIssued_ID.remove(issued_books + "(" + book_id + ")");
                System.out.println("Make sure to check if u have to pay fine");
                Main.mem();
            }
        }
        else {
            System.out.println("you did not issue this book");
            mem();
        }
    }
}
class Library {
    String name;
    int age;
    int phone_number;

    public static HashMap<Integer,String>number_name=new HashMap<>();
    public static HashMap<Integer,String>age_name=new HashMap<>();
    public static HashMap<String,Integer>name_fine=new HashMap<>();
    public void memberss(){
        for (Map.Entry< Integer,String> f : number_name.entrySet()) {
            System.out.println("Member:" + f.getValue());
            lib();
        }

    }

    public void add_mem1(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Name: ");
        name=sc.nextLine();
        System.out.println("Age: ");
        age=sc.nextInt();
        System.out.println("Number(last 5 digits): ");
        phone_number=sc.nextInt();
        number_name.put(phone_number,name);
        age_name.put(age,name);
        System.out.println("Member successfully registered");
        Main.lib();
    }
    public void remove_mem1(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Name: ");
        name=sc.nextLine();
        System.out.println("Age: ");
        age=sc.nextInt();
        System.out.println("Number: ");
        phone_number=sc.nextInt();
        if (number_name.containsKey(phone_number)){
            if(number_name.containsValue(name)){
                number_name.remove(phone_number);
                System.out.println("member removed");
                Main.lib();
            }
        }
        else {System.out.println("member not found");
            Main.lib();
        }
        }
    }

public class Main {
    static long start_time;
    static long end_time;
    public static void start_T(){
        start_time=System.currentTimeMillis();
    }
    public static void end_T(){
        end_time=System.currentTimeMillis();
    }
    public static void lib(){
        Library a1= new Library();
        Book a2=new Book();
        Scanner sc =new Scanner(System.in);
        System.out.println("1.   REGISTER MEMBER");
        System.out.println("2.   REMOVE MEMBER");
        System.out.println("3.   ADD BOOK");
        System.out.println("4.   REMOVE BOOK");
        System.out.println("5.   VIEW MEMBERS");
        System.out.println("6.   VIEW BOOKS");
        System.out.println("7.   BACK");
        int a99 = sc.nextInt();
        if (a99 == 1){
            a1.add_mem1();
        } else if (a99==2) {
            a1.remove_mem1();
        } else if (a99==3) {
            a2.add_B_mem2();

        } else if (a99==4) {
            a2.remove_B_mem2();

        } else if (a99==5) {
            a1.memberss();

        } else if (a99==6) {
            a2.view_book();


        } else if (a99==7) {
            start();
        }
    }
    public static void mem(){
        Library a1=new Library();
        Member a3=new Member();
        Book a2=new Book();
        Scanner sc=new Scanner(System.in);
        System.out.println("1.   LIST AVAILABLE BOOKS");
        System.out.println("2.   LIST MY BOOKS");
        System.out.println("3.   ISSUE BOOK");
        System.out.println("4.   RETURN BOOK");
        System.out.println("5.   PAY FINE");
        System.out.println("6.   BACK");
        int a = sc.nextInt();
        if (a == 1){
            a2.view_book_2();
        } else if (a==2) {
            a3.my_books();

        } else if (a==3) {
            a3.issue_book();

        } else if (a==4) {
            a3.return_book();

        } else if (a==5) {
            a3.pay_fine2(start_time,end_time);

        } else if (a==6){
            System.out.println("bye");
            start();
        }

    }
    public static void mem_login(){
        Library a1=new Library();
        Scanner sc=new Scanner(System.in);
        System.out.println("NAME: ");
        String naam=sc.nextLine();
        System.out.println("Phone number: ");
        int nomber=sc.nextInt();
        if (Library.number_name.containsKey(nomber)){
            if(Library.number_name.containsValue(naam)){
                System.out.println("Welcome member");
                mem();
            }
            else {
                System.out.println("Member not found");
                start();
            }
        }
        else {
            System.out.println("Member not found");
            start();
        }
    }



    public static void start(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Library portal initialized..");
        System.out.println("--------------------------");
        System.out.println("1.   Enter as a librarian");
        System.out.println("2.   Enter as a member");
        System.out.println("3.   EXIT");
        int a = sc.nextInt();
        if(a == 1) {
            System.out.println("Welcome librarian");
            lib();
        } else if (a == 2) {
            mem_login();
        } else if (a == 3) {
            System.out.println("BYE");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        start();
        Book a=new Book();
        }
    }

