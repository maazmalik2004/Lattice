package Latticenew;
import java.util.*;

class face
{
    vertex vertices[];
    //vertex array for a face
    
    vector n;
    //direction/normal vector of a face
    
    int nov; 
    //number of vertices in the face

    public face SetFace(face f, vertex... vertices) 
    {
        f.vertices = Arrays.copyOf(vertices, vertices.length);
        f.nov = vertices.length;

        if (vertices.length >= 3) {
            vector v = new vector();
            f.n = v.CrossProduct(v.CreateVector(vertices[1], vertices[0]), v.CreateVector(vertices[2], vertices[0]));
        }
        return f;
    }


    public void PrintFace(face f)
    {
        System.out.println("[face description");
        for (vertex v : f.vertices) {
            System.out.println(" vertex : (" + v.x + "," + v.y + "," + v.z + ")");
        }
        System.out.println(" direction vector : <" + f.n.x + "," + f.n.y + "," + f.n.z + ">");
        System.out.println(" number of vertices : " + f.nov + "]");
    }

    public static void main(String[] args)
    {
        //nothing
    }
}