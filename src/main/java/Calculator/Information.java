package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Information implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String message = "��� � ������ �������� ������\n";
        message += "-------------------------------\n";
        message += "���������� ������� | 20150096\n";
        message += "������ ������� | 20130087\n";
        message += "������� ������� | 20130485\n";
        
        JOptionPane.showMessageDialog(null, message , "���������" , JOptionPane.PLAIN_MESSAGE);
    }
}
