//TODO APOTHIKEFSI

package erecruit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import java.sql.*;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ViografikoCandidate {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
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
		shell.setSize(452, 510);
		shell.setText("\u0392\u03B9\u03BF\u03B3\u03C1\u03B1\u03C6\u03B9\u03BA\u03CC \u03A5\u03C0\u03BF\u03C8\u03B7\u03C6\u03AF\u03BF\u03C5");
		
		text = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		text.setEditable(false);
		text.setBounds(10, 10, 416, 413);
		text.setText(EisagwgiViografikou());
		
		Button EditBtn = new Button(shell, SWT.NONE);
		EditBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				text.setEditable(true);
			}
		});
		EditBtn.setBounds(10, 436, 190, 25);
		EditBtn.setText("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1");
		
		Button ApothikefsiBtn = new Button(shell, SWT.NONE);
		ApothikefsiBtn.setBounds(206, 436, 220, 25);
		ApothikefsiBtn.setText("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");

	}
	private String EisagwgiViografikou() {
		try {
			String Query = ("SELECT bio from candidate where username = '" + LoginWindow.username + "'");
			ResultSet ViografikoRS = Main.Connection().executeQuery(Query);
			ViografikoRS.first();
			String bio = ViografikoRS.getString(1);
			return bio;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ("Error");
		
	}

}
