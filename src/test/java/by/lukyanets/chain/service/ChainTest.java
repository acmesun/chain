package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Token;
import by.lukyanets.chain.util.Util;
import org.testng.annotations.Test;

public class ChainTest {

    @Test
    public void createChainTest() {
        var chain = new ChainCreator().createChain();
        var text = chain.process(new Token(Util.findAbsolutePath("text.txt")));

        System.out.println(text.getText());

    }

    @Test
    public void createChainSortedTest() {
        var chain = new ChainCreator().createChainParagraphsSorted();
        var text = chain.process(new Token(Util.findAbsolutePath("text.txt")));

        System.out.println(text.getText());

    }

    @Test
    public void createChainLongestTest() {
        var chain = new ChainCreator().createChainLongestWord();
        var text = chain.process(new Token(Util.findAbsolutePath("text.txt")));

        System.out.println(text.getText());

    }
}
