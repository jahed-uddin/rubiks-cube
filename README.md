
//This a Text only model of the Rubiks Cube. Enter the configuration of your own Rubiks cube and it will solve ot for you!!
(Not at all the most efficient algorithm...but it works)
WARNING: The program does NO SANITY CHECKING of user input so if you enter incorrect or invalid config then the progrmam will crash!!!

==============================
HOW TO USE THE RUBIKS SOLVER
==============================

If you have a real rubiks cube, then holding the Rubiks with the white face facing you, the red face upwards, and orange face downwards enter the config in the main app Line 8.

Each real cube face is represented by a string of 9 chars delimited by a comma:

"ggrowobby,brwrryowg,wboyggbwr,yoowobbrg,wgywbgwor,gyoyyrybr" IS EQUAL TO:


===============================================
WHITE FACE: 
[g][g][r]

[o][W][o]
[b][b][y]"
			
RED FACE: 	  	[b][r][w]
		           	[r][R][y]
			          [o][w][g]
				
GREEN FACE: 		[w][b][o]
			          [y][G][g]
	          		[b][w][r]
		
ORANGE FACE: 		[y][o][o]
                [w][O][b]
	          		[b][r][g]
			
BLUE FACE: 	   	[w][g][y]
        		  	[w][B][g]
          			[w][o][r]
				
YELLOW FACE: 		[g][y][o]
		          	[y][Y][r]
	          		[y][b][r]
			
===============================================

ALTERNATIVELY you can uncomment line 6 and make your own moves from the list of (commented out) moves from line 11.
Call RubiksSolver.solveCube(cube) TO SOLVE YOU CUBE!
