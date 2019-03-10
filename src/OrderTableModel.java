
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class OrderTableModel extends AbstractTableModel{
    
     private List<Order> data = new ArrayList<Order>();
     private String[] columnNames = {"ID","Food Name","Price", "Quantity"};

    public void setList(List<Order> list) {
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
                return data.get(rowIndex).getFoodname();
            case 2:
                return data.get(rowIndex).getPrice();
            case 3:
                return data.get(rowIndex).getQuantity();
            default:
                throw new IndexOutOfBoundsException();
            }
    }
    
     @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Order order = data.get(rowIndex);
            switch (columnIndex){
                case 0:
                    order.setId(Double.valueOf((String)aValue.toString()).intValue());
                    break;
                case 1:
                    order.setFoodname((String)aValue);
                    break;
                case 2:
                     order.setPrice(Double.valueOf((String)aValue.toString()));
                     break;
                case 3:
                     order.setQuantity(Double.valueOf((String)aValue.toString()).intValue());
                     break;
                default:
                    break;
            }
            fireTableCellUpdated(rowIndex,columnIndex);
        }
        
        public void addRow(Order order){
            data.add(order);
            fireTableDataChanged();
        }

    

}