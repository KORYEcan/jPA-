package jpabook.jpashop.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "ORDERS")
public class Order extends  BaseEntity {

  @Id @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

   @OneToOne(fetch = LAZY ,cascade = CascadeType.ALL)
   @JoinColumn(name = "DELIVERY_ID")
  private Delivery delivery;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "MEMBER_ID")
  private Member member;


  @OneToMany(mappedBy = "order")
  private List<Orderitem> orderItems = new ArrayList<>();


  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public LocalDateTime getOrderDate() {
    return orderDate;
  }
  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }
  public OrderStatus getStatus() {
    return status;
  }
  public void setStatus(OrderStatus status) {
    this.status = status;
  }


}
