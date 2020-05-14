

import entity.Product;

import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel{
    PrintTable printTable = new PrintTable();


    @Override
    public int getRowCount() {
        printTable.print();
        return printTable.products.size();
    }
    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return printTable.products.get(r).getId();
            case 1:
                return printTable.products.get(r).getName();
            case 2:
                return printTable.products.get(r).getTypeId().getName();
            case 3:
                return printTable.products.get(r).getCompanyId().getName();
            default:
                return "";
        }

    }

}