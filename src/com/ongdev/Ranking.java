package com.ongdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Ranking {
    public int[] ranking(String[] info, String[] query) {

        int[] answer = new int[query.length];

        for(int i =0; i < query.length; i++) {

            String temp = query[i];

            int total = getTotal(temp);
            
            temp = temp.replaceAll("- ", "").replaceAll("and ", "").replaceAll(String.valueOf(total), "");
            List<String> list = new ArrayList<>(Arrays.asList(temp.split(" ")));

            answer[i] = getCount(info, list, total);

        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }

    /*점수 가져 오는 함수*/
    private int getTotal(String query) {
        return Integer.parseInt(query.substring(query.lastIndexOf(" ", query.length())).trim());
    }

    /* query에 맞는 info 개수 구하기 */
    private int getCount(String[] info, List<String> list, int total){
        int count = 0;

        for (String str : info) {

            String[] getStr = str.split(" ");

            List<String> list2 = new ArrayList<>(Arrays.asList(getStr));
            list2.set(list2.size()-1,"");
            if (list2.containsAll(list) && total <= Integer.parseInt(getStr[getStr.length - 1])) {
                count++;
            }
        }
        
        return count;
    }
}