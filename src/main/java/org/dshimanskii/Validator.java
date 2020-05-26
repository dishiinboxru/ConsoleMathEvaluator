package org.dshimanskii;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public Validator() {
    }

    public boolean validateAllDigitsAre16bits(String input){
        //System.out.println("16 bit validation activated");
        String[] bitsValidationConversion;

        bitsValidationConversion = input.replaceAll("\\D+"," ").split(" ");
        //System.out.println(bitsValidationConversion.toString());
        for (String strTemp : bitsValidationConversion){
            try{
                //System.out.println(strTemp);
                int valueCheck = Integer.parseInt(strTemp);
                if( valueCheck > 65535 || valueCheck < 0){
                    System.out.println("please provide numbers ONLY in range 0-65535");
                    return false;
                }
            }catch (NumberFormatException e){
                System.out.println("please provide numbers ONLY in range 0-65535");
                return false;
            }
        }
        return true;
    }

    public boolean validateNotEmpty(String input){
        if ( input.isEmpty()){
            System.out.println("Looks like you've forgotten to type the expression");
            return false;
        }
        return true;
    }

    public boolean validateNoDoubleSlash ( String input){
        if ( input.contains("//")){
            System.out.println("Mind your math, double // is an error");
            return false;
        }
        return true;
    }

    public boolean validateMathExpression (String input ){

        String patternString = "([^0-9()\\-+\\/\\s\\*\\w])|([a-zA-Z]{2,})";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            System.out.println("Looks like you got words or special characters there, try entering without them");
            return false;
        }
        return true;
    }
}
