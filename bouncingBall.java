package Latticenew;

public class bouncingBall {
    public static void main(String[] args) {
        // Run the falling and bouncing sphere test
        runFallingBouncingSphere();
    }

    public static void runFallingBouncingSphere() {
        // Create a virtual world
        virtualworld world = new virtualworld(60, 30, 30);

        // Create a sphere and add it to the world
        object sphere = new object().CreateSphere(5.0, 20); // Add resolution parameter
        world.objects[0] = sphere;

        // Print initial world description
        world.WorldDescription();

        // Load objects into the world
        world.LoadObjectsToWorld();

        // Print the initial display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        double gravity = 0.5;
        double velocity = 0.0;

        // Falling and bouncing motion
        while (true) {
            // Update the sphere's Y-coordinate based on falling and bouncing
            double newY = sphere.vertices[0].y + velocity;
            sphere.TranslateObject(sphere, 0.0, newY - sphere.vertices[0].y, 0.0);
            velocity -= gravity;

            // Clear display and load updated objects
            world.ResetDisplay(world.cameras[0]);
            world.ResetVolume();
            world.LoadObjectsToWorld();

            // Print the updated display
            world.PrintDisplay(world.cameras[0]);

            // Delay for 50 milliseconds (simulating a short time step)
            delay(50);

            // Break the loop if the sphere is below the ground level
            if (sphere.vertices[0].y <= 0.0 && velocity < 0) {
                // Reverse the velocity to simulate bouncing
                velocity = -0.8 * velocity;

                // Adjust the sphere's Y-coordinate to be above the ground
                sphere.TranslateObject(sphere, 0.0, -sphere.vertices[0].y, 0.0);
            }
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
