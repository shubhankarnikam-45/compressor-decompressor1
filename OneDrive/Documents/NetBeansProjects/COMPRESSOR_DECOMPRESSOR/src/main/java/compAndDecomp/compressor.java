/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compAndDecomp;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;


/**
 *
 * @author shubhankar nikam
 */
public class compressor {
    
    public static void method(File file) throws IOException
    {
        //this .getParent() function will give me parent directory 
        //if compresssed the file then this must be present in the same directory.
        String fileDirectory = file.getParent();
        
        //using 'FileInputStream' class we read the input 'bits' of the file.
        FileInputStream fis = new FileInputStream(file);
        //created the 'FileOutputStream' to write bit to file.
        FileOutputStream fos = new FileOutputStream(fileDirectory +"/CompressedFile.gz"); 
        
        //now we use the 'GZIPOutputStream' class this take 'fos' as input.
        //becaseu we want to compresss the output file.
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        
        //created the byte array to store the input data.
        byte[] buffer = new byte[1024];
        
        //created 'len' variable to store the single 'byte'
        int len;
        
        //here we write the byte to the 'gzip' fle.
        while((len = fis.read(buffer)) != -1)
        {
            gzip.write(buffer, 0, len);
        }
        
        //closing the resoureces.
        gzip.close();
        fos.close();
        fis.close();
        
        
        
        
        
        
        
        
    }
    
    //main function.
    public static void main(String[]args) throws IOException
    {
        File path = new File("/Users/shubhankar nikam/Downloads/demo/com");
        
        //calling function 'method'
        method(path);
    }
}
