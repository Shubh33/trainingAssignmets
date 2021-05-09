package com.vogella.databinding.example;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;

public class GridLayoutDemo {

	protected Shell shell;
	private Table table;

	private Display display;
	GridLayoutDemo demo;

	GridLayoutDemo() {
		demo = this;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GridLayoutDemo window = new GridLayoutDemo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(709, 648);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		creteMenu();

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		ScrolledComposite scrolledComposite = new ScrolledComposite(composite,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		TabFolder tabFolder = new TabFolder(scrolledComposite, SWT.NONE);

		TabItem tbtmEmployeeDetails = new TabItem(tabFolder, SWT.NONE);
		tbtmEmployeeDetails.setText("Employee Details");

		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(tabFolder,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmEmployeeDetails.setControl(scrolledComposite_1);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);

		TableViewer tableViewer = new TableViewer(scrolledComposite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
		tc1.setText("Name");
		TableColumn tc2 = new TableColumn(table, SWT.CENTER);
		tc2.setText("Department");
		TableColumn tc3 = new TableColumn(table, SWT.CENTER);
		tc3.setText("Designation");
		TableColumn tc4 = new TableColumn(table, SWT.CENTER);
		tc4.setText("Joining Date");
		TableColumn tc5 = new TableColumn(table, SWT.CENTER);
		tc5.setText("Gender");
		TableColumn tc6 = new TableColumn(table, SWT.CENTER);
		tc6.setText("School");
		TableColumn tc7 = new TableColumn(table, SWT.CENTER);
		tc7.setText("Passing Year");

		tc1.setWidth(70);
		tc2.setWidth(70);
		tc3.setWidth(80);
		tc4.setWidth(70);
		tc5.setWidth(70);
		tc6.setWidth(80);
		tc7.setWidth(70);
		table.setHeaderVisible(true);

		scrolledComposite_1.setContent(table);
		scrolledComposite_1.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		TabItem tabHistory = new TabItem(tabFolder, SWT.NONE);
		tabHistory.setText("History");

		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("New Item");

		TabItem tbtmNewItem_2 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_2.setText("New Item");
		scrolledComposite.setContent(tabFolder);
		scrolledComposite.setMinSize(tabFolder.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		TreeViewer treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		treeViewer.setContentProvider(new FileTreeContentProvider());
		treeViewer.setLabelProvider(new FileTreeLabelProvider());
		treeViewer.setInput("root");

	}

	private void creteMenu() {
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);

		MenuItem menuItemFile = new MenuItem(menuBar, SWT.CASCADE);
		menuItemFile.setText("File");

		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		menuItemFile.setMenu(fileMenu);

		MenuItem newFileItem = new MenuItem(fileMenu, SWT.DROP_DOWN);
		newFileItem.setText("New");

		newFileItem.addSelectionListener(new NewMenuItemListner());
		MenuItem fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
		fileSaveItem.setText("&Save");
//		fileSaveItem.addSelectionListener(listener);

		MenuItem fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("E&xit");
		fileExitItem.addSelectionListener(new fileExitItemListener());

		MenuItem menuItemEdit = new MenuItem(menuBar, SWT.CASCADE);
		menuItemEdit.setText("Edit");

		MenuItem menuItemSource = new MenuItem(menuBar, SWT.CASCADE);
		menuItemSource.setText("Source");

		MenuItem menuItemRefactor = new MenuItem(menuBar, SWT.NONE);
		menuItemRefactor.setText("New Item");
	}

	class fileSaveItemListener implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
//	      label.setText("Saved");
		}

		public void widgetDefaultSelected(SelectionEvent event) {
//	      label.setText("Saved");
		}
	}

	public void processTableModel(List<String> data) {
		TableItem item1 = new TableItem(table, SWT.NONE);
		item1.setText(data.toArray(new String[0]));
	}

	class NewMenuItemListner implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
//	      label.setText("No worries!");
			System.out.println("New Menu clicked!!");
			try {
				EmployeeDetails window = new EmployeeDetails(demo);
				window.open();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void widgetDefaultSelected(SelectionEvent event) {
//	      label.setText("No worries!");
		}
	}

	class fileExitItemListener implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
			shell.close();
			display.dispose();
		}

		public void widgetDefaultSelected(SelectionEvent event) {
			shell.close();
			display.dispose();
		}
	}

}
