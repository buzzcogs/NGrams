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
public class NGramCalculator4 
{
    private class NGram
    {
        int occurence;
        int ndegree;
        protected List<String> ngram = new ArrayList<>() ;        
        @Override
        public String toString() 
        {
           return "" + ngram + ", " + occurence;
        }      
    }

    ArrayList<NGram> ngrams ;     
    ArrayList<NGram> uniqueNGrams ;
    int degree ; 
    String fileName; 
    
    public NGramCalculator4(String fname, int degree)
    {
        this.ngrams = new ArrayList<NGram>();     
        this.uniqueNGrams = new ArrayList<NGram>(); 
        this.degree = degree;
        this.fileName = fname;
    }
    
    public void printNGrams()
    {       
        Iterator<NGram> ngramPrintIter = ngrams.iterator();
        while (ngramPrintIter.hasNext()) 
        {
            System.out.println(ngramPrintIter.next());
        }
    }
    
    public NGramCalculator4()
    {
        this(" ", 0) ;    
    }
    
    public NGram addNGram(List<String> ngram, int degree, int occur)
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
        NGramCalculator4 myNGramCalc ;
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
            System.out.println(hound.length());
            myNGramCalc = new NGramCalculator4(fileName, ngramdegree);
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
                      myNGramCalc.addNGram(currngram.subList((p-ngramdegree), (p)), ngramdegree, 1);
                      System.out.println(" "+(p-ngramdegree)+ " "+ (p) + " "+currngram.subList((p-ngramdegree), (p)));
                   }
                   
                }

            }
           // myNGramCalc.printNGrams();
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println("Argument " + args[0] + " not a file.");
            System.exit(1);
        }   
                       
    }
        // TODO code application logic here
}
    

