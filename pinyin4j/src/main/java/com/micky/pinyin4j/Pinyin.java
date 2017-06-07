package com.micky.pinyin4j;

import android.content.Context;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @Description 拼音解析
 * @Author Micky Liu
 * @Email mickyliu@126.com
 * @Date 2016-6-06 14:40
 * @Version 1.0.0
 */
public class Pinyin {
    private byte[] mBytes = null;
    private String[] pinyinArr = null;
    private Map<String, String> mDuopinMap = new HashMap<String, String>();

    /**
     * 获取拼音
     * @param source 原字符串
     * @return 拼音List集合,多音字会以下划线分隔，如“重”字，返回 chong_zhong
     */
    public List<String> getPinyin(String source) {
        ArrayList list = new ArrayList();
        if (TextUtils.isEmpty(source)) {
            return list;
        }
        char[] charArr = source.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != ' ') {
                list.add(getPinyin(charArr[i]));
            }
        }
        return list;
    }

    /**
     * 获取拼音
     * @param c 原字符
     * @return 返回拼音,多音字会以下划线分隔，如“重”字，返回 chong_zhong
     */
    public String getPinyin(char c) {
        if (c == '_') {
            c = 'ぁ';
        }
        //直接从多音字库获取拼音
        String duopin = this.mDuopinMap.get(String.valueOf(c));
        if (duopin != null) {
            return duopin;
        }
        if (c < 0) {
            return String.valueOf(c).toLowerCase();
        }
        int index;
        if ((c >= '一') && (c <= 40869)) {
            int i = 2 * (c - '一');
            int j = 256 * this.mBytes[i];
            int k = i + 1;
            int m = j + 128 * ((0x80 & this.mBytes[k]) >> 7);
            int n = i + 1;
            index = m + (0x7F & this.mBytes[n]);

            for (String str = this.pinyinArr[index]; ; str = String.valueOf(c)) {
                return String.valueOf(str).toLowerCase();
            }
        }
        return String.valueOf(c);
    }

    public void init(Context context) {
        initPinyinBytes(context);
        pinyinArr = context.getResources().getStringArray(R.array.pinyin);
        initDuopinData(context);
    }

    private void initPinyinBytes(Context context) {
        if (mBytes != null && mBytes.length > 0) {
            return;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open("pinyin.dat");
            mBytes = new byte[inputStream.available()];
            inputStream.read(mBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void initDuopinData(Context context) {
        if (mDuopinMap != null && mDuopinMap.size() > 0) {
            return;
        }
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = context.getAssets().open("duopinyin.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            boolean isFirstChar = true;
            while ((line = bufferedReader.readLine()) != null) {
                String hanzi = "";
                String pinyin = "";
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                isFirstChar = true;
                while (stringTokenizer.hasMoreElements()) {
                    if (isFirstChar) {
                        hanzi = stringTokenizer.nextElement().toString();
                        isFirstChar = false;
                    }
                    pinyin = pinyin + stringTokenizer.nextElement().toString() + "_";
                    if (!stringTokenizer.hasMoreElements()) {
                        if (pinyin.endsWith("_")) {
                            pinyin = pinyin.substring(0, pinyin.length() - 1);
                        }
                        mDuopinMap.put(hanzi, pinyin);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
