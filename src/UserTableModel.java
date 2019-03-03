

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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


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
                return null;
            }
        }
//        @Override
//        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//            list.get(rowIndex).set(columnIndex,(String)aValue);
//            fireTableCellUpdated(rowIndex,columnIndex);
//        }
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
                System.out.println(user.getId() + " ID");
                System.out.println(user.getUsername() + " Name");
                System.out.println(user.getPassword()+ " Pword");
                System.out.println(user.getRole() + " Role");
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
//                System.out.println(list);
//                update table row components
//                fireTableDataChanged();
        }
        
        public boolean deleteUserfromFile(int index){
//               File Mf = new File("users_backup.txt");
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
    }