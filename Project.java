
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Project
{
    private ArrayList<Project> children = new ArrayList<Project>();
    private ArrayList<String, Project> map = new ArrayList<String, Project>();
    private String name;
    private int dependencies = 0;
    
    public Project(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }
    public void addNeighbour(Project node)
    {
        if(!map.containsKey(node))
        {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }
    
    public int incrementDependencies()
    {
        return dependencies++;
        
    }
    
    public ArrayList<Project> getChildren()
    {
        return children;
    }
    public int decrementDependencies()
    {
        return dependencies--;
    }
    public int getDependency()
    {
        return dependencies;
    }
}
   
