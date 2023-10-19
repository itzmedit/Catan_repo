// This is an interactive java application that computes up an equation based on the PMDAS principle/technique
// This program can compute values with 4 digits and more
/* This program also used the shunting yard algorithm - a simple technique for parsing infix expressions  
   containing binary operators of varying precedence */

// These are the needed packages for this program
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

// The PMDASCalculator class
public class PMDASCalculator {
    static public void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ask = "1", equation;
        
        // Using a while loop
        while (Integer.parseInt(ask) == 1) { 
            System.out.print("\nEnter an equation: ");
            equation = scan.nextLine().replaceAll(" ", ""); // replaces white spaces
            convertPostfix(equation);

            do { // to check the input if valid or invalid
               // Asks the user if wants to try more 
               System.out.println("\nDo you want to try more? \n[1] Yes \n[2] No");
               ask = scan.nextLine().replaceAll(" ", ""); // replaces white spaces
               
               if (invalidInputYN(ask)) { System.out.println("Invalid input! Please select again..."); }
            } while (invalidInputYN(ask)); // let the user enter again if invalid
        }
        
        // Prints exit when done
        System.out.println("\nExit!");
        scan.close();
    }

    // The convertPostfix method
    public static void convertPostfix(String equation) { // an equation is the parameter
        LinkedList<String> operand = new LinkedList<String>(); 
        Stack<Character> operator = new Stack<>();
        String value = ""; // the variable for multiple-digit values

        // Reads each character of an equation
        for (int x = 0; x < equation.length(); x++) {
            char ch = equation.charAt(x); // the variable for a character

            // Checks if the character is a digit
            if (Character.isDigit(ch) || ch == '.') { // can read dot operator
                value = value.concat(Character.toString(ch));
                System.out.println("Value: " + value);

                if ((x < equation.length()-1 && !Character.isDigit(equation.charAt(x+1)) && !dotOp(equation.charAt(x+1))) || x == equation.length()-1) {
                    operand.addLast(value);
                    value = "";
                    
                    if (x >= 2) {
                        if (equation.charAt(x-2) == ')') {
                              if (checkPrecedence(operator.peek()) == 2) 
                                 operand.addLast(String.valueOf(operator.pop()));
                        }
                    }
                }
            } 

            // Checks if the character is an open parenthesis
            else if (ch == '(')
                operator.push(ch);

            // Checks if the character is a close parenthesis
            else if (ch == ')') {
                while (operator.peek() != '(') {
                    operand.addLast(String.valueOf(operator.pop())); // adds operator to result
                }
                
                operator.pop();
            } 
            
            // Checks if the character is an operator
            else if (isOperator(ch)) { 
                if (x != 0 && operator.isEmpty()) { operator.push(ch); } 
                
                // Checks if the operator is a negative sign
                else if ((x == 0) || (x >= 1 && equation.charAt(x-1) == '(') || (isOperator(equation.charAt(x-1)))) {
                    value = value.concat(Character.toString(ch));
                }
                
                else {
                    while (!operator.isEmpty() && checkPrecedence(ch) <= checkPrecedence(operator.peek())) {
                        operand.addLast(String.valueOf(operator.pop())); // Append operators to nResult
                    }
                    
                    operator.push(ch);
                }
            }

            // To check if all the characters are separated correctly
            System.out.println("\nCurrent Character: " + ch);
            System.out.println("Operand: " + operand);
            System.out.println("Operator: " + operator);
        }
        
        System.out.println();

        // Adds the left character in operators to operands
        while (!operator.isEmpty()) operand.addLast(String.valueOf(operator.pop()));
        
        evalTop(operand);
    }

    // The isOperator method checks if the character is an operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    
    // The dotOp method checks if the character is a dot
    public static boolean dotOp(char ch) {
        return ch == '.';
    }
    
    // The checkPrecedence method checks if the operator has high/low precedence
    public static int checkPrecedence(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
    
    // invalidInputYN method with an input as a parameter
    public static boolean invalidInputYN(String _input) {
       return ((_input.length() != 1 || !Character.isDigit(_input.charAt(0))) || (Integer.parseInt(_input) != 1 && Integer.parseInt(_input) != 2));
    }

    // The evalTop method 
    public static void evalTop(LinkedList<String> _operand) {
        LinkedList<String> val = new LinkedList<String>();
        
        // Transfers operands' values to val 
        while (_operand.size() > 0) { 
            val.addLast(_operand.getFirst()); 
            System.out.println("Add in val: " + _operand.getFirst());
            _operand.removeFirst();
        }

        // For the computation
        while (val.size() > 1) {
            System.out.println("\nContent of val:  " + val);
            int numOp = 0;

            // Searching for the first operator's index
            for (int x = val.size()-1; x >= 0; x--) 
                 if (val.get(x).length() == 1 && isOperator(val.get(x).charAt(0))) { numOp = x; }
            
            double operand1 = Double.parseDouble(val.get(numOp-2)); // for the first operand
            System.out.println("Operand 1: " + operand1);
            
            double operand2 = Double.parseDouble(val.get(numOp-1)); // for the second operand
            System.out.println("Operand 2: " + operand2);
             
            char operator = val.get(numOp).charAt(0); // for the operator
            System.out.println("Operator: " + operator);
            
            // Removes characters
            for (int x = 0; x <= 1; x++) val.remove(numOp-x);
            val.set(numOp-2, "");
            
            // Computes for the result and adds in val
            val.set(numOp-2, String.valueOf(operation(operand1, operand2, operator)));
            System.out.println("Initial result: " + operation(operand1, operand2, operator)); // prints the initial result
        }

        // Prints the final result if the val is not empty
        if (!val.isEmpty()) System.out.println("\nFinal result: " + val.get(0));
    }

    // The operation method
    public static double operation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+': // for addition
                return operand1 + operand2;
                
            case '-': // for subtraction
                return operand1 - operand2;
                
            case '*': // for multiplication
                return operand1 * operand2;
                
            case '/': // for division
                if (operand2 == 0) throw new ArithmeticException("Division by zero");
                
                return operand1 / operand2;
                
            default: // throws an exception
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

