package erecruit.admin; //DONE ProsthikiAntikeim.

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import erecruit.Main;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Combo;

public class ProsthikiAntikeim {

	protected Shell shell;
	private Text OnomaAntikeimenouText;
	private Text PerigrafiAntikeimenouText;
	private int grammes;
	
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
		shell.setSize(275, 300);
		shell.setText("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03B1\u03BD\u03C4\u03B9\u03BA\u03B5\u03B9\u03BC\u03AD\u03BD\u03BF\u03C5");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 10, 109, 15);
		label.setText("\u038C\u03BD\u03BF\u03BC\u03B1 \u0391\u03BD\u03C4\u03B9\u03BA\u03B5\u03B9\u03BC\u03AD\u03BD\u03BF\u03C5");
		
		OnomaAntikeimenouText = new Text(shell, SWT.BORDER);
		OnomaAntikeimenouText.setBounds(10, 31, 239, 21);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 58, 137, 15);
		lblNewLabel.setText("\u03A0\u03B5\u03C1\u03B9\u03B3\u03C1\u03B1\u03C6\u03AE \u03B1\u03BD\u03C4\u03B9\u03BA\u03B5\u03B9\u03BC\u03AD\u03BD\u03BF\u03C5");
		
		PerigrafiAntikeimenouText = new Text(shell, SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
		PerigrafiAntikeimenouText.setBounds(10, 79, 239, 96);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setAlignment(SWT.CENTER);
		label_1.setBounds(10, 181, 239, 15);
		label_1.setText("\u0391\u03BD\u03AE\u03BA\u03B5\u03B9 \u03C3\u03B5:");
		
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setBounds(10, 200, 239, 23);
		TitloiAntikeimenwn();
		for(int i=0; i<grammes; i++) {
			combo.add(StringGiaCombo(i));
		}
		combo.select(0);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String OnomaAntikeimenou = OnomaAntikeimenouText.getText();
				String PerigrafiAntikeimenou = PerigrafiAntikeimenouText.getText();
				String combotext = null;
				combotext = combo.getText();
				String UpdateAntikeim = "INSERT INTO antikeim (title, descr, belongs_to) values ('"+OnomaAntikeimenou+"','"+PerigrafiAntikeimenou+"','"+combotext+"');";
				try {
					Main.Connection().execute(UpdateAntikeim);
					OnomaAntikeimenouText.setEditable(false);
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 226, 239, 25);
		btnNewButton.setText("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");

	}
	public String[] TitloiAntikeimenwn() {
		String [] error = {"error"};
		try {
			ResultSet TitloiAntikeimenwnRS = Main.Connection().executeQuery("SELECT title FROM antikeim;");
			TitloiAntikeimenwnRS.last();
			int i = TitloiAntikeimenwnRS.getRow() - 1;
			grammes = i;
			TitloiAntikeimenwnRS.first();
			String[] TitloiAntikeimenwnPinakas = new String[i];
			for (int j=0; j<i; j++)
			{
				TitloiAntikeimenwnPinakas[j] = TitloiAntikeimenwnRS.getString(1);
				TitloiAntikeimenwnRS.next();
				
			}
			return TitloiAntikeimenwnPinakas;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return error;
		
	}
	public String StringGiaCombo(int i) {
		String[] SunoloAntikeimenwn = null;
		SunoloAntikeimenwn = TitloiAntikeimenwn();
	String epistrofi = SunoloAntikeimenwn[i];
	return epistrofi;
	}
}
