package Day2.Exercise;


import java.awt.dnd.InvalidDnDOperationException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculatorWithException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
            double num1 = 0, num2 = 0;
            boolean validInput = false;

            while (!validInput){
                try{
                    System.out.println("Enter first number ");
                    num1 = scanner.nextDouble();
                    System.out.println("Enter second number ");
                    num2 = scanner.nextDouble();
                    validInput = true;
                } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter numeric value.");
                    scanner.nextLine(); //clear input buffer
                }
            }

            System.out.println("Enter operator(+,-,*,/)");
//            char operator = scanner.next().charAt(0);
            char operator;

            try {
                operator = getValidOperator(scanner);
            } catch (InvalidDnDOperationException e){
                System.out.println(e.getMessage());
                continue;
            }

            double result;

            try {
                switch (operator){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0){
                            result = num1 / num2;
                        } else {
                            throw new ArithmeticException("Division by zero is not allowed");
                        }
                        break;
                    default:
                        System.out.println("Invalid number");
                        return;
                }
                System.out.println("Result: "+ result);
                System.out.println("Quit program?: enter 1 to quit");
                try {
                    int quit = scanner.nextInt();
                    if (quit == 1){
                        System.out.println("Thank you, see you again");
                        exit = true;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Wrong answer, try again");
                    scanner.nextLine(); // clears input buffer
                }

            } catch (ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static char getValidOperator(Scanner scanner) throws InvalidDnDOperationException {
        char operator = scanner.next().charAt(0);
        if (operator == '+' || operator == '-' || operator == '*' || operator == '/'){
            return operator;
        }else {
            throw new InvalidDnDOperationException("Invalid operator. Please enter a valid operator.");
        }
    }

}

