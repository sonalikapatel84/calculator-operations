package main.java;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {

    private boolean status;
    String delimiter = " "; // Space delimiter
    String validationRegex =  "^\\d{0-9}+[.]?[0-9]*$";

    public double calculate(String input) throws Exception {

        //read the operation. if , found then ignore
        if (!input.isEmpty()) {
            if (hasACommaInOperands(input)) {
                // Throw exception if there is a comma
                throw new Exception();
            } else {
                // Assuming there is space between the operands.
                String[] splitStrings = getSplitStrings(input);
                String operator = splitStrings[1];
                double operand1 = Integer.parseInt(splitStrings[0]);
                double operand2 = Integer.parseInt(splitStrings[2]);

                switch (operator) {
                    case "+":
                        return getSum(operand1, operand2);
                    case "-":
                        return getMinus(operand1, operand2);
                    case "*":
                        return getProduct(operand1, operand2);
                    case "/":
                        return getDivide(operand1, operand2);
                    default:
                        break;
                }
            }
        }
        return 0.0;
    }

    private static double getDivide(double operand1, double operand2) {
        return operand1 / operand2;
    }

    private static double getProduct(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private static double getMinus(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private static double getSum(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private String[] getSplitStrings(String inputStrings) throws Exception {
        String[] splitStrings = inputStrings.split(delimiter);
        if (isCorrectFormat(splitStrings[0]) && isCorrectFormat(splitStrings[2])) {
            return splitStrings;
        } else {
            // Throw Exception if not in correct format
            throw new Exception("Incorrect format of input string!!");
        }
    }

    private boolean isCorrectFormat(String validationString) {
        String regexPattern = "[0-9]+[.]?[0-9]*";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(validationString);

        return matcher.matches();
    }

    private static boolean hasACommaInOperands(String input) {
        return input.contains(",");
    }

    public Calculator() {
        this.status = true;
    }

    public boolean getStatus() {
        return status;
    }
}
