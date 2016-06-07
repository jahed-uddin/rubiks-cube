import java.util.Arrays;

class RubiksSolver {

	public static void solveCube(RubiksCube cube) {
		System.out.println("SOLVING CUBE...");
		RubiksSolver.resolveCube(cube);
		System.out.println("===============================================");
		System.out.println("CUBE SOLVED!");
		//cube.displayCube();
	}

	private static boolean compareCorner(char[] arr1, char[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}
	
	private static void solveFirstMiddleSqG(RubiksCube cube) {
		cube.moveTopRowRight();
		cube.moveBackFaceAC();
		cube.moveTopRowLeft();
		cube.moveBackFaceAC();
		cube.moveRightColumnUp();
		cube.moveBackFaceCW();
		cube.moveRightColumnDown();		
	}

	private static void solveFirstMiddleSqR(RubiksCube cube) {
		cube.moveRightColumnUp();
		cube.moveBackFaceCW();
		cube.moveRightColumnDown();	
		cube.moveBackFaceCW();
		cube.moveTopRowRight();
		cube.moveBackFaceAC();
		cube.moveTopRowLeft();
	}

	private static void extractFromPos2735(RubiksCube cube) {
		cube.moveBottomRowRight();
		cube.moveBackFaceCW();
		cube.moveBottomRowLeft();
		cube.moveBackFaceCW();
		cube.moveRightColumnDown();
		cube.moveBackFaceAC();
		cube.moveRightColumnUp();		
	}


	private static void extractFromPos3347(RubiksCube cube) {
		cube.moveLeftColumnDown();
		cube.moveBackFaceCW();
		cube.moveLeftColumnUp();
		cube.moveBackFaceCW();
		cube.moveBottomRowLeft();
		cube.moveBackFaceAC();
		cube.moveBottomRowRight();
	}

	private static void extractFromPos1341(RubiksCube cube) {
		cube.moveLeftColumnUp();
		cube.moveBackFaceAC();
		cube.moveLeftColumnDown();
		cube.moveBackFaceAC();
		cube.moveTopRowLeft();
		cube.moveBackFaceCW();
		cube.moveTopRowRight();
	}

	private static void solveSecondMiddleSqO(RubiksCube cube) {
		cube.moveRightColumnDown();
		cube.moveBackFaceAC();
		cube.moveRightColumnUp();
		cube.moveBackFaceAC();
		cube.moveBottomRowRight();
		cube.moveBackFaceCW();
		cube.moveBottomRowLeft();
	}

	private static void solveSecondMiddleSqG(RubiksCube cube) {
		cube.moveBottomRowRight();
		cube.moveBackFaceCW();
		cube.moveBottomRowLeft();
		cube.moveBackFaceCW();
		cube.moveRightColumnDown();
		cube.moveBackFaceAC();
		cube.moveRightColumnUp();
	}

	private static void solveThirdMiddleSqB(RubiksCube cube) {
		cube.moveBottomRowLeft();
		cube.moveBackFaceAC();
		cube.moveBottomRowRight();
		cube.moveBackFaceAC();
		cube.moveLeftColumnDown();
		cube.moveBackFaceCW();
		cube.moveLeftColumnUp();
	}

	private static void solveThirdMiddleSqO(RubiksCube cube) {
		cube.moveLeftColumnDown();
		cube.moveBackFaceCW();
		cube.moveLeftColumnUp();
		cube.moveBackFaceCW();
		cube.moveBottomRowLeft();
		cube.moveBackFaceAC();
		cube.moveBottomRowRight();

	}

	private static void solveFourthMiddleSqR(RubiksCube cube){
		cube.moveLeftColumnUp();
		cube.moveBackFaceAC();
		cube.moveLeftColumnDown();
		cube.moveBackFaceAC();
		cube.moveTopRowLeft();
		cube.moveBackFaceCW();
		cube.moveTopRowRight();
	}

	private static void solveFourthMiddleSqB(RubiksCube cube){
		cube.moveTopRowLeft();
		cube.moveBackFaceCW();
		cube.moveTopRowRight();
		cube.moveBackFaceCW();
		cube.moveLeftColumnUp();
		cube.moveBackFaceAC();
		cube.moveLeftColumnDown();
	}
	
	private static void solveThirdLevelYellows(RubiksCube cube) {
		cube.moveTopRowLeft();
		cube.moveRightColumnUp();
		cube.moveBackFaceAC();
		cube.moveRightColumnDown();
		cube.moveBackFaceCW();
		cube.moveTopRowRight();	
	}
	
	private static void solveThirdLevelSwapRBAdj(RubiksCube cube) {
		cube.moveBottomRowRight();
		cube.moveBackFaceAC();
		cube.moveBackFaceAC();
		cube.moveBottomRowLeft();
		cube.moveBackFaceCW();
		cube.moveBottomRowRight();
		cube.moveBackFaceCW();
		cube.moveBottomRowLeft();
		cube.moveBackFaceCW();
	}

	
	private static void finalMoveLeft2(RubiksCube cube) {
		cube.moveRightColumnUp();
		cube.moveBackFaceAC();
		cube.moveBackFaceAC();
		cube.moveRightColumnDown();
		cube.moveBackFaceCW();
		cube.moveRightColumnUp();
		cube.moveBackFaceCW();
		cube.moveRightColumnDown();

		cube.moveLeftColumnUp();
		cube.moveBackFaceAC();
		cube.moveBackFaceAC();
		cube.moveLeftColumnDown();
		cube.moveBackFaceAC();
		cube.moveLeftColumnUp();
		cube.moveBackFaceAC();
		cube.moveLeftColumnDown();
	}
	
	private static void finalMoveFront2(RubiksCube cube) {
		
		cube.moveBottomRowRight();
		cube.moveBackFaceAC();
		cube.moveBackFaceAC();
		cube.moveBottomRowLeft();
		cube.moveBackFaceCW();
		cube.moveBottomRowRight();
		cube.moveBackFaceCW();
		cube.moveBottomRowLeft();
		
		cube.moveTopRowRight();
		cube.moveBackFaceAC();
		cube.moveBackFaceAC();
		cube.moveTopRowLeft();
		cube.moveBackFaceAC();
		cube.moveTopRowRight();
		cube.moveBackFaceAC();
		cube.moveTopRowLeft();
	}
	
	private static void finalMoveRight2(RubiksCube cube) {
		cube.moveLeftColumnDown();
		cube.moveBackFaceAC();
		cube.moveBackFaceAC();
		cube.moveLeftColumnUp();
		cube.moveBackFaceCW();
		cube.moveLeftColumnDown();
		cube.moveBackFaceCW();
		cube.moveLeftColumnUp();

		cube.moveRightColumnDown();
		cube.moveBackFaceAC();
		cube.moveBackFaceAC();
		cube.moveRightColumnUp();
		cube.moveBackFaceAC();
		cube.moveRightColumnDown();
		cube.moveBackFaceAC();
		cube.moveRightColumnUp();
	}

	public static void resolveCube(RubiksCube cube) {

		//SOLVING FIRST LEVEL 
		while (Character.toLowerCase(cube.getCubeFaces()[0][1]) != 'w' || Character.toLowerCase(cube.getCubeFaces()[1][7]) != 'r') {
			System.out.println("Solving first square...");

			if (Character.toLowerCase(cube.getCubeFaces()[0][1]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[1][7])=='w')  {
				cube.moveTopRowLeft();
				cube.moveLeftColumnUp();
				cube.moveBackFaceCW();
				cube.moveTopRowLeft();
				cube.moveTopRowLeft();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][1])== 'w' && Character.toLowerCase(cube.getCubeFaces()[1][3])=='r' ) {
				cube.moveTopRowRight();
			} 
			else if (Character.toLowerCase(cube.getCubeFaces()[4][1])== 'r' && Character.toLowerCase(cube.getCubeFaces()[1][3])=='w' ) {
				cube.moveLeftColumnUp();
				cube.moveBackFaceCW();
				cube.moveTopRowLeft();
				cube.moveTopRowLeft();
			} 


			else if (Character.toLowerCase(cube.getCubeFaces()[5][1])== 'w' && Character.toLowerCase(cube.getCubeFaces()[1][1])=='r' ) {
				cube.moveTopRowRight();
				cube.moveTopRowRight();
			} 
			else if (Character.toLowerCase(cube.getCubeFaces()[5][1])== 'r' && Character.toLowerCase(cube.getCubeFaces()[1][1])=='w' ) {
				cube.moveBackFaceAC();
				cube.moveLeftColumnDown();
				cube.moveTopRowRight();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) == 'r' && Character.toLowerCase(cube.getCubeFaces()[2][1])=='w' ) {
				cube.moveTopRowLeft();
			}  
			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[2][1])=='r' ) {
				cube.moveRightColumnUp();
				cube.moveBackFaceAC();
				cube.moveTopRowRight();
				cube.moveTopRowRight();
			}



			else if (Character.toLowerCase(cube.getCubeFaces()[0][3])=='w' && Character.toLowerCase(cube.getCubeFaces()[4][5])=='r') {
				cube.moveFrontFaceCW();	
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[0][3])=='r' && Character.toLowerCase(cube.getCubeFaces()[4][5])=='w') {
				cube.moveLeftColumnUp();
				cube.moveTopRowRight();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[0][5])=='w' && Character.toLowerCase(cube.getCubeFaces()[2][3])=='r') {
				cube.moveFrontFaceAC();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[0][5])=='r' && Character.toLowerCase(cube.getCubeFaces()[2][3])=='w') {
				cube.moveRightColumnUp();
				cube.moveTopRowLeft();	
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][3])=='w' && Character.toLowerCase(cube.getCubeFaces()[5][5])=='r') {
				cube.moveLeftColumnDown();
				cube.moveTopRowRight();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][3])=='r' && Character.toLowerCase(cube.getCubeFaces()[5][5])=='w') {
				cube.moveBackFaceCW();
				cube.moveTopRowLeft();
				cube.moveTopRowLeft();
			}

			/*
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5])=='r' && Character.toLowerCase(cube.getCubeFaces()[5][3])=='w') {
				cube.moveRightColumnUp();
				cube.moveRightColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5])=='w' && Character.toLowerCase(cube.getCubeFaces()[5][3])=='r') {
				cube.moveRightColumnUp();
				cube.moveTopRowLeft();
			}
			*/
			//REPLACEMENT
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5])=='r' && Character.toLowerCase(cube.getCubeFaces()[5][3])=='w') {
				cube.moveBackFaceAC();
				cube.moveTopRowLeft();
				cube.moveTopRowLeft();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5])=='w' && Character.toLowerCase(cube.getCubeFaces()[5][3])=='r') {
				cube.moveRightColumnDown();
				cube.moveTopRowLeft();
			}



			else if (Character.toLowerCase(cube.getCubeFaces()[0][7])=='w' && Character.toLowerCase(cube.getCubeFaces()[3][1])=='r') {
				cube.moveFrontFaceCW();
				cube.moveFrontFaceCW();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[0][7])=='r' && Character.toLowerCase(cube.getCubeFaces()[3][1])=='w') {
				cube.moveBottomRowLeft();
				cube.moveLeftColumnUp();
				cube.moveFrontFaceCW();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][7])=='w' && Character.toLowerCase(cube.getCubeFaces()[3][3])=='r') {
				cube.moveBottomRowRight();
				cube.moveFrontFaceCW();
				cube.moveFrontFaceCW();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][7])=='r' && Character.toLowerCase(cube.getCubeFaces()[3][3])=='w') {
				cube.moveLeftColumnUp();
				cube.moveFrontFaceCW();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][7])=='w' && Character.toLowerCase(cube.getCubeFaces()[3][5])=='r') {
				cube.moveBottomRowLeft();
				cube.moveFrontFaceCW();
				cube.moveFrontFaceCW();				
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][7])=='r' && Character.toLowerCase(cube.getCubeFaces()[3][5])=='w') {
				cube.moveRightColumnUp();
				cube.moveFrontFaceAC();
			}			


			else if (Character.toLowerCase(cube.getCubeFaces()[5][7])=='w' && Character.toLowerCase(cube.getCubeFaces()[3][7])=='r') {
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				cube.moveTopRowRight();
				cube.moveTopRowRight();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[5][7])=='r' && Character.toLowerCase(cube.getCubeFaces()[3][7])=='w') {
				cube.moveBackFaceAC();
				cube.moveRightColumnDown();
				cube.moveTopRowLeft();
			}				
		}
		System.out.println("First Square Resolved");
		System.out.println("Solving Second Square...");	

		while (Character.toLowerCase(cube.getCubeFaces()[0][5]) != 'w' || Character.toLowerCase(cube.getCubeFaces()[2][3]) != 'g') {

			if (Character.toLowerCase(cube.getCubeFaces()[0][5]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[2][3]) == 'w') {

				cube.moveRightColumnDown();
				cube.moveBottomRowRight();
				cube.moveBackFaceAC();
				cube.moveRightColumnUp();
				cube.moveRightColumnUp();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[2][1]) == 'g') {
				cube.moveRightColumnDown();
			}			
			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[2][1]) == 'w') {
				cube.moveRightColumnUp();		
				cube.moveBackFaceCW();
				cube.moveBottomRowLeft();
				cube.moveRightColumnUp();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'g') {
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				cube.moveBottomRowLeft();
				cube.moveRightColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'w') {
				cube.moveBackFaceCW();
				cube.moveRightColumnDown();	
				cube.moveRightColumnDown();					
			}

			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[4][1]) == 'g') {
				cube.moveLeftColumnUp();
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				cube.moveRightColumnUp();
				cube.moveRightColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[4][1]) == 'w') {
				cube.moveLeftColumnUp();
				cube.moveBackFaceAC();
				cube.moveBottomRowLeft();
				cube.moveRightColumnUp();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'w') {
				cube.moveRightColumnDown();
				cube.moveRightColumnDown();
			}

			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'g') {
				cube.moveBackFaceCW();
				cube.moveBottomRowLeft();
				cube.moveRightColumnUp();
			}



			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'w') {
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				cube.moveRightColumnUp();
				cube.moveRightColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'g') {
				cube.moveBackFaceAC();
				cube.moveBottomRowLeft();
				cube.moveRightColumnUp();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[0][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[4][5]) == 'g') {

				cube.moveLeftColumnDown();
				cube.moveBottomRowRight();
				cube.moveBottomRowRight();
				cube.moveRightColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[0][3]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[4][5]) == 'w') {

				cube.moveLeftColumnDown();
				cube.moveBottomRowLeft();
				cube.moveBackFaceAC();
				cube.moveRightColumnUp();	
				cube.moveRightColumnUp();	
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[0][7]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[3][1]) == 'w') {
				cube.moveBottomRowRight();
				cube.moveRightColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[0][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[3][1]) == 'g') {
				cube.moveBottomRowRight();
				cube.moveBottomRowRight();
				cube.moveBackFaceAC();
				cube.moveRightColumnUp();
				cube.moveRightColumnUp();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[3][5]) == 'w') {
				cube.moveRightColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[3][5]) == 'g') {
				cube.moveBottomRowRight();
				cube.moveBackFaceAC();
				cube.moveRightColumnUp();
				cube.moveRightColumnUp();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'g') {
				cube.moveBottomRowLeft();
				cube.moveRightColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'w') {
				cube.moveBackFaceAC();
				cube.moveRightColumnUp();
				cube.moveRightColumnUp();	
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][7]) == 'g' && Character.toLowerCase(cube.getCubeFaces()[3][3]) == 'w') {
				cube.moveBottomRowLeft();
				cube.moveBottomRowLeft();
				cube.moveRightColumnUp();			
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[3][3]) == 'g') {
				cube.moveBottomRowLeft();
				cube.moveBackFaceAC();
				cube.moveRightColumnUp();
				cube.moveRightColumnUp();	
			}
		}

		System.out.println("Second Square Resolved");
		System.out.println("Solving Third Square...");

		while (Character.toLowerCase(cube.getCubeFaces()[0][7]) != 'w' || Character.toLowerCase(cube.getCubeFaces()[3][1]) != 'o') {
			if (Character.toLowerCase(cube.getCubeFaces()[0][7]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[3][1]) == 'w') {
				cube.moveBottomRowLeft();
				cube.moveLeftColumnDown();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				cube.moveBottomRowRight();			
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[2][1]) == 'w') {
				cube.moveTopRowRight();
				cube.moveBackFaceCW();
				cube.moveTopRowLeft();
				cube.moveBackFaceCW();
				cube.moveBottomRowRight();
				cube.moveBottomRowRight();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[2][1]) == 'o') {
				cube.moveTopRowRight();
				cube.moveBackFaceAC();
				cube.moveTopRowLeft();
				cube.moveLeftColumnUp();
				cube.moveBottomRowRight();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'o') {
				cube.moveBackFaceAC();
				cube.moveLeftColumnUp();
				cube.moveBottomRowRight();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'w') {
				cube.moveBackFaceAC();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				cube.moveBottomRowRight();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[4][1]) == 'w') {
				cube.moveLeftColumnDown();
				cube.moveLeftColumnDown();
				cube.moveBottomRowRight();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[4][1]) == 'o') {
				cube.moveLeftColumnUp();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				cube.moveBottomRowRight();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'o') {
				cube.moveBackFaceAC();
				cube.moveBackFaceAC();
				cube.moveLeftColumnUp();
				cube.moveBottomRowRight();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'w') {
				cube.moveBackFaceCW();
				cube.moveBottomRowLeft();
				cube.moveBottomRowLeft();

			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'o') {
				cube.moveLeftColumnUp();
				cube.moveBottomRowRight();		
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'w') {
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();	
				cube.moveBottomRowRight();	
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[3][5]) == 'o') {
				cube.moveBottomRowLeft();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[3][5]) == 'w') {
				cube.moveBottomRowRight();
				cube.moveBackFaceCW();
				cube.moveLeftColumnUp();
				cube.moveBottomRowRight();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'o') {
				cube.moveBottomRowLeft();
				cube.moveBottomRowLeft();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'w') {
				cube.moveBackFaceCW();
				cube.moveLeftColumnUp();
				cube.moveBottomRowRight();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[3][3]) == 'o') {
				cube.moveBottomRowRight();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][7]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[3][3]) == 'w') {
				cube.moveLeftColumnDown();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				cube.moveBottomRowRight();	
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[0][3]) == 'o' && Character.toLowerCase(cube.getCubeFaces()[4][5]) == 'w') {
				cube.moveLeftColumnDown();
				cube.moveBottomRowRight();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[0][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[4][5]) == 'o') {
				cube.moveLeftColumnDown();
				cube.moveFrontFaceCW();
				cube.moveLeftColumnUp();
				cube.moveFrontFaceAC();
			}

		}
		System.out.println("Third Square Resolved");
		System.out.println("Solving Fourth Square...");

		while (Character.toLowerCase(cube.getCubeFaces()[0][3]) != 'w' || Character.toLowerCase(cube.getCubeFaces()[4][5]) != 'b') {
			if (Character.toLowerCase(cube.getCubeFaces()[0][3]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[4][5]) == 'w') {
				cube.moveLeftColumnUp();
				cube.moveFrontFaceCW();
				cube.moveTopRowRight();
				cube.moveFrontFaceAC();
			}

			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[2][1]) == 'w') {
				cube.moveFrontFaceCW();
				cube.moveTopRowLeft();
				cube.moveFrontFaceAC();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[2][1]) == 'b') {
				cube.moveFrontFaceCW();
				cube.moveTopRowRight();
				cube.moveTopRowRight();
				cube.moveFrontFaceAC();
				cube.moveLeftColumnDown();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'w') {
				cube.moveBackFaceAC();
				cube.moveLeftColumnUp();
				cube.moveLeftColumnUp();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'b') {
				cube.moveFrontFaceCW();
				cube.moveTopRowRight();
				cube.moveFrontFaceAC();
				cube.moveLeftColumnDown();
			}	



			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[4][1]) == 'b') {
				cube.moveLeftColumnDown();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[4][1]) == 'w') {
				cube.moveFrontFaceCW();
				cube.moveTopRowRight();
				cube.moveFrontFaceAC();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'w') {
				cube.moveBackFaceAC();
				cube.moveBackFaceAC();
				cube.moveLeftColumnDown();
				cube.moveLeftColumnDown();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'b') {
				cube.moveBackFaceAC();
				cube.moveFrontFaceCW();
				cube.moveTopRowRight();
				cube.moveFrontFaceAC();
				cube.moveLeftColumnDown();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'w') {
				cube.moveLeftColumnDown();
				cube.moveLeftColumnDown();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'b') {
				cube.moveLeftColumnDown();
				cube.moveFrontFaceCW();
				cube.moveTopRowRight();
				cube.moveFrontFaceAC();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[3][5]) == 'w') {
				cube.moveFrontFaceCW();
				cube.moveFrontFaceCW();
				cube.moveRightColumnUp();
				cube.moveFrontFaceCW();
				cube.moveFrontFaceCW();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[3][5]) == 'b') {
				cube.moveFrontFaceAC();
				cube.moveBottomRowLeft();
				cube.moveFrontFaceCW();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'b') {
				cube.moveBackFaceCW();
				cube.moveLeftColumnDown();
				cube.moveLeftColumnDown();
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'w') {
				cube.moveFrontFaceAC();
				cube.moveBottomRowRight();
				cube.moveFrontFaceCW();
				cube.moveLeftColumnUp();
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[3][3]) == 'w' && Character.toLowerCase(cube.getCubeFaces()[4][7]) == 'b') {
				cube.moveLeftColumnUp();				
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[3][3]) == 'b' && Character.toLowerCase(cube.getCubeFaces()[4][7]) == 'w') {
				cube.moveFrontFaceAC();
				cube.moveBottomRowRight();
				cube.moveFrontFaceCW();
			}
		}



		System.out.println("Fourth Square Solved!");
		System.out.println("Solving Corner Pieces...");


		// 1) - START AT THE TOP,FRONT, LEFT CORNER.
		while (	Character.toLowerCase(cube.getCubeFaces()[0][0]) != 'w' || 
				Character.toLowerCase(cube.getCubeFaces()[1][6]) != 'r' ||
				Character.toLowerCase(cube.getCubeFaces()[4][2]) != 'b' ) {

			char[] corner1 = new char[] {'b','r','w'};

			//IF THE SQUARE IS LOCATED IN THE TOP, FRONT, LEFT CORNER
			if (RubiksSolver.compareCorner(corner1, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][0]),
							Character.toLowerCase(cube.getCubeFaces()[1][6]),
							Character.toLowerCase(cube.getCubeFaces()[4][2])})) {

				System.out.println("Found Corner at Pos [0]");
				if (Character.toLowerCase(cube.getCubeFaces()[0][0])== 'r') {
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();	
				} 
				else if (Character.toLowerCase(cube.getCubeFaces()[0][0])== 'b') {
					cube.moveLeftColumnUp();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveTopRowLeft();
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE TOP, FRONT, RIGHT CORNER
			else if (RubiksSolver.compareCorner(corner1, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][2]),
							Character.toLowerCase(cube.getCubeFaces()[1][8]),
							Character.toLowerCase(cube.getCubeFaces()[2][0])})) {

				System.out.println("Found Corner at Pos [1]");
				if (Character.toLowerCase(cube.getCubeFaces()[0][2])=='r') {
					cube.moveTopRowRight();
					cube.moveBackFaceCW();
					cube.moveTopRowLeft();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][2])=='b') {
					cube.moveRightColumnUp();
					cube.moveLeftColumnUp();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveRightColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][2])=='w') {
					cube.moveRightColumnUp();
					cube.moveBackFaceAC();
					cube.moveRightColumnDown();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
				}		
			}


			//IF THE SQUARE IS LOCATED IN THE TOP, BACK, RIGHT CORNER
			else if (RubiksSolver.compareCorner(corner1, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[1][2]),
							Character.toLowerCase(cube.getCubeFaces()[2][2]),
							Character.toLowerCase(cube.getCubeFaces()[5][0])})) {
				System.out.println("Found Corner at Pos [2]");

				if (Character.toLowerCase(cube.getCubeFaces()[1][2]) == 'b') {
					cube.moveLeftColumnUp();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][2]) == 'w') {		
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][2]) == 'r') {
					cube.moveLeftColumnUp();
					cube.moveRightColumnUp();
					cube.moveBackFaceCW();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
					cube.moveRightColumnDown();		
				}		
			}


			//IF THE SQUARE IS LOCATED IN THE TOP, BACK, LEFT CORNER
			else if (RubiksSolver.compareCorner(corner1, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[1][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][0]),
							Character.toLowerCase(cube.getCubeFaces()[5][2])})) {

				if (Character.toLowerCase(cube.getCubeFaces()[1][0]) == 'r') {
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
				} 
				else if (Character.toLowerCase(cube.getCubeFaces()[1][0]) == 'w') {
					cube.moveTopRowLeft();
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][0]) == 'b') {
					cube.moveBackFaceCW();
					cube.moveLeftColumnUp();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveTopRowLeft();
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
				}					
			}


			//IF THE SQUARE IS LOCATED IN THE FRONT, BOTTOM, RIGHT CORNER
			else if (RubiksSolver.compareCorner(corner1, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][8]),
							Character.toLowerCase(cube.getCubeFaces()[2][6]),
							Character.toLowerCase(cube.getCubeFaces()[3][2])})) {
				if (Character.toLowerCase(cube.getCubeFaces()[0][8])== 'r') {	
					cube.moveRightColumnDown();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveRightColumnUp();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][8])== 'w') {
					cube.moveRightColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveRightColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][8])== 'b') {
					cube.moveBottomRowRight();
					cube.moveLeftColumnUp();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveBottomRowLeft();
				}

			}


			//IF THE SQUARE IS LOCATED IN THE BACK, BOTTOM, RIGHT CORNER
			else if (RubiksSolver.compareCorner(corner1, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[2][8]),
							Character.toLowerCase(cube.getCubeFaces()[3][8]),
							Character.toLowerCase(cube.getCubeFaces()[5][6])})) {

				if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'r') {					
					cube.moveLeftColumnUp();
					cube.moveBottomRowRight();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
					cube.moveBottomRowLeft();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'w') {	
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'b') {
					cube.moveLeftColumnUp();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();

				}			
			}


			//IF THE SQUARE IS LOCATED IN THE BACK, BOTTOM, LEFT CORNER
			else if (RubiksSolver.compareCorner(corner1, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[3][6]),
							Character.toLowerCase(cube.getCubeFaces()[4][6]),
							Character.toLowerCase(cube.getCubeFaces()[5][8])})) {

				if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'r') {	
					cube.moveTopRowLeft();
					cube.moveBackFaceCW();
					cube.moveTopRowRight();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'w') {	
					cube.moveBackFaceCW();
					cube.moveTopRowLeft();
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'b') {	
					cube.moveTopRowLeft();
					cube.moveBackFaceCW();
					cube.moveBackFaceCW();
					cube.moveTopRowRight();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE FRONT, BOTTOM, LEFT CORNER
			else if (RubiksSolver.compareCorner(corner1, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][6]),
							Character.toLowerCase(cube.getCubeFaces()[3][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][8])})) {
				if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'r') {
					cube.moveBottomRowLeft();
					cube.moveTopRowLeft();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();
					cube.moveTopRowRight();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'w') {	
					cube.moveBottomRowLeft();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();
					cube.moveTopRowLeft();
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'b') {
					cube.moveBottomRowLeft();
					cube.moveTopRowLeft();
					cube.moveBackFaceCW();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();
					cube.moveTopRowRight();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
				}
			}						
		}

		System.out.println("First Corner Solved");
		System.out.println("Resolving Second Corner...");

		// 2) - NEXT RESOLVE TOP,FRONT, RIGHT CORNER.
		while (	Character.toLowerCase(cube.getCubeFaces()[0][2]) != 'w' || 
				Character.toLowerCase(cube.getCubeFaces()[1][8]) != 'r' ||
				Character.toLowerCase(cube.getCubeFaces()[2][0]) != 'g' ) {

			char[] corner2 = new char[] {'g','r','w'};


			//SQUARE WILL NEVER BE IN THE TOP, FRONT, LEFT CORNER - Pos [0]

			//IF THE SQUARE IS LOCATED IN THE TOP, FRONT, RIGHT CORNER
			if (RubiksSolver.compareCorner(corner2  , new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][2]),
							Character.toLowerCase(cube.getCubeFaces()[1][8]),
							Character.toLowerCase(cube.getCubeFaces()[2][0])})) {
				System.out.println("Found 2nd Corner at Pos [1]");

				if (Character.toLowerCase(cube.getCubeFaces()[0][2])== 'g') {
					cube.moveTopRowRight();
					cube.moveBackFaceCW();
					cube.moveTopRowLeft();
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
					cube.moveBackFaceCW();
					cube.moveTopRowLeft();

				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][2])== 'r') {
					cube.moveTopRowRight();
					cube.moveBackFaceAC();
					cube.moveTopRowLeft();
					cube.moveRightColumnUp();
					cube.moveBackFaceAC();
					cube.moveRightColumnDown();

				}
			}


			//IF THE SQUARE IS LOCATED IN THE TOP, BACK, RIGHT CORNER
			else if (RubiksSolver.compareCorner(corner2  , new char[]
					{Character.toLowerCase(cube.getCubeFaces()[1][2]),
							Character.toLowerCase(cube.getCubeFaces()[2][2]),
							Character.toLowerCase(cube.getCubeFaces()[5][0])})) {
				System.out.println("Found 2nd Corner at Pos [2]");

				if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'g') {
					cube.moveBackFaceCW();
					cube.moveTopRowRight();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveTopRowLeft();
					cube.moveRightColumnUp();
					cube.moveBackFaceAC();
					cube.moveRightColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'r') {
					cube.moveBackFaceCW();
					cube.moveTopRowRight();
					cube.moveBackFaceAC();
					cube.moveTopRowLeft();
				} 
				else if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'w') {
					cube.moveTopRowRight();
					cube.moveBackFaceCW();
					cube.moveTopRowLeft();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE TOP, BACK, LEFT CORNER -POS[3]
			else if (RubiksSolver.compareCorner(corner2, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[1][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][0]),
							Character.toLowerCase(cube.getCubeFaces()[5][2])}))  {
				System.out.println("Found 2nd Corner at Pos [3]");

				if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'g') {
					cube.moveBackFaceCW();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'r') {
					cube.moveBackFaceCW();
				} 
				else if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'w') {
					cube.moveBackFaceCW();
					// Pos [2] will handlee
				}
			}


			//IF THE SQUARE IS LOCATED IN THE BOTTOM, FRONT, LEFT CORNER - POS [4]
			else if (RubiksSolver.compareCorner(corner2, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][6]),
							Character.toLowerCase(cube.getCubeFaces()[3][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][8])}))  {
				System.out.println("Found 2nd Corner at Pos [4]");

				if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'g') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();

				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'r') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
					cube.moveBackFaceAC();
					cube.moveTopRowLeft();

				} 
				else if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'w') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();
					cube.moveBackFaceCW();
					cube.moveRightColumnUp();
					cube.moveBackFaceAC();
					cube.moveRightColumnDown();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE BOTTOM, FRONT, LEFT CORNER - POS [5]
			else if (RubiksSolver.compareCorner(corner2, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][8]),
							Character.toLowerCase(cube.getCubeFaces()[2][6]),
							Character.toLowerCase(cube.getCubeFaces()[3][2])}))  {
				System.out.println("Found 2nd Corner at Pos [5]");

				if (Character.toLowerCase(cube.getCubeFaces()[0][8])== 'g') {
					cube.moveBottomRowRight();
					cube.moveBackFaceCW();
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
					cube.moveBackFaceCW();
					cube.moveTopRowLeft();					
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][8])== 'r') {
					cube.moveBottomRowRight();
					cube.moveTopRowRight();					
					cube.moveBackFaceAC();
					cube.moveTopRowLeft();
					cube.moveBottomRowLeft();					
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][8])== 'w') {
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveBottomRowLeft();
					// pos[2] will handle
				}
			}	


			//IF THE SQUARE IS LOCATED IN THE BOTTOM, FRONT, LEFT CORNER - POS [6]
			else if (RubiksSolver.compareCorner(corner2, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[2][8]),
							Character.toLowerCase(cube.getCubeFaces()[3][8]),
							Character.toLowerCase(cube.getCubeFaces()[5][6])}))  {
				System.out.println("Found 2nd Corner at Pos [6]");


				if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'g') {
					cube.moveTopRowRight();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveTopRowLeft();
					cube.moveRightColumnUp();
					cube.moveBackFaceAC();
					cube.moveRightColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'r') {
					cube.moveTopRowRight();
					cube.moveBackFaceAC();
					cube.moveTopRowLeft();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'w') {
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
					cube.moveBackFaceCW();
					cube.moveTopRowLeft();
				}
			}			


			//IF THE SQUARE IS LOCATED IN THE BOTTOM, FRONT, LEFT CORNER - POS [7]
			else if (RubiksSolver.compareCorner(corner2, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[3][6]),
							Character.toLowerCase(cube.getCubeFaces()[4][6]),
							Character.toLowerCase(cube.getCubeFaces()[5][8])}))  {
				System.out.println("Found 2nd Corner at Pos [7]");


				if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'g') {
					cube.moveRightColumnUp();
					cube.moveBackFaceCW();
					cube.moveBackFaceCW();
					cube.moveRightColumnDown();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'r') {
					cube.moveRightColumnUp();
					cube.moveBackFaceAC();
					cube.moveRightColumnDown();
					cube.moveTopRowRight();
					cube.moveBackFaceCW();
					cube.moveTopRowLeft();

				}
				else if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'w') {
					cube.moveBackFaceAC();
					cube.moveTopRowRight();
					cube.moveBackFaceAC();
					cube.moveTopRowLeft();
				}
			}
		}

		System.out.println("Second Corner Solved");
		System.out.println("Resolving Third Corner...");

		// 3) - NEXT RESOLVE FRONT, BOTTOM, RIGHT CORNER.
		while (	Character.toLowerCase(cube.getCubeFaces()[0][8]) != 'w' || 
				Character.toLowerCase(cube.getCubeFaces()[2][6]) != 'g' ||
				Character.toLowerCase(cube.getCubeFaces()[3][2]) != 'o' ) {

			char[] corner3 = new char[] {'w','g','o'};

			//SQUARE WILL NEVER BE IN Pos [0] & Pos [1]

			//IF THE SQUARE IS LOCATED IN THE TOP, BACK, RIGHT CORNER - POS [2]
			if (RubiksSolver.compareCorner(corner3, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[1][2]),
							Character.toLowerCase(cube.getCubeFaces()[2][2]),
							Character.toLowerCase(cube.getCubeFaces()[5][0])}))  {
				System.out.println("Found 3rd Corner at Pos [2]");


				if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'w') {
					cube.moveBottomRowRight();
					cube.moveBackFaceCW();
					cube.moveBottomRowLeft();	
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'g') {
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveBottomRowLeft();				
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'o') {
					cube.moveBottomRowRight();
					cube.moveBackFaceCW();
					cube.moveBackFaceCW();
					cube.moveBottomRowLeft();
					cube.moveRightColumnDown();
					cube.moveBackFaceCW();
					cube.moveRightColumnUp();	
				}
			}


			//IF THE SQUARE IS LOCATED IN THE TOP, BACK, LEFT CORNER - POS [3]
			else if (RubiksSolver.compareCorner(corner3, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[1][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][0]),
							Character.toLowerCase(cube.getCubeFaces()[5][2])}))  {
				System.out.println("Found 3rd Corner at Pos [3]");				
				if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'w') {
					cube.moveBackFaceCW();
					//Pos[2] wil handle..	

				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'g') {
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveRightColumnDown();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveRightColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'o') {
					cube.moveBackFaceCW();
					//Pos[2] wil handle..
				}
			}

			//IF THE SQUARE IS LOCATED IN THE FRONT, BOTTOM, LEFT CORNER - POS [4]
			else if (RubiksSolver.compareCorner(corner3, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][6]),
							Character.toLowerCase(cube.getCubeFaces()[3][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][8])}))  {
				System.out.println("Found 3rd Corner at Pos [4]");

				if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'w') {
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveRightColumnDown();
					cube.moveBackFaceAC();
					cube.moveRightColumnUp();					
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'g') {
					cube.moveLeftColumnDown();
					cube.moveRightColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveRightColumnUp();					
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'o') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
					cube.moveBottomRowRight();
					cube.moveBackFaceCW();
					cube.moveBottomRowLeft();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE FRONT, BOTTOM, RIGHT CORNER - POS [5]
			else if (RubiksSolver.compareCorner(corner3, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][8]),
							Character.toLowerCase(cube.getCubeFaces()[2][6]),
							Character.toLowerCase(cube.getCubeFaces()[3][2])}))  {
				System.out.println("Found 3rd Corner at Pos [5]");

				if (Character.toLowerCase(cube.getCubeFaces()[0][8])== 'o') {
					cube.moveRightColumnDown();
					cube.moveBackFaceCW();
					cube.moveRightColumnUp();
					cube.moveBackFaceAC();
					cube.moveRightColumnDown();
					cube.moveBackFaceCW();
					cube.moveRightColumnUp();					
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][8])== 'g') {
					cube.moveRightColumnDown();
					cube.moveBackFaceAC();
					cube.moveRightColumnUp();
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveBottomRowLeft();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE BACK, BOTTOM, RIGHT CORNER - POS [6]
			else if (RubiksSolver.compareCorner(corner3, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[2][8]),
							Character.toLowerCase(cube.getCubeFaces()[3][8]),
							Character.toLowerCase(cube.getCubeFaces()[5][6])}))  {
				System.out.println("Found 3rd Corner at Pos [6]");

				if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'w') {
					cube.moveRightColumnDown();
					cube.moveBackFaceCW();
					cube.moveRightColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'g') {
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveBottomRowLeft();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'o') {
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveBottomRowLeft();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveBottomRowLeft();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE BOTTOM, BACK, LEFT CORNER - POS [7]
			if (RubiksSolver.compareCorner(corner3, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[3][6]),
							Character.toLowerCase(cube.getCubeFaces()[4][6]),
							Character.toLowerCase(cube.getCubeFaces()[5][8])}))  {
				System.out.println("Found 3rd Corner at Pos [7]");

				if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'w') {
					cube.moveRightColumnDown();
					cube.moveBackFaceAC();
					cube.moveRightColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'g') {
					cube.moveRightColumnDown();
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveRightColumnUp();
					cube.moveLeftColumnUp();					
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'o') {
					cube.moveBackFaceAC();
					cube.moveRightColumnDown();
					cube.moveBackFaceCW();
					cube.moveRightColumnUp();
				}
			}	
		}


		System.out.println("Third Corner Solved");
		System.out.println("Resolving Fourth Corner...");

		// 4) - NEXT RESOLVE FRONT, BOTTOM, LEFT CORNER.
		while (	Character.toLowerCase(cube.getCubeFaces()[0][6]) != 'w' || 
				Character.toLowerCase(cube.getCubeFaces()[3][0]) != 'o' ||
				Character.toLowerCase(cube.getCubeFaces()[4][8]) != 'b' ) {

			char[] corner4 = new char[] {'w','o','b'};

			//SQUARE WILL NEVER BE IN Pos [0] & Pos [1] & Pos[5]

			//IF THE SQUARE IS LOCATED IN THE TOP, BACK, RIGHT CORNER - POS [2]
			if (RubiksSolver.compareCorner(corner4, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[1][2]),
							Character.toLowerCase(cube.getCubeFaces()[2][2]),
							Character.toLowerCase(cube.getCubeFaces()[5][0])}))  {
				System.out.println("Found 4th Corner at Pos [2]");

				if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'w') {
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
					cube.moveBackFaceCW();
					cube.moveLeftColumnUp();	
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'b') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
				}

				else if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'o') {
					cube.moveBackFaceAC();
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
				}
			}



			//IF THE SQUARE IS LOCATED IN THE TOP, BACK, LEFT CORNER - POS [3]
			else if (RubiksSolver.compareCorner(corner4, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[1][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][0]),
							Character.toLowerCase(cube.getCubeFaces()[5][2])}))  {
				System.out.println("Found 4th Corner at Pos [3]");

				if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'w') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'b') {
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveBackFaceCW();
					cube.moveLeftColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[1][2])== 'o') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE FRONT, BOTTOM, LEFT CORNER - POS [4]
			else if (RubiksSolver.compareCorner(corner4, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][6]),
							Character.toLowerCase(cube.getCubeFaces()[3][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][2])}))  {
				System.out.println("Found 4th Corner at Pos [4]");

				if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'b') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveBackFaceCW();
					cube.moveLeftColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'o') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE BOTTOM, BACK RIGHT CORNER - POS [6]
			else if (RubiksSolver.compareCorner(corner4, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[2][8]),
							Character.toLowerCase(cube.getCubeFaces()[3][8]),
							Character.toLowerCase(cube.getCubeFaces()[5][6])}))  {
				System.out.println("Found 4th Corner at Pos [6]");

				if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'w') {
					cube.moveLeftColumnDown();
					cube.moveBackFaceCW();
					cube.moveLeftColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'b') {
					cube.moveLeftColumnDown();
					cube.moveBackFaceCW();
					cube.moveBackFaceCW();
					cube.moveLeftColumnUp();
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveBackFaceCW();
					cube.moveLeftColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[2][8])== 'o') {
					cube.moveBackFaceCW();
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
				}
			}


			//IF THE SQUARE IS LOCATED IN THE BOTTOM, BACK LEFT CORNER - POS [7]
			else if (RubiksSolver.compareCorner(corner4, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[3][6]),
							Character.toLowerCase(cube.getCubeFaces()[4][6]),
							Character.toLowerCase(cube.getCubeFaces()[5][8])}))  {
				System.out.println("Found 4th Corner at Pos [7]");

				if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'w') {
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'b') {
					cube.moveBackFaceAC();
					cube.moveLeftColumnDown();
					cube.moveBackFaceCW();
					cube.moveLeftColumnUp();
				}
				else if (Character.toLowerCase(cube.getCubeFaces()[4][6])== 'o') {
					cube.moveBackFaceCW();
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();

				}
			}
			//IF THE SQUARE IS LOCATED IN THE NATURAL POSITION BUT INVERTED - POS [4]
			else if (RubiksSolver.compareCorner(corner4, new char[]
					{Character.toLowerCase(cube.getCubeFaces()[0][6]),
							Character.toLowerCase(cube.getCubeFaces()[3][0]),
							Character.toLowerCase(cube.getCubeFaces()[4][8])})) {
				
				if (Character.toLowerCase(cube.getCubeFaces()[0][6])== 'b') {
					cube.moveBottomRowLeft();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();
					cube.moveBackFaceAC();
					cube.moveBottomRowLeft();
					cube.moveBackFaceCW();
					cube.moveBottomRowRight();

				}
				else if (Character.toLowerCase(cube.getCubeFaces()[0][6])== '0') {
					cube.moveLeftColumnDown();
					cube.moveBackFaceAC();
					cube.moveLeftColumnUp();
					cube.moveBackFaceCW();
					cube.moveBackFaceCW();
					cube.moveBottomRowLeft();
					cube.moveBackFaceAC();
					cube.moveBottomRowRight();
				}
			}
		}

		//SOLVING SECOND LEVEL 
		System.out.println("Solving Second Level...");
		System.out.println("Solving Sq1...");

		while (Character.toLowerCase(cube.getCubeFaces()[1][5]) != 'r' || Character.toLowerCase(cube.getCubeFaces()[2][1]) != 'g') {

			if (Character.toLowerCase(cube.getCubeFaces()[4][3]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[5][5])=='g')  {
				System.out.println("Found Square 1 in Pos G[5][5],R[4][3] ...");
				RubiksSolver.solveFirstMiddleSqR(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[5][5])=='r')  {
				System.out.println("Found Square 1 in Pos G[4][3],R[5][5] ...");
				cube.moveBackFaceAC();
				RubiksSolver.solveFirstMiddleSqG(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[5][7])=='r')  {
				System.out.println("Found Square 1 in Pos G[3][7],R[5][7] ...");
				RubiksSolver.solveFirstMiddleSqG(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[5][7])=='g')  {
				System.out.println("Found Square 1 in Pos R[3][7],G[5][7] ...");
				cube.moveBackFaceCW();
				RubiksSolver.solveFirstMiddleSqR(cube);
			}

			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[5][1])=='r')  {
				System.out.println("Found Square 1 in Pos G[1][1],R[5][1] ...");
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveFirstMiddleSqG(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[5][1])=='g')  {
				System.out.println("Found Square 1 in Pos R[1][1],G[5][1] ...");
				cube.moveBackFaceAC();
				RubiksSolver.solveFirstMiddleSqR(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[5][3])=='r')  {
				System.out.println("Found Square 1 in Pos G[2][5],R[5][3] ...");
				cube.moveBackFaceCW();
				RubiksSolver.solveFirstMiddleSqG(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[5][3])=='g')  {
				System.out.println("Found Square 1 in Pos R[2][5],G[5][3] ...");
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveFirstMiddleSqR(cube);
			}



			// Natural Position - BUT INVERTED
			else if (Character.toLowerCase(cube.getCubeFaces()[1][5]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[2][1])=='r')  {
				System.out.println("Found Square 1 in Inverted Natural Pos G[1][5],R[2][1] ...");
				RubiksSolver.solveFirstMiddleSqR(cube);
				cube.moveBackFaceCW();
				RubiksSolver.solveFirstMiddleSqR(cube);
			}



			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[3][5])=='g')  {
				System.out.println("Found Square 1 in Pos G[3][5],R[2][7] ...");
				RubiksSolver.extractFromPos2735(cube);
				cube.moveBackFaceAC();
				RubiksSolver.solveFirstMiddleSqG(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[3][5])=='r')  {
				System.out.println("Found Square 1 in Pos R[3][5],G[2][7] ...");
				RubiksSolver.extractFromPos2735(cube);
				RubiksSolver.solveFirstMiddleSqR(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[3][3]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[4][7])=='r') {
				System.out.println("Found Square 1 in Inner Pos G[3][3],R[4][7] ...");
				RubiksSolver.extractFromPos3347(cube);
				cube.moveBackFaceAC();
				RubiksSolver.solveFirstMiddleSqR(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[3][3]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[4][7])=='g') {
				System.out.println("Found Square 1 in Inner Pos R[3][3],G[4][7] ...");
				RubiksSolver.extractFromPos3347(cube);
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveFirstMiddleSqG(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[4][1])=='r') {
				System.out.println("Found Square 1 in Inner Pos G[1][3],R[4][1] ...");
				RubiksSolver.extractFromPos1341(cube);
				cube.moveBackFaceCW();
				RubiksSolver.solveFirstMiddleSqR(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[4][1])=='g') {
				System.out.println("Found Square 1 in Inner Pos R[1][3],G[4][1] ...");
				RubiksSolver.extractFromPos1341(cube);
				RubiksSolver.solveFirstMiddleSqG(cube);
			}

		}


		System.out.println("Sq1 in Place...");
		System.out.println("Solving Sq2...");

		while (Character.toLowerCase(cube.getCubeFaces()[2][7]) != 'g' || Character.toLowerCase(cube.getCubeFaces()[3][5]) != 'o') {

			if (Character.toLowerCase(cube.getCubeFaces()[4][3]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[5][5])=='g')  {
				System.out.println("Found Square 2 in Pos o[4][3],g[5][5] ...");
				RubiksSolver.solveSecondMiddleSqO(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[5][5])=='o'){
				System.out.println("Found Square 2 in Pos g[4][3],o[5][5] ...");
				cube.moveBackFaceCW();
				RubiksSolver.solveSecondMiddleSqG(cube);				
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[5][1])=='o')  {
				System.out.println("Found Square 2 in Pos g[1][1],o[5][1] ...");
				RubiksSolver.solveSecondMiddleSqG(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[5][1])=='g')  {
				System.out.println("Found Square 2 in Pos o[1][1],g[5][1] ...");
				cube.moveBackFaceAC();
				RubiksSolver.solveSecondMiddleSqO(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[5][3])=='o')  {
				System.out.println("Found Square 2 in Pos g[2][5],o[5][3] ...");
				cube.moveBackFaceAC();
				RubiksSolver.solveSecondMiddleSqG(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[5][3])=='g')  {
				System.out.println("Found Square 2 in Pos o[2][5],g[5][3] ...");
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveSecondMiddleSqO(cube);				
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[5][7])=='o')  {
				System.out.println("Found Square 2 in Pos g[3][7],o[5][7] ...");
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveSecondMiddleSqG(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[5][7])=='g')  {
				System.out.println("Found Square 2 in Pos o[3][7],g[5][7] ...");
				cube.moveBackFaceCW();
				RubiksSolver.solveSecondMiddleSqO(cube);				
			}


			/// Natural poisiton but inverted
			else if (Character.toLowerCase(cube.getCubeFaces()[2][7]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[3][5])=='g')  {
				System.out.println("Found Square 2 in Pos o[2][7],g[3][5] ...");
				cube.moveBottomRowRight();
				cube.moveBackFaceAC();
				cube.moveBottomRowLeft();
				cube.moveBackFaceCW();
				cube.moveRightColumnDown();
				cube.moveBackFaceCW();
				cube.moveRightColumnUp();
				cube.moveBackFaceCW();
				RubiksSolver.solveSecondMiddleSqG(cube);				
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[3][3]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[4][7])=='o')  {
				System.out.println("Found Square 2 in Pos g[3][3],o[4][7] ...");
				cube.moveLeftColumnDown();
				cube.moveBackFaceCW();
				cube.moveLeftColumnUp();
				cube.moveBackFaceCW();
				cube.moveBottomRowLeft();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				cube.moveBackFaceAC();
				RubiksSolver.solveSecondMiddleSqO(cube);
			}			
			else if (Character.toLowerCase(cube.getCubeFaces()[3][3]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[4][7])=='g')  {
				System.out.println("Found Square 2 in Pos o[3][3],g[4][7] ...");
				cube.moveLeftColumnDown();
				cube.moveBackFaceCW();
				cube.moveLeftColumnUp();
				cube.moveBackFaceCW();
				cube.moveBottomRowLeft();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				RubiksSolver.solveSecondMiddleSqG(cube);
			}			


			else if (Character.toLowerCase(cube.getCubeFaces()[4][1]) =='g' &&  Character.toLowerCase(cube.getCubeFaces()[1][3])=='o')  {
				System.out.println("Found Square 2 in Pos g[4][1],o[1][3] ...");
				cube.moveLeftColumnUp();
				cube.moveBackFaceAC();
				cube.moveLeftColumnDown();
				cube.moveBackFaceAC();
				cube.moveTopRowLeft();
				cube.moveBackFaceCW();
				cube.moveTopRowRight();
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveSecondMiddleSqG(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][1]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[1][3])=='g')  {
				System.out.println("Found Square 2 in Pos o[4][1],g[1][3] ...");
				cube.moveLeftColumnUp();
				cube.moveBackFaceAC();
				cube.moveLeftColumnDown();
				cube.moveBackFaceAC();
				cube.moveTopRowLeft();
				cube.moveBackFaceCW();
				cube.moveTopRowRight();
				cube.moveBackFaceCW();				
				RubiksSolver.solveSecondMiddleSqO(cube);				
			}
		}

		System.out.println("Sq2 in place...");
		System.out.println("Solving Sq3...");

		while (Character.toLowerCase(cube.getCubeFaces()[3][3]) != 'o' || Character.toLowerCase(cube.getCubeFaces()[4][7]) != 'b') {

			if (Character.toLowerCase(cube.getCubeFaces()[1][1]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[5][1])=='o')  {
				RubiksSolver.solveThirdMiddleSqB(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[5][1])=='b') {
				cube.moveBackFaceCW();
				RubiksSolver.solveThirdMiddleSqO(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[5][3])=='o')  {
				cube.moveBackFaceAC();
				RubiksSolver.solveThirdMiddleSqB(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[5][3])=='b') {
				RubiksSolver.solveThirdMiddleSqO(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[5][7])=='o')  {
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveThirdMiddleSqB(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[5][7])=='b') {
				cube.moveBackFaceAC();
				RubiksSolver.solveThirdMiddleSqO(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[5][5])=='o')  {
				cube.moveBackFaceCW();
				RubiksSolver.solveThirdMiddleSqB(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[5][5])=='b') {
				cube.moveBackFaceAC();
				cube.moveBackFaceAC();
				RubiksSolver.solveThirdMiddleSqO(cube);
			}

			//Natural Position- Inverted
			else if (Character.toLowerCase(cube.getCubeFaces()[3][3]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[4][7])=='o')  {
				cube.moveLeftColumnDown();
				cube.moveBackFaceCW();
				cube.moveLeftColumnUp();
				cube.moveBackFaceCW();
				cube.moveBottomRowLeft();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				cube.moveBackFaceCW();
				RubiksSolver.solveThirdMiddleSqO(cube);

			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[4][1])=='o') {
				cube.moveTopRowLeft();
				cube.moveBackFaceCW();
				cube.moveTopRowRight();
				cube.moveBackFaceCW();
				cube.moveLeftColumnUp();
				cube.moveBackFaceAC();
				cube.moveLeftColumnDown();
				cube.moveBackFaceAC();
				RubiksSolver.solveThirdMiddleSqB(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) =='o' &&  Character.toLowerCase(cube.getCubeFaces()[4][1])=='b') {
				cube.moveTopRowLeft();
				cube.moveBackFaceCW();
				cube.moveTopRowRight();
				cube.moveBackFaceCW();
				cube.moveLeftColumnUp();
				cube.moveBackFaceAC();
				cube.moveLeftColumnDown();
				RubiksSolver.solveThirdMiddleSqO(cube);
			}
		}

		System.out.println("Sq3 in place...");
		System.out.println("Solving Sq4...");

		while (Character.toLowerCase(cube.getCubeFaces()[1][3]) != 'r' || Character.toLowerCase(cube.getCubeFaces()[4][1]) != 'b') {

			if (Character.toLowerCase(cube.getCubeFaces()[2][5]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[5][3])=='b')  {
				RubiksSolver.solveFourthMiddleSqR(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[2][5]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[5][3])=='r') {
				cube.moveBackFaceCW();
				RubiksSolver.solveFourthMiddleSqB(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[5][7])=='r') {
				RubiksSolver.solveFourthMiddleSqB(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[3][7]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[5][7])=='b') {
				cube.moveBackFaceAC();
				RubiksSolver.solveFourthMiddleSqR(cube);
			}



			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[5][1])=='r') {
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveFourthMiddleSqB(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[5][1])=='b') {
				cube.moveBackFaceCW();
				RubiksSolver.solveFourthMiddleSqR(cube);
			}


			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[5][5])=='r') {
				cube.moveBackFaceAC();
				RubiksSolver.solveFourthMiddleSqB(cube);
			}
			else if (Character.toLowerCase(cube.getCubeFaces()[4][3]) =='r' &&  Character.toLowerCase(cube.getCubeFaces()[5][5])=='b') {
				cube.moveBackFaceAC();
				cube.moveBackFaceAC();
				RubiksSolver.solveFourthMiddleSqR(cube);
			}

			// Natural Position But inverted
			else if (Character.toLowerCase(cube.getCubeFaces()[1][3]) =='b' &&  Character.toLowerCase(cube.getCubeFaces()[4][1])=='r') {
				RubiksSolver.solveFourthMiddleSqB(cube);
				cube.moveBackFaceCW();
				RubiksSolver.solveFourthMiddleSqB(cube);
			}		
		}

		System.out.println("Sq4 in place...");
		System.out.println("Solving Penultimate Squares...");
		
		
		while (Character.toLowerCase(cube.getCubeFaces()[5][1]) != 'y' || Character.toLowerCase(cube.getCubeFaces()[5][3]) != 'y' || 
				Character.toLowerCase(cube.getCubeFaces()[5][5]) != 'y' || Character.toLowerCase(cube.getCubeFaces()[5][7]) != 'y') {
			
			// Single middle square
			if (  Character.toLowerCase(cube.getCubeFaces()[5][1]) != 'y' && Character.toLowerCase(cube.getCubeFaces()[5][3]) != 'y' && 
					Character.toLowerCase(cube.getCubeFaces()[5][5]) != 'y' && Character.toLowerCase(cube.getCubeFaces()[5][7]) != 'y') {
				System.out.println("Executing 1...");
				RubiksSolver.solveThirdLevelYellows(cube);
			}
			
			
			// L-shape correct place
			else if (Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'y' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'y' && 
					Character.toLowerCase(cube.getCubeFaces()[5][5]) != 'y' && Character.toLowerCase(cube.getCubeFaces()[5][7]) != 'y' ) {
				System.out.println("Executing 2...");
				RubiksSolver.solveThirdLevelYellows(cube);	
			}
			
			// L-shape  but not correct place - move then execute
			else if (Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'y' && Character.toLowerCase(cube.getCubeFaces()[5][3]) != 'y' && 
					Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'y' && Character.toLowerCase(cube.getCubeFaces()[5][7]) != 'y' ) {
				System.out.println("Executing 3...");
				cube.moveBackFaceCW();
				RubiksSolver.solveThirdLevelYellows(cube);	
			}
			
			// L-shape  but not correct place - move then execute
			else if (Character.toLowerCase(cube.getCubeFaces()[5][1]) != 'y' && Character.toLowerCase(cube.getCubeFaces()[5][3]) != 'y' && 
					Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'y' && Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'y' ) {
				System.out.println("Executing 4...");
				cube.moveBackFaceCW();
				cube.moveBackFaceCW();
				RubiksSolver.solveThirdLevelYellows(cube);	
			}	
			// L-shape  but not correct place - move then execute
			else if (Character.toLowerCase(cube.getCubeFaces()[5][1]) != 'y' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'y' && 
					Character.toLowerCase(cube.getCubeFaces()[5][5]) != 'y' && Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'y' ) {
				System.out.println("Executing 4...");
				cube.moveBackFaceAC();
				RubiksSolver.solveThirdLevelYellows(cube);	
			}
			
			
			// BAR-Shape correct position
			else if (Character.toLowerCase(cube.getCubeFaces()[5][1]) != 'y' && Character.toLowerCase(cube.getCubeFaces()[5][3]) == 'y' && 
					Character.toLowerCase(cube.getCubeFaces()[5][5]) == 'y' && Character.toLowerCase(cube.getCubeFaces()[5][7]) != 'y' ) {
				System.out.println("Executing 6...");
				RubiksSolver.solveThirdLevelYellows(cube);	
			}			
			// BAR-Shape  but not correct position
			else if (Character.toLowerCase(cube.getCubeFaces()[5][1]) == 'y' && Character.toLowerCase(cube.getCubeFaces()[5][3]) != 'y' && 
					Character.toLowerCase(cube.getCubeFaces()[5][5]) != 'y' && Character.toLowerCase(cube.getCubeFaces()[5][7]) == 'y' ) {
				System.out.println("Executing 7...");
				cube.moveBackFaceCW();
				RubiksSolver.solveThirdLevelYellows(cube);	
			}	
		}
		
		System.out.println("Yellow Cross Solved");
		
		System.out.println("Solving Cross Colours...");
		
		while (Character.toLowerCase(cube.getCubeFaces()[1][1]) != 'r' || Character.toLowerCase(cube.getCubeFaces()[2][5]) != 'g' || 
				Character.toLowerCase(cube.getCubeFaces()[3][7]) != 'o' || Character.toLowerCase(cube.getCubeFaces()[4][3]) != 'b') {
			
			System.out.println("Executing Cross Colours Sequence...");
			
			// If solved but not in right position
			if  ((Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'g' &&  Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'o' &&  Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'b' &&  Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'r') ||
				(Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'o' &&  Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'b' &&  Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'r' &&  Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'g')) {
				cube.moveBackFaceCW();
				System.out.println("1..");
				//System.exit(0);
			}
			// If solved but not in right position
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'b' &&  Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'r' &&  Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'g' &&  Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'o') {
				cube.moveBackFaceAC();
				System.out.println("2..");
				//System.exit(0);
			}
			
			
			
						
			// If Red and Blue is adjacent and in correct place, execute sequence solveThirdLevelSwapRBAdj
			else if ( Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'r' &&  Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'b') {
				System.out.println("Executing Full adjacency Sequence 1...");
				RubiksSolver.solveThirdLevelSwapRBAdj(cube);
				System.out.println("3..");
				//System.exit(0);
				
			}
			//If RB Adjacent
			else if ( Character.toLowerCase(cube.getCubeFaces()[4][3]) == 'r' &&  Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'b' ||
					Character.toLowerCase(cube.getCubeFaces()[3][7]) == 'r' &&  Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'b' ){
				cube.moveBackFaceCW();
			}
			//If RB Adjacent
			else if (Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'b' &&  Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'r' ){
				cube.moveBackFaceAC();
			}
			
			else if ( Character.toLowerCase(cube.getCubeFaces()[1][1]) == 'r') {
				cube.moveRightColumnUp();
				cube.moveBackFaceAC();
				cube.moveBackFaceAC();
				cube.moveRightColumnDown();
				cube.moveBackFaceCW();
				cube.moveRightColumnUp();
				cube.moveBackFaceCW();
				cube.moveRightColumnDown();

			}
			// Otheriwse place red in correct place
			else if ( Character.toLowerCase(cube.getCubeFaces()[2][5]) == 'r') {
				cube.moveBackFaceAC();
			}			
			// Otheriwse place red in correct place
			else {
				cube.moveBackFaceCW();
			}	
			
			//System.exit(0);
		}
		System.out.println("Cross-Adjaceny Resolved!");
		
		System.out.println("Resolving Corner Pieces...");
		while ( !RubiksSolver.compareCorner(new char[]{Character.toLowerCase(cube.getCubeFaces()[1][2]), Character.toLowerCase(cube.getCubeFaces()[2][2]), Character.toLowerCase(cube.getCubeFaces()[5][0])},new char[] {'r','g','y'} ) ||
				!RubiksSolver.compareCorner(new char[]{Character.toLowerCase(cube.getCubeFaces()[2][8]), Character.toLowerCase(cube.getCubeFaces()[3][8]), Character.toLowerCase(cube.getCubeFaces()[5][6])},new char[] {'o','g','y'} ) ||
				!RubiksSolver.compareCorner(new char[]{Character.toLowerCase(cube.getCubeFaces()[3][6]), Character.toLowerCase(cube.getCubeFaces()[4][6]), Character.toLowerCase(cube.getCubeFaces()[5][8])},new char[] {'o','b','y'} ) ||
				!RubiksSolver.compareCorner(new char[]{Character.toLowerCase(cube.getCubeFaces()[1][0]), Character.toLowerCase(cube.getCubeFaces()[4][0]), Character.toLowerCase(cube.getCubeFaces()[5][2])},new char[] {'r','b','y'} ) ) {
			
			if (RubiksSolver.compareCorner(new char[]{Character.toLowerCase(cube.getCubeFaces()[1][2]), Character.toLowerCase(cube.getCubeFaces()[2][2]), Character.toLowerCase(cube.getCubeFaces()[5][0])},new char[] {'r','g','y'})) {
				System.out.println("Corner in Place...");
				cube.moveLeftColumnUp();
				cube.moveBackFaceAC();
				cube.moveRightColumnUp();
				cube.moveBackFaceCW();
				cube.moveLeftColumnDown();
				cube.moveBackFaceAC();
				cube.moveRightColumnDown();
				cube.moveBackFaceCW();
			}
			else if (!(RubiksSolver.compareCorner(new char[]{Character.toLowerCase(cube.getCubeFaces()[2][8]), Character.toLowerCase(cube.getCubeFaces()[3][8]), Character.toLowerCase(cube.getCubeFaces()[5][6])},new char[] {'r','g','y'}))) {
				System.out.println("Corner NOT in place...locating...");
				cube.moveTopRowRight();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				cube.moveBackFaceCW();
				cube.moveTopRowLeft();
				cube.moveBackFaceAC();
				cube.moveBottomRowLeft();
				cube.moveBackFaceCW();
			}
			else {
				System.out.println("Corner Remotely located...");
				cube.moveBottomRowLeft();
				cube.moveBackFaceAC();
				cube.moveTopRowLeft();
				cube.moveBackFaceCW();
				cube.moveBottomRowRight();
				cube.moveBackFaceAC();
				cube.moveTopRowRight();
				cube.moveBackFaceCW();
			}	
			//System.exit(0);
		}
		System.out.println("Corner Piece Positions Resolved!");
		
		System.out.println("Performing Corner Revolutions..");
		while ( Character.toLowerCase(cube.getCubeFaces()[1][2])!='r' ||
				Character.toLowerCase(cube.getCubeFaces()[2][2])!='g' ||
				Character.toLowerCase(cube.getCubeFaces()[5][0])!='y' ||

				Character.toLowerCase(cube.getCubeFaces()[2][8])!='g' ||
				Character.toLowerCase(cube.getCubeFaces()[3][8])!='o' ||
				Character.toLowerCase(cube.getCubeFaces()[5][6])!='y' ||

				Character.toLowerCase(cube.getCubeFaces()[3][6])!='o' ||
				Character.toLowerCase(cube.getCubeFaces()[4][6])!='b' ||
				Character.toLowerCase(cube.getCubeFaces()[5][8])!='y' ||

				Character.toLowerCase(cube.getCubeFaces()[1][0])!='r' ||
				Character.toLowerCase(cube.getCubeFaces()[4][0])!='b' ||
				Character.toLowerCase(cube.getCubeFaces()[5][2])!='y' ) {
		
			// If no corners solved OR If two squares solved (Left side - from looking top down) OR if Diagonal Squares solved
			
			if ((Character.toLowerCase(cube.getCubeFaces()[1][2])!='r'  &&
					Character.toLowerCase(cube.getCubeFaces()[2][8])!='g' &&
					Character.toLowerCase(cube.getCubeFaces()[3][6])!='o' &&
					Character.toLowerCase(cube.getCubeFaces()[4][0])!='b') ||
					(Character.toLowerCase(cube.getCubeFaces()[1][0])== 'r' &&
					Character.toLowerCase(cube.getCubeFaces()[3][6])=='o' &&
					Character.toLowerCase(cube.getCubeFaces()[1][2])!='r' &&
					Character.toLowerCase(cube.getCubeFaces()[2][8])!='g') ||
					(Character.toLowerCase(cube.getCubeFaces()[1][0])== 'r' &&
					Character.toLowerCase(cube.getCubeFaces()[1][2])!='r' &&
					Character.toLowerCase(cube.getCubeFaces()[5][6])=='y' &&
					Character.toLowerCase(cube.getCubeFaces()[5][8])!='y')||
					(Character.toLowerCase(cube.getCubeFaces()[1][0])!= 'r' &&
					Character.toLowerCase(cube.getCubeFaces()[1][2])=='r' &&
					Character.toLowerCase(cube.getCubeFaces()[5][6])!='y' &&
					Character.toLowerCase(cube.getCubeFaces()[5][8])=='y'))		
			{
				System.out.println("EXECUTING...");
				RubiksSolver.finalMoveLeft2(cube);
			}
			
			//If two squares solved (Front Side - from looking top down)
			else if (Character.toLowerCase(cube.getCubeFaces()[1][0])== 'r' &&
					Character.toLowerCase(cube.getCubeFaces()[1][2])=='r' &&
					Character.toLowerCase(cube.getCubeFaces()[5][6])!='y' &&
					Character.toLowerCase(cube.getCubeFaces()[5][8])!='y') 
			{
				System.out.println("EXECUTING 3...");
				RubiksSolver.finalMoveFront2(cube);
			}
			//if 2 Squares solved (Right Side - from looking top down)
			else if (Character.toLowerCase(cube.getCubeFaces()[1][0])!= 'r' &&
					Character.toLowerCase(cube.getCubeFaces()[1][2])=='r' &&
					Character.toLowerCase(cube.getCubeFaces()[5][6])=='y' &&
					Character.toLowerCase(cube.getCubeFaces()[5][8])!='y') 
			{
				System.out.println("EXECUTING 4...");
				RubiksSolver.finalMoveRight2(cube);
			}			
			
			//if 2 Squares solved (Back Side - from looking top down)
			else if (Character.toLowerCase(cube.getCubeFaces()[1][0])!= 'r' &&
					Character.toLowerCase(cube.getCubeFaces()[1][2])!='r' &&
					Character.toLowerCase(cube.getCubeFaces()[5][6])=='y' &&
					Character.toLowerCase(cube.getCubeFaces()[5][8])=='y') 
			{
				cube.moveTopRowLeft();
				cube.moveBackFaceAC();
				cube.moveBackFaceAC();
				cube.moveTopRowRight();
				cube.moveBackFaceCW();
				cube.moveTopRowLeft();
				cube.moveBackFaceCW();
				cube.moveTopRowRight();

				cube.moveBottomRowLeft();
				cube.moveBackFaceAC();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
				cube.moveBackFaceAC();
				cube.moveBottomRowLeft();
				cube.moveBackFaceAC();
				cube.moveBottomRowRight();
			}
			//If only 1 solved			
			else if (Character.toLowerCase(cube.getCubeFaces()[1][2])=='r' ||
					Character.toLowerCase(cube.getCubeFaces()[5][6])=='y') {
				System.out.println("EXECUTING 6...");
				RubiksSolver.finalMoveRight2(cube);		
			}
			
			else {
				System.out.println("EXECUTING Default...");
				RubiksSolver.finalMoveLeft2(cube);
			}
			
			
		}	
	}
}