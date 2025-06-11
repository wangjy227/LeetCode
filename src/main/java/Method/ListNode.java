package Method;

/**
 * 链表
 *
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 根据数组创建链表
     * @param arr
     * @return
     */
    public ListNode ListNodeInit(int[] arr){
        ListNode Head = new ListNode();
        ListNode R = Head;
        int len = arr.length;
        for(int i = 0;i<len;i++){
            ListNode temp = new ListNode(arr[i]);
            Head.next = temp;
            Head = Head.next;
        }
        return R;
    }

    /**
     * 按顺序输出链表节点
     */
    public void PutListNode(){
        ListNode temp = this;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
