package com.example.datastore;

import android.content.Context;

import java.io.*;

/**
 * 文件读取存储
 * 路径默认是存储到/data/data/<package>/files下
 * @author TechBirds
 * @date 14-8-26
 * @time 上午11:20
 * @vsersion 1.0
 */
public class FileDataStoreUtil {


    private FileOutputStream outputStream;
    private FileInputStream inputStream;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    FileDataStoreUtil(Context context,String fileName){
        try {
            outputStream = context.openFileOutput(fileName,Context.MODE_PRIVATE);
            inputStream = context.openFileInput(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(String content){

        try {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void read(){

        StringBuilder content = new StringBuilder();
        String line = "";
        try {
            while( (line = bufferedReader.readLine())!= null){
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
