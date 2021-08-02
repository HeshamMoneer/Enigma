package files;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Intro extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Intro shell = new Intro(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Intro(Display display) {
		super(display, SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL | SWT.MIN);
		setImage(SWTResourceManager.getImage(Intro.class, "/images/ENG.png"));
		
		Label lblChooseYourEnigma = new Label(this, SWT.NONE);
		lblChooseYourEnigma.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblChooseYourEnigma.setBounds(156, 72, 139, 30);
		lblChooseYourEnigma.setText("Choose edition");
		
		Label cr = new Label(this, SWT.NONE);
		cr.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		cr.setBounds(20, 230, 200, 30);
		cr.setText("Created by: Hesham Moneer");
		
		Button btnEngima = new Button(this, SWT.NONE);
		btnEngima.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				try {
					Display display = Display.getDefault();
					Intro1 shell = new Intro1(display);
					shell.open();
					shell.layout();
					while (!shell.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception em) {
					em.printStackTrace();
				}
			}
		});
		btnEngima.setBounds(93, 134, 75, 25);
		btnEngima.setText("Engima 3");
		
		Button btnEnigma = new Button(this, SWT.NONE);
		btnEnigma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				try {
					Display display = Display.getDefault();
					Intro2 shell = new Intro2(display);
					shell.open();
					shell.layout();
					while (!shell.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception em) {
					em.printStackTrace();
				}
			}
		});
		btnEnigma.setBounds(280, 134, 75, 25);
		btnEnigma.setText("Enigma 4");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Engima");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
