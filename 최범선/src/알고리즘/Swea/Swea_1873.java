package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Swea_1873 {
    static String[][] data;
    static int dx[] = {0,1,0,-1}; // 오른쪽 , 아래쪽, 왼쪽, 위쪽
    static int dy[] = {1,0,-1,0};
    static String[] shape = {">", "v", "<", "^"};
    static String a;
    static int idx, H , W, x, y;
    public static void game(int X, int Y, int d){
        x = X;
        y = Y;
        for (int i = 0; i < a.length(); i++) {
            String temp = Character.toString(a.charAt(i));
            if(temp.equals("S")){
                int nx = x + dx[d];
                int ny = y + dy[d];
                while (nx >= 0 && nx < H && ny >= 0 && ny < W){
                    if (data[nx][ny].equals("#")){
                        break;
                    }
                    else if (data[nx][ny].equals("*")){
                        data[nx][ny] = ".";
                        break;
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
            }else if(temp.equals("U")){
                d = 3;
                simple(d);
            }else if(temp.equals("D")){
                d = 1;
                simple(d);
            }else if(temp.equals("L")){
                d = 2;
                simple(d);
            }else if(temp.equals("R")){
                d = 0;
                simple(d);
            }
        }
        data[x][y] = shape[d];
    }
    public static void simple(int d){
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx >= 0 && nx < H && ny >= 0 && ny < W){
            if (data[nx][ny].equals(".")){
                x = nx;
                y = ny;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            data = new String[H][W];
            for (int j = 0; j < H; j++) {
                String temp = br.readLine();
                for (int k = 0; k < W; k++) {
                    data[j][k] = Character.toString(temp.charAt(k));
                }
            }
            int N = Integer.parseInt(br.readLine());
            a = br.readLine();
            boolean flag = false;
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (data[i][j].equals(">")){
                        idx = 0;
                        data[i][j] = ".";
                        game(i,j,idx);
                        flag = true;
                        break;
                    }else if(data[i][j].equals("<")){
                        idx = 2;
                        data[i][j] = ".";
                        game(i,j,idx);
                        flag = true;
                        break;
                    }else if(data[i][j].equals("^")){
                        idx = 3;
                        data[i][j] = ".";
                        game(i,j,idx);
                        flag = true;
                        break;
                    }else if(data[i][j].equals("v")){
                        idx = 1;
                        data[i][j] = ".";
                        game(i,j,idx);
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(data[i][j]);
                }
                System.out.println();
            }
        }
    }
}
