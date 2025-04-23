class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
	if(root == null || root == p || root == q){
        return root;
    }
    
    val left = lowestCommonAncestor(root.left, p, q);
    val right = lowestCommonAncestor(root.right, p, q);
    
    return when{
        left != null && right != null -> root
        left != null -> left
        right != null -> right
        else -> null
    }
}

fun main() {
    val root = TreeNode(3)
    val node5 = TreeNode(5)
    val node1 = TreeNode(1)
    val node6 = TreeNode(6)
    val node2 = TreeNode(2)
    val node0 = TreeNode(0)
    val node8 = TreeNode(8)
    val node7 = TreeNode(7)
    val node4 = TreeNode(4)

    root.left = node5
    root.right = node1
    node5.left = node6
    node5.right = node2
    node2.left = node7
    node2.right = node4
    node1.left = node0
    node1.right = node8

    val p = node5
    val q = node1

    val lca = lowestCommonAncestor(root, p, q)
    println("The lowest common ancestor is: ${lca?.`val`}")
}