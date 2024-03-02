package Latticenew;

public class PlanetRevolution {
    public static void main(String[] args) {
        // Run the planet revolution simulation
        runPlanetRevolution();
    }

    public static void runPlanetRevolution() {
        // Create a virtual world
        virtualworld world = new virtualworld(60, 30, 30);

        // Create a star (center) and add it to the world
        object star = new object().CreateSphere(5.0, 20); // Adjust radius and resolution for the star
        world.objects[0] = star;

        // Create a planet (sphere) and add it to the world
        object planet = new object().CreateSphere(3.0, 20); // Adjust radius and resolution for the planet
        world.objects[1] = planet;

        // Create a moon (small sphere) and add it to the world
        object moon = new object().CreateSphere(1.0, 10); // Adjust radius and resolution for the moon
        world.objects[2] = moon;

        // Create a space shuttle (cube) and add it to the world
        object spaceShuttle = new object().CreateCube(1.0); // Adjust size of the cube for the shuttle
        world.objects[3] = spaceShuttle;

        // Set initial position of the star (center)
        star.TranslateObject(star, 0.0, 0.0, 0.0);

        // Set initial position of the planet
        planet.TranslateObject(planet, 15.0, 0.0, 0.0);

        // Set initial position of the moon (relative to the planet)
        moon.TranslateObject(moon, 5.0, 0.0, 0.0);

        // Set initial position of the space shuttle (on the planet)
        spaceShuttle.TranslateObject(spaceShuttle, 14.0, 0.0, 0.0);

        // Print initial world description
        world.WorldDescription();

        // Load objects into the world
        world.LoadObjectsToWorld();

        // Print the initial display
        world.PrintDisplay(world.cameras[0]);

        // Delay for a short time for smoother motion
        delay(500);

        // Run the simulation for a certain number of frames
        int numFrames = 1000;

        for (int frame = 0; frame < numFrames; frame++) {
            // Rotate the planet around the star
            rotateObjectAroundAnotherObject(planet, star, 0.0, 1.0, 0.0);

            // Rotate the moon around the planet
            rotateObjectAroundAnotherObject(moon, planet, 0.0, 1.0, 0.0);

            // Simulate gravity effect on the space shuttle
            simulateGravity(spaceShuttle);

            // Clear display and load updated objects
            world.ResetDisplay(world.cameras[0]);
            world.ResetVolume();
            world.LoadObjectsToWorld();

            // Print the updated display
            world.PrintDisplay(world.cameras[0]);

            // Delay for a short time for smoother motion
            delay(50);
        }
    }

    private static void rotateObjectAroundAnotherObject(object o, object center, double axisX, double axisY, double axisZ) {
        // Calculate the relative position of the object to the center
        double relX = o.lx - center.lx;
        double relY = o.ly - center.ly;
        double relZ = o.lz - center.lz;

        // Rotate the relative position
        rotatePointAroundAxis(relX, relY, relZ, axisX, axisY, axisZ);

        // Set the new position of the object
        o.lx = center.lx + relX;
        o.ly = center.ly + relY;
        o.lz = center.lz + relZ;

        // Rotate the object itself
        rotateObjectAroundZAxis(o, 1.0);
    }

    private static void simulateGravity(object o) {
        // Simplified gravity simulation: Move the object towards the moon
        double gravityStrength = 0.1;
        double deltaX = 5.0 - o.lx;  // X-coordinate of the moon
        double deltaY = 0.0 - o.ly;  // Y-coordinate of the moon
        double deltaZ = 0.0 - o.lz;  // Z-coordinate of the moon
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

        // Normalize the gravity vector
        double gravityX = gravityStrength * deltaX / distance;
        double gravityY = gravityStrength * deltaY / distance;
        double gravityZ = gravityStrength * deltaZ / distance;

        // Apply gravity to the object's position
        o.lx += gravityX;
        o.ly += gravityY;
        o.lz += gravityZ;

        // Apply gravity to each vertex of the object
        for (vertex v : o.vertices) {
            v.x += gravityX;
            v.y += gravityY;
            v.z += gravityZ;
        }
    }

    private static void rotatePointAroundAxis(double x, double y, double z, double axisX, double axisY, double axisZ) {
        double radians = Math.toRadians(1.0);
        double cosA = Math.cos(radians);
        double sinA = Math.sin(radians);

        // Normalize the axis vector
        double length = Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);
        axisX /= length;
        axisY /= length;
        axisZ /= length;

        // Compute rotation matrix elements
        double ux = cosA + (1 - cosA) * axisX * axisX;
        double uy = (1 - cosA) * axisX * axisY - sinA * axisZ;
        double uz = (1 - cosA) * axisX * axisZ + sinA * axisY;
        double vx = (1 - cosA) * axisX * axisY + sinA * axisZ;
        double vy = cosA + (1 - cosA) * axisY * axisY;
        double vz = (1 - cosA) * axisY * axisZ - sinA * axisX;
        double wx = (1 - cosA) * axisX * axisZ - sinA * axisY;
        double wy = (1 - cosA) * axisY * axisZ + sinA * axisX;
        double wz = cosA + (1 - cosA) * axisZ * axisZ;

        // Rotate the point using the rotation matrix
        double tempX = ux * x + uy * y + uz * z;
        double tempY = vx * x + vy * y + vz * z;
        double tempZ = wx * x + wy * y + wz * z;

        x = tempX;
        y = tempY;
        z = tempZ;
    }

    private static void rotateObjectAroundZAxis(object o, double angle) {
        double radians = Math.toRadians(angle);
        double cosA = Math.cos(radians);
        double sinA = Math.sin(radians);

        // Rotate each vertex of the object around the z-axis
        for (vertex v : o.vertices) {
            double tempX = cosA * v.x - sinA * v.y;
            double tempY = sinA * v.x + cosA * v.y;
            v.x = tempX;
            v.y = tempY;
        }
    }

    private static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
