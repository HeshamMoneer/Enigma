package files;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;

public class GUI2_1 extends Shell {
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	
	Spinner XD1;
	Spinner XD2;
	Spinner XD3;
	Spinner XD4;
	Spinner XD_1;
	Spinner XD_2;
	Spinner XD_3;
	Spinner XD_4;
	Combo combo_1;
	Combo combo_2;
	Combo combo_3;
	Combo combo_4;
	Combo combo;
	
	static Label[] list0,list1,list2,list3,list4,list5,list6,list7,list8,list9,list10;
	
	static Label f1,f2,f4,f5;
	
	static int p1 = 0;
	static int p2 = 0;
	static int p3 = 0;
	static int p4 = 0;
	static int q1 = 0;
	static int q2 = 0;
	static int q3 = 0;
	static int r1 = 0;
	static int r2 = 0;
	static int r3 = 0;
	static int r4 = 0;
	static char[] rotor1 = new char[0];
	static char[] rotor2 = new char[0];
	static char[] rotor3 = new char[0];
	static char[] rotor4 = new char[0];
	static char[] UKW = new char[0];
	
	public static void move(int x, Label[] y) {
		for(int i = 0; i<y.length; i++) {
			int s = (i+x>=Codes.ETWN)?(i+x-Codes.ETWN):(i+x);
			y[i].setText(Codes.ETW[s]+"");
		}
		f1.setBounds(list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().x-20,list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().y,20,5);
		f2.setBounds(list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().x-20,list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().y,20,5);
	}
	
	void getInf() {
		
		p1 = Integer.parseInt(XD1.getText())-1;
		p2 = Integer.parseInt(XD2.getText())-1;
		p3 = Integer.parseInt(XD3.getText())-1;
		p4 = Integer.parseInt(XD4.getText())-1;
		
		r1 = Integer.parseInt(XD_1.getText())-1;
		r2 = Integer.parseInt(XD_2.getText())-1;
		r3 = Integer.parseInt(XD_3.getText())-1;
		r4 = Integer.parseInt(XD_4.getText())-1;
		
		int rotor1s = combo_3.getSelectionIndex();
		int rotor2s = combo_2.getSelectionIndex();
		int rotor3s = combo_1.getSelectionIndex();
		int rotor4s = combo_4.getSelectionIndex();
		
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
		case 0 : rotor3 = Codes.rotorI; q3 = 17;break;
		case 1 : rotor3 = Codes.rotorII; q3 = 5;break;
		case 2 : rotor3 = Codes.rotorIII; q3 = 22;break;
		case 3 : rotor3 = Codes.rotorIV; q3 = 10;break;
		case 4 : rotor3 = Codes.rotorV; q3 = 0;break;
		}
		switch(rotor4s) {
		case 0 : rotor4 = Codes.Beta;break;
		case 1 : rotor4 = Codes.Gamma;break;
		}
		switch(combo.getSelectionIndex()) {
		case 1 : UKW = Codes.UKWct; break;
		case 0 : UKW = Codes.UKWbt; break;
		}
	}
	void stepping() {
			try {
				String soundName = "./src/images/snd.wav";    
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			}
			catch(Exception e) {
				
			}
		
			p1 = (p1==Codes.ETWN-1)?(0):(p1+1);
			int m = (q2-1<0)?(q2-1+Codes.ETWN):(q2-1);
			if (p1==q1||p2==m) {
				p2 = (p2==Codes.ETWN-1)?(0):(p2+1);
				p3 = (p2==q2)?((p3==Codes.ETWN-1)?(0):(p3+1)):(p3);
			}
			XD1.setSelection(p1+1);
			XD2.setSelection(p2+1);
			XD3.setSelection(p3+1);
	}
	
	static Label lblVVV,lblLL,lblline1,lblline2,lblline3,lblline4,lblline5,lblline6,lblline7,lblline8,lblline9,lblline10,lblline11,lblline12;
	
	static Canvas canvas,canvas_1,canvas_2,canvas_3,canvas_5;
	
	static void doit() {
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setBackground(new Color(null, 250, 250, 250));
				g.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
				g.gc.setForeground(new Color(null,255,0,0));
				g.gc.drawLine(0, lblline2.getLocation().y-2, canvas.getBounds().width-2, lblline1.getLocation().y-2);
				g.gc.setForeground(new Color(null,0,255,0));
				g.gc.drawLine(0, lblline9.getLocation().y-2, canvas.getBounds().width-2, lblline10.getLocation().y-2);
			}
			
		});
		canvas.redraw();
		
		canvas_1.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setBackground(new Color(null, 250, 250, 250));
				g.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
				g.gc.setForeground(new Color(null,255,0,0));
				g.gc.drawLine(0, lblline3.getLocation().y-2, canvas.getBounds().width-2, lblline2.getLocation().y-2);
				g.gc.setForeground(new Color(null,0,255,0));
				g.gc.drawLine(0, lblline8.getLocation().y-2, canvas.getBounds().width-2, lblline9.getLocation().y-2);
			}
			
		});
		canvas_1.redraw();
		
		canvas_2.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setBackground(new Color(null, 250, 250, 250));
				g.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
				g.gc.setForeground(new Color(null,255,0,0));
				g.gc.drawLine(0, lblline4.getLocation().y-2, canvas.getBounds().width-2, lblline3.getLocation().y-2);
				g.gc.setForeground(new Color(null,0,255,0));
				g.gc.drawLine(0, lblline7.getLocation().y-2, canvas.getBounds().width-2, lblline8.getLocation().y-2);
			}
			
		});
		canvas_2.redraw();
		
		canvas_5.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setBackground(new Color(null, 250, 250, 250));
				g.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
				g.gc.setForeground(new Color(null,255,0,0));
				g.gc.drawLine(0, lblline5.getLocation().y-2, canvas.getBounds().width-2, lblline4.getLocation().y-2);
				g.gc.setForeground(new Color(null,0,255,0));
				g.gc.drawLine(0, lblline6.getLocation().y-2, canvas.getBounds().width-2, lblline7.getLocation().y-2);
			}
			
		});
		canvas_5.redraw();
		
		canvas_3.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setBackground(new Color(null, 250, 250, 250));
				g.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
				g.gc.setForeground(new Color(null,255,230,0));
				int[] mxc = {190,Math.min(lblline6.getLocation().y, lblline5.getLocation().y)-2,50,Math.min(lblline6.getLocation().y, lblline5.getLocation().y)-2,50,Math.max(lblline6.getLocation().y, lblline5.getLocation().y)-2,190,Math.max(lblline6.getLocation().y, lblline5.getLocation().y)-2};
				g.gc.drawPolygon(mxc);
			}
			
		});
		canvas_3.redraw();
	}

	private Label lblRotor_2;
	private Label label_4;
	private Label label_5;
	private Button btnBack;
	
	static Canvas canvas_4;
	static boolean click = false;
	static Label temporary;
	static Label label_9,label_8,label_10,label_7;
	
	public GUI2_1(Display display) {
		super(display, SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL | SWT.MIN);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setImage(SWTResourceManager.getImage(GUI.class, "/images/ENG.png"));
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('Q'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button.setText("&Q");
		button.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button.setBounds(681, 470, 34, 35);
		
		canvas_1 = new Canvas(this, SWT.BORDER);
		canvas_1.setBackground(new Color(null,250,250,250));
		canvas_1.setBounds(602, 0, 117, 338);
		
		Label label_2 = new Label(canvas_1, SWT.NONE);
		label_2.setToolTipText("Middle rotor");
		label_2.setText("Ring");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_2.setBackground(SWTResourceManager.getColor(250,250,250));
		label_2.setBounds(77, 284, 26, 17);
		
		XD_2 = new Spinner(canvas_1, SWT.BORDER);
		XD_2.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_2.setMaximum(26);
		XD_2.setMinimum(1);
		XD_2.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD_2.setBounds(56, 302, 57, 32);
		
		XD2 = new Spinner(canvas_1, SWT.BORDER);
		XD2.setBounds(0, 302, 56, 32);
		XD2.setOrientation(SWT.RIGHT_TO_LEFT);
		XD2.setMaximum(26);
		XD2.setMinimum(1);
		XD2.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				move(XD2.getSelection()-1,list4);
				move(XD2.getSelection()-1,list5);
				p2 = Integer.parseInt(XD2.getText())-1;
				f2.setBounds(list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().x-20,list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().y,20,5);
			}
		});
		XD2.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		
		Label label = new Label(canvas_1, SWT.NONE);
		label.setBounds(0, 284, 46, 17);
		label.setBackground(SWTResourceManager.getColor(250,250,250));
		label.setToolTipText("Middle rotor");
		label.setText("Position");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		combo_2 = new Combo(canvas_1, SWT.NONE);
		combo_2.setBounds(56, 0, 57, 29);
		combo_2.setToolTipText("Middle rotor");
		combo_2.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_2.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		combo_2.select(1);
		combo_2.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				int rotor2s = combo_2.getSelectionIndex();
				switch(rotor2s){
				case 0 : rotor2 = Codes.rotorI; q2 = 17; break;
				case 1 : rotor2 = Codes.rotorII; q2 = 5;break;
				case 2 : rotor2 = Codes.rotorIII; q2 = 22; break;
				case 3 : rotor2 = Codes.rotorIV; q2 = 10; break;
				case 4 : rotor2 = Codes.rotorV; q2 = 0; break;
				}
				f2.setBounds(list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().x-20,list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().y,20,5);
			}
		});
		
		Label lblRotor = new Label(canvas_1, SWT.NONE);
		lblRotor.setBounds(0, 0, 53, 28);
		lblRotor.setBackground(SWTResourceManager.getColor(250,250,250));
		lblRotor.setToolTipText("Middle rotor");
		lblRotor.setText("Rotor");
		lblRotor.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		
		canvas_2 = new Canvas(this, SWT.BORDER);
		canvas_2.setBackground(new Color(null,250,250,250));
		canvas_2.setBounds(398, 0, 117, 338);
		
		Label lblRing = new Label(canvas_2, SWT.NONE);
		lblRing.setToolTipText("Leftmost rotor");
		lblRing.setText("Ring");
		lblRing.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblRing.setBackground(SWTResourceManager.getColor(250,250,250));
		lblRing.setBounds(77, 284, 26, 17);
		
		XD_3 = new Spinner(canvas_2, SWT.BORDER);
		XD_3.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_3.setMaximum(26);
		XD_3.setMinimum(1);
		XD_3.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD_3.setBounds(56, 302, 57, 32);
		
		XD3 = new Spinner(canvas_2, SWT.BORDER);
		XD3.setBounds(0, 302, 56, 32);
		XD3.setOrientation(SWT.RIGHT_TO_LEFT);
		XD3.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD3.setMaximum(26);
		XD3.setMinimum(1);
		XD3.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				move(XD3.getSelection()-1,list6);
				move(XD3.getSelection()-1,list7);
			}
		});
		
		Label label_1 = new Label(canvas_2, SWT.NONE);
		label_1.setBounds(0, 284, 46, 17);
		label_1.setBackground(SWTResourceManager.getColor(250,250,250));
		label_1.setToolTipText("Leftmost rotor");
		label_1.setText("Position");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		combo_1 = new Combo(canvas_2, SWT.NONE);
		combo_1.setBounds(56, 0, 57, 29);
		combo_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		combo_1.setToolTipText("Leftmost rotor");
		combo_1.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_1.select(0);
		
		Label lblRotor_1 = new Label(canvas_2, SWT.NONE);
		lblRotor_1.setBounds(0, 0, 57, 28);
		lblRotor_1.setBackground(SWTResourceManager.getColor(250,250,250));
		lblRotor_1.setToolTipText("Leftmost rotor");
		lblRotor_1.setText("Rotor");
		lblRotor_1.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		
		text_1 = new Text(this, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		text_1.setFont(SWTResourceManager.getFont("VCR OSD Mono", 16, SWT.BOLD));
		text_1.setToolTipText("Output");
		text_1.setBounds(10, 429, 617, 252);
		
		canvas_3 = new Canvas(this, SWT.BORDER);
		canvas_3.setBackground(new Color(null,250,250,250));
		canvas_3.setBounds(10, 0, 117, 338);
		
		combo = new Combo(canvas_3, SWT.NONE);
		combo.setBounds(-2, 306, 117, 28);
		combo.setItems(new String[] {"UKW B thin", "UKW C thin"});
		combo.setToolTipText("Reflector");
		combo.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		combo.select(0);
		
		Label lblReflector = new Label(canvas_3, SWT.NONE);
		lblReflector.setBounds(10, 0, 88, 28);
		lblReflector.setBackground(SWTResourceManager.getColor(250,250,250));
		lblReflector.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblReflector.setText("Reflector");
		
		Button btnReset = new Button(this, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_1.setText("");
			}
		});
		btnReset.setBounds(10, 394, 46, 25);
		btnReset.setText("Empty");
		
		canvas_5 = new Canvas(this, SWT.BORDER);
		canvas_5.setBackground(new Color(null,250,250,250));
		canvas_5.setBounds(206, 0, 117, 338);
		
		label_4 = new Label(canvas_5, SWT.NONE);
		label_4.setToolTipText("Greek rotor");
		label_4.setText("Ring");
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_4.setBackground(SWTResourceManager.getColor(250,250,250));
		label_4.setBounds(77, 284, 26, 17);
		
		XD_4 = new Spinner(canvas_5, SWT.BORDER);
		XD_4.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_4.setMaximum(26);
		XD_4.setMinimum(1);
		XD_4.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD_4.setBounds(56, 302, 57, 32);
		
		XD4 = new Spinner(canvas_5, SWT.BORDER);
		XD4.setOrientation(SWT.RIGHT_TO_LEFT);
		XD4.setMaximum(26);
		XD4.setMinimum(1);
		XD4.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				move(XD4.getSelection()-1,list8);
				move(XD4.getSelection()-1,list9);
			}
		});
		XD4.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD4.setBounds(0, 302, 56, 32);
		
		label_5 = new Label(canvas_5, SWT.NONE);
		label_5.setToolTipText("Greek rotor");
		label_5.setText("Position");
		label_5.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_5.setBackground(SWTResourceManager.getColor(250,250,250));
		label_5.setBounds(0, 284, 46, 17);
		
		combo_4 = new Combo(canvas_5, SWT.NONE);
		combo_4.setToolTipText("Greek rotor");
		combo_4.setItems(new String[] {"Beta", "Gamma"});
		combo_4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		combo_4.setBounds(55, 3, 58, 29);
		combo_4.select(0);
		
		lblRotor_2 = new Label(canvas_5, SWT.NONE);
		lblRotor_2.setBounds(0, 0, 53, 25);
		lblRotor_2.setToolTipText("Greek rotor");
		lblRotor_2.setText("Rotor");
		lblRotor_2.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblRotor_2.setBackground(SWTResourceManager.getColor(250,250,250));
		
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
					em	.printStackTrace();
				}
			}
		});
		btnBack.setBounds(10, 363, 75, 25);
		btnBack.setText("Back");
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('W'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_1.setText("&W");
		button_1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_1.setBounds(721, 470, 34, 35);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('E'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_2.setText("&E");
		button_2.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_2.setBounds(761, 470, 34, 35);
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('R'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_3.setText("&R");
		button_3.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_3.setBounds(801, 470, 34, 35);
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('T'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_4.setText("&T");
		button_4.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_4.setBounds(841, 470, 34, 35);
		
		Button button_5 = new Button(this, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('Z'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_5.setText("&Z");
		button_5.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_5.setBounds(881, 470, 34, 35);
		
		Button button_6 = new Button(this, SWT.NONE);
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('U'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_6.setText("&U");
		button_6.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_6.setBounds(921, 470, 34, 35);
		
		Button button_7 = new Button(this, SWT.NONE);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('I'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_7.setText("&I");
		button_7.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_7.setBounds(961, 470, 34, 35);
		
		Button button_8 = new Button(this, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('O'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_8.setText("&O");
		button_8.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_8.setBounds(1001, 470, 34, 35);
		
		Button button_9 = new Button(this, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('A'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_9.setText("&A");
		button_9.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_9.setBounds(701, 511, 34, 35);
		
		Button button_10 = new Button(this, SWT.NONE);
		button_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('S'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_10.setText("&S");
		button_10.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_10.setBounds(741, 511, 34, 35);
		
		Button button_11 = new Button(this, SWT.NONE);
		button_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('D'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_11.setText("&D");
		button_11.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_11.setBounds(781, 511, 34, 35);
		
		Button button_12 = new Button(this, SWT.NONE);
		button_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('F'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_12.setText("&F");
		button_12.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_12.setBounds(821, 511, 34, 35);
		
		Button button_13 = new Button(this, SWT.NONE);
		button_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('G'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_13.setText("&G");
		button_13.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_13.setBounds(861, 511, 34, 35);
		
		Button button_14 = new Button(this, SWT.NONE);
		button_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('H'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_14.setText("&H");
		button_14.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_14.setBounds(901, 511, 34, 35);
		
		Button button_15 = new Button(this, SWT.NONE);
		button_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('J'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_15.setText("&J");
		button_15.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_15.setBounds(941, 511, 34, 35);
		
		Button button_16 = new Button(this, SWT.NONE);
		button_16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('K'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_16.setText("&K");
		button_16.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_16.setBounds(981, 511, 34, 35);
		
		Button button_17 = new Button(this, SWT.NONE);
		button_17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('P'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_17.setText("&P");
		button_17.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_17.setBounds(681, 552, 34, 35);
		
		Button button_18 = new Button(this, SWT.NONE);
		button_18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('Y'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_18.setText("&Y");
		button_18.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_18.setBounds(721, 552, 34, 35);
		
		Button button_19 = new Button(this, SWT.NONE);
		button_19.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('X'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_19.setText("&X");
		button_19.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_19.setBounds(761, 552, 34, 35);
		
		Button button_20 = new Button(this, SWT.NONE);
		button_20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('C'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_20.setText("&C");
		button_20.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_20.setBounds(801, 552, 34, 35);
		
		Button button_21 = new Button(this, SWT.NONE);
		button_21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('V'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_21.setText("&V");
		button_21.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_21.setBounds(841, 552, 34, 35);
		
		Button button_22 = new Button(this, SWT.NONE);
		button_22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('B'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_22.setText("&B");
		button_22.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_22.setBounds(881, 552, 34, 35);
		
		Button button_23 = new Button(this, SWT.NONE);
		button_23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('N'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_23.setText("&N");
		button_23.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_23.setBounds(921, 552, 34, 35);
		
		Button button_24 = new Button(this, SWT.NONE);
		button_24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('M'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_24.setText("&M");
		button_24.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_24.setBounds(961, 552, 34, 35);
		
		Button button_25 = new Button(this, SWT.NONE);
		button_25.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma4(Codes.pB('L'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3,rotor4,p4,r4)));
				doit();
			}
		});
		button_25.setText("&L");
		button_25.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_25.setBounds(1001, 552, 34, 35);
		
		Button button_26 = new Button(this, SWT.NONE);
		button_26.setText("Space");
		button_26.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		button_26.setBounds(761, 593, 174, 37);
		
		Label label_6 = new Label(this, SWT.HORIZONTAL);
		label_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_6.setBounds(681, 462, 353, 4);
		
		canvas = new Canvas(this, SWT.BORDER);
		canvas.setBackground(new Color(null,250,250,250));
		canvas.setBounds(807, 0, 117, 338);
		
		combo_3 = new Combo(canvas, SWT.NONE);
		combo_3.setBounds(56, 0, 57, 29);
		combo_3.setToolTipText("Rightmost rotor");
		combo_3.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_3.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		combo_3.select(2);
		
		XD_1 = new Spinner(canvas, SWT.BORDER);
		XD_1.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_1.setMaximum(26);
		XD_1.setMinimum(1);
		XD_1.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD_1.setBounds(56, 302, 57, 32);
		
		Label label_3 = new Label(canvas, SWT.NONE);
		label_3.setToolTipText("Rightmost rotor");
		label_3.setText("Ring");
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_3.setBackground(SWTResourceManager.getColor(250,250,250));
		label_3.setBounds(77, 284, 26, 17);
		
		XD1 = new Spinner(canvas, SWT.BORDER);
		XD1.setBounds(0, 302, 56, 32);
		XD1.setOrientation(SWT.RIGHT_TO_LEFT);
		XD1.setMaximum(26);
		XD1.setMinimum(1);
		XD1.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				move(XD1.getSelection()-1,list2);
				move(XD1.getSelection()-1,list3);
				p1 = Integer.parseInt(XD1.getText())-1;
				f1.setBounds(list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().x-20,list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().y,20,5);
			}
		});
		XD1.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		
		Label lblPosition = new Label(canvas, SWT.NONE);
		lblPosition.setBounds(0, 284, 51, 17);
		lblPosition.setBackground(SWTResourceManager.getColor(250,250,250));
		lblPosition.setToolTipText("Rightmost rotor");
		lblPosition.setText("Position");
		lblPosition.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		Label lblNewLabel = new Label(canvas, SWT.NONE);
		lblNewLabel.setBounds(0, 0, 57, 28);
		lblNewLabel.setBackground(SWTResourceManager.getColor(250,250,250));
		lblNewLabel.setToolTipText("Rightmost rotor");
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblNewLabel.setText("Rotor");
		
		canvas_4 = new Canvas(this,SWT.BORDER|SWT.NO_BACKGROUND);
		canvas_4.setBounds(960,30,85,267);
		
		list0 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list0[i] = new Label(canvas_4, SWT.NONE);
			list0[i].setText(""+Codes.ETW[i]);
			list0[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list0[i].setBounds(70,1+10*i,10,10);
			list0[i].setAlignment(SWT.CENTER);
		}
		
		list1 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list1[i] = new Label(canvas_4, SWT.NONE);
			list1[i].setText(""+Codes.ETW[i]);
			list1[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list1[i].setBounds(1,1+10*i,10,10);
			list1[i].setAlignment(SWT.CENTER);
			list1[i].addMouseListener(new MouseListener(){
				public void mouseDoubleClick(MouseEvent arg0){}
				public void mouseUp(MouseEvent arg0){}
				public void mouseDown(MouseEvent e){
					Label x = (Label) e.getSource();
					char c = Codes.plugBoard[indexOf(x,list1)];
					if(c != x.getText().charAt(0)) {
						Codes.plugBoard[Codes.toVal(c, Codes.ETW)] = c;
						Codes.plugBoard[indexOf(x,list1)]=x.getText().charAt(0);
					}
					else {
						if(click) {
							temporary.setBackground(new Color(null,240,240,240));
							Codes.plugBoard[indexOf(x,list1)] = temporary.getText().charAt(0);
							Codes.plugBoard[indexOf(temporary,list1)] = x.getText().charAt(0);
							click = false;
						}
						else {
							x.setBackground(new Color(null,100,100,255));
							temporary = x;
							click = true;
						}
					}
					draw();
					canvas_4.redraw();
				}
				private int indexOf(Label x, Label[] l1) {
					for(int i =0; i<l1.length;i++) {
						if(x==l1[i])
							return i;
					}
					return -1;
				}
			});
		}
		
		draw();
		canvas_4.redraw();
		
		list2 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list2[i] = new Label(this, SWT.NONE);
			list2[i].setText(""+Codes.ETW[i]);
			list2[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list2[i].setBounds(935,31+10*i,10,10);
			list2[i].setAlignment(SWT.CENTER);
		}
		
		list3 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list3[i] = new Label(this, SWT.NONE);
			list3[i].setText(""+Codes.ETW[i]);
			list3[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list3[i].setBounds(785,31+10*i,10,10);
			list3[i].setAlignment(SWT.CENTER);
		}
		
		list4 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list4[i] = new Label(this, SWT.NONE);
			list4[i].setText(""+Codes.ETW[i]);
			list4[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list4[i].setBounds(730,31+10*i,10,10);
			list4[i].setAlignment(SWT.CENTER);
		}
		
		list5 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list5[i] = new Label(this, SWT.NONE);
			list5[i].setText(""+Codes.ETW[i]);
			list5[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list5[i].setBounds(580,31+10*i,10,10);
			list5[i].setAlignment(SWT.CENTER);
		}
		
		list6 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list6[i] = new Label(this, SWT.NONE);
			list6[i].setText(""+Codes.ETW[i]);
			list6[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list6[i].setBounds(525,31+10*i,10,10);
			list6[i].setAlignment(SWT.CENTER);
		}
		
		list7 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list7[i] = new Label(this, SWT.NONE);
			list7[i].setText(""+Codes.ETW[i]);
			list7[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list7[i].setBounds(380,31+10*i,10,10);
			list7[i].setAlignment(SWT.CENTER);
		}
		
		list8 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list8[i] = new Label(this, SWT.NONE);
			list8[i].setText(""+Codes.ETW[i]);
			list8[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list8[i].setBounds(330,31+10*i,10,10);
			list8[i].setAlignment(SWT.CENTER);
		}
		
		list9 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list9[i] = new Label(this, SWT.NONE);
			list9[i].setText(""+Codes.ETW[i]);
			list9[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list9[i].setBounds(190,31+10*i,10,10);
			list9[i].setAlignment(SWT.CENTER);
		}
		
		list10 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list10[i] = new Label(this, SWT.NONE);
			list10[i].setText(""+Codes.ETW[i]);
			list10[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list10[i].setBounds(140,31+10*i,10,10);
			list10[i].setAlignment(SWT.CENTER);
		}
		
		lblLL = new Label(this, SWT.NONE);
		lblLL.setAlignment(SWT.CENTER);
		lblLL.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblLL.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblLL.setText("\r\n↑ \r\n↑ \r\n↑ \r\n↑\r\n");
		lblLL.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline1 = new Label(this, SWT.NONE);
		lblline1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline2 = new Label(this, SWT.NONE);
		lblline2.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline3 = new Label(this, SWT.NONE);
		lblline3.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline4 = new Label(this, SWT.NONE);
		lblline4.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline5 = new Label(this, SWT.NONE);
		lblline5.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline6 = new Label(this, SWT.NONE);
		lblline6.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline7 = new Label(this, SWT.NONE);
		lblline7.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline8 = new Label(this, SWT.NONE);
		lblline8.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline9 = new Label(this, SWT.NONE);
		lblline9.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline10 = new Label(this, SWT.NONE);
		lblline10.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline11 = new Label(this, SWT.NONE);
		lblline11.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline12 = new Label(this, SWT.NONE);
		lblline12.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblVVV = new Label(this, SWT.NONE);
		lblVVV.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblVVV.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblVVV.setAlignment(SWT.CENTER);
		lblVVV.setText("\r\n↓\r\n\r\n↓\r\n\r\n↓\r\n");
		lblVVV.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		label_7 = new Label(this, SWT.NONE);
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		label_8 = new Label(this, SWT.NONE);
		label_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		getInf();
		f1 = new Label(this,SWT.NONE);
		f1.setBackground(new Color(null, 0,0,0));
		f1.setBounds(list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().x-20,list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().y,20,5);
		f2 = new Label(this,SWT.NONE);
		f2.setBackground(new Color(null, 0,0,0));
		f2.setBounds(list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().x-20,list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().y,20,5);
		f4 = new Label(this,SWT.NONE);
		f4.setBackground(new Color(null, 0,0,0));
		f4.setBounds(740, 31, 25, 5);
		f5 = new Label(this,SWT.NONE);
		f5.setBackground(new Color(null, 0,0,0));
		f5.setBounds(535, 31, 25, 5);
		
		label_9 = new Label(this, SWT.NONE);
		label_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		label_10 = new Label(this, SWT.NONE);
		label_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		createContents();
	}
	
	public static void draw() {
		canvas_4.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setBackground(new Color(null,255,255,255));
				g.gc.fillRectangle(0, 0, canvas_4.getBounds().width, canvas_4.getBounds().height);
				for(int i = 0; i<Codes.ETWN; i++) {
					for(int j = 0; j<Codes.ETWN; j++) {
						if(list0[i].getText().charAt(0)==Codes.plugBoard[j]) {
							connect(list0[i],list1[j]);
							break;
						}
					}
				}
			}});
	}

	public static void connect(Label l1, Label l2) {
		canvas_4.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setForeground(new Color(null,0,0,255));
				g.gc.drawLine(l1.getLocation().x, l1.getLocation().y+5, l2.getLocation().x+10, l2.getLocation().y+5);
			}
		});
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Enigma 4");
		setSize(1132, 724);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
