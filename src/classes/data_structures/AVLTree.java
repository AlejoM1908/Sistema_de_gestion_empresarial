package classes.data_structures;

interface BinaryTreeInterface<T> {
    public void Insert(T value);

    public T Delete(T key);

    public TreeNode<T> Find(T findKey, TreeNode<T> currentNode);

    public TreeNode<T> Last(TreeNode<T> currentNode);

    public TreeNode<T> Next(TreeNode<T> currentNode);

    public void InOrder(Queue<T> returnQueue);

    public void PreOrder(Queue<T> returnQueue);

    public void PosOrder(Queue<T> returnQueue);

    public Queue<T> ByLevel();
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
     * Constructor of the class AVLTree
     */
    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Function that say if the AVLTree is empty
     * 
     * @return true if AVLTree is empty, false if not
     */
    public boolean IsEmpty() {
        return this.root == null;
    }

    /**
     * Function that empties the AVLTree
     */
    public void Empty() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Funtion that say if a key already exist in the AVLTree or not
     * 
     * @param key to be searched
     * @return true if key already exist in AVLTree, false if not
     */
    public boolean Exists(T key) {
        TreeNode<T> foundedNode = Find(key, this.root);

        return key.compareTo(foundedNode.getKey()) == 0;
    }

    /**
     * Function that find a node in the tree structure, but if it isn't found, it
     * returns the node pointer to another node where it is supposed to be a child
     * 
     * @return pointer of the found node or to where it is supposed to become a
     *         child
     */
    @Override
    public TreeNode<T> Find(T findKey, TreeNode<T> currentNode) {
        if (currentNode == null)
            return null;

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
     * Function to insert a node with the given key into the AVLTree
     * 
     * @param value to be stored in AVLTree
     */
    @Override
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

        this.size += 1;

        UpdateHeight(this.root);
        Balance(this.root);
    }

    /**
     * Function that delete a node from the AVLTree with the given key
     * 
     * @param key to be searched and deleted
     * @return key from the deleted node or null if key isn't found
     */
    @Override
    public T Delete(T key) {
        TreeNode<T> foundedNode = Find(key, this.root);

        if (foundedNode != null && foundedNode.getKey().compareTo(key) == 0)
            return DeleteNode(foundedNode);
        else
            return null;
    }

    /**
     * Function that delete a given TreeNode from the AVLTree
     * 
     * @param deleteNode to be deleted
     * @return key of the deletedNode
     */
    private T DeleteNode(TreeNode<T> deleteNode) {
        // Detecting two cases, node without childs and with one child (right or left)
        if (deleteNode.getLeft() == null || deleteNode.getRight() == null) {
            TreeNode<T> temporal = null;

            if (temporal == deleteNode.getLeft())
                temporal = deleteNode.getRight();
            else
                temporal = deleteNode.getLeft();

            // No childs case
            if (temporal == null) {
                if (deleteNode.getParent() != null) {
                    TreeNode<T> parent = deleteNode.getParent();

                    if (parent.getKey().compareTo(deleteNode.getKey()) <= 0)
                        parent.setRight(null);
                    else
                        parent.setLeft(null);

                    deleteNode.setParent(null);
                } else {
                    Empty();
                    return deleteNode.getKey();
                }
            }
            // One child case
            else {
                TreeNode<T> parent = deleteNode.getParent();

                if (parent != null) {
                    if (parent.getKey().compareTo(deleteNode.getKey()) < 0) {
                        parent.setRight(temporal);
                        temporal.setParent(parent);
                    } else {
                        parent.setLeft(temporal);
                        temporal.setParent(parent);
                    }

                    deleteNode.setParent(null);
                } else {
                    this.root = temporal;
                }
            }
        }
        // node with two childrens
        else {
            TreeNode<T> changeNode = Next(deleteNode);
            T temporal = deleteNode.getKey();

            deleteNode.setKey(changeNode.getKey());
            DeleteNode(changeNode);
            return temporal;
        }

        this.size--;

        UpdateHeight(this.root);
        Balance(this.root);
        return deleteNode.getKey();
    }

    /**
     * Function that returns the last key TreeNode from another TreeNode if it
     * exists in the AVLTree
     * 
     * @param currentNode where we need to find its last TreeNde
     * @return last TreeNode from the given TreeNode or null if it doesn't have a
     *         last TreeNode
     */
    public TreeNode<T> Last(TreeNode<T> currentNode) {
        if (currentNode.getLeft() == null)
            return null;

        currentNode = currentNode.getLeft();
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }

        return currentNode;
    }

    /**
     * Function that returns the next key TreeNode from another TreeNode if it
     * exists in the AVLTree
     * 
     * @param currentNode where we need to find its next TreeNde
     * @return next TreeNode from the given TreeNode or null if it doesn't have a
     *         next TreeNode
     */
    public TreeNode<T> Next(TreeNode<T> currentNode) {
        if (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
            while (currentNode.getLeft() != null) {
                currentNode = currentNode.getLeft();
            }

            return currentNode;
        }

        else {
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
     * Function that returns the height value stored into a given TreeNode
     * 
     * @param node where we want its height value
     * @return the value of the height stored in the given TreeNode
     */
    private int Height(TreeNode<T> node) {
        if (node == null)
            return 0;

        return node.getHeight();
    }

    /**
     * Recursive function that update all the heights from a given TreeNode to all
     * his predecessors
     * 
     * @param updateNode where it start recursivity
     */
    private void UpdateHeight(TreeNode<T> updateNode) {
        if (updateNode == null)
            return;

        TreeNode<T> leftNode = updateNode.getLeft();
        TreeNode<T> rightNode = updateNode.getRight();

        UpdateHeight(leftNode);
        UpdateHeight(rightNode);

        updateNode.setHeight(1 + Math.max(Height(leftNode), Height(rightNode)));
    }

    /**
     * Recursive function that balance the weight of the AVLTree from a given
     * TreeNode to all his predecessors
     * 
     * @param balanceNode where it start recursivity
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
     * Function that calculate the balance factor of a given TreeNode
     * 
     * @param node where the balance factor need's to be calculated
     * @return the balancing factor of the given TreeNode
     */
    private int CalculateBalanceFactor(TreeNode<T> node) {
        if (node == null)
            return 0;

        int leftHeight = Height(node.getLeft());
        int rightHeight = Height(node.getRight());

        return leftHeight - rightHeight;
    }

    /**
     * Function that execute the necessary rotations to the given unbalanced
     * TreeNode
     * 
     * @param unbalancedNode to be rebalanced
     */
    private void ExecuteRotations(TreeNode<T> unbalancedNode) {
        int balanceFactor = CalculateBalanceFactor(unbalancedNode);

        if (balanceFactor >= 2) {
            balanceFactor = CalculateBalanceFactor(unbalancedNode.getLeft());

            // Left-Left case
            if (balanceFactor >= 1) {
                RotateRight(unbalancedNode);
            }
            // Left-Right case
            else {
                RotateLeft(unbalancedNode.getLeft());
                RotateRight(unbalancedNode);
            }
        } else {
            balanceFactor = CalculateBalanceFactor(unbalancedNode.getRight());

            // Right-Left
            if (balanceFactor >= 1) {
                RotateRight(unbalancedNode.getRight());
                RotateLeft(unbalancedNode);
            }
            // Right-Right
            else {
                RotateLeft(unbalancedNode);
            }
        }
    }

    /**
     * Function that rotate a given TreeNode to the left
     * 
     * @param unbalancedNode to be rotated to the left
     */
    private void RotateLeft(TreeNode<T> unbalancedNode) {

        TreeNode<T> rightNode = unbalancedNode.getRight();
        TreeNode<T> temporalNode = rightNode.getLeft();

        rightNode.setLeft(unbalancedNode);
        unbalancedNode.setRight(temporalNode);

        if (unbalancedNode.getParent() != null) {
            TreeNode<T> unbalancedParent = unbalancedNode.getParent();

            if (unbalancedParent.getKey().compareTo(unbalancedNode.getKey()) < 0)
                unbalancedParent.setRight(rightNode);
            else
                unbalancedParent.setLeft(rightNode);
        } else
            this.root = rightNode;

        rightNode.setParent(unbalancedNode.getParent());
        unbalancedNode.setParent(rightNode);
        if (temporalNode != null)
            temporalNode.setParent(unbalancedNode);

        UpdateHeight(this.root);

    }

    /**
     * Function that rotate a given TreeNode to the right
     * 
     * @param unbalancedNode to be rotated to the right
     */
    private void RotateRight(TreeNode<T> unbalancedNode) {
        TreeNode<T> leftNode = unbalancedNode.getLeft();
        TreeNode<T> temporalNode = leftNode.getRight();

        leftNode.setRight(unbalancedNode);
        unbalancedNode.setLeft(temporalNode);

        if (unbalancedNode.getParent() != null) {
            TreeNode<T> unbalancedParent = unbalancedNode.getParent();

            if (unbalancedParent.getKey().compareTo(unbalancedNode.getKey()) < 0)
                unbalancedParent.setRight(leftNode);
            else
                unbalancedParent.setLeft(leftNode);
        } else
            this.root = leftNode;

        leftNode.setParent(unbalancedNode.getParent());
        unbalancedNode.setParent(leftNode);
        if (temporalNode != null)
            temporalNode.setParent(unbalancedNode);

        UpdateHeight(this.root);
    }

    /**
     * Function that stores into a given Queue the PreOrder AVLTree traversal
     * 
     * @param returnQueue where PreOrder traversal is stored
     */
    public void PreOrder(Queue<T> returnQueue) {
        PreOrderNode(this.root, returnQueue);
    }

    /**
     * Function that stores into a given Queue the PreOrder AVLTree traversal
     * 
     * @param current     node where the recursion start
     * @param returnQueue where PreOrder traversal is stored
     */
    private void PreOrderNode(TreeNode<T> current, Queue<T> returnQueue) {
        if (current == null)
            return;

        returnQueue.Enqueue(current.getKey());
        PreOrderNode(current.getLeft(), returnQueue);
        PreOrderNode(current.getRight(), returnQueue);
    }

    /**
     * Recursive function that stores into a given Queue the PosOrder AVLTree
     * traversal
     * 
     * @param returnQueue where PosOrder traversal is stored
     */
    public void PosOrder(Queue<T> returnQueue) {
        PosOrderNode(this.root, returnQueue);
    }

    /**
     * Recursive function that stores into a given Queue the PosOrder AVLTree
     * traversal
     * 
     * @param current     node where the recursion start
     * @param returnQueue where PosOrder traversal is stored
     */
    private void PosOrderNode(TreeNode<T> current, Queue<T> returnQueue) {
        if (current == null)
            return;

        PosOrderNode(current.getLeft(), returnQueue);
        PosOrderNode(current.getRight(), returnQueue);
        returnQueue.Enqueue(current.getKey());
    }

    /**
     * Recursive function that stores into a given Queue the InOrder AVLTree
     * traversal
     * 
     * @param returnQueue where InOrder traversal is stored
     */
    public void InOrder(Queue<T> returnQueue) {
        InOrderNode(this.root, returnQueue);
    }

    /**
     * Recursive function that stores into a given Queue the InOrder AVLTree
     * traversal
     * 
     * @param current     node where the recursion start
     * @param returnQueue where InOrder traversal is stored
     */
    private void InOrderNode(TreeNode<T> current, Queue<T> returnQueue) {
        if (current == null)
            return;

        InOrderNode(current.getLeft(), returnQueue);
        returnQueue.Enqueue(current.getKey());
        InOrderNode(current.getRight(), returnQueue);
    }

    /**
     * Recursive function that stores into a given Queue the ByLevel AVLTree
     * traversal
     * 
     * @return Queue were ByLevel traversal is stored
     */
    public Queue<T> ByLevel(){
        return ByLevelNode(this.root);
    }

    /**
     * Recursive function that stores into a given Queue the ByLevel AVLTree
     * traversal
     * 
     * @param current where the recursivity starts
     * @return Queue were ByLevel traversal is stored
     */
    private Queue<T> ByLevelNode(TreeNode<T> current) {
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
     * Size is the amount of TreeNodes stored in the AVLTree
     * 
     * @return size of the AVLTree
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Key is the value stored in a node
     * 
     * @param current TreeNode where we want to get its value
     * @return key stored in the given TreeNode
     */
    public T getKey(TreeNode<T> current) {
        return current.getKey();
    }

}
