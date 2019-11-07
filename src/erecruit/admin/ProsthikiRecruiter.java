package erecruit.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import erecruit.Main;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ProsthikiRecruiter {

	protected Shell shell;
	private Text NewUsernameTextBox;
	private Text NewPasswordTextBox;
	private Text NewNameTextBox;
	private Text NewSurnameTextBox;
	private Text NewMailTextBox;
	private Text NewProupiresiaTextBox;


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
		shell.setSize(352, 272);
		shell.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C5\u03C0\u03B5\u03CD\u03B8\u03C5\u03BD\u03BF\u03C5 \u03C0\u03C1\u03BF\u03C3\u03BB\u03AE\u03C8\u03B5\u03C9\u03BD");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setText("Username");
		lblUsername.setBounds(10, 10, 111, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 37, 111, 21);
		lblNewLabel.setText("Password");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		label.setBounds(10, 64, 111, 21);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		label_1.setBounds(10, 91, 111, 21);
		
		Label lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setText("Email");
		lblEmail.setBounds(10, 118, 111, 21);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("\u0388\u03C4\u03B7 \u03C0\u03C1\u03BF\u03CB\u03C0\u03B7\u03C1\u03B5\u03C3\u03AF\u03B1\u03C2");
		label_4.setBounds(10, 145, 111, 21);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("\u0395\u03C4\u03B1\u03B9\u03C1\u03B5\u03AF\u03B1");
		label_5.setBounds(10, 172, 111, 21);
		
		NewUsernameTextBox = new Text(shell, SWT.BORDER);
		NewUsernameTextBox.setBounds(137, 7, 189, 21);
		
		NewPasswordTextBox = new Text(shell, SWT.BORDER);
		NewPasswordTextBox.setBounds(137, 37, 189, 21);
		
		NewNameTextBox = new Text(shell, SWT.BORDER);
		NewNameTextBox.setBounds(137, 64, 189, 21);
		
		NewSurnameTextBox = new Text(shell, SWT.BORDER);
		NewSurnameTextBox.setBounds(137, 91, 189, 21);
		
		NewMailTextBox = new Text(shell, SWT.BORDER);
		NewMailTextBox.setBounds(137, 115, 189, 21);
		
		NewProupiresiaTextBox = new Text(shell, SWT.BORDER);
		NewProupiresiaTextBox.setBounds(137, 142, 189, 21);
		
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(137, 169, 189, 23);
		try {
			ResultSet RS =	Main.Connection().executeQuery("SELECT name FROM etaireia;");
			RS.last();
			int ArithmosEtaireiwn = RS.getRow();
			RS.first();
			for (int i=0; i< ArithmosEtaireiwn; i++)
			{
				combo.add(RS.getString(1));
				RS.next();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		Button AddBtn = new Button(shell, SWT.NONE);
		AddBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String NeoUsername = NewUsernameTextBox.getText();
				String NeoPassword = NewPasswordTextBox.getText();
				String NeoOnoma = NewNameTextBox.getText();
				String NeoEpitheto = NewSurnameTextBox.getText();
				String NeoEmail = NewMailTextBox.getText();
				String NeaProupiresia = NewProupiresiaTextBox.getText();
				try {
					ResultSet DateTimeRS = Main.Connection().executeQuery("SELECT NOW();");
					DateTimeRS.next();
					String datetime = DateTimeRS.getString(1);
					String InsertQuery = "INSERT INTO user (username, password, name, surname, reg_date, email) values\r\n ('"+NeoUsername+"', '"+NeoPassword+"','"+NeoOnoma+"','"+NeoEpitheto+"','"+datetime+"','"+NeoEmail+"');";
					Main.Connection().execute(InsertQuery);
					Main.Connection().execute("INSERT INTO recruiter (username, exp_years, firm) values ('"+NeoUsername+"', '"+NeaProupiresia+"', 'Placeholder');");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		AddBtn.setBounds(10, 199, 316, 25);
		AddBtn.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");

	}
}
