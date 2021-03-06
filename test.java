import java.util.Scanner;

/**
 * Created by zhao on 2018/8/6.
 */
public class test {
    //反转字符串：编写一个函数，其作用是将输入的字符串反转过来。
    public void reserve() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char[] array = str.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
        System.out.print(array);
    }

    //字符串转int
    public int StrToInt(String str) {
        char[] s = str.toCharArray();
        boolean valid = true;
        boolean flag = true;
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[0] == '0') {
                return 0;
            }
            if (s[i] <= '9' && s[i] >= '0') {
                sum = sum * 10 + s[i] - '0';
            } else {
                if (s[i] == '-') {
                    flag = false;
                } else if (s[i] == '+') {
                }
                else {
                    return 0;
                }
            }
        }
        if (valid == false) {
            return 0;
        }
        if (flag == false) {
            return 0 - sum;
        } else {
            return sum;
        }
    }


    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    // 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    public char[] replace(char[] str) {
        //实现方法1：
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                count++;
            }
        }
        char[] tmp = new char[str.length + count * 3];
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                tmp[j++] = '%';
                tmp[j++] = '2';
                tmp[j++] = '0';
                continue;
            }
            tmp[j++] = str[i];
        }
        return tmp;
    }

    public void reverse(char[] str,int begin,int end)
    {
        while(begin<end)
        {
            char tmp=str[begin];
            str[begin]=str[end];
            str[end]=tmp;
            begin++;
            end--;
        }
    }
    public String reverseSentence(String str) {

        char[] s=str.toCharArray();
        int begin=0;
        boolean blank=false; //是否有空格
        for(int i=0;i<str.length();i++)
        {
            if(s[i]==' ')
            {
                reverse(s,begin,i-1);
                begin=i+1;
                blank=true;
            }
            if(i==str.length()-1 && blank== true)
            {
                reverse(s,begin,i);
            }
        }
        if(blank == true)
        {
            reverse(s,0,s.length-1);
        }
        return String.valueOf(s);
    }

    //左旋n个字符
    public void left_Reverse(char[] str,int left_num)
    {
        reverse(str,0,left_num-1);
        reverse(str,left_num,str.length-1);
        reverse(str,0,str.length-1);
    }

    public static void main(String[] args) {
        test T = new test();
        // T.reserve();
        System.out.println(T.StrToInt("-5968"));
        char[] str = ("we are world").toCharArray();
        System.out.println(T.replace(str));
        System.out.println(T.reverseSentence("I am a student."));
        char[] s=("hello").toCharArray();
        T.left_Reverse(s,2);
        System.out.println(s);

    }

}

