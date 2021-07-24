package Project5SortedTreeList;

import java.util.Iterator;

public class treetest {

	public static void main(String[] args) {
		SortedTreeList<String> sortedtree = new SortedTreeList<>();
		BinarySearchTree<String> binarysearchtree = new BinarySearchTree<>();

		binarysearchtree.add("h");

		sortedtree.addEntry("j");
		sortedtree.addEntry("o");
		sortedtree.addEntry("s");
		sortedtree.addEntry("h");

		Iterator<String> it = sortedtree.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println(sortedtree.contains("j"));

		System.out.println(sortedtree.getPosition("h"));
		System.out.println(sortedtree.getEntry(1));

		System.out.println(sortedtree.getLength());

		binarysearchtree.clear();
		System.out.println(sortedtree.isEmpty());

		Object[] arr = sortedtree.toArray();

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	

}