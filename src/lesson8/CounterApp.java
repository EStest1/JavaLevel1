package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private int value = 0;


    public CounterApp () {

        setBounds(500, 500, 300,150);
        setTitle("Simple Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 32);
        JLabel jLabel = new JLabel();
        jLabel.setFont(font);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //
        // int value = 0;
        jLabel.setText(String.valueOf(value));

        JButton leftButton = new JButton("<");
        leftButton.setFont(font);

        JButton rightButton = new JButton(">");
        rightButton.setFont(font);

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                jLabel.setText(String.valueOf(value));
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                jLabel.setText(String.valueOf(value));
            }
        });

        add(jLabel, BorderLayout.CENTER);
        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        setVisible(true);

    }

    public static void main(String[] args) {
        new CounterApp();
    }
}
