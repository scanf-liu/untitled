package leetCode._347_前K个高频元素;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //建立哈希表（字典），以键值对的形式存储数字和频次
        Map<Integer,Integer> map=new HashMap<>();
        int[] res=new int[k];
        for(int num:nums){
            //如果字典中已经存储了数字，则说明数字不是第一次出现，将其频次加1
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{//否则，其是第一次出现，频次为1
                map.put(num,1);
            }
        }
        //建立优先队列（小根堆），通过Comparator自定义排序算法
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){//根据数字的频次进行排序
                return map.get(a)-map.get(b);
            }
        });
        for(Integer key:map.keySet()){//遍历字典的键
            if(queue.size()<k){//如果队列的规模小于k，直接入队
                queue.add(key);
            }else if(map.get(key)>map.get(queue.peek())){//否则与队列中频次最小的数进行比较
                queue.poll();//若队列中频次最小的数比该数字的频次小，则将其出队，将当前数字入队
                queue.add(key);
            }
        }
        int i=0;
        while(!queue.isEmpty()){
            res[i++]=queue.poll();
        }
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        //建立哈希表（字典），以键值对的形式存储数字和频次
        Map<Integer,Integer> map=new HashMap<>();
        int[] res=new int[k];
        for(int num:nums){
            //如果字典中已经存储了数字，则说明数字不是第一次出现，将其频次加1,否则，其是第一次出现，频次为1
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>[] list=new List[nums.length+1];//用list作为一个桶
        for(int num:map.keySet()){//将数字的频次i作为桶的索引index
            int i=map.get(num);
            if(list[i]==null){//如果桶还没“建立”,就建立一个列表作为桶
                list[i]=new ArrayList();
            }
            list[i].add(num);//将频次为i的数字num放入桶中
        }
        int i=0,t,j;
        for(t=nums.length;t>0;t--){//从索引高到低依次遍历每个桶，如果桶不空，则取数直至取出前k个数
            if(list[t]!=null){
                for(j=0;j<list[t].size()&&i<k;j++)
                {
                    res[i++]=list[t].get(j);
                }
            }
        }
        return res;
    }


}
