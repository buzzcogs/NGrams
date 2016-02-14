/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author buzzcogs
 */
public class SampleNGram 
{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner scan = null;
        String dirname = "C:\\Users\\buzzcogs\\Documents\\textfiles";
        File textdir = new File(dirname);
        if (textdir.isDirectory())
        {
            File [] dirlist = textdir.listFiles();
            for(int i = 0; i < dirlist.length; i++)
            {
                System.out.println(dirlist[i].getName());
                System.out.println(dirlist[i].length());
            }
        }
            
        try 
        {
            File hound = new File("C:\\Users\\buzzcogs\\Documents\\textfiles\\coleridge-kubla-370.txt");
            System.out.println(hound.getName());
            System.out.println(hound.length());
            scan = new Scanner(hound);
            String [] trigram = {"5", "6", "7"};
            int q = 0;
            while (scan.hasNextLine()) 
            {
                Scanner s2 = new Scanner(scan.nextLine());  
                q++;
                int p = 0;
                while (s2.hasNext()) 
                {
                   p++;
                   trigram[0] = trigram[1];
                   trigram[1] = trigram[2];
                   trigram[2] = s2.next();
                  
                   if (p > 2)
                   {
                       System.out.print(q);
                       System.out.print(' ');
                       System.out.print(trigram[0]);
                       System.out.print(' ');
                       System.out.print(trigram[1]);
                       System.out.print(' ');
                       System.out.print(trigram[2]);
                       System.out.print(' ');
                       System.out.print(p);
                       System.out.print('\n');
                   }
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();  
        }   
                       
    }
        // TODO code application logic here
}
    

