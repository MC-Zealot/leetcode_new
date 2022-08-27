package com.leetcode_6th.supercore;

public class MyHashMap {
    static class ListNode{
        int key;
        int value;
        ListNode next;
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    ListNode[] nodes;
    public MyHashMap() {
        nodes = new ListNode[10009];
    }

    public void put(int key, int value) {
        int index = getHashCode(key);
        ListNode node = nodes[index];
        ListNode tmp = new ListNode(key, value);
        if(node==null){
            nodes[index] = tmp;
            return;
        }
        ListNode pre = new ListNode(-1, -1);
        pre.next = node;
        while(node!=null){
            if(node.key == key){
                node.value = value;
                return;
            }
            node = node.next;
            pre = pre.next;
        }
        pre.next = tmp;

    }

    public int get(int key) {
        int index = getHashCode(key);
        ListNode node = nodes[index];
        while(node != null){
            if(node.key == key){
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = getHashCode(key);
        ListNode node = nodes[index];
        if(node == null){
            return;
        }
        ListNode pre = new ListNode(-1, -1);
        pre.next = node;
        while(node!= null){
            if(node.key == key){
                if(pre.key == -1){
                    nodes[index] = nodes[index].next;
                }else{
                    pre.next = node.next;
                }
                node.next = null;
                return;
            }
            node = node.next;
            pre = pre.next;
        }
    }
    public int getHashCode(int key){
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % nodes.length;
    }
}
