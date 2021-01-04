// https://www.freecodecamp.org/news/all-you-need-to-know-about-tree-data-structures-bceacb85490c/  - REF in python

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class BinarySearchTree {
  private class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node=" + value;
    }
  }

  private Node root;


  
/////////////////////InserTION USING NOT RECURSION/////////////////////////////////	O(logn) 
  public void insert(int value) {
    var node = new Node(value);

    if (root == null) {
      root = node;
      return;
    }

    var current = root;
    while (true) {
      if (value < current.value) {
        if (current.leftChild == null) {
          current.leftChild = node;
          break;
        }
        current = current.leftChild;
      } else {
        if (current.rightChild == null) {
          current.rightChild = node;
          break;
        }
        current = current.rightChild;
      }
    }
  }

  
////////////////////INSERTION USING RECURSION///////////////////////////////////////	O(logn)
public void insertnodeRcall(int value) {  
if(root == null) {                      //AS JAVA ONLY PASSED BY VALUE
root = new Node(value);
return;
}
insertnodeR(value, root);
}

private void insertnodeR(int value,Node root) {



if(root.leftChild != null && value <= root.value ) {

insertnodeR(value, root.leftChild);
}
else if(value <= root.value)
{
root.leftChild = new Node(value);
}
else if(root.rightChild != null && value > root.value) {
insertnodeR(value, root.rightChild);
}
else  {
root.rightChild = new Node(value);
}

}
//=====================================================
  
  
////////////////////////////////////////////////////////////////////////////
///   My find	
/*
public boolean find(int value) {

if(root == null) {
throw new IllegalStateException("EMPTY TREE");
}

Node current = root;

while(true) {
if(current.value == value)
return true;

if(value < current.value ) {
current = current.leftchild;

}
else if(value > current.value ) {
current = current.rightchild;
}
if(current == null)
return false;
}

}
*/
//////////////////////////////////////////////////////////////////

  public boolean find(int value) {
	
    var current = root;
    while (current != null) {
      if (value < current.value)
        current = current.leftChild;
      else if (value > current.value)
        current = current.rightChild;
      else
        return true;
    }
    return false;
  }
  
/////////////////TREE TRAVERSALS////////////////////////////////////////
  
  
  public void traversePreOrder() {
    traversePreOrder(root);
  }

  private void traversePreOrder(Node root) {
    if (root == null)
      return;

    System.out.println(root.value);
    traversePreOrder(root.leftChild);
    traversePreOrder(root.rightChild);
  }

  public void traverseInOrder() {
    traverseInOrder(root);
  }

  private void traverseInOrder(Node root) {
    if (root == null)
      return;

    traverseInOrder(root.leftChild);
    System.out.println(root.value);
    traverseInOrder(root.rightChild);
  }

  public void traversePostOrder() {
    traversePostOrder(root);
  }

  private void traversePostOrder(Node root) {
    if (root == null)
      return;

    traversePostOrder(root.leftChild);
    traversePostOrder(root.rightChild);
    System.out.println(root.value);
  }

  /////////////////////////////////////////////////\
  
  public int height() {
    return height(root);
  }

  private int height(Node root) {
    if (root == null)
      return -1;

    if (isLeaf(root)) //base case
      return 0;

    return 1 + Math.max(
            height(root.leftChild),
            height(root.rightChild));
  }
  
//=========================================================
  
  private boolean isLeaf(Node node) {
    return node.leftChild == null && node.rightChild == null;
  }

  
  // O(log n)
  public int min() {
    if (root == null)
      throw new IllegalStateException();

    var current = root;
    var last = current;
    while (current != null) {
      last = current;
      current = current.leftChild;
    }
    return last.value;
  }
/////////////////////////////////////////////
  // O(n)
  private int min(Node root) {
    if (isLeaf(root))
      return root.value;

    var left = min(root.leftChild);
    var right = min(root.rightChild);

    return Math.min(Math.min(left, right), root.value);
  }

  ////////////////////////////////////////////////
  
  public boolean equals(BinarySearchTree other) {
    if (other == null)
      return false;

    return equals(root, other.root);
  }

  private boolean equals(Node first, Node second) {
    if (first == null && second == null)
      return true;

    if (first != null && second != null)
      return first.value == second.value
              && equals(first.leftChild, second.leftChild)
              && equals(first.rightChild, second.rightChild);

    return false;
  }
//////////////////////////////////////////////////////////////
  
  public boolean isBinarySearchTree() {
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBinarySearchTree(Node root, int min, int max) {
    if (root == null)
      return true;

    if (root.value < min || root.value > max)
      return false;

    return
            isBinarySearchTree(root.leftChild, min, root.value - 1)
                    && isBinarySearchTree(root.rightChild, root.value + 1, max);
  }

  ////////////////////////////////////////////////////////////////
  
  public ArrayList<Integer> getNodesAtDistance(int distance) {
    var list = new ArrayList<Integer>();
    getNodesAtDistance(root, distance, list);
    return list;
  }

  private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
    if (root == null)
      return;

    if (distance == 0) {
      list.add(root.value);
      return;
    }

    getNodesAtDistance(root.leftChild, distance - 1, list);
    getNodesAtDistance(root.rightChild, distance - 1, list);
  }
  /////////////////////////////////////////////////////

  public void traverseLevelOrder() {
    for (var i = 0; i <= height(); i++) {
      for (var value : getNodesAtDistance(i))
        System.out.println(value);
    }
  }
////////////////////////////////////////////////////////
  // with queue 
  private void bredthfirstserch() {
		if(root == null) {
			throw new IllegalStateException("EMPTY");
		}
		Queue<Node> queue = new LinkedList<>();
		Node curent = root;
		queue.add(curent);
		
		while(!queue.isEmpty()) {
			Node currentnode = queue.remove();
			
			System.out.println(currentnode.value);
			
			if(currentnode.leftChild != null) {
				queue.add(currentnode.leftChild);
			}
			
			if(currentnode.rightChild != null) {
				queue.add(currentnode.rightChild);
			}
			
			
		}
  }
/////////////////////////////////////////////////counting nodes
//  =================================================
  
  public int size() {
    return size(root);
  }

  private int size(Node root) {
    if (root == null)
      return 0;

    if (isLeaf(root))
      return 1;

    return 1 + size(root.leftChild) + size(root.rightChild);
  }
////////////////////////////////////////////////counting leaves
  public int countLeaves() {
    return countLeaves(root);
  }

  private int countLeaves(Node root) {
    if (root == null)
      return 0;

    if (isLeaf(root))
      return 1;

    return countLeaves(root.leftChild) + countLeaves(root.rightChild);
  }
  ////////////////////////////////////////////////////////

  public int max() {
    if (root == null)
      throw new IllegalStateException();

    return max(root);
  }
/////////////////////////////////////////////////////
  private int max(Node root) {
    if (root.rightChild == null)
      return root.value;

    return max(root.rightChild);
  }
//////////////////////////////////////////////////
  public boolean contains(int value) {
    return contains(root, value);
  }

  private boolean contains(Node root, int value) {
    if (root == null)
      return false;

    if (root.value == value)
      return true;

    return contains(root.leftChild, value) || contains(root.rightChild, value);
  }
  /////////////////////////////////////////////////////////////

  public boolean areSibling(int first, int second) {
    return areSibling(root, first, second);
  }

  private boolean areSibling(Node root, int first, int second) {
    if (root == null)
      return false;

    var areSibling = false;
    if (root.leftChild != null && root.rightChild != null) {
      areSibling = (root.leftChild.value == first && root.rightChild.value == second) ||
                   (root.rightChild.value == first && root.leftChild.value == second);
    }

    return areSibling ||
            areSibling(root.leftChild, first, second) ||
            areSibling(root.rightChild, first, second);
  }

  ////////////////////////////////////////////////////////////
  public List<Integer> getAncestors(int value) {
    var list = new ArrayList<Integer>();
    getAncestors(root, value, list);
    return list;
  }

  private boolean getAncestors(Node root, int value, List<Integer> list) {
    // We should traverse the tree until we find the target value. If
    // find the target value, we return true without adding the current node
    // to the list; otherwise, if we ask for ancestors of 5, 5 will be also
    // added to the list.
    if (root == null)
      return false;

    if (root.value == value)
      return true;

    // If we find the target value in the left or right sub-trees, that means
    // the current node (root) is one of the ancestors. So we add it to the list.
    if (getAncestors(root.leftChild, value, list) ||
        getAncestors(root.rightChild, value, list)) {
      list.add(root.value);
      return true;
    }

    return false;
  }

  ////////////////////////////////////////////////
  public boolean isBalanced() {
    return isBalanced(root);
  }

  private boolean isBalanced(Node root) {
    if (root == null)
      return true;

    var balanceFactor = height(root.leftChild) - height(root.rightChild);

    return Math.abs(balanceFactor) <= 1 &&
            isBalanced(root.leftChild) &&
            isBalanced(root.rightChild);
  }

  public boolean isPerfect() {
    return size() == (Math.pow(2, height() + 1) - 1);
  }
  
  public int findminbst() {
	 return  findminbst(root);
  }
  private int findminbst(Node root) {

	  	if(root.leftChild != null) {
	  	return findminbst(root.leftChild);
	  	}else {
	  		return root.value;
	  	}

}
  
  
  
  
  
  
  
  
  
  
  
//  public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		BinarySearchTree bst = new BinarySearchTree();
////		bst.insertnode(30);
////		bst.insertnode(20);
////		bst.insertnode(40);
////		bst.insertnode(10);
////		bst.insertnode(50);
////		bst.insertnode(35);
////		bst.insertnode(25);
//		bst.insertnodeRcall(30);
////		bst.insertnodeRcall(20);
//		bst.insertnodeRcall(20);
//		bst.insertnodeRcall(-70);
//		bst.insertnodeRcall(40);
//		bst.insertnodeRcall(10);
//		bst.insertnodeRcall(50);
//		bst.insertnodeRcall(35);
//		bst.insertnodeRcall(25);
//		
////		bst.preOrder();
//		bst.bredthfirstserch();
//		System.out.println(bst.findminbst());
////		System.out.println(bst.find(-20));
////		System.out.println(bst.findhight());
////		System.out.println(bst.findminimumval()); // this is for any binary tree
////		bst.findminimalofBST(); //fo BST
//		
}







//
//
//  
////  
////  def find_minimum_value(self):
////	    if self.left_child:
////	       return self.left_child.find_minimum_value()
////	    else:
////	       return self.value
//  
//
///////////////////////////////////////////////
////python
//  //// https://www.freecodecamp.org/news/all-you-need-to-know-about-tree-data-structures-bceacb85490c/  - REF in python
//  
//def remove_node(self, value, parent):
//    if value < self.value and self.left_child:
//        return self.left_child.remove_node(value, self)
//    elif value < self.value:
//        return False
//    elif value > self.value and self.right_child:
//        return self.right_child.remove_node(value, self)
//    elif value > self.value:
//        return False
//    else:
//        if self.left_child is None and self.right_child is None and self == parent.left_child:
//            parent.left_child = None
//            self.clear_node()
//        elif self.left_child is None and self.right_child is None and self == parent.right_child:
//            parent.right_child = None
//            self.clear_node()
//        elif self.left_child and self.right_child is None and self == parent.left_child:
//            parent.left_child = self.left_child
//            self.clear_node()
//        elif self.left_child and self.right_child is None and self == parent.right_child:
//            parent.right_child = self.left_child
//            self.clear_node()
//        elif self.right_child and self.left_child is None and self == parent.left_child:
//            parent.left_child = self.right_child
//            self.clear_node()
//        elif self.right_child and self.left_child is None and self == parent.right_child:
//            parent.right_child = self.right_child
//            self.clear_node()
//        else:
//            self.value = self.right_child.find_minimum_value()
//            self.right_child.remove_node(self.value, self)
//
//        return True
//        		
//        		
//        		
//        		def clear_node(self):
//        		    self.value = None
//        		    self.left_child = None
//        		    self.right_child = None		
//        		    
//        		    
//        		def find_minimum_value(self):
//        		    if self.left_child:
//        		       return self.left_child.find_minimum_value()
//        		    else:
//        		       return self.value