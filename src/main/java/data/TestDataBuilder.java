package data;

import pojo.PostUsers;

public class TestDataBuilder {
    public PostUsers getPostUserData(String name, String job){
        PostUsers postUser = new PostUsers();
        postUser.setName(name);
        postUser.setJob(job);
        return postUser;
    }
}
