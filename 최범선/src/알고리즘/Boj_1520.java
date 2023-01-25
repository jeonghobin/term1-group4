package 알고리즘;
import java.io.*;
import java.util.*;
public class Boj_1520 {
//    static int M, N, cnt;
//    static int[][] data ;
//    static int dx[] = {0,1,0,-1};
//    static int dy[] = {1,0,-1,0};
//    public static void recursive(int x, int y) {
//
//        if (x == (M-1) && y == (N-1)) cnt++; // 오른쪽 아래 지점에 도착하면, 경로 +1
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if (nx >= 0 && nx < M && ny >= 0 && ny < N) { // 가려고 하는 다음 경로가 배열 범위 안에 있는지 확인
//                if(data[x][y] > data[nx][ny]) { // 배열안에 있을 경우, 현재 위치보다 다음 위치의 값이 더 작은 경우에만 이동하는 조건
//                    recursive(nx,ny); // 다음 위치 이동 , 조건 검사
//                }
//            }
//        }
//
//    }
//    public static void main(String args[]) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        M = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken());
//        data = new int[M][N];
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                data[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        recursive(0,0); // 왼쪽 위에 지점부터 오른쪽 아래 지점까지의 경로를 찾기 위해 (0,0)부터 시작
//        System.out.println(cnt);
//    }
    static int M, N;
    static int[][] data ;
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int[][] visited;

    public static int recursive(int x, int y) {

        if (x == (M-1) && y == (N-1)) {
            return 1;
        }
        if (visited[x][y] != -1) {
            return visited[x][y];
        }
        visited[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) { // 가려고 하는 다음 경로가 배열 범위 안에 있는지 확인
                if(data[x][y] > data[nx][ny]) { // 배열안에 있을 경우, 현재 위치보다 다음 위치의 값이 더 작은 경우에만 이동하는 조건
                    visited[x][y] += recursive(nx,ny); // 다음 위치 이동 , 조건 검사
                }
            }
        }
        return visited[x][y];

    }
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        data = new int[M][N];
        visited = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }

        System.out.println(recursive(0,0)); // 왼쪽 위에 지점부터 오른쪽 아래 지점까지의 경로를 찾기 위해 (0,0)부터 시작

    }
}





