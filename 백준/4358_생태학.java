import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	static TreeMap<String, Integer> trees = new TreeMap<String, Integer>();
	static double total=0; 
	
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			if(input == null || input.length() == 0) break;
			
			total++;
			trees.put(input, trees.getOrDefault(input, 0)+1);
		}
		
		StringBuffer sb = new StringBuffer();
		/*
		 * Object[] treeKey = trees.keySet().toArray(); for(Object treeName : treeKey) {
		 * String treeStr = (String)treeName; sb.append(treeStr + " "); double treeVal =
		 * (double)(Math.round(((double)trees.get(treeStr)/total)*1000000))/10000;
		 * sb.append(treeVal + "\n"); }
		 */
		
		Iterator<String> keyAll = trees.keySet().iterator();
        String key = null;
        while(keyAll.hasNext()) {
            key = keyAll.next();
            double per = (double)(trees.get(key)*100)/total;
            sb.append(key + " " + String.format("%.4f", per)+"\n");
        }
		
		System.out.println(sb.toString());
	}

}
