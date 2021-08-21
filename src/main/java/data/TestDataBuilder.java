package data;

import pojo.PostUsers;

public class TestDataBuilder {
    public static PostUsers getPostUserData(String name, String job) {
        return PostUsers.builder().name(name).job(job).build();
    }
}
