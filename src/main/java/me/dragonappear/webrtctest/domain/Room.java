package me.dragonappear.webrtctest.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.socket.WebSocketSession;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@ToString
@Data
public class Room {
    @NotNull private final Long id;
    private final Map<String, WebSocketSession> clients = new HashMap<>();
}
