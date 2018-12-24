package com.idukelu.java.javabase.io;

import org.junit.Test;

import java.io.*;

public class CharacterStreams {

    // 单字符读写
    @Test
    public void copyCharacters() throws IOException {

        String readPath = "/Users/duke/Taurus/Projects/java-base/src/main/java/com/idukelu/java/javabase/io/read.file";
        String writePath = "/Users/duke/Taurus/Projects/java-base/src/main/java/com/idukelu/java/javabase/io/write.file";

        try (Reader in = new FileReader(readPath); Writer out = new FileWriter(writePath)) {
            int i;
            while((i = in.read()) != -1) {
                out.write(i);
            }
        }
    }

    // 字符数组读写
    @Test
    public void copyCharactersArray() throws IOException {

        String readPath = "/Users/duke/Taurus/Projects/java-base/src/main/java/com/idukelu/java/javabase/io/read.file";
        String writePath = "/Users/duke/Taurus/Projects/java-base/src/main/java/com/idukelu/java/javabase/io/write.file";

        try (Reader in = new FileReader(readPath); Writer out = new FileWriter(writePath)) {
            char[] chars = new char[1024];
            int len;
            while((len = in.read(chars)) != -1) {
                out.write(chars, 0 , len);
//                out.write(new String(chars).substring(0, len));
            }
        }
    }
}
