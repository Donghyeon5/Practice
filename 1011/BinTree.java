package algorithm.ch00;

import java.util.Comparator;

public class BinTree {
	
		// 노드
		static class Node<K,V> {
			private K key; // 키값
			private V data; // 데이터
			private Node<K,V> left; // 왼쪽 포인터(왼쪽 자식노드에 대한 참조)
			private Node<K,V> right; // 오른쪽 포인터(오른쪽 자식노드에 대한 참조)
			
		// 생성자
		public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			super();
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
			}
	
		public K getKey() {
			return key;
		}
	
		public V getData() {
			return data;
		}
	}

	private Node<K,V> root; // 루트
	private Comparator<? super K> comparator = null; // 비교자(Comparator)
		
	public BinTree() {
		root = null;
		}	
	
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
		}
	
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
		: comparator.compare(key1, key2);
		}

		public V search(K key) {
			Node<K, V> p = root; // 루트에 주목
			while (true) {
				if (p == null) // 더 이상 나아갈 수 없으면
					return null; // …검색 실패
				int cond = comp(key, p.getKey()); // key와 노드 p의 키를 비교
				if (cond == 0) // 같으면
					return p.getData(); // …검색 성공
				else if (cond < 0) // key 쪽이 작으면
					p = p.left; // …왼쪽 서브트리에서 검색
				else // key 쪽이 크면
					p = p.right; // …오른쪽 서브트리에서 검색
			}
		}
		
		// --- node를 뿌리로 하는 서브트리에 노드 <K,V>를 삽입 ---//
		private void addNode(Node<K, V> node, K key, V data) {
			int cond = comp(key, node.getKey());
			if (cond == 0)
				return; // key가 이진검색트리에 이미 존재
			else if (cond < 0) {
				if (node.left == null)
					node.left = new Node<K, V>(key, data, null, null);
				else
					addNode(node.left, key, data); // 왼쪽 서브트리에 주목
			} else {
				if (node.right == null)
					node.right = new Node<K, V>(key, data, null, null);
				else
					addNode(node.right, key, data); // 오른쪽 서브트리에 주목
			}
		}
		
		// --- 노드 삽입 ---//
		public void add(K key, V data) {
			if (root == null)
				root = new Node<K, V>(key, data, null, null);
			else
				addNode(root, key, data);
		}


}
