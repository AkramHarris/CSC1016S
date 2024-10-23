// HRRAKR001
// Akram Harris
// 18/10/2024
class PtLine extends VectorObject { // PtLine is a child class of vectorobject
    private int x1, y1;

    public PtLine(int id, int x, int y, int x1, int y1) { // PtLine constructor
        super(id, x, y);
        this.x1 = x1; // x and y represent the endpoints of the line
        this.y1 = y1;
    }

    @Override
    public void draw(char[][] matrix) { // The draw method uses Bresenham's Line Algorithm
        int dx = Math.abs(x1 - x); // dx and dy represent the absolute difference between the endpoints
        int dy = Math.abs(y1 - y); 
        int sx = x < x1 ? 1 : -1; // sx and sy are step values that are used for the direction of x and y
        int sy = y < y1 ? 1 : -1; // The '?' is a ternary operator i used to write less code and compact a if statement
        int err = dx - dy; // The err is an error term in Bresenhams algorithm to decide where to move to make a straight line

        int cx = x; // The current co-ord 
        int cy = y;
        while (true) {
            if (cx >= 0 && cx < matrix[0].length && cy >= 0 && cy < matrix.length) {
                matrix[cy][cx] = '*'; // If the current point is in the matrix and plots it
            }
            if (cx == x1 && cy == y1) break; // When the current point reaches the endpoint, break the loop
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; cx += sx; } // if the err is greater than -dy then it moves in x direction
            if (e2 < dx) { err += dx; cy += sy; } // if the err is greater than dx then it moves in y direction
        }
    }
}
