package org.shivansh.StringCalculator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {
  public int add(String numbers){
          if(numbers.isEmpty()){
              return 0;
          }
     /*
     here we converted the comma separated string to array of strings
      */
      String[]numberStrings = numbers.split(",");

    /*
   returning sum of all the number strings
   */
      return Arrays.stream(numberStrings).mapToInt(Integer::parseInt).sum();

      }
  }

