package classes.data_structures;

interface BinaryTreeInterface<T> {
    public void Insert(T value);

    public T Delete(TreeNode<T> deleteNode);

    public TreeNode<T> Find(T findKey, TreeNode<T> currentNode);

    public TreeNode<T> Last(TreeNode<T> currentNode);

    public TreeNode<T> Next(TreeNode<T> currentNode);

    public void InOrder(TreeNode<T> current, Queue<T> returnQueue);

    public void PreOrder(TreeNode<T> current, Queue<T> returnQueue);

    public void PosOrder(TreeNode<T> current, Queue<T> returnQueue);

    public Queue<T> ByLevel(TreeNode<T> current);
}

/**
 * @param <T> that define the data type
 */
class TreeNode<T> {

    private T key;
    private int height;
    private TreeNode<T> left, right, parent;

    /**
     * Constructor of the class TreeNode
     * 
     * @param key to be stored
     */
    TreeNode(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
    }

    /**
     * Constructor of the class TreeNode
     * 
     * @param key   to be stored
     * @param right node pointer
     */
    TreeNode(T key, TreeNode<T> right) {
        this.key = key;
        this.left = null;
        this.right = right;
        this.parent = null;
        this.height = 0;
    }

    /**
     * Constructor of the class TreeNode
     * 
     * @param key   to be stored
     * @param right node pointer
     * @param left  node pointer
     */
    TreeNode(T key, TreeNode<T> right, TreeNode<T> left) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = null;
        this.height = 0;
    }

    /**
     * Constructor of the class TreeNode
     * 
     * @param key    to be stored
     * @param right  node pointer
     * @param left   node pointer
     * @param parent node pointer
     */
    TreeNode(T key, TreeNode<T> right, TreeNode<T> left, TreeNode<T> parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.height = 0;
    }

    /**
     * key is the data that is stored into the node
     * 
     * @HasGetter
     * @HasSetter
     * @return key stored in the node
     */
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * left is a pointer to the left child of the node
     * 
     * @HasGetter
     * @HasSetter
     * @return left node pointer
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * right is a pointer to the right child of the node
     * 
     * @HasGetter
     * @HasSetter
     * @return right node pointer
     */
    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * parent is a pointer to the parent node of this node
     * 
     * @HasGetter
     * @HasSetter
     * @return parent node pointer
     */
    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    /**
     * height is the height of the node in the tree
     * 
     * @HasGetter
     * @HasSetter
     * @return height of the node
     */
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

/**
 * @param <T> that define the data type
 */
public class AVLTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {
    private int size;
    private TreeNode<T> root;

    /**
     * Constructor of the class BinarySearchTree
     */
    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public boolean IsEmpty() {
        return this.size == 0;
    }

    public void Empty() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Function that find a node in the tree structure, but if it isn't found, it
     * returns the node pointer where it is supposed to be a child
     * 
     * @return pointer of the found node
     */
    public TreeNode<T> Find(T findKey, TreeNode<T> currentNode) {
        if (currentNode.getKey().compareTo(findKey) == 0)
            return currentNode;

        else if (currentNode.getKey().compareTo(findKey) < 0 && currentNode.getRight() != null) {
            return Find(findKey, currentNode.getRight());
        }

        else if (currentNode.getKey().compareTo(findKey) > 0 && currentNode.getLeft() != null) {
            return Find(findKey, currentNode.getLeft());
        }

        else
            return currentNode;
    }

    /**
     * Function to insert a node with the given data
     * 
     * @param value to be stored
     */
    public void Insert(T value) {
        if (this.root == null) {
            this.root = new TreeNode<T>(value);
            this.size++;
            this.root.setHeight(1);
            return;
        }

        TreeNode<T> insertNode = Find(value, this.root);

        if (insertNode.getKey().compareTo(value) == 0)
            return;

        TreeNode<T> newNode = new TreeNode<T>(value, null, null, insertNode);

        if (insertNode.getKey().compareTo(value) < 0)
            insertNode.setRight(newNode);
        else
            insertNode.setLeft(newNode);

        this.size++;

        UpdateHeight(this.root);
        Balance(this.root);
    }

    /**
     * Function that delete a node from the BinarySearchTree
     * 
     * @return key from the deleted node
     */
    public T Delete(TreeNode<T> deleteNode) {
        if (this.root == null)
            return null;

        // Deleting if the deleteNode is a leaf treeNode
        if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {
            if (deleteNode.getParent() != null) {
                if (deleteNode.getKey().compareTo((T) deleteNode.getParent().getKey()) > 0) {
                    deleteNode.getParent().setRight(null);
                } else if (deleteNode.getKey().compareTo((T) deleteNode.getParent().getKey()) < 0) {
                    deleteNode.getParent().setLeft(null);
                }
            } else
                this.root = null;
        }
        // Deleting if deleteNode have only a left treeNode
        else if (deleteNode.getLeft() != null && deleteNode.getRight() == null) {
            if (deleteNode.getParent() != null) {
                if (deleteNode.getKey().compareTo((T) deleteNode.getParent().getKey()) > 0) {
                    deleteNode.getParent().setRight(deleteNode.getLeft());
                } else if (deleteNode.getKey().compareTo((T) deleteNode.getParent().getKey()) < 0) {
                    deleteNode.getParent().setLeft(deleteNode.getLeft());
                }

                deleteNode.getLeft().setParent(deleteNode.getParent());
            }
        }
        // Deleting if deleteNode have only a right treeNode
        else if (deleteNode.getLeft() == null && deleteNode.getRight() != null) {
            if (deleteNode.getParent() != null) {
                if (deleteNode.getKey().compareTo((T) deleteNode.getParent().getKey()) > 0) {
                    deleteNode.getParent().setRight(deleteNode.getRight());
                } else if (deleteNode.getKey().compareTo((T) deleteNode.getParent().getKey()) < 0) {
                    deleteNode.getParent().setLeft(deleteNode.getRight());
                }

                deleteNode.getRight().setParent(deleteNode.getParent());
            }
        }
        // Deleting if deleteNode have left and right treeNode
        else {
            TreeNode<T> changeNode = Next(deleteNode);

            changeNode.setLeft(deleteNode.getLeft());
            changeNode.getLeft().setParent(changeNode);

            if (changeNode.getRight() != null && changeNode.getParent() != deleteNode) {
                TreeNode<T> temporalNode = changeNode.getRight();

                changeNode.setRight(deleteNode.getRight());
                changeNode.getRight().setParent(changeNode);
                changeNode.getRight().setLeft(temporalNode);
            }
            if (deleteNode.getParent() != null)
                changeNode.setParent(deleteNode.getParent());
            else
                this.root = changeNode;
        }

        this.size--;

        UpdateHeight(this.root);
        Balance(this.root);
        return deleteNode.getKey();
    }

    public TreeNode<T> Last(TreeNode<T> currentNode) {
        if (currentNode.getLeft() == null)
            return null;

        currentNode = currentNode.getLeft();
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }

        return currentNode;
    }

    public TreeNode<T> Next(TreeNode<T> currentNode) {
        if (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
            while (currentNode.getLeft() != null) {
                currentNode = currentNode.getLeft();
            }

            return currentNode;
        } else {
            while (currentNode.getParent() != null) {
                if (currentNode.getKey().compareTo(currentNode.getParent().getKey()) > 0) {
                    currentNode = currentNode.getParent();
                } else if (currentNode.getKey().compareTo(currentNode.getParent().getKey()) < 0) {
                    return currentNode.getParent();
                }
            }

            return null;
        }
    }

    /**
     * 
     * @param node
     * @return
     */
    private int Height(TreeNode<T> node) {
        if(node == null)
            return 0;

        return node.getHeight();
    }

    /**
     * 
     * @param first
     * @param second
     * @return
     */
    private int Max (int first, int second){
        if (first > second)
            return first;
        else 
            return second;
    }

    /**
     * 
     * @param updateNode
     */
    private void UpdateHeight(TreeNode<T> updateNode) {
        if (updateNode == null)
            return;

        TreeNode<T> leftNode = updateNode.getLeft();
        TreeNode<T> rightNode = updateNode.getRight();

        UpdateHeight(leftNode);
        UpdateHeight(rightNode);

        updateNode.setHeight(1 + Max(Height(leftNode), Height(rightNode)));
    }

    /**
     * 
     * @param balanceNode
     */
    private void Balance(TreeNode<T> balanceNode) {
        if (balanceNode == null)
            return;

        Balance(balanceNode.getLeft());
        Balance(balanceNode.getRight());

        int balanceFactor = CalculateBalanceFactor(balanceNode);

        if (balanceFactor <= -2 || balanceFactor >= 2)
            ExecuteRotations(balanceNode);
    }
    
    /**
     * 
     * @param node
     * @return
     */
    private int CalculateBalanceFactor(TreeNode<T> node) {
        if (node == null)
            return 0;

        int leftHeight = Height(node.getLeft());
        int rightHeight = Height(node.getRight());

        return leftHeight - rightHeight;
    }

    /**
     * 
     * @param unbalancedNode
     */
    private void ExecuteRotations(TreeNode<T> unbalancedNode) {
        int balanceFactor = CalculateBalanceFactor(unbalancedNode);

        if (balanceFactor >= 2){
            balanceFactor = CalculateBalanceFactor(unbalancedNode.getLeft());

            // Left-Left case
            if (balanceFactor >=1){
                RotateRight(unbalancedNode);
            }
            // Left-Right case
            else{
                RotateLeft(unbalancedNode.getLeft());
                RotateRight(unbalancedNode);
            }
        }
        else{
            balanceFactor = CalculateBalanceFactor(unbalancedNode.getRight());

            //Right-Left
            if (balanceFactor >= 1){
                RotateRight(unbalancedNode.getRight());
                RotateLeft(unbalancedNode);
            }
            //Right-Right
            else{
                RotateLeft(unbalancedNode);
            }
        }
    }

    /**
     * 
     * @param unbalancedNode
     */
    private void RotateLeft(TreeNode<T> unbalancedNode) {

        TreeNode<T> rightNode = unbalancedNode.getRight();
        TreeNode<T> temporalNode = rightNode.getLeft();
        
        rightNode.setLeft(unbalancedNode);
        unbalancedNode.setRight(temporalNode);

        if (unbalancedNode.getParent() != null){
            TreeNode<T> unbalancedParent = unbalancedNode.getParent();

            if (unbalancedParent.getKey().compareTo(unbalancedNode.getKey()) < 0)
                unbalancedParent.setRight(rightNode);
            else
                unbalancedParent.setLeft(rightNode);
        }
        else this.root = rightNode;

        rightNode.setParent(unbalancedNode.getParent());
        unbalancedNode.setParent(rightNode);
        if (temporalNode != null) temporalNode.setParent(unbalancedNode);

        UpdateHeight(this.root);
        
    }

    /**
     * 
     * @param unbalancedNode
     */
    private void RotateRight(TreeNode<T> unbalancedNode) {
        TreeNode<T> leftNode = unbalancedNode.getLeft();
        TreeNode<T> temporalNode = leftNode.getRight();

        leftNode.setRight(unbalancedNode);
        unbalancedNode.setLeft(temporalNode);

        if (unbalancedNode.getParent() != null){
            TreeNode<T> unbalancedParent = unbalancedNode.getParent();

            if (unbalancedParent.getKey().compareTo(unbalancedNode.getKey()) < 0)
                unbalancedParent.setRight(leftNode);
            else
                unbalancedParent.setLeft(leftNode);
        }
        else this.root = leftNode;

        leftNode.setParent(unbalancedNode.getParent());
        unbalancedNode.setParent(leftNode);
        if (temporalNode != null) temporalNode.setParent(unbalancedNode);
        
        UpdateHeight(this.root);
    }

    /**
     * 
     */
    public void PreOrder(TreeNode<T> current, Queue<T> returnQueue) {
        if (current == null)
            return;

        returnQueue.Enqueue(current.getKey());
        PreOrder(current.getLeft(), returnQueue);
        PreOrder(current.getRight(), returnQueue);
    }

    /**
     * 
     */
    public void PosOrder(TreeNode<T> current, Queue<T> returnQueue) {
        if (current == null)
            return;

        PosOrder(current.getLeft(), returnQueue);
        PosOrder(current.getRight(), returnQueue);
        returnQueue.Enqueue(current.getKey());
    }

    /**
     * Function that visit all the nodes in order
     */
    public void InOrder(TreeNode<T> current, Queue<T> returnQueue) {
        if (current == null)
            return;

        InOrder(current.getLeft(), returnQueue);
        returnQueue.Enqueue(current.getKey());
        InOrder(current.getRight(), returnQueue);
    }

    /**
     * Function that visit all the nodes by their depth levels
     */
    public Queue<T> ByLevel(TreeNode<T> current) {
        Queue<TreeNode<T>> queue = new Queue<>();
        Queue<T> returnQueue = new Queue<>();
        TreeNode<T> temporal;

        queue.Enqueue(current);

        while (!queue.IsEmpty()) {
            temporal = queue.Dequeue();

            returnQueue.Enqueue(temporal.getKey());
            if (temporal.getLeft() != null)
                queue.Enqueue(temporal.getLeft());
            if (temporal.getRight() != null)
                queue.Enqueue(temporal.getRight());
        }

        return returnQueue;
    }

    /**
     * Root is the pointer to the start of the BinarySearchTree
     * 
     * @HasGetter
     * @return root node pointer
     */
    public TreeNode<T> getRoot() {
        return this.root;
    }

    /**
     * 
     * 
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 
     * @param current
     * @return
     */
    public T getKey(TreeNode<T> current){
        return current.getKey();
    }

}
