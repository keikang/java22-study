import java.util.Arrays;
import java.util.List;

public class Unnamed {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList(new String[]{"a", "b", "c"});
        int totalCnt = 0;
        for (String str : strList){
            totalCnt++;
        }

        System.out.println("list의 길이는 : "+strList.size());
    }
}
