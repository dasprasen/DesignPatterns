package com.design.splitwise_lld;

import java.util.*;

public class GroupService {
    private Map<String, Group> groups;
    private UserService userService;

    public GroupService(UserService userService) {
        this.groups = new HashMap<>();
        this.userService = userService;
    }

    public Group createGroup(String name, List<String> userIds) {
        String groupId = UUID.randomUUID().toString();
        List<User> members = new ArrayList<>();

        for (String userId : userIds) {
            members.add(userService.getUser(userId));
        }
        Group group = new Group(groupId, name, members);
        groups.put(groupId, group);
        return group;
    }

    public void addMember(String groupId, String userId) {
        Group group = groups.get(groupId);
        User user = userService.getUser(userId);
        group.addMember(user);
    }

    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }

    public Map<String, Group> getGroups() {
        return groups;
    }
}
