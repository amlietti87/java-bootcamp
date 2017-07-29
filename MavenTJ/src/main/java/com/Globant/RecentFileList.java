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
    private final int maxLong = 5;
    private int count = 0;
    
    public int size() {
        Node node = first;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    void addFirst(T file, int listLong) {
        if (listLong <= maxLong) {
            if (first == null) {
                first = new Node(file);
                
            } else {
                if (!existFile(file)) {
                    Node node = new Node(file);
                    node.next = first;
                    first = node;
                } else {
                    deleteFile(file);
                    addFirst(file, (listLong - 1));
                    
                }
            }
        } else {
            removeLast();
            addFirst(file, (listLong - 1));
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

    public void removeLast() {
        Node node = first;
        Node t = node;
        if (first.next == null) {
            node = null;
        }
        while (node.next != null) {
            t = node;
            node = node.next;
        }
        t.next = null;
    }

    public boolean existFile(T file) {
        Node aux = first;
        boolean exist = false;
        do {
            if (file == aux.file) {
                exist = true;
            } else {
                aux = aux.next;
            }
        } while (aux != null && exist != true);

        return exist;
    }

    public void deleteFile(T file) {
        Node node = first;
        Node t = node;
        if (file == node.file) {
            node = null;
        }
        while (file != node.file) {
            t = node;
            node = node.next;
        }
        t.next = node.next;
        node = null;
    }

    private class Node {

        private final T file;
        private Node next;

        public Node(T file) {
            this.file = file;
        }

    }

}
