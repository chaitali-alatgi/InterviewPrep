import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.abs

//fun main(args: Array<String>) {
 //   sockMerchant()
 //   houseglassProblem()
 //   rotateLeft()
//    minimumBribes()
 //   arrayManupulation()
 //   ransomNote()
//    substringCompare()
//    sherlockAndAnagrams()
 //   bubbleSort()
 //   sort()
 //   insertionSort()
//    comparatorImplementation()
 //   fraudlent()
 //   mergeSort()
 //   anagrams()
 //   alteringCharacters()
 //   sherlockVAlidString()
//    specialPalindrom()
//    commonChild()
//    minAbsoluteDiff()
//    maxLuck()
//    findSecondHighestNumber()
//    findAllPairWithSum()
//}

fun sockMerchant() {
    val scan = Scanner(System.`in`)
    val inputList = scan.nextLine().split(" ").map{ s: String ->  Integer.parseInt(s) }

    var pairs = hashMapOf<Int, Int>()
//    val keys : List<Int> = scan.nextLine().split(" ").map { s: String ->  Integer.parseInt(s)}
    var count = 0
    for(item in inputList) {
        if (pairs.contains(item)) {
            pairs.put(item, pairs.get(item)!!.plus(1))
            if (pairs.get(item)!!.rem(2) == 0) {
                count = count + 1
            }
        } else {
            pairs.put(item, 1)
        }
    }
    println(count)
}


// not working
fun houseglassProblem() {
    val scan = Scanner(System.`in`)
    var inputList: ArrayList<List<Int>> = ArrayList<List<Int>>()
    var i = 0
    var sum = 0
    var preSum = 0
    while(scan.hasNext() && i < 5) {
        var input: List<Int> = scan.nextLine().split(" ").map { it -> it.toInt() }
        inputList.add(i, input)
        i++
    }
    for(i in 1 until inputList.size) {
        for(j in 1 until inputList.get(i).size) {
            if(i < inputList.size - 1  && j < inputList.get(i).size - 1) {
                sum = inputList.get(i - 1).get(j - 1) + inputList.get(i - 1).get(j) + inputList.get(i - 1).get(j + 1)
                    + inputList.get(i).get(j)
                    + inputList.get(i + 1).get(j - 1) + inputList.get(i + 1).get(j) + inputList.get(i + 1).get(j + 1)
                println( "$sum = $(inputList.get(i - 1).get(j - 1) + $inputList.get(i - 1).get(j) + $inputList.get(i - 1).get(j + 1) " +
                        "+ $inputList.get(i).get(j) " +
                        "+ $inputList.get(i + 1).get(j - 1) + $inputList.get(i + 1).get(j) + $inputList.get(i + 1).get(j + 1)")

                if(sum > preSum) {
                    preSum = sum
                }
            }
        }
    }

    println(preSum)
}

fun rotateLeft() {
    val scan = Scanner(System.`in`)
    val shiftVal = scan.nextLine().toInt()
    val inputList = scan.nextLine().split(" ").map{ s: String ->  s.toInt() }
    var newList = ArrayList<Int>()
    for(i in 0 until inputList.size) {
        var new_index = (i + shiftVal) % inputList.size
        newList.add(i, inputList.get(new_index))
    }

    println(newList)
}

fun minimumBribes() {
    val scan = Scanner(System.`in`)
    var inputList: MutableList<Int> = scan.nextLine().split(" ").map { it -> it.toInt() }.toMutableList()
    var attempts = 0
    for(i in 0 until inputList.size - 1) {
        if(inputList.get(i) > inputList.get(i + 1) && (abs(inputList.get(i + 1) - inputList.get(i)) < 3)) {
            var temp = inputList.get(i)
            inputList.set(i, inputList.get(i + 1))
            inputList.set(i + 1, temp)
            attempts++
        } else {
            print("TYoo chaos")
        }
    }

    println(attempts)
    println(inputList)
}

fun arrayManupulation() {
    val scan = Scanner(System.`in`)
    val inputnum = scan.nextLine().toInt()
    val inputs = scan.nextLine().toInt()
    val inputList: ArrayList<List<Int>> = ArrayList(inputs)
    var i = 0
    var maxvalue = 0
    while (scan.hasNext() && i < inputs) {
        inputList.add(i, scan.nextLine().split(" ").map { it -> it.toInt() })
        i++
    }

    var finalArray = ArrayList<Int>(inputnum)
    for (i in 0 until inputnum) {
        finalArray.add(0)
    }

    for (i in 0 until inputList.size) {
        val a = inputList.get(i).get(0) - 1
        val b = inputList.get(i).get(1) - 1
        val num = inputList.get(i).get(2)
        for (j in a..b) {
            if(j < finalArray.size) {
                val sum = finalArray.get(j) + num
                if (maxvalue < sum) {
                    maxvalue = sum
                }
                finalArray.set(j, sum)
            }
        }
    }

    println(finalArray)
    println(maxvalue)
}

fun ransomNote() {
    val scan = Scanner(System.`in`)
    var inputString : MutableList<String> = scan.nextLine().split(" ").toMutableList()
    val ransomString = scan.nextLine().split(" ")
    var replica = true
    for(i in ransomString) {
        if(inputString.contains(i)) {
            inputString.remove(i)
        } else {
            replica = false
            break
        }
    }

    println(replica)

}

fun substringCompare() {
    val scan = Scanner(System.`in`)
    val input = scan.nextLine().split(" ")
    var common = true
    for(i in input.get(0).toCharArray()) {
        if(input.get(1).contains(i)) {
            common = true
            break
        } else {
            common = false
        }
    }

    if(common) {
        println("Yes")
    } else {
        println("No")
    }

}

// not working
fun sherlockAndAnagrams() {
    val scan = Scanner(System.`in`)
    val input = scan.nextLine()
    var count = 0
    for(i in 1 until input.length) {
        var forward = input.substring(0, i)
        if(input.substring(input.length - i, input.length).contains(forward.reversed())) {
            count++
        }
    }
    println(count)
}


fun triplets() {
    val scan = Scanner(System.`in`)
    val input = scan.nextLine().split(" ").map { it -> it.toInt() }
    var combinations : ArrayList<ArrayList<Int>> = ArrayList()
    var str : HashSet<Int> = HashSet()
    for(i in 0 until input.size) {
//        if(input.get(i) == 1) {
//            str.add(input.get(i))
//        } else if(str.last() == input.get(i).p){
//
//        }
    }
}

fun bubbleSort() {
    val scan = Scanner(System.`in`)
    var inputList : MutableList<Int> = scan.nextLine().split(" ").map { s -> s.toInt() }.toMutableList()
    for(i in 0 until inputList.size) {
        for(j in 0 until inputList.size - 1) {
            if(inputList.get(j) > inputList.get(j + 1)) {
                var temp = inputList.get(j)
                inputList.set(j, inputList.get(j + 1))
                inputList.set(j + 1, temp)
                println(inputList)
            }
        }
    }
}

fun sort() {
    val scan = Scanner(System.`in`)
    val max = scan.nextLine().toInt()
    var inputList : MutableList<Int> = scan.nextLine().split(" ").map { s -> s.toInt() }.toMutableList()
    for(i in 0 until inputList.size) {
        for( j in i until inputList.size) {
            if(inputList.get(i) > inputList.get(j)) {
                var temp = inputList.get(i)
                inputList.set(i, inputList.get(j))
                inputList.set(j, temp)
                println(inputList)
            }
        }
    }
    var sum = 0
    var index : ArrayList<Int> = ArrayList()
    for(i in 0 until inputList.size) {
        sum += inputList.get(i)
        index.add(inputList.get(i))
        if(sum > max) {
            index.removeAt(i)
            break
        }
    }

   print(index)

}

fun insertionSort() : List<Int>{
    val scan = Scanner(System.`in`)
    var inputList : MutableList<Int> = scan.nextLine().split(" ").map { s -> s.toInt() }.toMutableList()
    for (i in 1 until inputList.size) {
        var key = inputList.get(i)
        var j = i - 1
        while (j >= 0 && inputList.get(j) > key) {
            inputList.set(j + 1, inputList.get(j))
            j = j - 1
        }
        inputList.set(j + 1, key)
        println(inputList)
    }
    return inputList
}

data class Player(val name: String, val score: Int)

fun comparatorImplementation() {
    val scan = Scanner(System.`in`)
    val inputs = scan.nextLine().toInt()
    var inputList: ArrayList<Player> = ArrayList()
    for(i in 0 until inputs) {
        var input = scan.nextLine().split(" ")
        var player : Player = Player(input.get(0), input.get(1).toInt())
        inputList.add(player)

    }



    println(inputList)
}

fun insertionSort(inputList : ArrayList<Int>) : ArrayList<Int> {
    for(i in 1 until inputList.size) {
        var key = inputList.get(i)
        var j = i - 1
        while(j>= 0 && inputList.get(j) >= key) {
            inputList.set(j + 1, inputList.get(j))
            j = j - 1
        }
        inputList.set(j + 1, key)
    }
    return inputList
}


fun fraudlent() {
    val scan = Scanner(System.`in`)
    val size = scan.nextLine().toInt()
    var inputList : MutableList<Int> = scan.nextLine().split(" ").map { s -> s.toInt() }.toMutableList()
    var median = 0
    var notificationCount = 0
    for(i in 0 until inputList.size) {
        if((i+ size) == inputList.size) {
            break
        }
       var transactionDataList: List<Int> = inputList.subList(i, i + size)
        transactionDataList = insertionSort(ArrayList(transactionDataList))
        var nextTransaction = inputList.get(i+ size)
        if(transactionDataList.size % 2 == 0) {
            median = (transactionDataList.get((inputList.size)/2) + transactionDataList.get(((transactionDataList.size)/2) + 1)) / 2
        } else {
            median = transactionDataList.get((transactionDataList.size)/2)
        }
        if(nextTransaction >= 2 * median) {
            notificationCount++
        }
    }

    println(notificationCount)
}

fun mergeSort() {
    val scan = Scanner(System.`in`)
    val inputList = scan.nextLine().split(" ").map { s -> s.toInt() }.toMutableList()
    merge(inputList, 0, inputList.size - 1)
}

fun merge(list: MutableList<Int>, left : Int, right: Int) {
    if(left < right) {
        var middle = left + (right - left) / 2
        merge(list, left, middle)
        merge(list, middle + 1, right)
        mergeSorting(list, left, middle, right)
    }
}

fun mergeSorting(list: MutableList<Int>, left: Int, middle: Int, right: Int) {
    println("$left $middle $right")
    var i = 0
    var j = 0
    var k = left
    var n1 = middle - left + 1
    var n2 = right - middle

    var leftList : ArrayList<Int> = ArrayList(n1)
    var rightList : ArrayList<Int> = ArrayList(n2)

    for(i in 0 until n1) {
        leftList.add(list.get(left + i))
    }
    for(i in 0 until n2) {
        rightList.add(list.get(middle + i + 1))
    }

    while(i < n1 && j < n2) {
        if(leftList.get(i)<= rightList.get(j)) {
            list.set(k, leftList.get(i))
            i++
        } else {
            list.set(k, rightList.get(j))
            j++
        }
        k++
    }


    while (i < n1) {
        list.set(k, leftList.get(i))
        i++
        k++
    }
    while (j < n2) {
        list.set(k, rightList.get(j))
        j++
        k++
    }

    println(list)
}
