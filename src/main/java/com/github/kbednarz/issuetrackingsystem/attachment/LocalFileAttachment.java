package com.github.kbednarz.issuetrackingsystem.attachment;

import java.io.File;
import java.nio.file.Files;

public class LocalFileAttachment implements Attachment {
    @Override
    public byte[] getContent(String path) throws Exception {
        File file = new File(path);
        if (!file.exists())
            throw new Exception("File " + path + " not exist");

        byte[] data = Files.readAllBytes(file.toPath());

        return data;
    }
}
