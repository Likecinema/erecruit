package erecruit;//TODO EPIVEVAIWSH, BUGFIXING

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.sql.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class AllagiStoixeiwnLogariasmouRecruiter extends LoginWindow {
	String Onoma = null;
	String Epwnumo = null;
	String email = null;
	String etaireia = null;
	ResultSet AnagnwshStoixeiwnRS = null;
	
	
	public void EisagwghStoixeiwnRecruiter() {
		try {
			Statement StatementStoixeiwn = Main.Connection();
			AnagnwshStoixeiwnRS = StatementStoixeiwn.executeQuery("select user.name, surname,reg_date,email,exp_years,etaireia.name from user inner  join recruiter on user.username = recruiter.username inner join etaireia on recruiter.firm = etaireia.AFM where user.username = '" + LoginWindow.username + "'");
			AnagnwshStoixeiwnRS.next();
	}
		 catch (SQLException e) {
			e.printStackTrace();
		 }
		}

	protected Shell shell;
	private Text usernameTextBox;
	private Text passwordTextBox;
	private Text onomaTextBox;
	private Text epwnumoTextBox;
	private Text HmerominiaEggrafhsTextBox;
	private Text emailTextBox;
	private Text etaireiaTextBox;
	private Text ethProupiresiasTextBox;
	
	public void AllagiStoixeiwnLogariasmouSQL() { //TODO UPDATE TH VASH
		Onoma = onomaTextBox.getText();
		Epwnumo = epwnumoTextBox.getText();
		email = emailTextBox.getText();
		etaireia = etaireiaTextBox.getText();
		UpdatePassword();
		
		
	}


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
	 * @throws SQLException 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents(){
		EisagwghStoixeiwnRecruiter();


		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		shell.setSize(339, 302);
		shell.setText("Αλλαγή στοιχείων λογαριασμού");
		
		usernameTextBox = new Text(shell, SWT.BORDER);
		usernameTextBox.setText(username);
		usernameTextBox.setEditable(false);
		usernameTextBox.setEnabled(false);
		usernameTextBox.setBounds(147, 10, 166, 21);
		
		passwordTextBox = new Text(shell, SWT.BORDER);
		passwordTextBox.setEnabled(false);
		passwordTextBox.setEditable(false);
		passwordTextBox.setBounds(147, 37, 166, 21);
		
		onomaTextBox = new Text(shell, SWT.BORDER);
		onomaTextBox.setEnabled(false);
		onomaTextBox.setEditable(false);
		onomaTextBox.setBounds(147, 64, 166, 21);
		try {
			onomaTextBox.setText(AnagnwshStoixeiwnRS.getString(1));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		epwnumoTextBox = new Text(shell, SWT.BORDER);
		epwnumoTextBox.setEnabled(false);
		epwnumoTextBox.setEditable(false);
		epwnumoTextBox.setBounds(147, 91, 166, 21);
		try {
			epwnumoTextBox.setText(AnagnwshStoixeiwnRS.getString(2));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		HmerominiaEggrafhsTextBox = new Text(shell, SWT.BORDER);
		HmerominiaEggrafhsTextBox.setEnabled(false);
		HmerominiaEggrafhsTextBox.setEditable(false);
		HmerominiaEggrafhsTextBox.setBounds(147, 118, 166, 21);
		try {
			HmerominiaEggrafhsTextBox.setText(AnagnwshStoixeiwnRS.getString(3));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		emailTextBox = new Text(shell, SWT.BORDER);
		emailTextBox.setEnabled(false);
		emailTextBox.setEditable(false);
		emailTextBox.setBounds(147, 145, 166, 21);
		try {
			emailTextBox.setText(AnagnwshStoixeiwnRS.getString(4));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		etaireiaTextBox = new Text(shell, SWT.BORDER);
		etaireiaTextBox.setEnabled(false);
		etaireiaTextBox.setEditable(false);
		etaireiaTextBox.setBounds(147, 172, 166, 21);
		try {
			etaireiaTextBox.setText(AnagnwshStoixeiwnRS.getString(6));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		ethProupiresiasTextBox = new Text(shell, SWT.BORDER);
		ethProupiresiasTextBox.setEnabled(false);
		ethProupiresiasTextBox.setEditable(false);
		ethProupiresiasTextBox.setBounds(147, 199, 166, 21);
		try {
			ethProupiresiasTextBox.setText(AnagnwshStoixeiwnRS.getString(5));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Label usernameRecruiterLabel = new Label(shell, SWT.NONE);
		usernameRecruiterLabel.setText("Όνομα χρήστη");
		usernameRecruiterLabel.setBounds(10, 16, 91, 15);
		
		Label passwordRecruiterLabel = new Label(shell, SWT.NONE);
		passwordRecruiterLabel.setBounds(10, 43, 120, 15);
		passwordRecruiterLabel.setText("Κωδικός πρόσβασης");
		
		Label OnomaRecruiterLabel = new Label(shell, SWT.NONE);
		OnomaRecruiterLabel.setBounds(10, 70, 55, 15);
		OnomaRecruiterLabel.setText("Όνομα");
		
		Label EpwnumoRecruiterLabel = new Label(shell, SWT.NONE);
		EpwnumoRecruiterLabel.setBounds(10, 97, 55, 15);
		EpwnumoRecruiterLabel.setText("Επώνυμο");
		
		Label HmerominiaEggrafhsLabel = new Label(shell, SWT.NONE);
		HmerominiaEggrafhsLabel.setBounds(10, 124, 120, 15);
		HmerominiaEggrafhsLabel.setText("Ημερομηνία εγγραφής");
		
		Label emailLabel = new Label(shell, SWT.NONE);
		emailLabel.setBounds(10, 151, 55, 15);
		emailLabel.setText("Email");
		
		Label etaireiaLabel = new Label(shell, SWT.NONE);
		etaireiaLabel.setBounds(10, 178, 55, 15);
		etaireiaLabel.setText("Εταιρεία");
		
		Label ethProupiresiasLabel = new Label(shell, SWT.NONE);
		ethProupiresiasLabel.setBounds(10, 205, 120, 15);
		ethProupiresiasLabel.setText("Έτη προϋπηρεσίας");
		
		Button ButtonAllagiStoixeiwn = new Button(shell, SWT.NONE);
		ButtonAllagiStoixeiwn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				onomaTextBox.setEnabled(true);
				onomaTextBox.setEditable(true);
				epwnumoTextBox.setEnabled(true);
				epwnumoTextBox.setEditable(true);
				emailTextBox.setEnabled(true);
				emailTextBox.setEditable(true);
			}
		});
		ButtonAllagiStoixeiwn.setBounds(10, 228, 101, 25);
		ButtonAllagiStoixeiwn.setText("Αλλαγή στοιχείων");
		
		Button ButtonAllaghKwdikou = new Button(shell, SWT.NONE);
		ButtonAllaghKwdikou.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				AllagiKwdikou ParathiroAllagisKwdikou = new AllagiKwdikou();
				ParathiroAllagisKwdikou.createContents();
				ParathiroAllagisKwdikou.open();
			}
		});
		ButtonAllaghKwdikou.setText("Αλλαγή κωδικού");
		ButtonAllaghKwdikou.setBounds(115, 228, 101, 25);
		
		Button ButtonEpivevaiwsh = new Button(shell, SWT.NONE);
		ButtonEpivevaiwsh.setText("Επιβεβαίωση");
		ButtonEpivevaiwsh.setBounds(222, 228, 91, 25);

	}
}
