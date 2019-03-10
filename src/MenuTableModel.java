

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


import javax.swing.table.AbstractTableModel;
class MenuTableModel extends AbstractTableModel {

        private List<Menu> data = new ArrayList<Menu>();
        private String[] columnNames = {"ID","Name", "Price"};

        public void setList(List<Menu> list) {
            this.data = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public int getRowCount() {
            return data.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getId();
            case 1:
                return data.get(rowIndex).getFoodname();
            case 2:
                return data.get(rowIndex).getPrice();
            default:
                return null;
            }
        }
         @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Menu menu = data.get(rowIndex);
//            Double.valueOf(aValue.toString()).intValue()
            switch (columnIndex){
                case 0:
                    menu.setId(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
                    menu.setFoodname((String)aValue);
                    break;
                case 2:
                     menu.setPrice(Double.valueOf((String)aValue.toString()));
                     break;
                default:
                    break;
            }
            fireTableCellUpdated(rowIndex,columnIndex);
        }
        public void deleteRow(int row)
        {
//            Getting Row Data
           Menu menu = data.get(row);
//            for (User usr: list) {
                System.out.println("Menu Deleted: "+menu.getId()+","+menu.getFoodname()+","+menu.getPrice());
//            }
//              remove data from list
                data.remove(row);
                
                if(deleteFoodfromFile(row)){
//                 update table row components
                    fireTableRowsDeleted(row, row);
                }else{
                    data.add(row,menu);
                    JOptionPane.showMessageDialog(null, "Unable to delete");
                }
        }
          public void addRow(Menu menu){
            data.add(menu);
            if (addUsertoFile()) {
                fireTableDataChanged();
            }
        }
          
          
        public boolean addUsertoFile(){
             File Tf = new File("menu.txt");
                PrintWriter Upw = null;
                try 
                {
                    Upw = new PrintWriter(new FileWriter(Tf));
                   for (Menu menu : data )
                    {
                        System.out.println("Menu added to new File: "+menu.getId()+","+menu.getFoodname()+","+menu.getPrice());
                        Upw.println(menu.getId()+","+menu.getFoodname()+","+menu.getPrice());//Don't use Upw.println because the toString() method of UserInformation class is already using \n in last.
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
            
        public boolean deleteFoodfromFile(int index){
                File Tf = new File("menu.txt");
                PrintWriter Upw = null;
                try 
                {
                    Upw = new PrintWriter(new FileWriter(Tf));
                    for (Menu menu : data )
                    {
                        System.out.println("Menu added to new File: "+menu.getId()+","+menu.getFoodname()+","+menu.getPrice());
                        Upw.println(menu.getId()+","+menu.getFoodname()+","+menu.getPrice());//Don't use Upw.println because the toString() method of UserInformation class is already using \n in last.
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
        public void updateRow(){
                File Tf = new File("menu.txt");
                PrintWriter Upw = null;
                try 
                {
                    Upw = new PrintWriter(new FileWriter(Tf));
                    for (Menu menu : data )
                    {
                        System.out.println("Menu added to new File: "+menu.getId()+","+menu.getFoodname()+","+menu.getPrice());
                        Upw.println(menu.getId()+","+menu.getFoodname()+","+menu.getPrice());//Don't use Upw.println because the toString() method of UserInformation class is already using \n in last.
                    }
                    Upw.close();
//                    Tf.renameTo(Mf);
//                    Mf.delete();
                } catch (FileNotFoundException e1) {
                } catch (IOException ioe) {
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