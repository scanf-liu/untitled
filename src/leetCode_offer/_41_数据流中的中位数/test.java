package leetCode_offer._41_数据流中的中位数;

public class test {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(11);
        obj.addNum(111);
        System.out.println(obj.findMedian());
        obj.addNum(111);
        System.out.println(obj.findMedian());

    }
}
