package Latticenew; 
import java.util.*;

public class virtualworld
{
    int bx,by,bz;
    //bounds of this world
    
    int ox,oy,oz;
    //origin of this world
    
    object objects[];
    //array of objects in this world
    
    virtualcamera cameras[];
    //array of cameras in this world
    
    int noo;
    //number of objects in this world
    
    int noc;
    //number of cameras in this world
    
    int volume[][][];
    //world array
    
    int menu1,menu2;
    
    int currcam;
    
    public virtualworld(int bx, int by, int bz)//constructor is called before anything else
    {
        this.bx=bx;
        this.by=by;
        this.bz=bz;
        ox=bx/2;
        oy=by/2;
        oz=bz/2;
        noo=0;
        noc=1;//a camera must always exist in the world
        volume=new int[bx][by][bz];
        volume[ox][oy][oz]=3;//display code for origin
        cameras = new virtualcamera[100];
        objects = new object[100];
        cameras[0]=new virtualcamera(bx,by);//setting up a standard camera in this world
    }
    
    public void DelayThread(int mil)
    {
        try
        {
            Thread.sleep(mil);
        }
        catch(InterruptedException e)
        { 
        }
    }
    
    public void WorldDescription()
    {
        System.out.println("[World Description");
        System.out.println(" Bounds: " + bx + "x" + by + "x" + bz);
        System.out.println(" Origin: (" + (ox-(bx/2)) + "," + (oy-(by/2)) + "," + (oz-(bz/2))+")");
        System.out.println(" Number of Objects: " + noo+"");
        System.out.println(" Number of Cameras: " + noc+"]");
    }
    
    public void ResetDisplay(virtualcamera c)//clears the display array from top left to bottom right for the camera in world w
    {
        for(int j=by-1;j>=0;j--)
        {
            for(int i=0;i<bx;i++)
            { 
                c.display[i][j]=0;
            }
        }
    }
    
    public void ResetVolume()
    {
        for(int k=0;k<bz;k++)
        {
            for(int j=0;j<by;j++)
            {
                for(int i=0;i<bx;i++)
                {
                    volume[i][j][k]=0;
                }
            }
        }
    }
    
    public void PrintDisplayCodes(virtualcamera c)
    {
        for(int j=by-1;j>=0;j--)
        {
            for(int i=0;i<bx;i++)
            {
                System.out.print(c.display[i][j]);
            }
            System.out.println();
        }
    }
    
    public void PrintDisplay(virtualcamera c)
    {
        System.out.print("\u000C");//clears terminal, screen refresh
        System.out.println("Lattice running...");
        /* the code section below accounts for the print priority scheme(PPS) so that what is in front is printed and in the back is not, 
        1 being the number code corresponding to the lowest priority wheras the higher numbers corresponding to the higher priorities */
        for(int j=by-1;j>=0;j--)//projection of world on camera
        {
            for(int i=0;i<bx;i++)
            {
                    for(int k=bz-1;k>=0;k--)
                    {
                        if(c.display[i][j]<=0)
                        if(volume[i][j][k]==0)//empty space
                        {
                            c.display[i][j]=0;
                        }
                        
                        if(c.display[i][j]<=1)
                        if(i==ox)//x axis
                        {
                            c.display[i][j]=1;
                        }
                        
                        if(c.display[i][j]<=2)
                        if(j==oy)//y axis
                        {
                            c.display[i][j]=2;
                        }
                        
                        if(c.display[i][j]<=3)
                        if(volume[i][j][k]==3)//origin
                        {
                            c.display[i][j]=3;
                        }
                        
                        if(c.display[i][j]<=4)//vertices and object elements
                        if(volume[i][j][k]==4)
                        {
                            c.display[i][j]=4;
                        }
                        
                    }
            }
        }
        
        for(int j=by-1;j>=0;j--)
        {
            for(int i=0;i<bx;i++)
            { 
                if(c.display[i][j]==0)//empty space
                System.out.print(". "); 
                if(c.display[i][j]==1)//x axis
                System.out.print(", ");
                if(c.display[i][j]==2)//y axis
                System.out.print(", ");
                if(c.display[i][j]==3)// origin
                System.out.print("+ ");
                if(c.display[i][j]==4)//vertices and object elements
                System.out.print("* "); 
                /*if(c.display[i][j]==5)
                System.out.print("& ");
                if(c.display[i][j]==6)
                System.out.print("# ");
                if(c.display[i][j]==7)
                System.out.print("= ");
                if(c.display[i][j]==8)
                System.out.print(": ");
                if(c.display[i][j]==9)
                System.out.print(". ");*/
                //used for brightness values
            }
            System.out.println("");
        }
    }
    
    public void LoadObjectsToWorld() 
    {
    for (object obj : objects) {
        if (obj != null) {
            for (vertex v : obj.vertices) {
                int xIndex = (int) Math.round(v.x) + ox;
                int yIndex = (int) Math.round(v.y) + oy;
                int zIndex = (int) Math.round(v.z) + oz;

                // Check if indices are within bounds
                if (xIndex >= 0 && xIndex < bx && yIndex >= 0 && yIndex < by && zIndex >= 0 && zIndex < bz) {
                    volume[xIndex][yIndex][zIndex] = 4;
                }
            }
        }
    }
    }

    public void main()
    {
        //nothing
    }
}
