/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RatePanel extends JPanel
{

private double[] rate; // exchange rates
private String[] currencyName;
private JLabel result;
private JComboBox currencyList;
private TextField inputAmount;
private JLabel warning;

    public RatePanel ()
    {
        JLabel title = new JLabel ("===How much is that in dollars?===");
        JLabel title2 = new JLabel ("Insert the Amount of money you want to convert :");
        JLabel title3 = new JLabel ("Select the currency :");
        JLabel title4 = new JLabel ("================================================");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select one",
        "European Euro", "Canadian Dollar",
        "Japanese Yen", "Australian Dollar",
        "Indian Rupee", "Mexican Peso"};
        rate = new double [] {0.0, 1.2103, 0.7351,
        0.0091, 0.6969,
        0.0222, 0.0880};
        currencyList = new JComboBox(currencyName);
        inputAmount = new TextField(10);
        
        title3.setAlignmentX(100);
        currencyList.setAlignmentX(300);
        result = new JLabel (" ------------ ");
        result.setFont(new Font ("Cavolini", Font.BOLD, 15));
        title4.setFont(new Font ("Helvetica", Font.BOLD, 15));
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ComboListener());
        add (title);
        add (title2);
        add (inputAmount);
        add (title3);
        add (currencyList);
        add (convertButton);
        add (title4);
        add (result);
    }

    private class ComboListener implements ActionListener
{
        public void actionPerformed (ActionEvent event)
        {
            int index = currencyList.getSelectedIndex();
            if (inputAmount.getText().isEmpty()){
                result.setText("Enter the correct input");
            }
            else {
                if (index != 0){
                    try {
                        result.setText ("The result is : " + inputAmount.getText()  + " " + currencyName[index] +
                        " = " + rate[index]*Integer.parseInt(inputAmount.getText()) + " U.S. Dollars");
                    }
                    catch (NumberFormatException warn){
                        result.setText("Please enter the correct input (it should be in number)");
                    }
                }
                else {
                    result.setText("Select the currency");
                }
            }
        }
    }
}