class Solution {

    class Node {
        int l, r;
        int prefix, suffix, max;
        char leftChar, rightChar;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String queryString,
                                  String queryCharacter,
                                  int[] queryIndices) {

        s = queryString.toCharArray();
        int n = s.length;

        tree = new Node[4 * n];
        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int q = 0; q < queryIndices.length; q++) {
            int index = queryIndices[q];
            s[index] = queryCharacter.charAt(q);

            update(1, 0, n - 1, index);

            ans[q] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int l, int r) {
        tree[node] = new Node(l, r);

        if (l == r) {
            tree[node].leftChar = s[l];
            tree[node].rightChar = s[l];
            tree[node].prefix = 1;
            tree[node].suffix = 1;
            tree[node].max = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        merge(node);
    }

    void update(int node, int l, int r, int index) {
        if (l == r) {
            tree[node].leftChar = s[l];
            tree[node].rightChar = s[l];
            tree[node].prefix = 1;
            tree[node].suffix = 1;
            tree[node].max = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        merge(node);
    }

    void merge(int node) {
        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node cur = tree[node];

        cur.leftChar = left.leftChar;
        cur.rightChar = right.rightChar;

        cur.prefix = left.prefix;
        cur.suffix = right.suffix;
        cur.max = Math.max(left.max, right.max);

        // Join suffix of left + prefix of right
        if (left.rightChar == right.leftChar) {

            cur.max = Math.max(
                cur.max,
                left.suffix + right.prefix
            );

            // Entire left segment has the same character
            if (left.prefix == left.r - left.l + 1) {
                cur.prefix = left.prefix + right.prefix;
            }

            // Entire right segment has the same character
            if (right.suffix == right.r - right.l + 1) {
                cur.suffix = right.suffix + left.suffix;
            }
        }
    }
}