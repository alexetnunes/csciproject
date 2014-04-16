import java.io.*;
import java.net.*;
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

public class Network
extends JFrame
implements ActionListener
{
	private JPanel panel1;
	private JButton sendbutton;
	private JTextArea received;
	private JTextArea sendarea;
	private JLabel Send;
	private JLabel Receive; 
	private JButton connect;
	private JLabel cstatus;
	
	public Network(){
		setTitle("Messenger");
		setSize(500,800);
		setDefaultCloseOperation(3);
		buidPanel();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void buidPanel(){
		this.panel1=new JPanel();
		this.received=new JTextArea(10,40);
		this.sendarea=new JTextArea(10,40);
		this.sendbutton=new JButton("send");
		this.Send=new JLabel("SendBox");
		this.connect=new JButton("Connect");
		this.received.setEditable(false);
		this.sendbutton.addActionListener(this);
		this.Receive=new JLabel("Party's Message");
		this.cstatus=new JLabel("Offline");
		
		
		setLayout(new BorderLayout());
		
		panel1.add(Send,"NORTH");
		panel1.add(sendarea,"CENTER");
		panel1.add(sendbutton,"CENTER");
		panel1.add(Receive, "CENTER");
		panel1.add(received,"SOUTH");
		panel1.add(connect, "SOUTH");
		panel1.add(cstatus,"SOUTH");
		add(panel1);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent ex) {
		if(ex.getSource()==this.connect){
			EncryptionS es=new EncryptionS();
			cstatus.setText("Connected");
		}
		// TODO Auto-generated method stub
		if(ex.getSource()==this.sendbutton){
			String sen=sendarea.getText();
			
			
			 Socket clientSocket = null;
			    DataInputStream in = null;
			    PrintStream out = null;
			    DataInputStream inputLine = null;

			    //open a socket on port 6002
			        try {
			      clientSocket = new Socket("localhost", 6026);
			      System.out.print("error2");
			      
			      out = new PrintStream(clientSocket.getOutputStream());
			      in = new DataInputStream(clientSocket.getInputStream());
			      inputLine = new DataInputStream(new BufferedInputStream(System.in));
			    } catch (UnknownHostException e) {
			      System.err.println("unknown server");
			    } catch (IOException e) {
			      System.err.println("Connection to server failed");
			    }
			        if (clientSocket != null && out != null && in != null) {
			            try {
			            	String responseline=sen;
			           
			            	while(responseline!=null){
			            		break;
		
			            	}
			            	received.setText(responseline);
			            	
			            
			            	 out.close();
			                 in.close();
			                 clientSocket.close();
			               } catch (UnknownHostException e) {
			                 System.err.println("Trying to connect to unknown server: " + e);
			               } catch (IOException e) {
			                 System.err.println("IOException:  " + e);
			               }			        
		}
		}
	}
}

	
	
	

