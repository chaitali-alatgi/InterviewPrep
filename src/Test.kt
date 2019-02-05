

data class Node (
        var data : Int = 0,
        var next : Node? = null
)

 public  class CusLinkList {
     var head : Node? = null

     fun insert(value : Int) {
         var node = Node(value, null)

         if(head == null) {
             head = node
         } else {
             var curr = head
             while(curr!!.next != null) {
                 var next = curr.next
                 curr = next
             }
             curr!!.next = node
         }
     }

     fun loopAt( index : Int) {
         var curr = head
         var count = 0
         while (curr!!.next != null && count != index) {
             curr = curr.next
             count++
         }
         curr.next = curr.next!!.next
         print(curr.data)
     }

     fun detectLoop() : Boolean {
         var curr = head
         while (curr!!.next != null) {
             if(curr.next == head)
                 return true
             else
                 curr = curr.next
         }
         return false
     }
 }


//fun main(args : Array<String>) {
//    var linkList = CusLinkList()
//    linkList.insert(1)
//    linkList.insert(2)
//    linkList.insert(3)
//    linkList.insert(4)
//    linkList.insert(5)
//    linkList.head!!.next!!.next = linkList.head
////    var curr = linkList.head
////    while(curr != null) {
////        var node = curr
////        println(node!!.data)
////        curr = node.next
////    }
//
//    print(linkList.detectLoop())
//
//}



