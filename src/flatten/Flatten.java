package flatten;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luke
 */
public class Flatten {

    public static List<Integer> flatten(Object[] nestedNums) {

        if (nestedNums == null) {
            return null;
        }

        List<Integer> flatNums = new ArrayList<>();

        for (Object element : nestedNums) {
            if (element instanceof Integer) {
                flatNums.add((Integer) element);
            } else {
                flatNums.addAll(flatten((Object[]) element));
            }
        }
        return flatNums;
    }
    
    
}

