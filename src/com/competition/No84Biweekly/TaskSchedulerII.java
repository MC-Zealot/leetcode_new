package com.competition.No84Biweekly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个下标从 0 开始的正整数数组 tasks ，表示需要 按顺序 完成的任务，其中 tasks[i] 表示第 i 件任务的 类型 。
 *
 * 同时给你一个正整数 space ，表示一个任务完成 后 ，另一个 相同 类型任务完成前需要间隔的 最少 天数。
 *
 * 在所有任务完成前的每一天，你都必须进行以下两种操作中的一种：
 *
 * 完成 tasks 中的下一个任务
 * 休息一天
 * 请你返回完成所有任务所需的 最少 天数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：tasks = [1,2,1,2,3,1], space = 3
 * 输出：9
 * 解释：
 * 9 天完成所有任务的一种方法是：
 * 第 1 天：完成任务 0 。
 * 第 2 天：完成任务 1 。
 * 第 3 天：休息。
 * 第 4 天：休息。
 * 第 5 天：完成任务 2 。
 * 第 6 天：完成任务 3 。
 * 第 7 天：休息。
 * 第 8 天：完成任务 4 。
 * 第 9 天：完成任务 5 。
 * 可以证明无法少于 9 天完成所有任务。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/task-scheduler-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TaskSchedulerII {
    public long taskSchedulerII(int[] tasks, int space) {
        long ret = 0;
        if(tasks.length == 1){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ;i < tasks.length; i++){
            set.add(tasks[i]);
        }
        if(set.size() == 1){
            return (tasks.length - 1) * (space + 1) + 1;
        }
        Map<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < tasks.length; ){
            int task = tasks[i];
            if(map.containsKey(task)){
                long r = map.get(task);
                if(ret > r + space){
                    map.put(task, ret);
                    i++;
                }
            } else{
                map.put(task, ret);
                i++;
            }
            ret++;
        }
        return ret;
    }

    public long taskSchedulerII2(int[] tasks, int space) {
        /*
        map中的key为任务种类，value为key对应任务所能开工的时间点
        (每开工一次,当前任务所能开工的时间就要增加space天),
        当总工作数达到了这个天数,方能开工
        */
        Map<Integer,Long> map = new HashMap<Integer,Long>();
        //当前总工作天数
        long days = 0;
        long zero = 0;
        for(int i = 0;i < tasks.length;i++){
            //当前任务种类
            int t = tasks[i];
            //如果当前工作天数达到了当前任务所需要等待的天数,days++代表这一天分配给了当前任务
            //否则就直接让当前天数跳到所能开工的时间(即休息了一定的天数,使days达到了当前任务的天数要求),并将当天分配给该任务,即+1
            if(days >= map.getOrDefault(t,zero)){
                days++;
            }else{
                days = map.get(t) + 1;
            }
            //无论是当天或是休息了几天后,只要完成了该任务,就需要调整该任务下一次能够去干它的时间,即当前时间加上间隔时间
            map.put(t,days + space);
        }
        return days;
    }
    public static void main(String[] args) {
        TaskSchedulerII t = new TaskSchedulerII();
        int[] tasks = {10, 10, 10, 10 ,10, 10, 10, 10 ,10, 10};
        int space = 10;
        long ret = t.taskSchedulerII(tasks, space);
        System.out.println(ret);
    }
}
