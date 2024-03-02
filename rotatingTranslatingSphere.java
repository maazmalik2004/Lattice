package Latticenew;

public class rotatingTranslatingSphere {
    public static void main(String[] args) {
        // Run the sphere test
        runTest();
    }

    public static void runTest() {
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

        // Rotate the sphere around the X-axis
        sphere.RotateObject(sphere, 90.0, 0.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Translate the sphere along the X-axis
        sphere.TranslateObject(sphere, 5.0, 0.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the sphere around the Y-axis
        sphere.RotateObject(sphere, 0.0, 90.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Translate the sphere along the Y-axis
        sphere.TranslateObject(sphere, 0.0, 5.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the sphere around the Z-axis
        sphere.RotateObject(sphere, 45.0, 0.0, 90.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);
    }

    private static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
