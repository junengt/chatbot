package beta.chatbot.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @PostMapping(value = "/message", headers = "Accept=application/json")
    public String message(@RequestBody JSONObject job) {

        String content;
        content = (String)job.get("content");

        JSONObject jobRes = new JSONObject();
        JSONObject jobText = new JSONObject();

        //메시지 자동 응답
        if (content.contains("안녕")) {
            jobText.put("text", "안녕");
        } else if (content.contains("반가워") || content.contains("방가")) {
            jobText.put("text", "나도 반가워");
        } else if (content.contains("잘자") ||content.contains("잘 자")) {
            jobText.put("text", "너도 잘 자");
        } else if (content.contains("사랑해")) {
            jobText.put("text", "나도 사랑해");
        } else {
            jobText.put("text", "아직 이해할 수 없는 말이야");
        }

        jobRes.put("message", jobText);
        return jobRes.toString();
    }

}
