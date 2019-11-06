//TODO! doulevoun ola ta get, xreiazomai ola ta set
package erecruit;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class RecruiterWindow extends LoginWindow {
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						/*+++++++++++++++++++++++++++++++++++++*/
						/*Parathiro tou interface tou recruiter*/
						/*+++++++++++++++++++++++++++++++++++++*/
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

	protected Shell shell;


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
		shell.setSize(369, 212);
		shell.setText("Παράθυρο υπεύθυνου προσλήψεων");
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						/*Anoigma neou parathirou analoga me th leitourgia pou dialegei o xristis*/
						/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
		Button ButtonAllagiStoixeiwnEtaireias = new Button(shell, SWT.NONE);
		ButtonAllagiStoixeiwnEtaireias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				AllagiStoixeiwnEtaireias ParathiroAllagisStoixeiwn = new AllagiStoixeiwnEtaireias();
				ParathiroAllagisStoixeiwn.createContents();
				ParathiroAllagisStoixeiwn.open();
			}
		});
		ButtonAllagiStoixeiwnEtaireias.setBounds(10, 10, 323, 25);
		ButtonAllagiStoixeiwnEtaireias.setText("Αλλαγή στοιχείων Εταιρείας");
		
		Button ButtonAllagiStoixeiwnLogariasmou = new Button(shell, SWT.NONE);
		ButtonAllagiStoixeiwnLogariasmou.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				AllagiStoixeiwnLogariasmouRecruiter ParathiroAllagisRecruiter = new AllagiStoixeiwnLogariasmouRecruiter();
				ParathiroAllagisRecruiter.createContents();
				ParathiroAllagisRecruiter.open();
			}
		});
		ButtonAllagiStoixeiwnLogariasmou.setBounds(10, 72, 323, 25);
		ButtonAllagiStoixeiwnLogariasmou.setText("Αλλαγή στοιχείων λογαριασμού");
		
		Button ButtonProsthikiThesisErgasias = new Button(shell, SWT.NONE);
		ButtonProsthikiThesisErgasias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ProsthikiThesisErgasias ParathiroProsthikisThesis = new ProsthikiThesisErgasias();
				ParathiroProsthikisThesis.createContents();
				ParathiroProsthikisThesis.open();
			}
		});
		ButtonProsthikiThesisErgasias.setBounds(10, 41, 323, 25);
		ButtonProsthikiThesisErgasias.setText("Προσθήκη θέσης εργασίας");
		
		Button ProvoliProsopikwnThesewn = new Button(shell, SWT.NONE);
		ProvoliProsopikwnThesewn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ProvoliKaiEpeksergasiaAitisewn ParathiroProvolisKaiEpeksergasias = new ProvoliKaiEpeksergasiaAitisewn();
				ParathiroProvolisKaiEpeksergasias.createContents();
				ParathiroProvolisKaiEpeksergasias.open();
			}
		});
		ProvoliProsopikwnThesewn.setBounds(10, 103, 323, 25);
		ProvoliProsopikwnThesewn.setText("Προβολή/Επεξεργασία προσωπικών θέσεων εργασίας");
		
		Button ButtonProvoliThesewnEtairias = new Button(shell, SWT.NONE);
		ButtonProvoliThesewnEtairias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				TheseisErgasiasEtaireias ParathiroThesewn = new TheseisErgasiasEtaireias();
				ParathiroThesewn.createContents();
				ParathiroThesewn.open();
				
			}
		});
		ButtonProvoliThesewnEtairias.setBounds(10, 134, 323, 25);
		ButtonProvoliThesewnEtairias.setText("Προβολή θέσεων εργασίας της Εταιρείας");

	}
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

}
