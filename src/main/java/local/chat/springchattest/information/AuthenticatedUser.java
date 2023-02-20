package local.chat.springchattest.information;

import local.chat.springchattest.controller.CommonModel;
import local.chat.springchattest.entity.User;

import java.util.Optional;

public class AuthenticatedUser {

    public static boolean isThisUserAuthenticated() {
        User user = (User) CommonModel.getCommonModels().get("user");
        return user.getAuthority() != null;
    }

    public static int getThisUserIdAuthority() {
        User user = (User) CommonModel.getCommonModels().get("user");
        if (isThisUserAuthenticated()) {
            Optional<Integer> authorityId = Optional
                    .of(user.getAuthority().getId());
            return authorityId.get();
        } else {
            return 0;
        }
    }
}
