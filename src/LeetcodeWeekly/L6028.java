package LeetcodeWeekly;

public class L6028 {
    public static void main(String[] args) {
        System.out.println(countCollisions("RRRRRRL"));
        System.out.println(countCollisions2("RRRRRRL"));
    }

    public static int countCollisions(String directions) {
        char[] dire = directions.toCharArray();
        int count = 0;
        int colNum = 1;
        while (colNum > 0) {
            colNum = 0;
            for (int i = 0; i < dire.length - 1 ; i++) {
                if (dire[i] == 'R' && dire[i + 1] == 'S') {
                    count++;
                    dire[i] = 'S';
                    colNum++;
                } else if (dire[i] == 'R' && dire[i + 1] == 'L') {
                    count += 2;
                    dire[i] = 'S';
                    dire[i + 1] = 'S';
                    colNum++;
                } else if (dire[i] == 'S' && dire[i + 1] == 'L') {
                    count++;
                    dire[i + 1] = 'S';
                    colNum++;
                }
            }
        }
        return count;
    }

    static int count = 0;
    static char[] dire;
    public static int countCollisions2(String directions) {
        dire = directions.toCharArray();
        for (int i = 0; i < dire.length - 1 ; i++) {
            calculateCol(i, i + 1);
        }
        for (int i = dire.length - 1; i > 0; i--) {
            calculateCol(i - 1, i);
        }
        return count;
    }

    public static void calculateCol(int pre, int post) {
        if (dire[pre] == 'R' && dire[post] == 'S') {
            count++;
            dire[pre] = 'S';
        } else if (dire[pre] == 'R' && dire[post] == 'L') {
            count += 2;
            dire[pre] = 'S';
            dire[post] = 'S';
        } else if (dire[pre] == 'S' && dire[post] == 'L') {
            count++;
            dire[post] = 'S';
        }
    }
}
