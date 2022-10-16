package kr.rhinitis.secondduoproject.item.dto;

import kr.rhinitis.secondduoproject.item.entity.Item;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ItemDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Post{
        private String title;
        private String body;
        private Integer price;
        private String itemName;
        private String paymentMethod;

        @Builder
        public Post(String title, String body, Integer price, String itemName, String paymentMethod) {
            this.title = title;
            this.body = body;
            this.price = price;
            this.itemName = itemName;
            this.paymentMethod = paymentMethod;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Patch{
        private String title;
        private String body;
        private Integer price;
        private String itemName;
        private String paymentMethod;

        public Patch(String title, String body, Integer price, String itemName, String paymentMethod) {
            this.title = title;
            this.body = body;
            this.price = price;
            this.itemName = itemName;
            this.paymentMethod = paymentMethod;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class Response{
        private Long itemId;
        private String title;
        private String body;
        private Integer price;
        private String itemName;
        private Item.ItemStatus status;
        private Item.PaymentMethod paymentMethod;

        @Builder
        public Response(Long itemId, String title, String body, Integer price, String itemName, Item.ItemStatus status, Item.PaymentMethod paymentMethod) {
            this.itemId = itemId;
            this.title = title;
            this.body = body;
            this.price = price;
            this.itemName = itemName;
            this.status = status;
            this.paymentMethod = paymentMethod;
        }
    }

}
