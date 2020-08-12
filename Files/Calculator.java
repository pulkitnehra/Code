import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Calculator  implements ActionListener{

    
    JFrame fr;
    JTextField tf;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9 ,b0, badd, bdiv, bsub, bmul, bclr, bdel, beq, bdec;
    static double a=0,b=0,result=0;
    static int operator=0;
    
   Calculator()
   {
       fr = new JFrame("Calculator");
       tf = new JTextField();
       b1 = new JButton("1");
       b2 = new JButton("2");
       b3 = new JButton("3");
       b4 = new JButton("4");
       b5 = new JButton("5");
       b6 = new JButton("6");
       b7 = new JButton("7");
       b8 = new JButton("8");
       b9 = new JButton("9");
       b0 = new JButton("0");
       badd = new JButton("+");
       bsub = new JButton("-");
       bmul = new JButton("*");
       bdiv = new JButton("/");
       bdel = new JButton("del");
       bclr = new JButton("C");
       beq = new JButton("=");
       bdec = new JButton(".");
       
//       Adjust the positions
       tf.setBounds(30, 40, 280, 30);
       b7.setBounds(40, 100, 50, 40);
       b8.setBounds(110, 100, 50, 40);
       b9.setBounds(180, 100, 50, 40);
       bdiv.setBounds(250, 100, 50, 40);
       
       
       b4.setBounds(40, 170, 50, 40);
       b5.setBounds(110, 170, 50, 40);
       b6.setBounds(180, 170, 50, 40);
       bmul.setBounds(250, 170, 50, 40);
       
       b1.setBounds(40, 240, 50, 40);
       b2.setBounds(110, 240, 50, 40);
       b3.setBounds(180, 240, 50, 40);
       bsub.setBounds(250, 240, 50, 40);
       
       bdec.setBounds(40, 310, 50, 40);
       b0.setBounds(110, 310, 50, 40);
       beq.setBounds(180, 310, 50, 40);
       badd.setBounds(250, 310, 50, 40);
       
       bdel.setBounds(60, 380, 100, 40);
       bclr.setBounds(180, 380, 100, 40);
       
       fr.add(tf);
       fr.add(b7);
       fr.add(b8);
       fr.add(b9);
       fr.add(bdiv);
       fr.add(b4);
       fr.add(b5);
       fr.add(b6);
       fr.add(bmul);
       fr.add(b1);
       fr.add(b2);
       fr.add(b3);
       fr.add(bsub);
       fr.add(bdec);
       fr.add(b0);
       fr.add(beq);
       fr.add(badd);
       fr.add(bdel);
       fr.add(bclr);
       fr.setLayout(null);
       fr.setVisible(true);
       fr.setSize(350, 500);
       fr.setResizable(false);
       
       
//       add action listeners
       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
       b4.addActionListener(this);
       b5.addActionListener(this);
       b6.addActionListener(this);
       b7.addActionListener(this);
       b8.addActionListener(this);
       b9.addActionListener(this);
       b0.addActionListener(this);
       badd.addActionListener(this);
       bsub.addActionListener(this);
       bmul.addActionListener(this);
       bdiv.addActionListener(this);
       bdel.addActionListener(this);
       bclr.addActionListener(this);
       beq.addActionListener(this);
       bdec.addActionListener(this);
       
       
 
   }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==b1)
        {
            tf.setText(tf.getText().concat("1"));
        }
        
        if(e.getSource()==b2)
        {
            tf.setText(tf.getText().concat("2"));
        }
        
        if(e.getSource()==b3)
        {
            tf.setText(tf.getText().concat("3"));
        }
        
        if(e.getSource()==b4)
        {
            tf.setText(tf.getText().concat("4"));
        }
        
        if(e.getSource()==b5)
        {
            tf.setText(tf.getText().concat("5"));
        }
        
        if(e.getSource()==b6)
        {
            tf.setText(tf.getText().concat("6"));
        }
        
        if(e.getSource()==b7)
        {
            tf.setText(tf.getText().concat("7"));
        }
        
        if(e.getSource()==b8)
        {
            tf.setText(tf.getText().concat("8"));
        }
        
        if(e.getSource()==b9)
        {
            tf.setText(tf.getText().concat("9"));
        }
        
        if(e.getSource()==b0)
        {
            tf.setText(tf.getText().concat("0"));
        }
        
        if(e.getSource()==bclr)
        {
            tf.setText("");
        }
        
        if(e.getSource()==bdec)
        {
            tf.setText(tf.getText().concat("."));
        }
        
        
        if(e.getSource()==badd)
        {
            a = Double.parseDouble(tf.getText());
            operator = 1;
            tf.setText("");
        }
        
        if(e.getSource()==bsub)
        {
            a = Double.parseDouble(tf.getText());
            operator = 2;
            tf.setText("");
        }
        
        if(e.getSource()==bdiv)
        {
            a = Double.parseDouble(tf.getText());
            operator = 3;
            tf.setText("");
        }
        
        if(e.getSource()==bmul)
        {
            a = Double.parseDouble(tf.getText());
            operator = 4;
            tf.setText("");
        }
        
        if(e.getSource()==beq)
        {
            b = Double.parseDouble(tf.getText());
            
            switch(operator)
            {
            case 1: result = a + b;
            break;
            
            case 2: result = a - b;
            break;
            
            case 3: result = a / b;
            break;
            
            case 4: result = a * b;
            break;
                
             default: result = 0;
            }
        tf.setText(""+result);
        
        }
        
         if(e.getSource()==bdel)
        {
            String s = tf.getText();
            tf.setText("");
            for (int i = 0; i < s.length()-1; i++) {
                tf.setText(tf.getText() + s.charAt(i));
            }
            
        }
        
       
    }
    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }
    
}
