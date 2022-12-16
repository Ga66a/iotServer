package ru.ga66a.iotServer.controller.victoriametrics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.ga66a.iotServer.domain.Device;
import ru.ga66a.iotServer.domain.Indicator;

@Component
public class VictoriaMetricsController {
    @Value("${victoriametrics.host:http://localhost:8428}")
    String serverHost;
    @Value("${victoriametrics.apipath:/api/v1/import/prometheus}")
    String apiPath;
    public void push(Device device) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://10.196.72.8:8428/api/v1/import/prometheus";
        //String importString = "\"dacha{voltage=\\\"accum\\\"} ";
        for (Indicator indicator : device.getIndicators()) {
            if (indicator.getCurrentState() != null) {
                restTemplate.postForObject(
                        resourceUrl,
                        indicatorToPrometheusDto(indicator, "CurrentState", indicator.getCurrentState().toString()),
                        String.class);
            }
            if (indicator.getTargetState() != null) {
                restTemplate.postForObject(
                        resourceUrl,
                        indicatorToPrometheusDto(indicator, "TargetState", indicator.getTargetState().toString()),
                        String.class);
            }
            if (indicator.getIndication() != null) {
                restTemplate.postForObject(
                        resourceUrl,
                        indicatorToPrometheusDto(indicator, "Indication", indicator.getIndication().toString()),
                        String.class);
            }
        }
    }

    private static String indicatorToPrometheusDto(Indicator indicator, String metric, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("iot{");
        stringBuilder.append("mak=\"" + indicator.getDeviceMak() + "\",");
        stringBuilder.append("name=\"" + indicator.getName() + "\",");
        stringBuilder.append("type=\"" + indicator.getType() + "\",");
        stringBuilder.append("metric=\"" + metric + "\"");
        stringBuilder.append("}" + value);
        return stringBuilder.toString();
    }
}
