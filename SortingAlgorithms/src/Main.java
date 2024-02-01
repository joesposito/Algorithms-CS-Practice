import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Integer[] inte = {9, 8 , 7 , 6, 5, 4};
        bubbleSort(inte);

        for(Integer i: inte){
            System.out.println(i);
        }

        System.out.println();
        Integer[] inte2 = {10, 9, 5, 4, 3, 2};
        bubbleSort(inte2, Integer::compareTo);

        for(Integer i: inte2){
            System.out.println(i);
        }

        System.out.println();

        Integer[] inte3 = {10, 9, 9, 99, 27, 44, 21, 9, 45};
        mergeSort(inte3);


        for(Integer i: inte3){
            System.out.println(i);
        }

        System.out.println();

        Integer[] inte4 = {10, 9, 5, 4, 3, 2, 9, 99, 27, 44, 21, 9, 45, 11, 23, 12, 19284, 4241};
        mergeSort(inte4, Collections.reverseOrder());


        for(Integer i: inte4){
            System.out.println(i);
        }

        System.out.println();
        Integer[] inte5 = {10, 9, 9, 99, 27, 44, 21, 9, 45, 213, 2, 44, 53553, 0, -425245};
        quickSort(inte5);

        for(Integer i: inte5){
            System.out.print(i + ", " );
        }

        System.out.println();
        Integer[] inte6 = {10, 9, 9, 99, 27, 44, 21, 9, 45, 213, 2, 44, 53553, 0, -425245};
        quickSort(inte6, Collections.reverseOrder());

        for(Integer i: inte6){
            System.out.print(i + ", " );
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        boolean swaps = true;
        for(int i = 1; i < list.length; i++){
            for(int j = 0; j < list.length - i && swaps; j++) {

                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                } else {
                    swaps = false;
                }
            }
        }
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator){
        boolean swaps = true;
        for(int i = 1; i < list.length; i++){
            for(int j = 0; j < list.length - i && swaps; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                } else {
                    swaps = false;
                }
            }
        }
    }
    
    public static <E extends Comparable<E>> void mergeSort(E[] list){
        if(list.length <= 1){
            return;
        }

        E[] s1 = (E[]) new Comparable[list.length/2];
        System.arraycopy(list, 0 , s1, 0, list.length/2);
        mergeSort(s1);

        E[] s2 = (E[]) new Comparable[list.length - list.length/2];
        System.arraycopy(list, list.length/2, s2, 0, s2.length);
        mergeSort(s2);
        merge(s1, s2, list);
    }
    public static <E extends Comparable<E>> E[] merge(E[] list1, E[] list2, E[] list){
        int i = 0;
        int j = 0;

        while(i + j != list.length - 1){
            if(list1[i].compareTo(list2[j]) > 0){
                list[i + j] = list2[j];
                j++;
            }else{
                list[i + j] = list1[i];
                i++;
            }

            if(i == list1.length){
                System.arraycopy(list2, j, list, i + j, list.length - i - j);
                return list;
            }else if(j == list2.length){
                System.arraycopy(list1, i, list, i + j, list.length - i - j);
                return list;
            }
        }

        return null;
    }

    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator){
        if(list.length <= 1){
            return;
        }

        E[] s1 = (E[]) new Comparable[list.length/2];
        System.arraycopy(list, 0 , s1, 0, list.length/2);
        mergeSort(s1, comparator);

        E[] s2 = (E[]) new Comparable[list.length - list.length/2];
        System.arraycopy(list, list.length/2, s2, 0, s2.length);
        mergeSort(s2, comparator);
        merge(s1, s2, list, comparator);
    }

    public static <E> E[] merge(E[] list1, E[] list2, E[] list, Comparator comparator){
        int i = 0;
        int j = 0;

        while(i + j != list.length - 1){
            if(comparator.compare(list1[i], list2[j]) > 0){
                list[i + j] = list2[j];
                j++;
            }else{
                list[i + j] = list1[i];
                i++;
            }

            if(i == list1.length){
                System.arraycopy(list2, j, list, i + j, list.length - i - j);
                return list;
            }else if(j == list2.length){
                System.arraycopy(list1, i, list, i + j, list.length - i - j);
                return list;
            }
        }

        return null;
    }

    public static <E extends Comparable<E>> void quickSort(E[] list) {
        if(list.length <= 1) {
            return;
        }

        quickSort(list, 0, list.length - 1);
    }

    public static <E extends Comparable<E>> int partition(E[] list, int min, int max){
        if(max < min){
            return min;
        }

        int low = min + 1;
        int high = max;
        int pivot = min;

        while(high >= low) {
            if (list[high].compareTo(list[pivot]) >= 0 && high >= low) {
                high--;
            }

            if (list[low].compareTo(list[pivot]) <= 0 && high >= low) {
                low++;
            }

        if (high >= low && list[high].compareTo(list[pivot]) < 0 && list[low].compareTo(list[pivot]) >= 0) {
                E temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }

      }

        E temp = list[high];
        list[high] = list[pivot];
        list[pivot] = temp;
        pivot = high;
        return pivot;
    }

    public static <E extends Comparable<E>> void quickSort(E[] list, int min, int max){
        if(max < min){
            return;
        }

        int pivot = partition(list, min, max);
        quickSort(list, min, pivot - 1);
        quickSort(list, pivot + 1, max);
    }

    public static <E> void quickSort(E[] list, Comparator<? super E> comparator){
        if(list.length <= 1) {
            return;
        }

        quickSort(list, 0, list.length - 1, comparator);
    }


    public static <E> int partition(E[] list, int min, int max, Comparator comparator){
        if(max < min){
            return min;
        }

        int low = min + 1;
        int high = max;
        int pivot = min;

        while(high >= low) {
            if (comparator.compare(list[high], list[pivot]) >= 0 && high >= low) {
                high--;
            }

            if (comparator.compare(list[low], list[pivot]) <= 0 && high >= low) {
                low++;
            }

            if (high >= low && comparator.compare(list[high], list[pivot]) < 0 && comparator.compare(list[low], list[pivot]) >= 0) {
                E temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }

        }

        E temp = list[high];
        list[high] = list[pivot];
        list[pivot] = temp;
        pivot = high;
        return pivot;
    }

    public static <E> void quickSort(E[] list, int min, int max, Comparator comparator){
        if(max < min){
            return;
        }

        int pivot = partition(list, min, max, comparator);
        quickSort(list, min, pivot - 1, comparator);
        quickSort(list, pivot + 1, max, comparator);
    }
}