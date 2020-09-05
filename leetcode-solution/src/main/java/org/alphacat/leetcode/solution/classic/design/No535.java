package org.alphacat.leetcode.solution.classic.design;

import java.util.HashMap;
import java.util.Random;

public class No535 {

    //基于字母与数字的随机生成encode码的一个优化版本
    public class Codec {
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String, String> map = new HashMap<>();
        Random random = new Random();
        int codeLong = 6;
        String url = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String enCode = getString();
            int collisionCount = 0;
            while (map.containsKey(enCode)) {
                collisionCount++;
                enCode = getString();
            }
            map.put(enCode, longUrl);
            return url + enCode;
        }

        private void ensureCapacities(int collisionCount) {
            if (collisionCount >= 10) {
                this.codeLong++;
            }
        }

        private String getString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < codeLong; i++) {
                int index = random.nextInt(62);
                char c = alphabet.charAt(index);
                sb.append(c);
            }
            return sb.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String originalCode = shortUrl.replace(url, "");
            return map.get(originalCode);
        }
    }

    //随机数
    public class Codec_2 {
        HashMap<Integer, String> map = new HashMap<>();
        Random random = new Random();
        int range = Integer.MAX_VALUE;
        int key = random.nextInt(range);
        String url = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            while (map.containsKey(key)) {
                key = random.nextInt(range);
            }
            map.put(key, longUrl);
            return url + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String originalCode = shortUrl.replace(url, "");
            Integer code;
            try {
                code = Integer.parseInt(originalCode);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new String();
            }
            return map.get(code);
        }
    }

    //hashcode
    public class Codec_3 {
        String url = "http://tinyurl.com/";
        HashMap<Integer, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int hashCode = longUrl.hashCode();
            map.put(hashCode, longUrl);//不考虑hashcode相同的时候
            return url + hashCode;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String originalCode = shortUrl.replace(url, "");
            Integer code;
            try {
                code = Integer.parseInt(originalCode);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new String();
            }
            return map.get(code);
        }
    }

    //顺序性地生成
    public class Codec_4 {
        String url = "http://tinyurl.com/";
        HashMap<String, String> map = new HashMap<>();
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int alphabetSize = alphabet.length();
        int index = 0;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            StringBuilder sb = new StringBuilder();
            int tempIndex = index;
            while (tempIndex >= 0) {
                char c = alphabet.charAt(tempIndex % alphabetSize);
                sb.append(c);
                tempIndex /= alphabetSize;
                tempIndex--;
            }
            String encodedCode = sb.toString();
            map.put(encodedCode, longUrl);
            index++;
            return url + encodedCode;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String originalCode = shortUrl.replace(url, "");
            return map.get(originalCode);
        }
    }

    //最简单的方式
    public class Codec_5 {
        String url = "http://tinyurl.com/";
        HashMap<Integer, String> map = new HashMap<>();
        int i = 0;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int crrIndex = i;
            map.put(crrIndex, longUrl);
            i++;
            return url + crrIndex;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String originalCode = shortUrl.replace(url, "");
            Integer code;
            try {
                code = Integer.parseInt(originalCode);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new String();
            }
            return map.get(code);
        }
    }
}
