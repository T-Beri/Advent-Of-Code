package Twenty25;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        int start = 50;

        while(true){
            String instruct = scan.nextLine();

            if(instruct.isEmpty()){
                break;
            }

            Pattern pattern = Pattern.compile("([RL])(\\d+)");
            Matcher matcher = pattern.matcher(instruct);

            String letter;
            int number;

            if(matcher.matches()){
                letter = matcher.group(1);
                number = Integer.parseInt(matcher.group(2));
            }else{
                break;
            }

            int num = 0;
            int quo = 0;
            if(letter.equals("R")){
                quo = number/100;
                number = number%100;
                num = start + number;
                if(num>=100){
                    num = num%100;
                    if(start!=0 && num!=0){

                        count++;
                    }
                }
                start = num;
                System.out.println(start);
            }else if(letter.equals("L")){
                quo = number/100;
                number = number% 100;
                num = start - number;
                if(num<0){
                    num = num + 100;
                    if(start!=0 && num!=0){

                        count++;
                    }
                }
                start = num;
                System.out.println(start);
            }

            if(start==0){
                count++;
            }
            count += quo;


        }
        System.out.println(count);
    }
}
