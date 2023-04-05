import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "C", "+" };
    private String operator = "";
    private double operand1 = 0, operand2 = 0, result = 0;

    public Calculator() {
        textField = new JTextField(20);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttons = new JButton[16];

        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttonPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(textField, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        pack();
    }

    public void actionPerformed(ActionEvent ae) {
        String buttonClicked = ae.getActionCommand();

        if (buttonClicked.equals("+")) {
            operator = "+";
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else if (buttonClicked.equals("-")) {
            operator = "-";
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else if (buttonClicked.equals("*")) {
            operator = "*";
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else if (buttonClicked.equals("/")) {
            operator = "/";
            operand1 = Double.parseDouble(textField.getText());
            textField.setText("");
        } else if (buttonClicked.equals("C")) {
            textField.setText("");
            operand1 = 0;
            operand2 = 0;
            result = 0;
            operator = "";
        } else if (buttonClicked.equals(".")) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        } else if (buttonClicked.matches("[0-9]")) {
            textField.setText(textField.getText() + buttonClicked);
        } else if (buttonClicked.equals("=")) {
            operand2 = Double.parseDouble(textField.getText());
            if (operator.equals("+")) {
                result = operand1 + operand2;
            } else if (operator.equals("-")) {
                result = operand1 - operand2;
            } else if (operator.equals("*")) {
                result = operand1 * operand2;
            } else if (operator.equals("/")) {
                result = operand1 / operand2;
            }
            textField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setTitle("Calculator");
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setLocationRelativeTo(null);
        calc.setVisible(true);
    }
}
