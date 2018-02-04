package com.github.kbednarz.issuetrackingsystem.attachment;

import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class AttachmentFactoryTest {
    private AttachmentFactory attachmentFactory = new AttachmentFactory();

    @Test
    public void getContent() throws Exception {
        // when
        Attachment result = attachmentFactory.getContent(0);
        // then
        assertNotNull(result);
        assertThat(result, instanceOf(LocalFileAttachment.class));

        // when
        result = attachmentFactory.getContent(1);
        // then
        assertNotNull(result);
        assertThat(result, instanceOf(Base64Attachment.class));

        // when
        result = attachmentFactory.getContent(2);
        // then
        assertNotNull(result);
        assertThat(result, instanceOf(HttpAttachment.class));
    }
}