package org.jz.luceneDemo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FileSwitchDirectory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;

/**
 * 建立Txt 文件索引
 *
 * @author Hongyi Zheng
 * @date 2018/7/18
 */
public class TxtFileIndexTest {

    public static void main(String[] args) throws IOException {
        File indexDir = new File("D:\\luceneIndex");


        File dataDir = new File("D:\\luceneData");
        Analyzer luceneAnalyzer = new StandardAnalyzer();
        File[] dataFiles = dataDir.listFiles();
        IndexWriterConfig config = new IndexWriterConfig(luceneAnalyzer);
//        IndexWriter indexWriter = new IndexWriter(Directory, config);
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < dataFiles.length; i++) {
//            if (dataFiles[i].isFile()&& dataFiles[i].getName().endsWith("txt")) {
//                System.out.println("正在为文件" + dataFiles[i].getCanonicalPath() + "建立索引");
//                Document document = new Document();
//                Reader textReader = new FileReader(dataFiles[i]);
//                document.add(new TextField("path", dataFiles[i].getCanonicalPath()));
//                document.add(TextField());
//            }
//        }


    }



}
