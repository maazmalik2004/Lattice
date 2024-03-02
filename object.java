package Latticenew;
import java.util.*;

class object {
    double lx, ly, lz; // Local origin for the object
    double p,q,r;
    vertex[] vertices; // Array to store vertices of the object
    face[] faces; // Array to store faces of the object
    int nof; // Number of faces in the object
    
    object()
    {
        lx=0;
        ly=0;
        lz=0;
        p=0;
        q=0;
        r=0;
    }
    
    public object CreateCube(double sideLength) {
        // Create instances of vertex and vector
        vertex v = new vertex();
        vector n = new vector();

        // Define half-length of the cube
        double halfLength = sideLength / 2.0;

        // Create vertices for the cube with the center at the origin
        vertex v1 = v.CreateVertex(-halfLength, -halfLength, -halfLength);
        vertex v2 = v.CreateVertex(halfLength, -halfLength, -halfLength);
        vertex v3 = v.CreateVertex(halfLength, halfLength, -halfLength);
        vertex v4 = v.CreateVertex(-halfLength, halfLength, -halfLength);
        vertex v5 = v.CreateVertex(-halfLength, -halfLength, halfLength);
        vertex v6 = v.CreateVertex(halfLength, -halfLength, halfLength);
        vertex v7 = v.CreateVertex(halfLength, halfLength, halfLength);
        vertex v8 = v.CreateVertex(-halfLength, halfLength, halfLength);

        // Create faces for the cube directly without using additional arrays
        face f1 = new face().SetFace(new face(), v1, v2, v3, v4);
        face f2 = new face().SetFace(new face(), v5, v6, v7, v8);
        face f3 = new face().SetFace(new face(), v1, v5, v8, v4);
        face f4 = new face().SetFace(new face(), v2, v6, v7, v3);
        face f5 = new face().SetFace(new face(), v1, v2, v6, v5);
        face f6 = new face().SetFace(new face(), v4, v3, v7, v8);

        // Create an instance of object
        object o = new object();

        // Set the cube faces and vertices in the object
        o.faces = new face[]{f1, f2, f3, f4, f5, f6};
        o.vertices = new vertex[]{v1, v2, v3, v4, v5, v6, v7, v8};
        o.nof = o.faces.length;

        // Set the local origin to the center
        o.lx = 0;
        o.ly = 0;
        o.lz = 0;

        return o;
    }
    
    public object CreateCuboid(double length, double width, double height) {
        // Create instances of vertex and vector
        vertex v = new vertex();
        vector n = new vector();

        // Define half-dimensions of the cuboid
        double halfLength = length / 2.0;
        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;

        // Create vertices for the cuboid with the center at the origin
        vertex v1 = v.CreateVertex(-halfLength, -halfWidth, -halfHeight);
        vertex v2 = v.CreateVertex(halfLength, -halfWidth, -halfHeight);
        vertex v3 = v.CreateVertex(halfLength, halfWidth, -halfHeight);
        vertex v4 = v.CreateVertex(-halfLength, halfWidth, -halfHeight);
        vertex v5 = v.CreateVertex(-halfLength, -halfWidth, halfHeight);
        vertex v6 = v.CreateVertex(halfLength, -halfWidth, halfHeight);
        vertex v7 = v.CreateVertex(halfLength, halfWidth, halfHeight);
        vertex v8 = v.CreateVertex(-halfLength, halfWidth, halfHeight);

        // Create faces for the cuboid
        face f1 = new face().SetFace(new face(), v1, v2, v3, v4);
        face f2 = new face().SetFace(new face(), v5, v6, v7, v8);
        face f3 = new face().SetFace(new face(), v1, v5, v8, v4);
        face f4 = new face().SetFace(new face(), v2, v6, v7, v3);
        face f5 = new face().SetFace(new face(), v1, v2, v6, v5);
        face f6 = new face().SetFace(new face(), v4, v3, v7, v8);

        // Create an instance of object
        object o = new object();

        // Set the cuboid faces and vertices in the object
        o.faces = new face[]{f1, f2, f3, f4, f5, f6};
        o.vertices = new vertex[]{v1, v2, v3, v4, v5, v6, v7, v8};
        o.nof = o.faces.length;

        // Set the local origin to the center
        o.lx = 0;
        o.ly = 0;
        o.lz = 0;

        return o;
    }
    
    public object CreateTetrahedron(double edgeLength) {
        // Create instances of vertex and vector
        vertex v = new vertex();
        vector n = new vector();

        // Define half-length of the tetrahedron's edges
        double halfEdge = edgeLength / 2.0;
        double height = Math.sqrt(2.0 / 3.0) * edgeLength / 2.0;

        // Create vertices for the tetrahedron with the center at the origin
        vertex v1 = v.CreateVertex(0, 0, height);
        vertex v2 = v.CreateVertex(edgeLength, 0, -halfEdge);
        vertex v3 = v.CreateVertex(-halfEdge, edgeLength, -halfEdge);
        vertex v4 = v.CreateVertex(-halfEdge, -halfEdge, -halfEdge);

        // Create faces for the tetrahedron
        face f1 = new face().SetFace(new face(), v1, v2, v3);
        face f2 = new face().SetFace(new face(), v1, v3, v4);
        face f3 = new face().SetFace(new face(), v1, v4, v2);
        face f4 = new face().SetFace(new face(), v2, v4, v3);

        // Create an instance of object
        object o = new object();

        // Set the tetrahedron faces and vertices in the object
        o.faces = new face[]{f1, f2, f3, f4};
        o.vertices = new vertex[]{v1, v2, v3, v4};
        o.nof = o.faces.length;

        // Set the local origin to the center
        o.lx = 0;
        o.ly = 0;
        o.lz = 0;

        return o;
    }
    
     public object CreateSphere(double radius, int resolution) {
        // Create instances of vertex and vector
        vertex v = new vertex();
        vector n = new vector();

        // Initialize arrays to store vertices and faces
        vertex[] sphereVertices = new vertex[resolution * (resolution - 1) + 2];
        face[] sphereFaces = new face[2 * resolution * (resolution - 1)];

        // Create vertices for the sphere
        double phi, theta;
        int vertexIndex = 0;

        for (int i = 0; i < resolution; i++) {
            for (int j = 0; j < resolution - 1; j++) {
                phi = 2 * Math.PI * i / resolution;
                theta = Math.PI * (j + 0.5) / resolution;

                double x = radius * Math.sin(theta) * Math.cos(phi);
                double y = radius * Math.sin(theta) * Math.sin(phi);
                double z = radius * Math.cos(theta);

                sphereVertices[vertexIndex++] = v.CreateVertex(x, y, z);
            }
        }

        // Create the top and bottom vertices
        sphereVertices[vertexIndex++] = v.CreateVertex(0, 0, radius);
        sphereVertices[vertexIndex] = v.CreateVertex(0, 0, -radius);

        // Create faces for the sphere
        int faceIndex = 0;

        // Top cap
        for (int i = 0; i < resolution; i++) {
            sphereFaces[faceIndex++] = new face().SetFace(new face(),
                    sphereVertices[i],
                    sphereVertices[(i + 1) % resolution],
                    sphereVertices[sphereVertices.length - 2]);
        }

        // Middle faces
        for (int i = 0; i < resolution - 2; i++) {
            for (int j = 0; j < resolution - 1; j++) {
                int current = i * (resolution - 1) + j;
                int next = i * (resolution - 1) + (j + 1) % (resolution - 1);
                int above = (i + 1) * (resolution - 1) + j;
                int aboveNext = (i + 1) * (resolution - 1) + (j + 1) % (resolution - 1);

                sphereFaces[faceIndex++] = new face().SetFace(new face(),
                        sphereVertices[current],
                        sphereVertices[next],
                        sphereVertices[above]);
                sphereFaces[faceIndex++] = new face().SetFace(new face(),
                        sphereVertices[next],
                        sphereVertices[aboveNext],
                        sphereVertices[above]);
            }
        }

        // Bottom cap
        int bottomIndex = sphereVertices.length - 1;
        for (int i = 0; i < resolution; i++) {
            sphereFaces[faceIndex++] = new face().SetFace(new face(),
                    sphereVertices[bottomIndex],
                    sphereVertices[(i + 1) % resolution],
                    sphereVertices[i + (resolution - 2) * (resolution - 1)]);
        }

        // Create an instance of object
        object o = new object();

        // Set the sphere faces and vertices in the object
        o.faces = Arrays.copyOf(sphereFaces, sphereFaces.length);
        o.vertices = Arrays.copyOf(sphereVertices, sphereVertices.length);
        o.nof = o.faces.length;

        // Set the local origin to the center
        o.lx = 0;
        o.ly = 0;
        o.lz = 0;

        return o;
    }


    public void PrintObject() {
        System.out.println("[object description");
        System.out.println(" local origin : (" + lx + "," + ly + "," + lz + ")");
        System.out.println(" number of faces : " + nof + "]");
        
        for (face f : faces) {
            System.out.println(" ");
            f.PrintFace(f);
        }
    }
    
    public void TranslateObject(object o, double x, double y, double z) {
        // Translate the local origin
        o.lx += x;
        o.ly += y;
        o.lz += z;

        // Translate each vertex of the object
        for (vertex v : o.vertices) {
            v.x += x;
            v.y += y;
            v.z += z;
        }
    }
    
    public void TranslateOrigin(object o, double x, double y, double z) 
    {
        // Translate the local origin
        o.lx += x;
        o.ly += y;
        o.lz += z;
    }
    
    
    public void RotateObject(object o, double p, double q, double r) {
    // Translate vertices to local origin
    for (vertex v : o.vertices) {
        v.x -= o.lx;
        v.y -= o.ly;
        v.z -= o.lz;
    }

    double cosP = Math.cos(Math.toRadians(p));
    double sinP = Math.sin(Math.toRadians(p));
    double cosQ = Math.cos(Math.toRadians(q));
    double sinQ = Math.sin(Math.toRadians(q));
    double cosR = Math.cos(Math.toRadians(r));
    double sinR = Math.sin(Math.toRadians(r));

    // Rotate each vertex of the object around the x, y, and z axes
    for (vertex v : o.vertices) {
        // Rotate around X-axis
        double tempY = cosP * v.y - sinP * v.z;
        double tempZ = sinP * v.y + cosP * v.z;
        v.y = tempY;
        v.z = tempZ;

        // Rotate around Y-axis
        double tempX = cosQ * v.x + sinQ * v.z;
        tempZ = -sinQ * v.x + cosQ * v.z;
        v.x = tempX;
        v.z = tempZ;

        // Rotate around Z-axis
        double tempX2 = cosR * v.x - sinR * v.y;
        double tempY2 = sinR * v.x + cosR * v.y;
        v.x = tempX2;
        v.y = tempY2;
    }

    // Translate vertices back to original positions
    for (vertex v : o.vertices) {
        v.x += o.lx;
        v.y += o.ly;
        v.z += o.lz;
    }
}


    public static void main(String[] args) 
    {
        //nothing
    }
}
