class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        if(arr.length ==0 || arr == null){
            return 0;
        }
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        for(int i =0; i < arr.length;i++){
            long count =1;
            for(int j =0; j<i;j++){
                if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j])){
                    count += map.get(arr[j])*map.get(arr[i]/arr[j]);
                }
            }
            map .put(arr[i], count);
        }
        long totalcount =0;
        for(Map.Entry<Integer, Long> entry: map.entrySet()){
            totalcount += entry.getValue();
            System.out.println("k"+entry.getKey()+"v"+entry.getValue());
        }
        return (int)(totalcount%(1000000007));
    }
}