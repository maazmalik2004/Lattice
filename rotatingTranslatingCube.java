package Latticenew;

public class rotatingTranslatingCube {
    public static void main(String[] args) {
        // Run the cube test
        runTest();
    }

    public static void runTest() {
        // Create a virtual world
        virtualworld world = new virtualworld(20, 20, 20);

        // Create a cube and add it to the world
        object cube = new object().CreateCube(5.0);
        world.objects[0] = cube;

        // Print initial world description
        world.WorldDescription();

        // Load objects into the world
        world.LoadObjectsToWorld();

        // Print the initial display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the cube around the X-axis
        cube.RotateObject(cube, 45.0, 0.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Translate the cube along the X-axis
        cube.TranslateObject(cube, 5.0, 0.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the cube around the Y-axis
        cube.RotateObject(cube, 0.0, 45.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Translate the cube along the Y-axis
        cube.TranslateObject(cube, 0.0, 5.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the cube around the Z-axis
        cube.RotateObject(cube, 0.0, 0.0, 45.0);

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
