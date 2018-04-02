import java.util.ArrayList;

////////////////////////////////////////////////////////////////////////////
// Semester:         CS400 Spring 2018
// PROJECT:          cs400_p3_201801
// FILES:            Graph.java
//                   GraphProcessor.java
//                   GraphTest.java
//                   WordProcessor.java
//
// USER:             ateng@wisc.edu
//                   tfiedler2@wisc.edu
//                   cdedrick@wisc.edu
//                   yfang57@wisc.edu
//                   mdespe@wisc.edu
//
// Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
// Bugs:             no known bugs, but not complete either
//
// 2018 Apr 16, 2018 Graph.java 
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Undirected and unweighted graph implementation
 * 
 * @param <E>
 *            type of a vertex
 * 
 * @author sapan (sapan@cs.wisc.edu)
 * 
 */
public class Graph<E> implements GraphADT<E> {
    
    /**
     * Graph constructor
     */
    public Graph() {
        vertices = new ArrayList<E>();
        edges = new ArrayList<ArrayList<Boolean>>();
    }
    
    /**
     * Instance variables and constructors
     */
    private ArrayList<ArrayList<Boolean>> edges; // 2D array for edges
    private ArrayList<E> vertices; // list of valid vertices
    
    /**
     * {@inheritDoc}
     */
    @Override
    public E addVertex(E vertex) {
        if (vertex == null) // If input is null
            return null;
        int i = vertices.indexOf(vertex);
        if (i == -1) { // If DNE
            vertices.add(vertex); // Append to vertices (will always be last index)
            edges.add(new ArrayList<Boolean>()); // New Row
            for (ArrayList<Boolean> startPoint : edges) {
                // Edges will always be a square matrix
                // With length and width equal to vertice's length
                // Each start and end point will also be in order based on inputed vertices
                // So no sorting around
                while (startPoint.size() != vertices.size()) {
                    // Will always only add one
                    // Unless the new point without any connections
                    startPoint.add(false); // Appending Column
                }
            }
            return vertex;
        }
        return null; // Otherwise return null
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public E removeVertex(E vertex) {
        if (vertex == null) // If input is null
            return null;
        int i = vertices.indexOf(vertex);
        if (i == -1) // If DNE
            return null;
        // Otherwise
        edges.remove(i); // Removes vertex row
        // i always correlates with its corresponding vertex
        // because order is not edited
        for (ArrayList<Boolean> edge : edges)
            edge.remove(i); // Removes vertex column
        return vertices.remove(i); // Removes vertex from array of vertices
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addEdge(E vertex1, E vertex2) {
        // Get start and end points
        int startPoint = vertices.indexOf(vertex1);
        int endPoint = vertices.indexOf(vertex2);
        // Check conditions
        if (startPoint == -1 || endPoint == -1 || startPoint == endPoint)
            return false; // If met, return false
        // Return true while setting the points to true
        edges.get(startPoint).set(endPoint, true);
        // Twice cause undirected
        edges.get(endPoint).set(startPoint, true);
        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeEdge(E vertex1, E vertex2) {
        // Get start and end points
        int startPoint = vertices.indexOf(vertex1);
        int endPoint = vertices.indexOf(vertex2);
        // Check conditions
        if (startPoint == -1 || endPoint == -1 || startPoint == endPoint)
            return false; // If met, return false;
        // Return true while setting the point to false
        edges.get(endPoint).set(startPoint, false);
        // Twice cause undirected
        edges.get(startPoint).set(endPoint, false);
        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdjacent(E vertex1, E vertex2) {
        // Get start and end points
        int startPoint = vertices.indexOf(vertex1);
        int endPoint = vertices.indexOf(vertex2);
        // Check conditions
        if (startPoint == -1 || endPoint == -1 || startPoint == endPoint)
            return false; // If met, return false
        // Return edge truth value (only need one)
        return edges.get(startPoint).get(endPoint);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getNeighbors(E vertex) {
        ArrayList<E> neighbors = new ArrayList<E>();
        int i = vertices.indexOf(vertex);
        if (i == -1) // If DNE
            return null;
        // Loop through all vertices to see if they are neighbors
        for (int j = 0; j < vertices.size(); j++) {
            if (i == j) // If same vertex
                continue;
            if (edges.get(i).get(j)) // If they are adjacent
                neighbors.add(vertices.get(j));
        }
        return neighbors; // Return array
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getAllVertices() {
        return vertices;
    }
    
}
