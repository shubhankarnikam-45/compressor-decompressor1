/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compAndDecomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author shubhankar nikam
 */
public class decompressor {
    
     public static void method(File file) throws IOException
    {
        //this .getParent() function will give me parent directory 
        //if compresssed the file then this must be present in the same directory.
        String fileDirectory = file.getParent();
        
        //using 'FileInputStream' class we read the input 'bits' of the file.
        FileInputStream fis = new FileInputStream(file);
        
        //to read the compressed data we use the `GZIPInputStream`
        GZIPInputStream gzip = new GZIPInputStream(fis);
        
         //created the 'FileOutputStream' to write bit to file.
        FileOutputStream fos = new FileOutputStream(fileDirectory +"/DecompressedFile");
        
        //same logic as the 'compressed' file.
        byte[] buffer = new byte[1024];
        
        //len variable.
        int len;
        
        while((len = gzip.read(buffer)) != -1)
        {
            fos.write(buffer, 0, len);
        }
        
        //close the resouoreds.
        fos.close();
        gzip.close();
        fis.close();
    }
     
     //main function.
     public static void main(String[]args) throws IOException
     {
         File path = new File("/Users/shubhankar nikam/Downloads/demo/CompressedFile.gz");
         method(path);
     }
    
}
