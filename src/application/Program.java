package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Map<String, Integer> votes = new LinkedHashMap<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String candidateName = fields[0];
				Integer candidateVotes;
				if (votes.get(candidateName) == null) {
					candidateVotes = Integer.valueOf(fields[1]);
				} else {
					candidateVotes = Integer.valueOf(fields[1]) + votes.get(candidateName);
				}
				votes.put(candidateName, candidateVotes);
				line = br.readLine();
			}
			
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
				
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
