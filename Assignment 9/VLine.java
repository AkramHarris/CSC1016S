// HRRAKR001
// Akram Harris
// 18/10/2024

class VLine extends VectorObject { // A child class of vectorobject
    private int length;

    VLine(int id, int x, int y, int length) { // A Vline constructor that has a length component
        super(id, x, y);
        this.length = length;
    }

    @Override
    public void draw(char[][] matrix) { // The draw method
        
        for (int i = y; i < y + length && i < matrix.length; i++) { // It goes through the matrix and uses the y co-ord as reference to print vertical lines
            matrix[i][x] = '*';
        }
    }
}
