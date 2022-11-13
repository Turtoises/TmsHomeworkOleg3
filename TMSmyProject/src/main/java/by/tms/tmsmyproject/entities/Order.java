package by.tms.tmsmyproject.entities;

import by.tms.tmsmyproject.entities.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractEntity{

    private Long userID;
    private OrderStatus orderStatus;
    private Author author;
    private Book book;

}
