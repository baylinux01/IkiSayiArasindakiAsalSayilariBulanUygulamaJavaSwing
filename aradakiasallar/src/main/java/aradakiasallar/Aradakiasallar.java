package aradakiasallar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Aradakiasallar extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JLabel lb1;
	private JLabel lb2;
	private JScrollPane sp1;
	private JEditorPane ep1;
	private String str;
	private String str2;
	private String s;
	private String s2;
	private long deger;
	private long deger2;
	private int count;
	private long num1;
	private long num2;
	private JButton btn;
	private Robot robot;
	
	
	public static boolean isSpacedEnded(String s)
	{
		return s!=null && Character.isWhitespace(s.charAt(s.length()-1));
	}
	
	public boolean isFractional(String s) {  
	    return s != null && (s.matches("[-+]?\\d+\\.+") || s.matches("[-+]?\\d+[^0-9.]") || s.matches("[-+]?\\d+\\.+0*[1-9]*+[^0-9]+"));  
	}  
	
	public boolean isFractionalNumeric(String s) {  
	    return s != null && (s.matches("[-+]?\\d+\\.+0*[1-9]+"));  
	}  
	
	public boolean isExactNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?0*");  
	}  
	
	public boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  

	public void aradakiAsallariBul() 
	{
		try {
			s=tf1.getText();
			 while(isSpacedEnded(s)) s=s.substring(0,s.length()-1);
			 str=s;
			 if(s.contains(".")) s=s.split("[.]")[0];
			 
			 s2=tf2.getText();
			 while(isSpacedEnded(s2)) s2=s2.substring(0,s2.length()-1);
			 str2=s2;
			 if(s2.contains(".")) s2=s2.split("[.]")[0];
			 
		
			 deger= Long.valueOf(s);
			 deger2= Long.valueOf(s2);
			 
			 
		} catch (NumberFormatException f) {
 
		}
		
		if(deger>=deger2) {num2=deger; num1=deger2;}
		else 			  {num1=deger; num2=deger2;}
		
		if(num1<0 || num2<0) {ep1.setText("Girdiğiniz sayılardan biri sıfır veya sıfırdan küçüktür\nHatalı değer");}
		
		
		
		
		ArrayList<Long> longdizi=new ArrayList<Long>();
		for(long i=num1;i<num2+1;i++) 
		{   
			
			if (i<2)  {}
		    if (i==2) {longdizi.add((long) 2);}
		    if(i>2) 
		    {
		    	count=0;
				for(long j=2;j<i;j++) 
				{
					if(i%j==0) {count++; break;}
				}
				if(count==0) longdizi.add(i);
		    }
		    
	    }
		ep1.setText("Sınırlar dahil girdiğiniz girdiğiniz iki sayı \narasındaki " +longdizi.size()+ " adet asal sayı aşağıdadır \n");
		for(int i=0;i<longdizi.size();i++)
		{
			ep1.setText(ep1.getText()+longdizi.get(i)+"\n");
		}
		
     
		if  (str.equals("") || str2.equals(""))  {ep1.setText("");}
		else if  ( isFractional(str) && isFractional(str2))    {ep1.setText("Girdiğiniz iki değer de bir sayı değildir\nHatalı değer");}
		else if  ( isFractional(str) && isFractionalNumeric(str2) )    {ep1.setText("Girdiğiniz birinci değer bir sayı değildir\nVe\nGirdiğiniz ikinci değer küsuratlıdır\nHatalı değer");}
		else if  ( isFractional(str2) && isFractionalNumeric(str) )    {ep1.setText("Girdiğiniz birinci değer küsuratlıdır\nVe\nGirdiğiniz ikinci değer bir sayı değildir\nHatalı değer");}
		else if  ( isFractionalNumeric(str) && isFractionalNumeric(str2) )    {ep1.setText("Girdiğiniz birinci değer küsuratlıdır\nVe\nGirdiğiniz ikinci değer küsuratlıdır\nHatalı değer");}
		else if  ( !isExactNumeric(str) && isFractionalNumeric(str2) )    {ep1.setText("Girdiğiniz birinci değer tam sayı değildir\nVe\nGirdiğiniz ikinci değer küsuratlıdır\nHatalı değer");}
		else if  ( !isExactNumeric(str2) && isFractionalNumeric(str) )    {ep1.setText("Girdiğiniz birinci değer küsuratlıdır\nVe\nGirdiğiniz ikinci değer tam sayı değildir\nHatalı değer");}
		else if  ( isFractional(str))    {ep1.setText("Girdiğiniz birinci değer bir sayı değildir\nHatalı değer");}
		else if  ( isFractional(str2))    {ep1.setText("Girdiğiniz ikinci değer bir sayı değildir\nHatalı değer");} 
		else if  (isFractionalNumeric(str) && isFractionalNumeric(str2) )    {ep1.setText("Girdiğiniz iki değer de küsuratlıdır\nHatalı değer");}
		else if  (isFractionalNumeric(str) )    {ep1.setText("Girdiğiniz birinci değer küsuratlıdır\nHatalı değer");}
		else if  (isFractionalNumeric(str2) )    {ep1.setText("Girdiğiniz ikinci değer küsuratlıdır\nHatalı değer");} 
		else if  (!isExactNumeric(str) && !isExactNumeric(str2))    {ep1.setText("Girdiğiniz iki değer de tam sayı değildir\nHatalı değer");}
		else if  (!isExactNumeric(str))    {ep1.setText("Girdiğiniz birinci değer tam sayı değildir\nHatalı değer");}
		else if  (!isExactNumeric(str2))    {ep1.setText("Girdiğiniz ikinci değer tam sayı değildir\nHatalı değer");} 
		
		
		
}
	DocumentListener dl=new DocumentListener() 
	{

		public void insertUpdate(DocumentEvent e) {
			
			if(Pattern.matches("[^1-9]+",tf1.getText())) 
			{
	
				tf1.requestFocus();
				tf1.setCaretPosition(1); 
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			
			if(Pattern.matches("[^1-9]+",tf2.getText())) 
			{
	
				tf2.requestFocus();
				tf2.setCaretPosition(1); 
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			if(tf1.getText().equals(" ")) tf1.setText("");
			if(tf2.getText().equals(" ")) tf2.setText("");
			if(tf1.getText().equals("") || tf2.getText().equals("")) ep1.setText("");
			if(!tf1.getText().equals("") && !tf2.getText().equals(""))
			{
				aradakiAsallariBul();
			}
			
		}

		public void removeUpdate(DocumentEvent e) {
			
			if(Pattern.matches("[^1-9]+",tf1.getText())) 
			{
	
				tf1.requestFocus();
				tf1.setCaretPosition(1); 
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			
			if(Pattern.matches("[^1-9]+",tf2.getText())) 
			{
	
				tf2.requestFocus();
				tf2.setCaretPosition(1); 
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			if(tf1.getText().equals(" ")) tf1.setText("");
			if(tf2.getText().equals(" ")) tf2.setText("");
			if(tf1.getText().equals("") || tf2.getText().equals("")) ep1.setText("");
			if(!tf1.getText().equals("") && !tf2.getText().equals(""))
			{
				aradakiAsallariBul();
			}
			
		}

		public void changedUpdate(DocumentEvent e) {
			
			if(Pattern.matches("[^1-9]+",tf1.getText())) 
			{
	
				tf1.requestFocus();
				tf1.setCaretPosition(1); 
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			
			if(Pattern.matches("[^1-9]+",tf2.getText())) 
			{
	
				tf2.requestFocus();
				tf2.setCaretPosition(1); 
				try {
					robot=new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					
				}
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
			}
			if(tf1.getText().equals(" ")) tf1.setText("");
			if(tf2.getText().equals(" ")) tf2.setText("");
			if(tf1.getText().equals("") || tf2.getText().equals("")) ep1.setText("");
			if(!tf1.getText().equals("") && !tf2.getText().equals(""))
			{
				aradakiAsallariBul();
			}
			
		}
		
	};
	
	ActionListener al=new ActionListener() 
	{

		public void actionPerformed(ActionEvent e) {
			aradakiAsallariBul();
			
		}
		
	};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aradakiasallar frame = new Aradakiasallar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aradakiasallar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lb1=new JLabel("Birinci sayıyı giriniz");
		lb1.setSize(200,20);
		lb1.setLocation(10,80);
		contentPane.add(lb1);
		
		tf1=new JTextField();
		tf1.setSize(200,20);
		tf1.setLocation(10,100);
		contentPane.add(tf1);
		tf1.getDocument().addDocumentListener(dl);
		
		
		lb2=new JLabel("İkinci sayıyı giriniz");
		lb2.setSize(200,20);
		lb2.setLocation(10,160);
		contentPane.add(lb2);
		
		tf2=new JTextField();
		tf2.setSize(200,20);
		tf2.setLocation(10,180);
		contentPane.add(tf2);
		tf2.getDocument().addDocumentListener(dl);
		
//		btn=new JButton("Hesapla");
//		btn.setSize(200,20);
//		btn.setLocation(10,270);
//		contentPane.add(btn);
//		btn.addActionListener(al);
	
		sp1=new JScrollPane();
		sp1.setSize(300,300);
		sp1.setLocation(220,50);
		
		ep1=new JEditorPane();
		ep1.setSize(300,300);
		sp1.setViewportView(ep1);
		sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(sp1);
		
		
		
	}

}
