import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class aaa {
    //1.�Ӽ�������һ���ַ�����ȫ��תΪ��д�������뵽һ��txt�ı���
    public void inputToUp() throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(br.readLine().toUpperCase());
        }
    }
    //2.��ƪӢ�����£��ҳ���A�д���B�в����ڵĵ��ʣ���ôȥ��
    public void Finddefferent(){
        String a="China as the most important quality sign for the international Chinese outbound market.I am Chinese.";
        String b="I am come from China";
        StringTokenizer tokenizer = new StringTokenizer(a, ",. ");//��a�𿪣��ŵ�����������
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
    //���ַ����е�aeiou�ַ�ȥ��
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
    //3.�㷨�⣺5Ԫ/ֻ��3Ԫ/ֻ��3ֻ/Ԫ��100Ԫ��100ֻ��������з������
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
    //4.ð�����򣬴Ӵ�С
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
    //һ���ַ����е������
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
    //16.Int���飬����Ԫ�صĲ�����
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
    /**
     * �������򣬵ݹ�
     * @param array
     * @param left
     * @param right
     */
    public static void test7(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        //2,1,3
        // base�д�Ż�׼��
        int base = array[left];//2
        int i = left, j = right;//0,2
        while(i != j) {
            // ˳�����Ҫ���ȴ��ұ߿�ʼ�����ң�ֱ���ҵ���baseֵС����
            while(array[j] >= base && i < j) {
                j--;
            }//j=1
            // �ٴ������ұ��ң�ֱ���ҵ���baseֵ�����
            while(array[i] <= base && i < j) {
                i++;
            }//i=2
            // �����ѭ��������ʾ�ҵ���λ�û���(i>=j)�ˣ������������������е�λ��
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        // ����׼���ŵ��м��λ�ã���׼����λ��
        array[left] = array[i];//3,1,2
        array[i] = base;

        // �ݹ飬�������׼����������ִ�к�����ͬ���Ĳ���
        // i��������Ϊ������ȷ���õĻ�׼ֵ��λ�ã������ٴ���
        test7(array, left, i - 1);
        test7(array, i + 1, right);
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
            System.out.println("�������ַ�����");
        }
        else {
            System.out.println("�ַ�����û�з������ַ�����");
        }
    }
    //�ݹ���ϰ
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
    //�ݹ���n�Ľ׳�
    public long fact(int n) throws Exception {
        if (n<0){
            throw new Exception("ldsfals");
        }else if (n==0||n==1){
            return n;
        }else {
            return n*fact(n-1);
        }
    }
    //쳲��������У�
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
     * int�������ƴ�ӣ���������ƴ�ӽ��563302311912
     * ˼·����ÿ��Ԫ��ÿһλ�����ҽ��жԱȣ�Ȼ������
     * 1.�Ƚ���ߵ�һλ��56,30,3,231,12,19
     * 2.�����һλ��ȵģ��ٱȽϵڶ�λ��56,30,3,231,19,12������ҳ���һλ��ȵģ�
     * 3.���û�еڶ�λ�ıȽϳ��ȣ�56,3,30,231,19,12
     * 231,12,56,19,30,3
     * ����˼·̫���ӣ������Ǹ��򵥵�˼·���ȶԱ��������������
     */
    public void test17(){
        long ll = 0;
        int[] arr = {231,30,3,12,232,19};
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            //��ѭ�����ҳ������Ǹ�ֵ
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
    //������intǰ��ƴ�Ӻ�Ƚϴ�С
    public boolean cmp(int n1, int n2){
        String s1 = String.valueOf(n1) + String.valueOf(n2);//45
        String s2 = String.valueOf(n2) + String.valueOf(n1);//54
        //�����ұȽ�ÿһλ
        for (int i = 0; i < s1.length(); i++) {
            if (Integer.parseInt(s1.substring(i, i+1)) > Integer.parseInt(s2.substring(i, i+1))) {return false;};
            if (Integer.parseInt(s1.substring(i, i+1)) < Integer.parseInt(s2.substring(i, i+1))) {return true;} ;
        }
        return false;
    }
    //������ָ������λ�õ�ֵ����
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /**���ֲ��ҷ�������ĳ�����Ƿ���������
     * 1.�������бȽϲ��ң�ʱ�临�Ӷ�0(n)
     * 2.������ϣ��Ԫ����key�±���value��ʱ�临�Ӷ�0(1),���ǿռ临�Ӷ�0(n)
     * 3.ʹ�ö��ֲ��ҷ�
     */
    public void test18(){
        int search = 13;//���ҵ�Ԫ��
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
    //�Ա������汾�Ŵ�С
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
    //���������ֳ��ִ����������鳤�ȵ�һ��
    //��û��ʹ��ͳ��ĳ�������ֵ��ܴ���
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
    //�ҳ������г��ִ�������
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
        int maxCount = Collections.max(count);//��ȡvalues�е����ֵ
        //����map���õ����value��Ӧ��key
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (entry.getValue() == maxCount){
                System.out.println("������ࣺ"+entry.getKey());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        aaa a1 = new aaa();
        a1.test23();
//        System.out.println(a1.fb(3));
    }
}
