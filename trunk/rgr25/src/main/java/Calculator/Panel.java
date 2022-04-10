package Calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public final class Panel extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double S;
	private double P;
	private double M;
	
	//������
	JLabel FirstLabel = new JLabel("����� ����� �������");
	JLabel SecondLabel = new JLabel("���� ������������ � �������");
	JLabel ThirdLabel = new JLabel("������� ������ �� �������");
	JLabel FourthLabel = new JLabel("����������� ����� �� �������:");
	JLabel FifthLabel = new JLabel("");
	JLabel SeventhLabel = new JLabel("");
	JLabel SixthLabel = new JLabel("����� ����� ������� � ����������:");
	
	public Panel() {
		
		
		
		setLayout(null);
		// ������
		Font shrift = new Font ("TimesRoman", Font.BOLD, 14);
		Font shrift1 = new Font ("TimesRoman", Font.BOLD, 16);
		
	    //�����������
	    final JLabel Hello = new JLabel("����� ���������� � ��������� ����������� ��� ����������� ���!");
	    add(Hello);
	    Hello.setBounds(20,5,550,20);
	    Hello.setVisible(true);
	    Hello.setFont(shrift1);
	    
		//����� ����� �������
		add(FirstLabel);
		FirstLabel.setBounds(20, 80, 260, 20);
		FirstLabel.setVisible(true);
		FirstLabel.setFont(shrift);
		final JTextField FirstField = new JTextField("");
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
		FirstField.setVisible(true);
		
	    //���� ������������
		add(SecondLabel);
		SecondLabel.setBounds(20, 120, 260, 20);
		SecondLabel.setVisible(true);
		SecondLabel.setFont(shrift);
		
		final JTextField SecondField = new JTextField("");
		add(SecondField);
		SecondField.setBounds(20, 140, 260, 20);
		SecondField.setVisible(true);
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
		ThirdLabel.setVisible(true);
		ThirdLabel.setFont(shrift);
		final JTextField ThirdField = new JTextField("");
		add(ThirdField);
		ThirdField.setBounds(20, 180, 260, 20);
		ThirdField.setVisible(true);
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
		FourthLabel.setVisible(true);
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
		SixthLabel.setVisible(true);
		SixthLabel.setFont(shrift);
		SixthLabel.setForeground(Color.BLACK);
		// ����� ����� �����
		add(SeventhLabel);
		SeventhLabel.setBounds(320, 170, 260, 20);
		SeventhLabel.setVisible(false);
		SeventhLabel.setFont(shrift1);
		SeventhLabel.setForeground(Color.BLACK);
		//����������
		JButton Information = new JButton("����������");
		Information.setBounds(20, 300, 120, 30);
		add(Information);
		Information.setVisible(true);
		
		ActionListener InforListener = new Information();
		Information.addActionListener(InforListener);
		
		class Raschet extends Main implements ActionListener {

			private double A;

			public void actionPerformed(ActionEvent e) {	
				String S_stroka = FirstField.getText();
				//Integer S = Integer.parseInt(S_stroka);
				String M_stroka = SecondField.getText();
				//Integer M = Integer.parseInt(M_stroka);
				String P_stroka = ThirdField.getText();
				//float P = Integer.parseInt(P_stroka);
				try {
					S = Integer.parseInt(S_stroka);
					M = Integer.parseInt(M_stroka);
					P = Integer.parseInt(P_stroka);
					P = (double) P / 1200;
					 A = S * P / ( 1 - Math.pow(1 + P, -M));
					 A = Math.ceil(A);
					 double H = A * M;
					SeventhLabel.setText("" + H +"   ���.");
					//FifthLabel.setText("" + A);
					FifthLabel.setVisible(true);
					SeventhLabel.setVisible(true);
				} catch(NumberFormatException b) {
					JOptionPane.showMessageDialog(null, "������ ��� ��������� ������� ������.\n �������������� ������." , "���������" , JOptionPane.PLAIN_MESSAGE);
				}
				DecimalFormat df = new DecimalFormat("###.##");
				FifthLabel.setText(df.format(getResult())+"   ���.");
			}
			
		}
		
		JButton Calculated = new JButton("���������");
		Calculated.setBounds(160, 300, 120, 30);
		add(Calculated);
		Calculated.setVisible(true);
		ActionListener Calculat = new Raschet();
		Calculated.addActionListener(Calculat);
		
		JButton Exit = new JButton("�����");
		Exit.setBounds(460, 300, 100, 30);
		add(Exit);
		Exit.setVisible(true);
		ActionListener ExitListener = new ExitButton();
		Exit.addActionListener(ExitListener);
		
		
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
    	return P;
    }	    

    public double getS() {
    	return S;
    }	    

    public double getM() {
    	return M;
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