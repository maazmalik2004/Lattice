package Latticenew;

public class virtualcamera {
    int x, y, z; // Position of the virtual camera in the world
    int p, q, r; // Orientation of the virtual camera in the world
    int display[][]; // World projection on camera array

    virtualcamera(int bx, int by) {
        x = 0;
        y = 0;
        z = 50;
        p = 0;
        q = 0;
        r = 0;
        display = new int[bx][by];
    }

    }
