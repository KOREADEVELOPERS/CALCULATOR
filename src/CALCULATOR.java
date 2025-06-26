import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class CALCULATOR extends JPanel {
    JTextField textField1;
    JFrame frame;
    JPanel pannel;
    JPanel pannelboard;
    int boardwidth = 300;
    int boardheight = 500;

    // To store operands and operator
    double num1 = 0, num2 = 0;
    String operator = "";
    boolean isOperatorClicked = false;

    CALCULATOR() {
        frame = new JFrame("Simple Calculator");
        frame.setSize(boardwidth, boardheight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        pannel = new JPanel();
        pannel.setBackground(Color.BLACK);
        pannel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        frame.add(pannel, BorderLayout.NORTH);

        pannelboard = new JPanel();
        pannelboard.setLayout(new GridLayout(4, 4, 10, 10));
        pannelboard.setBackground(Color.BLACK);
        pannelboard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(pannelboard, BorderLayout.CENTER);

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(450, 40));
        textField1.setFont(new Font("Arial", Font.PLAIN, 24));
        textField1.setBackground(Color.BLACK);
        textField1.setBorder(new LineBorder(Color.WHITE, 3));
        textField1.setForeground(Color.WHITE);
        textField1.setHorizontalAlignment(JTextField.RIGHT);
        textField1.setText("0");
        pannel.add(textField1);

        String[] Stringbutton = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String label : Stringbutton) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setFocusPainted(false);

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String btnText = btn.getText();

                    if (btnText.matches("[0-9]")) {
                        if (textField1.getText().equals("0") || isOperatorClicked) {
                            textField1.setText(btnText);
                            isOperatorClicked = false;
                        } else {
                            textField1.setText(textField1.getText() + btnText);
                        }
                    } else if (btnText.matches("[+\\-*/]")) {
                        operator = btnText;
                        num1 = Double.parseDouble(textField1.getText());
                        isOperatorClicked = true;
                    } else if (btnText.equals("=")) {
                        num2 = Double.parseDouble(textField1.getText());
                        double result = 0;
                        switch (operator) {
                            case "+": result = num1 + num2; break;
                            case "-": result = num1 - num2; break;
                            case "*": result = num1 * num2; break;
                            case "/":
                                if (num2 == 0) {
                                    textField1.setText("Cannot divide by 0");
                                    return;
                                }
                                result = num1 / num2;
                                break;
                        }
                        textField1.setText(String.valueOf(result));
                        operator = ""; // reset
                    } else if (btnText.equals("C")) {
                        textField1.setText("0");
                        num1 = 0;
                        num2 = 0;
                        operator = "";
                        isOperatorClicked = false;
                    }
                }
            });

            pannelboard.add(btn);
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CALCULATOR();
    }
}
