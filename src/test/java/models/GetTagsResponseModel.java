package models;


import lombok.Data;

import java.util.List;

@Data
public class GetTagsResponseModel {
    int userV;
    String appVersion;
    Boolean success;
    List<TagDataModel> data;
    List<NotificationsModel> notifications;

    @Data
    public static class TagDataModel {
        String id, name;

    }

    @lombok.Data
    public static class NotificationsModel {
        String type;
        TagResponseModel.NotificationsModel.NotificationData data;
        Boolean seen;
        String id;

        @lombok.Data
        public static class NotificationData {
            String title;
        }
    }
}
