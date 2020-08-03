package hrs;

import hrs.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationConfirmedCanceled_Reservationstatuschange(@Payload ReservationConfirmedCanceled reservationConfirmedCanceled){

        if(reservationConfirmedCanceled.isMe()){
            System.out.println("##### listener Reservationstatuschange : " + reservationConfirmedCanceled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationConfirmed_Reservationstatuschange(@Payload ReservationConfirmed reservationConfirmed){

        if(reservationConfirmed.isMe()){
            System.out.println("##### listener Reservationstatuschange : " + reservationConfirmed.toJson());
        }
    }

}
