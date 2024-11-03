package src.main.java.com.ctgu.work3;

import java.util.Date;

public class A1_4 {
    public class Customer{
        private String name;
        private String contact;
        private String deliveryAddress;
        private String active;
        private Order order;
    }
    public class Order{
        private Date createDate;
        private String status;
        private Customer customer;
        private OrderDetail orderDetail;
        private Product product;
        private Payment payment;

    }
    public class OrderDetail{
        private Integer quantity;
        public void calculateSubTotal(){

        }


        public void calculateWeight(){

        }


    }
    public class Product{
        private String title;
        private Integer weight;
        private String description;
        public Integer getPriceForQuantity() {
            return weight;
        }
        public Integer  getWeight() {
            return weight;
        }

    }
    public class Payment{
        private Integer amount;
        private Credit credit;
        private Cash cash;
        private WireTransfer wireTransfer;
        private AliPay aliPay;
        private WeixinPay weixinPay;

    }
    public class Credit{
        private String number;
        private String type;
        private Date expireDate;

    }
    public class Cash{
        private Integer cashTendered;

    }
    public class WireTransfer{
        private String bankID;
        private String bankName;

    }
    public class AliPay{
        private String number;

    }
    public class WeixinPay{
        private String number;
    }
}
