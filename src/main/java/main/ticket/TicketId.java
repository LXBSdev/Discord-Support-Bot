package main.ticket;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketId implements Serializable {
    private Integer ticketId;

    @JsonCreator
    public TicketId (@JsonProperty("ticketId") Integer ticketId) {
        this.ticketId = ticketId;
    }

    public void setTicketId(Integer lticketId) {
        if (lticketId > 0) {
            ticketId = lticketId;
        }
    }

    public Integer getTicketId() {
        return ticketId;
    }
}
