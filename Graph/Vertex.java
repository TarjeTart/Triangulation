package Graph;

public class Vertex {
	
	private static int[] counts = new int[26];
	private char label;
	private int count;

	public Vertex(char label) {
		this.label = label;
		count = counts[(int)label-65]++;
	}

	public void printVertex() {
		System.out.println(toString());
	}
	
	public String getVertex() {
		return label + Integer.toString(count);
	}
	
	public char getLabel() {
		return label;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean softEquals(Vertex a) {
		return this.label==a.getLabel();
	}
	
	public boolean hardEquals(Vertex a) {
		return (this.label == a.getLabel() 
				&& this.count == a.getCount());
	}

	@Override
	public String toString() {
		return label + Integer.toString(count);
	}
	
}
