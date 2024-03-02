package Latticenew; 
import java.util.*;
public class vector
{
    double x,y,z;
    //coordinates of a vector
    
    double length;
    //length of a vertex
    
    public vector CreateVector(vertex v1, vertex v2)//creates a vector given two vertices from v1 to v2 returns a vector
    {
        vector v=new vector();
        v.x=v2.x-v1.x;
        v.y=v2.y-v1.y;
        v.z=v2.z-v1.z;
        v.length=Math.sqrt(v.x*v.x+v.y*v.y+v.z*v.z);
        return v;
    }
    
    public vector SetVector(vector v, double x, double y, double z)//sets the value of a given vector returns the vector
    {
        v.x=x;
        v.y=y;
        v.z=z;
        v.length=Math.sqrt(v.x*v.x+v.y*v.y+v.z*v.z);
        return v;
    }
    
    public void PrintVector(vector v)
    {
        System.out.println("[vector description\n coordinates : <"+v.x+","+v.y+","+v.z+">");
        System.out.println(" length      : "+v.length+"]\n");
    }
    
    public vector CrossProduct(vector v1, vector v2)//calculates the cross product of the given two vectors returns a vector
    {
        vector v=new vector();
        v.x=(v1.y*v2.z)-(v1.z*v2.y);
        v.y=-((v1.x*v2.z)-(v1.z*v2.x));
        v.z=(v1.x*v2.y)-(v1.y*v2.x);
        return v;
    }
    
    public double DotProduct(vector v1, vector v2)//calculates the dot product of the given two vectors returns a vector
    {
        double dp=v1.x*v2.x+v1.y*v2.y+v1.z*v2.z;
        return dp;
    }
    
    public double AngleBetweenVectors(vector v1, vector v2)//calculates the angle between two vectors returns the angle in degrees
    {
        double q = Math.acos(DotProduct(v1, v2) / (v1.length*v2.length));
        return (q*180)/3.14159265359;
    }
}
