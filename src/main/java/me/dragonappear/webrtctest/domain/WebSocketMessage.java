package me.dragonappear.webrtctest.domain;

import lombok.*;

@ToString
@EqualsAndHashCode(of = {"from","type","data","candidate","sdp"})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WebSocketMessage {
    private String from;
    private String type;
    private String data;
    private Object candidate;
    private Object sdp;
}
