package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_14907 {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = "";

            int[] time = new int[26];
            int[] count = new int[26];
            int[] d = new int[26];

            ArrayList<Integer>[] list = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                list[i] = new ArrayList<>();
            }

            while ((line = br.readLine()) != null) {
//                if (line.length() < 2) break;
                line = line.trim();
                if (line.length() < 1) break;

                String temp[] = line.split(" ");
                String a = temp[0];
                String b = temp[1];

                time[a.charAt(0) - 65] = Integer.parseInt(b);

                if (temp.length == 3) {
                    String c = temp[2];
                    count[a.charAt(0) - 65] += c.length();
                    for (int i = 0; i < c.length(); i++) {
                        list[c.charAt(i) - 65].add(a.charAt(0) - 65);
                    }
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                if (count[i] == 0 && time[i] > 0) {
                    q.add(i);
                    d[i] = time[i];
                }
            }
            int max = -1;
            while (!q.isEmpty()) {
                int to = q.poll();
                max = Math.max(max, d[to]);
                for (int i = 0; i < list[to].size(); i++) {
                    int too = list[to].get(i);
                    if (--count[too] == 0) {
                        if (d[too] < d[to] + time[too]) {
                            d[too] = d[to] + time[too];
                            q.add(too);
                        }
                    }
                }
            }
//            System.out.println(Arrays.toString(d));
//            Arrays.sort(d);
//            System.out.println(d[25]);
            System.out.println(max);
        }

}