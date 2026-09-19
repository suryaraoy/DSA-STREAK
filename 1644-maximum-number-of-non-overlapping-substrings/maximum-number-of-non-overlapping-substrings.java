class Solution {
  public List<String> maxNumOfSubstrings(String s) {
    int n = s.length();

    int[] first = new int[26];
    int[] last = new int[26];

    Arrays.fill(first, n);
    Arrays.fill(last, -1);

    for(int i = 0; i < n; i++) {
      int c = s.charAt(i) - 'a';
      first[c] = Math.min(first[c], i);
      last[c] = i;
    }

    List<String> result = new ArrayList<>();
    int previousEnd = -1;

    for(int i = 0; i < n; i++) {
      int c = s.charAt(i) - 'a';

      if(i != first[c]) continue;

      int end = last[c];
      boolean valid = true;

      for(int j = i; j <= end; j++) {
        int x = s.charAt(j) - 'a';

        if(first[x] < i) {
          valid = false;
          break;
        }

        end = Math.max(end, last[x]);
      }

      if(!valid) continue;

      String current = s.substring(i, end + 1);

      if(i > previousEnd) result.add(current);
      else result.set(result.size() - 1, current);

      previousEnd = end;
    }

    return result;
  }
}