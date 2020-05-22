package org.dshimanskii;

public class Validator {

    public Validator() {
    }

    public boolean validateAllDigitsAre16bits(String input){
        //System.out.println("16 bit validation activated");
        String[] bitsValidationCOnversion;

        bitsValidationCOnversion = input.replaceAll("\\D+"," ").split(" ");
        //System.out.println(bitsValidationCOnversion.toString());
        for (String strTemp : bitsValidationCOnversion){
            try{
                //System.out.println(strTemp);
                int valueCheck = Integer.parseInt(strTemp);
                if( valueCheck > 65535 || valueCheck < 0){
                    System.out.println("please provide numbers ONLY in range 0-65535");
                    return true;
                }
            }catch (NumberFormatException e){
                System.out.println("please provide numbers ONLY in range 0-65535");
                return true;
            }


        }
        return false;
    }

    public boolean validateNotEmpty(String input){
        if ( input.isEmpty()){
            System.out.println("Looks like you've forgotten to type the expression");
            return true;
        }
        return false;
    }
}
