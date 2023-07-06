import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str=br.readLine();
		while(!str.equals("END")) {
			for(int i=str.length()-1;i>=0;i--) {
				System.out.print(str.charAt(i));
			}
			System.out.println();
			str = br.readLine();
		}
		
		
	}

}
