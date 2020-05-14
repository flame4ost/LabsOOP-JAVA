

import entity.Product;

import javax.swing.table.AbstractTableModel;

public class TypeTableModel extends AbstractTableModel{
    PrintTable printTable = new PrintTable();


    @Override
    public int getRowCount() {
        printTable.print();
        return printTable.types.size();
    }
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return printTable.types.get(r).getId();
            case 1:
                return printTable.types.get(r).getName();
            default:
                return "";
        }

    }
}