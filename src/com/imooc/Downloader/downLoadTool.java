package com.imooc.Downloader;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Random;

public class downLoadTool {
    public void downloadtool(String source, String target_path) throws Exception {
        URL url = new URL(source);
        InputStream is = url.openConnection().getInputStream();
        String filepath = target_path + source.substring(source.lastIndexOf("/"));
        OutputStream os = new FileOutputStream(filepath);
        byte[] bs = new byte[1024];
        int len = 0;
        int target_length = 0;
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
            target_length += len;
        }
        System.out.printf("文件下载完成，保存在%s，大小为%fKb" , filepath, Math.floor(target_length/1024));
    }
}
