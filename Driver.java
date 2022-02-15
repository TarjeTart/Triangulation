import java.util.ArrayList;

import Graph.*;

public class Driver {
	
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public static int asciiCount = 65;
	public static int asciiCount2 = 97;

	public static void main(String[] args) {
		
		//initialize graph
		Vertex a = new Vertex((char)asciiCount);
		Vertex a1 = new Vertex((char)asciiCount++);
		edges.add(new Edge(a,a1,String.valueOf(((char)asciiCount2))));
		edges.add(new Edge(a1,a,String.valueOf((char)asciiCount2++)));
		
		//remove all connected vertices of same label
		ArrayList<Edge> tmp = connectedVertex();
		while(tmp.size() > 0) {
			for(Edge e : tmp) {
				edges.remove(e);
				Vertex newVertex = new Vertex((char)asciiCount);
				edges.add(new Edge(e.getStart(),newVertex,e.getLabel()));
				edges.add(new Edge(e.getEnd(),newVertex,String.valueOf((char)asciiCount2)));
			}
			asciiCount++;asciiCount2++;
			tmp=connectedVertex();
		}
		
		
		//print result
		printGraph();
		
	}
	
	public static void printGraph() {
		for(Edge e : edges) {
			e.printEdge();
		}
	}
	
	public static ArrayList<Edge> connectedVertex() {
		ArrayList<Edge> toReturn = new ArrayList<Edge>();
		for(Edge e : edges) {
			if(e.getStart().getLabel()==e.getEnd().getLabel())
				toReturn.add(e);
		}
		return toReturn;
	}
	
}
