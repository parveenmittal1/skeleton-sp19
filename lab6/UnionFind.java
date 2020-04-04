import java.util.ArrayList;

public class UnionFind {
    private ArrayList<Integer> array;

    // TODO - Add instance variables?

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        // TODO
        int i=0;
        while(i<n){
            array.add(-1);
            i++;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) throws Exception {
        if(vertex<array.size()){
            throw new Exception("Invalid Index");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        if(v1<0)
        return -1*v1;
        else return sizeOf(array.get(array.get(v1)));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        if(array.get(v1)<0){
            return array.get(v1);
        }
        return array.get(v1);
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        if(parent(v1)==parent(v2)){
            return true;
        }
        if(parent(v1)<0&&parent(v2)<0){
            return v1==v2;
        }
        else return connected(parent(v1),parent(v2));

    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2){
        // TODO
        if(connected(v1,v2)){
            return;
        }
        int rootV1=find(v1);
        int rootV2=find(v2);
        if(array.get(v1)>array.get(v2)){
            array.set(v2,array.get(v1)+array.get(v2));
            array.set(v1,v2);
        }
        else {
            array.set(v1,array.get(v1)+array.get(v2));
            array.set(v2,v1);
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        ArrayList<Integer> parants=new ArrayList<>();
        return helperFind(parants,vertex);
    }


    public int helperFind(ArrayList<Integer> parants,int vertex){
        if(array.get(vertex)<0){

            for(int i=0;i<parants.size();i++){
                array.set(parants.get(i),vertex);
            }
            return vertex;
        }
        parants.add(vertex);
        return helperFind(parants,parent(vertex));
    }

}
