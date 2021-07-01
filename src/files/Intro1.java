package files;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Intro1 extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Intro1(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(Intro1.class, "/images/ENG.png"));
		
		Button btnTextFlow = new Button(this, SWT.NONE);
		btnTextFlow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				try {
					Display display = Display.getDefault();
					GUI shell = new GUI(display);
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
		btnTextFlow.setBounds(165, 93, 75, 25);
		btnTextFlow.setText("Text Flow");
		
		Button btnCharcterTracker = new Button(this, SWT.NONE);
		btnCharcterTracker.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				try {
					Display display = Display.getDefault();
					GUI_2 shell = new GUI_2(display);
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
		btnCharcterTracker.setBounds(153, 182, 96, 25);
		btnCharcterTracker.setText("Charcter Tracker");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				try {
					Display display = Display.getDefault();
					GUI_1 shell = new GUI_1(display);
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
		btnNewButton.setBounds(135, 136, 134, 25);
		btnNewButton.setText("Character Tracker Old");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Enigma 3");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
