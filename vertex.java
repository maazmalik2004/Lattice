package Latticenew;
import java.util.*;

public class vertex
{
    double x,y,z;
    //position of the vertex
    
    public vertex CreateVertex(double x,double y,double z)//create a vertex given coordinates returns a vertex
    {
        vertex v=new vertex();
        v.x=x;
        v.y=y;
        v.z=z;
        return v;
    }
    
    public vertex SetVertex(vertex v, double x,double y,double z)//sets the value of a vertex returns the vertex
    {
        v.x=x;
        v.y=y;
        v.z=z;
        return v;
    }
    
    public void PrintVertex(vertex v)//prints the description of the vertex
    {
        System.out.println("[vertex desctiption\n coordinates : ("+v.x+","+v.y+","+v.z+")]");
    }
    
    public static void main(String[] args)
    {
        //nothing
    }
}
