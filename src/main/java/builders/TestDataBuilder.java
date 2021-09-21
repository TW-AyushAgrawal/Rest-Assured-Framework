package builders;

import pojo.PostUsers;

public final class TestDataBuilder {
    public static PostUsers getPostUserData(String input) {
        String[] inputs = input.split(",");
        return PostUsers.builder().name(inputs[0]).job(inputs[1]).build();
    }
}
