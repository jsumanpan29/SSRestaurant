

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;
class UserTableModel extends AbstractTableModel {

        private List<User> list = new ArrayList<User>();
        private String[] columnNames = {"Username", "Role"};

        public void setList(List<User> list) {
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
                return list.get(rowIndex).getUsername();
            case 1:
                return list.get(rowIndex).getRole();
            default:
                return null;
            }
        }
    }