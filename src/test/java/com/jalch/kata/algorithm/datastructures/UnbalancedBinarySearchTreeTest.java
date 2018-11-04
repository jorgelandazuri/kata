package com.jalch.kata.algorithm.datastructures;

import com.jalch.kata.algorithm.datastructures.IntegerUnbalancedBinarySearchTree.Node;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UnbalancedBinarySearchTreeTest {

    private IntegerUnbalancedBinarySearchTree underTest;

    @Before
    public void setUp() {
        underTest = new IntegerUnbalancedBinarySearchTree();
    }

    @Test
    public void insert_single_element() {
        underTest.insert(20);
        assertThat(underTest.size(), is(1L));
        assertNode(20, null, null);
        assertThat(underTest.getInOrder(underTest.root).get(0), is(20));
        assertThat(underTest.getPreOrder(underTest.root).get(0), is(20));
        assertThat(underTest.getPostOrder(underTest.root).get(0), is(20));

        assertThat(underTest.getInOrder(underTest.root), is(singletonList(20)));
        assertThat(underTest.getPreOrder(underTest.root), is(singletonList(20)));
        assertThat(underTest.getPostOrder(underTest.root), is(singletonList(20)));
        assertThat(underTest.getBreadthFirstTraversalOrder(), is(singletonList(20)));
    }

    @Test
    public void insert_multiple_elements() {
        underTest.insert(20);
        underTest.insert(10);
        underTest.insert(15);
        underTest.insert(25);
        underTest.insert(25);
        underTest.insert(-20);
        assertThat(underTest.size(), is(6L));
        assertNode(20, new Node(10), new Node(25));
        assertNode(10, new Node(-20), new Node(15));
        assertNode(15, null, null);
        assertNode(25, new Node(25), null);
        assertNode(-20, null, null);

        assertThat(underTest.getInOrder(underTest.root), is(asList(-20, 10, 15, 20, 25, 25)));
        assertThat(underTest.getPreOrder(underTest.root), is(asList(20, 10, -20, 15, 25, 25)));
        assertThat(underTest.getPostOrder(underTest.root), is(asList(-20, 15, 10, 25, 25, 20)));
        assertThat(underTest.getBreadthFirstTraversalOrder(), is(asList(20, 10, 25, -20, 15, 25)));
    }

    private void assertNode(int value, Node leftData, Node rightData) {
        assertThat(underTest.contains(value), is(true));
        Node found = underTest.findFirstWith(value);
        assertThat(found.value, is(value));
        assertThat(leftData != null ? found.left.value : null, is(leftData != null ? leftData.value : null));
        assertThat(rightData != null ? found.right.value : null, is(rightData != null ? rightData.value : null));

    }
}