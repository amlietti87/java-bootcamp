/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Globant;

/**
 *
 * @author andreslietti
 */
class RecentFileList<T> {

    private Node first;
    private final int listLong = 2;
    private int count = 0;
    private RecentFileList<T> list;

    public void RecentFileList() {
        list = new RecentFileList();
    }
    
    public int size() {
        Node node = first;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    void add(T file) {
        if (list.size() < listLong) {
            if (first == null) {
            first = new Node(file);
            list.add(file);
        } else {
            Node node = new Node(file);
            node.next = first;
            first = node;
            list.add(file);
        }
        } else {
            list.removeLast(listLong);
            list.add(file);
        }
        

    }

    public T get(int index) {

        Node node = first;

        while (index > 0) {
            index--;
            node = node.next;

        }
        return node.file;
    }

    public T removeLast(int index) {
        Node node = first;
        Node prev = null;
        while (index > 0) {
            index--;
            prev = node;
            node = node.next;
        }
        if (prev == null) {
            first = node.next;
        } else {
            prev.next = node.next;
        }
        return node.file;
    }

    private class Node {

        private final T file;
        private Node next;

        public Node(T file) {
            this.file = file;
        }

    }

}
