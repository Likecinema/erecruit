//DONE!

package erecruit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class LoginWindow extends Main {
	 ResultSet Recruiter = null;
	 ResultSet Candidate = null;
	 String LoggedInUser = null;

	protected Shell LoginShell;
	private Text usernameField;
	private Text passwordField;
	public static String username;
	public static String password;

	public void open() {
		Display display = Display.getDefault();
		createContents();
		LoginShell.open();
		LoginShell.layout();
		while (!LoginShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

    boolean LoginButtonClicked = false;
    private Label AuthenticateLabel;
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() { /*Methodos Dimiourgias formas SWT*/
		LoginShell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		LoginShell.setSize(388, 124);
		LoginShell.setText("\u03A0\u03B1\u03C1\u03AC\u03B8\u03C5\u03C1\u03BF \u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE\u03C2 \u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03C9\u03BD");
		
		usernameField = new Text(LoginShell, SWT.BORDER);
		usernameField.setBounds(10, 31, 123, 21);
		
		passwordField = new Text(LoginShell, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		passwordField.setBounds(149, 31, 123, 21);

		Label usernameLabel = new Label(LoginShell, SWT.NONE);
		usernameLabel.setBounds(10, 10, 123, 15);
		usernameLabel.setText("\u038C\u03BD\u03BF\u03BC\u03B1 \u03A7\u03C1\u03AE\u03C3\u03C4\u03B7");
		
		Label passwordLabel = new Label(LoginShell, SWT.NONE);
		passwordLabel.setBounds(139, 10, 133, 15);
		passwordLabel.setText("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03A0\u03C1\u03CC\u03C3\u03B2\u03B1\u03C3\u03B7\u03C2");
		
		Button loginButton = new Button(LoginShell, SWT.NONE);
		loginButton.setToolTipText("");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) { /*Listener gia release tou click apo to pontiki gia na anoiksei to antistoixo parathiro */
				if (SQLCheck() == 1)
				{
					 AdminWindow ParathiroAdmin = new AdminWindow();
					 ParathiroAdmin.createContents();
					 ParathiroAdmin.open(); 
					 AuthenticateLabel.setText("");
					 
					
				}
				else if (SQLCheck() == 2)
				{
					RecruiterWindow ParathiroRecruiter = new RecruiterWindow();
					ParathiroRecruiter.createContents();
					ParathiroRecruiter.open();
					AuthenticateLabel.setText("");
				}
				else if (SQLCheck() == 3)
				{
					 CandidateWindow ParathiroCandidate = new CandidateWindow();
					 ParathiroCandidate.createContents();
					 ParathiroCandidate.open();
					 AuthenticateLabel.setText("");
					 LoginShell.close();
					
				}
				else if (SQLCheck() == 4)
				{
					AuthenticateLabel.setText("\u039B\u03AC\u03B8\u03BF\u03C2 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03B5\u03B9\u03C3\u03CC\u03B4\u03BF\u03C5. \u0394\u03BF\u03BA\u03B9\u03BC\u03AC\u03C3\u03C4\u03B5 \u03BE\u03B1\u03BD\u03AC.");
				}
			}
		});
		loginButton.setBounds(287, 29, 75, 25);
		loginButton.setText("\u0395\u03AF\u03C3\u03BF\u03B4\u03BF\u03C2");
		
		
		AuthenticateLabel = new Label(LoginShell, SWT.NONE);
		AuthenticateLabel.setAlignment(SWT.CENTER);
		AuthenticateLabel.setBounds(10, 60, 252, 15);

	}
	protected int SQLCheck() {			/*methodos Elegxou tou pinaka user ths vashs gia ta stoixeia eisodou */	
		 username = usernameField.getText(); 
		 password = passwordField.getText();
		 LoggedInUser = usernameField.getText();
		 String SQLusername;
		 String SQLpassword;
		 int epistrofh = 4; //arxikopoihsh int epistrofhs, an apotuxoun ta try/catch kai o elegxos admin epistrefei 4
		 //elegxos gia admin, gia username=password = admin thetei epistrofh = 1
		 if (username.equals("admin") && password.equals("admin")) {epistrofh = 1; System.out.println(epistrofh);}
			try {
				//elegxos gia recruiter, an vrei ta stoixeia thetei epistrofh = 1
				Recruiter = Connection().executeQuery("SELECT * FROM erecruit.recruiter WHERE username='"+username+"';");
							Recruiter.next();
							SQLusername = Recruiter.getString("username");
							//System.out.println(SQLusername);		
							Recruiter = Connection().executeQuery("SELECT password From erecruit.user WHERE password='"+password+"';");
							Recruiter.next();
							SQLpassword = Recruiter.getString("password");
							epistrofh = 2;
							//System.out.println(SQLpassword);
							
							
							

				 
			} catch (SQLException e) {
				
			try {
				//elegxos gia candidate, an vrei ta stoixeia thetei epistrofh = 2
				Candidate = Connection().executeQuery("SELECT username FROM erecruit.candidate WHERE username='"+username+"';");
				Candidate.next();
				SQLusername = Candidate.getString("username");
				//System.out.println(SQLusername);		
				Candidate = Connection().executeQuery("SELECT password From erecruit.user WHERE password='"+password+"';");
				Candidate.next();
				SQLpassword = Candidate.getString("password");
				epistrofh = 3;
				//System.out.println(SQLpassword);
				//System.out.print(epistrofh);
			}
			catch (SQLException e1) {}
				}

				

			
			 
		
	//TODO, psaxnei sundiasmo onomatos/kwdikou, epistrefei times "1" gia admin, "2" gia recruiter, "3" gia candidate, "4" gia not found
		return epistrofh;
	
}
}

