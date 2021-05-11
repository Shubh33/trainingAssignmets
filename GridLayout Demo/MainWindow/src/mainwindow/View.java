package mainwindow;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {
	public static final String ID = "MainWindow.view";

	@Inject
	IWorkbench workbench;

	TableViewer viewer;

//	private class StringLabelProvider extends ColumnLabelProvider {
//		
//		// getText method is used from super class ColumnLabelProvider
//
//		@Override
//		public Image getImage(Object obj) {
//			return workbench.getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
//		}
//
//	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);

		
//configure the table for display
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
		
		
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private List<String> createInitialDataModel() {
		return Arrays.asList("One", "Two", "Three");
	}
}