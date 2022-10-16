package kr.rhinitis.secondduoproject.item.entity;

import kr.rhinitis.secondduoproject.item.dto.ItemDto;
import kr.rhinitis.secondduoproject.util.audit.Auditable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends Auditable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String title;
    private String body;
    private Integer price;
    private String itemName;
    private ItemStatus status;
    private PaymentMethod paymentMethod;

    //private Member member;
    //private Category category;

    public enum ItemStatus{
        ON_SALE("판매중"),
        SOLD_OUT("판매완료"),
        INACTIVE("비활성화");

        String postDescription;

        ItemStatus(String postDescription) {
            this.postDescription = postDescription;
        }
    }

    public enum PaymentMethod{
        DIRECT("직거래"),
        DELIVERY("택배");

        String postDescription;

        PaymentMethod(String postDescription) {
            this.postDescription = postDescription;
        }
    }

    public Item(Long itemId, String title, String body, Integer price, String itemName, ItemStatus status, PaymentMethod paymentMethod) {
        this.itemId = itemId;
        this.title = title;
        this.body = body;
        this.price = price;
        this.itemName = itemName;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public void updateItem(ItemDto.Patch patchDto){
        this.title = patchDto.getTitle();
        this.body = patchDto.getBody();
        this.price = patchDto.getPrice();
        this.itemName = patchDto.getItemName();
        //this.paymentMethod = paymentMethod;
    }
}
