package mainwindow;

import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class GridLayoutExample {

	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.makeColumnsEqualWidth = true;
		shell.setLayout(layout);

		// Create the big button in the upper left
		GridData data = new GridData(GridData.FILL_BOTH);
////		data.widthHint = 200;
		Button one = new Button(shell, SWT.PUSH);
		one.setText("Button");
		one.setLayoutData(data);

		// Create a composite to hold the three buttons in the upper right
		Composite composite = new Composite(shell, SWT.NONE);
		data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		composite.setLayoutData(data);
		layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = 15;
		composite.setLayout(layout);

		  String[] items = new String[] { "One", "two", "three", "four", "five", "six"};
	      int[] selection = new int[] { 0};

	      // Create MultiSelectCombo box
	      final MultiSelectionCombo combo = new MultiSelectionCombo(shell, items, selection, SWT.PUSH);
	      combo.setLayoutData(new GridData(GridData.FILL_BOTH));
		data = new GridData(GridData.FILL_BOTH);
		Button two = new Button(composite, SWT.PUSH);
		two.setText("two");
		two.setLayoutData(data);

		// Create button "three"
		data = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		Button three = new Button(composite, SWT.PUSH);
		three.setText("three");
		three.setLayoutData(data);

		// Create button "four"
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		Button four = new Button(composite, SWT.PUSH);
		four.setText("four");
		four.setLayoutData(data);

		// Create the long button across the bottom
		data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 3;
		data.heightHint = 150;
		
		//Set up the table layout
	    TableLayout tableLayout = new TableLayout();
	    tableLayout.addColumnData(new ColumnWeightData(100, 300, true));
	    tableLayout.addColumnData(new ColumnWeightData(100, 300, true));
	    tableLayout.addColumnData(new ColumnWeightData(100, 300,true));

	    Table table = new Table(shell, SWT.SINGLE);
	    table.setLayout(tableLayout);
//	    table.setLayoutData(new GridData(GridData.FILL_BOTH));
	    //Add columns to the table
	    TableColumn column1 = new TableColumn(table, SWT.CENTER);
	    TableColumn column2 = new TableColumn(table, SWT.CENTER);
	    TableColumn column3 = new TableColumn(table, SWT.CENTER);

	    TableItem item = new TableItem(table, SWT.PUSH);
	    item.setText( new String[] { "column 1",
	                                  "column 2",
	                                  "column 3" } );
	    item = new TableItem(table, SWT.PUSH);
	    item.setText( new String[] { "a", "b", "c" } );
//	    table.setLayoutData(new GridData(GridData.FILL_BOTH));
//		Button five = new Button(shell, SWT.PUSH);
//		five.setText("five");
//		five.setLayoutData(data);
//		final Table table = new Table(shell, SWT.PUSH);
//		table.setHeaderVisible(true);
//		for (int i = 0; i < 4; i++) {
//			TableColumn column = new TableColumn(table, SWT.NONE);
//			column.setText("Column " + i);
//		}
//		table.setLayoutData(data);
//		final TableColumn[] columns = table.getColumns();
//		for (int i = 0; i < 12; i++) {
//			TableItem item = new TableItem(table, SWT.NONE);
//			for (int j = 0; j < columns.length; j++) {
//				item.setText(j, "Item " + i);
//			}
//		}

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	private static TableViewer getTable(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);

		// configure the table for display
		TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnWeightData(33, true));
		layout.addColumnData(new ColumnWeightData(33, true));
		layout.addColumnData(new ColumnWeightData(33, true));

		viewer.getTable().setLayout(layout);
		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);

		TableColumn column1 = new TableColumn(viewer.getTable(), SWT.CENTER);
		column1.setText("Employee Name");

		TableColumn column2 = new TableColumn(viewer.getTable(), SWT.CENTER);
		column2.setText("Department ");
		TableColumn column3 = new TableColumn(viewer.getTable(), SWT.CENTER);
		column3.setText("Position");
		return viewer;
	}
	
	
//	private static createTable() {
//		//Set up the table layout
//	    TableLayout layout = new TableLayout();
//	    layout.addColumnData(new ColumnWeightData(33, 75, true));
//	    layout.addColumnData(new ColumnWeightData(33, 75, true));
//	    layout.addColumnData(new ColumnWeightData(33, 75, true));
//
//	    Table table = new Table(parent, SWT.SINGLE);
//	    table.setLayout(layout);
//
//	    //Add columns to the table
//	    TableColumn column1 = new TableColumn(table, SWT.CENTER);
//	    TableColumn column2 = new TableColumn(table, SWT.CENTER);
//	    TableColumn column3 = new TableColumn(table, SWT.CENTER);
//
//	    TableItem item = new TableItem(table, SWT.NONE);
//	    item.setText( new String[] { "column 1",
//	                                  "column 2",
//	                                  "column 3" } );
//	    item = new TableItem(table, SWT.NONE);
//	    item.setText( new String[] { "a", "b", "c" } );
//	}
}