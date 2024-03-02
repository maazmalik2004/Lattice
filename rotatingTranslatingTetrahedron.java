package Latticenew;

public class rotatingTranslatingTetrahedron {
    public static void main(String[] args) {
        // Run the tetrahedron test
        runTest();
    }

    public static void runTest() {
        // Create a virtual world
        virtualworld world = new virtualworld(60, 30, 30);

        // Create a tetrahedron and add it to the world
        object tetrahedron = new object().CreateTetrahedron(5.0);
        world.objects[0] = tetrahedron;

        // Print initial world description
        world.WorldDescription();

        // Load objects into the world
        world.LoadObjectsToWorld();

        // Print the initial display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the tetrahedron around the X-axis
        tetrahedron.RotateObject(tetrahedron, 45.0, 0.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Translate the tetrahedron along the X-axis
        tetrahedron.TranslateObject(tetrahedron, 5.0, 0.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the tetrahedron around the Y-axis
        tetrahedron.RotateObject(tetrahedron, 0.0, 45.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Translate the tetrahedron along the Y-axis
        tetrahedron.TranslateObject(tetrahedron, 0.0, 5.0, 0.0);

        // Clear display and load updated objects
        world.ResetDisplay(world.cameras[0]);
        world.ResetVolume();
        world.LoadObjectsToWorld();

        // Print the updated display
        world.PrintDisplay(world.cameras[0]);

        // Delay for 1.5 seconds
        delay(1500);

        // Rotate the tetrahedron around the Z-axis
        tetrahedron.RotateObject(tetrahedron, 0.0, 0.0, 45.0);

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
