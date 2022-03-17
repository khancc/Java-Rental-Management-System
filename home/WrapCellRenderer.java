package home;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

//tableCellRenderer to wrap the text in every cell in a table
public class WrapCellRenderer extends JTextArea implements TableCellRenderer {
    int rowHeight = 0;  // current max row height for this scan

    @Override
    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
        setText((value==null) ? "" : value.toString());
        setWrapStyleWord(true);
        setLineWrap(true);
        setEditable(false);

        // current table column width in pixels
        int colWidth = table.getColumnModel().getColumn(column).getWidth();
        // set the text area width (height doesn't matter here)
        setSize(new Dimension(colWidth, 1));
        //set margin around cell
        setMargin( new Insets(2,2,2,2) );
        // get the text area preferred height and add the row margin
        int height = getPreferredSize().height;
        // ensure the row height fits the cell with most lines

        if (column == 0 || height > rowHeight) {
            table.setRowHeight(row, height);
            rowHeight = height;
        }

        return this;
    }

    //convert arrayList to array for table model
    public static Object[][] arrayListToArray(ArrayList<ArrayList<Object>> arrayList){
        Object[][] array = new Object[arrayList.size()][5];
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Object> row = arrayList.get(i);
            array[i] = row.toArray(new Object[row.size()]);
        }
        return array;
    }

    //get listed propertyID from the table to set values for comboBox
    public static String[] getTablePropertyID(JTable table){
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0;i<table.getModel().getRowCount();i++)
            list.add(table.getModel().getValueAt(i,0).toString());

        if (list.size() == 0){
            return new String[]{"No property"};
        }

        return list.toArray(new String[0]);
    }
}
    
