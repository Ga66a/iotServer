package ru.ga66a.iotServer.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.domain.Indicator;

@Service
public class OpenTSDBServiceImpl implements ru.ga66a.iotServer.service.OpenTSDBService {
    @Value("${opentsdb.host:http://localhost:4242}")
    String serverHost;
    @Value("${opentsdb.apipath:/api}")
    String apiPath;

    @Override
    public void put(Device device) {

        JSONArray indicatorsJson = getOpenTSBDJson(device);
        if (!indicatorsJson.isEmpty()) {
            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl = serverHost + apiPath+"/put";
            restTemplate.postForLocation(
                    resourceUrl,
                    indicatorsJson.toString());
        }
    }


    private JSONArray getOpenTSBDJson(Device device) {
        JSONArray jsonArray = new JSONArray();
        for (Indicator indicator : device.getIndicators()) {
            if (indicator.getCurrentState() != null) {
                jsonArray.put(getJsonIndicator(
                        indicator,
                        indicator.getType(),
                        indicator.getCurrentState().toString(),
                        "currentState"));
            }
            if (indicator.getTargetState() != null) {
                jsonArray.put(getJsonIndicator(
                        indicator,
                        indicator.getType(),
                        indicator.getIndication().toString(),
                        "targetState"));
            }
            if (indicator.getIndication() != null) {
                jsonArray.put(getJsonIndicator(
                        indicator,
                        indicator.getType(),
                        indicator.getIndication().toString(),
                        null));
            }
        }
        return jsonArray;
    }

    private JSONObject getJsonIndicator(Indicator indicator, String type, String value, String state) {
        JSONObject tags = new JSONObject();
        tags.put("mak", indicator.getDeviceMak());
        tags.put("name", indicator.getName());
        tags.put("type", indicator.getType());
        if (state != null) {
            tags.put("state", state);
        }

        JSONObject item = new JSONObject();
        item.put("metric", "iot");


        item.put("tags", tags);
        item.put("value", value);

        return item;
    }
}
