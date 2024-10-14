package org.example.peche;

import java.util.HashMap;
import java.util.Map;

public class User {
    public synchronized String getUserRole(User user) {
        Map<String, String> roles = new HashMap<>();
        roles.put("admin", "Administrator");
        roles.put("user", "Regular User");

        if (roles.containsKey(user.getRole())) {
            return roles.get(user.getRole());
        } else {
            return "Guest";
        }
    }

    private String getRole() {
        return null;
    }
}
