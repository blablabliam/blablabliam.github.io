
import java.io.*;

public class stringgen {

	public static void main(String[] args) {
 
	    double y0 = 0.;   
	    double vy0 = 6.;  
	    
	    double t = 0.;    
	    double dt = 0.04; 
	    double y = y0;
	    double vy = vy0;
	    double g = 9.8;   
	    
		double ymax = .2;
		double xbar = .4;
		double sigma = .04;
		double L = 1.0;
		double F = 750.0;
		double m = .025;
		double dt = .1;
		double dx = .1;
		double T = 60;
		double c = dx/dt;
		int totalxdivisions = L/dx;
		int totaltdivisions = T/dt;
		
		//declare the cool double array for the y position
		double[][] y = new double[totaltdivisions][totalxdivisions];
		
	      try{
	    	    FileWriter fw = new FileWriter("output.txt");
	    	    BufferedWriter fout = new BufferedWriter(fw);
				
				//Initialize the first two positions in the string from a curve.
				for(int i=0;i<=1;i++) {
					for(int n=0;n<=totalxdivisions;n++) {
						y[i][n] = exp((-1.0)*(n*L/dx-xbar)*(n*L/dx-xbar)/(2.0*sigma));
					}
				}
				
				for(int i=0;i<totaltdivisions;i++) {
					y[i][0] = 0.0;
					y[i][totalxdivisions] = 0.0;
				}
				
				//Now, run the string simulation by filling the rest of the array.
				for(int i=2;i<totaltdivisions;i++) {
					for(int n=1;n<totalxdivisions;n++) {
						y[i][n] = y[i-1][n+1] + y[i-1][n-1] - y[i-2][n];
					}
				}
				
				//Now, we write y to a txt file with a table.
				for(int i=1;i<totaltdivisions;i++) {
					for(int n=0;n<=totalxdivisions) {
						fout.write(y[i][n] + "  ");
					}
					fout.newLine();
				}
				fout.close()
				//close output 
	    	}catch (Exception e){      //Catch exception if any
			System.err.println("Error: " + e.getMessage());
	        }
			System.out.println("  ");					      
			System.out.println("All done!");					      
			System.out.println("initial gausian peak   = "+y[0][5]);					      
			System.out.println("final gausian peak = "+y[20][5]);					      

	}

}
