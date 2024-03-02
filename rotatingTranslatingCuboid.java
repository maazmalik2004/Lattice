package Latticenew;

public class rotatingTranslatingCuboid {
    public static void main(String[] args) {
        // Run the cuboid test
        runTest();
    }

    public static void runTest() {
        // Create a virtual world
        virtualworld world = new virtualworld(60, 30, 30);

        // Create a cuboid and add it to the world
        object cuboid = new object().CreateCuboid(10.0, 3.0, 3.0);
        world.objects[0] = cuboid;

        // Print initial world description
        world.WorldDescription();

        // Load objects into the world
        world.LoadObjectsToWorld();

        // Print the initial display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the cuboid around the X-axis
        cuboid.RotateObject(cuboid, 45.0, 0.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Translate the cuboid along the X-axis
        cuboid.TranslateObject(cuboid, 5.0, 0.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the cuboid around the Y-axis
        cuboid.RotateObject(cuboid, 0.0, 45.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Translate the cuboid along the Y-axis
        cuboid.TranslateObject(cuboid, 0.0, 5.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the cuboid around the Z-axis
        cuboid.RotateObject(cuboid, 0.0, 0.0, 45.0);

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
