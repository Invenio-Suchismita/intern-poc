package com.training.poc;
import java.util.*;
import java.io.*;
import javax.lang.model.util.ElementScanner14;
public class Main {
    public static void main(String[] args) throws CsvException  
    {
        
        String path="C:\\POC\\read-file-java-poc1.csv";
        String line;
        List<header> headerPojos=new ArrayList<>();
        List<List<lineitem>> lineitems=new ArrayList<>();
        HashMap<String,List<lineitem>> hashmap=new HashMap<>();
        String header="";
        
        int actualtotallines=0;
        int countLines=0;
       
        int HeaderFeilds=0;
        int LineFeilds=0;
        double totalAmt=0;
        double amountLines=0;
        
        try (BufferedReader br =new BufferedReader(new FileReader(path))) 
        {
                     
         header=br.readLine();
        
        
         String[] Hd= (header.split(";"));
         HeaderFeilds=Hd.length;
         String recordTypeL=Hd[0];
         int totalLines=Integer.parseInt(Hd[1]);
         actualtotallines=totalLines;
          totalAmt=Double.parseDouble(Hd[2]);
         int minAmt=Integer.parseInt(Hd[3]);
         String currentDate=Hd[4].replace(',', ' ');

        
         header hm=new header(recordTypeL,totalLines,totalAmt,minAmt,currentDate);

        
        System.out.println(hm.toString());

        
        headerPojos.add(hm);


        
            while((line = br.readLine()) != null)
            {
                
                String ar[]=(line.split(";"));
                LineFeilds=ar.length;
                
                String recordType=ar[0];
                int lineNumber=Integer.parseInt(ar[1]);
                String refDocNum=ar[2];
                String city=ar[3];
                String amt=ar[4].replace(',', ' ');
                 double amount=Double.parseDouble(amt); 
                 
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
        
        
        
        for(List<lineitem> lr: lineitems)
        {
            for(lineitem po:lr)
            {
                
                amountLines+=po.getAmount();
                hashmap.put(po.getRefDocNum(), lr);
            }

        }

        
            
        
        
        
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
    
    





