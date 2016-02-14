/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ngram;

import java.io.File;


/**
 *
 * @author buzzcogs
 */
public class DirListing 
{
    public static void main(String[] args) 
    {
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
    }       
      
}
