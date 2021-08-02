package files;

//import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GUI extends Shell {
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String args[]) {
//		try {
//			Display display = Display.getDefault();
//			GUI shell = new GUI(display);
//			shell.open();
//			shell.layout();
//			while (!shell.isDisposed()) {
//				if (!display.readAndDispatch()) {
//					display.sleep();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the shell.
	 * @param display
	 */
	static boolean doubleStepping = false;
	static boolean additional = false;
	private Button btnBack;
	public GUI(Display display) {
		super(display, SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL | SWT.MIN);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setImage(SWTResourceManager.getImage(GUI.class, "/images/ENG.png"));
		
		Label lblReflector = new Label(this, SWT.NONE);
		lblReflector.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblReflector.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblReflector.setBounds(27, 39, 117, 37);
		lblReflector.setText("Reflector");
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setItems(new String[] {"UKW B", "UKW C"});
		combo.setToolTipText("Reflector");
		combo.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		combo.setBounds(27, 125, 117, 40);
		combo.select(0);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setToolTipText("Rightmost rotor");
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel.setBounds(621, 39, 96, 37);
		lblNewLabel.setText("Rotor 1");
		
		Label lblRotor = new Label(this, SWT.NONE);
		lblRotor.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRotor.setToolTipText("Middle rotor");
		lblRotor.setText("Rotor 2");
		lblRotor.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblRotor.setBounds(437, 39, 96, 37);
		
		Label lblRotor_1 = new Label(this, SWT.NONE);
		lblRotor_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRotor_1.setToolTipText("Leftmost rotor");
		lblRotor_1.setText("Rotor 3");
		lblRotor_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblRotor_1.setBounds(243, 39, 96, 37);
		
		Canvas canvas_1 = new Canvas(this, SWT.BORDER | SWT.NO_BACKGROUND);
		canvas_1.setBounds(427, 82, 117, 223);
		
		Label label_2 = new Label(canvas_1, SWT.NONE);
		label_2.setToolTipText("Middle rotor");
		label_2.setText("Ring");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(30, 134, 53, 32);
		
		Spinner XD_2 = new Spinner(canvas_1, SWT.BORDER);
		XD_2.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_2.setMaximum(26);
		XD_2.setMinimum(1);
		XD_2.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		XD_2.setBounds(10, 172, 96, 37);
		
		Spinner XD2 = new Spinner(canvas_1, SWT.BORDER);
		XD2.setBounds(10, 91, 96, 37);
		XD2.setOrientation(SWT.RIGHT_TO_LEFT);
		XD2.setMaximum(26);
		XD2.setMinimum(1);
		XD2.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		
		Label label = new Label(canvas_1, SWT.NONE);
		label.setBounds(10, 53, 96, 32);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setToolTipText("Middle rotor");
		label.setText("Position");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		
		Combo combo_2 = new Combo(canvas_1, SWT.NONE);
		combo_2.setBounds(10, 7, 96, 40);
		combo_2.setToolTipText("Middle rotor");
		combo_2.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_2.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		combo_2.select(1);
		
		Canvas canvas = new Canvas(this, SWT.BORDER | SWT.NO_BACKGROUND);
		canvas.setBounds(612, 82, 117, 223);
		
		Spinner XD_1 = new Spinner(canvas, SWT.BORDER);
		XD_1.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_1.setMaximum(26);
		XD_1.setMinimum(1);
		XD_1.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		XD_1.setBounds(10, 172, 96, 37);
		
		Label label_3 = new Label(canvas, SWT.NONE);
		label_3.setToolTipText("Rightmost rotor");
		label_3.setText("Ring");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(30, 134, 53, 32);
		
		Spinner XD1 = new Spinner(canvas, SWT.BORDER);
		XD1.setBounds(10, 91, 96, 37);
		XD1.setOrientation(SWT.RIGHT_TO_LEFT);
		XD1.setMaximum(26);
		XD1.setMinimum(1);
		XD1.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		
		Label lblPosition = new Label(canvas, SWT.NONE);
		lblPosition.setBounds(10, 53, 96, 32);
		lblPosition.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPosition.setToolTipText("Rightmost rotor");
		lblPosition.setText("Position");
		lblPosition.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		
		Combo combo_3 = new Combo(canvas, SWT.NONE);
		combo_3.setBounds(10, 7, 96, 40);
		combo_3.setToolTipText("Rightmost rotor");
		combo_3.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_3.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		combo_3.select(2);
		
		Canvas canvas_2 = new Canvas(this, SWT.BORDER | SWT.NO_BACKGROUND);
		canvas_2.setBounds(232, 82, 117, 223);
		
		Label lblRing = new Label(canvas_2, SWT.NONE);
		lblRing.setToolTipText("Leftmost rotor");
		lblRing.setText("Ring");
		lblRing.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		lblRing.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRing.setBounds(30, 137, 53, 32);
		
		Spinner XD_3 = new Spinner(canvas_2, SWT.BORDER);
		XD_3.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_3.setMaximum(26);
		XD_3.setMinimum(1);
		XD_3.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		XD_3.setBounds(10, 175, 96, 37);
		
		Spinner XD3 = new Spinner(canvas_2, SWT.BORDER);
		XD3.setBounds(10, 94, 96, 37);
		XD3.setOrientation(SWT.RIGHT_TO_LEFT);
		XD3.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		XD3.setMaximum(26);
		XD3.setMinimum(1);
		
		Label label_1 = new Label(canvas_2, SWT.NONE);
		label_1.setBounds(10, 56, 96, 32);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setToolTipText("Leftmost rotor");
		label_1.setText("Position");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		
		Combo combo_1 = new Combo(canvas_2, SWT.NONE);
		combo_1.setBounds(10, 10, 96, 40);
		combo_1.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		combo_1.setToolTipText("Leftmost rotor");
		combo_1.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_1.select(0);
		
		text = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		text.setFont(SWTResourceManager.getFont("VCR OSD Mono", 16, SWT.BOLD));
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				try {
					int q1 = 0, q2 = 0, p1 = 0, p2 = 0, p3 = 0, r1 = 0, r2 = 0, r3 = 0;
					int rotor1s = combo_3.getSelectionIndex();
					int rotor2s = combo_2.getSelectionIndex();
					int rotor3s = combo_1.getSelectionIndex();
					char[] rotor1 = new char[0], rotor2 = new char[0], rotor3 = new char[0], UKW= new char[0];
					switch(rotor1s){
					case 0 : rotor1 = Codes.rotorI; q1 = 17; break;
					case 1 : rotor1 = Codes.rotorII; q1 = 5;break;
					case 2 : rotor1 = Codes.rotorIII; q1 = 22; break;
					case 3 : rotor1 = Codes.rotorIV; q1 = 10; break;
					case 4 : rotor1 = Codes.rotorV; q1 = 0; break;
					}
					switch(rotor2s){
					case 0 : rotor2 = Codes.rotorI; q2 = 17; break;
					case 1 : rotor2 = Codes.rotorII; q2 = 5;break;
					case 2 : rotor2 = Codes.rotorIII; q2 = 22; break;
					case 3 : rotor2 = Codes.rotorIV; q2 = 10; break;
					case 4 : rotor2 = Codes.rotorV; q2 = 0; break;
					}
					switch(rotor3s){
					case 0 : rotor3 = Codes.rotorI; break;
					case 1 : rotor3 = Codes.rotorII; break;
					case 2 : rotor3 = Codes.rotorIII; break;
					case 3 : rotor3 = Codes.rotorIV; break;
					case 4 : rotor3 = Codes.rotorV; break;
					}
					switch(combo.getSelectionIndex()) {
					case 1 : UKW = Codes.UKWc; break;
					case 0 : UKW = Codes.UKWb; break;
					}
					p1  = Integer.parseInt(XD1.getText())-1;
					p2  = Integer.parseInt(XD2.getText())-1;
					p3  = Integer.parseInt(XD3.getText())-1;
					r1  = Integer.parseInt(XD_1.getText())-1;
					r2  = Integer.parseInt(XD_2.getText())-1;
					r3  = Integer.parseInt(XD_3.getText())-1;
					String a = text.getText().toUpperCase();
					text_1.setText(Codes.pB(Codes.enigma3(Codes.pB(a),UKW,rotor1,p1,r1,q1,rotor2,p2,r2,q2,rotor3,p3,r3,0)));
				}
				catch(Exception e) {
					//MessageDialog.openError(null,"اتعدل بدل ما أعدلك","اشطا؟");
				}
			}
		});
		text.setToolTipText("Input");
		text.setBounds(410, 383, 367, 255);
		
		Text[] plugBoard1 = new Text[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			plugBoard1[i] = new Text(this, SWT.CENTER);
			plugBoard1[i].setText(Codes.ETW[i]+"");
			plugBoard1[i].setBounds(100+26*i,319,20,18);
			plugBoard1[i].setEnabled(false);
			plugBoard1[i].setToolTipText("PlugBoard");
		}
		
		Text[] plugBoard2 = new Text[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			plugBoard2[i] = new Text(this,SWT.CENTER|SWT.BORDER);
			plugBoard2[i].setTextLimit(1);
			plugBoard2[i].setText(Codes.ETW[i]+"");
			plugBoard2[i].setBounds(100+26*i,349,20,18);
			plugBoard2[i].setToolTipText("PlugBoard");
		}
		
		text_1 = new Text(this, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		text_1.setFont(SWTResourceManager.getFont("VCR OSD Mono", 16, SWT.BOLD));
		text_1.setToolTipText("Output");
		text_1.setBounds(10, 383, 367, 252);
		
		Canvas canvas_3 = new Canvas(this, SWT.BORDER | SWT.NO_BACKGROUND);
		canvas_3.setBounds(27, 82, 117, 121);
		
		Button btnReset = new Button(this, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_1.setText("");
				text.setText("");
			}
		});
		btnReset.setBounds(10, 348, 46, 25);
		btnReset.setText("Empty");
		
		btnBack = new Button(this, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
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
				} catch (Exception em) {
					em.printStackTrace();
				}
			}
		});
		btnBack.setBounds(54, 228, 75, 25);
		btnBack.setText("Back");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					for(int i = 0; i<Codes.ETWN; i++) {
						Codes.plugBoard[i] = plugBoard2[i].getText().toUpperCase().charAt(0);
						int m = Codes.toVal(plugBoard2[i].getText().toUpperCase().charAt(0), Codes.ETW);
						plugBoard2[m].setText(Codes.ETW[i]+"");
					}
					}
					catch(Exception lel) {
						//MessageDialog.openError(null, "اتعدل يا عم بقا", "بليز");
					}
			}
		});
		btnNewButton.setBounds(36, 259, 108, 25);
		btnNewButton.setText("Submit PlugBoard");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Enigma 3");
		setSize(803, 690);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
