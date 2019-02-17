
import java.awt.BorderLayout;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class Restaurant{
    
//    Runner
        public static void main(String[] args) {
//            init
            init();
//            Scanner sc = new Scanner(System.in);
//            First Panel
            JPanel firstPanel = new JPanel();
            JTextField ufield = new JTextField(10);
            JTextField pfield = new JPasswordField(10);
            
            firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));
//            firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.Y_AXIS));
            firstPanel.add(new JLabel("Input Username:"));
            firstPanel.add(Box.createVerticalStrut(15)); // a spacer
            firstPanel.add(ufield);
            firstPanel.add(Box.createVerticalStrut(15)); // a spacer
            firstPanel.add(new JLabel("Input Password:"));
            firstPanel.add(Box.createVerticalStrut(15)); // a spacer
            firstPanel.add(pfield);
            firstPanel.add(Box.createVerticalStrut(15)); // a spacer
            JOptionPane.showConfirmDialog(null, firstPanel, "Welcome to SSRestaurant", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//            int menu;
            
            if (loginUser(ufield.getText(),pfield.getText()) == 1) {
//                Execute Owner Authorization
//                System.out.println("Owner Menu");
//                System.out.println("1. Users Options");
//                System.out.println("2. Menu Options");
                JPanel ownerPanel = new JPanel();
                JTextField inputField = new JTextField();
                ownerPanel.setLayout(new BoxLayout(ownerPanel, BoxLayout.Y_AXIS));
                ownerPanel.add(new JLabel("1.)Users Options"));
                ownerPanel.add(Box.createVerticalStrut(15)); // a spacer
                ownerPanel.add(new JLabel("2.)Menu Options"));
                ownerPanel.add(Box.createVerticalStrut(15)); // a spacer
                ownerPanel.add(inputField);
                JOptionPane.showConfirmDialog(null, ownerPanel, "Owner Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//                menu = sc.nextInt();
                switch(Integer.parseInt(inputField.getText())){
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
                 
                JFrame frame = new JFrame();
                frame.setLayout(new BorderLayout());
                JTable table = new JTable();
                 BufferedReader br = new BufferedReader(new FileReader("users.txt"));
                 String l;
                 UserTableModel model = new UserTableModel();
                 List<User> userList = new ArrayList<User>();
                 while((l = br.readLine()) != null){
                     String[] data = new String[0];
                     data = l.split(",");
                         User user = new User();
                         user.setUsername(data[1]);
                         user.setRole(Integer.parseInt(data[3]));
                         userList.add(user);
                 }
                 model.setList(userList);
                 table.setModel(model);
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.add(new JScrollPane(table));
                 frame.setTitle("Users Table");
                 frame.pack();
                 frame.setVisible(true);
                  System.out.println("Users Table Loaded");
              
             } catch (Exception e) {
                  System.out.println("Connection Error: "+e.getMessage());
             }
            
        }
         
         public static void menuTable() {
             try {

                JFrame frame = new JFrame();
                frame.setLayout(new BorderLayout());
                JTable table = new JTable();
                 BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
                 String l;
                 MenuTableModel model = new MenuTableModel();
                 List<Menu> menuList = new ArrayList<Menu>();
                 while((l = br.readLine()) != null){
                     String[] data = new String[0];
                     data = l.split(",");
                         Menu menu = new Menu();
                         menu.setFoodname(data[1]);
                         menu.setPrice(Double.parseDouble(data[2]));
                         menuList.add(menu);
                 }
                 model.setList(menuList);
                 table.setModel(model);
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.add(new JScrollPane(table));
                 frame.setTitle("Menu Table");
                 frame.pack();
                 frame.setVisible(true);
                  System.out.println("Menu Table Loaded");
             } catch (Exception e) {
                  System.out.println("Connection Error: "+e.getMessage());
             }
        }
}