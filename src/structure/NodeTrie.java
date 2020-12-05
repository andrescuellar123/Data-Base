package structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NodeTrie {

	
	private LinkedList<NodeTrie> son;
	private NodeTrie parent;
	private boolean stop;
	private char value;
	
	public NodeTrie(char element) {

		this.setValue(element);
		setChildren(new LinkedList<NodeTrie>());
		setEnd(false);

	}

	public NodeTrie getChild(char c) {

		if (getSon() != null) {
			for (NodeTrie ch : getSon()) {
				if (ch.getValue() == c) {
					return ch;
				}
			}
		}
		return null;
	}


	public LinkedList<NodeTrie> getSon() {
		return son;
	}

	public void setChildren(LinkedList<NodeTrie> children) {
		this.son = children;
	}

	public NodeTrie getParent() {
		return parent;
	}

	public void setParent(NodeTrie parent) {
		this.parent = parent;
	}

	public boolean isEnd() {
		return stop;
	}

	public void setEnd(boolean isEnd) {
		this.stop = isEnd;

	}
	public char getValue() {
		return value;
	}

	public void setValue(char element) {
		this.value = element;
	}
	protected List<String> getTheSearchingWord() {

		List<String> list = new ArrayList<String>();
		if (isEnd()) {
			list.add(toString());
		}

		if (getSon() != null) {
			for (int i = 0; i < getSon().size(); i++) {
				if (getSon().get(i) != null) {
					list.addAll(getSon().get(i).getTheSearchingWord());
				}
			}
		}
		return list;
	}
	public String toString() {

		if (getParent() == null) {
			return "";

		} else {

			return getParent().toString() 
					+ new String(new char[] { value });
		}
	}
}