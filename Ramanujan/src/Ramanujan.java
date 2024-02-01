public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n){
        //a is the max value
        int a = (int)Math.cbrt((double)n);
        int count = 0;
        int[] arr = new int[4];

        for(int i = 1; i <= a; i++){
            for(int j = i + 1; j <= a; j++){
                if((i * i * i) + (j * j * j) == n){
                    if(count >= 4){
                        return false;
                    }

                    arr[count] = i;
                    count++;
                    arr[count] = j;
                    count++;
                    i++;
                }
            }
        }

        if(arr[0] * arr[0] * arr[0] + arr[1] * arr[1] * arr[1] == n && arr[2] * arr[2] * arr[2] + arr[3] * arr[3] * arr[3]
            == n){
            return true;
        }

        return false;
    }
}