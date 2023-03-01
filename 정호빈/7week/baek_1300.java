import java.util.*;
import java.io.*;


public class Main {
	
	static ArrayList<Integer> list =new ArrayList<>();
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        long s=0;
        long e = (long)N*N;
        
        while(s<=e) {
        	long min1=0,min2=0;
        	long mid = (s+e)/2;
        	for(int i=1;i<=N;i++) {
        		if(mid%i==0) {
        			min1+=Math.min(N,mid/i-1);
        		}else {
        			min1+=Math.min(N, mid/i);
        		}
        		min2+=Math.min(N, mid/i);
        	}
        	if(min1<K&&min2>=K) {
        		System.out.println(mid);
        		break;
        	}else if(min1>=K) {
        		e = mid-1;
        	}else if(min1<K&&min2<K) {
        		s = mid+1;
        	}
        }
        
        
        
    }

	
}
