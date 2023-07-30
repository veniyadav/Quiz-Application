package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1366, 768);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz1.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 371);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Rama and his brothers are all part of which dynasty?";
        questions[0][1] = "Flower dynasty";
        questions[0][2] = "Sun dynasty";
        questions[0][3] = "Moon dynasty";
        questions[0][4] = "Rock dynasty";

        questions[1][0] = "The divine bow of Bhagavan Shiv at King Janak's palace was broken or stringed by which God?";
        questions[1][1] = "Ram";
        questions[1][2] = "Lakshman";
        questions[1][3] = "Brahma";
        questions[1][4] = "Ravan";

        questions[2][0] = "Who was Lakshmana's mother?";
        questions[2][1] = "Sumitra";
        questions[2][2] = "Kaushalya";
        questions[2][3] = "Kaikeyi";
        questions[2][4] = "Urmila";

        questions[3][0] = "Sita is the avatar of which spouse of Vishnu?";
        questions[3][1] = "Durga";
        questions[3][2] = "Kali";
        questions[3][3] = "Lakshmi";
        questions[3][4] = "parvati";

        questions[4][0] = "Sita was found on the soil by King Janak and Queen Sunaina. She was an avatar of a goddess, but which one?";
        questions[4][1] = "Annika";
        questions[4][2] = "Medha";
        questions[4][3] = "Ambika";
        questions[4][4] = "Anagha";

        questions[5][0] = "What was the name of Ram's mother?";
        questions[5][1] = "sumitra";
        questions[5][2] = "Kausalya";
        questions[5][3] = "kaikeyi";
        questions[5][4] = "sita";

        questions[6][0] = " Ayodhya was the capital of which kingdom?";
        questions[6][1] = "Kosalo";
        questions[6][2] = "Mithila";
        questions[6][3] = "Indraprastha";
        questions[6][4] = "Lanka";

        questions[7][0] = "Who is the son of Kaikai?";
        questions[7][1] = "lakshman";
        questions[7][2] = "Bharatha";
        questions[7][3] = "Ram";
        questions[7][4] = "Hanuman";

        questions[8][0] = "Rama is the avatar of what Hindu God?";
        questions[8][1] = "Vishnu";
        questions[8][2] = "Shiva";
        questions[8][3] = "Bramhaa";
        questions[8][4] = "ganesh";

        questions[9][0] = "So, now we know the clan in which Ravan was born. But, hey, does anyone know who his parents were?";
        questions[9][1] = "Visharva and Kaikesi";
        questions[9][2] = "Sarikshit and Dhubhudhi";
        questions[9][3] = "Avangada and Kartikya";
        questions[9][4] = "Pranapanksh and Bidvisha";
        
        answers[0][1] = "Sun dynasty";
        answers[1][1] = "Ram";
        answers[2][1] = "Sumitra";
        answers[3][1] = "Lakshmi";
        answers[4][1] = "Anagha";
        answers[5][1] = "Kausalya";
        answers[6][1] = "Kosalo";
        answers[7][1] = "Bharatha";
        answers[8][1] = "Vishnu";
        answers[9][1] = "Visharva and Kaikesi";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 500, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 550, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 600, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}
