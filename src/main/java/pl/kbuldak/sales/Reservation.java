package pl.kbuldak.sales;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Reservation {

    @Id
    private final String id;
    private final BigDecimal total;
    private final String paymentId;

    public Reservation(String id, BigDecimal total, String paymentId) {
        this.id = id;
        this.total = total;
        this.paymentId = paymentId;
    }

    public String getId() {
        return id;
    }
}
