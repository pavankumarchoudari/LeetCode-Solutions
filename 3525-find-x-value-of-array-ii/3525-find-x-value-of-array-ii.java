class Solution {
    int k;
    int n;
    int[][] cnt;
    int[] product;

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            product[node] = nums[l] % k;
            cnt[node][product[node]] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node, node * 2, node * 2 + 1);
    }

    void merge(int node, int left, int right) {
        product[node] = (product[left] * product[right]) % k;

        for (int i = 0; i < k; i++) {
            cnt[node][i] = cnt[left][i];
        }

        for (int i = 0; i < k; i++) {
            int rem = (product[left] * i) % k;
            cnt[node][rem] += cnt[right][i];
        }
    }

    void update(int node, int l, int r, int pos, int value) {
        if (l == r) {
            for (int i = 0; i < k; i++) {
                cnt[node][i] = 0;
            }

            product[node] = value % k;
            cnt[node][product[node]] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(node * 2, l, mid, pos, value);
        } else {
            update(node * 2 + 1, mid + 1, r, pos, value);
        }

        merge(node, node * 2, node * 2 + 1);
    }

    int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            int[] result = new int[k];

            for (int i = 0; i < k; i++) {
                result[i] = cnt[node][i];
            }

            return result;
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        int[] left = query(node * 2, l, mid, ql, qr);
        int[] right = query(node * 2 + 1, mid + 1, r, ql, qr);

        int leftProduct = getProduct(node * 2, l, mid, ql, qr);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = left[i];
        }

        for (int i = 0; i < k; i++) {
            int rem = (leftProduct * i) % k;
            result[rem] += right[i];
        }

        return result;
    }

    int getProduct(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return product[node];
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return getProduct(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return getProduct(node * 2 + 1, mid + 1, r, ql, qr);
        }

        int left = getProduct(node * 2, l, mid, ql, qr);
        int right = getProduct(node * 2 + 1, mid + 1, r, ql, qr);

        return (left * right) % k;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;

        cnt = new int[4 * n][k];
        product = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, index, value);

            int[] result = query(1, 0, n - 1, start, n - 1);

            answer[i] = result[x];
        }

        return answer;
    }
}