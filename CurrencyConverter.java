package currencyconverter;
import java.awt.*;
import javax.swing.*;
public class CurrencyConverter
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("Currency Converter");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        RatePanel ratePanel = new RatePanel ();
        frame.getContentPane().add(ratePanel);
        frame.pack();
        frame.setSize(500, 220);
        frame.setVisible(true);
    }
}