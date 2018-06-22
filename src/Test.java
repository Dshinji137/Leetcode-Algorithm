import java.util.*;

public class Test {
	public static void main(String[] args) {
		int[] org = new int[]{4,5,2,6,3};
		List<List<Integer>> seqs = new ArrayList<>();
		List<Integer> seq = new ArrayList<>();
		seq.add(5); seq.add(2); seq.add(6); seq.add(3);
		seqs.add(new ArrayList<>(seq));
		seq = new ArrayList<>();
		seq.add(4); seq.add(1); seq.add(5); seq.add(2);
		seqs.add(new ArrayList<>(seq));
		//seq = new ArrayList<>();
		//seq.add(2); seq.add(3);
		//seqs.add(new ArrayList<>(seq));
		
		boolean ans = new SequenceReconstruction().sequenceReconstruction(org, seqs);
		System.out.println(ans);
	}

}
