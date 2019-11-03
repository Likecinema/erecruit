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

public class ProvoliKaiEpeksergasiaAitisewn {

	protected Shell shlProvoliKaiEpeksergasiaAitisewn;

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
		shlProvoliKaiEpeksergasiaAitisewn.setSize(942, 536);
		shlProvoliKaiEpeksergasiaAitisewn.setText("Προβολή και επεξεργασία αιτήσεων");
		
		Label label = new Label(shlProvoliKaiEpeksergasiaAitisewn, SWT.NONE);
		label.setBounds(10, 10, 227, 15);
		label.setText("\u03A0\u03B1\u03C1\u03B1\u03BA\u03B1\u03BB\u03CE \u0394\u03BF\u03BA\u03B9\u03BC\u03AC\u03C3\u03C4\u03B5 \u03C0\u03AC\u03BB\u03B9 \u03B1\u03CD\u03C1\u03B9\u03BF");
		

}
}
