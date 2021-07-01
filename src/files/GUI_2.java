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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.ModifyEvent;

public class GUI_2 extends Shell {
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public static void move(int x, Label[] y) {
		for(int i = 0; i<y.length; i++) {
			int s = (i+x>=Codes.ETWN)?(i+x-Codes.ETWN):(i+x);
			y[i].setText(Codes.ETW[s]+"");
		}
		f1.setBounds(list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().x-20,list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().y,20,5);
		f2.setBounds(list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().x-20,list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().y,20,5);
	}
	
	static Label lblVVV,lblLL,lblline1,lblline2,lblline3,lblline4,lblline5,lblline6,lblline7,lblline8,lblline9,lblline10;
	
	static Canvas canvas,canvas_1,canvas_2,canvas_3;

	private Button btnBack;
	static Spinner XD1;
	static Spinner XD2;
	static Spinner XD3;
	static Spinner XD_1;
	static Spinner XD_2;
	static Spinner XD_3;
	static Combo combo_1;
	static Combo combo_2;
	static Combo combo_3;
	static Combo combo;
	
	static Label f1,f2,f4,f5;
	
	static Label[] list0,list1,list2,list3,list4,list5,list6,list7,list8;
	
	static int p1 = 0;
	static int p2 = 0;
	static int p3 = 0;
	static int q1 = 0;
	static int q2 = 0;
	static int q3 = 0;
	static int r1 = 0;
	static int r2 = 0;
	static int r3 = 0;
	static char[] rotor1 = new char[0];
	static char[] rotor2 = new char[0];
	static char[] rotor3 = new char[0];
	static char[] UKW = new char[0];
	static void getInf() {
		
		p1 = Integer.parseInt(XD1.getText())-1;
		p2 = Integer.parseInt(XD2.getText())-1;
		p3 = Integer.parseInt(XD3.getText())-1;
		
		r1 = Integer.parseInt(XD_1.getText())-1;
		r2 = Integer.parseInt(XD_2.getText())-1;
		r3 = Integer.parseInt(XD_3.getText())-1;
		
		int rotor1s = combo_3.getSelectionIndex();
		int rotor2s = combo_2.getSelectionIndex();
		int rotor3s = combo_1.getSelectionIndex();
		
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
	
	static Label label_14,label_4,label_5,label_12;
	static Canvas canvas_4;
	static boolean click = false;
	static Label temporary;
	
	public GUI_2(Display display) {
		super(display, SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL | SWT.MIN);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setImage(SWTResourceManager.getImage(GUI.class, "/images/ENG.png"));
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('Q'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnNewButton_1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnNewButton_1.setBounds(417, 452, 34, 35);
		btnNewButton_1.setText("&Q");
		
		Button btnW = new Button(this, SWT.NONE);
		btnW.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('W'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnW.setText("&W");
		btnW.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnW.setBounds(457, 452, 34, 35);
		
		Button btnE = new Button(this, SWT.NONE);
		btnE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('E'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnE.setText("&E");
		btnE.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnE.setBounds(497, 452, 34, 35);
		
		Button btnR = new Button(this, SWT.NONE);
		btnR.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('R'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnR.setText("&R");
		btnR.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnR.setBounds(537, 452, 34, 35);
		
		Button btnT = new Button(this, SWT.NONE);
		btnT.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('T'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnT.setText("&T");
		btnT.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnT.setBounds(577, 452, 34, 35);
		
		Button btnZ = new Button(this, SWT.NONE);
		btnZ.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('Z'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnZ.setText("&Z");
		btnZ.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnZ.setBounds(617, 452, 34, 35);
		
		Button btnU = new Button(this, SWT.NONE);
		btnU.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('U'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnU.setText("&U");
		btnU.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnU.setBounds(657, 452, 34, 35);
		
		Button btnI = new Button(this, SWT.NONE);
		btnI.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('I'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnI.setText("&I");
		btnI.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnI.setBounds(697, 452, 34, 35);
		
		Button btnO = new Button(this, SWT.NONE);
		btnO.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('O'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnO.setText("&O");
		btnO.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnO.setBounds(737, 452, 34, 35);
		
		Button btnA = new Button(this, SWT.NONE);
		btnA.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('A'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnA.setText("&A");
		btnA.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnA.setBounds(437, 493, 34, 35);
		
		Button btnS = new Button(this, SWT.NONE);
		btnS.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('S'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnS.setText("&S");
		btnS.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnS.setBounds(477, 493, 34, 35);
		
		Button btnD = new Button(this, SWT.NONE);
		btnD.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('D'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnD.setText("&D");
		btnD.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnD.setBounds(517, 493, 34, 35);
		
		Button btnF = new Button(this, SWT.NONE);
		btnF.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('F'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnF.setText("&F");
		btnF.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnF.setBounds(557, 493, 34, 35);
		
		Button btnG = new Button(this, SWT.NONE);
		btnG.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('G'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnG.setText("&G");
		btnG.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnG.setBounds(597, 493, 34, 35);
		
		Button btnH = new Button(this, SWT.NONE);
		btnH.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('H'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnH.setText("&H");
		btnH.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnH.setBounds(637, 493, 34, 35);
		
		Button btnJ = new Button(this, SWT.NONE);
		btnJ.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('J'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnJ.setText("&J");
		btnJ.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnJ.setBounds(677, 493, 34, 35);
		
		Button btnK = new Button(this, SWT.NONE);
		btnK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('K'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnK.setText("&K");
		btnK.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnK.setBounds(717, 493, 34, 35);
		
		Button btnP = new Button(this, SWT.NONE);
		btnP.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('P'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnP.setText("&P");
		btnP.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnP.setBounds(417, 534, 34, 35);
		
		Button btnY = new Button(this, SWT.NONE);
		btnY.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('Y'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnY.setText("&Y");
		btnY.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnY.setBounds(457, 534, 34, 35);
		
		Button btnX = new Button(this, SWT.NONE);
		btnX.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('X'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnX.setText("&X");
		btnX.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnX.setBounds(497, 534, 34, 35);
		
		Button btnC = new Button(this, SWT.NONE);
		btnC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('C'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnC.setText("&C");
		btnC.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnC.setBounds(537, 534, 34, 35);
		
		Button btnV = new Button(this, SWT.NONE);
		btnV.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('V'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnV.setText("&V");
		btnV.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnV.setBounds(577, 534, 34, 35);
		
		Button btnB = new Button(this, SWT.NONE);
		btnB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('B'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnB.setText("&B");
		btnB.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnB.setBounds(617, 534, 34, 35);
		
		Button btnN = new Button(this, SWT.NONE);
		btnN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('N'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnN.setText("&N");
		btnN.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnN.setBounds(657, 534, 34, 35);
		
		Button btnM = new Button(this, SWT.NONE);
		btnM.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('M'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnM.setText("&M");
		btnM.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnM.setBounds(697, 534, 34, 35);
		
		Button btnL = new Button(this, SWT.NONE);
		btnL.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma32(Codes.pB('L'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
				doit();
			}
		});
		btnL.setText("&L");
		btnL.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnL.setBounds(737, 534, 34, 35);
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnNewButton_2.setBounds(497, 575, 174, 37);
		btnNewButton_2.setText("Space");
		
		canvas_1 = new Canvas(this, SWT.BORDER);
		canvas_1.setBackground(new Color(null, 250, 250, 250));
		canvas_1.setBounds(394, 0, 117, 338);
		
		Label label_2 = new Label(canvas_1, SWT.NONE);
		label_2.setToolTipText("Middle rotor");
		label_2.setText("Ring");
		label_2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		label_2.setBackground(SWTResourceManager.getColor(250,250,250));
		label_2.setBounds(73, 283, 32, 17);
		
		XD_2 = new Spinner(canvas_1, SWT.BORDER);
		XD_2.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_2.setMaximum(26);
		XD_2.setMinimum(1);
		XD_2.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD_2.setBounds(56, 302, 57, 32);
		
		Label label = new Label(canvas_1, SWT.NONE);
		label.setBounds(0, 283, 57, 17);
		label.setBackground(SWTResourceManager.getColor(250,250,250));
		label.setToolTipText("Middle rotor");
		label.setText("Position");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		combo_2 = new Combo(canvas_1, SWT.NONE);
		combo_2.setBounds(56, 0, 57, 33);
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
		
		canvas = new Canvas(this, SWT.BORDER);
		canvas.setBackground(new Color(null, 250, 250, 250));
		canvas.setBounds(577, 0, 117, 338);
		
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
		label_3.setBounds(73, 283, 30, 17);
		
		Label lblPosition = new Label(canvas, SWT.NONE);
		lblPosition.setBounds(0, 283, 57, 17);
		lblPosition.setBackground(SWTResourceManager.getColor(250,250,250));
		lblPosition.setToolTipText("Rightmost rotor");
		lblPosition.setText("Position");
		lblPosition.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		combo_3 = new Combo(canvas, SWT.NONE);
		combo_3.setBounds(56, 0, 57, 32);
		combo_3.setToolTipText("Rightmost rotor");
		combo_3.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_3.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		combo_3.select(2);
		combo_3.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				int rotor1s = combo_3.getSelectionIndex();
				switch(rotor1s){
				case 0 : rotor1 = Codes.rotorI; q1 = 17; break;
				case 1 : rotor1 = Codes.rotorII; q1 = 5;break;
				case 2 : rotor1 = Codes.rotorIII; q1 = 22; break;
				case 3 : rotor1 = Codes.rotorIV; q1 = 10; break;
				case 4 : rotor1 = Codes.rotorV; q1 = 0; break;
				}
				f1.setBounds(list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().x-20,list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().y,20,5);
			}
		});
		
		canvas_2 = new Canvas(this, SWT.BORDER);
		canvas_2.setBackground(SWTResourceManager.getColor(250,250,250));
		canvas_2.setBounds(210, 0, 117, 338);
		
		Label lblRing = new Label(canvas_2, SWT.NONE);
		lblRing.setToolTipText("Leftmost rotor");
		lblRing.setText("Ring");
		lblRing.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblRing.setBackground(SWTResourceManager.getColor(250,250,250));
		lblRing.setBounds(68, 284, 32, 17);
		
		XD_3 = new Spinner(canvas_2, SWT.BORDER);
		XD_3.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_3.setMaximum(26);
		XD_3.setMinimum(1);
		XD_3.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD_3.setBounds(57, 302, 56, 32);
		
		Label label_1 = new Label(canvas_2, SWT.NONE);
		label_1.setBounds(0, 284, 56, 17);
		label_1.setBackground(SWTResourceManager.getColor(250,250,250));
		label_1.setToolTipText("Leftmost rotor");
		label_1.setText("Position");
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		
		combo_1 = new Combo(canvas_2, SWT.NONE);
		combo_1.setBounds(56, 0, 57, 33);
		combo_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		combo_1.setToolTipText("Leftmost rotor");
		combo_1.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_1.select(0);
		
		text_1 = new Text(this, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		text_1.setFont(SWTResourceManager.getFont("VCR OSD Mono", 16, SWT.BOLD));
		text_1.setToolTipText("Output");
		text_1.setBounds(10, 424, 367, 252);
		
		canvas_3 = new Canvas(this, SWT.BORDER);
		canvas_3.setBackground(SWTResourceManager.getColor(250,250,250));
		canvas_3.setBounds(27, 0, 117, 338);
		
		combo = new Combo(canvas_3, SWT.NONE);
		combo.setBounds(0, 301, 112, 40);
		combo.setItems(new String[] {"UKW B", "UKW C"});
		combo.setToolTipText("Reflector");
		combo.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		combo.select(0);
		
		Label lblReflector = new Label(canvas_3, SWT.NONE);
		lblReflector.setBounds(10, 0, 88, 30);
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
		btnReset.setBounds(10, 389, 46, 25);
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
		btnBack.setBounds(10, 358, 75, 25);
		btnBack.setText("Back");
		
		Label label_7 = new Label(this, SWT.HORIZONTAL);
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_7.setBounds(417, 444, 353, 4);
		
		lblLL = new Label(this, SWT.NONE);
		lblLL.setAlignment(SWT.CENTER);
		lblLL.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblLL.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblLL.setText("\r\n↑ \r\n↑ \r\n↑ \r\n↑\r\n");
		lblLL.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblVVV = new Label(this, SWT.NONE);
		lblVVV.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblVVV.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblVVV.setAlignment(SWT.CENTER);
		lblVVV.setText("\r\n↓\r\n\r\n↓\r\n\r\n↓\r\n");
		lblVVV.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		label_12 = new Label(this, SWT.NONE);
		label_12.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		label_14 = new Label(this, SWT.NONE);
		label_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		canvas_4 = new Canvas(this,SWT.BORDER|SWT.NO_BACKGROUND);
		canvas_4.setBounds(724,30,85,267);
		
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
			list2[i].setBounds(700,31+10*i,10,10);
			list2[i].setAlignment(SWT.CENTER);
		}
		
		list3 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list3[i] = new Label(this, SWT.NONE);
			list3[i].setText(""+Codes.ETW[i]);
			list3[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list3[i].setBounds(560,31+10*i,10,10);
			list3[i].setAlignment(SWT.CENTER);
		}
		
		list4 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list4[i] = new Label(this, SWT.NONE);
			list4[i].setText(""+Codes.ETW[i]);
			list4[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list4[i].setBounds(520,31+10*i,10,10);
			list4[i].setAlignment(SWT.CENTER);
		}
		
		list5 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list5[i] = new Label(this, SWT.NONE);
			list5[i].setText(""+Codes.ETW[i]);
			list5[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list5[i].setBounds(375,31+10*i,10,10);
			list5[i].setAlignment(SWT.CENTER);
		}
		
		list6 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list6[i] = new Label(this, SWT.NONE);
			list6[i].setText(""+Codes.ETW[i]);
			list6[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list6[i].setBounds(335,31+10*i,10,10);
			list6[i].setAlignment(SWT.CENTER);
		}
		
		list7 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list7[i] = new Label(this, SWT.NONE);
			list7[i].setText(""+Codes.ETW[i]);
			list7[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list7[i].setBounds(190,31+10*i,10,10);
			list7[i].setAlignment(SWT.CENTER);
		}
		
		list8 = new Label[Codes.ETWN];
		for(int i = 0; i<Codes.ETWN;i++) {
			list8[i] = new Label(this, SWT.NONE);
			list8[i].setText(""+Codes.ETW[i]);
			list8[i].setFont(SWTResourceManager.getFont("Segoe UI", 5, SWT.NORMAL));
			list8[i].setBounds(160,31+10*i,10,10);
			list8[i].setAlignment(SWT.CENTER);
		}
		
		lblline1 = new Label(this, SWT.NONE);
		lblline1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline2 = new Label(this, SWT.NONE);
		lblline2.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline3 = new Label(this, SWT.NONE);
		lblline3.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline4 = new Label(this, SWT.NONE);
		lblline4.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline5 = new Label(this, SWT.NONE);
		lblline5.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline6 = new Label(this, SWT.NONE);
		lblline6.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline7 = new Label(this, SWT.NONE);
		lblline7.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline8 = new Label(this, SWT.NONE);
		lblline8.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		lblline9 = new Label(this, SWT.NONE);
		lblline9.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		lblline10 = new Label(this, SWT.NONE);
		lblline10.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		XD1 = new Spinner(canvas, SWT.BORDER);
		XD1.setBounds(0, 302, 56, 32);
		XD1.setOrientation(SWT.RIGHT_TO_LEFT);
		XD1.setMaximum(26);
		XD1.setMinimum(1);
		XD1.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD1.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				move(XD1.getSelection()-1,list2);
				move(XD1.getSelection()-1,list3);
				p1 = Integer.parseInt(XD1.getText())-1;
				f1.setBounds(list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().x-20,list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().y,20,5);
			}
		});
		
		Label lblNewLabel = new Label(canvas, SWT.NONE);
		lblNewLabel.setBounds(0, 0, 57, 29);
		lblNewLabel.setBackground(SWTResourceManager.getColor(250, 250, 250));
		lblNewLabel.setToolTipText("Rightmost rotor");
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblNewLabel.setText("Rotor");
		
		XD2 = new Spinner(canvas_1, SWT.BORDER);
		XD2.setBounds(0, 302, 56, 32);
		XD2.setOrientation(SWT.RIGHT_TO_LEFT);
		XD2.setMaximum(26);
		XD2.setMinimum(1);
		XD2.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		XD2.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				move(XD2.getSelection()-1,list4);
				move(XD2.getSelection()-1,list5);
				p2 = Integer.parseInt(XD2.getText())-1;
				f2.setBounds(list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().x-20,list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().y,20,5);
			}
		});
		
		Label lblRotor = new Label(canvas_1, SWT.NONE);
		lblRotor.setBounds(0, 0, 57, 29);
		lblRotor.setBackground(SWTResourceManager.getColor(250,250,250));
		lblRotor.setToolTipText("Middle rotor");
		lblRotor.setText("Rotor");
		lblRotor.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		
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
		
		Label lblRotor_1 = new Label(canvas_2, SWT.NONE);
		lblRotor_1.setBounds(0, 0, 56, 29);
		lblRotor_1.setBackground(SWTResourceManager.getColor(250,250,250));
		lblRotor_1.setToolTipText("Leftmost rotor");
		lblRotor_1.setText("Rotor");
		lblRotor_1.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		
		getInf();
		f1 = new Label(this,SWT.NONE);
		f1.setBackground(new Color(null, 0,0,0));
		f1.setBounds(list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().x-20,list3[(q1-p1-1<0)?(q1-p1-1+Codes.ETWN):(q1-p1-1)].getLocation().y,20,5);
		f2 = new Label(this,SWT.NONE);
		f2.setBackground(new Color(null, 0,0,0));
		f2.setBounds(list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().x-20,list5[(q2-p2-1<0)?(q2-p2-1+Codes.ETWN):(q2-p2-1)].getLocation().y,20,5);
		f4 = new Label(this,SWT.NONE);
		f4.setBackground(new Color(null, 0,0,0));
		f4.setBounds(530, 31, 10, 5);
		f5 = new Label(this,SWT.NONE);
		f5.setBackground(new Color(null, 0,0,0));
		f5.setBounds(345, 31, 10, 5);
		
		label_4 = new Label(this, SWT.NONE);
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		
		label_5 = new Label(this, SWT.NONE);
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	static void doit() {
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setBackground(new Color(null, 250, 250, 250));
				g.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
				g.gc.setForeground(new Color(null,255,0,0));
				g.gc.drawLine(0, lblline2.getLocation().y-2, canvas.getBounds().width-2, lblline1.getLocation().y-2);
				g.gc.setForeground(new Color(null,0,255,0));
				g.gc.drawLine(0, lblline7.getLocation().y-2, canvas.getBounds().width-2, lblline8.getLocation().y-2);
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
				g.gc.drawLine(0, lblline6.getLocation().y-2, canvas.getBounds().width-2, lblline7.getLocation().y-2);
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
				g.gc.drawLine(0, lblline5.getLocation().y-2, canvas.getBounds().width-2, lblline6.getLocation().y-2);
			}
			
		});
		canvas_2.redraw();
		
		canvas_3.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setBackground(new Color(null, 250, 250, 250));
				g.gc.fillRectangle(0, 0, canvas.getBounds().width, canvas.getBounds().height);
				g.gc.setForeground(new Color(null,255,230,0));
				int[] mxc = {190,Math.min(lblline4.getLocation().y, lblline5.getLocation().y)-2,50,Math.min(lblline4.getLocation().y, lblline5.getLocation().y)-2,50,Math.max(lblline4.getLocation().y, lblline5.getLocation().y)-2,190,Math.max(lblline4.getLocation().y, lblline5.getLocation().y)-2};
				g.gc.drawPolygon(mxc);
			}
			
		});
		canvas_3.redraw();
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

	protected void createContents() {
		setText("Enigma 3");
		setSize(875, 721);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
