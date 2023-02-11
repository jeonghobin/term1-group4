package day0210;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Baek2164 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n =Integer.parseInt(br.readLine());
		Queue<Integer> number = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			number.add(i);
		}
		while(number.size()>1) {
			number.remove();
			number.add(number.poll());
		}
		bw.write(number.peek()+"");
		bw.close();
	}
}