import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainMenu implements ActionListener {

    JFrame frame;

    ImageIcon icon = new ImageIcon("UnitConverterFavion.png");

    ArrayList<JButton> buttons = new ArrayList<>();

    public MainMenu() {
    // frame setup
    frame = new JFrame();
    frame.setTitle("Unit Converter");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setIconImage(icon.getImage());
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(new Color(0x123456));

    // unit converter buttons panel
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setBounds(75, 75, 250, 250);
    buttonsPanel.setBackground(Color.lightGray);
    buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

    // Temperature Converter Button
    JButton tempButton = new JButton("Temperature Converter");
    tempButton.setBounds(0, 0, 200, 40);
    tempButton.setBorder(BorderFactory.createSoftBevelBorder(0, Color.black, Color.gray));
    tempButton.setBackground(Color.lightGray);
    tempButton.setForeground(Color.BLACK);
    tempButton.setFont(Font.getFont("Arial"));
    tempButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    buttons.add(tempButton);
    tempButton.addActionListener(this);

    
    buttonsPanel.add(tempButton);
    frame.add(buttonsPanel);
    frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (TemperatureConverter.getOpen() == false) {
            new TemperatureConverter();
            TemperatureConverter.setOpen(true);
            
        }else {
            JOptionPane.showMessageDialog(frame, "Temperature Converter is already open.");
        }
    }

}