import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{
    JButton addButton,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9, delButton,CE,C,MC,div,sqrt,MR,mul,per,MS,sub,prop,M,pm,dot,eq,secondFunc;
    JTextField mainTextField, memoryTextField;
    String status;
    double result=0;
    double memory=0;
    double n1=0;

    //Mark the first number for easy calculation
    int first=1;

    //First number for percentage calculation
    double num;

    //Flag for appending digits or starting a new number
    /*1->Appending a digit to the existing number
      2->Taking a new number as input*/
    int opt=2;

    //Flag to mark binary operation for '=' button
    /*0->No Operation
      1->Addtion
      2->Subtraction
      3->Division
      4->Multiplication*/
    int oper1=0;
    int oper2=0;


    Main()
    {
        setTitle("Calculator");
        setSize(600,750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setResizable(false);

    }


    //Function for creating User Interface
    void initComponents()
    {

        mainTextField = new JTextField(50);
        mainTextField.setText(" ");
        mainTextField.setPreferredSize( new Dimension(100, 50));
        /*
        add(mainTextField,BorderLayout.NORTH);
        mainTextField.setHorizontalAlignment(JTextField.RIGHT);
        */


        //Panel 1
        JPanel row0 = new JPanel( new FlowLayout(FlowLayout.CENTER, 10, 10));
        row0.setBackground(Color.WHITE);
        row0.add(mainTextField);


        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        row1.setBackground(Color.WHITE);

        memoryTextField = new JTextField(10);
        memoryTextField.setText(" ");
        memoryTextField.setPreferredSize( new Dimension(100, 50));

        row1.add(memoryTextField);

        MR = new JButton("MR");
        MR.setForeground(Color.WHITE);
        MR.setBackground(Color.BLACK);
        MR.setPreferredSize( new Dimension(100, 50));

        row1.add(MR);

        MS = new JButton("MS");
        MS.setForeground(Color.WHITE);
        MS.setBackground(Color.BLACK);
        MS.setPreferredSize( new Dimension(100, 50));

        row1.add(MS);

        MC = new JButton("MC");
        MC.setForeground(Color.WHITE);
        MC.setBackground(Color.BLACK);
        MC.setPreferredSize( new Dimension(100, 50));

        row1.add(MC);

        secondFunc = new JButton("SF");
        secondFunc.setForeground(Color.WHITE);
        secondFunc.setBackground(Color.BLACK);
        secondFunc.setPreferredSize( new Dimension(100, 50));

        row1.add(secondFunc);




        //Panel 2
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        CE= new JButton("CE");
        CE.setForeground(Color.WHITE);
        CE.setBackground(Color.BLACK);
        CE.setPreferredSize( new Dimension(130, 50));

        row2.add(CE);

        C = new JButton("C");
        C.setForeground(Color.WHITE);
        C.setBackground(Color.BLACK);
        C.setPreferredSize( new Dimension(130, 50));

        row2.add(C);

        sqrt = new JButton("sqrt");
        sqrt.setForeground(Color.WHITE);
        sqrt.setBackground(Color.BLACK);
        sqrt.setPreferredSize( new Dimension(130, 50));

        row2.add(sqrt);

        delButton = new JButton("delete");
        delButton.setForeground(Color.WHITE);
        delButton.setBackground(Color.BLACK);
        delButton.setPreferredSize( new Dimension(130, 50));

        row2.add(delButton);


        //Panel 3
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        b7 = new JButton("7");
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.BLACK);
        b7.setPreferredSize( new Dimension(100, 50));
        row3.add(b7);
        b8= new JButton("8");
        b8.setForeground(Color.WHITE);
        b8.setBackground(Color.BLACK);
        b8.setPreferredSize( new Dimension(100, 50));
        row3.add(b8);
        b9 = new JButton("9");
        b9.setForeground(Color.WHITE);
        b9.setBackground(Color.BLACK);
        b9.setPreferredSize( new Dimension(100, 50));
        row3.add(b9);
        div = new JButton("/");
        div.setForeground(Color.WHITE);
        div.setBackground(Color.BLACK);
        div.setPreferredSize( new Dimension(100, 50));
        row3.add(div);
        per = new JButton("%");
        per.setForeground(Color.WHITE);
        per.setBackground(Color.BLACK);
        per.setPreferredSize( new Dimension(100, 50));
        row3.add(per);


        //Panel 4
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        b4= new JButton("4");
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setPreferredSize( new Dimension(100, 50));

        row4.add(b4);

        b5 = new JButton("5");
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        b5.setPreferredSize( new Dimension(100, 50));

        row4.add(b5);

        b6= new JButton("6");
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.BLACK);
        b6.setPreferredSize( new Dimension(100, 50));

        row4.add(b6);

        mul = new JButton("*");
        mul.setForeground(Color.WHITE);
        mul.setBackground(Color.BLACK);
        mul.setPreferredSize( new Dimension(100, 50));

        row4.add(mul);

        prop = new JButton("1/x");
        prop.setForeground(Color.WHITE);
        prop.setBackground(Color.BLACK);
        prop.setPreferredSize( new Dimension(100, 50));

        row4.add(prop);

        //Panel 5
        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        b1 = new JButton("1");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setPreferredSize( new Dimension(100, 50));

        row5.add(b1);

        b2= new JButton("2");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setPreferredSize( new Dimension(100, 50));

        row5.add(b2);

        b3 = new JButton("3");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setPreferredSize( new Dimension(100, 50));

        row5.add(b3);

        sub = new JButton("-");
        sub.setForeground(Color.WHITE);
        sub.setBackground(Color.BLACK);
        sub.setPreferredSize( new Dimension(100, 50));

        row5.add(sub);

        pm = new JButton("+/-");
        pm.setForeground(Color.WHITE);
        pm.setBackground(Color.BLACK);
        pm.setPreferredSize( new Dimension(100, 50));

        row5.add(pm);

        //Panel 6
        JPanel row6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        b0= new JButton("0");
        b0.setForeground(Color.WHITE);
        b0.setBackground(Color.BLACK);
        b0.setPreferredSize( new Dimension(100, 50));

        row6.add(b0);

        dot= new JButton(".");
        dot.setForeground(Color.WHITE);
        dot.setBackground(Color.BLACK);
        dot.setPreferredSize( new Dimension(100, 50));

        row6.add(dot);

        addButton = new JButton("+");
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.BLACK);
        addButton.setPreferredSize( new Dimension(100, 50));

        row6.add(addButton);

        eq = new JButton("=");
        eq.setForeground(Color.WHITE);
        eq.setBackground(Color.BLACK);
        eq.setPreferredSize( new Dimension(208, 50));

        row6.add(eq);



        //forming the Calculators view
        JPanel mainSection = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        mainSection.add(row0);
        mainSection.add(row1);
        mainSection.add(row2);
        mainSection.add(row3);
        mainSection.add(row4);
        mainSection.add(row5);
        mainSection.add(row6);

        mainSection.setBackground(Color.WHITE);

        //Adding all individual panels to main panel7
        add(mainSection);

        //Add events
        addButton.addActionListener(this);
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        delButton.addActionListener(this);
        CE.addActionListener(this);
        C.addActionListener(this);
        MC.addActionListener(this);
        div.addActionListener(this);
        sqrt.addActionListener(this);
        MR.addActionListener(this);
        mul.addActionListener(this);
        per.addActionListener(this);
        MS.addActionListener(this);
        sub.addActionListener(this);
        prop.addActionListener(this);
        secondFunc.addActionListener(this);
        pm.addActionListener(this);
        dot.addActionListener(this);
        eq.addActionListener(this);
        per.addActionListener(this);
    }
    //Method when ActionListener calls its corresponding routine


    //Method when ActionListener calls its corresponding routine
    public void actionPerformed(ActionEvent evt)
    {
        String str;

        //Action Corresponding to + button
        if(evt.getSource()== addButton)
        {
            if(first==1)
            {
                result=num=Double.parseDouble(mainTextField.getText());
                oper1=1;
            }
            else
            {
                n1=Double.parseDouble(mainTextField.getText());
                oper2=1;
            }

            //Action corresponding to previous operator
            switch(oper1)
            {
                case 1:add1();
                    break;
                case 2:sub();
                    break;
                case 3:div();
                    break;
                case 4:mul();
                    break;
            }
        }

        //Action Corresponding to * button
        if(evt.getSource()==mul)
        {
            if(first==1)
            {
                result=num=Double.parseDouble(mainTextField.getText());
                oper1=4;
            }
            else
            {
                n1=Double.parseDouble(mainTextField.getText());
                oper2=4;
            }

            //Action corresponding to previous operator
            switch(oper1)
            {
                case 1:add1();
                    break;
                case 2:sub();
                    break;
                case 3:div();
                    break;
                case 4:mul();
                    break;
            }
        }

        //Action Corresponding to / button
        if(evt.getSource()==div)
        {
            if(first==1)
            {
                result=num=Double.parseDouble(mainTextField.getText());
                oper1=3;
            }
            else
            {
                n1=Double.parseDouble(mainTextField.getText());
                oper2=3;
            }

            //Action corresponding to previous operator
            switch(oper1)
            {
                case 1:add1();
                    break;
                case 2:sub();
                    break;
                case 3:div();
                    break;
                case 4:mul();
                    break;
            }
        }

        //Action Corresponding to - button
        else if(evt.getSource()==sub)
        {
            if(first==1)
            {
                result=num=Double.parseDouble(mainTextField.getText());
                oper1=2;
            }
            else
            {
                n1=Double.parseDouble(mainTextField.getText());
                oper2=2;
            }

            //Action corresponding to previous operator
            switch(oper1)
            {
                case 1:add1();
                    break;
                case 2:sub();
                    break;
                case 3:div();
                    break;
                case 4:mul();
                    break;
            }

        }

        //Action Corresponding to = button
        else if(evt.getSource()==eq)
        {
            double n1=Double.parseDouble(mainTextField.getText());
            if(oper1==1)
                result=result+n1;
            else if(oper1==2)
                result=result-n1;
            else if(oper1==3)
                result=result/n1;
            else if(oper1==4)
                result=result*n1;
            else
                result=Double.parseDouble(mainTextField.getText());
            num=result;
            str=String.valueOf(result);
            mainTextField.setText(str);
        }

        //Action Corresponding to MS button
        else if(evt.getSource()==MS)
        {
            memory=Double.parseDouble(mainTextField.getText());

            String status;
            status=String.valueOf("MS");
            memoryTextField.setText(status);
            mainTextField.setText("Value saved to memory ");

        }

        //Action Corresponding to M button
        else if(evt.getSource()==M)
        {
            memory=memory+Double.parseDouble(mainTextField.getText());
            memory=0;
            mainTextField.setText("Memory Cleared");
            memoryTextField.setText("MC");
        }

        //Action Corresponding to MC button
        else if(evt.getSource()==MC)
        {
            memory=0;
            mainTextField.setText("Memory Cleared");
            memoryTextField.setText("MC ");
        }

        //Action Corresponding to MR button
        else if(evt.getSource()==MR)
        {
            str=String.valueOf(memory);
            mainTextField.setText(str);
            memoryTextField.setText("MR");
        }

        //Action Corresponding to +/- button
        else if(evt.getSource()==pm)
        {
            double n1=Double.parseDouble(mainTextField.getText());
            n1=-n1;
            str=String.valueOf(n1);
            mainTextField.setText(str);
        }

        //Action Corresponding to 0 button
        else if(evt.getSource()==b0)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+0;
            else
                str=String.valueOf(" ")+0;
            opt=1;
            mainTextField.setText(str);

        }

        //Action Corresponding to 1 button
        else if(evt.getSource()==b1)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+1;
            else
                str=String.valueOf(" ")+1;
            opt=1;
            mainTextField.setText(str);

        }

        //Action Corresponding to 2 button
        else if(evt.getSource()==b2)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+2;
            else
                str=String.valueOf(" ")+2;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 3 button
        else if(evt.getSource()==b3)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+3;
            else
                str=String.valueOf(" ")+3;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 4 button
        else if(evt.getSource()==b4)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+4;
            else
                str=String.valueOf(" ")+4;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 5 button
        else if(evt.getSource()==b5)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+5;
            else
                str=String.valueOf(" ")+5;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 6 button
        else if(evt.getSource()==b6)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+6;
            else
                str=String.valueOf(" ")+6;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 7 button
        else if(evt.getSource()==b7)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+7;
            else
                str=String.valueOf(" ")+7;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 8 button
        else if(evt.getSource()==b8)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+8;
            else
                str=String.valueOf(" ")+8;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to 9 button
        else if(evt.getSource()==b9)
        {
            if(opt==1)
                str=String.valueOf(mainTextField.getText())+9;
            else
                str=String.valueOf(" ")+9;
            opt=1;
            mainTextField.setText(str);
        }

        //Action Corresponding to BACKSPACE button
        else if(evt.getSource()==delButton)
        {
            int len;
            str= mainTextField.getText();
            len=str.length();
            if(len>=1)
                str=str.substring(0,len-1);
            mainTextField.setText(str);
        }

        //Action Corresponding to CE button
        else if(evt.getSource()==CE)
        {
            result=0;
            first=1;
            opt=2;
            str=String.valueOf('0');
            mainTextField.setText(str);

        }

        //Action Corresponding to C button
        else if(evt.getSource()==C)
        {
            result=0;
            memory=0;
            first=1;
            opt=2;
            mainTextField.setText(" ");
            memoryTextField.setText(" ");

        }

        //Action Corresponding to . button
        else if(evt.getSource()==dot)
        {
            str=String.valueOf(mainTextField.getText())+".";
            mainTextField.setText(str);
        }

        //Action Corresponding to 1/x button
        else if(evt.getSource()==prop)
        {
            double n1=Double.parseDouble(mainTextField.getText());
            n1=1/n1;
            str=String.valueOf(n1);
            mainTextField.setText(str);
        }

        //Action Corresponding to sqrt button
        else if(evt.getSource()==sqrt)
        {
            double n1=Double.parseDouble(mainTextField.getText());
            n1=Math.sqrt(n1);
            str=String.valueOf(n1);
            mainTextField.setText(str);
        }

        //Action Corresponding to % button
        else if(evt.getSource()==per)
        {
            double n1=Double.parseDouble(mainTextField.getText());
            n1=(n1*num)/100;
            str=String.valueOf(n1);
            mainTextField.setText(str);
        }

        else if(evt.getSource()==secondFunc)
        {
            str=String.valueOf("2Function");
            memoryTextField.setText(str);

        }

    }

    //Add called according to previous operator
    void add1()
    {
        if(first==0)
            result=num=result+n1;
        String str=String.valueOf(result);
        mainTextField.setText(str);
        opt=2;
        if(oper2!=0)
        {
            oper1=oper2;
            oper2=0;
        }
        first=0;
    }

    //Sub called according to previous operator
    void sub()
    {
        if(first==0)
            result=num=result-n1;
        String str=String.valueOf(result);
        mainTextField.setText(str);
        opt=2;
        if(oper2!=0)
            oper1=oper2;
        first=0;
    }

    //Div called according to previous operator
    void div()
    {
        if(first==0)
        {
            if(n1==0)
                mainTextField.setText("Cannot divide by zero");
            else
                result=num=result/n1;
        }
        String str=String.valueOf(result);
        mainTextField.setText(str);
        opt=2;
        if(oper2!=0)
            oper1=oper2;
        first=0;
    }

    //Mul called according to previous operator
    void mul()
    {
        if(first==0)
            result=num=result*n1;
        String str=String.valueOf(result);
        mainTextField.setText(str);
        opt=2;
        if(oper2!=0)
            oper1=oper2;
        first=0;
    }

    public static void main(String args[])
    {
        Main obj = new Main();
        obj.setVisible(true);
    }
}