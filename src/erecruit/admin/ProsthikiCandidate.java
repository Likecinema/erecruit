package erecruit.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class ProsthikiCandidate {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_5;
	private Text text_6;
	private Label label_7;
	private Label label_8;
	private Button btnNewButton;
	private Text text_4;
	private Text text_7;
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
		shell.setSize(356, 302);
		shell.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C5\u03C0\u03BF\u03C8\u03B7\u03C6\u03AF\u03BF\u03C5");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Username");
		label.setBounds(10, 13, 111, 21);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(137, 10, 189, 21);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(137, 40, 189, 21);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Password");
		label_1.setBounds(10, 40, 111, 21);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		label_2.setBounds(10, 67, 111, 21);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(137, 67, 189, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(137, 94, 189, 21);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		label_3.setBounds(10, 94, 111, 21);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("\u0397\u03BC/\u03BD\u03AF\u03B1 \u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE\u03C2");
		label_4.setBounds(10, 121, 111, 21);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("Email");
		label_5.setBounds(10, 148, 111, 21);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(137, 148, 189, 21);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(137, 121, 189, 21);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setText("\u0392\u03B9\u03BF\u03B3\u03C1\u03B1\u03C6\u03B9\u03BA\u03CC");
		label_6.setBounds(10, 175, 111, 21);
		
		label_7 = new Label(shell, SWT.NONE);
		label_7.setText("\u03A3\u03C5\u03C3\u03C4\u03B1\u03C4\u03B9\u03BA\u03AD\u03C2 \u0395\u03C0\u03B9\u03C3\u03C4\u03BF\u03BB\u03AD\u03C2");
		label_7.setBounds(10, 202, 124, 21);
		
		label_8 = new Label(shell, SWT.NONE);
		label_8.setText("\u03A0\u03C4\u03C5\u03C7\u03AF\u03B1");
		label_8.setBounds(10, 229, 111, 21);
		
		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(137, 175, 189, 21);
		btnNewButton.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u0392\u03B9\u03BF\u03B3\u03C1\u03B1\u03C6\u03B9\u03BA\u03BF\u03CD");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(137, 202, 189, 21);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(137, 229, 189, 21);

	}

}
