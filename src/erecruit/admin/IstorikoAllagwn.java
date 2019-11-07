package erecruit.admin;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import erecruit.LoginWindow;
import erecruit.Main;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;

public class IstorikoAllagwn {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IstorikoAllagwn window = new IstorikoAllagwn();
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
		shell = new Shell();
		shell.setSize(978, 486);
		shell.setText("\u0399\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03CC \u03BC\u03B5\u03C4\u03B1\u03B2\u03BF\u03BB\u03CE\u03BD \u03B1\u03BD\u03AC \u03C0\u03AF\u03BD\u03B1\u03BA\u03B1");
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setAlignment(SWT.CENTER);
		lblId.setBounds(10, 10, 150, 15);
		lblId.setText("ID \u0391\u03BB\u03BB\u03B1\u03B3\u03AE\u03C2");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("\u038C\u03BD\u03BF\u03BC\u03B1 \u03C7\u03C1\u03AE\u03C3\u03C4\u03B7");
		label.setAlignment(SWT.CENTER);
		label.setBounds(166, 10, 150, 15);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u0397\u03BC/\u03BD\u03AF\u03B1 \u03BA\u03B1\u03B9 \u03CE\u03C1\u03B1");
		label_1.setAlignment(SWT.CENTER);
		label_1.setBounds(322, 10, 150, 15);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u0395\u03C0\u03B9\u03C4\u03C5\u03C7\u03AF\u03B1");
		label_2.setAlignment(SWT.CENTER);
		label_2.setBounds(478, 10, 150, 15);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u0394\u03C1\u03AC\u03C3\u03B7");
		label_3.setAlignment(SWT.CENTER);
		label_3.setBounds(634, 10, 150, 15);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("\u03A0\u03AF\u03BD\u03B1\u03BA\u03B1\u03C2");
		label_4.setAlignment(SWT.CENTER);
		label_4.setBounds(782, 10, 150, 15);
		
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(10, 414, 774, 23);
		combo.add("user");
		combo.add("recruiter");
		combo.add("etaireia");
		combo.add("candidate");
		combo.add("job");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(10, 393, 942, 15);
		lblNewLabel.setText("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03C0\u03AF\u03BD\u03B1\u03BA\u03B1 \u03B3\u03B9\u03B1 \u03C0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u03C4\u03BF\u03C5 \u03B9\u03C3\u03C4\u03BF\u03C1\u03B9\u03BA\u03BF\u03CD \u03BC\u03B5\u03C4\u03B1\u03B2\u03BF\u03BB\u03CE\u03BD");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 31, 942, 356);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Button epilogibtn = new Button(shell, SWT.NONE);
		epilogibtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String pinakas = combo.getText();
				table.removeAll();
				IstorikoMetavolwnAnaPinaka(pinakas);
			}
		});
		epilogibtn.setBounds(802, 412, 150, 25);
		epilogibtn.setText("\u0395\u03C0\u03B9\u03BB\u03BF\u03B3\u03AE");

	}
	private void IstorikoMetavolwnAnaPinaka(String Pinakas){
		try
		{
			String PinakasMetavolwn = ("select * from logs where pinakas = '"+Pinakas+"';");
			ResultSet PinakasMetavolwnRS = Main.Connection().executeQuery(PinakasMetavolwn);
			ResultSetMetaData MetadataPinakaMetavolwn = PinakasMetavolwnRS.getMetaData();
			int ArithmosSthlwn = MetadataPinakaMetavolwn.getColumnCount();
		

		while (PinakasMetavolwnRS.next() == true)
		{
			
			TableItem item = new TableItem(table, SWT.NONE);

			for (int k = 1; k < ArithmosSthlwn + 1; k++) {
				if (table.getColumnCount() < ArithmosSthlwn) {
					TableColumn tblclm = new TableColumn(table, SWT.NONE);
					tblclm.setWidth(150);
				}
				item.setText(k-1, PinakasMetavolwnRS.getString(k));
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
}
	
