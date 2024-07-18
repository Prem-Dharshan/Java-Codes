// 11. Write a program for Horizon Phones, a provider of cellular phone service. Prompt a user for
// maximum monthly values for talk minutes used, text messages sent, and gigabytes of data
// used, and then recommend the best plan for the customer’s needs. A customer who needs fewer
// than 500 minutes of talk and no text or data should accept Plan A at $49 per month. A customer
// who needs fewer than 500 minutes of talk and any text messages should accept Plan B at $55
// per month. A customer who needs 500 or more minutes of talk and no data should accept either
// Plan C for up to 100 text messages at $61 per month or Plan D for 100 text messages or more
// at $70 per month. A customer who needs any data should accept Plan E for up to 3 gigabytes
// at $79 or Plan F for 3 gigabytes or more at $87.

package WS02;

import java.util.Scanner;

class HorizonPhones {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter maximum monthly talk minutes: ");
            int talkMinutes = scanner.nextInt();

            System.out.print("Enter maximum monthly text messages: ");
            int textMessages = scanner.nextInt();

            System.out.print("Enter maximum monthly gigabytes of data: ");
            int dataGB = scanner.nextInt();

            String recommendedPlan = recommendPlan(talkMinutes, textMessages, dataGB);
            System.out.println("Recommended Plan: " + recommendedPlan);
        }
    }

    public static String recommendPlan(int talkMinutes, int textMessages, int dataGB) {
        if (talkMinutes < 500 && textMessages == 0 && dataGB == 0) {
            return "Plan A - $49 per month";
        } else if (talkMinutes < 500 && textMessages > 0) {
            return "Plan B - $55 per month";
        } else if (talkMinutes >= 500 && dataGB == 0) {
            if (textMessages <= 100) {
                return "Plan C - $61 per month";
            } else {
                return "Plan D - $70 per month";
            }
        } else if (dataGB <= 3) {
            return "Plan E - $79 per month";
        } else {
            return "Plan F - $87 per month";
        }
    }
}
