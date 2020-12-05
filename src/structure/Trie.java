package structure;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	private NodeTrie root;

	public Trie() {
		root = new NodeTrie(' ');
	}

	
	public void add(String TheSearchingWord) {
		if (search(TheSearchingWord) == true)
			return;

		NodeTrie theroot = root;
		NodeTrie pre = null;
		
		for (char cha : TheSearchingWord.toCharArray()) {
			pre = theroot;
			NodeTrie child = theroot.getChild(cha);
			if (child != null) {
				theroot = child;
				child.setParent(pre);
			} else {
				theroot.getSon().add( new NodeTrie(cha));
				theroot = theroot.getChild(cha);
				theroot.setParent(pre);
			}
		}
		theroot.setEnd(true);
	}

	public boolean search(String word) {
		NodeTrie actual = root;
		for (char ch : word.toCharArray()) {
			if (actual.getChild(ch) == null)
				return false;
			else {
				actual = actual.getChild(ch);
			}
		}
		if (actual.isEnd() == true) {
			return true;
		}
		return false;
	}

	public List<String> completeSentence(String TheSearchingWord) {
		
		NodeTrie last = root;
		
		for (int i = 0; i < TheSearchingWord.length(); i++) {
			last = last.getChild(TheSearchingWord.charAt(i));
			
			if (last == null)
				return new ArrayList<String>();
		}

		return last.getTheSearchingWord();
	}
}
