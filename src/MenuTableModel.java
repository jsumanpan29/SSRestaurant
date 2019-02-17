

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;
class MenuTableModel extends AbstractTableModel {

        private List<Menu> list = new ArrayList<Menu>();
        private String[] columnNames = {"Name", "Price"};

        public void setList(List<Menu> list) {
            this.list = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public int getRowCount() {
            return list.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getFoodname();
            case 1:
                return list.get(rowIndex).getPrice();
            default:
                return null;
            }
        }
    }