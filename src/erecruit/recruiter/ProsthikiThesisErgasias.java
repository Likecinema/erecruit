package erecruit.recruiter; //TODO AllagiStoixeiwnEtaireias DONE. todo katharismosbutton Alliws Remove

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.*;

import erecruit.LoginWindow;
import erecruit.Main;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ProsthikiThesisErgasias extends RecruiterWindow {

	protected Shell shell;
	private Text misthosText;
	private Text titlosThesisText;
	private Text KwdikosText;
	public String Antikeim; 
	public Date ImerominiaEnarksis;
	public Date ImerominiaAnakoinwshs;
	public Date ImerominiaLiksis;
	private int CounterAntikeimenwn = 1;
	private Text EdraText;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			/*Methodos evresis id thesis ergasias, me skopo na fainetai to epomeno id sto analogo TextBox*/
			/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	public String SQLgetArithmosThesisErgasias() {	
		String arithmosthesis= "0";
		try {
			ResultSet ArithmosThesisErgasiasRS = Main.Connection().executeQuery("SELECT `id` from JOB ORDER BY `id` DESC");
			ArithmosThesisErgasiasRS.next();
			arithmosthesis = ArithmosThesisErgasiasRS.getString(1);
			arithmosthesis = String.valueOf(Integer.parseInt(arithmosthesis)+1);
			return arithmosthesis;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arithmosthesis;


	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				/*Methodos evresis twn antikeimenwn apo th vasi. 
				 * Apothikevontai se String[] kai Eisagontai sto Combo mesw ths setItems()*/
				/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	protected String[] EisagwgiAntikeimApoVasi() 
	{
		String[] error = {"Error"};
		try {
			ResultSet AntikeimenaRS = Main.Connection().executeQuery("SELECT `TITLE` FROM ANTIKEIM");
			AntikeimenaRS.last();
			CounterAntikeimenwn = AntikeimenaRS.getRow();
			String[] antikeimena = new String[CounterAntikeimenwn];
			AntikeimenaRS.beforeFirst();
			AntikeimenaRS.next();
			for (int i=0; i<CounterAntikeimenwn; i++) {
			antikeimena[i] = AntikeimenaRS.getString(1);
			AntikeimenaRS.next();
			
			}
			return antikeimena;

				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return error;
	}
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			/*Prosorini apothikefsi metavlhtwn prin ginei apothikefsi sth vash*/
			/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void ApothikefsiStoixeiwnNeasThesis() { 
		String TitlosNeasThesis = titlosThesisText.getText();
		String MisthosNeasThesis = misthosText.getText();
		String AntikeimSQL = Antikeim;
		Date ImerominiaEnarksisSQL = ImerominiaEnarksis;
		Date ImerominiaAnakoinwshsSQL = ImerominiaAnakoinwshs;
		Date ImerominiaLiksisSQL = ImerominiaLiksis;
		String EdraSQL = EdraText.getText();
		String UpdateJob = "insert into job (start_date, salary, position, edra, recruiter, announce_date, submission_date) values ('"+ImerominiaEnarksisSQL+"','"+MisthosNeasThesis+"', '"+TitlosNeasThesis+"', '"+EdraSQL+"', '"+LoginWindow.username+"', '"+ImerominiaAnakoinwshsSQL+"', '"+ImerominiaLiksisSQL+"');";
		String IDNEeasTheshs= SQLgetArithmosThesisErgasias();
		String UpdateRequires = "insert into requires (job_id, antikeim_title) values ('"+IDNEeasTheshs+"',"+AntikeimSQL+"');";
		try {
			Main.Connection().execute(UpdateJob);
			Main.Connection().execute(UpdateRequires);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*Metatroph hmerominias se morfh katalhlh gia update sthn SQL*/
					/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	public Date MetatropiSeSQLDate(DateTime TempDateTime) {
		int mera;
		int mhnas;
		int etos;
		mera = TempDateTime.getDay();
		mhnas = TempDateTime.getMonth() + 1;
		etos = TempDateTime.getYear();
		String TempString = (etos + "-" + mhnas + "-" + mera);
		Date SQLdate = Date.valueOf(TempString);
		return SQLdate;	
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*Epistrofh tou antikeimenou apo to Combo gia apothikefsi sth vash*/
					/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	public void getAntikeim(Combo AntikeimList){
		Antikeim = AntikeimList.getItem(AntikeimList.getSelectionIndex());
		}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
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
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		shell.setSize(397, 324);
		shell.setText("Προσθήκη θέσης εργασίας");
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
							/*+++++++++++++++++++++++++++++++++++*/
							/*Dhmiourgia Label, TextBox kai Combo*/
							/*+++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		Label kwdikosThesisLabel = new Label(shell, SWT.NONE);
		kwdikosThesisLabel.setBounds(10, 20, 171, 15);
		kwdikosThesisLabel.setText("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2 \u03BD\u03AD\u03B1\u03C2 \u03B8\u03AD\u03C3\u03B7\u03C2 \u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2");
		
		Label titlosThesisErgasiasLabel = new Label(shell, SWT.NONE);
		titlosThesisErgasiasLabel.setText("\u03A4\u03AF\u03C4\u03BB\u03BF\u03C2 \u0398\u03AD\u03C3\u03B7\u03C2 \u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2");
		titlosThesisErgasiasLabel.setBounds(10, 47, 171, 15);
		
		Label misthosThesisErgasiasLabel = new Label(shell, SWT.NONE);
		misthosThesisErgasiasLabel.setBounds(10, 78, 55, 15);
		misthosThesisErgasiasLabel.setText("\u039C\u03B9\u03C3\u03B8\u03CC\u03C2");
		
		Label antikeimThesisErgasiasLabel = new Label(shell, SWT.NONE);
		antikeimThesisErgasiasLabel.setBounds(10, 129, 171, 15);
		antikeimThesisErgasiasLabel.setText("\u0391\u03BD\u03C4\u03B9\u03BA\u03B5\u03AF\u03BC\u03B5\u03BD\u03BF \u03B8\u03AD\u03C3\u03B7\u03C2 \u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2");
		
		Label imerominiaEnarksisErgasiasLabel = new Label(shell, SWT.NONE);
		imerominiaEnarksisErgasiasLabel.setBounds(10, 172, 181, 15);
		imerominiaEnarksisErgasiasLabel.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03AD\u03BD\u03B1\u03C1\u03BE\u03B7\u03C2 \u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2");
		
		Label imerominiaAnakoinwshsLabel = new Label(shell, SWT.NONE);
		imerominiaAnakoinwshsLabel.setBounds(10, 202, 181, 15);
		imerominiaAnakoinwshsLabel.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03B1\u03BD\u03B1\u03BA\u03BF\u03AF\u03BD\u03C9\u03C3\u03B7\u03C2");
		
		Label imerominiaLiksisLabel = new Label(shell, SWT.NONE);
		imerominiaLiksisLabel.setBounds(10, 234, 232, 15);
		imerominiaLiksisLabel.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03BB\u03AE\u03BE\u03B7\u03C2 \u03C5\u03C0\u03BF\u03B2\u03BF\u03BB\u03AE\u03C2 \u03B1\u03B9\u03C4\u03AE\u03C3\u03B5\u03C9\u03BD");
		
		KwdikosText = new Text(shell, SWT.BORDER);
		KwdikosText.setText(SQLgetArithmosThesisErgasias()); //Eisagwgh ID thesis ergasias
		KwdikosText.setEditable(false);
		KwdikosText.setBounds(187, 17, 186, 21);
		
		titlosThesisText = new Text(shell, SWT.BORDER);
		titlosThesisText.setBounds(187, 44, 186, 21);
		
		misthosText = new Text(shell, SWT.BORDER);
		misthosText.setBounds(187, 75, 186, 21);
		
		EdraText = new Text(shell, SWT.BORDER);
		EdraText.setBounds(186, 102, 186, 21);
		
		Combo AntikeimenaList = new Combo(shell, SWT.READ_ONLY);
		AntikeimenaList.setBounds(187, 129, 186, 23);
		AntikeimenaList.setItems(EisagwgiAntikeimApoVasi()); //Eisagwgh Antikeimenwn sto combo
		AntikeimenaList.select(0);
		
		DateTime enarksiDateBox = new DateTime(shell, SWT.BORDER);
		enarksiDateBox.setBounds(266, 163, 107, 24);
		
		DateTime anakoinwshDateBox = new DateTime(shell, SWT.BORDER);
		anakoinwshDateBox.setBounds(268, 193, 106, 24);
		
		DateTime liksiDateBox = new DateTime(shell, SWT.BORDER);
		liksiDateBox.setBounds(268, 225, 105, 24);
		
		Label edraLabel = new Label(shell, SWT.NONE);
		edraLabel.setBounds(10, 108, 55, 15);
		edraLabel.setText("\u0388\u03B4\u03C1\u03B1");

		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						/*Dhmiourgia koumpiwn kai diaxeirisi twn leitourgiwn tous*/
						/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		Button EfarmogiButton = new Button(shell, SWT.NONE);
		EfarmogiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				getAntikeim(AntikeimenaList);
				ImerominiaLiksis = MetatropiSeSQLDate(liksiDateBox);
				ImerominiaEnarksis = MetatropiSeSQLDate(enarksiDateBox);
				ImerominiaAnakoinwshs = MetatropiSeSQLDate(anakoinwshDateBox);
				ApothikefsiStoixeiwnNeasThesis();
				shell.close();
				
				
			}
		});
		EfarmogiButton.setBounds(10, 255, 171, 25);
		EfarmogiButton.setText("\u0395\u03C6\u03B1\u03C1\u03BC\u03BF\u03B3\u03AE");
		
		Button KatharismosButton = new Button(shell, SWT.NONE); 
		KatharismosButton.setBounds(187, 255, 186, 25);
		KatharismosButton.setText("\u039A\u03B1\u03B8\u03B1\u03C1\u03B9\u03C3\u03BC\u03CC\u03C2");
		
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

	}
}
