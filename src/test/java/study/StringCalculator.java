package study;

public class StringCalculator {

    int calculate(String[] strInput) {
        int result = convertToInt(strInput[0]);

        // 1 + 3
        // 1 + 4 + 3
        for(int i=1; i < strInput.length; i++) {
            if(i == 0) {

            } else {
                if(strInput[i].equals("+")) {
                    result = result + convertToInt(strInput[i+1]);
                } else if(strInput[i].equals("-")) {
                    result = result - convertToInt(strInput[i+1]);
                } else if(strInput[i].equals("/")) {
                    result = result / convertToInt(strInput[i+1]);
                } else if(strInput[i].equals("*")) {
                    result = result * convertToInt(strInput[i+1]);
                }
            }
        }
        System.out.println("result : " + result);
        return result;
    }

    int convertToInt(String input) {
        return Integer.parseInt(input);
    }

}
