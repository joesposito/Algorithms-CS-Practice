public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a){
        int count = 0;

        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] > a[j]){
                    count++;
                }
            }
        }

        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k){
        int indexCount = 0;
        int length = n;
        int[] arr = new int[n];
        n--;
        long remainingInversions = k;

        for(;n >= 0; n--){
            //System.out.println("n:" + n + " rI:" + remainingInversions);
            if(n <= remainingInversions){
                arr[indexCount] = n;
                indexCount++;
                remainingInversions -= n;
            }else{
                break;
            }
        }

        System.out.println(indexCount);
        int m = length - indexCount;
        for(int i = 0; i < m; i++){
            arr[indexCount] = i;
            indexCount++;
        }
        return arr;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] test = generate(10, 20);
        System.out.println(count(test));

        for(int i : test) {
            System.out.print(i + " ");
        }
    }
}