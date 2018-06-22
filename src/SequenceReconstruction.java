import java.util.*;

public class SequenceReconstruction {
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        
        for(List<Integer> seq : seqs) {
            if(seq.size() == 1) {
                if(!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0),new HashSet<Integer>());
                    indegree.put(seq.get(0),0);
                }
            } else if(seq.size() > 1) {
                for(int i = 0; i < seq.size()-1; i++) {
                    if(!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i),new HashSet<Integer>());
                        indegree.put(seq.get(i),0);
                    }
                    
                    if(!map.containsKey(seq.get(i+1))) {
                        map.put(seq.get(i+1),new HashSet<Integer>());
                        indegree.put(seq.get(i+1),0);
                    }
                    
                    if(map.get(seq.get(i)).add(seq.get(i+1))) {
                        indegree.put(seq.get(i+1), indegree.get(seq.get(i+1))+1);
                    }
                }
            }
        }
        
        if(map.size() != org.length) return false;
        
        Queue<Integer> qe = new LinkedList<>();
        for(int key : indegree.keySet()) {
            if(indegree.get(key) == 0) {
                qe.offer(key);
            }
        }
        
        int ind = 0;
        while(!qe.isEmpty()) {
            if(qe.size() > 1) return false;
            int num = qe.poll();
            if(ind >= org.length || num != org[ind]) return false;
            else ind++;
            
            Set<Integer> set = map.get(num);
            for(int next : set) {
                indegree.put(next, indegree.get(next)-1);
                if(indegree.get(next) == 0) qe.offer(next);
            }
        }
        
        return ind == org.length;
	}
}
