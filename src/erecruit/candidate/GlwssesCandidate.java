//TODO APOTHIKEFSI


package erecruit.candidate;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

import erecruit.Main;
import erecruit.LoginWindow;

public class GlwssesCandidate extends AllagiStoixeiwnCandidate {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
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
		shell.setSize(320, 143);
		shell.setText("\u0393\u03BB\u03CE\u03C3\u03C3\u03B5\u03C2 \u03A5\u03C0\u03BF\u03C8\u03B7\u03C6\u03AF\u03BF\u03C5");
		
		text = new Text(shell, SWT.BORDER | SWT.V_SCROLL | SWT.WRAP| SWT.MULTI);
		text.setEditable(false);
		text.setBounds(10, 10, 284, 53);
		text.setText(EisagwghGlwsswn());
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(10, 69, 132, 25);
		button.setText("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(162, 69, 132, 25);
		btnNewButton.setText("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");

	}
	private String EisagwghGlwsswn() {
		String Query = ("SELECT lang from languages where languages.candid = '" + LoginWindow.username + "'");
		ResultSet Glwsses;
		try {
			Glwsses = Main.Connection().executeQuery(Query);
			Glwsses.first();
			String GlwssesCandidate = Glwsses.getString(1);
			return GlwssesCandidate;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "error";
		
	}

}
