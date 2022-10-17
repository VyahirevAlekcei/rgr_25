package CalculatorTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import CalculatorTest.PDFButton.Receipt;
import CalculatorTest.Panel;
public class PDFButton implements ActionListener {
	

	
	
	
	static int FONT_SIZE_SMALL = 16;
	 static int FONT_SIZE_BIG = 32;
	 static int OFFSET = 40;
	
	public void actionPerformed(ActionEvent e) {
		try {
			createTemplate();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			//S = panel.getS();
			//P = panel.getP();
			//M = panel.getM();
			//P = (double) P / 1200;
		} catch(NumberFormatException b) {
			//JOptionPane.showMessageDialog(null, "Ошибка при обработке вводных данных.\n Скорректируйте данные." , "Сообщение" , JOptionPane.PLAIN_MESSAGE);
		}
	    	
	}
	
	public static void createTemplate() throws Exception {
        Document document = new Document();

        Font font1 = new Font(Font.FontFamily.HELVETICA, 
                FONT_SIZE_BIG, Font.BOLD);
        Font font2 = new Font(Font.FontFamily.HELVETICA, 
                FONT_SIZE_SMALL, Font.ITALIC | Font.UNDERLINE);

        PdfWriter.getInstance(document, 
                new FileOutputStream("template.pdf"));

        document.open();

        // отцентрированный параграф
        Paragraph title = new Paragraph("Given by mortgage", font1);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(FONT_SIZE_BIG);
        document.add(title);

        // параграф с текстом
        Paragraph purpose = new Paragraph("General data", font2);
        purpose.setSpacingAfter(FONT_SIZE_BIG);
        document.add(purpose);

        // параграф с добавленным чанком текста
        Paragraph amount = new Paragraph();
        amount.setFont(font2);
        amount.setSpacingAfter(8);
        amount.add(new Chunk("\r\n"
        		+ "Amount to be paid"));
        document.add(amount);

        // параграф с фразой, в которую добавлен чанк
        Paragraph date = new Paragraph();
        date.setFont(font2);
        Phrase phrase = new Phrase();
        phrase.add(new Chunk("Date"));
        date.add(phrase);
        document.add(date);

        document.add(new Paragraph("Name", font2));

        Paragraph footer = new Paragraph(
            "Important - please retain for your records - ");


        document.close();
    }
 
 static class Receipt {
        private String purpose;
        private double amount;
        private Date date = new Date();
        private String name;

        public Receipt(String purpose, double amount, String name) {
            this.purpose = purpose;
            this.amount = amount;
            this.name = name;
        }

        public String getPurpose() { return purpose;}
        public void setPurpose(String purpose) { 
            this.purpose = purpose; 
        }

        public double getAmount() { return amount; }
        public void setAmount(double amount) { 
            this.amount = amount; 
        }

        public Date getDate() { return date; }
        public void setDate(Date date) { this.date = date; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

}
