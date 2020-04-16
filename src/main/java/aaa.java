import java.util.StringTokenizer;

public class aaa {
    //1.从键盘输入一个字符串，全部转为大写，并输入到一个txt文本中
    public void inputToUp(){

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

    public static void main(String[] args) {
        aaa a1 = new aaa();
        a1.Finddefferent();
    }
}
