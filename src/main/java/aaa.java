import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aaa {
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
    //将字符串中的aeiou字符去掉
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
    //3.算法题：5元/只，3元/只，3只/元，100元买100只，算出所有方法结果
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
    //4.冒泡排序，从大到小
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
    //14.Int数组，相邻元素的差，求最大
    public void IntCha(){
        int aa[]={2,4,6,7,10,18,20};
        int resu=0;
        for (int i=0; i<aa.length-1; i++){
            if (aa[i+1]-aa[i]>resu){
                resu=aa[i+1]-aa[i];
            }
        }
        System.out.println(resu);
    }
    /**
     * 快速排序，递归
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        //2,1,3
        // base中存放基准数
        int base = array[left];//2
        int i = left, j = right;//0,2
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }//j=1
            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }//i=2
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];//3,1,2
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
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
    //斐波那契数列，
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
    /**
     * int数组进行拼接，返回最大的拼接结果563302311912
     * 思路：将每个元素每一位从左到右进行对比，然后排序
     * 1.比较左边第一位：56,30,3,231,12,19
     * 2.如果第一位相等的，再比较第二位：56,30,3,231,19,12，如何找出第一位相等的？
     * 3.如果没有第二位的比较长度：56,3,30,231,19,12
     * 231,12,56,19,30,3
     * 上面思路太复杂，下面是更简单的思路，先对比两个数的组合是
     */
    public void sortArray(){
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
            if (Integer.parseInt(s1.substring(i, i+1)) > Integer.parseInt(s2.substring(i, i+1))) return false;
            if (Integer.parseInt(s1.substring(i, i+1)) < Integer.parseInt(s2.substring(i, i+1))) return true ;
        }
        return false;
    }
    //将数组指定两个位置的值交换
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //二分搜索
    public static void main(String[] args) throws Exception {
        aaa a1 = new aaa();
        a1.sortArray();
//        System.out.println(a1.fb(3));
    }
}
