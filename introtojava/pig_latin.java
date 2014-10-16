import java.util.*;
import java.util.regex.*;
public class pig_latin
{
    
   public static void main(String args[]){
       String entry;
       Scanner s = new Scanner(System.in);
       System.out.print("Enter a word or sentence to translate to Pig Latin!: ");
       entry = s.nextLine();
       entry = entry.replaceAll("[^a-zA-Z0-9\\s]", "");
       String[] words = entry.split("\\s");
       String translatedSentence="";
       for (int z = 0; z < words.length; z++){
           try{
           if (words[z] != null && String.valueOf(words[z].charAt(0)).matches("\\w")){
               translatedSentence = translatedSentence+translateWord(words[z])+" ";     
            }
        }
        catch(StringIndexOutOfBoundsException e){
        }
    }
       System.out.println("Translated Sentence: "+translatedSentence);
}
public static String translateWord(String word){
 
       String[] vowels = {"a", "e", "i", "o", "u"};
       String[] silentConsonants = {"wr", "kn", "mn", "mb", "pt", "gh"};
       String[] digraphs = {"sc", "ng", "ch", "ck", "gh", "ph", "rh", "sh", "th", "wh", "zh", "ci", "wr", "qu"};
       boolean vowelDetected = false, silentConsDetected = false;
       String translated = "";
       
       for(String vowel : vowels){
       if (String.valueOf(word.charAt(0)).equalsIgnoreCase(vowel)){
           vowelDetected = true;
           translated = word + "way";
        }       
    }
    if (!vowelDetected){
        String firstTwo = word.substring(0,2);
        for(String silentCons : silentConsonants){
            if(firstTwo.equalsIgnoreCase(silentCons)){
                silentConsDetected = true;
                translated = word + "way";
            }
        }
    }
    if(!silentConsDetected && !vowelDetected){
        int indexOfVowel = 0;
        boolean digraphPositive = false;
        String firstTwo = word.substring(0,2);
        for(String di:digraphs){
            if(firstTwo.equalsIgnoreCase(di)){
                translated = word.substring(2) + firstTwo + "ay";
                digraphPositive = true;
            }
        }
        if(!digraphPositive){
        translated = word.substring(1) +  word.charAt(0) + "ay";}
    }
    return translated;
}
}
