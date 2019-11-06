//DONE!

package erecruit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Point;

public class TheseisErgasiasEtaireias {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TheseisErgasiasEtaireias window = new TheseisErgasiasEtaireias();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		MethodosEvresisThesewn(LoginWindow.username);
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
	 */
	protected void createContents() {
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		shell.setMinimumSize(new Point(150, 39));
		shell.setSize(1100, 480);
		shell.setText("Προβολή θέσεων εργασίας της Εταιρείας");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setBounds(10, 35, 1060, 396);
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setAlignment(SWT.CENTER);
		lblId.setBounds(10, 14, 150, 15);
		lblId.setText("ID");
		Label lblSalary = new Label(shell, SWT.NONE);
		lblSalary.setAlignment(SWT.CENTER);
		lblSalary.setBounds(160, 14, 150, 15);
		lblSalary.setText("Μισθός");
		Label lblEdra = new Label(shell, SWT.NONE);
		lblEdra.setAlignment(SWT.CENTER);
		lblEdra.setBounds(310, 14, 150, 15);
		lblEdra.setText("Έδρα");
		Label lblPosition = new Label(shell, SWT.NONE);
		lblPosition.setAlignment(SWT.CENTER);
		lblPosition.setBounds(460, 14, 150, 15);
		lblPosition.setText("Θέση");
		Label lblRecruiter = new Label(shell, SWT.NONE);
		lblRecruiter.setAlignment(SWT.CENTER);
		lblRecruiter.setBounds(610, 14, 150, 15);
		lblRecruiter.setText("Υπεύθυνος προσλήψεων");
		Label lblAnnDate = new Label(shell, SWT.NONE);
		lblAnnDate.setAlignment(SWT.CENTER);
		lblAnnDate.setBounds(760, 14, 150, 15);
		lblAnnDate.setText("Ημερομινία Ανακοίνωσης");
		Label lblSubDate = new Label(shell, SWT.NONE);
		lblSubDate.setAlignment(SWT.CENTER);
		lblSubDate.setBounds(910, 14, 150, 15);
		lblSubDate.setText("Υποβολή μέχρι");

	}

	protected void MethodosEvresisThesewn(String Username)
	/* Arxika h methodos psaxnei gia theseis ergasias ths etaireias, apothikevontai se ena ResultSet. Epeita pairnei ton arithmo sthlwn apo ta metadata tou resultset kai dhmiourgei aftomata
	 * ton aparaithto arithmo sthlwn gia to ResultSet. Mesw ths while elegxei an uparoxun alles grammes, an uparxoun sunexizei. Telos, pairnei to keimeno apo kathe sthlh kai to topothetei sth
	 * swsth sthlh tou pinaka. */
	{
		try
		{
			String TheseisErgasias = ("select `id`, `salary`,`edra`, `position`,`recruiter`,`announce_date`,`submission_date` from job inner join recruiter on job.recruiter = recruiter.username inner join etaireia on recruiter.firm = etaireia.AFM where etaireia.AFM in ( select recruiter.firm from recruiter where recruiter.username = '" + LoginWindow.username + "')");
			ResultSet TheseisErgasiasRS = Main.Connection().executeQuery(TheseisErgasias);
			ResultSetMetaData MetadataThesewnEtaireias = TheseisErgasiasRS.getMetaData();
			int ArithmosSthlwn = MetadataThesewnEtaireias.getColumnCount();
		

		while (TheseisErgasiasRS.next() == true)
		{
			
			TableItem item = new TableItem(table, SWT.NONE);

			for (int k = 1; k < ArithmosSthlwn + 1; k++) {
				if (table.getColumnCount() < ArithmosSthlwn) {
					TableColumn tblclm = new TableColumn(table, SWT.NONE);
					tblclm.setWidth(150);
				}
				item.setText(k-1, TheseisErgasiasRS.getString(k));
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

