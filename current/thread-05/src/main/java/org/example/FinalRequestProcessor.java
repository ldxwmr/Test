package org.example;

/**
 * @author ld
 * @date 2021/9/16 22:12
 */
public class FinalRequestProcessor implements IRequestProcessor {
    @Override
    public void processRequest(Request request) {
        System.out.println("FinalRequestProcessor:" + request);
    }
}
