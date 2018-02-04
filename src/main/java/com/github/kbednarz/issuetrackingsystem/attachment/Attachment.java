package com.github.kbednarz.issuetrackingsystem.attachment;

public interface Attachment {
    byte[] getContent(String path) throws Exception;
}
