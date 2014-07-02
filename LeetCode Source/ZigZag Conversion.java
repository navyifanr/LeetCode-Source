/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

//数学问题

public class Solution {
    public String convert(String s, int nRows) {
        if(nRows==1)
            return s;
        int dis=2*nRows-2;  //首行(末行)的相邻字母的间隔
        int len=s.length();
        String result="";
        for(int i=0;i<nRows;i++){
            for(int j=i;j<len;j+=dis){
                result+=s.charAt(j);
                if(i>0&&i<nRows-1&&j+dis-2*i<len)  //处理不是首行和末行的
                    result+=s.charAt(j+dis-2*i);
            }
        }
        return result;
    }
}