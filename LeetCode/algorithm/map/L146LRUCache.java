package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class L146LRUCache {
    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     *
     * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lru-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *   对于满足题目要求空间复杂度为1由此可知哈希表空间复杂度为o(1)
     *   若要快速的存取元素则定为双向链表，且设置头节点和尾节点便于操作
     */

    //创建一个双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;  //记录双向链表种元素的个数
    private int capacity;  //记录双向链表节点的个数
    private DLinkedNode head;  //定义头节点
    private DLinkedNode tail;  //定义尾节点

    public L146LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //创建头节点和尾节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //获取对应键的值
        DLinkedNode node = cache.get(key);
        //判断此节点元素是否存在
        if (node == null) {
            return -1;
        }
        //如果存在通过哈希表定位返回到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        //获取对应键的值
        DLinkedNode node = cache.get(key);
        //判断此节点是否存在
        if (node == null) {
            //不存在添加一个新节点且添加到哈希表中
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加到哈希表中
            cache.put(key, newNode);
            //添加到双向链表头部
            addToHead(newNode);
            size++;
            //判断是否溢出
            if (size > capacity) {
                //删除双向链表的尾部且哈希表中的值
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            //节点存在，定位到哈希表修改value值，再将此节点移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 将节点添加到头部
     * @param node
     */
    public void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除节点
     * @param node
     */
    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 移动节点到头部
     * @param node
     */
    public void moveToHead(DLinkedNode node) {
        //删除节点，再将其节点添加到头部
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除尾节点元素
     * @return
     */
    public DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        //删除此节点
        removeNode(node);
        return node;
    }
}
