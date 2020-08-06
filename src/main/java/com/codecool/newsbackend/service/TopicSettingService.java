package com.codecool.newsbackend.service;

import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.entity.TopicSettingSend;
import com.codecool.newsbackend.repository.TopicSettingRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


@Service
public class TopicSettingService {

    @Autowired
    private TopicSettingRepository topicSettingRepository;

    public void updateUserTopicSettings(TopicSetting topicSetting, String username) {

        topicSettingRepository.updateUserTopicSettingsByUserName(username, topicSetting.isBusiness(),
                topicSetting.isEntertainment(), topicSetting.isGeneral(), topicSetting.isHealth(),
                topicSetting.isScience(), topicSetting.isSports(), topicSetting.isTechnology());
    }

    public String buildUserChosenTopicSelection(String username) throws IllegalAccessException {

        //TopicSetting userChosenTopicsByUserId = topicSettingRepository.getUserChosenTopicsByUserId(user_id);
        TopicSetting userChosenTopicsByUserName = topicSettingRepository.getUserChosenTopicsByUserName(username);
        Map<String, Object> myObjectAsDict = new HashMap<>();
        Field[] allFields = TopicSetting.class.getFields();
        for (Field field : allFields) {
            Object value = field.get(userChosenTopicsByUserName);
            myObjectAsDict.put(field.getName(), value);
        }

        JsonArray allSelectedTopics = new JsonArray();
        myObjectAsDict.forEach((k,v) -> {
            if(v.equals(true)) {
                try {
                    String response = MyGETRequestWithLimit(k, 4);
                    JsonObject singleTopic = new JsonObject();
                    JsonObject convertedResponse = new Gson().fromJson(response, JsonObject.class);
                    singleTopic.add(k, convertedResponse);
                    allSelectedTopics.add(singleTopic);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return allSelectedTopics.toString();
    }

    public TopicSettingSend getTopicSettingForUser(String username) {
        TopicSetting setting = topicSettingRepository.getUserChosenTopicsByUserName(username);
        return new TopicSettingSend(setting.isBusiness(), setting.isEntertainment(), setting.isGeneral(), setting.isHealth(), setting.isScience(), setting.isSports(), setting.isTechnology());
    }

    public static String MyGETRequestWithLimit(String topic, int limit) throws IOException {

        URL urlForGetRequest = new URL("http://newsapi.org/v2/top-headlines?country=us&category=" + topic + "&pageSize="+ limit+"&apiKey=687acd6f80d44fe0b6c2c28d162fa674");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            return response.toString();
        } else {

            System.out.println("GET NOT WORKED: " + urlForGetRequest );
            return "something went wrong :( url not working: " + urlForGetRequest;
        }

    }

}
