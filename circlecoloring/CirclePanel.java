/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlecoloring;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    private int width, height;  
    JButton left = new JButton("Left");
    JButton right = new JButton("Right");
    JButton up = new JButton("Up");
    JButton down = new JButton("Down");
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //--------------------------------------------------------------
    
    public CirclePanel(int width, int height)
    {
        this.width= width;
        this.height=height;
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        // Create buttons to move the circle
        
        left.setMnemonic('L');
        left.setToolTipText("This will move the circle 20 pixel to the left");
        
        right.setMnemonic('R');
        right.setToolTipText("This will move the circle 20 pixel to the right");
        
        up.setMnemonic('U');
        up.setToolTipText("This will move the circle 20 pixel to the top");
        
        down.setMnemonic('D');
        down.setToolTipText("This will move the circle 20 pixel to the bottom");
        JButton pink = new JButton ("Pink");
        pink.setToolTipText("This will change the circle color to pink");
        JButton cyan = new JButton ("Cyan");
        cyan.setToolTipText("This will change the circle color to cyan");
        
        JButton choose = new JButton ("Choose Color");
        choose.setToolTipText("This will open the color chooser");

        JButton magenta = new JButton ("Magneta");
        magenta.setToolTipText("This will change the circle color to magenta");
        JButton orange = new JButton ("Orange"); 
        orange.setToolTipText("This will change the circle color to orange");
        
        pink.setBackground(Color.pink);
        cyan.setBackground(Color.cyan);
        magenta.setBackground(Color.magenta);
        orange.setBackground(Color.orange);
        
        // Add listeners to the buttons
       
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        pink.addActionListener(new ColorListener(Color.pink));
        cyan.addActionListener(new ColorListener(Color.cyan));
        choose.addActionListener(new ColorListener(null));
        magenta.addActionListener(new ColorListener(Color.magenta));
        orange.addActionListener(new ColorListener(Color.orange));
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
        JPanel colorPanel = new JPanel();
        colorPanel.add(pink);
        colorPanel.add(cyan);
        colorPanel.add(choose);
        colorPanel.add(magenta);
        colorPanel.add(orange);
        this.add(colorPanel, "North");
    }
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener
    {
        private int dx;
        private int dy;
        private Component prev;
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy)
        {
            this.dx = dx;
            this.dy = dy;
        }
        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e)
        {
             if((x+dx+CIRCLE_SIZE)<width) {
                if((x+dx)>0){
                    x += dx;
                    left.setEnabled(true);
                    right.setEnabled(true);
                }else{
                    left.setEnabled(false);
                }
            }else{
                right.setEnabled(false);
            }

             if((y+dy+CIRCLE_SIZE)<height) {
                if((y+dy)>0){
                    y += dy;
                    up.setEnabled(true);
                    down.setEnabled(true);
                }else{
                    up.setEnabled(false);
                }
            }else{
                down.setEnabled(false);
            }


            if((y+dy+CIRCLE_SIZE)<height && (y+dy)>0){
                y += dy;
            }else{

            }
            repaint();
        }
    }
    
    
    private class ColorListener implements ActionListener{
        private Color colour;
        
        public ColorListener(Color theDc)
        {
            colour = theDc;
        }
        public void actionPerformed(ActionEvent e)
        {
            if (colour != null)
            {
                c = colour;
            }
            else {
                Color newColor = JColorChooser.showDialog(null, "Choose Color", c);
                c = newColor;
            }
            repaint();
        }
    }
}
