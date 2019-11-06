package erecruit.candidate;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import java.sql.*;
import erecruit.Main;
import erecruit.AllagiKwdikou;
import erecruit.LoginWindow;

public class AllagiStoixeiwnCandidate extends CandidateWindow{

	protected Shell shell;
	private Text UsernameTextBox;
	private Text PasswordTextbox;
	private Text NameTextBox;
	private Text SurnameTextBox;
	private Text Reg_dateTextBox;
	private Text emailTextBox;
	private Text SystatikesTextBox;
	private Text CertFileTextBox;

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
		shell.setSize(366, 464);
		shell.setText("\u0391\u03BB\u03BB\u03B1\u03B3\u03AE \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03C9\u03BD \u03A5\u03C0\u03BF\u03C8\u03B7\u03C6\u03AF\u03BF\u03C5");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(10, 10, 55, 25);
		lblUsername.setText("Username");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(10, 41, 55, 25);
		lblPassword.setText("Password");
		
		Label NameLbl = new Label(shell, SWT.NONE);
		NameLbl.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		NameLbl.setBounds(10, 72, 55, 25);
		
		Label SurnameLbl = new Label(shell, SWT.NONE);
		SurnameLbl.setBounds(10, 103, 55, 25);
		SurnameLbl.setText("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		
		Label RegDateLbl = new Label(shell, SWT.NONE);
		RegDateLbl.setBounds(10, 134, 100, 25);
		RegDateLbl.setText("\u0397\u03BC/\u03BD\u03AF\u03B1 \u0395\u03B3\u03B3\u03C1\u03B1\u03C6\u03AE\u03C2");
		
		Label emailLabel = new Label(shell, SWT.NONE);
		emailLabel.setBounds(10, 165, 55, 25);
		emailLabel.setText("Email");
		
		Label BioLabel = new Label(shell, SWT.NONE);
		BioLabel.setBounds(10, 196, 65, 25);
		BioLabel.setText("\u0392\u03B9\u03BF\u03B3\u03C1\u03B1\u03C6\u03B9\u03BA\u03CC");
		
		Label SystatikesLabel = new Label(shell, SWT.NONE);
		SystatikesLabel.setBounds(10, 227, 174, 25);
		SystatikesLabel.setText("\u0391\u03C1\u03C7\u03B5\u03AF\u03BF \u03C3\u03C5\u03C3\u03C4\u03B1\u03C4\u03B9\u03BA\u03CE\u03BD \u03B5\u03C0\u03B9\u03C3\u03C4\u03BF\u03BB\u03CE\u03BD");
		
		Label certificatesFileLabel = new Label(shell, SWT.NONE);
		certificatesFileLabel.setBounds(10, 258, 100, 25);
		certificatesFileLabel.setText("\u0391\u03C1\u03C7\u03B5\u03AF\u03BF \u03A0\u03C4\u03C5\u03C7\u03AF\u03C9\u03BD");
		
		Label LanguagesLabel = new Label(shell, SWT.NONE);
		LanguagesLabel.setBounds(10, 289, 55, 25);
		LanguagesLabel.setText("\u0393\u03BB\u03CE\u03C3\u03C3\u03B5\u03C2");
		
		Label ProjectsLabel = new Label(shell, SWT.NONE);
		ProjectsLabel.setBounds(10, 320, 55, 25);
		ProjectsLabel.setText("Projects");
		
		Label certsLabel = new Label(shell, SWT.NONE);
		certsLabel.setBounds(10, 351, 55, 25);
		certsLabel.setText("\u03A0\u03C4\u03C5\u03C7\u03AF\u03B1");
		
		UsernameTextBox = new Text(shell, SWT.BORDER);
		UsernameTextBox.setEditable(false);
		UsernameTextBox.setEnabled(false);
		UsernameTextBox.setBounds(166, 10, 174, 21);
		
		PasswordTextbox = new Text(shell, SWT.BORDER);
		PasswordTextbox.setEnabled(false);
		PasswordTextbox.setEditable(false);
		PasswordTextbox.setBounds(166, 41, 174, 21);
		
		NameTextBox = new Text(shell, SWT.BORDER);
		NameTextBox.setEnabled(false);
		NameTextBox.setEditable(false);
		NameTextBox.setBounds(166, 72, 174, 21);
		
		SurnameTextBox = new Text(shell, SWT.BORDER);
		SurnameTextBox.setEnabled(false);
		SurnameTextBox.setEditable(false);
		SurnameTextBox.setBounds(166, 103, 174, 21);
		
		Reg_dateTextBox = new Text(shell, SWT.BORDER);
		Reg_dateTextBox.setEnabled(false);
		Reg_dateTextBox.setEditable(false);
		Reg_dateTextBox.setBounds(166, 134, 174, 21);
		
		emailTextBox = new Text(shell, SWT.BORDER);
		emailTextBox.setEnabled(false);
		emailTextBox.setEditable(false);
		emailTextBox.setBounds(166, 165, 174, 21);
		
		Button BioButton = new Button(shell, SWT.NONE);
		BioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ViografikoCandidate Bio = new ViografikoCandidate();
				Bio.open();
				Bio.createContents();
			}
		});
		BioButton.setBounds(166, 196, 174, 25);
		BioButton.setText("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u0392\u03B9\u03BF\u03B3\u03C1\u03B1\u03C6\u03B9\u03BA\u03BF\u03CD");
		
		SystatikesTextBox = new Text(shell, SWT.BORDER);
		SystatikesTextBox.setEnabled(false);
		SystatikesTextBox.setEditable(false);
		SystatikesTextBox.setBounds(190, 227, 150, 21);
		
		CertFileTextBox = new Text(shell, SWT.BORDER);
		CertFileTextBox.setEnabled(false);
		CertFileTextBox.setEditable(false);
		CertFileTextBox.setBounds(166, 258, 174, 21);
		
		try {
			
		UsernameTextBox.setText(DedomenaCandidate().getString(1));
		NameTextBox.setText(DedomenaCandidate().getString(2));
		SurnameTextBox.setText(DedomenaCandidate().getString(3));
		Reg_dateTextBox.setText(DedomenaCandidate().getString(4));
		emailTextBox.setText(DedomenaCandidate().getString(5));
		SystatikesTextBox.setText(DedomenaCandidate().getString(6));
		CertFileTextBox.setText(DedomenaCandidate().getString(7));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		Button LanguagesButton = new Button(shell, SWT.NONE);
		LanguagesButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				GlwssesCandidate Glwsses = new GlwssesCandidate();
				Glwsses.open();
				Glwsses.createContents();
			}
		});
		LanguagesButton.setBounds(166, 289, 174, 25);
		LanguagesButton.setText("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u0393\u03BB\u03C9\u03C3\u03CE\u03BD");
		
		Button EditBtn = new Button(shell, SWT.NONE);
		EditBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				UsernameTextBox.setEditable(true);
				UsernameTextBox.setEnabled(true);
				NameTextBox.setEditable(true);
				NameTextBox.setEnabled(true);
				SurnameTextBox.setEditable(true);
				SurnameTextBox.setEnabled(true);
				Reg_dateTextBox.setEditable(true);
				Reg_dateTextBox.setEnabled(true);
				emailTextBox.setEditable(true);
				emailTextBox.setEnabled(true);
				SystatikesTextBox.setEditable(true);
				SystatikesTextBox.setEnabled(true);
				CertFileTextBox.setEditable(true);
				CertFileTextBox.setEnabled(true);
			}
		});
		EditBtn.setBounds(10, 382, 110, 25);
		EditBtn.setText("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1");
		
		Button AllagiKwdikouBtn = new Button(shell, SWT.NONE);
		AllagiKwdikouBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				AllagiKwdikou AllagiKwdikouCandidate = new AllagiKwdikou();
				AllagiKwdikouCandidate.open();
				
			}
		});
		AllagiKwdikouBtn.setBounds(126, 382, 108, 25);
		AllagiKwdikouBtn.setText("\u0391\u03BB\u03BB\u03B1\u03B3\u03AE \u03BA\u03C9\u03B4\u03B9\u03BA\u03BF\u03CD");
		
		Button ApothikefsiBtn = new Button(shell, SWT.NONE);
		ApothikefsiBtn.setBounds(240, 382, 100, 25);
		ApothikefsiBtn.setText("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");
		
		Button btnNewButton_5 = new Button(shell, SWT.NONE);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				PtuxiaWindow PW = new PtuxiaWindow();
				PW.open();
				PW.createContents();
			}
		});
		btnNewButton_5.setBounds(166, 347, 174, 25);
		btnNewButton_5.setText("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u03C0\u03C4\u03C5\u03C7\u03AF\u03C9\u03BD");
		
		Button ProjectsButton = new Button(shell, SWT.NONE);
		ProjectsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ProjectsWindow PW = new ProjectsWindow();
				PW.open();
				PW.createContents();
			}
		});
		ProjectsButton.setBounds(166, 320, 174, 25);
		ProjectsButton.setText("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE Projects");

	}
	private ResultSet DedomenaCandidate() {
		String Query = ("select user.username, user.name, user.surname, user.reg_date, user.email, candidate.sistatikes, candidate.certificates from user inner join candidate on user.username = candidate.username where user.username = '" + LoginWindow.username + "'");
		try {
			ResultSet DedomenaCandidateRS = Main.Connection().executeQuery(Query);
			DedomenaCandidateRS.first();
			return DedomenaCandidateRS;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

