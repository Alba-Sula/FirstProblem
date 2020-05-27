import java.util.Arrays;

public class FirstProblem {

    public static void main(String[] args) {


        String  haystack ="vnk2435kvabco8awkh125kjneytbcd12qjhb4acd123xmnbqwnw4t";
        String needle = "abcd1234";
        int threshold = 3;
        char [] h = new char [haystack.length()];
        char [] n = new char [needle.length()];
        int nOffset = 0;
        int hOffset = 0;
        int offJ = 0;


        for (int a = 0 ; a < haystack.length(); a++){
            h[a]=haystack.charAt(a);
        }

        for (int b = 0 ; b < needle.length(); b++){
            n[b]=needle.charAt(b);
        }

            for( int j = 0 ; j < h.length ; j++){
                offJ = 0;
            if(j+threshold <= h.length) {
                char[] slice = Arrays.copyOfRange(h, j, j + threshold);

                for (int i = 0; i < n.length; i++) {
                    if (i + threshold <= n.length) {
                        char[] subArr = Arrays.copyOfRange(n, i, i + threshold);
                        if (Arrays.equals(slice, subArr)) {
                            hOffset = j;
                            nOffset = i;
                            int s = 0;
                            int l = j + threshold;
                            int k = i + threshold;
                            if (l < h.length - 1  && k < n.length - 1) {
                                while (h[l] == n[k]) {
                                    l ++;
                                    k ++;
                                }
                                slice = Arrays.copyOfRange(h, j, l);
                                offJ = l-j;
                                System.out.println("sequence of length = " + slice.length + " found at haystack offset " + hOffset + ", needle offset " +  nOffset);
                               break;
                            }
                            System.out.println("sequence of length = " + slice.length + " found at haystack offset " +  hOffset+ ", needle offset " +  nOffset);
                        }
                    }
                }
            }
            if(offJ != 0){
                j+=offJ-1;
            }
        }
    }
}

/*
    this type of problem is used when we have a file and we want to save it in the database, we do so by converting all the file into a byte array
    a practical use of this exercise would be when for example you want to search and find anything in the file
    you first create the byte array of the "thing" you want to search into the byte array version of your file ... in this case that would be the needle array and the file would be haystack array
    than create the char array of both byte arrays and the rest of the code is the same. You can do lots of things with minor changes...for example :
    - "CRUD" => within the file, create a new word/sentence within a file, read sequences when you have the positions, update same as find and replace within the file and delete sequences from that file.    
*/