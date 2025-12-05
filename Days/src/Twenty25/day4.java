package Twenty25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        File input = new File("Days/src/Twenty25/day4in");

        try(Scanner scan = new Scanner(input)){
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                ArrayList<String> current = new ArrayList<>();
                for(char i: line.toCharArray()){
                    current.add(Character.toString(i));
                }
                arr.add(current);
            }
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
        }

        int rows = arr.size();
        int cols = arr.get(0).size();
        int count = 0;

        while(true){
            int prevC=count;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(arr.get(i).get(j).equals(".")){
                        continue;
                    }
                    int run =0;

                    int[] offsetR = {-1,-1,-1,0,0,1,1,1};
                    int[] offsetC = {-1,0,1,-1,1,-1,0,1};

                    for(int k = 0;k<8;k++){
                        int r = i + offsetR[k];
                        int c = j + offsetC[k];
                        if(r>=0 && c>=0 && r<rows && c<cols && !arr.get(r).get(c).equals(".")){
                            run++;
                        }
                    }

                    if(run<4){
                        count++;
                        arr.get(i).set(j,".");
                    }

                }
            }
            if(prevC==count){
                break;
            }
        }

        System.out.println(count);
    }
}
