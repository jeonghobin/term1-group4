package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Boj_2493 {
    public static class Pair{
        int index, height;

        public Pair(int index, int height) {
            super();
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Stack<Pair> s = new Stack<Pair>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int temp = Integer.parseInt(st.nextToken());
            Pair p = new Pair(i, temp);

            if (!s.isEmpty()) {
                while(s.peek().height < temp) {
                    s.pop();
                    if(s.isEmpty()) break;
                }
            }
            if (s.isEmpty()) {
                sb.append(0).append(" ");
            }else {
                Pair t = s.peek();
                sb.append(t.index).append(" ");
            }
            s.add(p);
        }
        System.out.println(sb);
    }
}

//public class Boj_2493 {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Stack<int []> s = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i < N + 1; i++) {
//            int temp = Integer.parseInt(st.nextToken());
//                while (!s.isEmpty()){
//                    int top = s.peek()[1];
//                    if (top >= temp){
//                        sb.append(s.peek()[0]).append(" ");
//                        break;
//                    }
//                    s.pop();
//                }
//            if(s.isEmpty()){
//                sb.append(0).append(" ");
//            }
//            s.push(new int[]{i, temp});
//        }
//        System.out.println(sb);
//
//    }
//}
//import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//        import java.util.Stack;
//        import java.util.StringTokenizer;
//
//public class Main {
//    public static class Pair{
//        int idx, val;
//
//        public Pair(int idx, int val) {
//            this.idx = idx;
//            this.val = val;
//        }
//    }
//
//
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Stack<Pair> s = new Stack<>();
//
//
//        for (int i = 1; i < N + 1; i++) {
//            int temp = Integer.parseInt(st.nextToken());
//            Pair p = new Pair(i, temp);
//
//            if(s.isEmpty()) {
//                sb.append(0).append(" ");
//            }else {
//                Pair t = s.peek();
//                if (temp > t.val) {
//                    s.pop();
//                    while(!s.isEmpty()) {
//                        Pair a = s.peek();
//                        if (temp < a.val) {
//                            sb.append(a.idx).append(" ");
//                            break;
//                        }
//                        s.pop();
//                    }
//                    if(s.isEmpty()) {
//                        sb.append(0).append(" ");
//                    }
//                }else {
//                    sb.append(t.idx).append(" ");
//                }
//            }
//            s.add(p);
//        }
//        System.out.println(sb);
//    }
//}