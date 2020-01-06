package com.leetcode.common;

import java.util.*;

class LRUCache {
    //定义一个节点类
    private static class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    //缓存HashMap
    private HashMap<Integer,DLinkedNode> cache = new HashMap<>();
    //当前节点数量
    private int count;
    //总容量
    private int capacity;
    //头节点
    private DLinkedNode head;
    //尾结点
    private DLinkedNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        //初始化头尾节点
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.pre = null;
        head.post = tail;

        tail.pre = head;
        tail.post = null;
    }
    //moveToHead操作包括：1 摘出来，2 放到头部
    private void moveToHead(DLinkedNode node) {
        //摘出来
        moveNode(node);
        //放到头上
        addHead(node);
    }
    //摘出来
    private void moveNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }
    //放到头上
    private void addHead(DLinkedNode node){
        node.post = head.post;
        node.pre = head;
        head.post.pre = node;
        head.post = node;
    }
    //弹出末尾节点
    private DLinkedNode popTail(){
        DLinkedNode lastNode = tail.pre;
        moveNode(lastNode);
        return lastNode;
    }
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        //当node 存在，则将node放到最前边
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){//如果node不存在
            //new一个node
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key,newNode);//放入缓存
            addHead(newNode);//把newHead放到最前边
            count++;//增加计数
            if(count > capacity) {//超出容量
                //提出最末端
                DLinkedNode lastNode = popTail();
                cache.remove(lastNode.key);//从缓存中删除末尾节点
                count--;
            }
        }else{//如果已经存在，则直接将node放到最前边
            node.value = value;//更新一下value值
            moveToHead(node);//将node放到最前边
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */