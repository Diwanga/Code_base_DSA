import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hashing {
	
	
	
	//Interview question , first non repeatable character : using hashmap
	private static void firstNonRepetableChar(String text) {
		
		Map<Character, Integer> map = new HashMap();
		
//		String text = "a green apple";
		
		for(char i : text.toCharArray()) {
			if(map.containsKey(i)) {
				map.put(i, (map.get(i)+1));
		} else {
			map.put(i, 1);
			
		}
				
		}
		
		for(char i : text.toCharArray()) {
			
			if(map.get(i)==1) {
				System.out.println(i+" is first non repeatable character");
				break;
			}
		}
		
	}
	
	private static void firstRepeatabeChar(String text) {
		// TODO Auto-generated method stub
		Set<Character> set = new HashSet();
		
		for(char i : text.toCharArray()) {
			if(set.contains(i)) {
				System.out.println("First repeatable character is "+i);
				return;
			}
			else {
				set.add(i);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		String text = "a green apple";
		firstNonRepetableChar(text);
		firstRepeatabeChar(text);
	}

}
