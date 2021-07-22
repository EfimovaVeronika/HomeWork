package ru.geekbrains.java2_lesson2;

public class MainHomeWork {
    public static void main(String[] args) {

        try {
            String[][] array = {{"2", "2", "2", "2"},
                    {"2", "2", "2", "2"},
                    {"2", "2", "2fdg", "2"},
                    {"2", "2", "2", "2"}};

            System.out.println(arrayFromStrToSumNum(4, array));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Catch them all!!!");
        }
    }


    public static int arrayFromStrToSumNum(int requiredArraySize, String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (array.length != requiredArraySize) {
            throw new MyArraySizeException(requiredArraySize);
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != requiredArraySize) {
                    throw new MyArraySizeException(requiredArraySize);
                }
                else {
                    for (int j = 0; j < array[i].length; j++) {
                        try {
                            sum += Integer.parseInt(array[i][j]);
                        }
                        catch (NumberFormatException e) {
                            throw new MyArrayDataException(i, j);
                        }
                    }
                }
            }
        }

        return sum;
    }
}
