import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main
{
  public static void main(String args[])
  {
    JFrame f=new JFrame();
    f.setLayout(null);

    f.setSize(400,400);
    f.setTitle("login");

    JTextField t1=new JTextField();
    JTextField t2=new JPasswordField();
    t1.setBounds(100,100,150,30);
    t2.setBounds(100,150,150,30);
    JButton b=new JButton("SIGN IN");
    b.setBounds(100,200,100,30);
    JLabel l=new JLabel();
    l.setBounds(250,200,200,30);
    b.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent ae)
      {
        if(t1.getText().toString().equals("kiran") && t2.getText().toString().equals("kiran"))
          l.setText("LOGIN SUCCESFUL");
        else
          l.setText("LOGIN FAILED");
       }
     });
    f.add(t1);
    f.add(t2);
    f.add(b);
    f.add(l);
    f.setVisible(true);
  }
}

