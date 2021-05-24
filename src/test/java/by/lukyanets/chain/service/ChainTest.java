package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Token;
import by.lukyanets.chain.service.creator.ChainCreator;
import by.lukyanets.chain.util.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChainTest {
    private final static String FILE_NAME = "text.txt";

    @Test
    public void createChainTest() {
        var chain = new ChainCreator().createChain();
        String actual = getText(chain);
        var expected = " It has survived - not only (five) centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. It was lookinghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh popularised in " +
                "the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions " +
                "of Lorem Ipsum! It is a long a!=b established fact that a reader will be distracted by the readable " +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less " +
                "normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it " +
                "look like readable English? It is a established fact that a reader will be of a page when at its layout" +
                "... Bye бандерлоги.";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createChainSortedTest() {
        var chain = new ChainCreator().createChainParagraphsSorted();
        String actual = getText(chain);
        var expected = " It is a established fact that a reader will be of a page when at its layout... Bye бандерлоги. " +
                "It has survived - not only (five) centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. It was lookinghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh popularised " +
                "in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions " +
                "of Lorem Ipsum! It is a long a!=b established fact that a reader will be distracted by the readable " +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less " +
                "normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it " +
                "look like readable English?";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void createChainLongestTest() {
        var chain = new ChainCreator().createChainLongestWord();
        var text = chain.process(new Token(Util.findAbsolutePath(FILE_NAME)));
        var expected = "It was lookinghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh popularised in the “Динамо” (Рига) " +
                "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently " +
                "with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!";
        var actual = text.getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createChainFilterTest() {
        var chain = new ChainCreator().createChainSentenceFilter();
        var text = chain.process(new Token(Util.findAbsolutePath(FILE_NAME)));
        var expected = "It was lookinghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh popularised in the “Динамо” (Рига) " +
                "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently " +
                "with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum! " +
                "It is a long a!=b established fact that a reader will be distracted by the readable content " +
                "of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less " +
                "normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, " +
                "making it look like readable English?";
        var actual = text.getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createChainCounterTest() {
        var chain = new ChainCreator().createChainWordCount();
        var text = chain.process(new Token(Util.findAbsolutePath(FILE_NAME)));
        var expected = "reader 2 when 2 that 3 lorem 2 has 2 readable 2 using 2 like 2 its 2 is 3 it 6 at 2 " +
                "ipsum 2 page 2 be 2 fact 2 content 2 of 5 established 2 a 7 will 2 the 5 with 2";
        var actual = text.getText();
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void createChainCharCounterTest() {
        var chain = new ChainCreator().createChainCharCount();
        var text = chain.process(new Token(Util.findAbsolutePath(FILE_NAME)));
        var expected = "It has survived - not only (five) centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. Consonants: 64; Vowels: 39 It was " +
                "lookinghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh popularised in the “Динамо” (Рига) with the release " +
                "of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop " +
                "publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum! " +
                "Consonants: 170; Vowels: 77 " +
                "It is a long a!=b established fact that a reader will be distracted by the readable content of a " +
                "page when looking at its layout. Consonants: 62; Vowels: 40 The point of using Ipsum is that it " +
                "has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), " +
                "content here's, making it look like readable English? Consonants: 91; Vowels: 56 It is a established " +
                "fact that a reader will be of a page when at its layout... " +
                "Consonants: 34; Vowels: 25 " +
                "Bye бандерлоги. Consonants: 8; Vowels: 5";
        var actual = text.getText();
        Assert.assertEquals(actual, expected);

    }

    private String getText(ChainedProcessor chain) {
        var text = chain.process(new Token(Util.findAbsolutePath(FILE_NAME)));
        return text.getText();
    }
}
