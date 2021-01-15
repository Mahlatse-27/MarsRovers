import java.util.* ;

public class Program {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in) ;

        System.out.println("Enter the width and height of the Plateau: ");
        System.out.println("E.g: 5 5");
        
        String matrix_dim = input.nextLine() ;
        String []matrix_dim_arr = string_splitter(matrix_dim);

        int width = Integer.parseInt(matrix_dim_arr[0]) ;
        int height = Integer.parseInt(matrix_dim_arr[1]);

        int num_of_rovers = 2 ;

        String []res_arr = new String[num_of_rovers] ;

        for (int i = 0 ; i < num_of_rovers ; i++ ){
        	 
        	 int rover_num = i+1 ;
        	 
        	 System.out.println("**** ROVER "+ rover_num +" ****");
             System.out.println("Enter The Rover's x-coordinate, y-coordinate and Compass direction: ");
             System.out.println("E.g: 3 3 E");
             
             String rover_pos = input.nextLine();
             String []rover_pos_arr = string_splitter(rover_pos);

             System.out.println("Enter Rover's New Movements: ");
             System.out.println("E.g: LMRMLRLLRRM");
             String rover_mov = input.nextLine();
             
             String result = movement_of_rover(width, height, rover_pos_arr, rover_mov) ;

             res_arr[i] = result;

        }
        
        System.out.println("");
        for(int i = 0 ; i < res_arr.length ; i++ ){
        	int rover_num = i+1; 
             System.out.println("Rover " +rover_num+"'s  New Coordinates : ");
             System.out.println(res_arr[i]);
             System.out.println("");
        }
    }

    public static String movement_of_rover(int width, int height, String[] rover_pos_arr, String rover_mov){

        int rover_x = Integer.parseInt(rover_pos_arr[0]);
        int rover_y = Integer.parseInt(rover_pos_arr[1]);   

        char rovev_dir = rover_pos_arr[2].charAt(0) ;

        //
        for (int i = 0 ; i < rover_mov.length() ; i++){
            char curr_mov_dir = rover_mov.charAt(i) ;

            if (rovev_dir == 'N'){
                if (curr_mov_dir == 'M'){
                    rover_y++ ;
                    if (rover_within_bounds(width, height, rover_x, rover_y)){
                        return "Rover Out Of Bounds";
                    }
                }
                else if (curr_mov_dir == 'R'){
                    rovev_dir = 'E' ;
                }
                else if (curr_mov_dir == 'L'){
                    rovev_dir = 'W' ;
                }
            }

            else if (rovev_dir == 'E'){
                if (curr_mov_dir == 'M'){
                    rover_x++ ;
                    if (rover_within_bounds(width, height, rover_x, rover_y)){
                        return "Rover Out Of Bounds";
                    }
                }
                else if (curr_mov_dir == 'R'){
                    rovev_dir = 'S' ;
                }
                else if (curr_mov_dir == 'L'){
                    rovev_dir = 'N' ;
                }
            }

            else if (rovev_dir == 'S'){
                if (curr_mov_dir == 'M'){
                    rover_y-- ;
                    if (rover_within_bounds(width, height, rover_x, rover_y)){
                        return "Rover Out Of Bounds";
                    }
                }
                else if (curr_mov_dir == 'R'){
                    rovev_dir = 'W' ;
                }
                else if (curr_mov_dir == 'L'){
                    rovev_dir = 'E' ;
                }
            }

            else if (rovev_dir == 'W'){
                if (curr_mov_dir == 'M'){
                    rover_x-- ;
                    if (rover_within_bounds(width, height, rover_x, rover_y)){
                        return "Rover Out Of Bounds";
                    }
                }
                else if (curr_mov_dir == 'R'){
                    rovev_dir = 'N' ;
                }
                else if (curr_mov_dir == 'L'){
                    rovev_dir = 'S' ;
                }
            }
        }

        //Converting A New Rover Coordinates Integers To Strings
        String curr_rover_x = "" + rover_x;
        String curr_rover_y = "" + rover_y;

        //Concatenating Rover Coordinates And Rover Direction
        String result = curr_rover_x + " " + curr_rover_y + " " + rovev_dir ;

        return result;
    }

    public static Boolean rover_within_bounds(int width, int height, int rover_x, int rover_y){
        if ((rover_y >= 0 && rover_y <= height) && (rover_x >= 0 && rover_x <= width)){
            return false ;
        }
        return true ;
    }
    
    public static String[] string_splitter(String line) {
    	String[] array = line.split(" ");
    	
    	return array;
    }
}