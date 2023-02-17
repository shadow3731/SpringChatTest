package local.chat.springchattest.controller;

import local.chat.springchattest.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommonModel {

    private static Map<String, Object> modelsMap = new HashMap<>();

    static {
        modelsMap.put("user", new User());
        modelsMap.put("serverDateTime", new Date());
    }

    static Map<String, Object> getCommonModels() {
        return modelsMap;
    }

    static void setCommonModels(Map<String, Object> newModelsMap) {
        modelsMap = newModelsMap;
    }

    static boolean isThisUserAuthenticated() {
        User user = (User) modelsMap.get("user");
        return user.getAuthority() != null;
    }

    static int getThisUserIdAuthority() {
        User user = (User) modelsMap.get("user");
        Optional<Integer> authorityId = Optional
                .of(user.getAuthority().getId());
        return authorityId.orElse(0);
    }
}
