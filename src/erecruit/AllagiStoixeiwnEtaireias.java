package erecruit;
//Done. Leipoun mono get/set apo SQL

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AllagiStoixeiwnEtaireias {


	protected Shell shell;
	private Text numText;
	private Text cityText;
	private Text countryText;
	private Text streetText;
	private Text telText;
	private Text nameText;
	private Text DOYText;
	private Text AFMText;
	private Button AllagiStoixeiwnButton;
	private Button EfarmogiAllagwnButton;

	private void SQLAllagiStoixeiwn() 		//TODO ola ta string sto erecruit.etairia//
	{
		String thlefwno = telText.getText();
		String odos = streetText.getText();
		String Arithmos = numText.getText();//TODO DE GOUSTAREI ARITHMOUS!
		String xwra = countryText.getText();
		String polh = cityText.getText();

	}


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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {

		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE) & (~SWT.MAX));
		shell.setSize(366, 300);
		shell.setText("\u03A0\u03C1\u03BF\u03B2\u03BF\u03BB\u03AE \u03BA\u03B1\u03B9 \u03B1\u03BB\u03BB\u03B1\u03B3\u03AE \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03C9\u03BD \u03B5\u03C4\u03B1\u03B9\u03C1\u03B5\u03AF\u03B1\u03C2");
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
								/*++++++++++++++++++++++++++++*/
								/*Dhmiourgia Label kai TextBox*/
								/*++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		Label AFM = new Label(shell, SWT.NONE);
		AFM.setBounds(10, 13, 77, 15);
		AFM.setText("\u0391.\u03A6.\u039C");
		
		Label DOY = new Label(shell, SWT.NONE);
		DOY.setText("\u0394.\u039F.\u03A5.");
		DOY.setBounds(10, 43, 77, 15);
		
		Label name = new Label(shell, SWT.NONE);
		name.setText("\u038C\u03BD\u03BF\u03BC\u03B1");
		name.setBounds(10, 70, 77, 15);
		
		Label tel = new Label(shell, SWT.NONE);
		tel.setText("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		tel.setBounds(10, 94, 77, 15);
		
		Label street = new Label(shell, SWT.NONE);
		street.setText("\u039F\u03B4\u03CC\u03C2");
		street.setBounds(10, 122, 77, 15);
		
		Label num = new Label(shell, SWT.NONE);
		num.setText("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2");
		num.setBounds(10, 146, 77, 15);
		
		Label city = new Label(shell, SWT.NONE);
		city.setText("\u03A0\u03CC\u03BB\u03B7");
		city.setBounds(10, 173, 77, 15);
		
		Label country = new Label(shell, SWT.NONE);
		country.setText("\u03A7\u03CE\u03C1\u03B1");
		country.setBounds(10, 200, 77, 15);
		
		numText = new Text(shell, SWT.BORDER);
		numText.setEnabled(false);
		numText.setEditable(false);
		numText.setBounds(172, 143, 168, 21);
		
		cityText = new Text(shell, SWT.BORDER);
		cityText.setEnabled(false);
		cityText.setEditable(false);
		cityText.setBounds(172, 170, 168, 21);
		
		countryText = new Text(shell, SWT.BORDER);
		countryText.setEnabled(false);
		countryText.setEditable(false);
		countryText.setBounds(172, 197, 168, 21);
		
		streetText = new Text(shell, SWT.BORDER);
		streetText.setEnabled(false);
		streetText.setEditable(false);
		streetText.setBounds(172, 119, 168, 21);
		
		telText = new Text(shell, SWT.BORDER);
		telText.setEnabled(false);
		telText.setEditable(false);
		telText.setBounds(172, 91, 168, 21);
		
		nameText = new Text(shell, SWT.BORDER);
		nameText.setEnabled(false);
		nameText.setEditable(false);
		nameText.setBounds(172, 67, 168, 21);
		
		DOYText = new Text(shell, SWT.BORDER);
		DOYText.setEnabled(false);
		DOYText.setEditable(false);
		DOYText.setBounds(172, 40, 168, 21);
		
		AFMText = new Text(shell, SWT.BORDER);
		AFMText.setEnabled(false);
		AFMText.setEditable(false);
		AFMText.setBounds(172, 10, 168, 21);
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
								/*++++++++++++++++++++++++++*/
								/*Eisagwgi stoixeiwn apo SQL*/
								/*++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		String Query = ("SELECT AFM, DOY, name, tel, street, num, city, country from etaireia INNER JOIN recruiter ON recruiter.firm=etaireia.AFM where recruiter.username = '" + LoginWindow.username + "'");
		try {
		ResultSet StoixeiaEtaireiasRS =  Main.Connection().executeQuery(Query);
		StoixeiaEtaireiasRS.first();
		AFMText.setText(StoixeiaEtaireiasRS.getString(1));
		DOYText.setText(StoixeiaEtaireiasRS.getString(2));
		nameText.setText(StoixeiaEtaireiasRS.getString(3));
		telText.setText(StoixeiaEtaireiasRS.getString(4));
		streetText.setText(StoixeiaEtaireiasRS.getString(5));
		numText.setText(StoixeiaEtaireiasRS.getString(6));
		cityText.setText(StoixeiaEtaireiasRS.getString(7));
		countryText.setText(StoixeiaEtaireiasRS.getString(8));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
									/*++++++++++++++++++++++++++++++++++*/
									/*Koumpia kai diaxeirisi leitourgiwn*/
									/*++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		AllagiStoixeiwnButton = new Button(shell, SWT.NONE);
		AllagiStoixeiwnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				telText.setEditable(true);
				telText.setEnabled(true);
				streetText.setEditable(true);
				streetText.setEnabled(true);
				numText.setEditable(true);
				numText.setEnabled(true);
				countryText.setEditable(true);
				countryText.setEnabled(true);
				cityText.setEditable(true);
				cityText.setEnabled(true);
				
			}
		});
		AllagiStoixeiwnButton.setBounds(10, 224, 114, 28);
		AllagiStoixeiwnButton.setText("\u0391\u03BB\u03BB\u03B1\u03B3\u03AE \u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03C9\u03BD");
		
		EfarmogiAllagwnButton = new Button(shell, SWT.NONE);
		EfarmogiAllagwnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				telText.setEditable(false);
				streetText.setEditable(false);
				numText.setEditable(false);
				countryText.setEditable(false);
				cityText.setEditable(false);
				SQLAllagiStoixeiwn();
			}
		});
		EfarmogiAllagwnButton.setText("\u0395\u03C6\u03B1\u03C1\u03BC\u03BF\u03B3\u03AE \u0391\u03BB\u03BB\u03B1\u03B3\u03CE\u03BD");
		EfarmogiAllagwnButton.setBounds(130, 224, 144, 28);
		
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

	}

}
