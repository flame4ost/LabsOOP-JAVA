import org.junit.Assert;
import org.junit.Test;

public class TestGuessWord {
    @Test
    public void test_word() {
        Words words = new Words();
        char[] word = words.getWord(0);
        char[] expected = {'t', 'h', 'i', 's'};
        Assert.assertArrayEquals(expected, word);
        word = words.getWord(1);
        char[] expected1 = { 'i', 's'};
        Assert.assertArrayEquals(expected1, word);
    }


}
