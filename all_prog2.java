package TQE_Go;

import javax.swing.*;
import java.text.DecimalFormat;

public class all_prog2 {
    public static String option = "Choose a certain action:\n" +
            "*****************************************\n" +
            "[1] Cryptocurrency Conversion\n" +
            "[2] Banking Simulation\n" +
            "[3] Restaurant\n" +
            "[4] Calculation of Area of a Certain Shape\n" +
            "[5] 10pts Quiz\n" +
            "*****************************************\n" +
            "[0] Exit";
    public static int opt = Integer.parseInt(JOptionPane.showInputDialog(option));

    public static void main(String[] args) {
        while (opt != -1) {
            if (opt == 1) {
                prog_1.main();
            } else if (opt == 2) {
                prog_2.main();
            } else if (opt == 3) {
                prog_3.main();
            } else if (opt == 4) {
                prog_4.main();
            } else if (opt == 5) {
                prog_5.main();
            } else if (opt == 0) {
                int decision = JOptionPane.showConfirmDialog(null, "Do you want to quit?");
                if (decision == 1) {
                    break;
                } else if (decision == 0) {
                    opt = Integer.parseInt(JOptionPane.showInputDialog(option));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input");
                opt = Integer.parseInt(JOptionPane.showInputDialog(option));
            }
            opt = Integer.parseInt(JOptionPane.showInputDialog(option));
        }
    }

    public static class prog_1 {
        public static String input = "Select conversion:\n" +
                "***************************\n" +
                "-BTC" +
                "\n[1] BTC to USD" +
                "\n[2] USD to BTC" +
                "\n[3]BTC to ETH" +
                "\n\n-ETH" +
                "\n[4] ETH to USD" +
                "\n[5] USD to ETH" +
                "\n[6] ETH to BTC" +
                "\n***************************" +
                "\n\n [0] Exit";
        public static int in;
        public static float eth = 9322.34f, btc = 16324.59f, total, p_total;

        public static void main() {
            in = Integer.parseInt(JOptionPane.showInputDialog(input));
            while (in >= -1) {
                if (in >= 1 && in <= 3) {
                    btc(in);
                } else if (in >= 4 && in <= 6) {
                    eth(in);
                } else if (in == 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect input");
                    in = Integer.parseInt(JOptionPane.showInputDialog(input));
                }
            }
        }

        private static void btc(int bit) {
            if (bit == 1) {
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total BTC to convert"));
                total = currency * btc;
                JOptionPane.showMessageDialog(null, "The result of conversion is $ " + total);
                next_opt();
            } else if (bit == 2) {
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total USD to convert"));
                total = currency / btc;
                JOptionPane.showMessageDialog(null, "The result of conversion is BTC " + total);
                next_opt();
            } else if (bit == 3) {
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total BTC to convert"));
                p_total = currency * btc;
                total = p_total / eth;
                JOptionPane.showMessageDialog(null, "The result of conversion is ETH " + total);
                next_opt();
            }
        }

        private static void eth(int ether) {
            if (ether == 4) {
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total ETH to convert"));
                total = currency * eth;
                JOptionPane.showMessageDialog(null, "The result of conversion is $" + total);
                next_opt();
            } else if (ether == 5) {
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total USD to convert"));
                total = currency / eth;
                JOptionPane.showMessageDialog(null, "The result of conversion is ETH " + total);
                next_opt();
            } else if (ether == 6) {
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total ETH to convert"));
                p_total = currency * eth;
                total = p_total / btc;
                JOptionPane.showMessageDialog(null, "The result of conversion is BTC " + total);
                next_opt();
            }
        }

        private static void next_opt() {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to convert more?");
            if (confirm == 1) {
                JOptionPane.showMessageDialog(null, "Thank you for using our service!");
                in = 0;
            }
        }
    }

    public static class prog_2 {
        public static String input = "Choose what to do with your bank account:\n" +
                "*******************************************" +
                "\n[1] Withdraw" +
                "\n[2] Deposit" +
                "\n[3] Balance Inquiry" +
                "\n*******************************************\n" +
                "[0] Exit";
        public static int in = Integer.parseInt(JOptionPane.showInputDialog(input));
        public static float bal = 0.00f;

        public static void main() {
            while (in >= 0 && in <= 3) {
                if (in == 1) {
                    float cash_amount = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of cash to withdraw"));
                    withdraw(cash_amount);
                    next_opt();
                } else if (in == 2) {
                    float cash_amount = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of cash to withdraw"));
                    deposit(cash_amount);
                    next_opt();
                } else if (in == 3) {
                    balance_inquiry();
                    next_opt();
                } else if (in == 0) {
                    JOptionPane.showMessageDialog(null, "Thank you for using our service!");
                    break;
                } else if (in < 0 || in > 3) {
                    JOptionPane.showMessageDialog(null, "Invalid service");
                    in = Integer.parseInt(JOptionPane.showInputDialog(input));
                }
            }
        }

        private static void deposit(float depo) {
            if (depo <= 0) {
                JOptionPane.showMessageDialog(null, "Invalid deposit amount");
            } else {
                bal += depo;
                JOptionPane.showMessageDialog(null, "Success!");
            }
        }

        private static void withdraw(float wthw) {
            if (bal <= 0.00) {
                JOptionPane.showMessageDialog(null, "Insufficient balance");
            } else {
                bal -= wthw;
                JOptionPane.showMessageDialog(null, "Success!");
            }
        }

        private static void balance_inquiry() {
            JOptionPane.showMessageDialog(null, "Your total balance is: " + bal);
        }

        private static void next_opt() {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you have another transaction?");
            if (confirm == 0) {
                in = Integer.parseInt(JOptionPane.showInputDialog(input));
            } else if (confirm == 1) {
                in = 0;
            }
        }
    }

    public static class prog_3 {
        public static String input = """
                Subarashi's Kitchen
                ***************************************
                [1] Fried chicken - P35.00
                [2] Lumpia shanghai - P5.00
                [3] Beef steak - P45.00
                [4] Adobo pork - P35.00
                [5] Spicy wings P50.00
                [6] Pastil - P10.00
                [7] Humba pork - P40.00
                [8] Spicy lechon paksiw - P50.00
                [9] Tinola - P35.00
                [10] Tortang talong - P15.00
                ***************************************
                [11] Checkout
                [0] Exit
                """, rcpt = "";
        public static int in = Integer.parseInt(JOptionPane.showInputDialog(input)), sub_total = 0, total = 0;

        public static void main() {
            order(in);
        }

        private static void order(int in) {
            while (in > -1) {
                if (in == 1) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many fried chicken do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many fried chicken do you want to order"));
                        }
                    }
                    sub_total += quantity * 35;
                    total += sub_total;
                    rcpt += "Fried chicken - " + quantity + "         P" + sub_total + "\n";
                    exit();
                } else if (in == 2) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How much lumpia shanghai do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many lumpia shanghai do you want to order"));
                        }
                    }
                    sub_total += quantity * 5;
                    total += sub_total;
                    rcpt += "Lumpia shanghai - " + quantity + "          P" + sub_total + "\n";
                    exit();
                } else if (in == 3) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many beef steak do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many fried chicken do you want to order"));
                        }
                    }
                    sub_total += quantity * 45;
                    total += sub_total;
                    rcpt += "Beef steak - " + quantity + "           P" + sub_total + "\n";
                    exit();
                } else if (in == 4) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many adobo pork do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many adobo pork do you want to order"));
                        }
                    }
                    sub_total += quantity * 35;
                    total += sub_total;
                    rcpt += "Adobo pork - " + quantity + "            P" + sub_total + "\n";
                    exit();
                } else if (in == 5) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many spicy wings do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many spicy wings do you want to order"));
                        }
                    }
                    sub_total += quantity * 50;
                    total += sub_total;
                    rcpt += "Spicy wings - " + quantity + "          P" + sub_total + "\n";
                    exit();
                } else if (in == 6) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many pastil/s do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many pastil/s do you want to order"));
                        }
                    }
                    sub_total += quantity * 10;
                    total += sub_total;
                    rcpt += "Pastil - " + quantity + "               P" + sub_total + "\n";
                    exit();
                } else if (in == 7) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many humba pork do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many humba pork do you want to order"));
                        }
                    }
                    sub_total += quantity * 40;
                    total += sub_total;
                    rcpt += "Humba pork - " + quantity + "            P" + sub_total + "\n";
                    exit();
                } else if (in == 8) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many spicy lechon paksiw do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many spicy lechon paksiw do you want to order"));
                        }
                    }
                    sub_total += quantity * 50;
                    total += sub_total;
                    rcpt += "Spicy lechon paksiw - " + quantity + "       P" + sub_total + "\n";
                    exit();
                } else if (in == 9) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many tinola do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many tinola do you want to order"));
                        }
                    }
                    sub_total += quantity * 35;
                    total += sub_total;
                    rcpt += "Tinola - " + quantity + "                   P" + sub_total + "\n";
                    exit();
                } else if (in == 10) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many tortang talong do you want to order"));
                    while (quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null, "Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many tortang talong do you want to order"));
                        }
                    }
                    sub_total += quantity * 15;
                    total += sub_total;
                    rcpt += "Tortang talong - " + quantity + "          P" + sub_total + "\n";
                    exit();
                } else if (in == 11) {
                    receipt(rcpt);
                } else if (in == 0) {
                    int decision = JOptionPane.showConfirmDialog(null, "Are you sure you wanna exit?");
                    if (decision == 0) {
                        JOptionPane.showMessageDialog(null, "Sayonara!");
                        break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid order");
                }
                in = Integer.parseInt(JOptionPane.showInputDialog(input));
            }
        }

        private static void receipt(String rcpt) {
            String csh = JOptionPane.showInputDialog("Your order is:\n" + rcpt + "\n" + "Total: P" + total + "\nEnter cash amount");
            int cash = Integer.parseInt(csh);
            if (cash > total) {
                int change = cash - total;
                JOptionPane.showMessageDialog(null, "Your change is P" + change + "\nPlease wait to your order to serve\n            ARIGATO GUZAIMAS");
            } else if (total == cash) {
                JOptionPane.showMessageDialog(null, "Please wait to your order to serve\n            ARIGATO GUZAIMAS");
            }
            while (cash < total) {
                JOptionPane.showMessageDialog(null, "Insufficient cash");
                cash = Integer.parseInt(JOptionPane.showInputDialog(csh));
            }
        }

        public static void exit() {
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to order more?");
            if (confirm == 1) {
                receipt(rcpt);
                next_order();
            }
        }

        public static void next_order() {
            int confirm = JOptionPane.showConfirmDialog(null, "Next order?");
            if (confirm == 0) {
                rcpt = null;
            } else if (confirm == 1) {
                JOptionPane.showMessageDialog(null, "Bye! Jiyane!");
                in = 0;
            }
        }
    }

    public static class prog_4 {
        public static String input = "Choose you want to know the area of the chosen shape:\n" +
                "**************************************************\n" +
                "[1] Square\n" +
                "[2] Triangle\n" +
                "[3] Rectangle\n" +
                "[4] Circle\n" +
                "**************************************************\n" +
                "[0] Exit";
        public static int area = 0, in;

        public static void main() {
            in = Integer.parseInt(JOptionPane.showInputDialog(input));
            while (in != -1) {
                if (in == 1) {
                    int s1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of a side of your square"));
                    square_area(s1);
                    exit();
                } else if (in == 2) {
                    int h = Integer.parseInt(JOptionPane.showInputDialog("Enter the height of your triangle")),
                            b = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of the base of the triangle"));
                    triangle_area(h, b);
                    exit();
                } else if (in == 3) {
                    int l = Integer.parseInt(JOptionPane.showInputDialog("Enter the length of your rectangle")),
                            w = Integer.parseInt(JOptionPane.showInputDialog("Enter the width of your rectangle"));
                    rectangle_area(w, l);
                    exit();
                } else if (in == 4) {
                    float r = Float.parseFloat(JOptionPane.showInputDialog("Enter the radius of your circle"));
                    circle_area(r);
                    exit();
                } else if (in == 0) {
                    int decision = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
                    if (decision == 1) {
                        in = Integer.parseInt(JOptionPane.showInputDialog(input));
                    } else if (decision == 0) {
                        break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid option");
                }
                in = Integer.parseInt(JOptionPane.showInputDialog(input));
            }
        }

        private static void square_area(int side) {
            area = side * side;
            JOptionPane.showMessageDialog(null, "The area of your square is " + area);
        }

        private static void triangle_area(int height, int base) {
            area = height * base;
            JOptionPane.showMessageDialog(null, "The area of your triangle is " + area);
        }

        private static void rectangle_area(int width, int length) {
            area = width * length;
            JOptionPane.showMessageDialog(null, "The area of your rectangle is " + area);
        }

        private static void circle_area(float radius) {
            final DecimalFormat df = new DecimalFormat("0.00");
            float area = (float) ((radius * radius) * Math.PI);

            JOptionPane.showMessageDialog(null, "The area of your circle is " + df.format(area));
        }

        private static void exit() {
            int decision = JOptionPane.showConfirmDialog(null, "Do you want to calculate more?");
            if (decision == 0) {
                in = Integer.parseInt(JOptionPane.showInputDialog(input));
            } else if (decision == 1) {
                in = 0;
            }
        }
    }

    public static class prog_5 {
        public static void main() {
            JOptionPane.showMessageDialog(null, "Welcome");
            String option = "Are you ready to take the quiz?";
            int opt = JOptionPane.showConfirmDialog(null, option);
            if (opt == 0) {
                JOptionPane.showMessageDialog(null, "Answer these 10 question, GOOD LUCK!");
                questions();
            } else if (opt == 1) {
                JOptionPane.showMessageDialog(null, "Ok! Just enter this section when your ready ;)");
            }
        }

        private static void questions() {
            String[] que = new String[10];
            for (int i = 0; i <= 9; i++) {
                if (i == 0) {
                    que[i] = JOptionPane.showInputDialog("""
                            1. What is the name of the first computer virus?
                            a. ILOVEYOU
                            b. Stuxnet
                            c. Conficker
                            d. Tinba""");
                } else if (i == 1) {
                    que[i] = JOptionPane.showInputDialog("""
                            2. First computer was made by ____________.
                            a. Mark Zuckerberg
                            b. Jeff Bezos
                            c. Charles Babbage
                            d. Many Pacquiao""");
                } else if (i == 2) {
                    que[i] = JOptionPane.showInputDialog("""
                            3. Who discovers the use of 0?
                            a. Pinoy
                            b. Indians
                            c. Chinese
                            d. None of the above""");
                } else if (i == 3) {
                    que[i] = JOptionPane.showInputDialog("""
                            4. When the the first gate is on then the second gate is off (LOGICAL OR), what will be the output?
                            a. on
                            b. off
                            c. brownout
                            d. short circuit""");
                } else if (i == 4) {
                    que[i] = JOptionPane.showInputDialog("""
                            5. What is the first calculator?
                            a. Casio
                            b. Abacus
                            c. Hands
                            d. Pascaline""");
                } else if (i == 5) {
                    que[i] = JOptionPane.showInputDialog("""
                            6. Who created the first programming language?
                            a. Ada Lovelace
                            b. God
                            c. Larry page
                            d. Sergey Brin""");
                } else if (i == 6) {
                    que[i] = JOptionPane.showInputDialog("""
                            7. What is the binary code for "219"?
                            a. 11101101
                            b. 10101110
                            c. 01101111
                            d. 11011011""");
                } else if (i == 7) {
                    que[i] = JOptionPane.showInputDialog("""
                            8. In motherboard, what is the voltage regulator?
                            a. VRM
                            b. KRM
                            c. AK47
                            d. RPD""");
                } else if (i == 8) {
                    que[i] = JOptionPane.showInputDialog("""
                            9. There are three types of selection in programming, one is if, if-else, and ____ selection?
                            a. crime
                            b. case
                            c. option
                            d. waterfall""");
                } else if (i == 9) {
                    que[i] = JOptionPane.showInputDialog("""
                            10. In terms of storage, which is better unicode ASCII or UTF-8?
                             a. UTF-8
                             b. ASCII
                             c. Both
                             d. None of the above""");
                }
            }
            checking(que);
        }

        private static void checking(String[] questions) {
            String[] ans = {"a", "c", "b", "a", "d", "a", "d", "a", "b", "b"};
            String result = "";
            int score = 0;
            for (int i = 0; i <= 9; i++) {
                if (ans[i].equals(questions[i])) {
                    score += 1;
                    result += (i + 1) + ". " + questions[i] + " - correct\n";
                } else {
                    result += (i + 1) + ". " + questions[i] + " - incorrect\n";
                }
            }
            JOptionPane.showMessageDialog(null, "Here is the result:\n" + result + "Your score is " + score + "/10");
            int decision = JOptionPane.showConfirmDialog(null, "Do you want to try again?");
            if (decision == 0) {
                questions();
            }
        }
    }
}
