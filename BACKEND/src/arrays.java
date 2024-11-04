public class arrays {
    public static void main(String[]args){
        //ARRAYS are forms of storng data of the same type
        //single dimensional arrays contain one row and many columns
        int data[]={5,6,7,8};
        System.out.println(data[2]);
        for(int i=0;i<4;i++){
            System.out.print(data[i]);
        }
        // 2D array with 2 rows and 3 columns
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

// Accessing an element
        System.out.println(matrix[0][0]);  // Output: 2 (first row, second column)

    }
}
