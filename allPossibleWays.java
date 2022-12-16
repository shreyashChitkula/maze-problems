import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

//very interesting when learnt for the first time
public class mazeProblem {
    public static void main(String[] args) {
        boolean[][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path=new int[maze.length][maze[0].length];
        allPossibleWaysIfAllDirectionsAllowedPathAndMatrix(maze,path,"",0,0,1);

    }
      static void allPossibleWaysIfAllDirectionsAllowedPathAndMatrix(boolean[][] maze,int[][] path,String p,int r,int c,int step){
        if(r==0&&c==maze[0].length-1) {
            path[r][c]=step;
            for (int i = 0; i < path.length; i++) {
                System.out.println(Arrays.toString(path[i]));
            }
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        //i am considering this block in my path
        maze[r][c]=false;
        path[r][c]=step;
        if(r<maze.length-1){
            allPossibleWaysIfAllDirectionsAllowedPathAndMatrix(maze,path,p+'B',r+1,c,step+1);
        }
        if(c<maze[0].length-1){
            allPossibleWaysIfAllDirectionsAllowedPathAndMatrix(maze,path,p+'R',r,c+1,step+1);
        }
        if(r>0){
            allPossibleWaysIfAllDirectionsAllowedPathAndMatrix(maze,path,p+'T',r-1,c,step+1);
        }
        if(c>0){
            allPossibleWaysIfAllDirectionsAllowedPathAndMatrix(maze,path,p+'L',r,c-1,step+1);
        }
        //this line is where the function will be over
        //so before funcion gets removed,also remove changes that were made by that function
        maze[r][c]=true;
        path[r][c]=0;
        //while going to upper functions calls
        //changings the changes made in this path
        //make it as original for new call
        //clearing the changes made in path
    }
}
