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
        int sentenceNumber = keyboard.nextInt() - 1;
        int wordNumber = keyboard.nextInt() - 1;
        if ( (sentenceNumber < 0) || (wordNumber < 0) ||
                (sentenceNumber > (textFile.size() - 1)) || (wordNumber > (textFile.get(sentenceNumber).size() - 1)) )
        {
            System.out.println("Sorry, the number you have entered is an invalid position number.");
        }
        else
        {
            List<String> sentence = textFile.get(sentenceNumber);
            String word = sentence.get(wordNumber);
            System.out.println(word);
        }
    }

    public static List<List> getArrayListOfArrayLists()
    {
        List<List> sentencesList = new ArrayList<List>();

        String resourceFolder = "src/main/resources";
        String fileName = resourceFolder + "/" + "sample_text.txt";

        Scanner inputStream = null;
        try
        {
            File file = new File(fileName);
            inputStream = new Scanner(file);

            String fileString = "";
            while(inputStream.hasNextLine())
            {
                fileString += (inputStream.nextLine() + " ");
            }
            String [] fileSentences = fileString.split("(?<=[.!?])\\s*");
            for (int i = 0; i < fileSentences.length; i++)
            {
                String sentence = fileSentences[i];
                String [] words = sentence.split(" ");

                List<String> wordList = new ArrayList<String>();
                for (int j = 0; j < words.length; j++)
                {
                    wordList.add(words[j]);
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