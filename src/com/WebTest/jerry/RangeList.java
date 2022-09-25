package com.WebTest.jerry;

public class RangeList {
    class ListNode{
        int rangeStart;
        int rangeEnd;
        ListNode next;
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
                return this;
            }else if(node.rangeStart > this.rangeEnd){
                // if range start of the node is after current range, try next range recursively
                if(this.next!= null){
                    this.next = this.next.removeNode(node);
                }
                return this;
            }else if(this.rangeStart == node.rangeStart && this.rangeEnd == node.rangeEnd){
                //if the range exact match the current range, return next
                return this.next;
            }else if(this.rangeStart < node.rangeStart && this.rangeEnd >= node.rangeEnd){
                // if current range wraps the range, break into 2 range, and return left
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
                    while(this.next != null && this.rangeEnd >= this.next.rangeStart){
                        this.rangeEnd = this.next.rangeEnd;
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
    public void print() {
        if(this.head == null){
            System.out.println("()");
            return;
        }
        ListNode node = this.head;
        while(node!=null){
            System.out.print("["+node.rangeStart +", " + node.rangeEnd +") ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example run
        RangeList rl = new RangeList();
        rl.add(new int[]{1,5});
        rl.print(); // Should display: [1, 5)

        rl.add(new int[]{10, 20});
        rl.print(); // Should display: [1, 5) [10, 20)

        rl.add(new int[]{20, 20});
        rl.print(); // Should display: [1, 5) [10, 20)

        rl.add(new int[]{20, 21});
        rl.print(); // Should display: [1, 5) [10, 21)

        rl.add(new int[]{2, 4});
        rl.print(); // Should display: [1, 5) [10, 21)

        rl.add(new int[]{3, 8});
        rl.print(); // Should display: [1, 8) [10, 21)

        rl.remove(new int[]{5,7});
        rl.print();

        rl.add(new int[]{-5, 0});
        rl.print();

        rl.remove(new int[]{-3, 2});
        rl.print();

        rl.add(new int[]{100, 120});
        rl.print();

    }
}
