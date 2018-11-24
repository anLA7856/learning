package com.anla.spare;

/**
 * @user anLA7856
 * @time 18-11-23 下午10:41
 * @description 深度搜索项目，找到最大值
 */
public class FindMaxWay {

    private int allSteps;
    private int[][] border = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args){
        FindMaxWay findMaxWay = new FindMaxWay();

        int[][] grid = new int[8][6];
        findMaxWay.init(grid);
        findMaxWay.allSteps = findMaxWay.allSteps(grid);
        findMaxWay.run(grid,4,5, 0);

    }

    /**
     * 寻找过程
     * @param grid
     */
    private void run(int[][] grid, int startX, int startY, int step) {

        if(step == this.allSteps){
            System.out.println("find ways!");
            for (int i = 0; i < grid.length;i++)
                for (int j = 0;j < grid[i].length;j++){
                    System.out.print(grid[i][j] + "");
                }
                System.out.println();

            return;
        }

        for(int i=0;i<4;i++)    // 上下左右顺序
        {

            int nextX = startX+this.border[i][0];
            int nextY = startY+this.border[i][1];
            if(testPoint(grid, nextX, nextY))//判断下一个要走的点是否合法，在迷宫的题目里面主要是判断转移的点能不能走
            {
                grid[startX][startY] = 2;
                run(grid, nextX,nextY, step+1);//进一步搜索
                grid[startX][startY] = 0;
            }
        }

    }

    private int allSteps(int[][] grid) {
        int sum = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[i].length;j++){
                if (grid[i][j] == 0){
                    sum ++;
                }
            }
        }
        return sum;
    }

    private boolean testPoint(int[][] grid, int startX, int startY) {
        int lengthX = grid.length;
        int lengthY = grid[0].length;
        if (startX >= 0 && startX < lengthX && startY >=0 && startY<lengthY && grid[startX][startY] != 1 && grid[startX][startY] != 2) {
            return true;
        }
        return false;
    }


    /**
     * 设置数组初始值
     * 2为墙，1为起始点
     * @param grid
     */
    private void init(int[][] grid) {
        grid[4][5] = 1;
        grid[4][4] = 2;
        grid[5][5] = 2;
        grid[2][2] = 2;
        grid[2][3] = 2;
        grid[5][0] = 2;
        grid[5][3] = 2;
    }


}
