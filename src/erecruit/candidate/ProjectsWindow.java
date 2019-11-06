package erecruit.candidate;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import java.sql.*;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import erecruit.LoginWindow;
import erecruit.Main;

public class ProjectsWindow extends AllagiStoixeiwnCandidate {

	protected Shell shell;
	private Text PerigrafiText;
	private Text URLText;
	private int seires = 0;

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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(10, 31, 414, 23);
		PinakasProject();
		for(int i=0; i<seires; i++) {
			combo.add(EisagwghIDStoCombo(i));
		}
		combo.select(0);
		combo.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				int IDint = combo.getSelectionIndex();
				String[][] PinakasMeProject = PinakasProject();
				PerigrafiText.setText(PinakasMeProject[IDint][1]);
				URLText.setText(PinakasMeProject[IDint][2]);
			}});
		
		Label IDLabel = new Label(shell, SWT.NONE);
		IDLabel.setBounds(10, 10, 414, 15);
		IDLabel.setText("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 Project \u03BC\u03B5 \u03B2\u03AC\u03C3\u03B7 \u03C4\u03BF ID");
		
		PerigrafiText = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.WRAP | SWT.MULTI);
		PerigrafiText.setEditable(false);
		PerigrafiText.setBounds(10, 60, 414, 161);
		
		Label URLLabel = new Label(shell, SWT.NONE);
		URLLabel.setBounds(10, 236, 55, 15);
		URLLabel.setText("URL:");
		
		URLText = new Text(shell, SWT.BORDER);
		URLText.setEditable(false);
		URLText.setBounds(71, 230, 353, 21);

	}
	private String[][] PinakasProject() {
			String TheseisApoSQL = ("select `num`, `descr`, `url` from project where candid = '" + LoginWindow.username + "'");
			String[][] error = new String[][] {{"error1"},{"error2"}};
			try {
				ResultSet ProjectsCandidateRS = Main.Connection().executeQuery(TheseisApoSQL);
				ResultSetMetaData MetadataRS = ProjectsCandidateRS.getMetaData();
				int SthlesProject = MetadataRS.getColumnCount();
				ProjectsCandidateRS.last();
				int SeiresProject = ProjectsCandidateRS.getRow();
				seires = SeiresProject;
				ProjectsCandidateRS.first();
				String[][] PinakasThesewn = new String[SeiresProject][SthlesProject];
				for (int i = 0; i< SeiresProject; i++) {
					for (int k = 0; k<SthlesProject;k++)
					{
						PinakasThesewn[i][k] = ProjectsCandidateRS.getString(k+1);
					}
					ProjectsCandidateRS.next();

				}
				return PinakasThesewn;
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return error;
	}
		protected String EisagwghIDStoCombo(int i){
			String IDGiaCombo = null;
			String[][] ArrayGiaCombo = PinakasProject();
				IDGiaCombo = ArrayGiaCombo[i][0];
				return IDGiaCombo;
		}
	}
