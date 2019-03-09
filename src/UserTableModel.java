

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;


import javax.swing.table.AbstractTableModel;
class UserTableModel extends AbstractTableModel {

        private List<User> data = new ArrayList<User>();
        private String[] columnNames = {"ID","Username","Password", "Role"};

        public void setList(List<User> list) {
            this.data = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
        @Override
        public int getRowCount() {
            return data.size();
        }
        @Override
        public int getColumnCount() {
            return columnNames.length;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getId();
            case 1:
                return data.get(rowIndex).getUsername();
            case 2:
                return data.get(rowIndex).getPassword();
            case 3:
                return data.get(rowIndex).getRole();
            default:
                throw new IndexOutOfBoundsException();
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            User user = data.get(rowIndex);
//            Double.valueOf(aValue.toString()).intValue()
            switch (columnIndex){
                case 0:
                    user.setId(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
                    user.setUsername((String)aValue);
                    break;
                case 2:
                     user.setPassword((String)aValue);
                     break;
                case 3:
                     user.setRole(Double.valueOf((String)aValue.toString()).intValue());
                     break;
                default:
                    break;
            }
            fireTableCellUpdated(rowIndex,columnIndex);
        }
        @Override
        public boolean isCellEditable(int row, int col)
        {
            return false;
        }
        public void deleteRow(int row)
        {
//            Getting Row Data
           User user = data.get(row);
//            for (User usr: list) {
                System.out.println("User Deleted: "+user.getId()+","+user.getUsername()+","+user.getRole());
//            }
//              remove data from list
                data.remove(row);
                
                if(deleteUserfromFile(row)){
//                 update table row components
                    fireTableRowsDeleted(row, row);
                }else{
                    data.add(row,user);
                    JOptionPane.showMessageDialog(null, "Unable to delete");
                }
        }
        
        public void addRow(User user){
            data.add(user);
            if (addUsertoFile()) {
                fireTableDataChanged();
            }
        }
         
        public void updateRow(){
            File Tf = new File("users.txt");
                PrintWriter Upw = null;
                try 
                {
                    Upw = new PrintWriter(new FileWriter(Tf));
                    for (User user : data )
                    {
                        System.out.println("User updated to new File: "+user.getId()+","+user.getUsername()+","+user.getRole());
                        Upw.println(user.getId()+","+user.getUsername()+","+user.getPassword()+","+user.getRole());//Don't use Upw.println because the toString() method of UserInformation class is already using \n in last.
                    }
                    Upw.close();
//                    Tf.renameTo(Mf);
//                    Mf.delete();
//                    return true;
                } catch (FileNotFoundException e1) {
//                    return false;
                } catch (IOException ioe) {
//                    return false;
                }
                finally 
                {
                    if (Upw != null)
                    {
                        try
                        {
                            Upw.close();
                        }
                        catch (Exception ex){}
                    }
                }
            
        
        }
       public boolean userNameExists(String username){
            for (User user: data) {
               if(user.getUsername().equals(username)){
                   return true;
               }
           }
            return false;
         }   
//        public boolean updateUserfromFile(){
//        
//        }
            
        public boolean deleteUserfromFile(int index){
                File Tf = new File("users.txt");
                PrintWriter Upw = null;
                try 
                {
                    Upw = new PrintWriter(new FileWriter(Tf));
                    for (User user : data )
                    {
                        System.out.println("User added to new File: "+user.getId()+","+user.getUsername()+","+user.getRole());
                        Upw.println(user.getId()+","+user.getUsername()+","+user.getPassword()+","+user.getRole());//Don't use Upw.println because the toString() method of UserInformation class is already using \n in last.
                    }
                    Upw.close();
//                    Tf.renameTo(Mf);
//                    Mf.delete();
                    return true;
                } catch (FileNotFoundException e1) {
                    return false;
                } catch (IOException ioe) {
                    return false;
                }
                finally 
                {
                    if (Upw != null)
                    {
                        try
                        {
                            Upw.close();
                        }
                        catch (Exception ex){}
                    }
                }
        }
        
        public boolean addUsertoFile(){
            File mainFile = new File("users.txt");
             File tempFile = new File("usersOutput.txt");
                PrintWriter Upw = null;
                try 
                {
                    Upw = new PrintWriter(new FileWriter(tempFile));
                    
                    for (User user : data )
                    {
                        System.out.println("User added to new File: "+user.getId()+","+user.getUsername()+","+user.getRole());
                        Upw.println(user.getId()+","+user.getUsername()+","+user.getPassword()+","+user.getRole());//Don't use Upw.println because the toString() method of UserInformation class is already using \n in last.
                    }
                    Upw.close();
                    if (mainFile.exists() && tempFile.exists()) {
                        mainFile.delete();
                        tempFile.renameTo(mainFile);
                        System.out.println ("\nUser Deleted!");
                    }
//                    if (!mainFile.delete()) {
//                          System.out.println("Could not delete file");
//                    }
//                    if (!tempFile.renameTo(mainFile)) {
//                         System.out.println("Could not rename file");
//                    }
                    return true;
                } catch (FileNotFoundException e1) {
                    return false;
                } catch (IOException ioe) {
                    System.out.println(ioe);
                    return false;
                }
                finally 
                {
                    if (Upw != null)
                    {
                        try
                        {
                            Upw.close();
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                        }
                    }
                }
        }
    }