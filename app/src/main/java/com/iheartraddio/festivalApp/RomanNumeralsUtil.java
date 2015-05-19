package com.iheartraddio.festivalApp;

/**
 * Created by kkim on 4/6/15.
 */
public class RomanNumeralsUtil {

    /**
     * Function:This method converts an int to a String that represents
     * its Roman Numeral value:
     *
     * If input is 1, then return value should be "I"
     * If input is 12, then return value should be "XII"
     * @param number
     * @return
     */
    public String convertToRomanNumeral(int number) {
        //setup string builder to add roman numbers to it
        StringBuilder romanNumber = new StringBuilder();
        //create an array of the size 'number'
        String numberSize = Integer.toString(number);
        int arraySize = numberSize.length();
        int [] numberArray = new int[arraySize];
        //seperate the values in the array
        createNumberArray(number, numberArray, arraySize);

        //setup the romanNumber string
        createString(romanNumber, numberArray);

        //romanNumber = correctFormat(romanNumber);

        return "" + romanNumber;
    }

    /**
     * Function:This handles format validation of a roman numeral string
     * i.e.
     * input "IX", return true
     * input "ABCDEF" returns false
     *
     * @param romanNumeral
     * @return
     *
     */
    public boolean isValidRomanNumeral(String romanNumeral) {
        //first check if it is the right format
        for(int i=0;i<romanNumeral.length();i++){
            char item = romanNumeral.charAt(i);
            if(item == 'I' ||
                    item=='V' ||
                    item=='X' ||
                    item=='L' ||
                    item=='C' ||
                    item=='M' ||
                    item=='D'){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    private void createNumberArray(int number, int [] array, int counter){
        int remainder = 0;
        int currentArray = 0;
        while(counter>0){
            remainder = number % 10;
            number = number / 10;
            array[currentArray]=remainder;
            counter --;
            currentArray++;
        }
    }

    private void createString(StringBuilder builder, int [] numberArray){
        int value = 0;
        //check the tens place of the original number through the array.
        for(int i=0;i<numberArray.length;i++){
            value = numberArray[i];
            switch(i){
                //One' place
                case 0:
                    switch(numberArray[i]){
                        case 0:
                            appendBeforeStringBuilder(builder,"0");
                            break;
                        case 1:
                            appendBeforeStringBuilder(builder, "I");
                            break;
                        case 2:
                            appendBeforeStringBuilder(builder, "II");
                            break;
                        case 3:
                            appendBeforeStringBuilder(builder, "III");
                            break;
                        case 4:
                            appendBeforeStringBuilder(builder, "IV");
                            break;
                        case 5:
                            appendBeforeStringBuilder(builder, "V");
                            break;
                        case 6:
                            appendBeforeStringBuilder(builder, "VI");
                            break;
                        case 7:
                            appendBeforeStringBuilder(builder, "VII");
                            break;
                        case 8:
                            appendBeforeStringBuilder(builder, "VIII");
                            break;
                        case 9:
                            appendBeforeStringBuilder(builder, "IX");
                            break;
                        case 10:
                            appendBeforeStringBuilder(builder, "X");
                            break;
                    }
                    break;
                //10's place
                case 1:
                    //Add roman numerals based on the number
                    if(value<4){
                        for(int k=0;k<value;k++){
                            appendBeforeStringBuilder(builder, "X");
                        }
                    }else if(value == 4){
                        appendBeforeStringBuilder(builder, "XL");
                    }else if(5<=value && value<=8){
                        if(value==6){
                            appendBeforeStringBuilder(builder, "X");
                        }else if(value==7){
                            appendBeforeStringBuilder(builder, "X");
                            appendBeforeStringBuilder(builder, "X");
                        }else if(value==8){
                            appendBeforeStringBuilder(builder, "X");
                            appendBeforeStringBuilder(builder, "X");
                            appendBeforeStringBuilder(builder, "X");
                        }
                        appendBeforeStringBuilder(builder, "L");
                    }else if(value == 9){
                        appendBeforeStringBuilder(builder, "XC");
                    }
                    break;
                //100's place
                case 2:
                    if(value<4){
                        for(int k=0;k<value;k++){
                            appendBeforeStringBuilder(builder, "C");
                        }
                    }else if(value==4){
                        appendBeforeStringBuilder(builder, "CD");
                    }else if(value==5){
                        appendBeforeStringBuilder(builder, "D");
                    }else if(6<=value && value<=8){
                        if (value == 6){
                            appendBeforeStringBuilder(builder, "C");
                        }else if(value == 7){
                            appendBeforeStringBuilder(builder, "C");
                            appendBeforeStringBuilder(builder, "C");
                        }else if(value ==8){
                            appendBeforeStringBuilder(builder, "C");
                            appendBeforeStringBuilder(builder, "C");
                            appendBeforeStringBuilder(builder, "C");
                        }
                        appendBeforeStringBuilder(builder, "D");
                    }else if(value == 9){
                        appendBeforeStringBuilder(builder, "CM");
                    }
                    break;
                //1000's place
                case 3:
                    for(int k=0;k<value;k++){
                        appendBeforeStringBuilder(builder, "M");
                    }
                    break;
                //10,000's place
                case 4:
                    break;
                //100,000's place
                case 5:
                    break;
                //1,000,000's place
                case 6:
                    break;
                //10,000,000's place
                case 7:
                    break;
                //100,000,000's place
                case 8:
                    break;
                //1,000,000,000's place
                case 9:
                    break;
            }
        }
    }
    public StringBuilder correctFormat(StringBuilder romanNumber){
        StringBuilder newNumber = new StringBuilder();
        int counter = romanNumber.length()-1;
        for(int i=0;i<romanNumber.length();i++){
            newNumber.append(romanNumber.charAt(counter));
            counter --;
        }
        return newNumber;
    }

    public void appendBeforeStringBuilder(StringBuilder romanNumber, String numeral){
        if(romanNumber.length()>0){
            StringBuilder newBuilder = new StringBuilder();
            //first append new numeral before adding on old string.
            newBuilder.append(numeral);
            newBuilder.append(romanNumber);
            romanNumber.setLength(newBuilder.length());
            for(int i=newBuilder.length();i>0;i--){
                romanNumber.setCharAt(i-1,newBuilder.charAt(i-1));
            }
        }else if(romanNumber.length()==0){
            romanNumber.append(numeral);
        }
    }
}
