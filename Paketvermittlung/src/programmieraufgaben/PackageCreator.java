package programmieraufgaben;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PackageCreator {

   
    public DataPackage fillParameters(DataPackage dataPackage) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie IP Version (4 or 6) ein : ");
        dataPackage.setVersion(sc.nextInt());
        
        System.out.println("Geben Sie Ihre IP Adresse ein : ");
        dataPackage.setSender(sc.next());
        
        System.out.println("Geben Sie die Ip Adresse von Ihre Gegner ein : ");
        dataPackage.setReciver(sc.next());
        
        System.out.println("Schreiben Sie Ihre Nachricht (endet mit <CR><LF>) : ");
        String word="";
        while(sc.hasNext()&&!word.equalsIgnoreCase("<CR><LF>"))
        {
            word = sc.next();
            if( word.length() <= dataPackage.getDataPackageLength())
            {
                char [] toChar = word.toCharArray();
                dataPackage.setData(toChar);
            }
            else
            {
                
                System.out.println("Die Nachricht kann nicht versendet werden, da sie ein Wort mit Länge > Maximum Datenteilslänge");
                break;
            }
        }
        return dataPackage;
    }

   
    public List<DataPackage> splitPackage(DataPackage dataPackage) {
        List<DataPackage> dataPackages = new LinkedList<>();
        char [] data = dataPackage.getData();  // whole Massege
       int index=0;
       int oIndex=0;
       String word = "";
       String [] words = new String [1024];
       String [] others = new String[1024];
       
       for(int i=0;i<data.length;i++)
       {
           if(Character.isLetter(data[i]))
           {
               word += data[i];
           }
           else
           {
               words[index] = word;
               word ="";
               index++;
               
               others [oIndex] = Character.toString(data[i]);
               oIndex++;
           }
               
       }
       
       System.out.println(words.length);
       System.out.println(others.length);
       int packetNumber =1;
       DataPackage p = new DataPackage(1);
        for (String word1 : words) {
            if ((p.getDataPackageLength() < dataPackage.getDataPackageLength()) && (word1.length() < (dataPackage.getDataPackageLength() - p.getDataPackageLength()))) {
                char[] tmp = word1.toCharArray();
                String tmpS = Arrays.toString(p.getData())+Arrays.toString(tmp);
                p.setData(tmpS.toCharArray());
                for (String other : others) {
                   char[] tmp1 = other.toCharArray();
                    String tmpO = Arrays.toString(p.getData())+Arrays.toString(tmp1);
                     p.setData(tmpO.toCharArray());
                    p.setDataPackageLength(p.getDataPackageLength()+tmp.length+tmp1.length);
                } 
            } else {
                p.setPacketNumber(packetNumber);
                packetNumber++;
                p.setDataSize(p.getData().length);
                p.setReciver(dataPackage.getReciver());
                p.setSender(dataPackage.getSender());
                p.setVersion(dataPackage.getVersion());
                dataPackages.add(p);
                p = new DataPackage(0);
            }
        }
        
        return dataPackages;
    }

    
    public void printOutPackage(List<DataPackage> dataPackages) {
        
        Iterator<DataPackage> it = dataPackages.iterator();
        while(it.hasNext())
        {
            DataPackage pkg = it.next();
            pkg.toString();
        }

    }
}
