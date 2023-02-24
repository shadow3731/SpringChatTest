package local.chat.springchattest.controller;

import java.util.*;

public class CommonModel {

    private static Map<String, Object> modelsMap = new HashMap<>();

    static {
        modelsMap.put("serverDateTime", new Date());
    }

    public static Map<String, Object> getCommonModels() {
        return modelsMap;
    }

    public static void setCommonModels(Map<String, Object> newModelsMap) {
        modelsMap = newModelsMap;
    }
}
