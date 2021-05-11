package mainwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloSWT {

	public static void main(String[] args) {
		Display display = new org.eclipse.swt.widgets.Display();
		Shell shell = new Shell(display);
		
		Text helloWorldTest = new Text(shell, SWT.NONE);
		helloWorldTest.setText("Hello World SWT");
		helloWorldTest.pack();
		
		shell.pack(); //optional
		shell.open ();
		while (!shell.isDisposed ()) {
		    if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}
