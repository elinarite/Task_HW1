package task_140223;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HW2 {

    public static void main(String[] args) {

        // 1 решение
        int[] nums = {1, 8, 7, 6, 4, 2, 7, 5,};
        getMin3(nums);
        // 2 решение
        int[] arr = new int[]{0, 1, 5, 4, 8, 9, 3, 2, 6};
        int sum = 13;
        getTwoNumbers(arr, sum);
        // 3 решение
        int[] arrDouble = new int[]{1, 4, 6, 2, 7, 8, 3, 2, 9, 3, 4};
        getDuplicated(arrDouble);
        // 4 решение
        int[] a = new int[]{1, 1, 5, 4, 1, 9, 2, 4, 6};
        int n = 11;
        System.out.println(getMinSequence(a, n));
        // 5 решение
        String s = "AAASSDDFFRRTGGBNHYUUU";
        System.out.println(getNewString(s));
        // 6 решение
        int[] numbers = {5, 3, 5, 6, 6, 3, 4};
        getUniqueNumber(numbers);
        //7 решение
        int[] arrNum = {1, 0, 2, 8, 6, 5, 4, 7};
        System.out.println(getMissingNumber(arrNum));

        //8 решение
        int[] arrDivide = new int[]{128, 226, 34, 47, 5};
        getNumberDivideSelbst(arrDivide);

        //9 решение
        for (int[] row : spiral(7, 8)) {
            System.out.println(Arrays.toString(row));
        }
    }

    //метод для 1 решения
    public static void getMin3(int nums[]) {
        //   найти 3 и 4 минальный элемент
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        if (nums.length > 4) {
            for (int i = 0; i < nums.length; ++i) {

                if (nums[i] < min1) {
                    min4 = min3;
                    min3 = min2;
                    min2 = min1;
                    min1 = nums[i];
                } else if (nums[i] < min2) {
                    min4 = min3;
                    min3 = min2;
                    min2 = nums[i];
                } else if (nums[i] < min3) {
                    min4 = min3;
                    min3 = nums[i];
                } else if (nums[i] < min4) {
                    min4 = nums[i];
                }
            }
            System.out.println(Arrays.toString(nums));
            System.out.println("min3 " + min3 + " min4 " + min4);
        } else {
            System.out.println("массив меньше");

        }

    }

    //метод для 2 решения
    public static void getTwoNumbers(int[] numbers, int n) {
        //Дан массив и число. Вывести на экран два любых числа из массива которые
        //в сумме дают n за O(n) либо написать что таких чисел нет
        //[0 1 5 4 8 9 3 2 6] n = 13
        //** все пары чисел
        int a = 0;
        int b = 0;
        Set<Integer> set = new HashSet<>(numbers.length);
        for (int value : numbers) {
            a = value;
            b = n - value;
            if (!set.contains(b)) {
                set.add(a);
            } else {
                System.out.println("First number is: " + value + ", Second number is: " + b);
            }

        }
    }

    //метод для 3 решения
    public static void getDuplicated(int[] nums) {
        //вам необходимо проверить массив на наличие повторений чисел

        Set<Integer> foundStrings = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int value : nums) {
            if (foundStrings.contains(value)) {
                duplicates.add(value);
            } else {
                foundStrings.add(value);
            }
        }
        System.out.println(duplicates);
    }

    //метод для 4 решения
    public static int getMinSequence(int[] nums, int s) {
        //[1 1 5 4 1 9 2 4 6] n = 11
        //вернуть длину минимальной последовательности
        //которая в сумме дает n
        //в массиве все числа положительные
        int result = Integer.MAX_VALUE;
        int left = 0;
        int valSum = 0; // 1 2 7 11

        for (int i = 0; i < nums.length; i++) {
            // [1 4 5 4 1 1 9 2 4 6 11] s = 11
            valSum += nums[i]; //valSum = valSum + nums[i]

            while (valSum >= s) {
                result = Math.min(result, (i + 1) - left);
                valSum = valSum - nums[left];
                left++;
            }
        }
        return (result == Integer.MAX_VALUE ? 0 : result);
    }

    //метод для 5 решения
    public static String getNewString(String s) {
        //AAASSDDFFRRTGGBNHYUUU -> 3A2S2D2F2R1T2G1B1N1H1Y3U
        //**ДОБАВИТЬ ПРОВЕРКУ
        char[] chr = s.toCharArray();
        String b = "";
        for (int i = 0; i < chr.length - 1; i++) {
            if (Character.isDigit(chr[i])) {
                System.out.println("Invalid character entered: ");
                break;
            } else {
                System.out.print((s.lastIndexOf(chr[i]) - s.indexOf(chr[i]) + 1) + "" + chr[i]);
                i += (s.lastIndexOf(chr[i]) - s.indexOf(chr[i]));
            }
        }
        return "";
    }

    //метод для 6 решения
    public static void getUniqueNumber(int[] nums) {
        //Дан массив чисел в котором все числа имеют повторения
        // кроме одного числа. Найти это число
        int result = 0;
        for (int a : nums) {
            result = result ^ a; // result ^= a
        }
        System.out.println(result);
    }

    //метод для 7 решения
    public static int getMissingNumber(int[] arr) {
        //Дан массив чисел, в котором есть все числа от 0 до N .
        // Все эти числа в единственном экземпляре. Расположены в разнобой.
        // Одно число в этом массиве пропущено ( Например {1 0 2 8 6 5 4 7} - это 3 ) .
        // Найти пропущенное число
        int result = 0;
        for (int a : arr)
            result ^= a;
        for (int i = 0; i < arr.length + 1; i++) {
            result ^= i;
        }
        return result;
    }

    //метод для 8 решения
    public static void getNumberDivideSelbst(int[] arr) {
        //  Дан массив чисел. Найти число состоящее из собственных делителей.
        //  Например число 128 состоит из 1 2 и 8. 128 % 1 == 0 , 128 % 2 == 0 и 128 % 8 == 0.
        //  Вот такие числа надо найти.
        int k;
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            String s = String.valueOf(arr[i]);
            char[] charrArr = s.toCharArray();
            for (int j = 0; j < charrArr.length; j++) {
                k = Character.digit(charrArr[j], 10);
                if (arr[i] % k == 0) {
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("Число " + arr[i] + " не подошло");
                flag = false;
            } else {
                System.out.println("Число " + arr[i] + " подошло");
            }
        }
    }

    //метод для 9 решения
    public static int[][] spiral(int rows, int cols) {
//      4.  Ну и для особо отличившихся. Написать метод который
//генерирует двумерный массив длиной N и высотой H
//Далее заполняет получившийся массив числами от 1 до W по спирали.
//Например массив [ ][ ][ ][ ]
//                        [ ][ ][ ][ ]
//                        [ ][ ][ ][ ]
//имеет N == 4 and H == 3 и вид [ 1 ][ 2 ][ 3 ][ 4 ]
//                                             [10][11][12 ][ 5 ]
//                                             [ 9 ][ 8 ][ 7 ][ 6 ]
        int[][] arr = new int[rows][cols];

        int num = 1;
        int max = rows * cols;
        int rmin = 0;
        int cmin = 0;
        int rmax = rows - 1;
        int cmax = cols - 1;
        System.out.println("-----" + rows + " x " + cols + "-----");
        while (num <= max) {
            for (int i = cmin; num <= max && i <= cmax; i++) {
                arr[rmin][i] = num++;
            }
            rmin++;
            for (int i = rmin; num <= max && i <= rmax; i++) {
                arr[i][cmax] = num++;
            }
            cmax--;
            for (int i = cmax; num <= max && i >= cmin; i--) {
                arr[rmax][i] = num++;
            }
            rmax--;
            for (int i = rmax; num <= max && i >= rmin; i--) {
                arr[i][cmin] = num++;
            }
            cmin++;
        }
        return arr;
    }
}








