/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

/*
题意：判断给定的字符串是不是回文（只考数字和字母）
思路：
1.先把字符串转换为小写的
2.两个下标分别从头从尾开始扫描
3.要过滤掉不是数字字母的字符
*/

//方法一:
public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return true;               //空字符串是true
        int i=0;
        int l=s.length()-1;
        while(i<l){
            if(!isValidChar(s.charAt(i))){
                i++;
                continue;
            }
            if(!isValidChar(s.charAt(l))){
                l--;
                continue;
            }
            if(!isSameChar(s.charAt(i),s.charAt(l))){
                return false;
            }
            i++;
            l--;
        }
        return true;
    }
    
    public boolean isValidChar(char ch){
        if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9'))
            return true;
        else return false;
    }
    public boolean isSameChar(char ch1,char ch2){
        if(ch1>='A'&&ch1<='Z')
            ch1=(char)(ch1+32);   
        if(ch2>='A'&&ch2<='Z')
            ch2=(char)(ch2+32); 
        return ch1==ch2;
    }
}

//方法二：先用正则表达式去除无效的字符
public boolean isPalindrome(String s){
	s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
	int len=s.length();
	if(len<2)
		return true;
	Stack<Character> stack=new Stack<Character>();
	int index=0;
	while(index<len/2){
		stack.push(s.charAt(index));
		index++;
	}
	if(len%2==1)
		index++;
	while(index<len){
	/*	if(stack.empty()){
			return false;
		}*/
		char temp=stack.pop();
		if(s.charAt(index)!=temp)
			return false;
		else
			index++;
	}
	return true;
}