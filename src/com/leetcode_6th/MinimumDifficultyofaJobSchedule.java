package com.leetcode_6th;

public class MinimumDifficultyofaJobSchedule {
    private int[][] memo;
    private int n, d;
    private int[] jobDifficulty;
    private int[] hardestJobRemaining;
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if(n < d){
            return -1;
        }
        hardestJobRemaining = new int[n] ;
        int hardest = -1;
        for(int i = n - 1; i >= 0; i--){
            hardest = Math.max(jobDifficulty[i], hardest);
            hardestJobRemaining[i] = hardest;
        }
        memo = new int[n][d + 1];
        for(int i = 0;i < n; i++){
            for(int j = 0; j < d+1; j++){
                memo[i][j] = -1;
            }
        }
        this.d = d;
        this.jobDifficulty = jobDifficulty;

        return dp(0, 1);
    }
    public int dp(int i, int day){
        if(day == d){// last day to finish all left jobs
            return hardestJobRemaining[i];
        }
        if(memo[i][day] == -1){
            int best = Integer.MAX_VALUE;
            int hardest = 0;
            for (int j = i; j < n - (d - day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                // Recurrence relation
                best = Math.min(best, hardest + dp(j + 1, day + 1));
            }
            memo[i][day] = best;
        }
        return memo[i][day];
    }
}
