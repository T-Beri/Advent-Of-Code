package Twenty25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day5 {
    public static Long binaryS(Long index,ArrayList<Long> list,HashMap<Long,Long> sweep){
        int low = 0;
        int high = list.size()-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(list.get(mid).equals(index)){
                return sweep.get(index);
            }else if(list.get(mid)<index){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        if(high<0){
            return 0L;
        }else
        return sweep.get(list.get(high));
    }
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

        int n = hs.size();
        Long x = 0L;
        HashMap<Long,Long> sweep = new HashMap<>();
        ArrayList<Long> indices = new ArrayList<>(hs.keySet());
        Collections.sort(indices);

        for (Long key : indices) {
            x += hs.get(key);
            sweep.put(key, x);
        }

        int count = 0;
        for(Long i:arr){
            if(binaryS(i,indices,sweep)==0){
                continue;
            }else{
                count++;
            }
        }
        System.out.println(count);

    }
}
