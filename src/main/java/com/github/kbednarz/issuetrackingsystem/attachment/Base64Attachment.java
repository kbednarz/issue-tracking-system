package com.github.kbednarz.issuetrackingsystem.attachment;

import java.util.Base64;

public class Base64Attachment implements Attachment {
    @Override
    public byte[] getContent(String path) throws Exception {
        byte[] encodedBytes = Base64.getEncoder().encode(path.getBytes());

        return encodedBytes;
    }
}
