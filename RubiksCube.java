import java.util.Arrays;

public class RubiksCube {
	// Side 0 = WHITE
	// Side 1 = RED
	// Side 2 = GREEN
	// Side 3 = ORANGE
	// Side 4 = BLUE
	// Side 5 = YELLOW
	
	private char[][] cubeFaces;

	public RubiksCube (String rubiksConfig) {
		
		this.cubeFaces = new char[6][9];
		
		if (rubiksConfig.length()!=59){
			System.out.println("Incorrect configuration entered...exiting");
			System.exit(0);
		}

		String[] config = rubiksConfig.split(",");
		//System.out.println(Arrays.toString(config));
		//System.out.println(config.length);
		
		
		for (int i=0; i < config.length; i++) {
			for (int j = 0; j < config[i].length(); j++) {
				cubeFaces[i][j] = config[i].charAt(j);
			}
		}	
		
		for (int i=0; i < cubeFaces.length; i++) {
			cubeFaces[i][4] = Character.toUpperCase(cubeFaces[i][4]);			
		}
						
	}
	
	public RubiksCube (char[][] cubeFaces) {
		this.cubeFaces = cubeFaces;
	}

	public RubiksCube() {

		this.cubeFaces = new char[][]{  {'w','w','w','w','W','w','w','w','w'},
			{'r','r','r','r','R','r','r','r','r'},
			{'g','g','g','g','G','g','g','g','g'},
			{'o','o','o','o','O','o','o','o','o'},
			{'b','b','b','b','B','b','b','b','b'},
			{'y','y','y','y','Y','y','y','y','y'}};
	}
	
	public char[][] getCubeFaces() {
		return cubeFaces;
	}

	@Override
	public String toString() {
		String cube = new String();
		for (int i = 0; i < this.cubeFaces.length; i++) {
			cube = cube + Arrays.toString(this.cubeFaces[i]) + "\n";
		}		
	return cube;
	}
	
	public void displayCube() {

		String[] colours = new String[]{"WHITE","RED","GREEN","ORANGE","BLUE","YELLOW"};
		System.out.println("===============================================");
		for (int i = 0; i < this.cubeFaces.length; i++ ) {
			System.out.print(colours[i] + " FACE: \t\t");	
			int faceCounter = 0; 
			
			for (int j = 0; j < cubeFaces[i].length; j++) {
				faceCounter++;
				System.out.print("[" + cubeFaces[i][j] + "]");
				if (faceCounter == 3) {
					faceCounter = 0;
					System.out.print("\n\t\t\t");
				}
			}
			System.out.println();			
		}
		System.out.println("===============================================");
	}
	
	

	private char[] tempSquares(int face,int i1,int i2,int i3){

		char tsq1 = cubeFaces[face][i1];
		char tsq2 = cubeFaces[face][i2];
		char tsq3 = cubeFaces[face][i3];

		return new char[]{tsq1,tsq2,tsq3};
	}

	private void move(int face, int[] adjacencies, char[][] transformMatrix, char[][] transposeMatrix) {
		
		cubeFaces[face][transformMatrix[0][0]] = cubeFaces[adjacencies[2]][transformMatrix[1][0]];
		cubeFaces[face][transformMatrix[0][1]] = cubeFaces[adjacencies[2]][transformMatrix[1][1]];
		cubeFaces[face][transformMatrix[0][2]] = cubeFaces[adjacencies[2]][transformMatrix[1][2]];


		cubeFaces[adjacencies[2]][transformMatrix[1][0]] = cubeFaces[adjacencies[3]][transformMatrix[2][0]];
		cubeFaces[adjacencies[2]][transformMatrix[1][1]] = cubeFaces[adjacencies[3]][transformMatrix[2][1]];
		cubeFaces[adjacencies[2]][transformMatrix[1][2]] = cubeFaces[adjacencies[3]][transformMatrix[2][2]];

		// TOP YELLOW FACE COMES FROM GREEN FACE

		cubeFaces[adjacencies[3]][transformMatrix[2][0]] = cubeFaces[adjacencies[1]][transformMatrix[3][0]];
		cubeFaces[adjacencies[3]][transformMatrix[2][1]] = cubeFaces[adjacencies[1]][transformMatrix[3][1]];
		cubeFaces[adjacencies[3]][transformMatrix[2][2]] = cubeFaces[adjacencies[1]][transformMatrix[3][2]];

		// TOP GREEN FACE COMES FROM ORIGINAL WHITE

		cubeFaces[adjacencies[1]][transformMatrix[3][0]] = transformMatrix[4][0];
		cubeFaces[adjacencies[1]][transformMatrix[3][1]] = transformMatrix[4][1];
		cubeFaces[adjacencies[1]][transformMatrix[3][2]] = transformMatrix[4][2];			

		// RED-FACE SQUARES ARE TRANSPOSED =================
		// STORE RED-FACE TOP ROW
		

		cubeFaces[adjacencies[0]][transposeMatrix[0][0]] = cubeFaces[adjacencies[0]][transposeMatrix[1][0]];
		cubeFaces[adjacencies[0]][transposeMatrix[0][1]] = cubeFaces[adjacencies[0]][transposeMatrix[1][1]];
		cubeFaces[adjacencies[0]][transposeMatrix[0][2]] = cubeFaces[adjacencies[0]][transposeMatrix[1][2]];

		cubeFaces[adjacencies[0]][transposeMatrix[0][3]] = cubeFaces[adjacencies[0]][transposeMatrix[1][3]];
		cubeFaces[adjacencies[0]][transposeMatrix[0][4]] = cubeFaces[adjacencies[0]][transposeMatrix[1][4]];


		cubeFaces[adjacencies[0]][transposeMatrix[0][5]] = transposeMatrix[1][5];
		cubeFaces[adjacencies[0]][transposeMatrix[0][6]] = transposeMatrix[1][6];
		cubeFaces[adjacencies[0]][transposeMatrix[0][7]] = transposeMatrix[1][7];
		
	}

	
	public void moveTopRowLeft() {
		System.out.println("*** Moving Top Row <= Left...");
		char[] tempTransformedSqrs = this.tempSquares(0,0,1,2);
		char[] tempTransposedSqrs = this.tempSquares(1,0,1,2);

		int[] adjacencies = {1,4,2,5};	
		
		char[][] transformMatrix = {{0,1,2},
				{0,1,2},
				{0,1,2},
				{0,1,2},
				tempTransformedSqrs} ;
		
		char[][] transposeMatrix = {{1,3,0,7,6,2,5,8},
				{3,7,6,5,8,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};
		
				
		// TOP-ADJACENT = TA; RIGHT-ADJ = RA; BOTTOM-ADJ = BA; LEFT-ADJ = LA; OPPOSITE = OP;
		// ADJACENCY = {TA, RA, BA, LA, OP}
		
		this.move(0, adjacencies, transformMatrix, transposeMatrix);
		
	}

	
	public void moveTopRowRight() {
		
		System.out.println("*** Moving Top Row => Right...");

		char[] tempTransformedSqrs = this.tempSquares(0,0,1,2);		// STORE COLOURS/VALUES TO OF ONE ROW THAT WILL BE TRANSFORMED 
		char[] tempTransposedSqrs = this.tempSquares(1,0,1,2);	 	// STORE COLOURS/VALUES TO OF ONE ROW THAT WILL BE TRANSPOSED
		
		int[] adjacencies = {1,2,4,5};
		char[][] transformMatrix = {{0,1,2},
									{0,1,2},
									{0,1,2},
									{0,1,2},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;
		
		char[][] transposeMatrix = {{1,2,5,8,7,6,3,0},
									{5,8,7,6,3,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};
					
		this.move(0, adjacencies, transformMatrix, transposeMatrix);
	}

	
	public void moveLeftColumnDown() {
		System.out.println("*** Moving Left Column \\/ Down...");
		char[] tempTransformedSqrs = this.tempSquares(0,0,3,6);
		char[] tempTransposedSqrs = this.tempSquares(4,0,1,2);
		
		int[] adjacencies = {4,3,1,5};
		
		char[][] transformMatrix = {{0,3,6},
									{0,3,6},
									{8,5,2},
									{0,3,6},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;
		
		char[][] transposeMatrix = {{1,3,0,7,6,2,5,8},
				{3,7,6,5,8,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};
		
		this.move(0, adjacencies, transformMatrix, transposeMatrix);		
		
	}
	
	public void moveLeftColumnUp() {
		System.out.println("*** Moving Left Column /\\ Up...");
		char[] tempTransformedSqrs = this.tempSquares(0,0,3,6);
		char[] tempTransposedSqrs = this.tempSquares(4,0,1,2);
						  //{4,3,1,2}
		int[] adjacencies = {4,1,3,5};
		
		char[][] transformMatrix = {{0,3,6},
									{0,3,6},
									{8,5,2},
									{0,3,6},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;
		
		char[][] transposeMatrix = {{1,2,5,8,7,6,3,0},
				{5,8,7,6,3,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};		
		this.move(0, adjacencies, transformMatrix, transposeMatrix);	
	
	}
	
	public void moveRightColumnDown() {
		System.out.println("*** Moving Right Column \\/ Down...");
		char[] tempTransformedSqrs = this.tempSquares(0,2,5,8);
		char[] tempTransposedSqrs = this.tempSquares(2,0,1,2);
		
		int[] adjacencies = {2,3,1,5};
		
		char[][] transformMatrix = {{2,5,8},
									{2,5,8},
									{6,3,0},
									{2,5,8},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;
		
		char[][] transposeMatrix = {{1,2,5,8,7,6,3,0},
				{5,8,7,6,3,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};
		
		this.move(0, adjacencies, transformMatrix, transposeMatrix);		
		
	}	
	
	public void moveRightColumnUp() {
		System.out.println("*** Moving Right Column /\\ Up...");
		char[] tempTransformedSqrs = this.tempSquares(0,2,5,8);
		char[] tempTransposedSqrs = this.tempSquares(2,0,1,2);
						  
		int[] adjacencies = {2,1,3,5};
		
		char[][] transformMatrix = {{2,5,8},
									{2,5,8},
									{6,3,0},
									{2,5,8},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;
		
		char[][] transposeMatrix = {{1,3,0,7,6,2,5,8},
				{3,7,6,5,8,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};
		this.move(0, adjacencies, transformMatrix, transposeMatrix);		
	}
	
	public void moveBottomRowRight() {
		
		System.out.println("*** Moving Bottom Row => Right...");

		char[] tempTransformedSqrs = this.tempSquares(0,6,7,8);		// STORE COLOURS/VALUES TO OF ONE ROW THAT WILL BE TRANSFORMED 
		char[] tempTransposedSqrs = this.tempSquares(3,0,1,2);	 	// STORE COLOURS/VALUES TO OF ONE ROW THAT WILL BE TRANSPOSED
		
		int[] adjacencies = {3,2,4,5};
		char[][] transformMatrix = {{6,7,8},
									{6,7,8},
									{6,7,8},
									{6,7,8},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;
		
		char[][] transposeMatrix = {{1,3,0,7,6,2,5,8},
									{3,7,6,5,8,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};
					
		this.move(0, adjacencies, transformMatrix, transposeMatrix);
	}
	
	public void moveBottomRowLeft() {

		System.out.println("*** Moving Bottom Row <= Left...");
		
		char[] tempTransformedSqrs = this.tempSquares(0,6,7,8);		// STORE COLOURS/VALUES TO OF ONE ROW THAT WILL BE TRANSFORMED 
		char[] tempTransposedSqrs = this.tempSquares(3,0,1,2);	 	// STORE COLOURS/VALUES TO OF ONE ROW THAT WILL BE TRANSPOSED
		
		int[] adjacencies = {3,4,2,5};
		char[][] transformMatrix = {{6,7,8},
									{6,7,8},
									{6,7,8},
									{6,7,8},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;

		char[][] transposeMatrix = {{1,2,5,8,7,6,3,0},
				{5,8,7,6,3,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};

		this.move(0, adjacencies, transformMatrix, transposeMatrix);

	}
	
	public void moveFrontFaceCW() {
		System.out.println("*** Moving Front Face =====>| Clockwise...");
		System.out.println("                            V");
		
		char[] tempTransformedSqrs = this.tempSquares(2,0,3,6);
		char[] tempTransposedSqrs = this.tempSquares(0,0,1,2);
		
		int[] adjacencies = {0,3,1,4};
		char[][] transformMatrix = {{0,3,6},
									{6,7,8},
									{8,5,2},
									{2,1,0},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;

		char[][] transposeMatrix = {{1,3,0,7,6,2,5,8},
				{3,7,6,5,8,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};		
		
		this.move(2, adjacencies, transformMatrix, transposeMatrix);		
	}
	
	public void moveFrontFaceAC() {
		System.out.println("*** Moving Front Face |<==== Anti-Clockwise...");
		System.out.println("                      V");
		
		char[] tempTransformedSqrs = this.tempSquares(2,0,3,6);
		char[] tempTransposedSqrs = this.tempSquares(0,0,1,2);
		
		int[] adjacencies = {0,1,3,4};
		
		char[][] transformMatrix = {{0,3,6},
									{2,1,0},
									{8,5,2},
									{6,7,8},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;

		char[][] transposeMatrix = {{1,2,5,8,7,6,3,0},
				{5,8,7,6,3,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};		
		
		this.move(2, adjacencies, transformMatrix, transposeMatrix);		
	}
	
	public void moveBackFaceCW() {
		System.out.println("*** Moving Back Face =====>| Clockwise...");
		System.out.println("                           V");
		
		char[] tempTransformedSqrs = this.tempSquares(1,0,1,2);
		char[] tempTransposedSqrs = this.tempSquares(5,0,1,2);
		
		int[] adjacencies = {5,2,4,3};
		
		char[][] transformMatrix = {{0,1,2},
									{6,3,0},
									{8,7,6},
									{2,5,8},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;
		
		char[][] transposeMatrix = {{1,2,5,8,7,6,3,0},
				{5,8,7,6,3,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};		
		
		this.move(1, adjacencies, transformMatrix, transposeMatrix);
	}
	
	public void moveBackFaceAC() {
		System.out.println("*** Moving Back Face |<==== Anti-Clockwise...");
		System.out.println("                     V");
		
		char[] tempTransformedSqrs = this.tempSquares(1,0,1,2);
		char[] tempTransposedSqrs = this.tempSquares(5,0,1,2);
		
		int[] adjacencies = {5,4,2,3};
		
		char[][] transformMatrix = {{0,1,2},
									{2,5,8},
									{8,7,6},
									{6,3,0},
									{tempTransformedSqrs[0],tempTransformedSqrs[1],tempTransformedSqrs[2]}} ;
		char[][] transposeMatrix = {{1,3,0,7,6,2,5,8},
				{3,7,6,5,8,tempTransposedSqrs[0],tempTransposedSqrs[1],tempTransposedSqrs[2]}};		

		this.move(1, adjacencies, transformMatrix, transposeMatrix);	
		
	}
		
}




