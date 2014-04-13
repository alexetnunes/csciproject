import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import java.util.*;

//Encryptor Window Class extends Jframe and implements Action Listener
public class EncryptorWindow
	extends JFrame
	implements ActionListener
{
//private variables
	
  //Panel variables
  private JPanel panel1;
  private JPanel panel2;
  private JPanel panel3;
  
  //private JTextArea textarea;
  
   //Message label for user ease
  private JLabel messageLabel;
  //Input field
  private JTextField cryptField;
  private JTextField dcryptField;
  //Encrypt, decrypt & reset buttons
  private JButton encryptButton;
  private JButton decryptButton;
  private JButton resetButton;
  
  private String text;
  private String newtext;
  private  String temp="";
  
  //Window width and length
  private final int windowWidth =900;
  private final int windowLength =500;
  
  //Encrypted or decrypted string being returned 
  private JLabel output;
  String input;
  String encryptedString;
  
  //Constructor
  public EncryptorWindow()
  { 
	  text="";
	  newtext="";
	  //Title appearing at top of window.
    setTitle("Encryptor");
    //Set size of window. 
    setSize(900, 500);
    //Sets closing operations.
    setDefaultCloseOperation(3);
   
    buildPanel();
 
//Sets window to appear in center of screen. 
setLocationRelativeTo(null);
   

    setVisible(true);
  }
  
  private void buildPanel()
  {
  
  //Input box
	 
	//this.textarea=new JTextArea(5,40);  
    this.messageLabel = new JLabel("Encrypt Bar");
    
    this.output = new JLabel(this.encryptedString);
    
    this.dcryptField= new JTextField(80);
    
    this.cryptField = new JTextField(30);
//Encrypt Button 
    
    this.encryptButton = new JButton("Encrypt");
    
    this.encryptButton.addActionListener(this);
 	
encryptButton.setBackground(Color.YELLOW);
  //Decrypt Button   
    this.decryptButton = new JButton("Decrypt");
    
    this.decryptButton.addActionListener(this);
 
decryptButton.setBackground(Color.YELLOW);
 
  //Reset Button   
    this.resetButton = new JButton("Reset");
    
    this.resetButton.addActionListener(this);
 
resetButton.setBackground(Color.PINK);
   
//All buttons are placed in the center area.
    //add(this.cryptField, "Center");
    
	setLayout(new BorderLayout());
    //add(this.encryptButton, "Center");
    
    add(this.decryptButton, "Center");
 
    //photograph of lock
    JLabel Background=new JLabel(new ImageIcon("C:\\Users\\richard\\workspace\\FinalProject\\src\\lock.jpg"));
    add(Background);
    
    Background.setLayout(new FlowLayout());
    //panel1.setBackground(Background);
    Background.add(this.messageLabel);
    Background.add(this.cryptField);
    Background.add(this.encryptButton);
    Background.add(this.dcryptField);
    Background.add(this.decryptButton);
    Background.add(this.resetButton);
    
  }
  
  
  //Button Action Listeners
  public void actionPerformed(ActionEvent e)
  {  
	   Decode dc=new Decode();
	   Encode en= new Encode("");
	  
	System.out.println(text);
	  ArrayList encoded= new ArrayList<String>();
	  
	  this.input = this.cryptField.getText();
	  //text=cryptField.getText();
      en.encodeThis(text);
    if (e.getSource() == this.encryptButton)
    {
      text=cryptField.getText();
      temp = text;
      en.encodeThis(temp);
      temp=en.getEncodedI();
      dcryptField.setText(temp);
      cryptField.setText("");
     // this.encryptButton.setVisible(false);
      //this.decryptButton.setVisible(true);
    }
    if (e.getSource() == this.decryptButton)
    {
    	temp=dcryptField.getText();
      encoded=en.getEncodedInput();
  
      
      newtext=dc.decodeThis(encoded.toString());
     
   
      
      cryptField.setText(newtext);
      //this.encryptButton.setVisible(true);
      //this.decryptButton.setVisible(false);
      
    }
    if (e.getSource() == this.resetButton)
    {
      this.encryptButton.setVisible(true);
      this.decryptButton.setVisible(true);
      this.output.setVisible(false);
      this.cryptField.setText("");
      this.dcryptField.setText("");
    }
  }
}

