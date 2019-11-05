/*TODO
 * Den exw kanei: 
 * Provolh thesewn ergasias me vash to ti epilexthike sto combobox
 * kanena update sthn sql
 * 
 */


package erecruit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.sql.*;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ProvoliKaiEpeksergasiaAitisewn {

	protected Shell shlProvoliKaiEpeksergasiaAitisewn;
	private Text IDText;
	private Text SalaryText;
	private Text EdraText;
	private Text PositionText;
	private Text StartDateText;
	private Text AnnounceDateText;
	private Text SubmDateText;
	@SuppressWarnings("unused")
	private int sthlespinaka;
	private int seirespinaka;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						/*Methodos gia epistrofi tou id me vash to pinaka sthn epomenh methodo*/
						/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	protected String EisagwgiThesewnRecruiter(int i){
		String IDGiaCombo = null;
		String[][] ArrayGiaCombo = PinakasThesewnRecruiter();
			IDGiaCombo = ArrayGiaCombo[i][0];
			return IDGiaCombo;
			
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*Methodos gia anagnwsh twn thesewn ergasias apo th vash
					 * kai epistrofh pinaka 2 diastasewn me ta stoixeia stis 
					 * theseis "TheseisApoSQL"*/
					/*++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	}
	private String[][] PinakasThesewnRecruiter(){
		String TheseisApoSQL = ("select `id`, `salary`,`edra`, `position`,`start_date`,`announce_date`,`submission_date` from job inner join recruiter on job.recruiter = recruiter.username inner join etaireia on recruiter.firm = etaireia.AFM where etaireia.AFM in ( select recruiter.firm from recruiter where recruiter.username = '" + LoginWindow.username + "')");
		String[][] error = new String[][] {{"error1"},{"error2"}};
		try {
			ResultSet TheseisRecruiterRS = Main.Connection().executeQuery(TheseisApoSQL);
			ResultSetMetaData MetadataThesewnRecruiter = TheseisRecruiterRS.getMetaData();
			int SthlesThesewn = MetadataThesewnRecruiter.getColumnCount();
			sthlespinaka = SthlesThesewn;
			TheseisRecruiterRS.last();
			int SeiresThesewn = TheseisRecruiterRS.getRow();
			seirespinaka = SeiresThesewn;
			TheseisRecruiterRS.first();
			String[][] PinakasThesewn = new String[SeiresThesewn][SthlesThesewn];
			for (int i = 0; i< SeiresThesewn; i++) {
				for (int k = 0; k<SthlesThesewn;k++)
				{
					PinakasThesewn[i][k] = TheseisRecruiterRS.getString(k+1);
				}
				TheseisRecruiterRS.next();

			}
			return PinakasThesewn;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return error;
	}
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlProvoliKaiEpeksergasiaAitisewn.open();
		shlProvoliKaiEpeksergasiaAitisewn.layout();
		while (!shlProvoliKaiEpeksergasiaAitisewn.isDisposed()) {
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
		shlProvoliKaiEpeksergasiaAitisewn = new Shell();
		shlProvoliKaiEpeksergasiaAitisewn.setSize(501, 319);
		shlProvoliKaiEpeksergasiaAitisewn.setText("Προβολή και επεξεργασία αιτήσεων");
		
		Combo EpilogiAitisisCombo = new Combo(shlProvoliKaiEpeksergasiaAitisewn, SWT.READ_ONLY);
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					/*SelectionAdapter gia epilogi ergasias kai gemisma twn antistoixwn textbox*/
					/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		EpilogiAitisisCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int ArithmosErgasias = EpilogiAitisisCombo.getSelectionIndex();
				String[][] PinakasErgasiwn = PinakasThesewnRecruiter();
				IDText.setText(PinakasErgasiwn[ArithmosErgasias][0]);
				SalaryText.setText(PinakasErgasiwn[ArithmosErgasias][1]);
				EdraText.setText(PinakasErgasiwn[ArithmosErgasias][2]);
				PositionText.setText(PinakasErgasiwn[ArithmosErgasias][3]);
				StartDateText.setText(PinakasErgasiwn[ArithmosErgasias][4]);
				AnnounceDateText.setText(PinakasErgasiwn[ArithmosErgasias][5]);
				SubmDateText.setText(PinakasErgasiwn[ArithmosErgasias][6]);
				
			}
		});
		

		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


		
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
								/*+++++++++++++++++++++++++++++++++++++++++++++*/
								/* Gemisma tou combo me ta id apo tis ergasies */
								/*+++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		EpilogiAitisisCombo.setBounds(10, 31, 463, 23);
		EpilogiAitisisCombo.select(0);
		PinakasThesewnRecruiter();
		for (int i = 0; i<seirespinaka; i++) {
		EpilogiAitisisCombo.add(EisagwgiThesewnRecruiter(i));
		}
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
										    /*++++++++++++++++++++++++++++*/
											/*Dhmiourgia Label kai textbox*/
										    /*++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		
		Label EksigisiEpilogisLabel = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		EksigisiEpilogisLabel.setBounds(10, 10, 179, 15);
		EksigisiEpilogisLabel.setText("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03B1\u03AF\u03C4\u03B7\u03C3\u03B7 (\u03BC\u03B5 \u03B2\u03AC\u03C3\u03B7 \u03C4\u03BF ID)");
		
		Label IDLabel = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		IDLabel.setBounds(10, 63, 223, 15);
		IDLabel.setText("ID");
		
		Label MisthosLabel = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		MisthosLabel.setText("\u039C\u03B9\u03C3\u03B8\u03CC\u03C2");
		MisthosLabel.setBounds(10, 90, 223, 15);
		
		Label StartDateLabel = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		StartDateLabel.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0388\u03BD\u03B1\u03C1\u03BE\u03B7\u03C2");
		StartDateLabel.setBounds(10, 171, 223, 15);
		
		Label AnnounceDateLabel = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		AnnounceDateLabel.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0391\u03BD\u03B1\u03BA\u03BF\u03AF\u03BD\u03C9\u03C3\u03B7\u03C2");
		AnnounceDateLabel.setBounds(10, 198, 223, 15);
		
		Label SubmissionDateLabel = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		SubmissionDateLabel.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03BB\u03AE\u03BE\u03B7\u03C2 \u03C5\u03C0\u03BF\u03B2\u03BF\u03BB\u03AE\u03C2 \u0391\u03B9\u03C4\u03AE\u03C3\u03B5\u03C9\u03BD");
		SubmissionDateLabel.setBounds(10, 226, 223, 15);
		
		Label ThesiLabel = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		ThesiLabel.setText("\u0398\u03AD\u03C3\u03B7");
		ThesiLabel.setBounds(10, 144, 223, 15);
		
		Label EdraLabel = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		EdraLabel.setText("\u0388\u03B4\u03C1\u03B1");
		EdraLabel.setBounds(10, 117, 223, 15);
		
		IDText = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		IDText.setEditable(false);
		IDText.setBounds(239, 60, 231, 21);
		
		SalaryText = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		SalaryText.setEditable(false);
		SalaryText.setBounds(239, 87, 231, 21);
		
		EdraText = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		EdraText.setEditable(false);
		EdraText.setBounds(239, 114, 231, 21);
		
		PositionText = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		PositionText.setEditable(false);
		PositionText.setBounds(239, 141, 231, 21);
		
		StartDateText = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		StartDateText.setEditable(false);
		StartDateText.setBounds(239, 168, 231, 21);
		
		AnnounceDateText = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		AnnounceDateText.setEditable(false);
		AnnounceDateText.setBounds(239, 195, 231, 21);
		
		SubmDateText = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		SubmDateText.setEditable(false);
		SubmDateText.setBounds(239, 223, 231, 21);
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
										/*++++++++++++++++++++++++++++++++++*/
										/*Koumpia kai Diaxeirisi leitourgiwn*/
										/*++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		Button EditJobButton = new Button(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		EditJobButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				SalaryText.setEditable(true);
				EdraText.setEditable(true);
				PositionText.setEditable(true);
				StartDateText.setEditable(true);
				SubmDateText.setEditable(true);
			}
		});
		EditJobButton.setBounds(10, 247, 125, 25);
		EditJobButton.setText("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1 \u0391\u03AF\u03C4\u03B7\u03C3\u03B7\u03C2");
		
		Button SaveAndQuitButton = new Button(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE); //TODO APOTHIKEFSI & UPDATE STH VASH
		SaveAndQuitButton.setText("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7 \u03BA\u03B1\u03B9 \u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		SaveAndQuitButton.setBounds(326, 247, 147, 25);
		
		Button YpopsifioiKaiVathmologiesButton = new Button(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE); //TODO DOULEIA SQL & NEO PARATHIRO
		YpopsifioiKaiVathmologiesButton.setText("\u03A5\u03C0\u03BF\u03C8\u03AE\u03C6\u03B9\u03BF\u03B9 \u03BA\u03B1\u03B9 \u0392\u03B1\u03B8\u03BC\u03BF\u03BB\u03BF\u03B3\u03AF\u03B5\u03C2");
		YpopsifioiKaiVathmologiesButton.setBounds(141, 247, 179, 25);
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		

	}
}

	
