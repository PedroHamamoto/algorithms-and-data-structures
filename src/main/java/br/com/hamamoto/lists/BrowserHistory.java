package br.com.hamamoto.lists;

import java.util.Objects;
/**
 *<a href="https://leetcode.com/problems/design-browser-history/"> LeetCode problem </a> - Design a browser history
 * */
class BrowserHistory {

    static class ListNode {
        ListNode next;
        ListNode previous;
        String url;

        ListNode(String url) {
            this.url = url;
        }
    }

    ListNode current;

    public BrowserHistory(String homepage) {
        current = new ListNode(homepage);
    }
    
    public void visit(String url) {
        current.next = null;

        ListNode page = new ListNode(url);

        current.next = page;
        page.previous = current;

        current = page;
    }
    
    public String back(int steps) {
        ListNode pointer = current;

        while (Objects.nonNull(pointer.previous) && steps > 0) {
            pointer = pointer.previous;
            steps--;
        }

        current = pointer;

        return current.url;
    }
    
    public String forward(int steps) {
        ListNode pointer = current;

        while (Objects.nonNull(pointer.next) && steps > 0) {
            pointer = pointer.next;
            steps--;
        }

        current = pointer;

        return current.url;
    }
}