package RainyUniverse;

public class L6028 {
    public int countCollisions(String directions) {
        int[] arr = new int[directions.length() + 2];
        int res = 0;
        for(int i = 0; i < directions.length(); i++){
            if(directions.charAt(i) == 'L'){
                if(arr[i] != 0){
                    res = res + 1;
                    arr[i + 1] = arr[i + 1] + 1;
                    continue;
                }else if(arr[i + 1] != 0){
                    res = res + 2;
                    arr[i + 1] = arr[i + 1] + 1;
                    continue;
                }
                arr[i] = arr[i] + 1;
            }else if(directions.charAt(i) == 'S'){
                if(arr[i + 1] != 0){
                    res = res + 1;
                }
                arr[i + 1] = arr[i + 1] + 1;
            }else if(directions.charAt(i) == 'R'){
                int flag = 0;
                for(int j = i + 1; j < directions.length(); j++){
                    if(directions.charAt(j) == 'R'){
                        continue;
                    }else if(directions.charAt(j) == 'L'){
                        flag = j;
                    }else if(directions.charAt(j) == 'S'){
                        break;
                    }
                }

                if(flag != 0){
                    for(int j = i + 1; j < flag; j++){
                        arr[j + 1] = arr[j + 1] + 1;
                        res = res + 1;
                        i = j;
                    }
                }
                arr[i + 2] = arr[i + 2] + 1;
            }
        }
        return res;
    }
}
