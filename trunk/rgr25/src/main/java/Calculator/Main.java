package Calculator;

import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		
		JFrame Main_Frame = new JFrame("Frame");
		Main_Frame.setTitle("Лучший калькулятор");
		Main_Frame.setBounds(500, 400, 600, 400);
		Main_Frame.setResizable(false);
		
		JPanel Main_Panel = new JPanel();
		Main_Panel.setLayout(null);
		Main_Frame.add(Main_Panel);
		
		JLabel FirstLabel = new JLabel("Общая сумма кредита");
		Main_Panel.add(FirstLabel);
		FirstLabel.setBounds(20, 80, 260, 20);
		FirstLabel.setVisible(true);
		JTextField FirstField = new JTextField();
		Main_Panel.add(FirstField);
		FirstField.setBounds(20, 100, 260, 20);
		FirstField.setVisible(true);
		JLabel SecondLabel = new JLabel("Срок кредитования в месяцах");
		Main_Panel.add(SecondLabel);
		SecondLabel.setBounds(20, 120, 260, 20);
		SecondLabel.setVisible(true);
		JTextField SecondField = new JTextField();
		Main_Panel.add(SecondField);
		SecondField.setBounds(20, 140, 260, 20);
		SecondField.setVisible(true);
		JLabel ThirdLabel = new JLabel("Месячная ставка по кредиту");
		Main_Panel.add(ThirdLabel);
		ThirdLabel.setBounds(20, 160, 260, 20);
		ThirdLabel.setVisible(true);
		JTextField ThirdField = new JTextField();
		Main_Panel.add(ThirdField);
		ThirdField.setBounds(20, 180, 260, 20);
		ThirdField.setVisible(true);
		JLabel FourthLabel = new JLabel("Ежемесячный взнос по ипотеке:");
		Main_Panel.add(FourthLabel);
		FourthLabel.setBounds(320, 100, 260, 20);
		FourthLabel.setVisible(true);
		JLabel FifthLabel = new JLabel("");
		Main_Panel.add(FifthLabel);
		FifthLabel.setBounds(320, 120, 260, 20);
		FifthLabel.setVisible(false);
		JLabel SixthLabel = new JLabel("Общая сумма кредита с процентами:");
		Main_Panel.add(SixthLabel);
		SixthLabel.setBounds(320, 140, 260, 20);
		SixthLabel.setVisible(true);
		JLabel SeventhLabel = new JLabel("");
		Main_Panel.add(SeventhLabel);
		SeventhLabel.setBounds(320, 160, 260, 20);
		SeventhLabel.setVisible(false);
		
		JButton Information = new JButton("Информация");
		Information.setBounds(20, 300, 120, 30);
		Main_Panel.add(Information);
		Information.setVisible(true);
		ActionListener InforListener = new Information();
		Information.addActionListener(InforListener);
		
		JButton Calculated = new JButton("Расчитать");
		Calculated.setBounds(160, 300, 120, 30);
		Main_Panel.add(Calculated);
		Calculated.setVisible(true);
		
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
