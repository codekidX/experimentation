import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
    vertexQueue.add(source);

    while (!vertexQueue.isEmpty()) {
        Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
        if (distanceThroughU < v.minDistance) {
            vertexQueue.remove(v);

            v.minDistance = distanceThroughU ;
            v.previous = u;
            vertexQueue.add(v);
        }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices 
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        

        // set the edges and weight
        A.adjacencies = new Edge[]{ new Edge(B, 5), new Edge(D,10) };
        B.adjacencies = new Edge[]{ new Edge(C, 20) };
        C.adjacencies = new Edge[]{ new Edge(D, 2), new Edge(F,10) };
        D.adjacencies = new Edge[]{ new Edge(E, 2) };
        E.adjacencies = new Edge[]{ new Edge(F, 5), new Edge(D, 2) };
        F.adjacencies = new Edge[]{ new Edge(E,5), new Edge(C,10) };


        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + F + ": " + F.minDistance);
        List<Vertex> path = getShortestPathTo(F);
        System.out.println("Path: " + path);
    }
}