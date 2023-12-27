import java.util.ArrayList;

/**

 * @author Lawrence Li
 */
public class oop3 {

  /**
   * Returns an array of all sequences of substrings of haystack that match the
   * needle pattern.
   *
   * The dash (-) is a single-character wildcard (i.e. it can match any
   * character), all others much match directly.
   *
   * @param needle   pattern for which to search
   * @param haystack text over which to search
   * @return an array of substrings of haystack that match needle
   */
  public static String[] patternMatch(String needle, String haystack) {
    final ArrayList<String> matches = new ArrayList<String>();
    final StringBuilder sb = new StringBuilder(needle);

    for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
      boolean matched = true;

      for (int j = 0; j < needle.length(); j++) {
        if (
          (needle.charAt(j) != haystack.charAt(i + j)) &&
          (needle.charAt(j) != '-')
        ) {
          matched = false;
          break;
        }
      }

      if (matched) {
        for (int j = 0; j < needle.length(); j++) {
          sb.setCharAt(j, haystack.charAt(i + j));
        }
        matches.add(sb.toString());
      }
    }

    final String[] ret = new String[matches.size()];
    for (int i = 0; i < matches.size(); i++) {
      ret[i] = matches.get(i);
    }

    return ret;
  }
}
