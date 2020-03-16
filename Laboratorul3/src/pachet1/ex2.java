package pachet1;

public class ex2 {
    public static void main(String[] args) {
        char[] chars = {'j', 'a', 'v', 'a'};
        for(char c : chars) {
            System.out.println(c);
        }
        System.out.println(chars);

        int[][] intMatrix = new int[3][3];
        intMatrix[0][0] = 0;
        intMatrix[2][2] = 22;
        for(int i[] : intMatrix) {
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        char[][] multidiCharArray = {{'c'}, {'2'}, {'j', 'a', 'v', 'a'}};
        System.out.println(multidiCharArray);

        int [][] ints = new int[3][];
        ints[0] = new int[2];
        ints[0][0] = 1;
        ints[0][1] = 2;
        ints[1] = new int[]{4, 5, 67};
        ints[2] = new int[]{33, 44};
        displayArrayValues(ints);

    }

    private static void displayArrayValues(int[][] input){
        for(int[] i : input) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
