package erecruit.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class ProsthikiAntikeim {

	protected Shell shell;
	private Text text;
	private Text text_1;
	
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
		shell.setSize(275, 300);
		shell.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03B1\u03BD\u03C4\u03B9\u03BA\u03B5\u03B9\u03BC\u03AD\u03BD\u03BF\u03C5");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 10, 109, 15);
		label.setText("\u038C\u03BD\u03BF\u03BC\u03B1 \u0391\u03BD\u03C4\u03B9\u03BA\u03B5\u03B9\u03BC\u03AD\u03BD\u03BF\u03C5");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 31, 239, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 58, 137, 15);
		lblNewLabel.setText("\u03A0\u03B5\u03C1\u03B9\u03B3\u03C1\u03B1\u03C6\u03AE \u03B1\u03BD\u03C4\u03B9\u03BA\u03B5\u03B9\u03BC\u03AD\u03BD\u03BF\u03C5");
		
		text_1 = new Text(shell, SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
		text_1.setBounds(10, 79, 239, 142);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(10, 226, 239, 25);
		btnNewButton.setText("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");

	}

}
