package erecruit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ProvoliKaiAkurwshAitisisCandidate {

	protected Shell shell;
	private int sthles;
	private int seires;

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
		shell.setText("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u03BA\u03B1\u03B9 \u0391\u03BA\u03CD\u03C1\u03C9\u03C3\u03B7 \u03B1\u03AF\u03C4\u03B7\u03C3\u03B7\u03C2");
		shell.setSize(348, 350);
		
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(10, 31, 312, 23);
		PinakasAitisewnErgasias();
		for (int i = 0; i<seires; i++) {
		combo.add(EisagwgiThesewnErgasias(i));
		}
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 70, 165, 15);
		label.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03AD\u03BD\u03B1\u03C1\u03BE\u03B7\u03C2");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(10, 91, 55, 15);
		label_1.setText("\u039C\u03B9\u03C3\u03B8\u03CC\u03C2");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(10, 115, 55, 15);
		label_2.setText("\u0398\u03AD\u03C3\u03B7");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(10, 136, 55, 15);
		label_3.setText("\u0388\u03B4\u03C1\u03B1");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(10, 157, 165, 15);
		label_4.setText("\u03A5\u03C0\u03B5\u03CD\u03B8\u03C5\u03BD\u03BF\u03C2 \u03C0\u03C1\u03BF\u03C3\u03BB\u03AE\u03C8\u03B5\u03C9\u03BD");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 178, 165, 15);
		lblNewLabel.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0391\u03BD\u03B1\u03BA\u03BF\u03AF\u03BD\u03C9\u03C3\u03B7\u03C2");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(10, 199, 165, 15);
		lblNewLabel_1.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u039B\u03AE\u03BE\u03B7\u03C2 \u03A5\u03C0\u03BF\u03B2\u03BF\u03BB\u03AE\u03C2");
		
		Label StartDateDynamicLabel = new Label(shell, SWT.NONE);
		StartDateDynamicLabel.setAlignment(SWT.CENTER);
		StartDateDynamicLabel.setBounds(202, 70, 120, 15);
		
		Label SalaryDynamicLabel = new Label(shell, SWT.NONE);
		SalaryDynamicLabel.setAlignment(SWT.CENTER);
		SalaryDynamicLabel.setBounds(202, 91, 120, 15);
		
		Label PositionDynamicLabel = new Label(shell, SWT.NONE);
		PositionDynamicLabel.setAlignment(SWT.CENTER);
		PositionDynamicLabel.setBounds(202, 115, 120, 15);
		
		Label EdraDynamicLabel = new Label(shell, SWT.NONE);
		EdraDynamicLabel.setAlignment(SWT.CENTER);
		EdraDynamicLabel.setBounds(202, 136, 120, 15);
		
		Label RecruiterDynamicLabel = new Label(shell, SWT.NONE);
		RecruiterDynamicLabel.setAlignment(SWT.CENTER);
		RecruiterDynamicLabel.setBounds(202, 157, 120, 15);
		
		Label AnnounceDateDynamicLabel = new Label(shell, SWT.NONE);
		AnnounceDateDynamicLabel.setAlignment(SWT.CENTER);
		AnnounceDateDynamicLabel.setBounds(202, 178, 120, 15);
		
		Label SubmissionDateDynamicLabel = new Label(shell, SWT.NONE);
		SubmissionDateDynamicLabel.setAlignment(SWT.CENTER);
		SubmissionDateDynamicLabel.setBounds(202, 199, 120, 15);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() { //TODO akurwsh aitisis
			@Override
			public void mouseUp(MouseEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date Shmera = new Date();
				String Hmerominia = formatter.format(Shmera);
			}
		});
		btnNewButton.setBounds(10, 255, 312, 25);
		btnNewButton.setText("\u0391\u03BA\u03CD\u03C1\u03C9\u03C3\u03B7 \u0391\u03AF\u03C4\u03B7\u03C3\u03B7\u03C2");
		
		Label KatastasiAkurwshsDynamicLabel = new Label(shell, SWT.NONE);
		KatastasiAkurwshsDynamicLabel.setAlignment(SWT.CENTER);
		KatastasiAkurwshsDynamicLabel.setBounds(10, 286, 312, 15);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(10, 10, 312, 15);
		lblNewLabel_2.setText("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03B1\u03AF\u03C4\u03B7\u03C3\u03B7 \u03BC\u03B5 \u03B2\u03AC\u03C3\u03B7 \u03C4\u03BF ID");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(10, 220, 165, 15);
		lblNewLabel_3.setText("\u039A\u03B1\u03C4\u03AC\u03C3\u03C4\u03B1\u03C3\u03B7 \u03B1\u03AF\u03C4\u03B7\u03C3\u03B7\u03C2");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(181, 220, 141, 15);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { //TODO Katastash Aitisis
				int ArithmosTheshs = combo.getSelectionIndex();
				String[][] PinakasAitisewn = PinakasAitisewnErgasias();
				StartDateDynamicLabel.setText(PinakasAitisewn[ArithmosTheshs][1]);
				SalaryDynamicLabel.setText(PinakasAitisewn[ArithmosTheshs][2]);
				PositionDynamicLabel.setText(PinakasAitisewn[ArithmosTheshs][3]);
				EdraDynamicLabel.setText(PinakasAitisewn[ArithmosTheshs][4]);
				AnnounceDateDynamicLabel.setText(PinakasAitisewn[ArithmosTheshs][6]);
				RecruiterDynamicLabel.setText(PinakasAitisewn[ArithmosTheshs][5]);
				SubmissionDateDynamicLabel.setText(PinakasAitisewn[ArithmosTheshs][7]);
			}});

	}
	private String[][] PinakasAitisewnErgasias(){
	String TheseisApoSQL = ("select * from job inner join applies on applies.job_id = job.id where applies.cand_usrname = '" + LoginWindow.username + "'");
	String[][] error = new String[][] {{"error1"},{"error2"}};
		try {
			ResultSet TheseisErgasiasRS = Main.Connection().executeQuery(TheseisApoSQL);
			ResultSetMetaData MetadataThesewnErgasias = TheseisErgasiasRS.getMetaData();
			int SthlesThesewn = MetadataThesewnErgasias.getColumnCount();
			sthles = SthlesThesewn;
			TheseisErgasiasRS.last();
			int SeiresThesewn = TheseisErgasiasRS.getRow();
			seires = SeiresThesewn;
			TheseisErgasiasRS.first();
			String[][] PinakasThesewn = new String[SeiresThesewn][SthlesThesewn];
			for (int i = 0; i< SeiresThesewn; i++) {
				for (int k = 0; k<SthlesThesewn;k++)
				{
					PinakasThesewn[i][k] = TheseisErgasiasRS.getString(k+1);
				}
				TheseisErgasiasRS.next();

			}
			return PinakasThesewn;
			}
		catch (SQLException e) {e.printStackTrace();}
		return error;
		}
		protected String EisagwgiThesewnErgasias(int i){
			String IDGiaCombo = null;
			String[][] ArrayGiaCombo = PinakasAitisewnErgasias();
				IDGiaCombo = ArrayGiaCombo[i][0];
				return IDGiaCombo;
		}

}
