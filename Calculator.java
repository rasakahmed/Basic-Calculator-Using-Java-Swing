import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Helvetica",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    String operator;


    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 532);
        frame.setLayout(null);
        frame.setResizable(false);
        //frame.getContentPane().setBackground(new Color(0,0,0));

        textfield = new JTextField();
        textfield.setBounds(18, 18, 300, 65);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("D");
        clrButton = new JButton("C");


        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;


        for(int i =0;i<8;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            //functionButtons[i].setBackground(new Color(255, 255, 255, 73));

            functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            functionButtons[i].setBorderPainted(false);
            functionButtons[i].setContentAreaFilled(false);
        }

        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            //numberButtons[i].setBackground(new Color(255, 255, 255, 73));

            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            numberButtons[i].setBorderPainted(false);
            numberButtons[i].setContentAreaFilled(false);
        }


        delButton.setBounds(172,94,68,50);
        clrButton.setBounds(248,94,68,50);

        panel = new JPanel();
        panel.setBounds(18, 150, 300, 320);
        panel.setLayout(new GridLayout(4,4,5,5));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(addButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton) {
            String temp = textfield.getText();
            if (!temp.contains(".")) {
                textfield.setText(temp + ".");
            }
        }
        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ="+";
            textfield.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ="-";
            textfield.setText("");
        }
        if(e.getSource()==mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ="×";
            textfield.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ="÷";
            textfield.setText("");
        }
        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textfield.getText());

            switch(operator) {
                case"+":
                    result=num1+num2;
                    break;
                case"-":
                    result=num1-num2;
                    break;
                case"×":
                    result=num1*num2;
                    break;
                case"÷":
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            if (!string.isEmpty()) {
                StringBuilder sb = new StringBuilder(string);
                sb.deleteCharAt(sb.length() - 1);
                textfield.setText(sb.toString());
            }
        }
    }
}