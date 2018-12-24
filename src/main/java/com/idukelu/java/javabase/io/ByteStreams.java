package com.idukelu.java.javabase.io;

import org.junit.Test;

import java.io.*;

/**
 * 字节流是流的基础，但我们应该尽量避免使用这种低级流
 */
public class ByteStreams {

    // 单字节读写
    @Test
    public void copyBytes() throws IOException {

        String readPath = "/Users/duke/Taurus/Projects/java-base/src/main/java/com/idukelu/java/javabase/io/read.file";
        String writePath = "/Users/duke/Taurus/Projects/java-base/src/main/java/com/idukelu/java/javabase/io/write.file";

        try (InputStream in = new FileInputStream(readPath);OutputStream out = new FileOutputStream(writePath)) {
            int i;
            while((i = in.read()) != -1) {
                out.write(i);
            }
        }
    }

    // 字节数组读写
    @Test
    public void copyCharacter() throws IOException {

        String readPath = "/Users/duke/Taurus/Projects/java-base/src/main/java/com/idukelu/java/javabase/io/read.file";
        String writePath = "/Users/duke/Taurus/Projects/java-base/src/main/java/com/idukelu/java/javabase/io/write.file";

        try (InputStream in = new FileInputStream(readPath);OutputStream out = new FileOutputStream(writePath)) {
            byte[] bytes = new byte[1024];
            int len;
            while((len = in.read(bytes)) != -1) {
                out.write(bytes,0, len);
            }
        }
    }
}
