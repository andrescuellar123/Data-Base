package structure;

import java.util.ArrayList;
import java.util.List;


public class ABBTree<K extends Comparable<K>, V>  {

	private ABBNode<K,V> root;
	private int size;



	public boolean add(K key, V value) {
		ABBNode<K, V> bstn = new ABBNode<>(key, value);

		return add(bstn);
	}


	protected boolean add(ABBNode<K, V> node) {

		if (root == null) {

			root = node;
		} else {

			add(root, node);
		}
		setSize(getSize() + 1);
		return true;

	}


	private void add(ABBNode<K, V> otherNode, ABBNode<K, V> newNode) {

		if (otherNode.compareTo(newNode) > 0) {
			if (otherNode.getLeft() == null) {
				otherNode.setLeft(newNode);
				newNode.setParent(otherNode);
			} else {
				add(otherNode.getLeft(), newNode);
			}

		} else {
			if (otherNode.getRight() == null) {
				otherNode.setRight(newNode);
				newNode.setParent(otherNode);

			} else {
				add(otherNode.getRight(), newNode);
			}
		}

	}


	public ABBNode<K,V> getMin(ABBNode<K,V> node){

		while(node.getLeft() != null) {

			node = node.getLeft();

		}

		return node;	

	}


	public ABBNode<K, V> getRoot() {
		return root;
	}
	public int getSize() {
		return size;
	}
	public void setRoot(ABBNode<K, V> root) {
		this.root = root;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ABBNode<K, V> searchNode(K key) {

		if (root.getKey().equals(key)) {

			return root;
		}

		return search(root, key);

	}

	private ABBNode<K, V> search(ABBNode<K, V> current, K key) {

		if (current == null) {

			return null;

		} else if (current.getKey().equals(key)) {

			return current;

		} else if (current.getKey().compareTo(key) > 0) {

			if (current.getLeft() == null) {

				return null;

			} else {

				return search(current.getLeft(), key);

			}

		} else {

			if (current.getKey().equals(key)) {

				return current;

			} else {

				return search(current.getRight(), key);

			}
		}

	}


	public void removeNode(K key) {

		ABBNode<K, V> removeNode = searchNode(key);

		if (removeNode != null) {

			if (removeNode.getRight() == null && removeNode.getLeft() == null) {

				if (removeNode.getParent().getLeft() == removeNode) {

					removeNode.getParent().setLeft(null);
				} else {

					removeNode.getParent().setRight(null);

				}

			} else if (removeNode.getRight() == null ^ removeNode.getLeft() == null) {

				if (removeNode.getRight() != null) {

					if (removeNode.getParent().getRight() == removeNode) {

						removeNode.getRight().setParent(removeNode.getParent());
						removeNode.getParent().setRight(removeNode.getRight());

					} else {

						removeNode.getRight().setParent(removeNode.getParent());
						removeNode.getParent().setLeft(removeNode.getRight());

					}

				} else {

					if (removeNode.getParent().getRight() == removeNode) {

						removeNode.getLeft().setParent(removeNode.getParent());
						removeNode.getParent().setRight(removeNode.getLeft());
						

					} else {

						removeNode.getLeft().setParent(removeNode.getParent());
						removeNode.getParent().setLeft(removeNode.getLeft());
						
					}

				}

			} else if (removeNode.getLeft() != null && removeNode.getRight() != null) {

				ABBNode<K, V> current = removeNode.getLeft();

				while (current.getRight() != null) {

					current = current.getRight();

				}

				if (current.getParent().getRight() == current) {

					current.getParent().setRight(null);

				} else {

					current.getParent().setLeft(null);

				}

				current.setParent(removeNode.getParent());
				
				current.setLeft(removeNode.getLeft());
				
				current.setRight(removeNode.getRight());
				
				current.getRight().setParent(current);
				
				current.getLeft().setParent(current);

				if (removeNode.getParent().getRight() == removeNode) {

					current.getParent().setRight(current);
					
				} else {

					current.getParent().setLeft(current);
				

				}

				current = null;
				
			}
		}
	}

}
