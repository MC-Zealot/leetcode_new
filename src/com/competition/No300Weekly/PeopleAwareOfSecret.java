package com.competition.No300Weekly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2327. 知道秘密的人数
 * 在第 1 天，有一个人发现了一个秘密。
 *
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
 *
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 6, delay = 2, forget = 4
 * 输出：5
 * 解释：
 * 第 1 天：假设第一个人叫 A 。（一个人知道秘密）
 * 第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
 * 第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
 * 第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
 * 第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
 * 示例 2：
 *
 * 输入：n = 4, delay = 1, forget = 3
 * 输出：6
 * 解释：
 * 第 1 天：第一个知道秘密的人为 A 。（一个人知道秘密）
 * 第 2 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 3 天：A 和 B 把秘密分享给 2 个新的人 C 和 D 。（四个人知道秘密）
 * 第 4 天：A 忘记了秘密，B、C、D 分别分享给 3 个新的人。（六个人知道秘密）
 *
 *
 * 提示：
 *
 * 2 <= n <= 1000
 * 1 <= delay < forget <= n
 */
public class PeopleAwareOfSecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        int index = 2;
        int day = 2;

        while(day <= n){
            List<Integer> tmp = new ArrayList<>();
            List<Integer> del = new ArrayList<>();
            for(Integer idx: map.keySet()){
                int cnt = map.get(idx) + 1;
                if(cnt > forget){
                    del.add(idx);
                    continue;
                }
                map.put(idx, cnt);
                if(cnt > delay){
                    tmp.add(index++);
                }
            }
            for(int i = 0;i < tmp.size(); i++){
                map.put(tmp.get(i), 1);
            }
            for(int i = 0;i < del.size();i++){
                map.remove(del.get(i));
            }
            day++;
        }
        return map.size();
    }
    static final int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret2(int n, int delay, int forget) {
        int[] f = new int[n];
        f[0] = 1;
        int cntB = 0;
        for (int i = 0; i < n; i++) {
            if (i + delay >= n) {
                cntB = (cntB + f[i]) % MOD;
            }
            for (int j = i + delay; j < Math.min(i + forget, n); j++){
                f[j] = (f[j] + f[i]) % MOD;
            }
        }
        return (f[n - 1] + cntB) % MOD;
    }

    public static void main(String[] args) {
        PeopleAwareOfSecret pas = new PeopleAwareOfSecret();
        int n = 684;
        int delay = 18;
        int forget = 496;
        int ret = pas.peopleAwareOfSecret(n,delay, forget);
        System.out.println(ret);
    }
}
