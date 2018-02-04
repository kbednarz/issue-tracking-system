package com.github.kbednarz.issuetrackingsystem.attachment;

public class AttachmentFactory {
    public Attachment getContent(Integer mode) throws Exception {
        switch (mode) {
            case 0:
                return new LocalFileAttachment();
            case 1:
                return new Base64Attachment();
            case 2:
                return new HttpAttachment();
            default:
                throw new Exception("Invalid mode");
        }

    }
}
