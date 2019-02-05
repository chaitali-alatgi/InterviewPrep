
data class Root(var value : Int, var left : Root?, var right : Root?)

class BinarySearchTree {
    var root : Root? = null

    fun insert(value : Int) {
        root = getRoot(value, root)
    }

    fun getRoot(value: Int , root: Root?) : Root? {
        if(root == null) {
            return Root(value, null, null)
        } else {
            if(value < root!!.value) {
                root.left = getRoot(value, root.left)
            } else if(value > root!!.value) {
                root.right = getRoot(value, root.right)
            }
            return root
        }
        return null
    }

    fun inOrder() {
        getInOrder(root)
    }

    fun getInOrder(root: Root?) {
        if(root != null) {

            getInOrder(root.left)
            print(root.value)
            getInOrder(root.right)

        }
    }

    fun maxDepth(root: Root?) : Int{

        if(root == null) {
            return 0
        } else {
            var lDepth = maxDepth(root!!.left)
            var rDepth = maxDepth(root!!.right)
            if(lDepth > rDepth) {
                return lDepth + 1
            } else
                return rDepth + 1
        }

    }
}

//fun main(args : Array<String>) {
//    var linkList = BinarySearchTree()
//    linkList.insert(1)
//    linkList.insert(3)
//    linkList.insert(2)
//    linkList.insert(5)
//    linkList.insert(4)
//    linkList.inOrder()
//    println(linkList.maxDepth(linkList.root))
//
//}
