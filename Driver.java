import java.util.ArrayList;

import Graph.*;

public class Driver {
	
	public static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public static int asciiCount = 65;
	public static int asciiCount2 = 97;
	public static int shapeSides = 3;

	public static void main(String[] args) {
		
		//initialize graph
		/*projective plane
		Vertex a = new Vertex((char)asciiCount);
		Vertex a1 = new Vertex((char)asciiCount++);
		edges.add(new Edge(a,a1,String.valueOf(((char)asciiCount2))));
		edges.add(new Edge(a1,a,String.valueOf((char)asciiCount2++)));*/
		
		Vertex a = new Vertex((char)asciiCount);
		Vertex a1 = new Vertex((char)asciiCount);
		Vertex a2 = new Vertex((char)asciiCount);
		Vertex a3 = new Vertex((char)asciiCount++);
		edges.add(new Edge(a,a1,String.valueOf(((char)asciiCount2))));
		edges.add(new Edge(a2,a3,String.valueOf(((char)asciiCount2++))));
		edges.add(new Edge(a1,a2,String.valueOf(((char)asciiCount2))));
		edges.add(new Edge(a,a3,String.valueOf((char)asciiCount2++)));
		
		
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
		
		//check and fix ambiguity
		tmp=ambiguity();
		while(tmp.size() > 0) {
			for(Edge e : tmp) {
				edges.remove(e);
				Vertex newVertex = new Vertex((char)asciiCount);
				edges.add(new Edge(newVertex,e.getStart(),String.valueOf((char)asciiCount2)));
				edges.add(new Edge(newVertex,e.getEnd(),e.getLabel()));
			}
			asciiCount++;asciiCount2++;
			tmp=ambiguity();
		}
		
		//print result
		printGraph();
		
	}
	
	//checks for edge ambiguity
	public static ArrayList<Edge> ambiguity(){
		ArrayList<Edge> toReturn = new ArrayList<Edge>();
		for(int i = 0; i < edges.size(); i++) {
			for(int j = i+1; j < edges.size(); j++) {
				Edge tmp1 = edges.get(i);
				Edge tmp2 = edges.get(j);
				if(tmp1.vertexEqual(tmp2)) {
					//ambiguity
					if(!tmp1.getLabel().equals(tmp2.getLabel())) {
						toReturn.add(tmp2);
						for(int k = j+1; k < edges.size(); k++) {
							if(Edge.softEqual(tmp2, edges.get(k)))
								toReturn.add(edges.get(k));
						}
						return toReturn;
					}
				}
			}
		}
		return toReturn;
	}
	
	//prints a list of the graphs edges
	public static void printGraph() {
		for(Edge e : edges) {
			e.printEdge();
		}
	}
	
	//check for connected vertex
	public static ArrayList<Edge> connectedVertex() {
		ArrayList<Edge> toReturn = new ArrayList<Edge>();
		for(Edge e : edges) {
			if(e.getStart().getLabel()==e.getEnd().getLabel())
				toReturn.add(e);
		}
		return toReturn;
	}
	
}
