import java.util.*;

/*
注意：
1，两端空格要去掉
2，单词间只保留一个空格

		"            "
        "a        "
        "             a        "
        "             a"
        "             a                     b        "
        "             a b       "
        "             a  b"
        "a  b      "
        "             a  b                c d e f                          g      "
*/

class Q151_ReverseWords{

	//ac
	public static String reverseWords(String s){
		if(s=="") return "";
		String str="";
		int start=0,end;
		for(int i=s.length()-1;i>=0;){
			while(i>=0&&s.charAt(i)==' ') 
				i--;
			if(i!=start) str+=" ";
			end=i;
			while(i>=0&&s.charAt(i)!=' ') i--;
			start=i;
			str+=s.substring(start+1,end+1);
		}
		//去除两端空格
		start=0;
		end=str.length()-1;
		while(start<=end&&str.charAt(start)==' ')
			start++;
		while(start<=end&&str.charAt(end)==' ')
			end--;
		return str.substring(start,end+1);
	}



	public static String reverseWords1(String s) {
    	ArrayList<String> buf = new ArrayList<String>();
    	s += ' ';
    	int n = s.length(), h = -1;
    	for(int i=0; i<n; i++) {
        	if(h == -1 && s.charAt(i) != ' ')   h = i;
        	else if(h != -1 && s.charAt(i) == ' ') {
            	buf.add(0,s.substring(h,i));
            	h = -1;
        	}
    	}
    	StringBuilder sb = new StringBuilder();
    	for(String iter : buf)  sb.append(iter+" ");
    	return sb.length() == 0 ? "" : sb.substring(0,sb.length()-1).toString();
	}
	public static void main(String[] args){
		String str="   a   b    ";
		System.out.print(str);
		System.out.println("--");
		System.out.print(reverseWords(str));
		System.out.println("--");

		System.out.print(reverseWords1(str));
		System.out.println("--");
	}
}