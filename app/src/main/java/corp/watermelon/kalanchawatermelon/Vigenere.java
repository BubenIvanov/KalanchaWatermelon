package corp.watermelon.kalanchawatermelon;

/**
 * Created by Buben Ivanov on 06.02.2017.
 */

public class Vigenere {
    public int smesh = (int)'a';
    public String encrypt(String text, String keyWord)
    {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < text.length();i++)
        {
            int num = ((text.charAt(i) + keyWord.charAt(i % keyWord.length()) - 2 * smesh) % 26);
            char c = (char)(num + smesh);
            ans.append(c);
        }
        return ans.toString();
    }
    public String decrypt(String shifr, String keyWord)
    {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < shifr.length();i++)
        {
            int num = ((shifr.charAt(i)  - keyWord.charAt(i % keyWord.length()) + 26) % 26);
            char c = (char)(num + smesh);
            ans.append(c);
        }
        return ans.toString();
    }
}
