
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun anagrams() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine().toMutableList()
    val inputB = scan.nextLine().toMutableList()
    var count = 0
    var inputAIterator = inputA.iterator()
    var inputBIterator = inputB.iterator()
    if(inputA.size > inputB.size) {
        while(inputAIterator.hasNext()) {
            if(inputB.contains(inputAIterator.next())) {
                inputAIterator.remove()
                inputB.remove(inputAIterator.next())
                count++
            }
        }
    } else {
        while (inputBIterator.hasNext()) {
            if(inputA.contains(inputBIterator.next())) {
                inputA.remove(inputBIterator.next())
                inputBIterator.remove()
                count++
            }
        }
    }
    println(inputA.size + inputB.size - 2 * count)
    println("$inputA  $inputB")
}

fun alteringCharacters() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine().toMutableList()
    var inputIterator = inputA.iterator()
    var c = inputIterator.next()
    var count = 0
    while (inputIterator.hasNext()) {
        var next = inputIterator.next()
        if(c.equals(next)) {
          inputIterator.remove()
            count++
        }
        c = next
    }

    println("$count $inputA")

}

fun sherlockVAlidString() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine().toMutableList()
    var map : HashMap<Char, Int> = HashMap()
    for(c in inputA) {
        map.compute(c, { key, v ->
                if (v == null)
                    1
                else
                    v!! + 1
            })

    }
    var count = map.getValue(inputA.get(0))
    var result = "YES"
    for(i in map.values) {
        if(count != i) {
           if(i - count != 1) {
               result = "No"
           }
        }
    }
    print(result)
}

fun specialPalindrom() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine()
    var list :ArrayList<String> = ArrayList()
    for(i in 0..inputA.length) {
        for(j in i..inputA.length) {
            var sub = inputA.substring(i,j)
            if(sub.equals(sub.reversed())) {
                if(!sub.equals("")) {
                    list.add(sub)
                }
            }
        }
    }
    println(list.size)
}

fun commonChild() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine()
    val inputB = scan.nextLine()

    val C = Array(inputA.length + 1) { IntArray(inputB.length + 1) }

    for (i in 0 until inputA.length) {
        for (j in 0 until inputB.length) {
            print(C[i][j])
        }
        print("\n")
    }

    for (i in 0 until inputA.length) {
        for (j in 0 until inputB.length) {
            if (inputA.get(i) === inputB.get(j)) {
                C[i + 1][j + 1] = C[i][j] + 1
            } else {
                C[i + 1][j + 1] = Math.max(C[i + 1][j], C[i][j + 1])
            }
            print(C[i + 1][j + 1])
        }
        print("\n")
    }

     print(C[inputA.length][inputB.length].toString())
}


fun minAbsoluteDiff() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine().split(" ").map { it -> it.toInt() }
    var sum = Math.abs(inputA.get(0) - inputA.get(1))
    Collections.sort(inputA)
    for (i in 1 until inputA.size - 1) {
        var absValue = Math.abs(inputA.get(i) - inputA.get(i + 1))
    //    println("${inputA.get(0)} ${inputA.get(i)} $absValue")
        if(sum > absValue) {
            sum = absValue
        }
    }
    println(sum)
}

fun maxLuck() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine().split(" ").map { it -> it.toInt() }
    var list : ArrayList<List<Int>> = ArrayList()
    var sum = 0;
    for(i in 0 until inputA.get(0)) {
        var input = scan.nextLine().split(" ").map { it -> it.toInt() }
        if(input.get(1) == 1) {
            list.add(input)
        }
        sum += input.get(0)
    }
    println(sum)
    Collections.sort(list, { t1 : List<Int>, t2 : List<Int> -> t1.get(0).compareTo(t2.get(0))})
    if(list.size > inputA.get(1)) {
        for(i in 0 until (list.size - inputA.get(1))){
            sum -= 2 * list.get(i).get(0)
        }
    }
    println(sum)
}

fun findSecondHighestNumber() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine().split(" ").map { it -> it.toInt() }
    var highest = 0
    var secondHighest = 0;
    for(i in inputA) {
        if(i > highest) {
            secondHighest = highest
            highest = i
        }
    }

    println(secondHighest)

}

fun findAllPairWithSum() {
    val scan = Scanner(System.`in`)
    val inputA = scan.nextLine().split(" ").map { it -> it.toInt() }
    val sum = scan.nextLine().toInt()
    var hashSet : HashSet<Int> = HashSet()
    for(i in inputA) {
        var target = sum - i
        if(!hashSet.contains(target)) {
           hashSet.add(i)
        } else {
            println("$i $target")
        }
    }
//    Collections.sort(inputA)
//    var left = 0
//    var right = inputA.size - 1
//    println(inputA)
//    while(left < inputA.size && right > 0) {
//         var value = inputA.get(left) + inputA.get(right)
//        if(value < sum) {
//            left++
//        } else if(value > sum) {
//            right --
//        } else {
//            println("${inputA.get(left)} ${inputA.get(right)} ")
//            left++
//            right--
//        }
//    }

    var list : LinkedList<Int> = LinkedList()
    list.remove()
}


fun printFibonnaciiSeries() {
    val scan = Scanner(System.`in`)
    val num = scan.nextLine().toInt()
    var sum = 0
    for(i in 0..num) {
        
    }

}