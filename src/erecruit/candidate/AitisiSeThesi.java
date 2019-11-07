package erecruit.candidate; //DONE

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import erecruit.LoginWindow;
import erecruit.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AitisiSeThesi {

	protected Shell shell;
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
	shell.setSize(307, 237);
	shell.setText("\u0391\u03AF\u03C4\u03B7\u03C3\u03B7 \u03B3\u03B9\u03B1 \u03B8\u03AD\u03C3\u03B7");
	
	Combo combo = new Combo(shell, SWT.READ_ONLY);
	
	combo.setBounds(10, 31, 271, 23);
	PinakasThesewnErgasias();
	for (int i = 0; i<seires; i++) {
	combo.add(EisagwgiThesewnErgasias(i));
	}
	
	Label lblNewLabel = new Label(shell, SWT.NONE);
	lblNewLabel.setBounds(10, 10, 115, 15);
	lblNewLabel.setText("ID \u0398\u03AD\u03C3\u03B7\u03C2 \u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1\u03C2");
	
	Label lblNewLabel_1 = new Label(shell, SWT.NONE);
	lblNewLabel_1.setBounds(10, 60, 115, 15);
	lblNewLabel_1.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03AD\u03BD\u03B1\u03C1\u03BE\u03B7\u03C2");
	
	Label AnnounceDateDynamicLabel = new Label(shell, SWT.NONE);
	AnnounceDateDynamicLabel.setAlignment(SWT.CENTER);
	AnnounceDateDynamicLabel.setBounds(169, 140, 115, 15);
	
	Label label = new Label(shell, SWT.NONE);
	label.setBounds(10, 81, 55, 15);
	label.setText("\u039C\u03B9\u03C3\u03B8\u03CC\u03C2");
	
	Label PositionDynamicLabel = new Label(shell, SWT.NONE);
	PositionDynamicLabel.setAlignment(SWT.CENTER);
	PositionDynamicLabel.setBounds(169, 102, 115, 15);
	
	Label lblNewLabel_4 = new Label(shell, SWT.NONE);
	lblNewLabel_4.setBounds(10, 102, 55, 15);
	lblNewLabel_4.setText("\u0398\u03AD\u03C3\u03B7");
	
	Label EdraDynamicLabel = new Label(shell, SWT.NONE);
	EdraDynamicLabel.setAlignment(SWT.CENTER);
	EdraDynamicLabel.setBounds(169, 119, 115, 15);
	
	Label lblNewLabel_6 = new Label(shell, SWT.NONE);
	lblNewLabel_6.setBounds(10, 119, 55, 15);
	lblNewLabel_6.setText("\u0388\u03B4\u03C1\u03B1");
	
	Label lblNewLabel_7 = new Label(shell, SWT.NONE);
	lblNewLabel_7.setBounds(10, 140, 152, 15);
	lblNewLabel_7.setText("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03B1\u03BD\u03B1\u03BA\u03BF\u03AF\u03BD\u03C9\u03C3\u03B7\u03C2");
	
	Label SalaryDynamicLabel = new Label(shell, SWT.NONE);
	SalaryDynamicLabel.setAlignment(SWT.CENTER);
	SalaryDynamicLabel.setBounds(169, 81, 115, 15);
	
	Label StartDateDynamicLabel = new Label(shell, SWT.NONE);
	StartDateDynamicLabel.setAlignment(SWT.CENTER);
	StartDateDynamicLabel.setBounds(169, 60, 115, 15);
	
	Button btnNewButton = new Button(shell, SWT.NONE);
	btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseUp(MouseEvent e) {
			int ArithmosIndex = combo.getSelectionIndex();
			String IDThesis = combo.getItem(ArithmosIndex);
			String InsertOnApplies = "insert into applies (cand_usrname, job_id) values ('"+LoginWindow.username+"',"+IDThesis+");";
			try {
				Main.Connection().execute(InsertOnApplies);
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	});
	btnNewButton.setBounds(10, 161, 271, 25);
	btnNewButton.setText("\u0391\u03AF\u03C4\u03B7\u03C3\u03B7 \u03B3\u03B9\u03B1 \u03C4\u03B7 \u03B8\u03AD\u03C3\u03B7");
	combo.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			int ArithmosTheshs = combo.getSelectionIndex();
			String[][] PinakasErgasiwn = PinakasThesewnErgasias();
			StartDateDynamicLabel.setText(PinakasErgasiwn[ArithmosTheshs][4]);
			SalaryDynamicLabel.setText(PinakasErgasiwn[ArithmosTheshs][1]);
			PositionDynamicLabel.setText(PinakasErgasiwn[ArithmosTheshs][3]);
			EdraDynamicLabel.setText(PinakasErgasiwn[ArithmosTheshs][2]);
			AnnounceDateDynamicLabel.setText(PinakasErgasiwn[ArithmosTheshs][5]);
		}
	});
	}

	private String[][] PinakasThesewnErgasias(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date Shmera = new Date();
		String Hmerominia = formatter.format(Shmera);
	String TheseisApoSQL = ("select `id`, `salary`,`edra`, `position`,`start_date`,`announce_date`,`submission_date` from job where submission_date >= '" + Hmerominia + "'");
	String[][] error = new String[][] {{"error1"},{"error2"}};
		try {
			ResultSet TheseisErgasiasRS = Main.Connection().executeQuery(TheseisApoSQL);
			ResultSetMetaData MetadataThesewnErgasias = TheseisErgasiasRS.getMetaData();
			int SthlesThesewn = MetadataThesewnErgasias.getColumnCount();
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
			String[][] ArrayGiaCombo = PinakasThesewnErgasias();
				IDGiaCombo = ArrayGiaCombo[i][0];
				return IDGiaCombo;
		}
		
	}
