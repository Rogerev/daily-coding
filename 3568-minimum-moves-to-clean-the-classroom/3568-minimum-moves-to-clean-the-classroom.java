class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length, m = classroom[0].length();
        int sr = -1, sc = -1;
        List<int[]> trash = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') { sr = i; sc = j; }
                else if (ch == 'L') trash.add(new int[]{i, j});
            }

        int k = trash.size();
        if (k == 0) return 0;

        int[][] id = new int[n][m];
        for (int[] row : id) Arrays.fill(row, -1);
        for (int i = 0; i < k; i++) id[trash.get(i)[0]][trash.get(i)[1]] = i;

        int fullMask = (1 << k) - 1;
        int[][][][] dist = new int[n][m][energy + 1][1 << k];
        for (int[][][] a : dist) for (int[][] b : a) for (int[] c : b) Arrays.fill(c, -1);

        Queue<int[]> q = new LinkedList<>();
        dist[sr][sc][energy][0] = 0;
        q.add(new int[]{sr, sc, energy, 0});

        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], e = cur[2], mask = cur[3];
            int moves = dist[r][c][e][mask];

            if (mask == fullMask) return moves;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                char ch = classroom[nr].charAt(nc);
                if (ch == 'X' || e == 0) continue;

                int ne = e - 1, nmask = mask;
                if (ch == 'L') nmask |= (1 << id[nr][nc]);
                if (ch == 'R') ne = energy;

                if (dist[nr][nc][ne][nmask] == -1) {
                    dist[nr][nc][ne][nmask] = moves + 1;
                    q.add(new int[]{nr, nc, ne, nmask});
                }
            }
        }
        return -1;
    }
}