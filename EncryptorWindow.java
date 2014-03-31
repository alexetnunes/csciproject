import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EncryptorWindow
  extends JFrame
  implements ActionListener
{
  private JPanel panel1;
  private JPanel panel2;
  private JPanel panel3;
  private JLabel messageLabel;
  private JTextField cryptField;
  private JButton encryptButton;
  private JButton decryptButton;
  private final int windowWidth = 600;
  private final int windowLength = 300;
  private JLabel output;
  String input;
  String encryptedString;
  private JButton resetButton;
  
  public EncryptorWindow()
  {
    setTitle("Encryptor");
    
    setSize(600, 300);
    
    setDefaultCloseOperation(3);
    
    buildPanel();
    




    setVisible(true);
  }
  
  private void buildPanel()
  {
    this.messageLabel = new JLabel("Enter here");
    
    this.output = new JLabel(this.encryptedString);
    
    this.cryptField = new JTextField(30);
    
    this.encryptButton = new JButton("Encrypt");
    
    this.encryptButton.addActionListener(this);
    
    this.decryptButton = new JButton("Decrypt");
    
    this.decryptButton.addActionListener(this);
    
    this.resetButton = new JButton("Reset");
    
    this.resetButton.addActionListener(this);
    
    add(this.cryptField, "Center");
    
    add(this.encryptButton, "Center");
    
    add(this.decryptButton, "Center");
    



    this.panel1 = new JPanel();
    
    this.panel2 = new JPanel();
    this.panel3 = new JPanel();
    
    this.panel1.add(this.messageLabel);
    this.panel1.add(this.cryptField);
    this.panel2.add(this.encryptButton);
    this.panel2.add(this.decryptButton);
    this.panel2.add(this.resetButton);
    this.panel3.add(this.output);
    
    add(this.panel1, "North");
    add(this.panel2, "Center");
    add(this.panel3, "South");
  }
  
  public void actionPerformed(ActionEvent e)
  {
    this.input = this.cryptField.getText();
    if (e.getSource() == this.encryptButton)
    {
      System.out.println("Does this work");
      this.encryptButton.setVisible(false);
      this.decryptButton.setVisible(true);
    }
    if (e.getSource() == this.decryptButton)
    {
      this.encryptButton.setVisible(true);
      this.decryptButton.setVisible(false);
    }
    if (e.getSource() == this.resetButton)
    {
      this.encryptButton.setVisible(true);
      this.decryptButton.setVisible(true);
      this.output.setVisible(false);
    }
  }
}
