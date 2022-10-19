package com.WebTest.jerry;

public class RangeListTest {
    class ListNode{
        //ListNode represent range,
        int rangeStart; // range start
        int rangeEnd; // range end
        ListNode next; // next range
        private ListNode(int rangeStart, int rangeEnd){
            this.rangeStart = rangeStart;
            this.rangeEnd = rangeEnd;
        }

        /**
         * remove a range(node) from the range list
         * @param node the range to be removed
         * @return
         */
        private ListNode removeNode(ListNode node){
            if(node.rangeEnd - node.rangeStart <= 0){
                // if node is empty, return current range
                // 如果node为空，则不改变
                return this;
            }else if(node.rangeStart > this.rangeEnd){
                // if range start of the node is after current range, try next range recursively
                //如果要删除的节点不在此刻的节点范围内，则遍历到下一个节点再试试。
                if(this.next!= null){
                    this.next = this.next.removeNode(node);
                }
                return this;
            }else if(this.rangeStart == node.rangeStart && this.rangeEnd == node.rangeEnd){
                //if the range exact match the current range, return next
                //如果刚好匹配，则返回下一个节点（删掉当前节点）
                return this.next;
            }else if(this.rangeStart < node.rangeStart && this.rangeEnd >= node.rangeEnd){
                // if current range wraps the range, break into 2 range, and return left
                //
                ListNode leftNode = new ListNode(this.rangeStart, node.rangeStart);
                ListNode rightNode = new ListNode(node.rangeEnd, this.rangeEnd);
                rightNode.next = this.next;
                leftNode.next = rightNode;
                return leftNode;
            }else{
                // if The two ranges overlap, remove the range from current range
                while(this.next != null && node.rangeEnd > this.next.rangeEnd){
                    //  find next range end which is before the range end
                    this.next = this.next.next;
                }
                // remove
                if(this.next!=null){
                    this.rangeEnd = node.rangeStart;
                    this.next.rangeStart = node.rangeEnd;
                }else{
                    this.rangeStart = node.rangeEnd;
                }
                return this;
            }
        }

        /**
         * Add a new range(node) to the range list
         * @param node new range to be added
         * @return
         */
        private ListNode addNode(ListNode node){

            if(this.rangeStart <= node.rangeStart && this.rangeEnd >= node.rangeEnd){
                //if new node is already included, return
                return this;
            } else if(this.rangeStart > node.rangeEnd){
                //if range end of new node is before current range
                //new node go into the head
                node.next = this;
                return node;
            }else{
                if(this.rangeEnd < node.rangeStart){
                    //if range start of new node is after current range, try next range recursively
                    this.next = this.next != null?this.next.addNode(node):node;
                }else{
                    //if The two ranges overlap, combine them into new range
                    this.rangeStart = this.rangeStart < node.rangeStart? this.rangeStart: node.rangeStart;
                    this.rangeEnd = this.rangeEnd > node.rangeEnd? this.rangeEnd : node.rangeEnd;
                    //if combined range and next range overlap, continue to combine them
                    while(this.next != null){
                        if(this.rangeEnd < this.next.rangeEnd && this.rangeEnd > this.next.rangeStart){
                            this.rangeEnd = this.next.rangeEnd;
                        }
                        this.next = this.next.next;
                    }
                }
                return this;
            }
        }
    }
    private ListNode head = null;
    /**
     * Adds a range to the list
     * @param range Array of two integers that specify beginning and end of range.
     */
    public void add(int[] range) {
        ListNode newNode = new ListNode(range[0], range[1]);
        if(this.head == null){
            this.head = newNode;
        }else{
            this.head = this.head.addNode(newNode);
        }
    }

    /**
     * Removes a range from the list
     * @param range  Array of two integers that specify beginning and end of range.
     */
    public void remove(int[] range) {
        if(this.head == null){
            return;
        }
        this.head = this.head.removeNode(new ListNode(range[0], range[1]));
    }

    /** * Prints out the list of ranges in the range list */
    public String print() {
        String ret = "";
        if(this.head == null){
            System.out.println("()");
            return "()";
        }
        ListNode node = this.head;
        while(node!=null){
            System.out.print("["+node.rangeStart +", " + node.rangeEnd +") ");
            ret += "["+node.rangeStart +", " + node.rangeEnd +") ";
            node = node.next;
        }
        System.out.println();
        return ret;
    }

    public static void main(String[] args) {
        // Example run
        RangeListTest rl = new RangeListTest();
        rl.add(new int[]{1,20});
        String ret = rl.print();
        rl.remove(new int[]{4, 16});
        String ret1 = rl.print();
//        rl.add(new int[]{0, 24});
//        rl.print();
        rl.remove(new int[]{-100, 100});
        rl.print();
    }
}
