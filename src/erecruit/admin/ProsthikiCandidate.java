package erecruit.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class ProsthikiCandidate {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ProsthikiCandidate window = new ProsthikiCandidate();
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
		shell = new Shell();
		shell.setSize(322, 290);
		shell.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C5\u03C0\u03B5\u03CD\u03B8\u03C5\u03BD\u03BF\u03C5 \u03C0\u03C1\u03BF\u03C3\u03BB\u03AE\u03C8\u03B5\u03C9\u03BD");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setText("Username");
		lblUsername.setBounds(10, 10, 100, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 37, 55, 21);
		lblNewLabel.setText("Password");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(121, 10, 76, 21);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		label.setBounds(10, 64, 55, 21);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		label_1.setBounds(10, 91, 55, 21);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("Password");
		label_2.setBounds(10, 118, 55, 21);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("Password");
		label_3.setBounds(10, 145, 55, 21);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("Password");
		label_4.setBounds(10, 172, 55, 21);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("Password");
		label_5.setBounds(10, 199, 55, 21);

	}
}
