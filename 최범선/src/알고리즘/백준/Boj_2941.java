package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2941 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String[] data = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for (int j = 0; j < data.length; j++) {
            if (a.contains(data[j])){
                a = a.replaceFirst(data[j], ",");
                if (a.contains(data[j])){
                    j--;
                }
            }
        }
        System.out.println(a.length());
    }
}
