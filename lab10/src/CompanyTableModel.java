import javax.swing.table.AbstractTableModel;

/**
 * Created by alex3 on 6/12/2017.
 */
public class CompanyTableModel extends AbstractTableModel {
    PrintTable printTable = new PrintTable();


    @Override
    public int getRowCount() {
        printTable.print();
        return printTable.companys.size();
    }
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return printTable.companys.get(r).getId();
            case 1:
                return printTable.companys.get(r).getName();
            default:
                return "";
        }

    }
}