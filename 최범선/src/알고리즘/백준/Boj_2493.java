package 알고리즘.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2493 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int []> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            int temp = Integer.parseInt(st.nextToken());
                while (!s.isEmpty()){
                    int top = s.peek()[1];
                    if (top >= temp){
                        sb.append(s.peek()[0]).append(" ");
                        break;
                    }
                    s.pop();
                }
            if(s.isEmpty()){
                sb.append(0).append(" ");
            }
            s.push(new int[]{i, temp});
        }
        System.out.println(sb);

    }
}
