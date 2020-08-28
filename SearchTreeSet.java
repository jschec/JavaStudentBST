/**
 * A binary search tree with nodes containing values of type E
 *
 * @author      Joshua Scheck
 * @version     2020-07-26
 */
public class SearchTreeSet<E extends Comparable<E>> {

    //----------------------------------------------------------------
    //      INSTANCE DATA
    //----------------------------------------------------------------
    /** starting node for this tree */
    private SearchTreeNode<E> overallRoot;

    //----------------------------------------------------------------
    //      CONSTRUCTORS
    //----------------------------------------------------------------
    /**
     * Constructor; Initialized with an empty tree
     */
    public SearchTreeSet() {
        overallRoot = null;
    }

    /**
     * Adds the given value to this Search tree set
     *
     * @param   value                       new node's value
     * @throws  IllegalArgumentException    if value is null
     */
    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Node value cannot be null");
        }
        overallRoot = add(overallRoot, value);
    }

    /**
     * Recursively traverses through Search tree set to identify the
     * location in which to add a new node with the designated value.
     * Nodes are assigned to the left if given value is smaller
     * than current node's data value, right if larger.
     *
     * @param   root    current node
     * @param   value   element value to add
     * @return          the manipulated node
     */
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = add(root.right, value);
        } else if (root.data.compareTo(value) > 0) {
            root.left = add(root.left, value);
        }
        return root;
    }

    /**
     * Retrieves a count of nodes in this Search tree set
     *
     * @return          the number of nodes in this Search tree set
     */
    public int countNodes() {
        return countNodes(overallRoot);
    }

    /**
     * Recursively traverses through Search tree set and
     * counts non-null nodes.
     *
     * @param   root    node in this Search tree set
     * @return          calculated number of nodes
     */
    private int countNodes(SearchTreeNode<E> root) {
        if (root == null) {
            return 0;
        }

        int count = 1;

        count += countNodes(root.right) +
                countNodes(root.left);

        return count;
    }

    /**
     * Determines if the given value is contained in this Search tree set
     *
     * @param   value   sought value
     * @return          true if the given value is contained in this
     *                  Search tree set, false otherwise
     */
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }

    /**
     * Recursively traverses through Search tree set and determines if
     * each of the nodes contain the given value
     *
     * @param   root    node in this Search tree set
     * @param   value   sought value in this Search tree set
     * @return          true if the given value is contained in
     *                  the node, false otherwise
     */
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else if (root.data.compareTo(value) == 0) {
            return true;
        } else if (root.data.compareTo(value) < 0) {
            return contains(root.right, value);
        } else {
            return contains(root.left, value);
        }
    }

    /**
     * Retrieves an in-order or reverse in-order list representation of this
     * Search tree set
     *
     * @param   wantAscending   true for in-order (ascending) list representation,
     *                          false for reverse in-order (descending)
     * @return                  in-order or reverse in-order list representation
     *                          for this Search tree set
     */
    public String getInOrderList(boolean wantAscending) {
        return getInOrderList(overallRoot, wantAscending);
    }

    /**
     * Recursively traverses through this Search tree set in-order or reverse in-order
     * and retrieves String representations of each node
     *
     * @param   root            node in this Search tree set
     * @param   wantAscending   true for in-order (ascending) list representation,
     *                          false for reverse in-order (descending)
     * @return                  String representation of SearchTreeNode(s)
     */
    private String getInOrderList(SearchTreeNode<E> root, boolean wantAscending) {
        if (root == null) {
            return "";
        }

        String result = "";

        if (wantAscending) {
            result += getInOrderList(root.left, wantAscending) +
                    root.data.toString() + "\n" +
                    getInOrderList(root.right, wantAscending);
        } else {
            result += getInOrderList(root.right, wantAscending) +
                    root.data.toString() + "\n" +
                    getInOrderList(root.left, wantAscending);
        }

        return result;
    }

    //----------------------------------------------------------------
    //      INTERNAL CLASSES
    //----------------------------------------------------------------
    /**
     * Nodes composing SearchTree class
     */
    private static class SearchTreeNode<E> {
        /** data stored in this node */
        public E data;
        /** left tree node with a lesser data value than this node */
        public SearchTreeNode<E> left;
        /** right tree node with a greater data value than this node */
        public SearchTreeNode<E> right;

        //----------------------------------------------------------------
        //      CONSTRUCTORS
        //----------------------------------------------------------------
        /**
         * Constructor for SearchTreeNode class; Constructs a node
         * with given data and null links.
         *
         * @param   data    value stored in this node
         */
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        /**
         * Constructor for SearchTreeNode class; Constructs a node
         * with given data and references to left and right links.
         *
         * @param   data    value stored in this node
         * @param   left    reference to left node
         * @param   right   reference to right node
         */
        public SearchTreeNode(E data, SearchTreeNode<E> left, 
        SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}