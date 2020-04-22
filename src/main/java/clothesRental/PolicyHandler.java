package clothesRental;

import clothesRental.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    PaymentProcessingRepository paymentProcessingRepository;
    PaymentProcessing paymentProcessing = new PaymentProcessing();
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserveChanged_PaymentCanceled(@Payload ReserveChanged reserveChanged){

        if(reserveChanged.isMe()){
            System.out.println("##### listener PaymentCanceled : " + reserveChanged.toJson());

            paymentProcessing.setProductStatus(reserveChanged.getProductStatus());
            paymentProcessingRepository.save(paymentProcessing);

            System.out.println("##### listener 결제 변경,예약 취소 : " + reserveChanged.toJson());

        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserveCanceled_PaymentCanceled(@Payload ReserveCanceled reserveCanceled){

        if(reserveCanceled.isMe()){
            System.out.println("##### listener PaymentCanceled : " + reserveCanceled.toJson());

            paymentProcessing.setProductStatus(reserveCanceled.getProductStatus());
            paymentProcessingRepository.save(paymentProcessing);

            System.out.println("##### listener 결제 취소,예약 취소 : " + reserveCanceled.toJson());
        }
    }

}
