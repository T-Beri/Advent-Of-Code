package Twenty25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day5pt2 {
    public static void main(String[] args) {
        File input = new File("Days/src/Twenty25/day5in");

        HashMap<Long,Long> hs = new HashMap<>();
        ArrayList<Long> arr = new ArrayList<>();


        try(Scanner scan = new Scanner(input)){
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
                Matcher match = pattern.matcher(line);

                Long num1;
                Long num2;
                if(match.find()){
                    num1 = Long.parseLong(match.group(1));
                    num2 = Long.parseLong(match.group(2));
                    hs.put(num1,hs.getOrDefault(num1,0L)+1);
                    hs.put(num2+1,hs.getOrDefault(num2+1,0L)-1);
                }else if(!line.isEmpty()){
                    arr.add(Long.parseLong(line));
                }

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Long x = 0L;
        HashMap<Long,Long> sweep = new HashMap<>();
        ArrayList<Long> indices = new ArrayList<>(hs.keySet());
        Collections.sort(indices);

        for (Long key : indices) {
            x += hs.get(key);
            sweep.put(key, x);
        }

        Long s=null;
        Long run = 0L;
        ArrayList<Long[]> list = new ArrayList<>();


        for(Long key:indices){
            run+=hs.get(key);
            if(s==null){
                s= key;
            }
            if(run==0){
                Long[] curr = new Long[2];
                curr[0] = s;
                curr[1] = key;
                list.add(curr);
                s = null;
            }

        }

        Long count = 0L;

        for(Long[] curr : list){
            count+=curr[1]-curr[0];
        }

        System.out.println(count);

    }

}
