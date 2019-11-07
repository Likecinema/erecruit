package erecruit.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import erecruit.Main;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ProsthikiCandidate {

	protected Shell shell;
	private Text NewUsernameTextBox;
	private Text NewPasswordTextBox;
	private Text NewNameTextBox;
	private Text NewSurnameTextBox;
	private Text NewMailTextBox;
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
		shell.setSize(356, 248);
		shell.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C5\u03C0\u03BF\u03C8\u03B7\u03C6\u03AF\u03BF\u03C5");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("Username");
		label.setBounds(10, 13, 111, 21);
		
		NewUsernameTextBox = new Text(shell, SWT.BORDER);
		NewUsernameTextBox.setBounds(137, 10, 189, 21);
		
		NewPasswordTextBox = new Text(shell, SWT.BORDER);
		NewPasswordTextBox.setBounds(137, 40, 189, 21);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("Password");
		label_1.setBounds(10, 40, 111, 21);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		label_2.setBounds(10, 67, 111, 21);
		
		NewNameTextBox = new Text(shell, SWT.BORDER);
		NewNameTextBox.setBounds(137, 67, 189, 21);
		
		NewSurnameTextBox = new Text(shell, SWT.BORDER);
		NewSurnameTextBox.setBounds(137, 94, 189, 21);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		label_3.setBounds(10, 94, 111, 21);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("Email");
		label_5.setBounds(10, 121, 111, 21);
		
		NewMailTextBox = new Text(shell, SWT.BORDER);
		NewMailTextBox.setBounds(137, 121, 189, 21);
		
		
		Button AddCandidateButton = new Button(shell, SWT.NONE);
		AddCandidateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String NeoUsername = NewUsernameTextBox.getText();
				String NeoPassword = NewPasswordTextBox.getText();
				String NeoOnoma = NewNameTextBox.getText();
				String NeoEpitheto = NewSurnameTextBox.getText();
				String NeoEmail = NewMailTextBox.getText();
				try {
					ResultSet DateTimeRS = Main.Connection().executeQuery("SELECT NOW();");
					DateTimeRS.next();
					String datetime = DateTimeRS.getString(1);
					String InsertQuery = "INSERT INTO user (username, password, name, surname, reg_date, email) values\r\n ('"+NeoUsername+"', '"+NeoPassword+"','"+NeoOnoma+"','"+NeoEpitheto+"','"+datetime+"','"+NeoEmail+"');";
					Main.Connection().execute(InsertQuery);
					Main.Connection().execute("INSERT INTO candidate (username, bio, sistatikes, certificates) values ('"+NeoUsername+"', 'Placeholder', 'Placeholder', 'Placeholder');");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AddCandidateButton.setBounds(10, 176, 316, 25);
		AddCandidateButton.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C5\u03C0\u03BF\u03C8\u03B7\u03C6\u03AF\u03BF\u03C5");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBounds(10, 155, 316, 15);
		lblNewLabel_1.setText("\u03A4\u03B1 \u03C5\u03C0\u03CC\u03BB\u03BF\u03B9\u03C0\u03B1 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03C0\u03C1\u03BF\u03C3\u03C4\u03AF\u03B8\u03B5\u03BD\u03C4\u03B1\u03B9 \u03B1\u03C0\u03CC \u03C4\u03BF\u03BD \u03C5\u03C0\u03BF\u03C8\u03AE\u03C6\u03B9\u03BF");

	}
}
