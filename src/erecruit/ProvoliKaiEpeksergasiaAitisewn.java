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
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.sql.*;

public class ProvoliKaiEpeksergasiaAitisewn {

	protected Shell shlProvoliKaiEpeksergasiaAitisewn;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private int sthlespinaka;
	private int seirespinaka;
	
	protected String EisagwgiThesewnRecruiter(int i){
		String IDGiaCombo = null;
		String[][] ArrayGiaCombo = PinakasThesewnRecruiter();
			IDGiaCombo = ArrayGiaCombo[i][0];
			System.out.println(IDGiaCombo);
			return IDGiaCombo;
		
		
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
			//System.out.println("sthles=" + SthlesThesewn);
			//System.out.println("seires=" + SeiresThesewn);
			for (int i = 0; i< SeiresThesewn; i++) {
				//System.out.println("H Timh tou i einai " + i);
				for (int k = 0; k<SthlesThesewn;k++)
				{
					//System.out.println("H timh tou k einai " +k);
					PinakasThesewn[i][k] = TheseisRecruiterRS.getString(k+1);
					System.out.println(PinakasThesewn[i][k]);
				}
				TheseisRecruiterRS.next();

			}
			return PinakasThesewn;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return error;
	}

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
		EpilogiAitisisCombo.setBounds(10, 31, 463, 23);
		EpilogiAitisisCombo.select(0);
		System.out.println("eimai edw");
		PinakasThesewnRecruiter();
		for (int i = 0; i<seirespinaka; i++) {
		EpilogiAitisisCombo.add(EisagwgiThesewnRecruiter(i));
		System.out.println(EisagwgiThesewnRecruiter(i));
		}
		
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
		
		text = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(239, 60, 231, 21);
		
		text_1 = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		text_1.setBounds(239, 87, 231, 21);
		
		text_2 = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		text_2.setBounds(239, 114, 231, 21);
		
		text_3 = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		text_3.setBounds(239, 141, 231, 21);
		
		text_4 = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		text_4.setBounds(239, 168, 231, 21);
		
		text_5 = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		text_5.setEditable(false);
		text_5.setBounds(239, 195, 231, 21);
		
		text_6 = new Text(shlProvoliKaiEpeksergasiaAitisewn, SWT.BORDER);
		text_6.setBounds(239, 223, 231, 21);
		
		Button EditJobButton = new Button(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		EditJobButton.setBounds(10, 247, 125, 25);
		EditJobButton.setText("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1 \u0391\u03AF\u03C4\u03B7\u03C3\u03B7\u03C2");
		
		Button SaveAndQuitButton = new Button(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		SaveAndQuitButton.setText("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7 \u03BA\u03B1\u03B9 \u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		SaveAndQuitButton.setBounds(326, 247, 147, 25);
		
		Button button = new Button(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		button.setText("\u03A5\u03C0\u03BF\u03C8\u03AE\u03C6\u03B9\u03BF\u03B9 \u03BA\u03B1\u03B9 \u0392\u03B1\u03B8\u03BC\u03BF\u03BB\u03BF\u03B3\u03AF\u03B5\u03C2");
		button.setBounds(141, 247, 179, 25);
		formToolkit.adapt(button, true, true);
		

}
}
