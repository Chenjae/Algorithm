package report.day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz2 {
	public static void main(String[] args) throws IOException {
		int startNum, endNum, mulNum;
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���ۼ�:");
		startNum = Integer.parseInt(br.readLine());
		System.out.print("����:");
		endNum = Integer.parseInt(br.readLine());
		System.out.print("���:");
		mulNum = Integer.parseInt(br.readLine());
		
		for(int i = startNum; i<=endNum; i++) {
			if(i%mulNum == 0) result += i;
		}
		
		System.out.println(result);
		
	}

}
