package report.day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Quiz4 {
	public static void main(String[] args) throws IOException {
		int result=0;
		int totalLength=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int memorySize = Integer.parseInt(input[0]);
		int wordSize = Integer.parseInt(input[1]);
		String[] words = br.readLine().split(" ");
		
		LinkedList<String> memory = new LinkedList<String>();
		
		int i=0;
		for(String word : words) {
			i = memory.indexOf(word);
			if(i >= 0) { //암기한 단어
				result += 1;
				memory.remove(i);
				memory.add(word); //최신으로
			}
			else { //암기하지 않은 단어
				result += 3;
				if(memory.size() >= memorySize) {//MemoryFull
					findShortLength :
					for(String memWord : memory) {//for findShortLength
						if(memWord.length() <=  (float)totalLength/memory.size()) {
							memory.remove(memWord);
							memory.add(word);
							totalLength += (word.length() - memWord.length());
							break findShortLength;
						}
					}
				}else{//MemoryisNotFull
					totalLength += word.length();
					memory.add(word);
				}
			}
		}//for
		
		System.out.println(result);
		
	}

}
