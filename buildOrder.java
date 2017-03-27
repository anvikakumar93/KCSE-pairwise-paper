
import java.io.*;
import java.util.ArrayList;

public class buildOrder
{
    public static Graph buildGraph(String[] projects, String [][] dependencies)
    {
        Graph graph = new Graph();
        for(String project: projects)
        {
           createorgetGraph(project);
        }
        for(String dependency: dependencies)
        {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
            
        }
        return graph;
    }
    // adding projects with no dependencies
    public static int addNonDependant(Project[] order, ArrayList<Project>, int offset)
    {
        for(Project project: projects)
        {
            if(project.getDependency() == 0)
            {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
    public static Project[] orderProjects(ArrayList<Project> projects)
    {
        Project order[] = new Project[projects.size()];
        int endofList = addNonDependant(order, projects, 0);
        
        int toProcess = 0;
        while(toProcess < order.length)
        {
            Project current = order[toProcess];
            if(current == null)
            {
                return null;
            }
            ArrayList<Project> children = current.getChildren();
            for(Project child: children)
            {
                child.decrementDependencies();
            }
            endofList = addNonDependant(order, children, endofList);
            toProcess++;
        }
        return order;
    }
    public static String[] converttoString(Project[] projects)
    {
        String[] build = new String[projects.length];
        for(int i = 0; i<projects.length; i++)
        {
            build[i] = projects[i].getName();
        }
        return build;
    }
    public static Project[] findbuildOrder(Project[] projects, String[][] dependencies)
    {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }
    public static Project] buildorderWrapper(Project[] projects, String[][] dependencies)
    {
        Project buildOrder = findbuildOrder(projects, dependencies);
        if(buildOrder == null)
        {
            return null;
        }
        String[] buildOrderString = converttoString(buildOrder);
        return buildOrderString;
    }
}
    
    
