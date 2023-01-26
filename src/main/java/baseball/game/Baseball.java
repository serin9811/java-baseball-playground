package baseball.game;

import java.util.Scanner;

class Baseball {

    // 같은 수가 같은 자리에 있으면 스트라이크
    // 같은 수가 다른 자리에 있으면 볼
    // 같은 수가 전혀 없으면 포볼 또는 낫싱
    // 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다
    static int computersNumber = 0;
    static boolean isGameOnGoing = true;
    static boolean isPrintingQuestion = true;

    public static int receiveInput() {
        if(isPrintingQuestion) System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }
    public static void main(String[]args){
        while (isGameOnGoing) {
            if(computersNumber == 0) pickComputersNumber();
            int input = receiveInput();
            if(input == 1) {
                isPrintingQuestion = true;
                pickComputersNumber();
                input = receiveInput();
            }


            if(input == 2) {
                isGameOnGoing = false;
                System.exit(0);
            }

            if(input != 1 && input != 2) {
                System.out.println(matchGame(input));
            }
        }
    }

    private static void pickComputersNumber() {
        int[] numbers = new int[3];
        int randomNumber = 0;

        for(int i=0; i < numbers.length; i++) {
            do {
                randomNumber = (int)(Math.random() * 10);
            } while (isAlreadyExistingNumber(numbers, randomNumber));
            numbers[i] = randomNumber;
        }

        String tmp = "";
        for(int i=0; i < numbers.length; i++) {
            tmp += numbers[i]+ "";
        }
        System.out.println("상대방이 선택한 수 : " + tmp);
        computersNumber = Integer.valueOf(tmp);
    }

    private static boolean isAlreadyExistingNumber(int nums[], int index) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == index) return true;
        }
        return false;
    }


    static String matchGame(int input){
        // 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다
        // 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고
        // 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.

        int ball = 0;
        int strike = 0;

        int unitsOfInput = input % 10;
        input = input / 10;
        int tensOfInput = input % 10;
        input = input / 10;
        int hundredsOfInput = input % 10;

        int copyOfComputersNumber = computersNumber;
        int unitsOfComputersNumber = copyOfComputersNumber % 10;
        copyOfComputersNumber = copyOfComputersNumber / 10;
        int tensOfComputersNumber = copyOfComputersNumber % 10;
        copyOfComputersNumber = copyOfComputersNumber / 10;
        int hundredsOfComputersNumber = copyOfComputersNumber % 10;

        if(unitsOfInput == unitsOfComputersNumber)
            ball++;
        if(tensOfInput == tensOfComputersNumber)
            ball++;
        if(hundredsOfInput == hundredsOfComputersNumber)
            ball++;

        if(unitsOfInput == tensOfComputersNumber)
            strike ++;
        if(unitsOfInput == hundredsOfComputersNumber)
            strike++;

        if(tensOfInput == unitsOfComputersNumber)
            strike++;
        if(tensOfInput == hundredsOfComputersNumber)
            strike++;

        if(hundredsOfInput == unitsOfComputersNumber)
            strike++;
        if(hundredsOfInput == tensOfComputersNumber)
            strike++;

        String message = "";

        if(strike == 0 && ball == 0)
            message = "낫싱";

        if(ball > 0 && ball != 3)
            message = ball +"볼";

        if(strike > 0)
            message += " " + strike + "스트라이크";

        if(ball == 3) {
            message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
            isPrintingQuestion = false;
        }

        return message;
    }
}
