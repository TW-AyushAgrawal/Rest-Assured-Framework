package enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum APIResources {

    POST_USER_REQUEST("/api/users"),
    DELETE_USER_REQUEST("/api/users/{id}"),
    USER_ID;
    private String resource;

    public String getResource() {
        return resource;
    }

}
