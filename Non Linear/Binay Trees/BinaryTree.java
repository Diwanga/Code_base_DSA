

//https://www.freecodecamp.org/news/all-you-need-to-know-about-tree-data-structures-bceacb85490c/


//
/*
meka nikanma tree ekak. binary search tree neme.


 */

////////////////////////////////////////////////////////////////////////////////////
public class BinaryTree { //children 2 inna ona ekak
	private Node root ;
	
private class Node {

int value;
private Node leftchild;
private Node rightchild;

public Node(int value) {
	// TODO Auto-generated constructor stub
	this.value = value;
}
public Node insertNodeToLeft(int value) {  // ona ne. node.left eken krnna puluwn.. else part ekata withrai meka ona
	Node newNode = new Node(value);
	if(this.leftchild == null) {
		this.leftchild = newNode;
	}
	else {  // this is our choice  no restriction as binary tree
		newNode.leftchild = this.leftchild;
		this.leftchild = newNode;
	}
	return newNode;
}

public Node insertNodeToRight(int value) {
	Node newNode = new Node(value);
	if(this.rightchild == null) {
		this.rightchild = newNode;
	}
	else { // this si our choice. no restriction as binary tree
		newNode.rightchild = this.leftchild;
		this.rightchild = newNode;
	}
	return newNode;
}

}

public BinaryTree(int value) {
	// TODO Auto-generated constructor stub
	root = new Node(value);
}

//public Node getroot() {
//	return root;
//}

public void creteTree() {
	Node A20 = root.insertNodeToLeft(20);
	 Node A40 = root.insertNodeToRight(40);
	 Node A10 = A20.insertNodeToLeft(10);
	 Node A25 = A20.insertNodeToRight(25);
	 Node A35 = A40.insertNodeToLeft(35);
	 Node A50 = A40.insertNodeToRight(50);
}

public void preOrder() {
	
	preorder(root);
	
	
}

private void preorder(Node root) {
	
	if(root == null) {
		return;
	}
	
	System.out.println(root.value);
	preorder(root.leftchild);
	preorder(root.rightchild);
	
}


//Traversal Algorithems

public static void main(String[] args) {
	BinaryTree a = new BinaryTree(30);
    a.creteTree();
    
    a.preOrder();  //30 20 10 25 40 35 50

 

}





	
	
}

