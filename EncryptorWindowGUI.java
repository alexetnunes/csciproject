

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JScrollBar;


public class EncryptorWindowGUI extends JFrame implements ActionListener{

	private JLabel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JButton decryptButton;
    private JButton encryptButton;
    private JButton btnReset;
    
    
  
	// * Launch the application.
	
	public EncryptorWindowGUI(){
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
	
	
	// * Create the frame.
	public void buildPanel() {
		setBounds(900, 400, 450, 300);
		
	    contentPane=new JLabel(new ImageIcon("C:\\Users\\richard\\workspace\\FinalProject\\src\\lockEdit.jpg"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblEncrytionDecrytion = new JLabel("Encryption/Decryption");
		lblEncrytionDecrytion.setBounds(151, 11, 139, 20);
		contentPane.add(lblEncrytionDecrytion);
		
		textField = new JTextField();
		textField.setBounds(38, 46, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(257, 46, 139, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 117, 134, 79);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(258, 117, 138, 79);
		contentPane.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		scrollPane_1.setViewportView(textArea_1);
		
		textArea_1.setEditable(false);
		textArea.setEditable(false);
		
	    encryptButton = new JButton("Encrypt");
		encryptButton.addActionListener(this);
		encryptButton.setBounds(66, 77, 83, 18);
		contentPane.add(encryptButton);
		
		 decryptButton = new JButton("Decrypt");
		decryptButton.setBounds(292, 77, 83, 18);
		decryptButton.addActionListener(this);
		contentPane.add(decryptButton);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(380, 117, 16, 79);
		contentPane.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(156, 117, 16, 79);
		contentPane.add(scrollBar_1);
		
		JLabel lblEncryptionInput = new JLabel("Encryption Input");
		lblEncryptionInput.setBounds(66, 32, 83, 14);
		contentPane.add(lblEncryptionInput);
		
		JLabel label = new JLabel("Decryption Input");
		label.setBounds(292, 32, 83, 14);
		contentPane.add(label);
		
		JLabel lblEncryptedOutput = new JLabel("Encrypted output");
		lblEncryptedOutput.setBounds(66, 106, 98, 9);
		contentPane.add(lblEncryptedOutput);
		
		JLabel label_1 = new JLabel("Decrypted output");

		label_1.setBounds(292, 106, 98, 9);
		contentPane.add(label_1);
		
	    btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		btnReset.setBounds(173, 226, 91, 23);
		
		contentPane.add(btnReset);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		   Decode dc=new Decode();
		   Encode en= new Encode("");
		   String text="",temp="";
		  
		   
		   if(e.getSource()==encryptButton){
			   text=textField.getText();
			   en.encodeThis(text);
			   textArea.setText(en.getEncodedInput().toString());
		   }
		   if(e.getSource()==decryptButton){
			   text=textField_1.getText();
			   temp=dc.decodeThis(text);
			   textArea_1.setText(temp);
		   }
		   if(e.getSource()==btnReset){
			   textField_1.setText("");
			   textField.setText("");
			   textArea_1.setText("");
			   textArea.setText("");
		   }
	}
}