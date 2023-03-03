package tn.esprit.pidev.bns.service.ibtihel;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.webjars.NotFoundException;
import tn.esprit.pidev.bns.entity.hadir.Product;
import tn.esprit.pidev.bns.entity.ibtihel.*;
import tn.esprit.pidev.bns.entity.omar.Deliverer;
import tn.esprit.pidev.bns.entity.omar.User;
import tn.esprit.pidev.bns.repository.hadir.ProductRepo;
import tn.esprit.pidev.bns.repository.ibtihel.*;
import tn.esprit.pidev.bns.repository.omar.DelivererRepo;
import tn.esprit.pidev.bns.repository.omar.IUserRepo;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IServiceIbtihel;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceIbtihel implements IServiceIbtihel {


    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    DeliveryRepo deliveryRepo;
@Autowired
    CommandLineRepo commandLineRepo;
@Autowired
    DelivererRepo delivererRepo;
@Autowired
    ProductRepo productRepo;

@Autowired
   private PaymentRepo paymentRepo;

@Autowired
    IUserRepo userRepo;



///stripe
//@Value("sk_test_51Khl7ZAmmAEwNuySJwTRMgb230wvzoZdIK2y9TshyH9zw23VcRLJtZFu9X3oL4CHhPUUjdnwFZKs7i3GCsLYaAhI00CeUoUGzp")
//String stripeKey;



// ////commandLine //////
    @Override
    public CommandLine addCommandLine(CommandLine commandLine) {
        return commandLineRepo.save(commandLine);
    }

    @Override
    public CommandLine updateCommandLine(CommandLine commandLine) {
        return commandLineRepo.save(commandLine);
    }

    @Override
    public CommandLine deleteCommandLine(Integer idCommandLine) {
        commandLineRepo.deleteById(idCommandLine);
        return null;
    }

    @Override
    public List<CommandLine> ListCommandLine() {
        return  (List<CommandLine>) commandLineRepo.findAll();
    }

    @Override
    public CommandLine ListCommanLineById(Integer idCommandLine) {
        return commandLineRepo.findById(idCommandLine).get();
    }







    /// cart ///////////////////
    @Override
    public Cart saveCart(Cart cart, Integer idCommandLine) {



        CommandLine commandLine = commandLineRepo.findById(idCommandLine).orElseThrow(()
                -> new NotFoundException("ligne commande non trouvée"));
        commandLine.getCart();
        Set<CommandLine> commandLines = new HashSet<CommandLine>();
        commandLines.add(commandLine);
        cart.setCommandLines(commandLines);

        commandLineRepo.save(commandLine);

        return cartRepo.save(cart);


    }


    @Override
    public void assignCommandeLineToCart(Integer idCommandLine, Integer idCart) {
        Cart cart= cartRepo.findById( idCart).get();
        CommandLine commandLine= commandLineRepo.findById(idCommandLine).get();
        commandLine.setCart(cart);
        commandLineRepo.save(commandLine);

    }


    @Override
    public Cart updateCart(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public Cart deleteCart(Integer idCart) {
        cartRepo.deleteById(idCart);
        return null;
    }

    @Override
    public List<Cart> ListCart() {
        return  (List<Cart>) cartRepo.findAll();
    }

    @Override
    public Cart ListCartById(Integer idCart) {
        return cartRepo.findById(idCart).get();
    }









    //// order ////////
    @Override
    public PurchaseOrder addPurchaseOrder(PurchaseOrder order) {

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


    /////// Delivery ////////

    @Override
    public Delivery addDelivery(Delivery delivery) {
                deliveryRepo.save(delivery);
                sendSMS(delivery);
                return delivery;
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    @Override
    public Delivery deleteDelivery(Integer idDelivery) {
        deliveryRepo.deleteById(idDelivery);
        return null;
    }

    @Override
    public List<Delivery> ListDelivery() {
        return (List<Delivery>) deliveryRepo.findAll();
    }

    @Override
    public Delivery ListDeliveryById(Integer idDelivery) {
        return deliveryRepo.findById(idDelivery).get();
    }

    @Override
    public int notstarted(int id) {
        return deliveryRepo.notstarted(id);
    }

    @Override
    public int delivered(int id) {
        return deliveryRepo.delivered(id);
    }

    @Override
    public int inProgress(int id) {
        return deliveryRepo.inProgress(id);
    }

    @Override
    public String availableDelivery(int id) {
        int ns=deliveryRepo.notstarted(id);
        int del=deliveryRepo.delivered(id);
        int ip=deliveryRepo.inProgress(id);

        float pns= ((float)ns/((float)del+(float)ip+(float)ns))*100;
        float pdel= ((float)del/((float)del+(float)ip+(float)ns))*100;
        float pip= ((float)ip/((float)del+(float)ip+(float)ns))*100;

        String sns=String.valueOf(ns);
        String sdel=String.valueOf(del);
        String sip=String.valueOf(ip);
        String t=String.valueOf(deliveryRepo.total(id));
        return "delivery Not Started : "+sns+"  :   "+String.valueOf((int)pns)+
                "%    delivery In Progress : "+sip+"  :  "+String.valueOf((int)pip)+"%"+
                "%    delivery delivered : "+sdel+"  :  "+String.valueOf((int)pdel)+"% "+
                "\n" +" Total deliveries : "+t;

    }


    @Override
    public void assignDelivererToDelivery(Integer idDelivery, Integer idDeliverer) {
        Deliverer deliverer =delivererRepo.findById( idDeliverer).get();
        Delivery delivery= deliveryRepo.findById(idDelivery).get();
        delivery.setDeliverer(deliverer);
        deliveryRepo.save(delivery);
    }

    @Override
    public void assignDeliveryToOrder(Integer idOrder, Integer idDelivery) {
        Delivery delivery= deliveryRepo.findById(idDelivery).get();
        PurchaseOrder purchaseOrder= purchaseOrderRepo.findById(idOrder).get();
        purchaseOrder.setDelivery(delivery);
        purchaseOrderRepo.save(purchaseOrder);

    }




    /////add product to commandline//////
    @Override
    public CommandLine addProductToCommandLine(int idCommandLine, int idProduct) {
        CommandLine commandLine = commandLineRepo.findById(idCommandLine).get();
        Product product = productRepo.findById(idProduct).get();
        commandLine.getProducts();
        product.setStock(product.getStock()-1);
        commandLine.setQuantity(commandLine.getQuantity()+1);
        return commandLineRepo.save(commandLine);
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


    ///// ******** SMS ***********

  @Autowired
    public static final String ACCOUNT_SID = "AC62f2665fc874d6b5b8e686e25c25e442";
    @Autowired
    public static final String AUTH_TOKEN = "241967025561bd056e77cfc678976411";



    public  void sendSMS(Delivery delivery) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(delivery.getPhoneNumber()),
                new PhoneNumber("+12766002091"),
                "New Delivery has been added "+
                        "\r"+"Delivery Date : "+delivery.getDeliveryDate()+
                        "\r"+" Arrival  Date :"+delivery.getArrivalDate()+
                        "\r"+"Adresse :"+delivery.getAddress()+
                        "\r"+"Total price :"+delivery.getTotalPrice()+
                        "\r"+"Delivery Status :"+delivery.getDeliveryStatus()

        ).create();

        System.out.println(message.getSid());
    }





 /////////////// Payment STRIPE ///////

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
        chargeParams.put("amount", Math.round(TotalOrdersTVA(idOrder)));
        chargeParams.put("currency", "usd");
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
