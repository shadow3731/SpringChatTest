package local.chat.springchattest.controller;

import local.chat.springchattest.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommonModel {

    private static Map<String, Object> modelsMap = new HashMap<>();

    static {
        modelsMap.put("user", new User());
        modelsMap.put("serverDateTime", new Date());
    }

    public static Map<String, Object> getCommonModels() {
        return modelsMap;
    }

    public static void setCommonModels(Map<String, Object> newModelsMap) {
        modelsMap = newModelsMap;
    }
}
