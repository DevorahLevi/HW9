package edu.ti.caih313.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextFileArrayList
{
    public static void main(String[] args)
    {
        List<List> textFile = new ArrayList<List>();


        textFile = TextFileArrayList.getArrayListOfArrayLists();
        for (int i = 0; i < textFile.size(); i++)
        {
            for (int j = 0; j < textFile.get(i).size(); j++)
            {
                System.out.println(textFile.get(i).get(j));
            }
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a sentence number followed by a word number and that word will be displayed.");
        int sentenceNumber = keyboard.nextInt();
        int wordNumber = keyboard.nextInt();
        if ((sentenceNumber > textFile.size()) || (wordNumber > textFile.get(sentenceNumber).size()) ||
                (sentenceNumber == 0) || (wordNumber == 0))
        {
            System.out.println("Sorry, the number you have entered is an invalid position number.");
        }
        else
        {
            sentenceNumber--;
            wordNumber--;
            List<String> sentence = textFile.get(sentenceNumber);
            String word = sentence.get(wordNumber);
            System.out.println(word);
        }

    }

    public static List<List> getArrayListOfArrayLists()
    {
        List<List> sentencesList = new ArrayList<List>();

        String resourceFolder = "src/main/resources";
        String fileName = resourceFolder + "/" + "Homework.txt";

        Scanner inputStream = null;
        try
        {
            File file = new File(fileName);
            inputStream = new Scanner(file);

            while(inputStream.hasNextLine())
            {
               List<String> wordList = new ArrayList<String>();
               String line = inputStream.nextLine();
               String [] words = line.split(" ");
               for (int i = 0; i < words.length; i++)
               {
                   wordList.add(words[i]);
               }
               sentencesList.add(wordList);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error opening the file " + fileName + ": " + e.getMessage());
        }
        finally
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
        }
        return sentencesList;
    }
}
