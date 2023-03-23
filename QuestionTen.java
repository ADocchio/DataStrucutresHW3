import java.util.*;

/*@author Aden D'Occhio
 * Problem Description:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You
 * are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai
 * ----------------------------------------------------------------------------
 * I solve this problem using dft algorithm that traverses the directional graph to find a valid solution, if it finds a cycle
 * in the graph then we know that the recorder is impossible and thus we can-return an empty array. This time complexity
 * is O(V + E) and our space complexity is O(V)
 * */
public class QuestionTen {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>(numCourses);
        LinkedList<Integer> courseOrder = new LinkedList<>();
        for(int i = 0; i < numCourses;i++){ //load graph with all courses
            graph.put(i, new LinkedList<Integer>());
        }
        for(int[] req : prerequisites){ //load graph with prerequisites
            graph.get(req[0]).add(req[1]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses;i++){
            if(!bfs(graph, i, visited, new HashSet<>(), courseOrder)){
                return new int[]{};
            }
        }
        int[] result = new int[numCourses];
        int i = 0;
        for(int course : courseOrder){
            result[i++] = course;
        }
        return result;
    }

    private static boolean bfs(HashMap<Integer, LinkedList<Integer>> graph , int src, Set<Integer> visited, Set<Integer> cycle, LinkedList<Integer> courseOrder){
        if(cycle.contains(src)){return false;}
        if(visited.contains(src)){return true;}
        if(graph.get(src).isEmpty()){
            courseOrder.add(src); //end of path
            visited.add(src);
            return true;
        }
        cycle.add(src);
        boolean loop = false;
        for(int course : graph.get(src)){
           if(!bfs(graph, course, visited, cycle, courseOrder)){
               loop = true;
           }
        }
        courseOrder.add(src);
        visited.add(src);
        return !loop;
    }
}
