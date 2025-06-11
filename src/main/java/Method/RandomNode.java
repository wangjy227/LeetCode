package Method;

/**
 * Ëæ»úÁ´±í
 */
public class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public RandomNode(int val, RandomNode next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }
}
