package erecruit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AllagiKwdikou extends LoginWindow {

	protected Shell shell;
	private Text PaliosKwdikosTextBox;
	private Text NeosKwdikosTextBox;
	private Text EpanalipsiNeouKwdikouTextBox;

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

	protected void createContents() {
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		shell.setSize(382, 172);
		shell.setText("SWT Application");
		
		PaliosKwdikosTextBox = new Text(shell, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		PaliosKwdikosTextBox.setText(password);
		PaliosKwdikosTextBox.setBounds(210, 13, 146, 21);
		
		NeosKwdikosTextBox = new Text(shell, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		NeosKwdikosTextBox.setBounds(210, 37, 146, 21);
		
		EpanalipsiNeouKwdikouTextBox = new Text(shell, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		EpanalipsiNeouKwdikouTextBox.setBounds(210, 64, 146, 21);
		
		Label oldPasswordLabel = new Label(shell, SWT.NONE);
		oldPasswordLabel.setBounds(10, 16, 156, 15);
		oldPasswordLabel.setText("\u03A0\u03B1\u03BB\u03B9\u03CC\u03C2 \u03BA\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03C0\u03C1\u03CC\u03C3\u03B2\u03B1\u03C3\u03B7\u03C2");
		
		Label newPasswordLabel = new Label(shell, SWT.NONE);
		newPasswordLabel.setToolTipText("");
		newPasswordLabel.setText("\u039D\u03AD\u03BF\u03C2 \u03BA\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03C0\u03C1\u03CC\u03C3\u03B2\u03B1\u03C3\u03B7\u03C2");
		newPasswordLabel.setBounds(10, 45, 156, 15);
		
		Label repeatPasswordLabel = new Label(shell, SWT.NONE);
		repeatPasswordLabel.setText("\u0395\u03C0\u03B1\u03BD\u03AC\u03BB\u03B7\u03C8\u03B7 \u03BD\u03AD\u03BF\u03C5 \u03BA\u03C9\u03B4\u03B9\u03BA\u03BF\u03CD");
		repeatPasswordLabel.setBounds(10, 67, 156, 15);
		
		Label MinimaLathousLabel = new Label(shell, SWT.NONE);
		MinimaLathousLabel.setAlignment(SWT.CENTER);
		MinimaLathousLabel.setBounds(10, 91, 167, 32);
		
		Button button = new Button(shell, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (ElegxosPaliouKwdikou(PaliosKwdikosTextBox.getText()) == true) {
					if (AllagiKwdikou(NeosKwdikosTextBox.getText(), EpanalipsiNeouKwdikouTextBox.getText()) == true) {
						AllagiKwdikou(NeosKwdikosTextBox.getText(), EpanalipsiNeouKwdikouTextBox.getText());}
					else MinimaLathousLabel.setText("Διαφωνία μεταξύ νέου κωδικού κ επανάληψη νέου κωδικού");	
					}
				else MinimaLathousLabel.setText("Λάθος πληκτρολόγηση παλιού κωδικού");
			}
		});
		button.setBounds(210, 91, 146, 25);
		button.setText("\u0391\u03BB\u03BB\u03B1\u03B3\u03AE \u03BA\u03C9\u03B4\u03B9\u03BA\u03BF\u03CD");

	}
}
