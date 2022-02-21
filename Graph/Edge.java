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
		System.out.println(toString());
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
	
	public boolean vertexEqual(Edge a) {
		return this.start.softEquals(a.getStart()) && this.end.softEquals(a.getEnd());
	}
	
	public static boolean softEqual(Edge a, Edge b) {
		return (a.getStart().softEquals(b.getStart()) 
				&& a.getEnd().softEquals(b.getEnd()) 
				&& a.getLabel().contentEquals(b.getLabel()));
	}
	
	public static boolean hardEqual(Edge a, Edge b) {
		return (a.getStart().hardEquals(b.getStart()) 
				&& a.getEnd().hardEquals(b.getEnd()) 
				&& a.getLabel().contentEquals(b.getLabel()));
	}
	
	@Override
	public String toString() {
		return label + " = (" + start.getVertex() + ":" + end.getVertex() + ")";
	}
	
}
