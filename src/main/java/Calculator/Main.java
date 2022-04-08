package Calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		
		JFrame Main_Frame = new JFrame("Frame");
		Main_Frame.setTitle("Лучший калькулятор");
		Main_Frame.setBounds(500, 400, 600, 400);
		Main_Frame.setResizable(false);
	
		JPanel Main_Panel = new JPanel();
		Main_Panel.setLayout(null);
		Main_Frame.add(Main_Panel);
		
		
		Font shrift = new Font ("TimesRoman", Font.BOLD, 14);
		
		JLabel FirstLabel = new JLabel("Общая сумма кредита");
		Main_Panel.add(FirstLabel);
		FirstLabel.setBounds(20, 80, 260, 20);
		FirstLabel.setVisible(true);
		FirstLabel.setFont(shrift);
		final JTextField FirstField = new JTextField("");
		Main_Panel.add(FirstField);
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
		JLabel SecondLabel = new JLabel("Срок кредитования в месяцах");
		Main_Panel.add(SecondLabel);
		SecondLabel.setBounds(20, 120, 260, 20);
		SecondLabel.setVisible(true);
		SecondLabel.setFont(shrift);
		final JTextField SecondField = new JTextField("");
		Main_Panel.add(SecondField);
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
		JLabel ThirdLabel = new JLabel("Годовая ставка по кредиту");
		Main_Panel.add(ThirdLabel);
		ThirdLabel.setBounds(20, 160, 260, 20);
		ThirdLabel.setVisible(true);
		ThirdLabel.setFont(shrift);
		final JTextField ThirdField = new JTextField("");
		Main_Panel.add(ThirdField);
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
		JLabel FourthLabel = new JLabel("Ежемесячный взнос по ипотеке:");
		Main_Panel.add(FourthLabel);
		FourthLabel.setBounds(320, 100, 260, 20);
		FourthLabel.setVisible(true);
		FourthLabel.setFont(shrift);
		final JLabel FifthLabel = new JLabel("");
		Main_Panel.add(FifthLabel);
		FifthLabel.setBounds(320, 120, 260, 20);
		FifthLabel.setVisible(false);
		FifthLabel.setFont(shrift);
		JLabel SixthLabel = new JLabel("Общая сумма кредита с процентами:");
		Main_Panel.add(SixthLabel);
		SixthLabel.setBounds(320, 140, 260, 20);
		SixthLabel.setVisible(true);
		SixthLabel.setFont(shrift);
		final JLabel SeventhLabel = new JLabel("");
		Main_Panel.add(SeventhLabel);
		SeventhLabel.setBounds(320, 160, 260, 20);
		SeventhLabel.setVisible(false);
		SeventhLabel.setFont(shrift);
		
		JButton Information = new JButton("Информация");
		Information.setBounds(20, 300, 120, 30);
		Main_Panel.add(Information);
		Information.setVisible(true);
		
		ActionListener InforListener = new Information();
		Information.addActionListener(InforListener);
		
		class Raschet extends Main implements ActionListener {

			private double A;

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String S_stroka = FirstField.getText();
				//Integer S = Integer.parseInt(S_stroka);
				String M_stroka = SecondField.getText();
				//Integer M = Integer.parseInt(M_stroka);
				String P_stroka = ThirdField.getText();
				//float P = Integer.parseInt(P_stroka);
				try {
					Integer S = Integer.parseInt(S_stroka);
					Integer M = Integer.parseInt(M_stroka);
					float P = Integer.parseInt(P_stroka);
					P = (float) P / 1200;
					 A = S * P / ( 1 - Math.pow(1 + P, -M));
					 A = Math.ceil(A);
					 double H = A * M;
					SeventhLabel.setText("" + H);
					FifthLabel.setText("" + A);
					FifthLabel.setVisible(true);
					SeventhLabel.setVisible(true);
				} catch(NumberFormatException b) {
					JOptionPane.showMessageDialog(null, "Ошибка при обработке вводных данных.\n Скорректируйте данные." , "Сообщение" , JOptionPane.PLAIN_MESSAGE);
				}
			}
			
		}
		
		JButton Calculated = new JButton("Расчитать");
		Calculated.setBounds(160, 300, 120, 30);
		Main_Panel.add(Calculated);
		Calculated.setVisible(true);
		ActionListener Calculat = new Raschet();
		Calculated.addActionListener(Calculat);
		
		JButton Exit = new JButton("Выход");
		Exit.setBounds(460, 300, 100, 30);
		Main_Panel.add(Exit);
		Exit.setVisible(true);
		ActionListener ExitListener = new ExitButton();
		Exit.addActionListener(ExitListener);
		
		Main_Frame.setVisible(true);
		Main_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
