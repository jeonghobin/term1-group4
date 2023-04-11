package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15664 {
    static int N, M;
    static int[] data;
    static HashSet<String> h;
    public static void recursive(int idx, int cnt, int[] sel){
        if (cnt > M) return;
        if (cnt == M){
//            System.out.println(Arrays.toString(sel));
            int[] temp = Arrays.copyOf(sel, M);
            Arrays.sort(temp);
            String t = Arrays.toString(temp);
            h.add(t);
            return;
        }

        for (int i = idx; i < N; i++) {
            sel[cnt] = data[i];
            recursive(i + 1, cnt + 1, sel);
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];
        h = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, 0, new int[M]);

        ArrayList<int[]> list = new ArrayList<>();

        for (String s : h) {
            s = s.replace("[", "");
            s = s.replace("]", "");
            s = s.replace(",", "");
            int[] temp = new int[M];
            int idx = 0;
            for (String s1 : s.split(" ")) {
                temp[idx++] = Integer.parseInt(s1);
            }
            list.add(temp);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < M; i++) {
                    if(o1[i] == o2[i])continue;
                    return Integer.compare(o1[i], o2[i]);
                }
                return 0;
            }
        });
        for (int[] a : list) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}















