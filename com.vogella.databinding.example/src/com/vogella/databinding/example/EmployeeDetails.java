package com.vogella.databinding.example;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.CallbackHandler;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EmployeeDetails {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	Display display;

	GridLayoutDemo demo;

	EmployeeDetails(GridLayoutDemo demo) {
		this.demo = demo;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EmployeeDetails window = new EmployeeDetails(null);
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
		shell.setSize(582, 455);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite.widthHint = 553;
		gd_composite.heightHint = 424;
		composite.setLayoutData(gd_composite);

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");

		text = new Text(composite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblDepartment = new Label(composite, SWT.NONE);
		lblDepartment.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDepartment.setText("Department");

		text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblDesignation = new Label(composite, SWT.NONE);
		lblDesignation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDesignation.setText("Designation");

		text_2 = new Text(composite, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblSelectStartDate = new Label(composite, SWT.NONE);
		lblSelectStartDate.setText("Select Joining Date");

		DateTime dateTime = new DateTime(composite, SWT.BORDER);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Gender");

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		Button btnMake = new Button(composite_1, SWT.RADIO);
		btnMake.setText("Make");

		Button btnFemale = new Button(composite_1, SWT.RADIO);
		btnFemale.setText("Female");
		new Label(composite, SWT.NONE);

		Group grpEducationDetails = new Group(composite, SWT.NONE);
		grpEducationDetails.setLayout(new GridLayout(2, false));
		GridData gd_grpEducationDetails = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_grpEducationDetails.widthHint = 370;
		gd_grpEducationDetails.heightHint = 102;
		grpEducationDetails.setLayoutData(gd_grpEducationDetails);
		grpEducationDetails.setText("Education Details");

		Label lblUniversty = new Label(grpEducationDetails, SWT.NONE);
		lblUniversty.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUniversty.setText("School");

		String[] items = new String[] { "Pune University", "Kolhapur University", "Nagpur University",
				"DElhi University", "Chennai University", "Gujrat University" };
		Combo combo = new Combo(grpEducationDetails, SWT.NONE);
		combo.setItems(items);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		Label lblPassingYear = new Label(grpEducationDetails, SWT.NONE);
		lblPassingYear.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPassingYear.setText("Passing Year");

		text_3 = new Text(grpEducationDetails, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_2.widthHint = 168;
		composite_2.setLayoutData(gd_composite_2);

		Button btnAdd = new Button(composite_2, SWT.NONE);
		btnAdd.setText("Add");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				List<String> employeeData = new ArrayList<String>();
				employeeData.add(text.getText());
				employeeData.add(text_1.getText());
				employeeData.add(text_2.getText());
				employeeData.add(dateTime.getYear() + "-" + dateTime.getMonth() + "-" + dateTime.getDay());
				String gender = "";
				if (btnMake.getSelection() == true) {
					gender = "Male";
				} else if (btnFemale.getSelection() == true) {
					gender = "Female";
				}
				employeeData.add(gender);
				employeeData.add(combo.getText());
				employeeData.add(text_3.getText());
				System.out.println("-------------" + employeeData);
				demo.processTableModel(employeeData);

			}
		});

		Button btnCancel = new Button(composite_2, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				shell.close();
				display.dispose();

			}
		});

	}

}
