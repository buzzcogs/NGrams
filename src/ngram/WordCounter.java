/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ngram;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author buzzcogs
 */
public class WordCounter 
{
    public static void main (String args [])
    {
        Vector vocab =  new Vector(1000);
     //   Scanner scan = new Scanner(System.in);
        
        File hound = new File("C:\\Users\\buzzcogs\\Documents\\textfiles\\doyle-hound-383.txt");
        Scanner scan;
        try
        {
            scan = new Scanner(hound);
            int i;
            while (scan.hasNext())
            {
                Association wordInfo;
                String vocabWord;

                String word = scan.next();
                for ( i = 0; i < vocab.size(); i++)
                {
                    wordInfo = (Association)vocab.get(i);
                    vocabWord = (String)wordInfo.getKey();
                    if (vocabWord.equals(word))
                    {
                        Integer f = (Integer)wordInfo.getValue();
                        wordInfo.setValue(new Integer(f.intValue()+ 1));
                        break;
                    }
                }
                if (i == vocab.size())
                {
                    vocab.add(new Association(word, new Integer(1)));
                }

                for (i = 0; i < vocab.size(); i++)
                {
                    Association wordInfo2 = (Association)vocab.get(i);
                    System.out.println(wordInfo2.getKey()+" occurs " +
                                       wordInfo2.getValue()+" times");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
