package com.WebTest.jerry;

public class RangeListII {
    class ListNode{
        int rangeStart;
        int rangeEnd;
        ListNode next;
        private ListNode(int rangeStart, int rangeEnd){
            this.rangeStart = rangeStart;
            this.rangeEnd = rangeEnd;
        }

        private ListNode unlink(ListNode element){
            if(element.rangeEnd - element.rangeStart <= 0){
                return this;
            }
            if(element.rangeStart > this.rangeEnd){
                if(this.next!= null){
                    this.next = this.next.unlink(element);
                }
                return this;
            }

            if(this.rangeStart == element.rangeStart && this.rangeEnd == element.rangeEnd){
                return this.next;
            }else if(this.rangeStart < element.rangeStart && this.rangeEnd >= element.rangeEnd){
                ListNode leftNode = new ListNode(this.rangeStart, element.rangeStart);
                ListNode rightNode = new ListNode(element.rangeEnd, this.rangeEnd);
                rightNode.next = this.next;
                leftNode.next = rightNode;
                return leftNode;
            }else{
                while(this.next != null && element.rangeEnd > this.next.rangeEnd){
                    this.next = this.next.next;
                }
                if(this.next!=null){
                    this.rangeEnd = element.rangeStart;
                    this.next.rangeStart = element.rangeEnd;
                }else{
                    this.rangeStart = element.rangeEnd;
                }
                return this;
            }
        }

        private ListNode link(ListNode element){
            if(this.rangeStart <= element.rangeStart && this.rangeEnd >= element.rangeEnd){
                return this;
            }else if(this.rangeStart > element.rangeEnd){
                element.next = this;
                return element;
            }else{
                if(this.rangeEnd < element.rangeStart){
                    this.next = this.next != null?this.next.link(element):element;
                }else{
                    this.rangeStart = this.rangeStart < element.rangeStart? this.rangeStart: element.rangeStart;
                    this.rangeEnd = this.rangeEnd > element.rangeEnd? this.rangeEnd : element.rangeEnd;

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
     *  Adds a range to the list * @param {Array<number>} range - Array of two integers that specify beginning and end of range.
     */
    public void add(int[] range) {
        ListNode newNode = new ListNode(range[0], range[1]);
        if(this.head == null){
            this.head = newNode;
        }else{
            this.head = this.head.link(newNode);
        }
    }
    /** *
     * Removes a range from the list * @param {Array<number>} range - Array of two integers that specify beginning and end of range.
     * 没有说是否需要返回
     * */
    public void remove(int[] range) {
        if(this.head == null){
            return;
        }
        this.head = this.head.unlink(new ListNode(range[0], range[1]));
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
        RangeListII rl = new RangeListII();
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
