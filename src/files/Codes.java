package files;

public class Codes {
static char[] ETW = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
static int ETWN = ETW.length;
static char[] Beta = {'L','E','Y','J','V','C','N','I','X','W','P','B','Q','M','D','R','T','A','K','Z','G','F','U','H','O','S'};
static char[] Gamma = {'F','S','O','K','A','N','U','E','R','H','M','B','T','I','Y','C','W','L','Q','P','Z','X','V','G','J','D'};
static char[] rotorI = {'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'};
static char[] rotorII = {'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
static char[] rotorIII = {'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O'};
static char[] rotorIV = {'E','S','O','V','P','Z','J','A','Y','Q','U','I','R','H','X','L','N','F','T','G','K','D','C','M','W','B'};
static char[] rotorV = {'V','Z','B','R','G','I','T','Y','U','P','S','D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K'};
static char[] UKWb = {'Y','R','U','H','Q','S','L','D','P','X','N','G','O','K','M','I','E','B','F','Z','C','W','V','J','A','T'};
static char[] UKWbt = {'E','N','K','Q','A','U','Y','W','J','I','C','O','P','B','L','M','D','X','Z','V','F','T','H','R','G','S'};
static char[] UKWc = {'F','V','P','J','I','A','O','Y','E','D','R','Z','X','W','G','C','T','K','U','Q','S','B','N','M','H','L'};
static char[] UKWct = {'R','D','O','B','J','N','T','K','V','E','H','M','L','F','C','W','Z','A','X','G','Y','I','P','S','U','Q'};
static char[] plugBoard = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
public static char pB(char c) {
		for(int j = 0; j<ETWN;j++) {
			if(c==ETW[j]) {
				c = plugBoard[j];
				break;
			}
		}
	return c;
}
public static String pB(String s) {
	String sNew = "";
	for(int i = 0; i<s.length();i++) {
		if(s.charAt(i)==' ') {
			sNew = sNew + ' ';
			continue;
		}
		for(int j = 0; j<ETWN;j++) {
			if(s.charAt(i)==ETW[j]) {
				sNew = sNew + plugBoard[j];
				break;
			}
		}
	}
	return sNew;
}
public static int toVal(char c, char[] ca) {
	for(int i = 0; i<ca.length; i++) {
		if(c==ca[i])
			return i;
	}
	return 0;
}
public static char rotor(char[] rotor, char c, int ring, boolean flag){
	if(flag) {
	int cx = toVal(c,ETW);
	cx = (cx-ring<0)?(cx-ring+ETWN):(cx-ring);
	c = rotor[cx];
	return c;
	}
	else {
		int cx = toVal(c,rotor);
		cx = (cx+ring>=ETWN)?(cx+ring-ETWN):(cx+ring);
		c = ETW[cx];
		return c;
	}
}
public static char reflector(char[] UKW, char c) {
	for(int j = 0; j<ETWN;j++) {
		if(c==ETW[j]) {
			c = UKW[j];
			break;
		}
	}
	return c;
}
public static String enigma3(String s, char[] UKW, char[] rotor1, int p1, int r1, int q1, char[] rotor2, int p2, int r2, int q2, char[] rotor3, int p3, int r3, int q3) {
	String result = "";
	s = s.toUpperCase();
	char c;
	for(int i = 0; i<s.length();i++) {
		if(s.charAt(i)<'A'||s.charAt(i)>'Z') {
			result = result + s.charAt(i);
			continue;
		}
		p1 = (p1==ETWN-1)?(0):(p1+1);
		int m = (q2-1<0)?(q2-1+Codes.ETWN):(q2-1);
		if (p1==q1||p2==m) {
			p2 = (p2==Codes.ETWN-1)?(0):(p2+1);
			p3 = (p2==q2)?((p3==Codes.ETWN-1)?(0):(p3+1)):(p3);
		}
		c = s.charAt(i);
		c = (toVal(c,ETW)+p1>=ETWN)?(ETW[toVal(c,ETW)+p1-ETWN]):(ETW[toVal(c,ETW)+p1]);
		c = rotor(rotor1,c,r1,true);
		c = ETW[(toVal(c,ETW)+r1>=ETWN)?(toVal(c,ETW)+r1-ETWN):(toVal(c,ETW)+r1)];
		c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
		c = (toVal(c,ETW)+p2>=ETWN)?(ETW[toVal(c,ETW)+p2-ETWN]):(ETW[toVal(c,ETW)+p2]);
		c = rotor(rotor2,c,r2,true);
		c = ETW[(toVal(c,ETW)+r2>=ETWN)?(toVal(c,ETW)+r2-ETWN):(toVal(c,ETW)+r2)];
		c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
		c = (toVal(c,ETW)+p3>=ETWN)?(ETW[toVal(c,ETW)+p3-ETWN]):(ETW[toVal(c,ETW)+p3]);
		c = rotor(rotor3,c,r3,true);
		c = ETW[(toVal(c,ETW)+r3>=ETWN)?(toVal(c,ETW)+r3-ETWN):(toVal(c,ETW)+r3)];
		c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
		c = reflector(UKW,c);
		c = ETW[(toVal(c,ETW)+p3>=ETWN)?(toVal(c,ETW)+p3-ETWN):(toVal(c,ETW)+p3)];
		c = ETW[(toVal(c,ETW)-r3<0)?(toVal(c,ETW)-r3+ETWN):(toVal(c,ETW)-r3)];
		c = rotor(rotor3,c,r3,false);
		c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
		c = ETW[(toVal(c,ETW)+p2>=ETWN)?(toVal(c,ETW)+p2-ETWN):(toVal(c,ETW)+p2)];
		c = ETW[(toVal(c,ETW)-r2<0)?(toVal(c,ETW)-r2+ETWN):(toVal(c,ETW)-r2)];
		c = rotor(rotor2,c,r2,false);
		c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
		c = ETW[(toVal(c,ETW)+p1>=ETWN)?(toVal(c,ETW)+p1-ETWN):(toVal(c,ETW)+p1)];
		c = ETW[(toVal(c,ETW)-r1<0)?(toVal(c,ETW)-r1+ETWN):(toVal(c,ETW)-r1)];
		c = rotor(rotor1,c,r1,false);
		c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
		result = result + c;
	}
	return result;
}
public static char enigma3(char c, char[] UKW, char[] rotor1, int p1, int r1, char[] rotor2, int p2, int r2, char[] rotor3, int p3, int r3) {
	
	c = (toVal(c,ETW)+p1>=ETWN)?(ETW[toVal(c,ETW)+p1-ETWN]):(ETW[toVal(c,ETW)+p1]);
	GUI_1.txt_1.setText("  "+c);
	c = rotor(rotor1,c,r1,true);
	c = ETW[(toVal(c,ETW)+r1>=ETWN)?(toVal(c,ETW)+r1-ETWN):(toVal(c,ETW)+r1)];
	GUI_1.txt_2.setText("  "+c);
	c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
	c = (toVal(c,ETW)+p2>=ETWN)?(ETW[toVal(c,ETW)+p2-ETWN]):(ETW[toVal(c,ETW)+p2]);
	GUI_1.txt_3.setText("  "+c);
	c = rotor(rotor2,c,r2,true);
	c = ETW[(toVal(c,ETW)+r2>=ETWN)?(toVal(c,ETW)+r2-ETWN):(toVal(c,ETW)+r2)];
	GUI_1.txt_4.setText("  "+c);
	c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
	c = (toVal(c,ETW)+p3>=ETWN)?(ETW[toVal(c,ETW)+p3-ETWN]):(ETW[toVal(c,ETW)+p3]);
	GUI_1.txt_5.setText("  "+c);
	c = rotor(rotor3,c,r3,true);
	c = ETW[(toVal(c,ETW)+r3>=ETWN)?(toVal(c,ETW)+r3-ETWN):(toVal(c,ETW)+r3)];
	GUI_1.txt_6.setText("  "+c);
	c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
	GUI_1.txt_7.setText("  "+c);
	c = reflector(UKW,c);
	GUI_1.txt_8.setText("  "+c);
	c = ETW[(toVal(c,ETW)+p3>=ETWN)?(toVal(c,ETW)+p3-ETWN):(toVal(c,ETW)+p3)];
	GUI_1.txt_9.setText("  "+c);
	c = ETW[(toVal(c,ETW)-r3<0)?(toVal(c,ETW)-r3+ETWN):(toVal(c,ETW)-r3)];
	c = rotor(rotor3,c,r3,false);
	GUI_1.txt_10.setText("  "+c);
	c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
	c = ETW[(toVal(c,ETW)+p2>=ETWN)?(toVal(c,ETW)+p2-ETWN):(toVal(c,ETW)+p2)];
	GUI_1.txt_11.setText("  "+c);
	c = ETW[(toVal(c,ETW)-r2<0)?(toVal(c,ETW)-r2+ETWN):(toVal(c,ETW)-r2)];
	c = rotor(rotor2,c,r2,false);
	GUI_1.txt_12.setText("  "+c);
	c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
	c = ETW[(toVal(c,ETW)+p1>=ETWN)?(toVal(c,ETW)+p1-ETWN):(toVal(c,ETW)+p1)];
	GUI_1.txt_13.setText("  "+c);
	c = ETW[(toVal(c,ETW)-r1<0)?(toVal(c,ETW)-r1+ETWN):(toVal(c,ETW)-r1)];
	c = rotor(rotor1,c,r1,false);
	GUI_1.txt_14.setText("  "+c);
	c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
	return c;
}
public static char enigma32(char c, char[] UKW, char[] rotor1, int p1, int r1, char[] rotor2, int p2, int r2, char[] rotor3, int p3, int r3) {
	
	GUI_2.label_4.setBounds(585, 406, 253, 8);
	GUI_2.label_14.setBounds(585, 410, 8, 35);
	
	GUI_2.lblLL.setBounds(830, 296-10*(ETWN-toVal(pB(c),ETW)), 8, 114+10*(ETWN-toVal(pB(c),ETW)));
	GUI_2.lblline9.setBounds(730, 296-10*(ETWN-toVal(pB(c),ETW)), 100, 1);
	GUI_2.lblline1.setBounds(690, 296-10*(ETWN-toVal(c,ETW)), 100, 1);
	c = (toVal(c,ETW)+p1>=ETWN)?(ETW[toVal(c,ETW)+p1-ETWN]):(ETW[toVal(c,ETW)+p1]);
	c = rotor(rotor1,c,r1,true);
	GUI_2.lblline2.setBounds(510, 296-10*((ETWN-toVal(c,ETW)+p1>ETWN)?(-toVal(c,ETW)+p1):(ETWN-toVal(c,ETW)+p1)), 70, 1);
	c = ETW[(toVal(c,ETW)+r1>=ETWN)?(toVal(c,ETW)+r1-ETWN):(toVal(c,ETW)+r1)];
	c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
	c = (toVal(c,ETW)+p2>=ETWN)?(ETW[toVal(c,ETW)+p2-ETWN]):(ETW[toVal(c,ETW)+p2]);
	c = rotor(rotor2,c,r2,true);
	GUI_2.lblline3.setBounds(320, 296-10*((ETWN-toVal(c,ETW)+p2>ETWN)?(-toVal(c,ETW)+p2):(ETWN-toVal(c,ETW)+p2)), 80, 1);
	c = ETW[(toVal(c,ETW)+r2>=ETWN)?(toVal(c,ETW)+r2-ETWN):(toVal(c,ETW)+r2)];
	c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
	c = (toVal(c,ETW)+p3>=ETWN)?(ETW[toVal(c,ETW)+p3-ETWN]):(ETW[toVal(c,ETW)+p3]);
	c = rotor(rotor3,c,r3,true);
	GUI_2.lblline4.setBounds(140, 296-10*((ETWN-toVal(c,ETW)+p3>ETWN)?(-toVal(c,ETW)+p3):(ETWN-toVal(c,ETW)+p3)), 80, 1);
	c = ETW[(toVal(c,ETW)+r3>=ETWN)?(toVal(c,ETW)+r3-ETWN):(toVal(c,ETW)+r3)];
	c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
	c = reflector(UKW,c);
	GUI_2.lblline5.setBounds(140, 296-10*(ETWN-toVal(c,ETW)), 80, 1);
	c = ETW[(toVal(c,ETW)+p3>=ETWN)?(toVal(c,ETW)+p3-ETWN):(toVal(c,ETW)+p3)];
	c = ETW[(toVal(c,ETW)-r3<0)?(toVal(c,ETW)-r3+ETWN):(toVal(c,ETW)-r3)];
	c = rotor(rotor3,c,r3,false);
	GUI_2.lblline6.setBounds(320, 296-10*((ETWN-toVal(c,ETW)+p3>ETWN)?(-toVal(c,ETW)+p3):(ETWN-toVal(c,ETW)+p3)), 80, 1);
	c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
	c = ETW[(toVal(c,ETW)+p2>=ETWN)?(toVal(c,ETW)+p2-ETWN):(toVal(c,ETW)+p2)];
	c = ETW[(toVal(c,ETW)-r2<0)?(toVal(c,ETW)-r2+ETWN):(toVal(c,ETW)-r2)];
	c = rotor(rotor2,c,r2,false);
	GUI_2.lblline7.setBounds(510, 296-10*((ETWN-toVal(c,ETW)+p2>ETWN)?(-toVal(c,ETW)+p2):(ETWN-toVal(c,ETW)+p2)), 70, 1);
	c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
	c = ETW[(toVal(c,ETW)+p1>=ETWN)?(toVal(c,ETW)+p1-ETWN):(toVal(c,ETW)+p1)];
	c = ETW[(toVal(c,ETW)-r1<0)?(toVal(c,ETW)-r1+ETWN):(toVal(c,ETW)-r1)];
	c = rotor(rotor1,c,r1,false);
	GUI_2.lblline8.setBounds(690, 296-10*((ETWN-toVal(c,ETW)+p1>ETWN)?(-toVal(c,ETW)+p1):(ETWN-toVal(c,ETW)+p1)), 100, 1);
	c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
	GUI_2.lblVVV.setBounds(819, 296-10*(ETWN-toVal(pB(c),ETW)), 8, 84+10*(ETWN-toVal(pB(c),ETW)));
	GUI_2.lblline10.setBounds(789, 296-10*(ETWN-toVal(pB(c),ETW)), 35, 1);
	
	GUI_2.label_12.setBounds(190, 375, 8, 48);
	GUI_2.label_5.setBounds(190, 375, 637, 8);
	return c;
}
public static String enigma4(String s, char[] UKW, char[] rotor1, int p1, int r1, int q1, char[] rotor2, int p2, int r2, int q2, char[] rotor3, int p3, int r3, int q3, char[] rotor4, int p4, int r4) {
	String result = "";
	s = s.toUpperCase();
	char c;
	for(int i = 0; i<s.length();i++) {
		if(s.charAt(i)<'A'||s.charAt(i)>'Z') {
			result = result + s.charAt(i);
			continue;
		}
		p1 = (p1==ETWN-1)?(0):(p1+1);
		int m = (q2-1<0)?(q2-1+Codes.ETWN):(q2-1);
		if (p1==q1||p2==m) {
			p2 = (p2==Codes.ETWN-1)?(0):(p2+1);
			if(p2==q2) {
				p3 = p3==Codes.ETWN-1?0:p3+1;
			}
		}
		c = s.charAt(i);
		c = (toVal(c,ETW)+p1>=ETWN)?(ETW[toVal(c,ETW)+p1-ETWN]):(ETW[toVal(c,ETW)+p1]);
		c = rotor(rotor1,c,r1,true);
		c = ETW[(toVal(c,ETW)+r1>=ETWN)?(toVal(c,ETW)+r1-ETWN):(toVal(c,ETW)+r1)];
		c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
		c = (toVal(c,ETW)+p2>=ETWN)?(ETW[toVal(c,ETW)+p2-ETWN]):(ETW[toVal(c,ETW)+p2]);
		c = rotor(rotor2,c,r2,true);
		c = ETW[(toVal(c,ETW)+r2>=ETWN)?(toVal(c,ETW)+r2-ETWN):(toVal(c,ETW)+r2)];
		c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
		c = (toVal(c,ETW)+p3>=ETWN)?(ETW[toVal(c,ETW)+p3-ETWN]):(ETW[toVal(c,ETW)+p3]);
		c = rotor(rotor3,c,r3,true);
		c = ETW[(toVal(c,ETW)+r3>=ETWN)?(toVal(c,ETW)+r3-ETWN):(toVal(c,ETW)+r3)];
		c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
		c = (toVal(c,ETW)+p4>=ETWN)?(ETW[toVal(c,ETW)+p4-ETWN]):(ETW[toVal(c,ETW)+p4]);
		c = rotor(rotor4,c,r4,true);
		c = ETW[(toVal(c,ETW)+r4>=ETWN)?(toVal(c,ETW)+r4-ETWN):(toVal(c,ETW)+r4)];
		c = ETW[(toVal(c,ETW)-p4<0)?(toVal(c,ETW)-p4+ETWN):(toVal(c,ETW)-p4)];
		c = reflector(UKW,c);
		c = ETW[(toVal(c,ETW)+p4>=ETWN)?(toVal(c,ETW)+p4-ETWN):(toVal(c,ETW)+p4)];
		c = ETW[(toVal(c,ETW)-r4<0)?(toVal(c,ETW)-r4+ETWN):(toVal(c,ETW)-r4)];
		c = rotor(rotor4,c,r4,false);
		c = ETW[(toVal(c,ETW)-p4<0)?(toVal(c,ETW)-p4+ETWN):(toVal(c,ETW)-p4)];
		c = ETW[(toVal(c,ETW)+p3>=ETWN)?(toVal(c,ETW)+p3-ETWN):(toVal(c,ETW)+p3)];
		c = ETW[(toVal(c,ETW)-r3<0)?(toVal(c,ETW)-r3+ETWN):(toVal(c,ETW)-r3)];
		c = rotor(rotor3,c,r3,false);
		c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
		c = ETW[(toVal(c,ETW)+p2>=ETWN)?(toVal(c,ETW)+p2-ETWN):(toVal(c,ETW)+p2)];
		c = ETW[(toVal(c,ETW)-r2<0)?(toVal(c,ETW)-r2+ETWN):(toVal(c,ETW)-r2)];
		c = rotor(rotor2,c,r2,false);
		c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
		c = ETW[(toVal(c,ETW)+p1>=ETWN)?(toVal(c,ETW)+p1-ETWN):(toVal(c,ETW)+p1)];
		c = ETW[(toVal(c,ETW)-r1<0)?(toVal(c,ETW)-r1+ETWN):(toVal(c,ETW)-r1)];
		c = rotor(rotor1,c,r1,false);
		c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
		result = result + c;
	}
	return result;
}
public static char enigma4(char c, char[] UKW, char[] rotor1, int p1, int r1, char[] rotor2, int p2, int r2, char[] rotor3, int p3, int r3, char[] rotor4, int p4, int r4) {
		GUI2_1.label_8.setBounds(864, 405, 8, 59);
		GUI2_1.label_9.setBounds(864, 399, 244, 8);
		GUI2_1.lblline11.setBounds(984, 296-10*(ETWN-toVal(pB(c),ETW)), 120, 1);
		GUI2_1.lblLL.setBounds(1100, 296-10*(ETWN-toVal(pB(c),ETW)), 8, 107+10*(ETWN-toVal(pB(c),ETW)));
		GUI2_1.lblline1.setBounds(924, 296-10*(ETWN-toVal(c,ETW)), 110, 1);
		c = (toVal(c,ETW)+p1>=ETWN)?(ETW[toVal(c,ETW)+p1-ETWN]):(ETW[toVal(c,ETW)+p1]);
		c = rotor(rotor1,c,r1,true);
		GUI2_1.lblline2.setBounds(719, 296-10*((ETWN-toVal(c,ETW)+p1>ETWN)?(-toVal(c,ETW)+p1):(ETWN-toVal(c,ETW)+p1)), 90, 1);
		c = ETW[(toVal(c,ETW)+r1>=ETWN)?(toVal(c,ETW)+r1-ETWN):(toVal(c,ETW)+r1)];
		c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
		c = (toVal(c,ETW)+p2>=ETWN)?(ETW[toVal(c,ETW)+p2-ETWN]):(ETW[toVal(c,ETW)+p2]);
		c = rotor(rotor2,c,r2,true);
		GUI2_1.lblline3.setBounds(515, 296-10*((ETWN-toVal(c,ETW)+p2>ETWN)?(-toVal(c,ETW)+p2):(ETWN-toVal(c,ETW)+p2)), 90, 1);
		c = ETW[(toVal(c,ETW)+r2>=ETWN)?(toVal(c,ETW)+r2-ETWN):(toVal(c,ETW)+r2)];
		c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
		c = (toVal(c,ETW)+p3>=ETWN)?(ETW[toVal(c,ETW)+p3-ETWN]):(ETW[toVal(c,ETW)+p3]);
		c = rotor(rotor3,c,r3,true);
		GUI2_1.lblline4.setBounds(323, 296-10*((ETWN-toVal(c,ETW)+p3>ETWN)?(-toVal(c,ETW)+p3):(ETWN-toVal(c,ETW)+p3)), 80, 1);
		c = ETW[(toVal(c,ETW)+r3>=ETWN)?(toVal(c,ETW)+r3-ETWN):(toVal(c,ETW)+r3)];
		c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
		c = (toVal(c,ETW)+p4>=ETWN)?(ETW[toVal(c,ETW)+p4-ETWN]):(ETW[toVal(c,ETW)+p4]);
		c = rotor(rotor4,c,r4,true);
		GUI2_1.lblline5.setBounds(127, 296-10*((ETWN-toVal(c,ETW)+p4>ETWN)?(-toVal(c,ETW)+p4):(ETWN-toVal(c,ETW)+p4)), 80, 1);
		c = ETW[(toVal(c,ETW)+r4>=ETWN)?(toVal(c,ETW)+r4-ETWN):(toVal(c,ETW)+r4)];
		c = ETW[(toVal(c,ETW)-p4<0)?(toVal(c,ETW)-p4+ETWN):(toVal(c,ETW)-p4)];
		c = reflector(UKW,c);
		GUI2_1.lblline6.setBounds(127, 296-10*(ETWN-toVal(c,ETW)), 80, 1);
		c = ETW[(toVal(c,ETW)+p4>=ETWN)?(toVal(c,ETW)+p4-ETWN):(toVal(c,ETW)+p4)];
		c = ETW[(toVal(c,ETW)-r4<0)?(toVal(c,ETW)-r4+ETWN):(toVal(c,ETW)-r4)];
		c = rotor(rotor4,c,r4,false);
		GUI2_1.lblline7.setBounds(323, 296-10*((ETWN-toVal(c,ETW)+p4>ETWN)?(-toVal(c,ETW)+p4):(ETWN-toVal(c,ETW)+p4)), 80, 1);
		c = ETW[(toVal(c,ETW)-p4<0)?(toVal(c,ETW)-p4+ETWN):(toVal(c,ETW)-p4)];
		c = ETW[(toVal(c,ETW)+p3>=ETWN)?(toVal(c,ETW)+p3-ETWN):(toVal(c,ETW)+p3)];
		c = ETW[(toVal(c,ETW)-r3<0)?(toVal(c,ETW)-r3+ETWN):(toVal(c,ETW)-r3)];
		c = rotor(rotor3,c,r3,false);
		GUI2_1.lblline8.setBounds(515, 296-10*((ETWN-toVal(c,ETW)+p3>ETWN)?(-toVal(c,ETW)+p3):(ETWN-toVal(c,ETW)+p3)), 90, 1);
		c = ETW[(toVal(c,ETW)-p3<0)?(toVal(c,ETW)-p3+ETWN):(toVal(c,ETW)-p3)];
		c = ETW[(toVal(c,ETW)+p2>=ETWN)?(toVal(c,ETW)+p2-ETWN):(toVal(c,ETW)+p2)];
		c = ETW[(toVal(c,ETW)-r2<0)?(toVal(c,ETW)-r2+ETWN):(toVal(c,ETW)-r2)];
		c = rotor(rotor2,c,r2,false);
		GUI2_1.lblline9.setBounds(719, 296-10*((ETWN-toVal(c,ETW)+p2>ETWN)?(-toVal(c,ETW)+p2):(ETWN-toVal(c,ETW)+p2)), 90, 1);
		c = ETW[(toVal(c,ETW)-p2<0)?(toVal(c,ETW)-p2+ETWN):(toVal(c,ETW)-p2)];
		c = ETW[(toVal(c,ETW)+p1>=ETWN)?(toVal(c,ETW)+p1-ETWN):(toVal(c,ETW)+p1)];
		c = ETW[(toVal(c,ETW)-r1<0)?(toVal(c,ETW)-r1+ETWN):(toVal(c,ETW)-r1)];
		c = rotor(rotor1,c,r1,false);
		GUI2_1.lblline10.setBounds(924, 296-10*((ETWN-toVal(c,ETW)+p1>ETWN)?(-toVal(c,ETW)+p1):(ETWN-toVal(c,ETW)+p1)), 80, 1);
		c = ETW[(toVal(c,ETW)-p1<0)?(toVal(c,ETW)-p1+ETWN):(toVal(c,ETW)-p1)];
		GUI2_1.lblVVV.setBounds(1085, 296-10*(ETWN-toVal(pB(c),ETW)), 8, 87+10*(ETWN-toVal(pB(c),ETW)));
		GUI2_1.lblline12.setBounds(984, 296-10*(ETWN-toVal(pB(c),ETW)), 107, 1);
		GUI2_1.label_7.setBounds(410, 380, 8, 50);
		GUI2_1.label_10.setBounds(410, 380, 683, 8);
		return c;
}
//public static void main(String[] args) {
//	System.out.print(pB("BAXY"));
//}
}
