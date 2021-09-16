package org.example;

/**
 * @author ld
 * @date 2021/9/16 22:12
 */
public class ChainExample {
    public static void main(String[] args) {
        FinalRequestProcessor finalRequestProcessor = new FinalRequestProcessor();
        SaveRequestProcessor saveRequestProcessor = new SaveRequestProcessor(finalRequestProcessor);
        saveRequestProcessor.start();
        PrintProcessor printProcessor = new PrintProcessor(saveRequestProcessor);
        printProcessor.start();
        ValidProcessor validProcessor = new ValidProcessor(printProcessor);
        validProcessor.start();
        Request request = new Request();
        request.setName("Mic");
        validProcessor.processRequest(request);
    }
}
