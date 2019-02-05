
import java.util.*

data class Vertex( var id : String, var name : String)
data class Edge(var id: String, var source : Vertex, var destination: Vertex, var weight : Int)
data class Graph(var vertexs: List<Vertex>, var edges : List<Edge>)

class DijkstraAlgorithm (var graph : Graph){
    var vertexs : ArrayList<Vertex> = ArrayList(graph.vertexs)
    var edges : ArrayList<Edge> = ArrayList(graph.edges)
    lateinit var settledNodes : HashSet<Vertex>
    lateinit var unSettledNodes : HashSet<Vertex>
    lateinit var predessors : HashMap<Vertex, Vertex>
    lateinit var distance : HashMap<Vertex, Int>

    public fun execute(source: Vertex) {
        settledNodes = HashSet()
        unSettledNodes = HashSet()
        predessors = HashMap()
        distance = HashMap()
        distance.put(source, 0)
        unSettledNodes.add(source)
        while (unSettledNodes.size > 0) {
            var vertex : Vertex = getMinimum(unSettledNodes)
            settledNodes.add(vertex)
            unSettledNodes.remove(vertex)
            findMinimumDistance(vertex)
        }
    }

    private fun findMinimumDistance(vertex: Vertex) {
        var adjacentNode : List<Vertex> = getNeighbours(vertex)
        for(target in adjacentNode) {
            if(getShortestDistance(target) > (getShortestDistance(vertex) + getDistanceBetweenNode(vertex, target))) {
                distance.put(target, getShortestDistance(vertex) + getDistanceBetweenNode(target, vertex))
                predessors.put(target, vertex)
                unSettledNodes.add(target)
            }
        }
    }

    private fun getDistanceBetweenNode(vertex: Vertex, target: Vertex): Int {
        for(edge in edges) {
            if(edge.source.equals(vertex) && edge.destination.equals(vertex)) {
                return edge.weight
            }
        }
        return 0
    }

    private fun getNeighbours(vertex: Vertex): List<Vertex> {
        var neighbors : ArrayList<Vertex> = ArrayList()
        for(edge in edges) {
            if(edge.source.equals(vertex) && !isSettled(vertex)) {
                neighbors.add(edge.destination)
            }
        }
        return neighbors
    }

    private fun isSettled(vertex: Vertex): Boolean {
        return settledNodes.contains(vertex)
    }

    private fun getMinimum(unSettledNodes: HashSet<Vertex>): Vertex {
        var minimum : Vertex = Vertex("","")
        for(vertex in unSettledNodes) {
            if(minimum.id === "") {
                minimum = vertex
            } else {
                if(getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex
                }
            }
        }
        return minimum
    }

    private fun getShortestDistance(vertex: Vertex): Int {
        var distance = distance.get(vertex)
        if(distance == null) {
            return Int.MAX_VALUE
        } else {
           return distance
        }
    }

    fun getPath(target: Vertex): LinkedList<Vertex>? {
        val path = LinkedList<Vertex>()
        var step = target
        // check if a path exists
        if (predessors.get(step) == null) {
            return null
        }
        path.add(step)
        while (predessors.get(step) != null) {
            step = predessors.get(step)!!
            path.add(step)
        }
        // Put it into the correct order
        Collections.reverse(path)
        println(path)
        return path
    }
}

//fun main(args : Array<String>) {
//    var vertexs : ArrayList<Vertex> = ArrayList()
//    var edges : ArrayList<Edge> = ArrayList()
//    for (i in 0..10) {
//        val location = Vertex("Node_$i", "Node_$i")
//        vertexs.add(location)
//    }
//
//    addLane(edges, vertexs,"Edge_0", 0, 1, 85)
//    addLane(edges, vertexs,"Edge_1", 0, 2, 217)
//    addLane(edges, vertexs,"Edge_2", 0, 4, 173)
//    addLane(edges, vertexs,"Edge_3", 2, 6, 186)
//    addLane(edges, vertexs,"Edge_4", 2, 7, 103)
//    addLane(edges, vertexs,"Edge_5", 3, 7, 183)
//    addLane(edges, vertexs,"Edge_6", 5, 8, 250)
//    addLane(edges, vertexs,"Edge_7", 8, 9, 84)
//    addLane(edges, vertexs,"Edge_8", 7, 9, 167)
//    addLane(edges, vertexs,"Edge_9", 4, 9, 502)
//    addLane(edges, vertexs,"Edge_10", 9, 10, 40)
//    addLane(edges, vertexs,"Edge_11", 1, 10, 600)
//
//    // Lets check from location Loc_1 to Loc_10
//    val graph = Graph(vertexs, edges)
//    val dijkstra = DijkstraAlgorithm(graph)
//    dijkstra.execute(vertexs.get(0))
//    dijkstra.getPath(vertexs.get(10))
//
//}

fun addLane(edges: ArrayList<Edge>, vertexs: ArrayList<Vertex>, laneId: String, sourceLocNo: Int, destLocNo: Int,
                    duration: Int) {
    val lane = Edge(laneId, vertexs.get(sourceLocNo), vertexs.get(destLocNo), duration)
    edges.add(lane)
}


