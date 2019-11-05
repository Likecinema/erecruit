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
		
		Button ProvoliProfilBtn = new Button(shell, SWT.NONE);
		ProvoliProfilBtn.setBounds(10, 10, 259, 25);
		ProvoliProfilBtn.setText("�������/������ ��������� ������");
		
		Button ProvoliAithsewnKaiAkurwshBtn = new Button(shell, SWT.NONE);
		ProvoliAithsewnKaiAkurwshBtn.setBounds(10, 41, 259, 25);
		ProvoliAithsewnKaiAkurwshBtn.setText("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u03B1\u03B9\u03C4\u03AE\u03C3\u03B5\u03C9\u03BD \u03BA\u03B1\u03B9 \u0391\u03BA\u03CD\u03C1\u03C9\u03C3\u03B7 \u03B1\u03AF\u03C4\u03B7\u03C3\u03B7\u03C2");
		
		Button AitisiSeTheshBtn = new Button(shell, SWT.NONE);
		AitisiSeTheshBtn.setBounds(10, 72, 259, 25);
		AitisiSeTheshBtn.setText("\u0391\u03AF\u03C4\u03B7\u03C3\u03B7 \u03C3\u03B5 \u03B8\u03AD\u03C3\u03B7");

	}
}
