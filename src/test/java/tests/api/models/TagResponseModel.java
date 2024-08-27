package tests.api.models;

import lombok.Data;

import java.util.List;

@Data
public class TagResponseModel {

    Boolean success;
    Data data;
    List<NotificationsModel> notifications;
    String appVersion;
    int userV;

    @lombok.Data
    public static class Data {
        String name, id;
    }

    @lombok.Data
    public static class NotificationsModel {
        String type;
        NotificationData data;
        Boolean seen;
        String id;

        @lombok.Data
        public static class NotificationData {
            String title;
        }
    }
}
