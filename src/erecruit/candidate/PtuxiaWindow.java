package erecruit.candidate;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import java.sql.*;
import org.eclipse.swt.widgets.TableItem;

import erecruit.LoginWindow;
import erecruit.Main;

import org.eclipse.swt.widgets.TableColumn;

public class PtuxiaWindow extends AllagiStoixeiwnCandidate {

	protected Shell shell;
	private Table table;

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		PtuxiaCandidate();
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
		shell.setSize(780, 538);
		shell.setText("SWT Application");

		

		
		
		Label TitlosLabel = new Label(shell, SWT.NONE);
		TitlosLabel.setAlignment(SWT.CENTER);
		TitlosLabel.setBounds(10, 10, 150, 15);
		TitlosLabel.setText("\u03A4\u03AF\u03C4\u03BB\u03BF\u03C2");
		
		Label IdrumaLabel = new Label(shell, SWT.NONE);
		IdrumaLabel.setAlignment(SWT.CENTER);
		IdrumaLabel.setBounds(160, 10, 150, 15);
		IdrumaLabel.setText("\u038A\u03B4\u03C1\u03C5\u03BC\u03B1");
		
		Label BathmidaLabel = new Label(shell, SWT.NONE);
		BathmidaLabel.setAlignment(SWT.CENTER);
		BathmidaLabel.setBounds(310, 10, 150, 15);
		BathmidaLabel.setText("\u0392\u03B1\u03B8\u03BC\u03AF\u03B4\u03B1");
		
		Label EtosLabel = new Label(shell, SWT.NONE);
		EtosLabel.setAlignment(SWT.CENTER);
		EtosLabel.setBounds(460, 10, 150, 15);
		EtosLabel.setText("\u0388\u03C4\u03BF\u03C2");
		
		Label VathmosLabel = new Label(shell, SWT.NONE);
		VathmosLabel.setAlignment(SWT.CENTER);
		VathmosLabel.setBounds(610, 10, 150, 15);
		VathmosLabel.setText("\u0392\u03B1\u03B8\u03BC\u03CC\u03C2");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 31, 744, 416);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	
		
		
		Button ProsthikiPtuxiouBtn = new Button(shell, SWT.NONE);
		ProsthikiPtuxiouBtn.setBounds(10, 464, 744, 25);
		ProsthikiPtuxiouBtn.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03C0\u03C4\u03C5\u03C7\u03AF\u03BF\u03C5");

	}
	
	protected void PtuxiaCandidate()
	/* Arxika h methodos psaxnei gia theseis ergasias ths etaireias, apothikevontai se ena ResultSet. Epeita pairnei ton arithmo sthlwn apo ta metadata tou resultset kai dhmiourgei aftomata
	 * ton aparaithto arithmo sthlwn gia to ResultSet. Mesw ths while elegxei an uparoxun alles grammes, an uparxoun sunexizei. Telos, pairnei to keimeno apo kathe sthlh kai to topothetei sth
	 * swsth sthlh tou pinaka. */
	{
		try
		{
			String Query = ("SELECT titlos,idryma,bathmida,etos,grade from degree inner join has_degree on has_degree.degr_title = degree.titlos where has_degree.cand_usrname = '" + LoginWindow.username + "'");
			ResultSet PtuxiaRS = Main.Connection().executeQuery(Query);
			System.out.println(Query);
			ResultSetMetaData MetadataThesewnEtaireias = PtuxiaRS.getMetaData();
			int ArithmosSthlwn = MetadataThesewnEtaireias.getColumnCount();
			System.out.println(ArithmosSthlwn);
		

		while (PtuxiaRS.next() == true)
		{
			
			TableItem item = new TableItem(table, SWT.NONE);

			for (int k = 1; k < ArithmosSthlwn + 1; k++) {
				if (table.getColumnCount() < ArithmosSthlwn) {
					TableColumn tblclm = new TableColumn(table, SWT.NONE);
					tblclm.setWidth(150);
				}
				item.setText(k-1, PtuxiaRS.getString(k));
				System.out.println(PtuxiaRS.getString(k));
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
