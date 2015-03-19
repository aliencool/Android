package com.example.utility;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.example.bean.MusicBean;
import com.example.handler.parse.XMLHandler;

/**
 * 这个类主要解析从服务器发下来的XML
 * Created by Think on 2015/3/12.
 */
public class XMLParse {
    public ArrayList<MusicBean> getMusicList(String filePath) throws  Exception
    {
    	File file = new File(filePath);
    	
    	if(!file.exists()) return null;
    	
        ArrayList<MusicBean> arrayList = new ArrayList<MusicBean>();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser parser = saxParserFactory.newSAXParser();

        parser.parse(file,new XMLHandler(arrayList));
      
        return arrayList;
    }
}