import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Terminal terminal = new TerminalImpl(new TerminalServer(), new PinValidator("0001"), 50000);
        Scanner scanner = new Scanner(System.in);
        boolean pinCheck = false;
        boolean exitCheck = false;
        System.out.println("Enter pin.");
        while (!pinCheck) {
            String pin = scanner.nextLine();
            try {
                pinCheck = terminal.validatePin(pin);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        while (!exitCheck) {
            System.out.println("Press 1 to get money, 2  to put money, 3 to check an account state, 9 to exit.");
            String command = scanner.nextLine();
            if (command.equals("9")) exitCheck = true;
            if (command.equals("3")) System.out.println("Account state: " + terminal.checkAccountState());
            if (command.equals("1")) {
                System.out.println("Enter an amount of money.");
                int money = scanner.nextInt();
                try {
                    terminal.getMoney(money);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (command.equals("2")) {
                System.out.println("Enter an amount of money.");
                int money = scanner.nextInt();
                try {
                    terminal.putMoney(money);

                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
