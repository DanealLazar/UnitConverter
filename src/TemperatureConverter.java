import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import javax.swing.*;

public class TemperatureConverter implements WindowListener, ActionListener {

     static boolean isOpen = false;

     JTextField currentTemp;

     JFrame frame;

     JPanel buttonsPanel;

     JLabel currentTempLabel;

     JButton toTempButton;

     JLabel toTempLabel;

     JButton changeConversionButton;

    
    public TemperatureConverter() {

        ImageIcon icon = new ImageIcon("UnitConverterFavion.png");
    
        frame = new JFrame("Temperature Converter");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.addWindowListener(this);

        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(75, 50, 250, 250);
        buttonsPanel.setBackground(Color.lightGray);
        buttonsPanel.setLayout(null);

        changeConversionButton = new JButton("Change Conversion");
        changeConversionButton.setBounds(50, 200, 150, 30);
        changeConversionButton.addActionListener(this);

        currentTempLabel = new JLabel(" :Fahrenheit");
        currentTempLabel.setBounds(150, 50, 100, 30);
        
        currentTemp = new JTextField();
        currentTemp.setBounds(50, 50, 100, 30);

        toTempButton = new JButton("to Celsius");
        toTempButton.setBounds(50, 100, 100, 30);
        toTempButton.setFont(new Font("Arial", Font.BOLD, 11));
        toTempButton.addActionListener(this);

        toTempLabel = new JLabel(" 0 :Celsius");
        toTempLabel.setBounds(150, 100, 100, 30);
        
        buttonsPanel.add(changeConversionButton);
        buttonsPanel.add(currentTemp);
        buttonsPanel.add(currentTempLabel);
        buttonsPanel.add(toTempButton);
        buttonsPanel.add(toTempLabel);
        

        frame.add(buttonsPanel);
        frame.setVisible(true);



    }


    public static boolean getOpen(){
    return isOpen;
    }

    public static void setOpen(boolean open) {
        isOpen = open;
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        isOpen = false;
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Change Conversion")) {
            if (currentTempLabel.getText().equals(" :Fahrenheit")) {
                currentTempLabel.setText(" :Celsius");
                toTempLabel.setText(" 0 :Fahrenheit");
                toTempButton.setText("to Fahrenheit");
            } else {
                currentTempLabel.setText(" :Fahrenheit");
                toTempLabel.setText(" 0 :Celsius");
                toTempButton.setText("to Celsius");
                
            }
        }

        if(e.getActionCommand().equals("to Celsius") && currentTemp.getText() != null){
            try {
                double fahrenheitValue = Double.parseDouble(currentTemp.getText());
                double celsiusValue = fahrenheitToCelsius(fahrenheitValue);
                System.out.println(fahrenheitValue + " Fahrenheit is " + celsiusValue + " Celsius.");

                toTempLabel.setText(String.format("%.2f :Celsius", celsiusValue));
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a valid number for Fahrenheit.");
            
        }
             }else if(e.getActionCommand().equals("to Fahrenheit") && currentTemp.getText() != null){
                try {
                    double celsiusValue = Double.parseDouble(currentTemp.getText());
                    double fahrenheitValue = celsiusToFahrenheit(celsiusValue);
                    System.out.println(celsiusValue + " Celsius is " + fahrenheitValue + " Fahrenheit.");
    
                    toTempLabel.setText(String.format("%.2f :Fahrenheit", fahrenheitValue));
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input. Please enter a valid number for Celsius.");
                }
            }
    }
}
