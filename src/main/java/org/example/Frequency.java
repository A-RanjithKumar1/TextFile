package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Frequency
{
    static void countWords(String filename, Map<String, Integer> words) throws FileNotFoundException {
        Scanner file=new Scanner (new File(filename));
        while(file.hasNext()){
            String word=file.next();
            Integer count=words.get(word);
            if(count!=null)
                count++;
            else
                count=1;
            words.put(word,count);
        }
        file.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        final Logger l =  Logger.getLogger("InfoLogging");
        List s=  new ArrayList();
        String dump;
        Map<String,Integer> words=new HashMap<String, Integer>();
        countWords("C:\\Users\\Tringapps-User13\\OneDrive\\Desktop\\Demo.txt",words);
        l.log(Level.INFO,()->" "+ words);
        List<String> keyList = new ArrayList<String>(words.keySet());
        List<Integer> valueList = new ArrayList<Integer>(words.values());
        l.log(Level.INFO,()->" "+keyList);
        l.log(Level.INFO,()->" "+ valueList);
        Collections.sort(valueList, Collections.reverseOrder());
        for(int i:(valueList)){
            for(Entry< String,Integer> entry: words.entrySet()) {
                if(entry.getValue() == i) {
                    dump=entry.getKey()+"--"+i;
                    s.add(dump);
                }
            }
        }
        l.log(Level.INFO,()->""+s);
    }
}