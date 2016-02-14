/*
 * Ngram project
 */
package ngram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author buzzcogs
 */
public class NGramCalculator5 
{
    private class NGram
    {
        int occurence;
        int ndegree;
        protected ArrayList<String> ngram = new ArrayList<>() ;        
        @Override
        public String toString() 
        {
           StringBuffer stringBuf = new StringBuffer();
           for (int i = 0; i < ngram.size(); i++)
           {
               stringBuf.append(ngram.get(i)+ " ");
           }
           stringBuf.append(this.occurence);
           return stringBuf.toString();
        }      
    }

    ArrayList<NGram> ngrams ;     
    ArrayList<NGram> uniqueNGrams ;
    int degree ; 
    String fileName; 
    
    public NGramCalculator5(String fname, int degree)
    {
        this.ngrams = new ArrayList<NGram>();     
        this.uniqueNGrams = new ArrayList<NGram>(); 
        this.degree = degree;
        this.fileName = fname;
    }
    
    public void printNGrams()
    {       
       for (int i = 0; i < this.ngrams.size(); i++) 
       {
          NGram gram = ngrams.get(i);
          gram.toString();
	  System.out.println(gram.toString());
       }
    }
    
    public NGramCalculator5()
    {
        this(" ", 0) ;    
    }
    
    public NGram addNGram(ArrayList<String> ngram, int degree, int occur)
    {
        NGram myGram = new NGram();
        myGram.ngram  = ngram;
        myGram.ndegree = degree;
        this.ngrams.add(myGram);
        
        return new NGram();        
    }
    public int getNGramDegree()
    {
        return this.degree;
    }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)             
    {
        NGramCalculator5 myNGramCalc ;
        int ngramdegree = 0;
        if (args.length < 1 )
        {
            System.out.println("Must include file name and degree n-gram in arguments");
            System.out.println("Syntax: java NGramCalculator <filename> <degree of ngram--default=1>");
            System.exit(1);
        }
        else if (args.length > 1 )
        {
            try 
            {
                ngramdegree = Integer.parseInt(args[1]);
                System.out.println("ngram degree is " +ngramdegree);
            } 
            catch (NumberFormatException e) 
            {
                System.err.println("Argument " + args[1] + " must be an integer.");
                System.exit(1);
            }
                    
        }
        
        Scanner scan = null;
        try 
        {
            String fileName = args[0];
            File hound = new File(fileName);
            System.out.println(hound.getName());
            //System.out.println(hound.length());
            myNGramCalc = new NGramCalculator5(fileName, ngramdegree);
            scan = new Scanner(hound);
            ArrayList<String> currngram =  new ArrayList<String>();
            int p = 0; 
            while (scan.hasNextLine()) 
            {
               Scanner s2 = new Scanner(scan.nextLine());
                
                while (s2.hasNext()) 
                {
                   
                   String nextstr = s2.next();
                   p++;
                   //System.out.println(nextstr + " "+p);
                   currngram.add(nextstr);  
                   // p mod m 
                   // range is p - M, p
                  // if ((p % ngramdegree) == 0)
                   if ( p >= ngramdegree)
                   {
                       ArrayList<String> subgram = new ArrayList<String>(currngram.subList((p-ngramdegree), (p)).size());
                       subgram.addAll(currngram.subList((p-ngramdegree), (p)));
                       myNGramCalc.addNGram(subgram, ngramdegree, 1);
                      //System.out.println(" "+(p-ngramdegree)+ " "+ (p) + " "+currngram.subList((p-ngramdegree), (p)));
                   }
                   
                }

            }
           myNGramCalc.printNGrams();
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println("Argument " + args[0] + " not a file.");
            System.exit(1);
        }   
                       
    }
        // TODO code application logic here
}
    

