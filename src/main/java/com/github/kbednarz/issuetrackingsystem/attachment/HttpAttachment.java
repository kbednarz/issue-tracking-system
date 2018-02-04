package com.github.kbednarz.issuetrackingsystem.attachment;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpAttachment implements Attachment {
    @Override
    public byte[] getContent(String path) throws Exception {
        URL url = new URL(path);
        URLConnection conn = url.openConnection();

        try (InputStream is = conn.getInputStream(); ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[0xFFFF];

            for (int len; (len = is.read(buffer)) != -1; )
                os.write(buffer, 0, len);

            os.flush();

            return os.toByteArray();
        }
    }
}
