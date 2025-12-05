package Twenty25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        File myObj = new File("Days/src/day3in");
        int sum = 0;
        try (Scanner scan = new Scanner(myObj)) {
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                int n = data.length();
                int max = Integer.MIN_VALUE;
                for(int i =0;i<n;i++){
                    for(int j=i+1;j<n;j++){
                        int number = Integer.parseInt(Character.toString(data.charAt(i)))*10 + Integer.parseInt(Character.toString(data.charAt(j)));
                        if(number>max){
                            max = number;
                        }
                    }
                }
                sum+=max;



            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(sum);

    }
}
