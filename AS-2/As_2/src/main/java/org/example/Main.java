package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static org.example.Visitor.Visitor_menu_2;
interface add_and_remove{
    public void add();
    public void remove();
}

class Admin extends Discount implements add_and_remove{
    Main ok1=new Main();

    String attraction_name;
    String attraction_description;
    static int attraction_price;
    static String op_cl;
    static Visitor v=new Visitor();
    static HashMap<String,String>name_schedule=new HashMap<>();
    static HashMap<String,String> name_description=new HashMap<>();
    static HashMap<String,Integer> name_Price=new HashMap<>();
    static HashMap<Integer,Integer>special_ticket_discount=new HashMap<>();

    public void schedule(){
        Scanner sc=new Scanner(System.in);
        System.out.println("pick attraaction");
        System.out.println(name_Price);
        attraction_name=sc.nextLine();
        if (name_description.containsKey(attraction_name)){
            System.out.println("you want attraction to be 1. open or 2. closed");
            int no=sc.nextInt();
            if (no==1){
                op_cl="open";
                name_schedule.put(attraction_name,op_cl);
                Main.Manage_attraction();
            } else if (no==2) {
                op_cl="closed";
                name_schedule.put(attraction_name,op_cl);
                Main.Manage_attraction();

            }
        }else {
            System.out.println("error");
            Main.Manage_attraction();
        }

    }


    public void add(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter attraction name");
        attraction_name=sc.nextLine();
        System.out.println("Enter description");
        attraction_description=sc.nextLine();
        System.out.println("enter price");
        attraction_price=sc.nextInt();
        name_description.put(attraction_name,attraction_description);
        name_Price.put(attraction_name,attraction_price);
        System.out.println("Attraction added successfully");
        ok1.Manage_attraction();
    }
    public void View_Attraction(){
        for (Map.Entry<String,String> f : Admin.name_description.entrySet()) {
            System.out.println("Name: " + f.getKey() + " Description: " + f.getValue());
    }
        ok1.Manage_attraction();
}
public void remove() {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter name");
    attraction_name = sc.nextLine();
    if (Admin.name_description.containsKey(attraction_name)) {
        Admin.name_description.remove(attraction_name);
        System.out.println("removed successfully");
        Main.Manage_attraction();
    } else {
        System.out.println("not found");
        Main.Manage_attraction();
    }
}

    public void Modify_Attraction(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name of attraction");
        attraction_name=sc.nextLine();
        System.out.println("enter new name");
        String new_name=sc.nextLine();
        System.out.println("enter new description");
        String new_des=sc.nextLine();
        if (name_description.containsKey(attraction_name)) {
            name_description.remove(attraction_name);
        }else {
            System.out.println("wrong info");
            Main.Manage_attraction();
        }
        name_description.put(new_name,new_des);
        System.out.println("Attraction modified");
        Main.Manage_attraction();
    }
    public void set_special_deals(){
        Visitor v=new Visitor();
        System.out.println("enter number of tickets to be bought for discount" );
        int ticket_no= sc.nextInt();
        System.out.println("enter the discount");
        int special_discount=sc.nextInt();
        special_ticket_discount.put(ticket_no,special_discount);
        System.out.println("special discounts added");
        Main.Admin_Menu_2();



    }
    public static void visit_attraction() {
        Scanner sc=new Scanner(System.in);

        System.out.println(attraction_price);
        System.out.println("enter name of attraction you want to visit");
        String attract = sc.nextLine();
        if (name_schedule.get(attract)!="closed"){

        if (name_Price.containsKey(attract)) {
            System.out.println("Buy our premium Membership and get special deals");
            System.out.println("1. bought");
            System.out.println("2. NO");
            int a = sc.nextInt();
            if (a == 1) {
                System.out.println("Thanks for visiting");
                Visitor_menu_2();
            } else if (a==2) {
                if ((v.ticket_price.containsKey(attract))) {
                    System.out.println("Thanks for visiting");
                    v.ticket_price.remove(attract);
                    Visitor_menu_2();
                } else {
                    System.out.println("ticket not available");
                    Visitor_menu_2();
                }

            }
            }
        }else {
            System.out.println("ticket not available");
            Visitor_menu_2();
        }
    }

            }



class Animal implements add_and_remove{
    static String animal_name;
    String animal_type;
    String description;
    static Visitor v=new Visitor();
    static HashMap<String,String> Animal_name_type=new HashMap<>();
    static HashMap<String,String> Animal_name_description=new HashMap<>();
    public void add(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter animal name");
        animal_name=sc.nextLine();
        System.out.println("Enter animal type {mammals,reptiles,amphibians}");
        animal_type=sc.nextLine();
        System.out.println("enter a description");
        description=sc.nextLine();
        Animal_name_type.put(animal_name,animal_type);
        Animal_name_description.put(animal_name,description);
        System.out.println("Animal added to Zoo");
        Main.Manage_Animals();
    }
    public void Update_animal(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the animal name");
        animal_name=sc.nextLine();
        if(Animal_name_type.containsKey(animal_name)){
            System.out.println("enter new details");
            animal_type=sc.nextLine();
            System.out.println("enter a description");
            description=sc.nextLine();
            Animal_name_type.put(animal_name,animal_type);
            Animal_name_description.put(animal_name,description);
            System.out.println("details updated");
            Main.Manage_Animals();
        }else {
            System.out.println("animal not found");
            Main.Manage_Animals();
        }
    }
    public void remove(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter animal name");
        animal_name=sc.nextLine();
        if (Animal_name_type.containsKey(animal_name)){
            Animal_name_type.remove(animal_name);
            Animal_name_description.remove(animal_name);
            System.out.println("Animal removed from zoo");
            Main.Manage_Animals();
        }
        else {
            System.out.println("animal not found");
            Main.Manage_Animals();
        }
    }
    public static void visit_animals(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose animal");
        System.out.println(Animal_name_type);
        animal_name=sc.nextLine();
        if (Animal_name_type.containsKey(animal_name)) {
            System.out.println("1.FEED");
            System.out.println("2 read about animal");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("the animal loves it and it is making noise showing appreciation");
                Visitor_menu_2();
            } else if (choice==2) {
                System.out.println(Animal_name_description.get(animal_name));
                Visitor_menu_2();
            }
        }

    }
}
class Discount{
    static Scanner sc=new Scanner(System.in);
    String D_category;
    int D_percentage;
    Main d=new Main();
    static HashMap<String,Integer> category_discount=new HashMap<>();
    public void add_discount(){
        System.out.println("enter discount category");
        D_category=sc.nextLine();
        System.out.println("enter discount percentage");
        D_percentage=sc.nextInt();
        category_discount.put(D_category,D_percentage);
        System.out.println("Discount added successfully");
        Main.Set_Discount();
    }
    public void modify_discount(){
        System.out.println("enter the category");
        D_category=sc.nextLine();
        System.out.println("enter the new discount");
        int new_discount= sc.nextInt();
        if (category_discount.containsKey(D_category)){
            category_discount.put(D_category,new_discount);
            System.out.println("discount modified successfully");
            Main.Set_Discount();
        }else {
            System.out.println("category not found");
            Main.Set_Discount();
        }
    }
    public void Remove_discount(){
        System.out.println("enter the category");
        D_category=sc.nextLine();
        if (category_discount.containsKey(D_category)){
            category_discount.remove(D_category);
            System.out.println("discount removed successfully");
            Main.Set_Discount();
        }else {
            System.out.println("category not found");
            Main.Set_Discount();
        }
    }
    public static void View_Discount(){
        System.out.println(category_discount);
        Visitor_menu_2();

    }
    public void View_Special(){
        Discount d=new Discount();
        for (Map.Entry<Integer,Integer> f : Admin.special_ticket_discount.entrySet()) {
            System.out.println("Buy" + f.getKey() + " Tickets and get " + f.getValue() + "% off");
        }
        Visitor_menu_2();
    }
    public void View_Special_2() {
        Discount d = new Discount();
        for (Map.Entry<Integer, Integer> f : Admin.special_ticket_discount.entrySet()) {
            System.out.println("Buy" + f.getKey() + " Tickets and get " + f.getValue() + "% off");
        }
    }


}
class Visitor{
    static Visitor_2 v=new Visitor_2();
    static Scanner sc=new Scanner(System.in);
    static String name;
    int age;
    int phone_number;
    static int balance;
    String email;
    String mail;
    String password;
    HashMap<String,String> email_password=new HashMap<>();
    static HashMap<String,Integer> ticket_price=new HashMap<>();
    static HashMap<String,String>name_feedback=new HashMap<>();
    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter email");
        mail=sc.nextLine();
        System.out.println("enter password");
        password=sc.nextLine();
        System.out.println("enter name");
        name=sc.nextLine();
        System.out.println("enter age");
        age=sc.nextInt();
        System.out.println("enter balance");
        balance=sc.nextInt();
        System.out.println("enter number");
        phone_number=sc.nextInt();
        System.out.println("registration successful");
        email_password.put(mail,password);
        Main.Visitor_menu_1();

    }
    public void login(){
        System.out.println("enter mail");
        email=sc.nextLine();
        System.out.println("enter password");
        password=sc.nextLine();
        if(email_password.containsKey(mail)){
                System.out.println("Login successful");
                Visitor_menu_2();

            }
        else {
            System.out.println("id not found");
            Main.Visitor_menu_1();
        }


    }
    public static void Buy_membership(){
        System.out.println("1. Basic Membership (₹20)");
        System.out.println("2. Premium Membership (₹50)");
        int m=sc.nextInt();
        if (m==1){
            if (((balance-20)>0)){
                balance=balance-20;
                System.out.println("Basic Membership purchased successfully. Your balance is now " + balance);
                Visitor_menu_2();
            }else {
                System.out.println("no money");
                Visitor_menu_2();
            }
        } else if (m==2) {
            if((balance-50)>0){
                balance=balance-50;
                System.out.println("Premium Membership purchased successfully. Your balance is now " + balance);
                Visitor_menu_2();
            }
        }else {
            System.out.println("insufficient funds");
            Visitor_menu_2();
        }
    }
    public static void Buy_Tickets(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Buy Tickets");
        System.out.println(Admin.name_Price);
        System.out.println("enter name of attraction you wanna buy");
        String naam=sc.nextLine();
        for (Map.Entry<String,Integer> f : Admin.name_Price.entrySet()) {
            if (Objects.equals(naam, f.getKey())){
                balance=balance-f.getValue();
                ticket_price.put(f.getKey(),f.getValue());
                System.out.println("The ticket for" +f.getKey() + " was purchased successfully. Your balance is now " + balance);
                Visitor_menu_2();
            }
        }
    }
    public static void Buy_Discount_Ticket(){
        Scanner sc=new Scanner(System.in);
        System.out.println(Discount.category_discount);
        String a= sc.nextLine();
        if (Discount.category_discount.containsKey(a)){
            System.out.println(Admin.name_Price);
            System.out.println("enter name of attraction you wanna buy");
            String naaam=sc.nextLine();
            for (Map.Entry<String,Integer> f : Admin.name_Price.entrySet()) {
                if (Objects.equals(naaam, f.getKey())){
                    balance=balance-(f.getValue()-((f.getValue()*Discount.category_discount.get(a))/100));
                    ticket_price.put(f.getKey(),f.getValue());
                    System.out.println("The ticket for" +f.getKey() + " was purchased successfully. Your balance is now " + balance);
                    Visitor_menu_2();
                }
            }
        }
    }

    public static void Visitor_menu_2(){
        Discount d=new Discount();
        System.out.println("visitor menu");
        System.out.println("1. Explore the Zoo");
        System.out.println("2. Buy Membership");
        System.out.println("3. Buy Tickets");
        System.out.println("4. View Discounts");
        System.out.println("5. View Special Deals");
        System.out.println("6. Visit Animals");
        System.out.println("7. Visit Attractions");
        System.out.println("8. Leave Feedback");
        System.out.println("9. Log Out");
        int l=sc.nextInt();
        if(l==1){
            v.zoo_explore();

        } else if (l==2) {
            Buy_membership();

        } else if (l==3) {
            Scanner sc=new Scanner(System.in);
            System.out.println("You have any discount codes? " +
                    "1. Yes " +
                    "2. No");
            int ans=sc.nextInt();
            if (ans==1){
                Buy_Discount_Ticket();
            }
            if (ans==2){
                Buy_Tickets();
            }

        } else if (l==4) {

            Discount.View_Discount();

        } else if (l==5) {
            d.View_Special();

        } else if (l==6) {
            Animal.visit_animals();

        } else if (l==7) {
            Admin.visit_attraction();

        } else if (l==8) {
            Feedback();

        } else if (l==9) {
            Main.start();
        }

    }
    public static void Feedback(){
        Scanner a=new Scanner(System.in);
        System.out.println("we would love to know your feedback");
        String feed=a.nextLine();
        name_feedback.put(name,feed);
        System.out.println("thank you for the feedback");
        Visitor_menu_2();
    }
}
class Visitor_2{
    Scanner sc=new Scanner(System.in);
    public void zoo_explore(){
        System.out.println("View Attractions");
        System.out.println("View Animals");
        System.out.println("Exit");
        int j=sc.nextInt();
        if (j==1){
            System.out.println(Admin.name_description);
            Visitor_menu_2();

        } else if (j==2) {
            System.out.println(Animal.Animal_name_type);
            Visitor_menu_2();
        } else if (j==3) {
            Visitor_menu_2();
        }
    }

}




public class Main {
    static Admin aj=new Admin();
    static Visitor v=new Visitor();
    public static void Admin_Menu_1(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username (username=a)");
        String name=sc.nextLine();
        System.out.println("enter password (password=a)");
        String pass=sc.nextLine();
        if (Objects.equals(name, "a")) {
            if (Objects.equals(pass, "a")) {
                Admin_Menu_2();
            }
            } else {
                System.out.println("wrong info");
                start();
            }

    }
    public static void Visitor_menu_1(){

        Scanner sc=new Scanner(System.in);
        System.out.println("1. Register");
        System.out.println("2. login");
        int a=sc.nextInt();
                if(a==1){
                    v.register();
                } else if (a==2) {
                    v.login();
                }
    }

    public static void Admin_Menu_2(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Admin Menu");
        System.out.println("1.Manage Attractions");
        System.out.println("2.Manage Animals");
        System.out.println("3.Schedule Events");
        System.out.println("4.Set Discounts");
        System.out.println("5.Set Special Deals");
        System.out.println("6. View Visitor Stats");
        System.out.println("7. View Feedback");
        System.out.println("8. Exit");
        int b=sc.nextInt();
        if (b==1){
            Manage_attraction();

        } else if (b==2) {
            Manage_Animals();

        } else if (b==3) {
            aj.schedule();
        } else if (b==4) {
            Set_Discount();
        } else if (b==5) {
            aj.set_special_deals();

        } else if (b==6) {

        } else if (b==7) {
            System.out.println(v.name_feedback);
            Admin_Menu_2();
        } else if (b==8) {
            start();
        }
    }
    public static void Set_Discount(){
        Discount D=new Admin ();
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Add Discount");
        System.out.println("2. Modify Discount");
        System.out.println("3. Remove Discount");
        System.out.println("4. Exit");
        int a=sc.nextInt();
        if(a==1){
            D.add_discount();
        } else if (a==2) {
            D.modify_discount();
        } else if (a==3) {
            D.Remove_discount();
        } else if (a==4) {
            Admin_Menu_2();
        }

    }
    public static void Manage_Animals(){
        Animal a2=new Animal();
        Scanner sc=new Scanner(System.in);
        System.out.println("Manage Animals");
        System.out.println("1.Add Animal");
        System.out.println("2. Update Animal Details");
        System.out.println("3. Remove Animal");
        System.out.println("4. Exit");
        int a1= sc.nextInt();
        if(a1==1){
            a2.add();
        } else if (a1==2) {
            a2.Update_animal();
        } else if (a1==3) {
            a2.remove();
        } else if (a1==4) {
            Admin_Menu_2();
        }
    }
    public static void Manage_attraction(){
        Admin ok=new Admin();
        Scanner sc=new Scanner(System.in);
        System.out.println("Manage Attractions");
        System.out.println("1. Add Attraction");
        System.out.println("2. view Attraction");
        System.out.println("3. modify Attraction");
        System.out.println("4. Remove Attraction");
        System.out.println("5. Exit");
        int a1= sc.nextInt();
        if(a1==1){
            ok.add();
        } else if (a1==2) {
            ok.View_Attraction();
        } else if (a1==3) {
            ok.Modify_Attraction();
        } else if (a1==4) {
            ok.remove();
        } else if (a1==5) {
            Admin_Menu_2();
        }

    }
    public static void start(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to ZOOtopia");
        System.out.println("1. Enter as Admin");
        System.out.println("2. Enter as a Visitor");
        System.out.println("3. View Special Deals");
        int a= sc.nextInt();
        if (a==1){
            Main.Admin_Menu_1();

        } else if (a==2) {
            Visitor_menu_1();

        } else if (a==3) {
            aj.View_Special_2();

        }

    }
    public static void main(String[] args) {
        start();
    }
}