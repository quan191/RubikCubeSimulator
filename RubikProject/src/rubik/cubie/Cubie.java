package rubik.cubie;

import javafx.scene.shape.TriangleMesh;
import rubik.cubie.setup.ColorsSetUp;

public class Cubie extends TriangleMesh {
	
	private static int[][] points = {{2,3,6},{3,7,6},
									{0,1,2},{2,1,3},
									{1,5,3},{5,7,3},
									{0,4,1},{4,5,1},
									{4,6,5},{6,7,5},
									{0,2,4},{2,6,4}};
		
	public Cubie(int[] face) {
		// TODO Auto-generated constructor stub

        // POINTS
        this.getPoints().addAll(
             0.5f,  0.5f,  0.5f,
             0.5f, -0.5f,  0.5f,
             0.5f,  0.5f, -0.5f,
             0.5f, -0.5f, -0.5f,
            -0.5f,  0.5f,  0.5f,
            -0.5f, -0.5f,  0.5f,
            -0.5f,  0.5f, -0.5f,
            -0.5f, -0.5f, -0.5f
        );

        // TEXTURES
        this.getTexCoords().addAll(
            ColorsSetUp.X_RED, 0.5f, 			// 0
            ColorsSetUp.X_GREEN, 0.5f,			// 1
            ColorsSetUp.X_BLUE, 0.5f, 			// 2
            ColorsSetUp.X_YELLOW, 0.5f, 		// 3
            ColorsSetUp.X_ORANGE, 0.5f, 		// 4 
            ColorsSetUp.X_WHITE, 0.5f,			// 5
            ColorsSetUp.X_GRAY, 0.5f,			// 6
            5f/7f,0f,
            6f/7f,0f,
            5f/7f,1f,
            6f/7f,1f
        );

        for(int i=0;i<12;i+=2) {
        	if (face[i/2]!=ColorsSetUp.WHITE) {
        		this.getFaces().addAll(points[i][0],face[i/2],points[i][1],face[i/2],points[i][2],face[i/2]);
        		this.getFaces().addAll(points[i+1][0],face[i/2],points[i+1][1],face[i/2],points[i+1][2],face[i/2]);
        	}
        	else {
        		this.getFaces().addAll(points[i][0],10,points[i][1],8,points[i][2],9);
        		this.getFaces().addAll(points[i+1][0],8,points[i+1][1],7,points[i+1][2],9);
        	}
        }
//        this.getFaces().addAll(
//            2,face[0],3,face[0],6,face[0],      // F      
//            3,face[0],7,face[0],6,face[0],  
//
//            0,face[1],1,face[1],2,face[1],      // R     
//            2,face[1],1,face[1],3,face[1],         
//
//            1,face[2],5,face[2],3,face[2],      // U   
//            5,face[2],7,face[2],3,face[2],
//
//            0,face[3],4,face[3],1,face[3],      // B      
//            4,face[3],5,face[3],1,face[3],       
//
//            4,face[4],6,face[4],5,face[4],      // L      
//            6,face[4],7,face[4],5,face[4],    
//
//            0,10,2,8,4,9,      // D      
//            2,8,6,7,4,9        
//        );
    }
}
	
	


