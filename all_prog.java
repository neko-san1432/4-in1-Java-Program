package Finals;

import javax.swing.*;
import java.text.DecimalFormat;

public class all_prog{
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
    public static void main (String[] args){
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
                if (decision == 0) {
                    System.exit(0);
                } else if (decision == 1) {
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
                "\n [0] Exit";
        public static int in1;
        public static void main() {
            in1 = Integer.parseInt(JOptionPane.showInputDialog(input));
            while (in1 > -1)  {
                if (in1 >= 1 && in1 <= 3) {
                    btc(in1);
                    int confirm = JOptionPane.showConfirmDialog(null, "Do you want to convert more?");
                    if (confirm == 1) {
                        JOptionPane.showMessageDialog(null, "Thank you for using our service!");
                        break;
                    }
                } else if (in1 >= 4 && in1 <= 6) {
                    eth(in1);
                    int confirm = JOptionPane.showConfirmDialog(null, "Do you want to convert more?");
                    if (confirm == 1) {
                        JOptionPane.showMessageDialog(null, "Thank you for using our service!");
                        break;
                    }
                }else if(in1== 0){
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect input");
                }
                in1 = Integer.parseInt(JOptionPane.showInputDialog(input));
            }
        }
        public static float eth = 9322.34f, btc = 16324.59f, total,p_total;
        private static void btc(int bit){
            if (bit == 1){
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total BTC to convert"));
                total = currency*btc;
                JOptionPane.showMessageDialog(null, "The result of conversion is $ "+total);
            } else if (bit == 2) {
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total USD to convert"));
                total = currency/btc;
                JOptionPane.showMessageDialog(null, "The result of conversion is BTC "+total);
            }else if (bit == 3){
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total BTC to convert"));
                p_total = currency*btc;
                total = p_total/eth;
                JOptionPane.showMessageDialog(null, "The result of conversion is ETH "+total);
            }
        }
        private static void eth(int ether){
            if (ether == 4){
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total ETH to convert"));
                total = currency*eth;
                JOptionPane.showMessageDialog(null, "The result of conversion is $"+total);
            } else if (ether == 5) {
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total USD to convert"));
                total = currency/eth;
                JOptionPane.showMessageDialog(null, "The result of conversion is ETH "+total);
            }else if (ether == 6){
                float currency = Float.parseFloat(JOptionPane.showInputDialog("Enter total ETH to convert"));
                p_total = currency*eth;
                total = p_total/btc;
                JOptionPane.showMessageDialog(null, "The result of conversion is BTC "+total);
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
        public static int in2;
        public static void main(){
            in2 = Integer.parseInt(JOptionPane.showInputDialog(input));
            while(in2 >=0 && in2 <= 3){
                if (in2 == 1){
                    float cash_amount = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of cash to withdraw"));
                    withdraw(cash_amount);
                    next_opt();
                }else if (in2 == 2){
                    float cash_amount = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of cash to deposit"));
                    deposit(cash_amount);
                    next_opt();
                }else if(in2 == 3){
                    balance_inquiry();
                    next_opt();
                }else if (in2 == 0){
                    JOptionPane.showMessageDialog(null,"Thank you for using our service!");
                    break;
                }else if (in2 <0 || in2 > 3){
                    JOptionPane.showMessageDialog(null,"Invalid service");
                }
                if (confirm == 1){
                    break;
                }
                in2 = Integer.parseInt(JOptionPane.showInputDialog(input));

            }
        }
        public static float bal = 0.00f;
        private static void deposit(float depo){
            if(depo <= 0){
                JOptionPane.showMessageDialog(null,"Invalid deposit amount");
            }else {
                bal+= depo;
                JOptionPane.showMessageDialog(null,"Success!");
            }
        }
        private static void withdraw(float wthw){
            if(bal <= 0.00){
                JOptionPane.showMessageDialog(null,"Insufficient balance");
            }else{
                bal-= wthw;
                JOptionPane.showMessageDialog(null,"Success!");
            }
        }
        private static void balance_inquiry(){
            JOptionPane.showMessageDialog(null,"Your total balance is: " + bal);
        }
        public static int confirm;

        private static void next_opt(){
            confirm = JOptionPane.showConfirmDialog(null,"Do you have another transaction?");
            if(confirm == 1){
                JOptionPane.showMessageDialog(null,"Thank you for using our service!");
            }
        }
    }
    public static class prog_3 {
        public static String input ="""
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
                """,rcpt = "";
        public static int sub_total,total = 0;
        public static void main (){
            int in3 = Integer.parseInt(JOptionPane.showInputDialog(input));
            order(in3);
        }
        private static void order(int in3){
            while(in3 > -1){
                if(in3 == 1){
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many fried chicken do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many fried chicken do you want to order"));
                        }
                    }
                    sub_total = quantity * 35;
                    total += sub_total;
                    rcpt += "Fried chicken - " + quantity + "         P"+sub_total+"\n";
                    exit();
                } else if (in3 == 2) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How much lumpia shanghai do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many lumpia shanghai do you want to order"));
                        }
                    }
                    sub_total = quantity * 5;
                    total += sub_total;
                    rcpt += "Lumpia shanghai - " + quantity + "          P"+sub_total+"\n";
                    exit();
                } else if (in3 == 3) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many beef steak do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many beef steak do you want to order"));
                        }
                    }
                    sub_total = quantity * 45;
                    total += sub_total;
                    rcpt += "Beef steak - " + quantity + "           P"+sub_total+"\n";
                    exit();
                } else if (in3 == 4) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many adobo pork do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many adobo pork do you want to order"));
                        }
                    }
                    sub_total = quantity * 35;
                    total += sub_total;
                    rcpt += "Adobo pork - " + quantity + "            P"+sub_total+"\n";
                    exit();
                } else if (in3 == 5) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many spicy wings do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many spicy wings do you want to order"));
                        }
                    }
                    sub_total = quantity * 50;
                    total += sub_total;
                    rcpt += "Spicy wings - " + quantity +"          P"+ sub_total+"\n";
                    exit();
                } else if (in3 ==6){
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many pastil/s do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many pastil/s do you want to order"));
                        }
                    }
                    sub_total = quantity * 10;
                    total += sub_total;
                    rcpt += "Pastil - " + quantity + "               P"+sub_total+"\n";
                    exit();
                } else if (in3 == 7) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many humba pork do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many humba pork do you want to order"));
                        }
                    }
                    sub_total = quantity * 40;
                    total += sub_total;
                    rcpt += "Humba pork - " + quantity + "            P"+sub_total+"\n";
                    exit();
                } else if (in3 ==8) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many spicy lechon paksiw do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many spicy lechon paksiw do you want to order"));
                        }
                    }
                    sub_total = quantity * 50;
                    total += sub_total;
                    rcpt += "Spicy lechon paksiw - " + quantity +"       P"+ sub_total+"\n";
                    exit();
                }else if(in3 == 9){
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many tinola do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many tinola do you want to order"));
                        }
                    }
                    sub_total = quantity * 35;
                    total += sub_total;
                    rcpt += "Tinola - " + quantity + "                   P"+sub_total+"\n";
                    exit();
                } else if (in3 == 10) {
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How many tortang talong do you want to order"));
                    while(quantity <= 0) {
                        if (quantity <= 0) {
                            JOptionPane.showMessageDialog(null,"Invalid amount");
                            quantity = Integer.parseInt(JOptionPane.showInputDialog("How many tortang talong do you want to order"));
                        }
                    }
                    sub_total = quantity * 15;
                    total += sub_total;
                    rcpt += "Tortang talong - " + quantity + "          P"+sub_total+"\n";
                    exit();
                } else if (in3 == 11) {
                    receipt(rcpt);
                } else if (in3 == 0){
                    int decision = JOptionPane.showConfirmDialog(null, "Are you sure you wanna exit?");
                    if (decision == 0){
                        JOptionPane.showMessageDialog(null,"Sayonara!");
                        break;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid order");
                }
                if (confirm2 == 1){
                    break;
                }else{
                    in3 = Integer.parseInt(JOptionPane.showInputDialog(input));
            }
            }
        }
        private static void receipt(String rcpt){
            String csh ="Your order is:\n"+rcpt+"\n"+"Total: P"+ total+"\nEnter cash amount";
            int cash = Integer.parseInt(JOptionPane.showInputDialog(csh));
            if (cash>total){
                int change = cash - total;
                JOptionPane.showMessageDialog(null, "Your change is P"+ change+"\nPlease wait to your order to serve\n            ARIGATO GUZAIMAS");
                next_order();
            }else if (cash == total){
                JOptionPane.showMessageDialog(null, "Please wait to your order to serve\n            ARIGATO GUZAIMAS");
                next_order();
            }
            while(cash < total){
                JOptionPane.showMessageDialog(null,"Insufficient cash");
                cash = Integer.parseInt( JOptionPane.showInputDialog(csh));
            }
        }
        public static int confirm2,confirm1;
        private static void exit(){
            confirm1 = JOptionPane.showConfirmDialog(null,"Do you want to order more?");
            if(confirm1 == 1){
                receipt(rcpt);
            }
        }
        private static void next_order() {
            confirm2 = JOptionPane.showConfirmDialog(null, "Next order?");
            if (confirm2 == 0) {
                rcpt = "";
                total = 0;
            } else if (confirm2 == 1) {
                JOptionPane.showMessageDialog(null, "Bye! Jiyane!");
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
                "**************************************************\n"+
                "[0] Exit";
        public static int in4;
        public static float area = 0;
        public static void main () {
            in4 = Integer.parseInt(JOptionPane.showInputDialog(input));
            while (in4 != -1) {
                if (in4 == 1) {
                    float s1 = Float.parseFloat(JOptionPane.showInputDialog("Enter the length of a side of your square"));
                    square_area(s1);
                    exit();
                } else if (in4 == 2) {
                    float h = Float.parseFloat(JOptionPane.showInputDialog("Enter the height of your triangle")),
                            b = Float.parseFloat(JOptionPane.showInputDialog("Enter the length of the base of the triangle"));
                    triangle_area(h, b);
                    exit();
                } else if (in4 == 3) {
                    float l = Float.parseFloat(JOptionPane.showInputDialog("Enter the length of your rectangle")),
                            w = Float.parseFloat(JOptionPane.showInputDialog("Enter the width of your rectangle"));
                    rectangle_area(w, l);
                    exit();
                } else if (in4 == 4) {
                    float r = Float.parseFloat(JOptionPane.showInputDialog("Enter the radius of your circle"));
                    circle_area(r);
                    exit();
                } else if (in4 == 0) {
                    int decision = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
                    if (decision == 1) {
                        in4 = Integer.parseInt(JOptionPane.showInputDialog(input));
                    }
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid option");
                    in4 = Integer.parseInt(JOptionPane.showInputDialog(input));
                }
            }
        }
        private static void square_area(float side){
            area = side*side;
            JOptionPane.showMessageDialog(null,"The area of your square is "+ area);
        }
        private static void triangle_area(float height, float base){
            area = height*base;
            JOptionPane.showMessageDialog(null,"The area of your triangle is "+ area);
        }
        private static void rectangle_area(float width, float length){
            area = width* length;
            JOptionPane.showMessageDialog(null,"The area of your rectangle is "+ area);
        }
        private static void circle_area(float radius){
            final DecimalFormat df = new DecimalFormat("0.00");
            area = (float) (( radius *radius)*Math.PI);

            JOptionPane.showMessageDialog(null,"The area of your circle is "+ df.format(area));
        }
        private static void exit(){
            int decision = JOptionPane.showConfirmDialog(null, "Do you want to calculate more?");
            if (decision == 0){
                in4 = Integer.parseInt(JOptionPane.showInputDialog(input));
            }else if(decision== 1){
                in4 = 0;
            }
        }
    }
    public static class prog_5 {
        public static void main(){
            JOptionPane.showMessageDialog(null,"Welcome");
            String option = "Are you ready to take the quiz?";
            int opt =JOptionPane.showConfirmDialog(null,option);
            if (opt == 0){
                JOptionPane.showMessageDialog(null,"Answer these 10 question, GOOD LUCK!");
                questions();
            } else if (opt == 1) {
                JOptionPane.showMessageDialog(null,"Ok! Just enter this section when your ready ;)");
            }
        }
        private static void questions(){
            String[] que = new String[10];
            for (int i = 0; i <= 9; i++) {
                if (i == 0){
                    que[i] = JOptionPane.showInputDialog("""
                        1. What is the name of the first computer virus?
                        a. ILOVEYOU
                        b. Stuxnet
                        c. Conficker
                        d. Tinba""");
                }else if(i == 1){
                    que[i] = JOptionPane.showInputDialog("""
                        2. First computer was made by ____________.
                        a. Mark Zuckerberg
                        b. Jeff Bezos
                        c. Charles Babbage
                        d. Many Pacquiao""");
                }else if(i == 2){
                    que[i] = JOptionPane.showInputDialog("""
                        3. Who discovers the use of 0?
                        a. Pinoy
                        b. Indians
                        c. Chinese
                        d. None of the above""");
                }else if(i == 3){
                    que[i] = JOptionPane.showInputDialog("""
                        4. When the the first gate is on then the second gate is off (LOGICAL OR), what will be the output?
                        a. on
                        b. off
                        c. brownout
                        d. short circuit""");
                }else if(i == 4){
                    que[i] = JOptionPane.showInputDialog("""
                        5. What is the first calculator?
                        a. Casio
                        b. Abacus
                        c. Hands
                        d. Pascaline""");
                }else if(i == 5){
                    que[i] = JOptionPane.showInputDialog("""
                        6. Who created the first programming language?
                        a. Ada Lovelace
                        b. God
                        c. Larry page
                        d. Sergey Brin""");
                }else if(i == 6){
                    que[i] = JOptionPane.showInputDialog("""
                        7. What is the binary code for "219"?
                        a. 11101101
                        b. 10101110
                        c. 01101111
                        d. 11011011""");
                }else if(i == 7){
                    que[i] = JOptionPane.showInputDialog("""
                        8. In motherboard, what is the voltage regulator?
                        a. VRM
                        b. KRM
                        c. AK47
                        d. RPD""");
                }else if(i == 8){
                    que[i] = JOptionPane.showInputDialog("""
                        9. There are three types of selection in programming, one is if, if-else, and ____ selection?
                        a. crime
                        b. case
                        c. option
                        d. waterfall""");
                }else if(i == 9){
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
        private static void checking(String[] questions){
            String[] ans = {"a","c","b","a","d","a","d","a","b","b"};
            String result = "";
            int score = 0;
            for (int i = 0; i <= 9; i++) {
                if (ans[i].equals(questions[i])){
                    score += 1;
                    result += (i+1) + ". "+ questions[i] + " - correct\n";
                }else{
                    result += (i+1) + ". "+ questions[i] + " - incorrect\n";
                }
            }
            JOptionPane.showMessageDialog(null,"Here is the result:\n"+result+"Your score is " + score + "/10");
            int decision = JOptionPane.showConfirmDialog(null,"Do you want to try again?");
            if (decision == 0){
                questions();
            }
        }
    }
    }