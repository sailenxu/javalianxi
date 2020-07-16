package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LianXi {
    //1.从键盘输入一个字符串，全部转为大写，并输入到一个txt文本中
    public void inputToUp() throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(br.readLine().toUpperCase());
        }
    }
    //2.两篇英文文章，找出在A中存在B中不存在的单词，怎么去重
    public void Finddefferent(){
        String a="China as the most important quality sign for the international Chinese outbound market.I am Chinese.";
        String b="I am come from China";
        StringTokenizer tokenizer = new StringTokenizer(a, ",. ");//将a拆开，放到单词数组中
        String[] arr = new String[tokenizer.countTokens()];
        int i=0;
        while (tokenizer.hasMoreTokens()){
            arr[i] = tokenizer.nextToken();
            i++;
        }
        for (int j=0; j<arr.length; j++){
            if (!b.contains(arr[j])){
                System.out.println(arr[j]);
            }
        }
    }
    //3.将字符串中的aeiou字符去掉
    public void delChar(){
        String a="I have a student";
        String b = "aeiou";
        char cc[] = a.toCharArray();
        char dd[] = b.toCharArray();
        String out="";
        for (int j=0; j<cc.length; j++){
            for (int i=0; i<dd.length; i++){
                if (cc[j]==dd[i]){
                    break;
                }
                if (i==dd.length-1){
                    out=out+cc[j];
                }
            }
        }
        System.out.println(out);
    }
    //1.6判断字符串是否是ipv4地址
    public boolean isIpv4(String str) {
        System.out.println(str);
        if (str.length()==0 && str == null) return false;
        String split[] = str.split("\\.");
        //按照.分开，因为ipv4可以分成4个,java需要加转移字符！！！
        System.out.println(Arrays.toString(split));
        if (split.length == 4) {
            //第一个在1-255之间，不能为0，剩下每组都在0-255之间才对
            if (Integer.valueOf(split[0]) > 0 && Integer.valueOf(split[0]) <= 255) {
                for (String s:split) {
                    if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255) {
                    }else{
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LianXi lianXi = new LianXi();
        System.out.println(lianXi.isIpv4("1.0.0.0"));
    }
    //4.算法题：5元/只，3元/只，3只/元，100元买100只，算出所有方法结果
    public void meth(){
        for (int x=0; x<=20; x++){
            for (int y=0; y<=33; y++){
                int z=100-x-y;
                if (z%3==0&&(5*x+3*y+z/3==100)){
                    System.out.println("x:"+x+",y:"+y+",z:"+z);
                }
            }
        }
    }
    //5.冒泡排序，从大到小
    public void maopao(){
        int arr[] = {23,5,1,6,8,0};
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length-1; j++){
                if (arr[j]<arr[j+1]){
                    int k=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=k;
                }
            }
        }
        for (int m:arr){
            System.out.println(m);
        }
    }
    //6.快速排序
    public int getPivot(int arr[], int left, int right) {
        int tmp = arr[left];//设定最左侧的为tmp,从最右侧开始找比tmp小的
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];//找到比tmp小的，空出坑来，把值挪到left
            //然后从左侧找比tmp大的
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];//找到比tmp大的，空出坑来，把值给上面的right坑
        }
        //当left=right，这个坑没东西了，放入tmp，这样数组顺序分成了两边，左边比tmp小，右边比tmp大，tmp作为基准点，两边的数组再次递归排序
        arr[left] = tmp;
        System.out.println(Arrays.toString(arr));
        return left;
    }
    public void kuaipai(int arr[], int left, int right) {
        if (left >= right) return;
        int pivot = getPivot(arr, left, right);
        kuaipai(arr, left, pivot-1);
        kuaipai(arr, pivot+1, right);
    }

//    public static void main(String[] args) {
//        LianXi lianXi = new LianXi();
//        lianXi.kuaipai(new int[]{6,2,7,3,8}, 0, 4);
//    }
//    public static void main(String[] args) {
//        LianXi lianXi = new LianXi();
//        int aa[]={5,4,7,2,9};
//        lianXi.quickSort(aa,0,4);
//        for (int a:aa){
//            System.out.print(a+":");
//        }
//    }
    //7.堆排序shendu
    //8.归并排序
    public void guibing(int arr[], int left, int right){
        //拆分
        if (left>=right) return;
        int mid = left+(right-left)/2;
        guibing(arr, left, mid);
        guibing(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    //比较大小后合并
    private void merge(int[] arr, int left, int mid, int right) {
        System.out.println("lef:" +left+":mid:"+mid+":right:"+right);
        int s1 = left;//第一个的开始
        int s2 = mid+1;//第二个数组归并的开始
        int temp[] = new int[right-left+1];//创建一个新数组，来存储排序后的值
        int i = 0;//数组索引index
        //依次对比两个归并中的值
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] <= arr[s2]){
                temp[i] = arr[s1]; i++; s1++;
            }else {
                temp[i] = arr[s2]; i++; s2++;
            }
        }
        //while执行完，还会剩下s1或s2没放入temp，需要单独的将剩下的放入temp
        while (s1 <= mid) {
            temp[i] = arr[s1]; i++; s1++;
        }
        while (s2 <= right) {
            temp[i] = arr[s2]; i++; s2++;
        }
        //temp已经是合并后的数组了，要将temp放入arr
        for (int j = 0;j<temp.length;j++) {
            arr[j+left] = temp[j];
        }
        System.out.println(Arrays.toString(arr));
    }
    //9.斐波那契数列，n是前两个数的和，求n
    public int fb(int n){
        if (n<1){
            return 0;
        }else if (n==1){
            return 1;
        }else {
            return fb(n-1)+fb(n-2);
        }
    }
    public int fb2(int n){
        int f0=0;
        int f1=1;
        int f2=0;
        if (n==1){
            return 1;
        }else if (n<1){
            return 0;
        }else{
            for (int i=2; i<=n; i++){
                f2=f0+f1;
                f0=f1;
                f1=f2;
            }
            return f2;
        }
    }
    //一个字符串中单词最长的
    public void FindLong(){
        String aa = "I have a student";
        StringTokenizer st = new StringTokenizer(aa);
        int i=0;
        int num=0;
        String result="";
        while(st.hasMoreTokens()){
            result = st.nextToken();
            if (result.length()>num){
                num=result.length();
            }
            i++;
        }
        System.out.println(result);
    }
    //12.将一个int进行逆序123》321
    public void test12(int x){
        int res=0;
        while (x!=0){
            res = res*10+x%10;
            x = x/10;
        }
    }
    public void climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

    //16.Int数组，相邻元素的差，求最大
    public void test16(){
        int aa[]={2,10,6,7,30,18,20};
        int resu=0;
        for (int i=0; i<aa.length-1; i++){
            if (aa[i+1]>aa[i]){
                if (aa[i+1]-aa[i]>resu){
                    resu=aa[i+1]-aa[i];
                }
            }else if (aa[i+1]<aa[i]){
                if (aa[i]-aa[i+1]>resu){
                    resu = aa[i]-aa[i+1];
                }
            }
        }
        System.out.println(resu);
    }

    public void checkChar(){
        String strSearch = "This is the string in which you have to search for a substring.";
        String substring = "substring";
        boolean found = false;
        int max = strSearch.length() - substring.length();
        testlbl:
        for (int i = 0; i <= max; i++) {
            int length = substring.length();
            int j = i;
            int k = 0;
            while (length-- != 0) {
                if(strSearch.charAt(j++) != substring.charAt(k++)){
                    continue testlbl;
                }
            }
            found = true;
            break testlbl;
        }
        if (found) {
            System.out.println("发现子字符串。");
        }
        else {
            System.out.println("字符串中没有发现子字符串。");
        }
    }
    //递归练习
    public void listAllFile(File file){
        File[] files = file.listFiles();
        for (int i = 0; i<files.length; i++){
            if (files[i].isDirectory()){
                listAllFile(files[i]);
                System.out.println("mulu:::"+files[i].getName());
            }else{
                System.out.println("wenjian:::"+files[i].getName());
            }
        }
    }
    //递归求n的阶乘
    public long fact(int n) throws Exception {
        if (n<0){
            throw new Exception("ldsfals");
        }else if (n==0||n==1){
            return n;
        }else {
            return n*fact(n-1);
        }
    }

    /**
     * int数组进行拼接，返回最大的拼接结果563302311912
     * 思路：将每个元素每一位从左到右进行对比，然后排序
     * 1.比较左边第一位：56,30,3,231,12,19
     * 2.如果第一位相等的，再比较第二位：56,30,3,231,19,12，如何找出第一位相等的？
     * 3.如果没有第二位的比较长度：56,3,30,231,19,12
     * 231,12,56,19,30,3
     * 上面思路太复杂，下面是更简单的思路，先对比两个数的组合是
     */
    public void test17(){
        long ll = 0;
        int[] arr = {231,30,3,12,232,19};
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            //此循环是找出最大的那个值
            for (int j = i+1; j < arr.length; j++) {
                if (cmp(arr[max], arr[j])) {
                    max = j;
                    System.out.println("i:"+i+",j:"+j+",max:"+max);
                }
            }
            exch(arr, max, i);
        }
        for(int x:arr) {
            System.out.println(x);
        }
    }
    //将两个int前后拼接后比较大小
    public boolean cmp(int n1, int n2){
        String s1 = String.valueOf(n1) + String.valueOf(n2);//45
        String s2 = String.valueOf(n2) + String.valueOf(n1);//54
        //从左到右比较每一位
        for (int i = 0; i < s1.length(); i++) {
            if (Integer.parseInt(s1.substring(i, i+1)) > Integer.parseInt(s2.substring(i, i+1))) {return false;};
            if (Integer.parseInt(s1.substring(i, i+1)) < Integer.parseInt(s2.substring(i, i+1))) {return true;} ;
        }
        return false;
    }
    //将数组指定两个位置的值交换
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**二分查找法：查找某个数是否在数组中，前提数组是有序的
     * 1.遍历进行比较查找，时间复杂度0(n)
     * 2.建立哈希表，元素做key下标做value，时间复杂度0(1),但是空间复杂度0(n)
     * 3.使用二分查找法
     */
    public void test18(){
        int search = 13;//查找的元素
        int[] arr = {10,11,12,13,14,15,16,17,18,19,20};
        int start = 0;
        int end =arr.length-1;
        int mid;
        while (start<=end){
            mid = start + (end-start)/2;
            if(arr[mid]==search){
                return;
            }else if (arr[mid]<search){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
    }
    //对比两个版本号大小
    public void test19(){
        String v1 = "5.15.4.1802";
        String v2 = "6.15.1.1010";
        for (int i=0;i<v1.split("\\.").length;i++){
            System.out.println(i);
            if (Integer.parseInt(v1.split("\\.")[i])>Integer.parseInt(v2.split("\\.")[i])){
                System.out.println("v1");
                break;
            }else if (Integer.parseInt(v1.split("\\.")[i])==Integer.parseInt(v2.split("\\.")[i])){
                System.out.println("==");
            }else{
                System.out.println("v2");
                break;
            }
        }
    }
    //数组中数字出现次数超过数组长度的一半
    //并没有使用统计某个数出现的总次数
    public void test22(){
        int[] arr = {10,11,11,13,11,11,11,17,15,19};
        int result = arr[0];
        int count = 1;
        for (int i = 1;i<arr.length;i++){
            if (count==0){
                result = arr[i];
                count = 1;
            }else if (result == arr[i]){
                count++;
            }else{
                count--;
            }
            System.out.println(arr[i]+"::"+count+"::"+result);
        }
        System.out.println(count+":::::"+result);
    }
    //找出数组中出现次数最多的
    public void test23(){
        int[] arr = {10,11,11,13,11,11,11,17,15,19};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        Collection<Integer> count = map.values();
        int maxCount = Collections.max(count);//获取values中的最大值
        //遍历map，拿到最大value对应的key
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (entry.getValue() == maxCount){
                System.out.println("次数最多："+entry.getKey());
            }
        }
    }
    public void leetcode20(String s){
        Stack<Character> stack = new Stack<Character>();
        for (int i=0;i<s.length();i++) {
            char s1 = s.charAt(i);
            if (s1 == '(' || s1 == '{' || s1 == '[') {
                stack.push(s1);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("右括号多");
                    return;
                }
                if ((s1 == '}' && stack.peek() == '{') || (s1 == ']' && stack.peek() == '[') || (s1 == ')' && stack.peek() == '(')) {
                    stack.pop();
                } else {
                    System.out.println("bupipei");
                    return;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("zuoduo");
            return;
        }
    }
    public void coversion(int number) {
        int result = number/25;
        int remain = number%25;
        if (result == 0) {
            coversion(result);
            if (remain < 10) {
                System.out.println(remain);
            }else {
                System.out.println(remain+55);
            }
        }
    }


//    public static void main(String[] args) throws Exception {
//        aaa a1 = new aaa();
////        a1.test23();
////        System.out.println(a1.fb(3));
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        map.put("aa", 1);
//        map.put("bb", 2);
//        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
//        table.put("cc", 3);
//        table.put("dd", 4);
//        if (map.containsKey("aa")){
//            System.out.println(map.get("aa"));
//        }
//        if (table.contains("3")){
//            System.out.println("cc");
//        }
//        System.out.println(Collections.max(map.values()));
//        map.remove("aa");
//        //查找map中某个value对应的key，遍历map
//        for (Map.Entry<String, Integer> entry:map.entrySet()){
//            if (entry.getValue()==1){
//                System.out.println(entry.getKey());
//            }
//        }
//
//    }
}
