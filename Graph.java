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
     * Instance variables and constructors
     */
    
    /**
     * {@inheritDoc}
     */
    @Override
    public E addVertex(E vertex) {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public E removeVertex(E vertex) {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addEdge(E vertex1, E vertex2) {
        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeEdge(E vertex1, E vertex2) {
        return false;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdjacent(E vertex1, E vertex2) {
        return true;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getNeighbors(E vertex) {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> getAllVertices() {
        return null;
    }
    
}
