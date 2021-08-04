import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Generator
 *
 * 
 */
public class Generator extends Actor
{
    static final int WALL = 1;
    static final int MAZE_PATH = 0;
    int rows;
    int cols;
    int act_rows;
    int act_cols;
    int[][] board;
    
    public Generator(int row, int col)
    {
        rows = row*2+1;
        cols = col*2+1;
        act_rows = row;
        act_cols = col;
        board = new int[rows*3][cols*3];
        for(int i=0; i<rows; i++){
            board[i][0] = WALL;
            board[i][cols-1] = WALL;
        }

        for(int i=0; i<cols; i++){
            board[0][i] = WALL;
            board[rows-1][i] = WALL;
        }
    }

    public void makeMaze()
    {
        makeMaze(0,cols-1,0,rows-1);
    }

    
    private void makeMaze(int left, int right, int top, int bottom)
    {
        int width = right-left;
        int height = bottom-top;
        if(width > 2 && height > 2){

            if(width > height)
                divideVertical(left, right, top, bottom);

            else if(height > width)
                divideHorizontal(left, right, top, bottom);

            else if(height == width){
                Random rand = new Random();
                int pickOne = Greenfoot.getRandomNumber(2);

                if(pickOne==1)
                    divideVertical(left, right, top, bottom);
                else
                    divideHorizontal(left, right, top, bottom);
            }
        }else if(width > 2 && height <=2){
            divideVertical(left, right, top, bottom);
        }else if(width <=2 && height > 2){
            divideHorizontal(left, right, top, bottom);
        }
    }

    private void divideVertical(int left, int right, int top, int bottom)
    {
        Random rand = new Random();
        int divide =  left + 2 + rand.nextInt((right-left-1)/2)*2;
        for(int i=top; i<bottom; i++){
            board[i][divide] = WALL;
        }
        int clearSpace = top + rand.nextInt((bottom-top)/2) * 2 + 1;
        board[clearSpace][divide] = MAZE_PATH;     
        makeMaze(left, divide, top, bottom);
        makeMaze(divide, right, top, bottom);
    }

    private void divideHorizontal(int left, int right, int top, int bottom)
    {
        Random rand = new Random();
        int divide =  top + 2 + rand.nextInt((bottom-top-1)/2)*2;
        if(divide%2 == 1)
            divide++;

        for(int i=left; i<right; i++){
            board[divide][i] = WALL;
        }
        int clearSpace = left + rand.nextInt((right-left)/2) * 2 + 1;
        board[divide][clearSpace] = MAZE_PATH;
        makeMaze(left, right, top, divide);
        makeMaze(left, right, divide, bottom);
    }

    public int[][] getMaze(){
        return board;
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public int[] getRandomEmptyPosition()
    {
        int x=0,y=0;
        int[] xy = new int[2];
        x=Greenfoot.getRandomNumber(getRows());
        y=Greenfoot.getRandomNumber(getCols());        
        while(board[x][y]!=0)
        {
            x=Greenfoot.getRandomNumber(getRows());
            y=Greenfoot.getRandomNumber(getCols());
        }
        board[x][y]=3;
        xy[0]=x;
        xy[1]=y;
        return xy;
    }
    
    }
