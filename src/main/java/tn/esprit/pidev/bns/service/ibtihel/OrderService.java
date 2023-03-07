package tn.esprit.pidev.bns.service.ibtihel;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.ibtihel.*;
import tn.esprit.pidev.bns.entity.omar.User;
import tn.esprit.pidev.bns.repository.ibtihel.PaymentRepo;
import tn.esprit.pidev.bns.repository.ibtihel.PromoCodeRepo;
import tn.esprit.pidev.bns.repository.ibtihel.PurchaseOrderRepo;
import tn.esprit.pidev.bns.repository.omar.IUserRepo;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IOrder;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IPromoCode;

import javax.persistence.EntityManager;
import java.util.*;


@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderService implements IOrder {



    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;
    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    IUserRepo userRepo;





    @Override
    public PurchaseOrder confirmPurchaseOrder(PurchaseOrder order) {

        purchaseOrderRepo.save(order);
        sendmail(order);
        return order;
    }



    @Override
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder order) {
        return purchaseOrderRepo.save(order);
    }



    @Override
    public List<PurchaseOrder> ListPurchaseOrder() {

        return  (List<PurchaseOrder>) purchaseOrderRepo.findAll();
    }



    @Override
    public PurchaseOrder ListOrderById(Integer idOrder) {
        return purchaseOrderRepo.findById(idOrder).get();
    }



    @Override
    public int TotalOrdersTVA(int idOrder) {
        PurchaseOrder purchaseOrder= purchaseOrderRepo.findById(idOrder).orElse(null);
        int total = 0;
        total = (int) ((purchaseOrder.getCart().getTotalCart()*purchaseOrder.getTax())+ purchaseOrder.getCart().getTotalCart());
        return total;
    }



    //mail ***********


    @Autowired
    private JavaMailSender javaMailSender;


    @Autowired
    public void EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendmail(PurchaseOrder order)
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("ibtihelaouni90@gmail.com");
        mailSender.setPassword("enuzwoibobyecfjr");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(properties);
        String from = mailSender.getUsername();
        String to = order.getMail();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("New order");
        message.setText("New order has been added"+"\r"+"Reference : "+order.getReference()+
                "\r"+"price : "+order.getOrderPrice()+
                "\r"+" Date :"+order.getDate()+
                "\r"+"Adresse :"+order.getAddress());

        mailSender.send(message);

    }



    /////////////// Payment STRIPE ///////




    //incription lel created wel user
    @Override
    public Payment payment(int idUser, int idOrder, Payment p) throws StripeException {

        Stripe.apiKey = "sk_test_51MhUkfKKTmwWBHpLis6pDnCyZje6jrMcCx94yEbKPZjaZvvROd1PLzbEouw4wQnkgUxXkS3ZuKRKGnDe4951Mzhv004MUWaF0f";
        User user = userRepo.findById(idUser).get();
        PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(idOrder).get();
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getFirstName());
        params.put("email", user.getEmail());
        params.put("amount*100", purchaseOrder.getCart().getTotalCart());
        Customer customer = Customer.create(params);
        p.setCustomerId(customer.getId());
        return p;


    }

    @Override
    public double createCharge(String token, int idUser, int idOrder) throws StripeException {

        Optional<User> user = userRepo.findById(idUser);
        PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(idOrder).get();

        String id;
        Stripe.apiKey = "sk_test_51MhUkfKKTmwWBHpLis6pDnCyZje6jrMcCx94yEbKPZjaZvvROd1PLzbEouw4wQnkgUxXkS3ZuKRKGnDe4951Mzhv004MUWaF0f";
        Map<String, Object> chargeParams = new HashMap<>();
        //calcul tva
        chargeParams.put("amount", Math.round(TotalOrdersTVA(idOrder)));
        chargeParams.put("currency", "eur");
        chargeParams.put("source", "tok_visa"); // ^ obtained with Stripe.js
        //create a charge
        Charge charge = Charge.create(chargeParams);
        id = charge.getId();
        if (id == null) {
            throw new RuntimeException("Something went wrong!");
        }

        Payment payment = new Payment(); // Create a new Payment object
        // Set the properties of the Payment object as required
        payment.setCreated(1);
        payment.setUser(user.get());
        purchaseOrder.setPayment(payment);
        paymentRepo.save(payment);
        // payment successfully
        return TotalOrdersTVA(idOrder);

    }






}
