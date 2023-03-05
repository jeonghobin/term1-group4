package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 알고스탁 {
    static int[][] data;
    static int start, income, R, C, total, max;
    static ArrayList<Pair> list;

    static public class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void find(int money, int day){

        if (day == C) {
            total = money;
            return;
        }

        list = new ArrayList<>();
        max = - 1;
        for (int i = 0; i < R; i++) {
            if (money >= data[i][day] && data[i][day + 1] > data[i][day]){
                list.add(new Pair(i, day));
            }
        }
        recursive(0, money, 0, money);

        if(max == -1){
            find(money + income, day + 1);
        }else{
            find(max + income, day + 1);
        }

    }

    public static void recursive(int idx, int totalMoney, int totalIncome, int nowMoney){

        if(nowMoney < 0) return;

        if (idx >= list.size()){
            max = Math.max(max, totalIncome + nowMoney);
            return;
        }
        Pair t = list.get(idx);

        int r = t.x;
        int c = t.y;

        for (int i = 0; i <= nowMoney / data[r][c]; i++) {
            recursive(idx + 1, totalMoney, totalIncome + data[r][c+1] * i, nowMoney - data[r][c] * i);
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            income = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            data = new int[R][C + 1];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C + 1; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            find(start, 0);
            sb.append(total - (start + income * C)).append("\n");
        }
        System.out.println(sb);

    }
}
