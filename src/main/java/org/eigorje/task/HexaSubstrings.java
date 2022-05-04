/*
* For hexadecimal numbers return min and max of sorted set of substrings
* Only substring starting with letter and ending with number are considered at response.
*
* Examle for a01 substings are "a" "0" "1" "a0" "a01" "01"
* so response should be a0 as min and a01 as max
*
* Assert.assertTrue(findSubstrings("a01").equals("a0 a01"));
* Assert.assertTrue(findSubstrings("7961686f6f").equals("f6 f6"));
*
* as substring needs to start with a letter and finish with a number
*
*
* abcde12345 -> e1 e12 e123 e1234 e12345 -> e1 e12345
* */

package org.eigorje.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HexaSubstrings {

    public static void main (String[] args) {
     findSubstrings("7961686f6f");
    }

    public static String findSubstrings(String inputString){

    List <Integer> indexesWithLetters = new ArrayList<>();
      for (int i = 0; i < inputString.length(); i++){
        if (Character.isLetter(inputString.charAt(i))){
            indexesWithLetters.add(i);
        }
    }

    Set <String> substrings = new TreeSet<>();
      for (int j = 0; j < indexesWithLetters.size(); j++){
        String substring = "";
        if (j < indexesWithLetters.size() -1){
            substring = inputString.substring(indexesWithLetters.get(j), indexesWithLetters.get(j+1));
        } else {
            substring = inputString.substring(indexesWithLetters.get(j));
        }
        if (substring.length() > 1 ) substrings.add(substring);
    }

      substrings.forEach(System.out::println);
        System.out.print("===> ");
      for (String s :substrings.stream().collect(Collectors.toList())){
        if (s.length() > 2){
            substrings.addAll(createSubStrings(s));
        }
    }

    List <String> subStringList = substrings.stream().collect(Collectors.toList());
      if (subStringList.isEmpty()) return "";

      if (subStringList.size() > 1){
          System.out.println(subStringList.get(0) + " " + subStringList.get(subStringList.size()-1));
        return subStringList.get(0) + " " + subStringList.get(subStringList.size()-1);
    } else {
          System.out.println(subStringList.get(0) + " " + subStringList.get(0));
        return subStringList.get(0) + " " + subStringList.get(0);
    }
}

    private static Set <String> createSubStrings(String s){
        Set <String> setTemp = new TreeSet<>();
        for (int i = s.length()-1; i > 1; i --){
            setTemp.add(s.substring(0, i));
        }
        return setTemp;
    }

}
