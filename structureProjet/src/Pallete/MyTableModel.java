package Pallete;

import javax.swing.AbstractListModel;

public class MyTableModel extends AbstractListModel {
    
	private String [] fieldsNames;
	private Object [][]  data;
	
	 public void initClientsFields(String...colNames)
	public String getColumnName(int col) { return fieldsNames[col];}
	public  int getRowCount() {return data.length;}
	public int getColumnsCount () { return fieldsNames.length;}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	/* this.fireTableDtaChanged();

}
