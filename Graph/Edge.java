package Graph;

public class Edge {

	private Vertex start;
	private Vertex end;
	private String label;
	
	public Edge(Vertex start, Vertex end,String label) {
		this.start=start;
		this.end=end;
		this.label = label;
	}
	
	public void printEdge() {
		System.out.println(label + " = (" + start.getVertex() + ":" + end.getVertex() + ")");
	}
	
	public Vertex[] getEdge() {
		Vertex[] tmp = {start,end};
		return tmp;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Vertex getStart() {
		return start;
	}
	
	public Vertex getEnd() {
		return end;
	}
	
	public static boolean areEqual(Edge a, Edge b) {
		return (a.getStart().equals(b.getStart()) 
				&& a.getEnd().equals(b.getEnd()) 
				&& a.getLabel().contentEquals(b.getLabel()));
	}
	
}
