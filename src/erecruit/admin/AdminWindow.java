package erecruit.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import erecruit.Main;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AdminWindow {

	protected Shell shell;

	public void open() {
		Display display = Display.getDefault();
		createContents();
		Main.ExecuteTriggers();
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
		shell.setSize(249, 181);
		shell.setText("\u03A0\u03B1\u03C1\u03AC\u03B8\u03C5\u03C1\u03BF \u0394\u03B9\u03B1\u03C7\u03B5\u03B9\u03C1\u03B9\u03C3\u03C4\u03AE");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ProsthikiRecruiter PR = new ProsthikiRecruiter();
				PR.open();
			}
		});
		btnNewButton.setBounds(10, 10, 209, 25);
		btnNewButton.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C5\u03C0\u03B5\u03CD\u03B8\u03C5\u03BD\u03BF\u03C5 \u03C0\u03C1\u03BF\u03C3\u03BB\u03AE\u03C8\u03B5\u03C9\u03BD");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ProsthikiCandidate PC = new ProsthikiCandidate();
				PC.open();
			}
		});
		btnNewButton_1.setBounds(10, 41, 209, 25);
		btnNewButton_1.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03A5\u03C0\u03BF\u03C8\u03B7\u03C6\u03AF\u03BF\u03C5");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ProsthikiAntikeim PA = new ProsthikiAntikeim();
				PA.open();
			}
		});
		btnNewButton_2.setBounds(10, 72, 209, 25);
		btnNewButton_2.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u0391\u03BD\u03C4\u03B9\u03BA\u03B5\u03B9\u03BC\u03AD\u03BD\u03BF\u03C5");
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				IstorikoAllagwn IA = new IstorikoAllagwn();
				IA.open();
			}
		});
		btnNewButton_3.setBounds(10, 103, 209, 25);
		btnNewButton_3.setText("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u03BC\u03B5\u03C4\u03B1\u03B2\u03BF\u03BB\u03CE\u03BD \u03B1\u03BD\u03AC \u03C0\u03AF\u03BD\u03B1\u03BA\u03B1");

	}

}
