package lesson5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {
    public Chat(){
        setTitle("test window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600,600,640,480);
        setLayout(null);

        JButton sendBtn = new JButton("SEND");
        //sendBtn.setBounds(20,20,);
        JTextField messageBox = new JTextField();
        JTextArea chatText = new JTextArea();
        add(chatText);
        add(messageBox);
        add(sendBtn);
        chatText.setEditable(false);

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatText.append(messageBox.getText()+ "\r\n");
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new Chat();
    }
}
