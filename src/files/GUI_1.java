package files;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;

public class GUI_1 extends Shell {
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String args[]) {
//		try {
//			Display display = Display.getDefault();
//			GUI_1 shell = new GUI_1(display);
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
	static Label txt_1,txt_2,txt_3,txt_4,txt_5,txt_6,txt_7,txt_8,txt_9,txt_10,txt_11,txt_12,txt_13,txt_14;
	Spinner XD1;
	Spinner XD2;
	Spinner XD3;
	Spinner XD_1;
	Spinner XD_2;
	Spinner XD_3;
	Combo combo_1;
	Combo combo_2;
	Combo combo_3;
	Combo combo;
	
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
	void getInf() {
		try {
			String soundName = "./src/images/snd.wav";    
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			}
			catch(Exception e) {
				
			}
		
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
		case 4 : rotor1 = Codes.rotorV; q1 = 26; break;
		}
		switch(rotor2s){
		case 0 : rotor2 = Codes.rotorI; q2 = 17; break;
		case 1 : rotor2 = Codes.rotorII; q2 = 5;break;
		case 2 : rotor2 = Codes.rotorIII; q2 = 22; break;
		case 3 : rotor2 = Codes.rotorIV; q2 = 10; break;
		case 4 : rotor2 = Codes.rotorV; q2 = 26; break;
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
			p1 = (p1==Codes.ETWN-1)?(0):(p1+1);
			if(doubleStepping) {
				--p3;
				--p2;
				additional = true;
			}
			if(p1==q1&&additional) {
				++p3;
				++p2;
				additional = false;
			}
			doubleStepping = (p2==q2-1);
			p2 = (p1==q1||p2==q2-1)?((p2==Codes.ETWN-1)?(0):(p2+1)):(p2);
			p3 = (p2==q2)?((p3==Codes.ETWN-1)?(0):(p3+1)):(p3);
			XD1.setSelection(p1+1);
			XD2.setSelection(p2+1);
			XD3.setSelection(p3+1);
	}
	
	static Label[] plugBoard2 = new Label[Codes.ETWN];
	static Label[] plugBoard1 = new Label[Codes.ETWN];
	static boolean click = false;
	static char temporary = ' ';
	static Canvas canvas_4;
	
	private void connect() {
		for(int i = 0; i<Codes.ETWN;i++) {
				connect(plugBoard2[i],plugBoard1[i]);
			}
		}

	private void connect(Label l1, Label l2) {
		canvas_4.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent g) {
				g.gc.setForeground(new Color(null,250,230,0));
				g.gc.drawLine(  l1.getLocation().x-((Canvas) g.getSource()).getLocation().x+8, 
								l1.getLocation().y-((Canvas) g.getSource()).getLocation().y-5, 
								l2.getLocation().x-((Canvas) g.getSource()).getLocation().x+8, 
								l2.getLocation().y-((Canvas) g.getSource()).getLocation().y+15);
			}
			
		});
		canvas_4.redraw();
	}
	
	public GUI_1(Display display) {
		super(display, SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL | SWT.MIN);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setImage(SWTResourceManager.getImage(GUI.class, "/images/ENG.png"));
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('Q'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnNewButton_1.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnNewButton_1.setBounds(427, 438, 34, 35);
		btnNewButton_1.setText("&Q");
		
		Button btnW = new Button(this, SWT.NONE);
		btnW.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('W'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnW.setText("&W");
		btnW.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnW.setBounds(467, 438, 34, 35);
		
		Button btnE = new Button(this, SWT.NONE);
		btnE.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('E'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnE.setText("&E");
		btnE.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnE.setBounds(507, 438, 34, 35);
		
		Button btnR = new Button(this, SWT.NONE);
		btnR.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('R'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnR.setText("&R");
		btnR.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnR.setBounds(547, 438, 34, 35);
		
		Button btnT = new Button(this, SWT.NONE);
		btnT.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('T'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnT.setText("&T");
		btnT.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnT.setBounds(587, 438, 34, 35);
		
		Button btnZ = new Button(this, SWT.NONE);
		btnZ.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('Z'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnZ.setText("&Z");
		btnZ.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnZ.setBounds(627, 438, 34, 35);
		
		Button btnU = new Button(this, SWT.NONE);
		btnU.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('U'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnU.setText("&U");
		btnU.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnU.setBounds(667, 438, 34, 35);
		
		Button btnI = new Button(this, SWT.NONE);
		btnI.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('I'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnI.setText("&I");
		btnI.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnI.setBounds(707, 438, 34, 35);
		
		Button btnO = new Button(this, SWT.NONE);
		btnO.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('O'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnO.setText("&O");
		btnO.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnO.setBounds(747, 438, 34, 35);
		
		Button btnA = new Button(this, SWT.NONE);
		btnA.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('A'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnA.setText("&A");
		btnA.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnA.setBounds(447, 479, 34, 35);
		
		Button btnS = new Button(this, SWT.NONE);
		btnS.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('S'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnS.setText("&S");
		btnS.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnS.setBounds(487, 479, 34, 35);
		
		Button btnD = new Button(this, SWT.NONE);
		btnD.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('D'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnD.setText("&D");
		btnD.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnD.setBounds(527, 479, 34, 35);
		
		Button btnF = new Button(this, SWT.NONE);
		btnF.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('F'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnF.setText("&F");
		btnF.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnF.setBounds(567, 479, 34, 35);
		
		Button btnG = new Button(this, SWT.NONE);
		btnG.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('G'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnG.setText("&G");
		btnG.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnG.setBounds(607, 479, 34, 35);
		
		Button btnH = new Button(this, SWT.NONE);
		btnH.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('H'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnH.setText("&H");
		btnH.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnH.setBounds(647, 479, 34, 35);
		
		Button btnJ = new Button(this, SWT.NONE);
		btnJ.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('J'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnJ.setText("&J");
		btnJ.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnJ.setBounds(687, 479, 34, 35);
		
		Button btnK = new Button(this, SWT.NONE);
		btnK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('Z'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnK.setText("&K");
		btnK.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnK.setBounds(727, 479, 34, 35);
		
		Button btnP = new Button(this, SWT.NONE);
		btnP.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('P'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnP.setText("&P");
		btnP.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnP.setBounds(427, 520, 34, 35);
		
		Button btnY = new Button(this, SWT.NONE);
		btnY.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('Y'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnY.setText("&Y");
		btnY.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnY.setBounds(467, 520, 34, 35);
		
		Button btnX = new Button(this, SWT.NONE);
		btnX.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('X'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnX.setText("&X");
		btnX.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnX.setBounds(507, 520, 34, 35);
		
		Button btnC = new Button(this, SWT.NONE);
		btnC.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('C'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnC.setText("&C");
		btnC.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnC.setBounds(547, 520, 34, 35);
		
		Button btnV = new Button(this, SWT.NONE);
		btnV.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('V'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnV.setText("&V");
		btnV.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnV.setBounds(587, 520, 34, 35);
		
		Button btnB = new Button(this, SWT.NONE);
		btnB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('B'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnB.setText("&B");
		btnB.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnB.setBounds(627, 520, 34, 35);
		
		Button btnN = new Button(this, SWT.NONE);
		btnN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('N'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnN.setText("&N");
		btnN.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnN.setBounds(667, 520, 34, 35);
		
		Button btnM = new Button(this, SWT.NONE);
		btnM.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('M'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnM.setText("&M");
		btnM.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnM.setBounds(707, 520, 34, 35);
		
		Button btnL = new Button(this, SWT.NONE);
		btnL.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getInf();
				stepping();
				text_1.setText(text_1.getText()+Codes.pB(Codes.enigma3(Codes.pB('L'), UKW, rotor1, p1,r1, rotor2, p2,r2, rotor3, p3,r3)));
			}
		});
		btnL.setText("&L");
		btnL.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnL.setBounds(747, 520, 34, 35);
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_2.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		btnNewButton_2.setBounds(507, 561, 174, 37);
		btnNewButton_2.setText("Space");
		
		Label lblReflector = new Label(this, SWT.NONE);
		lblReflector.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblReflector.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblReflector.setBounds(27, 39, 117, 37);
		lblReflector.setText("Reflector");
		
		combo = new Combo(this, SWT.NONE);
		combo.setItems(new String[] {"UKW B", "UKW C"});
		combo.setToolTipText("Reflector");
		combo.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		combo.setBounds(27, 135, 117, 40);
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
		
		XD_2 = new Spinner(canvas_1, SWT.BORDER);
		XD_2.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_2.setMaximum(26);
		XD_2.setMinimum(1);
		XD_2.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		XD_2.setBounds(10, 172, 96, 37);
		
		XD2 = new Spinner(canvas_1, SWT.BORDER);
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
		
		combo_2 = new Combo(canvas_1, SWT.NONE);
		combo_2.setBounds(10, 7, 96, 40);
		combo_2.setToolTipText("Middle rotor");
		combo_2.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_2.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		combo_2.select(1);
		
		Canvas canvas = new Canvas(this, SWT.BORDER | SWT.NO_BACKGROUND);
		canvas.setBounds(612, 82, 117, 223);
		
		XD_1 = new Spinner(canvas, SWT.BORDER);
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
		
		XD1 = new Spinner(canvas, SWT.BORDER);
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
		
		combo_3 = new Combo(canvas, SWT.NONE);
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
		
		XD_3 = new Spinner(canvas_2, SWT.BORDER);
		XD_3.setOrientation(SWT.RIGHT_TO_LEFT);
		XD_3.setMaximum(26);
		XD_3.setMinimum(1);
		XD_3.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		XD_3.setBounds(10, 175, 96, 37);
		
		XD3 = new Spinner(canvas_2, SWT.BORDER);
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
		
		combo_1 = new Combo(canvas_2, SWT.NONE);
		combo_1.setBounds(10, 10, 96, 40);
		combo_1.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
		combo_1.setToolTipText("Leftmost rotor");
		combo_1.setItems(new String[] {"I", "II", "III", "IV", "V"});
		combo_1.select(0);
		
		MouseListener xyz = new MouseListener() {
			public void mouseDown(MouseEvent e) {
				if(((Label) e.getSource()).getText().charAt(0)!=Codes.ETW[indexOf(((Label) e.getSource()),plugBoard1)]) {
					String tmp = ((Label) e.getSource()).getText();
					((Label) e.getSource()).setText(Codes.ETW[indexOf(((Label) e.getSource()),plugBoard1)]+"");
					plugBoard1[Codes.toVal(tmp.charAt(0),Codes.ETW)].setText(tmp);
					plugBoard1[Codes.toVal(((Label) e.getSource()).getText().charAt(0),Codes.ETW)].setBackground(new Color(null,255,255,255));
					plugBoard1[Codes.toVal(tmp.charAt(0),Codes.ETW)].setBackground(new Color(null,255,255,255));
				}
				else {
					if(click) {
						char tmp = ((Label) e.getSource()).getText().charAt(0);
						((Label) e.getSource()).setText(temporary+"");
						plugBoard1[Codes.toVal(temporary,Codes.ETW)].setText(tmp+"");
						Color p;
						Random rand = new Random();
						int r = rand.nextInt(256);
						int g = rand.nextInt(256);
						int b = rand.nextInt(256);
						p = new Color(null,r,g,b);
						plugBoard1[Codes.toVal(temporary,Codes.ETW)].setBackground(p);
						plugBoard1[Codes.toVal(tmp,Codes.ETW)].setBackground(p);
						Codes.plugBoard[Codes.toVal(temporary,Codes.ETW)] = tmp;
						Codes.plugBoard[Codes.toVal(tmp,Codes.ETW)] = temporary;
						click = false;
					}
					else {
						temporary = ((Label) e.getSource()).getText().charAt(0);
						((Label) e.getSource()).setBackground(new Color(null,100,100,255));
						click = true;
					}
				}
			}

			private int indexOf(Label l, Label[] p) {
				for(int i = 0; i<p.length;i++) {
					if(l==p[i])
						return i;
				}
				return -1;
			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		
		for(int i =0; i<Codes.ETWN;i++) {
			plugBoard1[i] = new Label(this, SWT.CENTER);
			plugBoard1[i].setText(Codes.ETW[i]+"");
			plugBoard1[i].setBounds(95+26*i,341,20,15);
			plugBoard1[i].setToolTipText("PlugBoard");
			plugBoard1[i].setBackground(new Color(null,255,255,255));
			plugBoard1[i].addMouseListener(xyz);
		}
		for(int i = 0; i<Codes.ETWN;i++) {
			plugBoard2[i] = new Label(this,SWT.CENTER|SWT.NO_BACKGROUND);
			plugBoard2[i].setText(Codes.ETW[i]+"");
			plugBoard2[i].setBounds(95+26*i,389,20,18);
			plugBoard2[i].setBackground(new Color(null,255,255,255));
			plugBoard2[i].setToolTipText("PlugBoard");
		}
		
		text_1 = new Text(this, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		text_1.setFont(SWTResourceManager.getFont("VCR OSD Mono", 16, SWT.BOLD));
		text_1.setToolTipText("Output");
		text_1.setBounds(10, 414, 367, 252);
		
		Canvas canvas_3 = new Canvas(this, SWT.BORDER | SWT.NO_BACKGROUND);
		canvas_3.setBounds(27, 82, 117, 140);
		
		Button btnReset = new Button(this, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_1.setText("");
			}
		});
		btnReset.setBounds(10, 379, 46, 25);
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
		
		txt_1 = new Label(this, SWT.NONE);
		txt_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txt_1.setBounds(732, 105, 25, 25);
		
		txt_2 = new Label(this, SWT.NONE);
		txt_2.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txt_2.setBounds(583, 105, 25, 25);
		
		txt_3 = new Label(this, SWT.NONE);
		txt_3.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txt_3.setBounds(549, 105, 25, 25);
		
		txt_4 = new Label(this, SWT.NONE);
		txt_4.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txt_4.setBounds(395, 105, 25, 25);
		
		txt_5 = new Label(this, SWT.NONE);
		txt_5.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txt_5.setBounds(355, 105, 25, 25);
		
		txt_6 = new Label(this, SWT.NONE);
		txt_6.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txt_6.setBounds(200, 105, 25, 25);
		
		txt_7 = new Label(this, SWT.NONE);
		txt_7.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		txt_7.setBounds(150, 105, 25, 25);
		
		txt_8 = new Label(this, SWT.NONE);
		txt_8.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		txt_8.setBounds(150, 181, 25, 25);
		
		txt_9 = new Label(this, SWT.NONE);
		txt_9.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		txt_9.setBounds(200, 181, 25, 25);
		
		txt_10 = new Label(this, SWT.NONE);
		txt_10.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		txt_10.setBounds(355, 181, 25, 25);
		
		txt_11 = new Label(this, SWT.NONE);
		txt_11.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		txt_11.setBounds(395, 181, 25, 25);
		
		txt_12 = new Label(this, SWT.NONE);
		txt_12.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_12.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		txt_12.setBounds(549, 181, 25, 25);
		
		txt_13 = new Label(this, SWT.NONE);
		txt_13.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_13.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		txt_13.setBounds(583, 181, 25, 25);
		
		txt_14 = new Label(this, SWT.NONE);
		txt_14.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txt_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		txt_14.setBounds(732, 181, 25, 25);
		
		Label label_4 = new Label(this, SWT.HORIZONTAL);
		label_4.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		label_4.setText("           ←                                               ←                                            ← ");
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_4.setBounds(138, 105, 630, 26);
		
		Label label_5 = new Label(this, SWT.HORIZONTAL);
		label_5.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		label_5.setText("           →                                               →                                            → ");
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_5.setBounds(138, 181, 617, 25);
		
		Label label_7 = new Label(this, SWT.HORIZONTAL);
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_7.setBounds(427, 430, 353, 4);
		
		Label lblLL = new Label(this, SWT.NONE);
		lblLL.setAlignment(SWT.CENTER);
		lblLL.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblLL.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblLL.setText("\r\n\r\n↑ \r\n↑ \r\n↑ \r\n↑\r\n");
		lblLL.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblLL.setBounds(760, 123, 8, 215);
		
		canvas_4 = new Canvas(this, SWT.BORDER);
		canvas_4.setToolTipText("");
		canvas_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas_4.setBounds(94, 338, 674, 71);
		
		Label lblVVV = new Label(this, SWT.NONE);
		lblVVV.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblVVV.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblVVV.setAlignment(SWT.CENTER);
		lblVVV.setText("\r\n↓\r\n\r\n↓\r\n\r\n↓\r\n");
		lblVVV.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblVVV.setBounds(749, 205, 8, 110);
		
		Label label_10 = new Label(this, SWT.HORIZONTAL);
		label_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_10.setBounds(101, 310, 656, 8);
		
		Label label_11 = new Label(this, SWT.NONE);
		label_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_11.setBounds(94, 310, 8, 40);
		
		Label label_12 = new Label(this, SWT.NONE);
		label_12.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_12.setBounds(94, 378, 8, 37);
		
		Label label_14 = new Label(this, SWT.NONE);
		label_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_14.setBounds(595, 407, 8, 25);
		
		connect();
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Enigma 3");
		setSize(803, 723);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
