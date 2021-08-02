package files;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Intro2 extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Intro2(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(Intro1.class, "/images/ENG.png"));
		
		Label cr = new Label(this, SWT.NONE);
		cr.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		cr.setBounds(20, 230, 200, 30);
		cr.setText("Created by: Hesham Moneer");
		
		Button btnTextFlow = new Button(this, SWT.NONE);
		btnTextFlow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				try {
					Display display = Display.getDefault();
					GUI2 shell = new GUI2(display);
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
					GUI2_1 shell = new GUI2_1(display);
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
		btnCharcterTracker.setBounds(155, 150, 96, 25);
		btnCharcterTracker.setText("Charcter tracker");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Enigma 4");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
