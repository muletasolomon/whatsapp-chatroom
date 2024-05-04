package com.whatsapp.spring.swagger.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class EmojiService {

    private static final Map<String, String> emojis = new HashMap<>();

    static {

        String val = "\uD83D\uDC4D";
        emojis.put("LOVE", "❤️");
        emojis.put("THUMB_UP", val);
        emojis.put("CRYING", "😢");
        emojis.put("SURPRISED", "😮");

    }

    public static List<String> getReactions() {
        return new ArrayList<>(emojis.values());
    }

    public static String getEmoji(String key) {
        return emojis.get(key);
    }

}
