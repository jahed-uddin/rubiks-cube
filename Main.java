import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		//RubiksCube cube = new RubiksCube();

		RubiksCube cube = new RubiksCube("ggrowobby,brwrryowg,wboyggbwr,yoowobbrg,wgywbgwor,gyoyyrybr");
		cube.displayCube();
		//System.exit(0);

		//cube.moveTopRowRight();
		//cube.moveTopRowLeft();
		//cube.moveLeftColumnUp();
		//cube.moveLeftColumnDown();
		//cube.moveRightColumnUp();
		//cube.moveRightColumnDown();
		//cube.moveBottomRowRight();
		//cube.moveBottomRowLeft();
		//cube.moveFrontFaceCW();		
		//cube.moveFrontFaceAC();
		//cube.moveBackFaceCW();
		//cube.moveBackFaceAC();
		//System.out.println(cube.toString());
				
		// ################### TESTING #################
		
		
		RubiksSolver.solveCube(cube);
		cube.displayCube();	
		System.out.println("Exiting App...");
		System.out.println("===============================================");

		


	}
	

}
