import java.io.BufferedReader;
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
    public static void main(String[] args) throws IOException {
        aaa a1 = new aaa();
        a1.meth();
    }
}
