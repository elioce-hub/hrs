package hrs;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="HotelReservationManagement_table")
public class HotelReservationManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reservationId;
    private String status;

    @PostPersist
    public void onPostPersist(){
        ReservationConfirmed reservationConfirmed = new ReservationConfirmed();
        BeanUtils.copyProperties(this, reservationConfirmed);
        reservationConfirmed.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate(){
        ReservationConfirmedCanceled reservationConfirmedCanceled = new ReservationConfirmedCanceled();
        BeanUtils.copyProperties(this, reservationConfirmedCanceled);
        reservationConfirmedCanceled.publishAfterCommit();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
