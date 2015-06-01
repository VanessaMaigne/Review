public class EasySolutionImpl implements EasySolution {
    /**
     * #19 : Remove Nth Node From End of List
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return head;

        else if(head.next == null) return null;

        else {
            int size = 1;
            int i=0;
            ListNode temp = head;
            ListNode last = head;

            while(temp.next != null){
                size++;
                temp = temp.next;
            }

            if(size == n) return head.next; // Remove first element
            else {
                while(last.next != null && i < size-n-1){
                    last = last.next;
                    i++;
                }

                if(last.next != null && last.next.next != null){
                    last.next = last.next.next;
                } else {
                    last.next = null;
                }
            }

            return head;
        }
    }

    /**
     * #125 : Valid Palindrome
     */
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        s = s.toUpperCase();
        boolean isPalindrome = true;
        int i=0, j=s.length()-1;
        while(i<j && isPalindrome){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(j>=i && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(i<j){
                isPalindrome = s.charAt(i) == s.charAt(j);
                i++;
                j--;
            }
        }

        return isPalindrome;
    }

    /**
     * #8 : String to Integer (atoi)
     */
    public int myAtoi(String str) {
        if(str.isEmpty())
            return 0;

        str = str.replaceAll(" ","");
        char firstChar = str.charAt(0);
        if(!Character.isDigit(firstChar) && firstChar != '+' && firstChar != '-')
            return 0;

        try{
            if(str.charAt(0) == '+' || str.charAt(0) == '-')
                str = str.substring(1, str.length());
            int value = Integer.parseInt(str);
            return value;
        } catch(NumberFormatException e){
            int i=0;
            String temp="";
            while(i<str.length() && Character.isDigit(str.charAt(i))){
                temp += str.charAt(i);
                i++;
            }
            if(temp.isEmpty()) return 0;
            else {
                String maxStr = String.valueOf(Integer.MAX_VALUE);
                String minStr = String.valueOf(Integer.MIN_VALUE);
                if(firstChar == '+' && temp.length() >= maxStr.length()) return Integer.MAX_VALUE;
                else if(firstChar == '-' && temp.length() >= minStr.length()) return Integer.MIN_VALUE;
                else return myAtoi(temp);
            }
        }
    }


    /**
     *  #6 : ZigZag Conversion
     *  Pb with the text not clear. ABC, 2 --> ACB ??
     */
    public String convert(String s, int numRows) {
        if(s == null) return null;
        else if(numRows <= 0 || s.length() == 0) return "";
        else if(s.length() <= numRows || numRows == 1) return s;

        String result ="";
        int numberOfCharsInSmallRows = numRows / 2;
        for(int i=1; i<=numRows; i++){
            int j=i;
            if(i%2 ==0){ // even line
                boolean isFullRow = true;
                int gabFullRow = Math.abs(numRows -j) + j/2;
                int gabSmallRow = numRows + numberOfCharsInSmallRows - gabFullRow;
                while(j <= s.length()){
                    result += s.charAt(j-1);
                    j+= isFullRow ? gabFullRow : gabSmallRow;
                    isFullRow = !isFullRow;
                }
            } else { // odd line
                while(j <= s.length()){
                    result += s.charAt(j-1);
                    j+=numRows + numberOfCharsInSmallRows;
                }
            }
        }
        return result;
    }
}
