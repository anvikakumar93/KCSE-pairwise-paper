
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Graph
{
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private ArrayList<String, Project> map = new ArrayList<String, Project>();
    
    public Project createorgetNode(String name)
    {
        if(!map.containsKey(name))
        {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
    return map.get(name);
    }
    
    public void addEdge(String startEdge, String endName)
    {
        Project start = createorgetNode(startEdge);
        Project end = createorgetNode(endEdge);
        start.addNeighbour(end);
    }
    public ArrayList<Project> getNodes() {
        return nodes;
        
    }
}
