package erecruit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class CandidateWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CandidateWindow window = new CandidateWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
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
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		shell.setSize(287, 133);
		shell.setText("\u03A0\u03B1\u03C1\u03AC\u03B8\u03C5\u03C1\u03BF \u03A5\u03C0\u03BF\u03C8\u03B7\u03C6\u03AF\u03BF\u03C5");
		
		Button btnTest = new Button(shell, SWT.NONE);
		btnTest.setBounds(10, 10, 259, 25);
		btnTest.setText("Προβολή/αλλαγή στοιχείων προφίλ");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(10, 41, 259, 25);
		btnNewButton.setText("Προβολή αιτήσεων και αίτηση σε νέες θέσεις");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(10, 72, 259, 25);
		btnNewButton_1.setText("Ακύρωση υποψηφιότητας");

	}
}
