package com.arao.challenges.codility;
import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'maxDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY px as parameter.
     */

    public static int maxDifference(List<Integer> px) {
        px.stream().forEach(System.out::print);
        System.out.println();
        int maxProfit = 0;
        for(int i=1; i<px.size(); i++) {
            if(px.get(i) > px.get(i-1)) {
                maxProfit += px.get(i) - px.get(i-1);
            }
        }
        return maxProfit > 0  ? maxProfit : -1;
    }
//7 ,9 ,5 ,6, 3 ,2
//    2,3,5,6,7,9
}

public class MaxDifference {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int pxCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> px = new ArrayList<>();
//
//        for (int i = 0; i < pxCount; i++) {
//            int pxItem = Integer.parseInt(bufferedReader.readLine().trim());
//            px.add(pxItem);
//        }
        List<Integer> px = Arrays.asList(2,3,10,2,4,8,1);
        int result = Result.maxDifference(px);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
