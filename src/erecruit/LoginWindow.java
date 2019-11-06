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
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
								/*++++++++++++++++++++++++++++*/
								/*Dhmiourgia label kai textbox*/
								/*++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
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
	
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
									/*++++++++++++++++++++++++++++++++++*/
									/*Koumpia kai diaxeirisi leitourgiwn*/
									/*++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
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
	
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				/*++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				/*Methodos Elegxou tou pinaka user ths vashs
				 * gia ta stoixeia eisodou
			    * Pws Leitourgei: Arxikopoiei integer me onoma
				 * epistfori, kai elegxei me try/catch mexri na vrei* 		
				 * pinaka pou na exei username kai password idio
				 * me afto pou vrisketai sta textbox. An apotuxei
				 * epistrefei timh = 4. To programma einai ftiagmeno
				 * me epistrofh = 4 na emfanizei minima lathous
				 * an username = password = admin tote epistrofh = 1
				 * kai anoigei to AdminWindow                         */
				/*++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	protected int SQLCheck() {	
		 username = usernameField.getText(); 
		 password = passwordField.getText();
		 LoggedInUser = usernameField.getText();
		 String SQLusername;
		 String SQLpassword;
		 int epistrofh = 4; //arxikopoihsh int epistrofhs, an apotuxoun ta try/catch kai o elegxos admin epistrefei 4
		 //elegxos gia admin, gia username=password = admin thetei epistrofh = 1
		 if (username.equals("admin") && password.equals("admin")) {epistrofh = 1;}
			try {
				//elegxos gia recruiter, an vrei ta stoixeia thetei epistrofh = 1
				Recruiter = Connection().executeQuery("SELECT * FROM recruiter WHERE username='"+username+"';");
							Recruiter.next();
							SQLusername = Recruiter.getString("username");	
							Recruiter = Connection().executeQuery("SELECT password From user inner join recruiter on recruiter.username = user.username WHERE password='"+password+"' AND user.username = '" + username + "'");
							Recruiter.next();
							SQLpassword = Recruiter.getString("password");
							epistrofh = 2;
							
							
							

				 
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("O xristis " + username + " den einai ipefthinos proslipsewn");
			}
				
			try {
				//elegxos gia candidate, an vrei ta stoixeia thetei epistrofh = 2
				Candidate = Connection().executeQuery("SELECT username FROM candidate WHERE username='"+username+"';");
				Candidate.next();
				SQLusername = Candidate.getString("username");	
				Candidate = Connection().executeQuery("SELECT password From user inner join candidate on user.username = candidate.username WHERE password='"+password+"' AND user.username = '" + username + "'");
				Candidate.next();
				SQLpassword = Candidate.getString("password");
				epistrofh = 3;
				}
					catch (SQLException e1) {
						e1.printStackTrace();
						System.out.println("O Xristis " + username + " den einai upopsifios");
					}

		return epistrofh;
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
}
}

