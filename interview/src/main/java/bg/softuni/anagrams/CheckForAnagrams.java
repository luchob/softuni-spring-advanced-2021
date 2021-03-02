package bg.softuni.anagrams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckForAnagrams {

  public static void main(String[] args) {
    listAnagrams(List.of("Бира", "Риба", "кавалер",
        "акварел", "пешо", "софтуни"));
  }

  public static void listAnagrams(List<String> words) {
    // List all words that are anagrams.
    // Example: [Бира, Риба, кавалер, акварел, пешо, софтуни]
    // Expected output:
    // Бира, Риба
    // кавалер, акварел
    Set<Set<String>> allAnagrams = new HashSet<>();
    for (String aWord : words) {
      boolean found = false;

      for (Set<String> anagrams : allAnagrams) {
        if (anagrams.contains(aWord)) {
          found = true;
        } else {
          String randomWord = anagrams.iterator().next();
          if (areAnagrams(aWord, randomWord)) {
            anagrams.add(aWord);
          }
        }
      }

      if (!found) {
        Set<String> newSetOfPossibleAnagrams = new HashSet<>();
        newSetOfPossibleAnagrams.add(aWord);
        allAnagrams.add(newSetOfPossibleAnagrams);
      }
    }

    allAnagrams.stream().
        filter(s -> s.size() > 1).
        forEach(System.out::println);
  }

  private static boolean areAnagrams(String word1, String word2) {
    if (word1.length() != word2.length() || word1.equalsIgnoreCase(word2)) {
      return false;
    }

    return sortByCharacter(word1.toLowerCase()).
        equals(sortByCharacter(word2.toLowerCase()));
  }

  private static String sortByCharacter(String word) {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
