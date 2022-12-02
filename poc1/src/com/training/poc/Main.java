package com.training.poc;
import java.util.*;
import java.io.*;
import javax.lang.model.util.ElementScanner14;
public class Main {
    public static void main(String[] args) throws CsvException  
    {
        //variable that will be used further
        String path="C:\\POC\\read-file-java-poc1.csv";
        String line;
        List<header> headerPojos=new ArrayList<>();
        List<List<lineitem>> lineitems=new ArrayList<>();
        HashMap<String,List<lineitem>> hashmap=new HashMap<>();
        String header="";
        //updated
        int actualtotallines=0;
        int countLines=0;
        //
        int HeaderFeilds=0;
        int LineFeilds=0;
        double totalAmt=0;
        double amountLines=0;
        //if it dosent exist then it will give a exception which must be handeled
        try (BufferedReader br =new BufferedReader(new FileReader(path))) 
        {
         //to store the header value in string variable named header              
         header=br.readLine();
        // System.out.println("the header feilds are---");
        //split the string ';' as char regex
         String[] Hd= (header.split(";"));
         HeaderFeilds=Hd.length;
         String recordTypeL=Hd[0];
         int totalLines=Integer.parseInt(Hd[1]);
         actualtotallines=totalLines;
          totalAmt=Double.parseDouble(Hd[2]);
         int minAmt=Integer.parseInt(Hd[3]);
         String currentDate=Hd[4].replace(',', ' ');

        //store the parameters in the HeadPojo by using the constructors
         header hm=new header(recordTypeL,totalLines,totalAmt,minAmt,currentDate);

        //print the stored values in the form of string
        System.out.println(hm.toString());

        //used for the storing the pojo values in the arrayList
        headerPojos.add(hm);


        //System.out.println("the Line feilds are --");
            while((line = br.readLine()) != null)
            {
                //split the string ';' as char regex
                String ar[]=(line.split(";"));
                LineFeilds=ar.length;
                //recive all the values from the array and store in the variables by type conversion of few
                String recordType=ar[0];
                int lineNumber=Integer.parseInt(ar[1]);
                String refDocNum=ar[2];
                String city=ar[3];
                String amt=ar[4].replace(',', ' ');
                 double amount=Double.parseDouble(amt); 
                 //usedd a constructor to store it in LinesPojo
                lineitem Lp=new lineitem(recordType,lineNumber,refDocNum,city,amount);
                List<lineitem> linespojo=new ArrayList<>();
                linespojo.add(Lp);
                lineitems.add(linespojo);
                countLines++;
            }
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        //store the values in the hashmap
        
        for(List<lineitem> lr: lineitems)
        {
            for(lineitem po:lr)
            {
                
                amountLines+=po.getAmount();
                hashmap.put(po.getRefDocNum(), lr);
            }

        }

        
            //System.out.println(amountLines);
        
        
        //for printing the hashmap values with respective to the refdocnum and value as LinesPojo .
        //after checking for all the exception 
        validate(actualtotallines, countLines, hashmap, totalAmt, amountLines, HeaderFeilds, LineFeilds);
        
        }   
    

    static void validate (int actualtotallines,int countLines,HashMap<String,List<lineitem>> hashmap,double totalAmt,double amountLines,int HeaderFeilds,
    int LineFeilds) throws CsvException
    {    
        if(actualtotallines!=countLines)
        {
            throw new CsvException("Header values are not matching with Line Values");
        }
        else if(totalAmt!=amountLines)
        {
            throw new CsvException("Total amt in header is not matching with Line amt");
        }
        else if(HeaderFeilds!=LineFeilds)
        {
            throw new CsvException("Feilds of Header and Lines are not Matching");
        }
        else 
        {
            System.out.println("\nhashmap:"+hashmap);
        }
           
    }  

}
    
    





