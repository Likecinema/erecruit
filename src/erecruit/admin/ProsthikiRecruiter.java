package erecruit.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

public class ProsthikiRecruiter {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;


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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(352, 303);
		shell.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C5\u03C0\u03B5\u03CD\u03B8\u03C5\u03BD\u03BF\u03C5 \u03C0\u03C1\u03BF\u03C3\u03BB\u03AE\u03C8\u03B5\u03C9\u03BD");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setText("Username");
		lblUsername.setBounds(10, 10, 111, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 37, 111, 21);
		lblNewLabel.setText("Password");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(137, 7, 189, 21);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		label.setBounds(10, 64, 111, 21);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		label_1.setBounds(10, 91, 111, 21);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u0397\u03BC/\u03BD\u03AF\u03B1 \u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE\u03C2");
		label_2.setBounds(10, 118, 111, 21);
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setText("Email");
		lblEmail.setBounds(10, 145, 111, 21);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("\u0388\u03C4\u03B7 \u03C0\u03C1\u03BF\u03CB\u03C0\u03B7\u03C1\u03B5\u03C3\u03AF\u03B1\u03C2");
		label_4.setBounds(10, 172, 111, 21);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("\u0395\u03C4\u03B1\u03B9\u03C1\u03B5\u03AF\u03B1");
		label_5.setBounds(10, 199, 111, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(137, 37, 189, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(137, 64, 189, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(137, 91, 189, 21);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(137, 118, 189, 21);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(137, 145, 189, 21);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(137, 172, 189, 21);
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(137, 199, 189, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(10, 228, 316, 25);
		btnNewButton.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");

	}
}
