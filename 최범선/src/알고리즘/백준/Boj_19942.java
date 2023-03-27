package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_19942 {

    static int N, min, a,b,c,d, index;
    static int[][] data;
    static boolean[] v;
    static ArrayList<ArrayList<Integer>> list;
    public static void recursive(int idx, int price) {

        if (price > min) return;

        if (idx > N) {
            int q = 0, w = 0, e = 0, r = 0;
            ArrayList temp = new ArrayList<>();
            for (int i = 1; i < N + 1; i++) {
                if(!v[i]) continue;
                temp.add(i);
                q += data[i][0];
                w += data[i][1];
                e += data[i][2];
                r += data[i][3];
            }
            if(q >= a && w >= b && e >= c && r >= d) {
                if (price < min) {
                    list.clear();
                    min = price;
                    list.add(temp);
                }else {
                    list.add(temp);
                }
            }
            return;
        }
        v[idx] = true;
        recursive(idx + 1, price + data[idx][4]);
        v[idx] = false;
        recursive(idx + 1, price);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        data = new int[N+1][5];
        v = new boolean[N + 1];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        min = Integer.MAX_VALUE;
        recursive(1, 0);
        if(list.size() < 1) System.out.println(-1);
        else {
//        for (ArrayList<Integer> s : list) {
//            for (Integer i : s) {
//				System.out.print(i + " ");
//			}
//            System.out.println();
//        }
//        System.out.println();
//
            Collections.sort(list, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    // TODO Auto-generated method stub

                    int size = Math.min(o1.size(), o2.size());
                    for (int i = 0; i < size; i++) {
                        if (o1.get(i) == o2.get(i)) continue;
                        return Integer.compare(o1.get(i), o2.get(i));
                    }
                    return Integer.compare(o1.size(), o2.size());
                }
            });

//        for (ArrayList<Integer> s : list) {
//            for (Integer i : s) {
//				System.out.print(i + " ");
//			}
//            System.out.println();
//        }
            System.out.println(min);
            for (Integer i : list.get(0)) {
                System.out.print(i + " ");
            }

        }

    }

}