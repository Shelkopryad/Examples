package src.buffer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 16734975 on 06.11.2018.
 */
public class Win extends JFrame {

    private Buffer buffer;

    public Win(String name) {
        super(name);
        constuctGUI();
        buffer = new Buffer();
    }

    private void constuctGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setAlwaysOnTop(true);
        JButton button = new JButton("Copy");
        button.addActionListener(new Handler());
        getContentPane().add(button);
        pack();
        setVisible(true);
    }

    private class Handler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println(buffer.getClipboardContents());
        }
    }



}
