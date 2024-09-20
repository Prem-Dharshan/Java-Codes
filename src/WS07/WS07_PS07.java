/*
7. Your English literature friend is very happy with the code you gave him. Now for his research,
he used your application to find character frequency in many novels. For larger novels, the
application takes a lot of time for computation. So he called you on a fine Sunday to discuss
this with you. He wanted to know whether you can improve the speed of the application.
You decided to modify the application by using multiple threads to reduce the computation
time. For this, accept the number of counters or threads at the beginning of the problem and
get the string for each counter or thread. Create a thread by extending the Thread class and
take the user entered string as input. Each thread calculates the character frequency for the
word assigned to that thread. All the counts are stored locally in the thread and once all the
threads are completed print the character frequency for each of the threads.
Create a class Main and test it.
Input and Output format:
Refer to sample Input and Output for formatting specifications.
Sample input and output:
Enter Number of Counters:2
Enter text for counter 1: FrequencyCounter
Enter text for counter 2: JavaTheCompleteReference
Counter 1 Result :
C:1 F:1 c:1 e:3 n:2 o:1 q:1 r:2 t:1 u:2 y:1
Counter 2 Result :
C:1 J:1 R:1 T:1 a:2 c:1 e:7 f:1 h:1 l:1 m:1 n:1 o:1 p:1 r:1 t:1 v:1
 */

package WS07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class FrequencyCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of Counters: ");
        int numCounters = scanner.nextInt();
        scanner.nextLine();

        FrequencyCounterThread[] threads = new FrequencyCounterThread[numCounters];

        for (int i = 0; i < numCounters; i++) {
            System.out.print("Enter text for counter " + (i + 1) + ": ");
            String text = scanner.nextLine();
            threads[i] = new FrequencyCounterThread(text);
            threads[i].start();
        }

        for (int i = 0; i < numCounters; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Counter " + (i + 1) + " Result : ");
            Map<Character, Integer> frequencyMap = threads[i].getFrequencyMap();
            frequencyMap.forEach((ch, freq) -> System.out.print(ch + ":" + freq + " "));
            System.out.println();
        }

        scanner.close();
    }
}

class FrequencyCounterThread extends Thread {
    private final String text;
    private final Map<Character, Integer> frequencyMap = new HashMap<>();

    public FrequencyCounterThread(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
    }

    public Map<Character, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}
