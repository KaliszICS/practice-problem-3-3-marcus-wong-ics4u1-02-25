import java.util.*;

public class PracticeProblem {

	public static void main(String args[]) {

	}
	public static ArrayList<String> perms(String str) {
		ArrayList<String> permutations = new ArrayList<String>();
		permsHelper("", str, permutations);
		return permutations;

		
	}
	public static void permsHelper(String used, String unused, ArrayList<String> permutations) {
		if (unused.length() == 0) {
			permutations.add(used);
			return;
		}
		for (int i = 0; i < unused.length(); i++) {
			String nextUsed = used + unused.charAt(i);
			String nextUnused = unused.substring(0, i) + unused.substring(i + 1);
			permsHelper(nextUsed, nextUnused, permutations);
		}
	}
	public static ArrayList<String> permsUnique(String str) {
		ArrayList<String> permutations = new ArrayList<>();
		HashSet<String> duplicate = new HashSet<>();
		permsUniqueHelper("", str, permutations, duplicate);
		return permutations;
	}
	public static void permsUniqueHelper(String used, String unused, ArrayList<String> permutations, HashSet<String> duplicate) {
		if (unused.length() == 0) {
			if (!duplicate.contains(used)) {
				permutations.add(used);
				duplicate.add(used);
			}
			
			return;
		}
		for (int i = 0; i < unused.length(); i++) {
			String nextUsed = used + unused.charAt(i);
			String nextUnused = unused.substring(0, i) + unused.substring(i + 1);
			permsUniqueHelper(nextUsed, nextUnused, permutations, duplicate);
		}
	}
}
