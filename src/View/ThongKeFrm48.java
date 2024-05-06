package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThongKeFrm48 {

    private JPanel ThongKeFrm48;
    private JButton thốngKêĐốiTácButton;
    private JButton dongMHBtn;
    private JButton thốngKêKháchHàngButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ThongKeFrm48");
        frame.setContentPane(new ThongKeFrm48().ThongKeFrm48);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void close() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ThongKeFrm48);
        frame.dispose();
    }

    public ThongKeFrm48() {
        dongMHBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // click to redirect to ThongKeDongMHFrm48
                close();
                TkDongMHFrm48 tkeDongMH = new TkDongMHFrm48();
                tkeDongMH.main(null);
            }
        });
    }
}
