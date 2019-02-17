
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Restaurant{
    
//    Runner
        public static void main(String[] args) {
//            init
            init();
            Scanner sc = new Scanner(System.in);
            String uname;
            String pword;
            System.out.println("Welcome to SSRestaurant");
            System.out.println("Input Username:");
            uname = sc.nextLine();
            System.out.println("Input Password");
            pword = sc.nextLine();
            int menu;
            
            if (loginUser(uname,pword) == 1) {
//                Execute Owner Authorization
                System.out.println("Owner Menu");
                System.out.println("1. Users Options");
                System.out.println("2. Menu Options");
                menu = sc.nextInt();
                switch(menu){
                    case 1:
//                        show Users table
                        usersTable();
                        break;
                    case 2:
//                        shows Menu table
                        menuTable();
                        break;
                }
            }else{
//                Execute Cashier Authorization
            }
        }
        
//        Login username & password Method
        private static int loginUser(String u, String p) {
            int val = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader("users.txt"));
//                Get line && Compare Username and Password
                String l,un,pw;
//                 Get User Role
                int ur;
                while ((l = br.readLine()) !=null) {     
//                    {id,username,password,user_role}
                    un = l.split(",")[1];
                    pw = l.split(",")[2];
                     ur = Integer.parseInt(l.split(",")[3]);
                   
//                    Compare Username and Password
                    if (un.equals(u) && pw.equals(p)) {
                        if (ur == 1) {
                            val = 1;
                        }
                        else{
                            val = 2;
                        }
                    }
                }
                
            } catch (IOException e) {
                System.out.println("Connection Error: "+e.getMessage());
            }
//            prints value
            System.out.println(val);
            
            return val;
        }
//        Connection
        private static void init(){
            System.out.println("Initiating...");
//            users database
            usersInit();
//            food database
            menuInit();
            System.out.println("Init Complete");
        }
        
        private static void usersInit(){
            try {
                File f = new File("users.txt");
                if (f.createNewFile()) {
                    System.out.println("Users Creation Success!");
                }
                else if(f.exists()){
                    System.out.println("User file exists!");
                }
                else
                {
                    System.out.println("Users Creation Failed!");
                }
                System.out.println("Users Initiated!");
            } 
            
            catch (IOException e) {
                System.out.println("Connection Error: "+e.getMessage());
            }
        }
        
         private static void menuInit(){
            try {
                File f = new File("menu.txt");
                if (f.createNewFile()) {
                    System.out.println("Menu Creation Success!");
                }
                else if(f.exists()){
                    System.out.println("Menu file exists!");
                }
                else
                {
                    System.out.println("Menu Creation Failed!");
                }
                System.out.println("Menu Initiated!");
            } 
            
            catch (IOException e) {
                System.out.println("Connection Error: "+e.getMessage());
            }
        }
         
         public static void usersTable() {
             try {
                 BufferedReader br = new BufferedReader(new FileReader("users.txt"));
                 String l;
                 System.out.println("Users Tables");
                 while((l = br.readLine()) != null){
                     String[] data = new String[0];
                     data = l.split(",");
                     System.out.println("--------------------------------------------------");
                     for (int i = 0; i < data.length; i++) {
                         System.out.print(data[i]+ "|");
                     }
                     System.out.println();
                 }
             } catch (Exception e) {
             }
        }
         
         public static void menuTable() {
             try {
                 BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
                 String l;
                 System.out.println("Menu Table");
                 while ((l = br.readLine()) != null) {
                     String[] data = new String[0];
                     data = l.split(",");
                     for (int i = 0; i < data.length; i++) {
                         System.out.print(data[i] + "|");
                     }
                     System.out.println();
                     
                 }
             } catch (Exception e) {
             }
        }
}