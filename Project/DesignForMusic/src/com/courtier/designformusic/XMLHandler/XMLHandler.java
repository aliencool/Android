package com.courtier.designformusic.XMLHandler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

import com.courtier.designformusic.Bean.MusicBean;

import java.util.ArrayList;


/**
 * 这个类主要用于解析XML
 * Created by Think on 2015/3/12.
 */
public class XMLHandler  extends DefaultHandler{
    private String mTarget;
    private ArrayList<MusicBean> mArrayList;
    private MusicBean mMusicBean;

    public XMLHandler(ArrayList<MusicBean> arrayList) {
        this.mArrayList = arrayList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        mTarget = localName;
        if(mTarget.equals("mp3"))
        {
            mMusicBean = new MusicBean();
        }
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(mArrayList != null &&  "mp3".equals(localName))
        {
            mArrayList.add(mMusicBean);
        }
        //每次使其为空
        mTarget = "";
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String temp = new String(ch,start,length);

        if(mTarget.equals("mp3id"))
        {
            mMusicBean.setId(Integer.parseInt(temp));
        }
        
        if(mTarget.equals("mp3name"))
        {
            mMusicBean.setMp3Name(temp);
        }
        
        if(mTarget.equals("mp3size"))
        {
            mMusicBean.setMp3Size(Integer.parseInt(temp));
        }
        
        if(mTarget.equals("lrcname"))
        {
            mMusicBean.setLrcName(temp);
        }
        
        if(mTarget.equals("lrcsize"))
        {
            mMusicBean.setLrcSize(Integer.parseInt(temp));
        }
        
        super.characters(ch, start, length);
    }
}
