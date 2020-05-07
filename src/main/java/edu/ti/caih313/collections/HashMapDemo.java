package edu.ti.caih313.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapDemo
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> histogramPositiveNumbers = new HashMap<Integer, Integer>();
        histogramPositiveNumbers = HashMapDemo.histogramPositiveNumbers();
        for (Integer number : histogramPositiveNumbers.keySet())
        {
           Integer numberOfTimesAppeared = histogramPositiveNumbers.get(number);
           System.out.println("The number " + number + " appears " + numberOfTimesAppeared + " times.");
           System.out.println();
        }

    }

    public static Map<Integer, Integer> histogramPositiveNumbers()
    {
        Map<Integer, Integer> histogramPositiveNumbers = new HashMap<Integer, Integer>();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the numbers into the histogram. Enter a negative number to stop.");
        int number = keyboard.nextInt();
        while (number >= 0)
        {
            if (histogramPositiveNumbers.containsKey(number))
            {
                int value = histogramPositiveNumbers.get(number);
                value++;
                histogramPositiveNumbers.put(number, value);
            }
            else
            {
                histogramPositiveNumbers.put(number, 1);
            }

            number = keyboard.nextInt();
        }

        return histogramPositiveNumbers;
    }
}
