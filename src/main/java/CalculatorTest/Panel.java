package CalculatorTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import CalculatorTest.createTemplate;


import CalculatorTest.PDFButton.Receipt;



public final class Panel extends JPanel {


	/**
	 * 
	 */
	static int FONT_SIZE_SMALL = 16;
	 static int FONT_SIZE_BIG = 32;
	 static int OFFSET = 40;
	public String S_stroka;
	public String P_stroka;
	public String M_stroka;
	private static final long serialVersionUID = 1L;
	private double S;
	private double P;
	private double P_m;
	private double M;
	private double H;
	
	//������
	JLabel Hello = new JLabel("����� ���������� � ��������� ����������� ��� ����������� ���!");
	JLabel FirstLabel = new JLabel("����� ����� �������");
	JLabel SecondLabel = new JLabel("���� ������������ � �������");
	JLabel ThirdLabel = new JLabel("������� ������ �� �������");
	JLabel FourthLabel = new JLabel("����������� ����� �� �������:");
	JLabel FifthLabel = new JLabel("");
	JLabel SeventhLabel = new JLabel("");
	JLabel SixthLabel = new JLabel("����� ����� ������� � ����������:");
	JButton Information = new JButton("����������");
	JTextField ThirdField = new JTextField("");
	JTextField FirstField = new JTextField("");
	JTextField SecondField = new JTextField("");
	JButton Exit = new JButton("�����");
	JButton Calculated = new JButton("���������");
	JButton PDF = new JButton("������������� PDF");
	
	JLabel AuthorLabel = new JLabel("�����������");
	JLabel LoginLabel = new JLabel("�����");
	JLabel PasswordLabel = new JLabel("������");
	JTextField LoginTest = new JTextField("������� �����");
	JTextField PasswordTest = new JTextField("������� ������");
	JButton Enter = new JButton("�����");
	
	public static void fillInReceipt(Receipt receipt) 
            throws Exception {
        PdfReader reader = new PdfReader(
            new FileInputStream("template.pdf"));
        PdfStamper stamper = new PdfStamper(reader, 
                new FileOutputStream("��������������� ��������.pdf"));

        PdfContentByte stream = stamper.getOverContent(1);
        stream.beginText();
        stream.setColorFill(BaseColor.BLUE);

        BaseFont font = BaseFont.createFont();

        float pageWidth = reader.getPageSize(1).getWidth();
        stream.setFontAndSize(font, FONT_SIZE_SMALL);
        float v = stream.getEffectiveStringWidth(
            receipt.getPurpose(), false);

        float fitSize = (pageWidth-OFFSET*2) * FONT_SIZE_SMALL/v;
        stream.setFontAndSize(font, fitSize);
        stream.setTextMatrix(OFFSET, 680);
        stream.showText(receipt.getPurpose());

        stream.setFontAndSize(font, FONT_SIZE_SMALL);

        String amount = NumberFormat.getCurrencyInstance()
                .format(receipt.getAmount());
        v = stream.getEffectiveStringWidth(amount, false);
        stream.setTextMatrix(pageWidth - v - OFFSET, 630);
        stream.showText(amount);

        v = stream.getEffectiveStringWidth(
                receipt.getDate() + "", false);
        stream.setTextMatrix(pageWidth - v - OFFSET, 605);
        stream.showText(receipt.getDate() + "");

        v = stream.getEffectiveStringWidth(
                receipt.getName(), false);
        stream.setTextMatrix(pageWidth - v - OFFSET, 580);
        stream.showText(receipt.getName());

        stream.endText();
        stamper.setFullCompression();
        stamper.close();
    }
	public Panel() {
		
		
		
		setLayout(null);
		// ������
		Font shrift = new Font ("TimesRoman", Font.BOLD, 14);
		Font shrift1 = new Font ("TimesRoman", Font.BOLD, 16);
		
	    //�����������
	    add(Hello);
	    Hello.setBounds(20,5,550,20);
	    Hello.setVisible(false);
	    Hello.setFont(shrift1);
	    
	    add(AuthorLabel);
	    add(LoginLabel);
	    add(PasswordLabel);
	    add(LoginTest);
	    add(PasswordTest);
	    add(Enter);
	    
	    AuthorLabel.setBounds(200, 10, 120, 30);
	    AuthorLabel.setVisible(true);
	    AuthorLabel.setFont(shrift);
	    
	    LoginLabel.setBounds(40, 50, 120, 30);
	    LoginLabel.setVisible(true);
	    LoginLabel.setFont(shrift);
	    
	    PasswordLabel.setBounds(40, 150, 120, 30);
	    PasswordLabel.setVisible(true);
	    PasswordLabel.setFont(shrift);
	    
	    LoginTest.setBounds(40, 100, 200, 30);
	    LoginTest.setVisible(true);
	    LoginTest.setFont(shrift);
	    
	    PasswordTest.setBounds(40, 200, 200, 30);
	    PasswordTest.setVisible(true);
	    PasswordTest.setFont(shrift);
	    
	    Enter.setBounds(200, 250, 120, 30);
	    Enter.setVisible(true);
	    Enter.setFont(shrift);
	    
	    
		//����� ����� �������
		add(FirstLabel);
		FirstLabel.setBounds(20, 80, 260, 20);
		FirstLabel.setVisible(false);
		FirstLabel.setFont(shrift);
		add(FirstField);
		FirstField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
			public void keyPressed(KeyEvent e) {	
			}
			public void keyReleased(KeyEvent e) {	
			}
        });
		FirstField.setBounds(20, 100, 260, 20);
		FirstField.setVisible(false);
		
	    //���� ������������
		add(SecondLabel);
		SecondLabel.setBounds(20, 120, 260, 20);
		SecondLabel.setVisible(false);
		SecondLabel.setFont(shrift);
		
		add(SecondField);
		SecondField.setBounds(20, 140, 260, 20);
		SecondField.setVisible(false);
		SecondField.addKeyListener(new KeyListener() {
        	
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
			public void keyPressed(KeyEvent e) {	
			}
			public void keyReleased(KeyEvent e) {	
			}
        });
		
		//������� ������
		add(ThirdLabel);
		ThirdLabel.setBounds(20, 160, 260, 20);
		ThirdLabel.setVisible(false);
		ThirdLabel.setFont(shrift);

		add(ThirdField);
		ThirdField.setBounds(20, 180, 260, 20);
		ThirdField.setVisible(false);
		ThirdField.addKeyListener(new KeyListener() {
        	
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
			public void keyPressed(KeyEvent e) {	
			}
			public void keyReleased(KeyEvent e) {	
			}
        });
		
	    //����������� �����
		add(FourthLabel);
		FourthLabel.setBounds(320, 100, 260, 20);
		FourthLabel.setVisible(false);
		FourthLabel.setFont(shrift);
		FourthLabel.setForeground(Color.BLACK);
		//����� ������������ ������
		add(FifthLabel);
		FifthLabel.setBounds(320, 120, 260, 20);
		FifthLabel.setVisible(false);
		FifthLabel.setFont(shrift1);
		FifthLabel.setForeground(Color.BLACK);
		//����� �����
		add(SixthLabel);
		SixthLabel.setBounds(320, 150, 300, 20);
		SixthLabel.setVisible(false); // ������ ���� false
		SixthLabel.setFont(shrift);
		SixthLabel.setForeground(Color.BLACK);
		// ����� ����� �����
		add(SeventhLabel);
		SeventhLabel.setBounds(320, 170, 260, 20);
		SeventhLabel.setVisible(false);
		SeventhLabel.setFont(shrift1);
		SeventhLabel.setForeground(Color.BLACK);
		//����������
		add(Information);
		Information.setBounds(20, 300, 120, 30);
		add(Information);
		Information.setVisible(false);
		
		ActionListener InforListener = new Information();
		Information.addActionListener(InforListener);
		
		
		
		class Raschet extends Main implements ActionListener {

			private double A;

			public void actionPerformed(ActionEvent e) {
				
				
				S_stroka = FirstField.getText();
				//Integer S = Integer.parseInt(S_stroka);
				M_stroka = SecondField.getText();
				//Integer M = Integer.parseInt(M_stroka);
				P_stroka = ThirdField.getText();
				//float P = Integer.parseInt(P_stroka);
				try {
					S = Integer.parseInt(S_stroka);
					M = Integer.parseInt(M_stroka);
					P = Integer.parseInt(P_stroka);
					P_m = (double) P / 1200;
					
					Double step = Math.pow(1 + P_m, M);
					Double verx = P_m * step;
					Double niz = step - 1;
					Double annut = verx / niz;
					A = S * annut;
					//A = S * P_m / ( 1 + Math.pow(1 + P_m, -M) - 1);
					// A = (S * P_m) / (1 - (1 + P_m) * (1 - M));
					 A = Math.ceil(A);
					 H = A * M;
					 
					SeventhLabel.setText("" + H +"   ���.");
					FifthLabel.setText("" + A);
					FifthLabel.setVisible(true);
					SeventhLabel.setVisible(true);
					
					DecimalFormat df = new DecimalFormat("###.##");
					FifthLabel.setText(df.format(A)+"   ���.");
				} catch(NumberFormatException b) {
					JOptionPane.showMessageDialog(null, "������ ��� ��������� ������� ������.\n �������������� ������." , "���������" , JOptionPane.PLAIN_MESSAGE);
				}
				Receipt receipt = new Receipt(
		                "Total mortgage amount = " + S + 
		                "  Repayment time in months  =" + M +
		                "  Mortgage interest =" + P,
		                H,
		                "Name Surname");
				try {
					fillInReceipt(receipt);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "" , "���������" , JOptionPane.PLAIN_MESSAGE);
					e1.printStackTrace();
				}
				//DecimalFormat df = new DecimalFormat("###.##");
				//FifthLabel.setText(df.format(getResult())+"   ���.");
				}
			
		
		}
		
		Calculated.setBounds(160, 300, 120, 30);
		add(Calculated);
		Calculated.setVisible(false);
		ActionListener Calculat = new Raschet();
		Calculated.addActionListener(Calculat);
		
		Exit.setBounds(460, 300, 100, 30);
		add(Exit);
		Exit.setVisible(true);
		ActionListener ExitListener = new ExitButton();
		Exit.addActionListener(ExitListener);
		
		PDF.setBounds(300, 300, 120, 30);
		add(PDF);
		PDF.setVisible(false);
		ActionListener PDFListener = new PDFButton();
		PDF.addActionListener(PDFListener);
		
		class Authorization extends Main implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String Login;
				String Password;
				
				String AdminLog = "Admin";
				String AdminPas = "Admin";
				
				String PremiumLog = "PremiumUser";
				String PremiumPas = "Premium";
				
				String UserLog = "User";
				String UserPas = "123";
			
				Login = LoginTest.getText();
				Password = PasswordTest.getText();
				
				if (Login.equals(AdminLog) == true) {
					if (Password.equals(AdminPas) == true) {
						
						AuthorLabel.setVisible(false);
						LoginLabel.setVisible(false);
						PasswordLabel.setVisible(false);
						LoginTest.setVisible(false);
						PasswordTest.setVisible(false);
						Enter.setVisible(false);
						
						
						
						FirstLabel.setVisible(true);
						SecondLabel.setVisible(true);
						ThirdLabel.setVisible(true);
						FourthLabel.setVisible(true);
						SixthLabel.setVisible(true);
						Information.setVisible(true);
						FirstField.setVisible(true);
						SecondField.setVisible(true);
						ThirdField.setVisible(true);
						Calculated.setVisible(true);
						PDF.setVisible(true);
						Hello.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(null, "�������� ������" , "���������" , JOptionPane.PLAIN_MESSAGE);
					}
					
				} else if (Login.equals(PremiumLog) == true) {
					if (Password.equals(PremiumPas) == true) {
						JOptionPane.showMessageDialog(null, "��� ����������� �������� PDF �����, ������� ������� �� ������ �������������,\n � ����� ��������� ���������� ������� ���������" , "���������" , JOptionPane.PLAIN_MESSAGE);
						AuthorLabel.setVisible(false);
						LoginLabel.setVisible(false);
						PasswordLabel.setVisible(false);
						LoginTest.setVisible(false);
						PasswordTest.setVisible(false);
						Enter.setVisible(false);
						
						FirstLabel.setVisible(true);
						SecondLabel.setVisible(true);
						ThirdLabel.setVisible(true);
						FourthLabel.setVisible(true);
						SixthLabel.setVisible(true);
						FirstField.setVisible(true);
						SecondField.setVisible(true);
						ThirdField.setVisible(true);
						Calculated.setVisible(true);
						PDF.setVisible(true);
						Hello.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(null, "�������� ������" , "���������" , JOptionPane.PLAIN_MESSAGE);
					}
					
					
				} else if (Login.equals(UserLog) == true) {
					if (Password.equals(UserPas) == true) {
						JOptionPane.showMessageDialog(null, "�������� ����������� �������� ������� ������ ����� �� 4.99$\n � �������� ������ � ����������� ���������� ����� ����������" , "���������" , JOptionPane.PLAIN_MESSAGE);
						AuthorLabel.setVisible(false);
						LoginLabel.setVisible(false);
						PasswordLabel.setVisible(false);
						LoginTest.setVisible(false);
						PasswordTest.setVisible(false);
						Enter.setVisible(false);
						
						FirstLabel.setVisible(true);
						SecondLabel.setVisible(true);
						ThirdLabel.setVisible(true);
						FourthLabel.setVisible(true);
						SixthLabel.setVisible(true);
						FirstField.setVisible(true);
						SecondField.setVisible(true);
						ThirdField.setVisible(true);
						Calculated.setVisible(true);
						Hello.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(null, "�������� ������" , "���������" , JOptionPane.PLAIN_MESSAGE);
					}
					
					
				} else {
					JOptionPane.showMessageDialog(null, "�������� �����" , "���������" , JOptionPane.PLAIN_MESSAGE);	
				}
				
				
			}
	    	
	    }
	    
	    ActionListener authorization = new Authorization();
	    Enter.addActionListener(authorization);
		
		
	}
	
	public void setS(double S) {
    	this.S = S;
    }	    

    public void setM(double M) {
    	this.M = M;
    }	   
  
    public void setP(double P) {
    	this.P = P;
    	
    }
    public double getP() {
    	return this.P;
    }	    

    public double getS() {
    	
    	return this.S;
    }	    

    public double getM() {
    	return this.M;
    }
    public double getResult() {            
        if (getM() == 0) {
        	SeventhLabel.setText("������� ���������� ��������");
        	SeventhLabel.setForeground(Color.RED);
        	//System.out.println("");
        	//JOptionPane.showMessageDialog(null,"������� ���������� ��������");
        	return 0;
        } else if (getP() > getS()) {
        	JOptionPane.showMessageDialog(null,"");
        	return 0;
        } 
    	return ((getS() * getP()) / ( 1 - Math.pow(1 + (getP()), -(getM()) )));
    }


	
}