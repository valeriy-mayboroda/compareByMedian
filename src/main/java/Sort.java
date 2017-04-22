import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by val on 22.04.2017.
 */
public class Sort {
    public static void main(String[] args) {
        Integer[] a = {13, 8, 15, 5, 17};
        for (Integer i : a)
            System.out.print(i + " ");
        System.out.println();
        a = sort(a);
        for (Integer i : a)
            System.out.print(i + " ");
        System.out.println();
    }
    public static Integer[] sort(Integer[] array) {
        //implement logic here

        //Сортировка по возрастанию (от минимального до максимального значения)
        Comparator<Integer> compareByMin = new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return a-b;
            }
        };
        Arrays.sort(array, compareByMin);//Collections.sort(list, compareByMin)

        //Ищем медиану
        /*
        (Медиана ищется отбрасыванием наименьшего и наибольшего чесел в списке, это не среднее арифметическое)
        Массив отсортирован по возрастанию - медиана массива в центре
        Если длина массива нечетная - медиана определена и находится в центре
        Если длина массива четная - медиана = среднее арифметическое 2х чисел в центре и приводим к int
         */
        int size = array.length;
        final int median = size > 1 ?
                (size % 2 == 0 ? (array[size/2-1] + array[size/2])/2 : array[size/2])
                : array[0];

        //Сортировка по возрастанию от медианы
        Comparator<Integer> compareByDelta = new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                int deltaA = Math.abs(a-median);
                int deltaB = Math.abs(b-median);
                if (deltaA == deltaB) //Если удаленность от медианы одинаковая - в порядке возрастания
                    return a-b;
                else return deltaA-deltaB;//В порядке возрастания от медианы
            }
        };
        Arrays.sort(array, compareByDelta);

        return array;
    }
}
