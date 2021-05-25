package com.codesquad.team10.airbnb.util;

import com.codesquad.team10.airbnb.model.User;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    public static final String USER_SESSION_KEY = "sessionedUser";

    public static boolean isLoginUser(HttpSession session) {
        return session.getAttribute(USER_SESSION_KEY) != null;
    }

    public static User getUserFromSession(HttpSession session) {
        if (!isLoginUser(session)) {
            throw new IllegalArgumentException("User is not logged in.");
        }
        return (User) session.getAttribute(USER_SESSION_KEY);
    }
}
