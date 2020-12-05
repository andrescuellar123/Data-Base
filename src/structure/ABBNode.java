package structure;

import java.io.Serializable;



public class ABBNode<K extends Comparable<K>,V> implements Serializable{
	private K key;
	private V value;
	private ABBNode<K, V> parent;
	private ABBNode<K, V> left;
	private ABBNode<K, V> right;
	int height;
	int rHeight;
	int lHeight;

	public ABBNode(K key, V value) {
		this.key = key;
		this.value = value;
		left=null;
		right=null;
		parent = null;
		height = 0;
		rHeight = 0;
		lHeight = 0;
	}




	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public ABBNode<K, V> getParent() {
		return parent;
	}

	public void setParent(ABBNode<K, V> parent) {
		this.parent = parent;
	}

	public ABBNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(ABBNode<K, V> left) {
		this.left = left;
	}

	public ABBNode<K, V> getRight() {
		return right;
	}

	public void setRight(ABBNode<K, V> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return (left==null && right==null);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getrHeight() {
		return rHeight;
	}

	public void setrHeight(int rHeight) {
		this.rHeight = rHeight;
	}

	public int getlHeight() {
		return lHeight;
	}

	public void setlHeight(int lHeight) {
		this.lHeight = lHeight;
	}
	public int compareTo(ABBNode<K, V> b) {
		return (this.getKey()).compareTo(b.getKey());

	}
}
