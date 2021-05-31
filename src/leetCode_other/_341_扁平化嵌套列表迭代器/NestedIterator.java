package leetCode_other._341_扁平化嵌套列表迭代器;
/*

import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("all")
public class NestedIterator implements Iterator<Integer> {

    LinkedList<NestedInteger> result;

    public NestedIterator(List<NestedInteger> nestedList) {
        result = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return result.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!result.isEmpty() && !result.getFirst().isInteger()) {
            List<NestedInteger> list = result.removeFirst().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                result.addFirst(list.get(i));
            }
        }
        return !result.isEmpty();
    }
}
*/
