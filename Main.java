/*
 * this program acts as a very basic calculator
 * @author Thomas Quigley
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JTextField firstInput;
  JTextField secondInput;
  JTextField resultOutput;

  JLabel firstLabel;
  JLabel secondLabel;
  JLabel resultLabel;

  JButton addButton;
  JButton subButton;
  JButton mulButton;
  JButton divButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Calculator");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);


    // make the main panel and add it to the frame
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);


    // make the 3 labels and add them to the main panel
    firstLabel = new JLabel("First Number");
    secondLabel = new JLabel("Second Number");
    resultLabel = new JLabel("Result");
    

    firstLabel.setBounds(200, 70, 200, 30);
    secondLabel.setBounds(200, 150, 200, 30);
    resultLabel.setBounds(200, 230, 200, 30);

    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(resultLabel);


    // make the two input text fields and add them to the main panel
    firstInput = new JTextField();
    secondInput = new JTextField();

    firstInput.setBounds(500, 70, 100, 30);
    secondInput.setBounds(500, 150, 100, 30);

    mainPanel.add(firstInput);
    mainPanel.add(secondInput);


    // make the output text field and add it to the main panel
    resultOutput = new JTextField();
    resultOutput.setBounds(500, 230, 100, 30);
    resultOutput.setEnabled(false);
    mainPanel.add(resultOutput);


    // make the four buttons and add the to the main panel
    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("x");
    divButton = new JButton("/");

    addButton.setBounds(200, 350, 50, 30);
    subButton.setBounds(300, 350, 50, 30);
    mulButton.setBounds(400, 350, 50, 30);
    divButton.setBounds(500, 350, 50, 30);

    addButton.addActionListener(this);
    subButton.addActionListener(this);
    mulButton.addActionListener(this);
    divButton.addActionListener(this);

    addButton.setActionCommand("add");
    subButton.setActionCommand("sub");
    mulButton.setActionCommand("mul");
    divButton.setActionCommand("div");

    mainPanel.add(addButton);
    mainPanel.add(subButton);
    mainPanel.add(mulButton);
    mainPanel.add(divButton);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // get the number inputs 
    String firstText = firstInput.getText();
    String secondText = secondInput.getText();
    int firstNumber = Integer.parseInt(firstText);
    int secondNumber = Integer.parseInt(secondText);

    // initialize result variable
    int result;


    // see which button was pressed
    switch(command) {
      case "add":
        // add the numbers together and output the result
        result = firstNumber + secondNumber;
        resultOutput.setText("" + result);
        return;
      case "sub":
        // subtract the numbers together and output the result
        result = firstNumber - secondNumber;
        resultOutput.setText("" + result);
        return;
      case "mul":
        // multiply the numbers together and output the result
        result = firstNumber * secondNumber;
        resultOutput.setText("" + result);
        return;
      case "div":
        // divide the numbers together and output the result
        result = firstNumber / secondNumber;
        resultOutput.setText("" + result);
        return;
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
