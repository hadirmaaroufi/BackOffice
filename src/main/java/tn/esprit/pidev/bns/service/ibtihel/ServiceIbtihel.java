package tn.esprit.pidev.bns.service.ibtihel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.pidev.bns.entity.ibtihel.Cart;
import tn.esprit.pidev.bns.entity.ibtihel.CommandLine;
import tn.esprit.pidev.bns.entity.ibtihel.Delivery;
import tn.esprit.pidev.bns.entity.ibtihel.PurchaseOrder;
import tn.esprit.pidev.bns.entity.omar.Deliverer;
import tn.esprit.pidev.bns.repository.ibtihel.CartRepo;
import tn.esprit.pidev.bns.repository.ibtihel.CommandLineRepo;
import tn.esprit.pidev.bns.repository.ibtihel.DeliveryRepo;
import tn.esprit.pidev.bns.repository.ibtihel.PurchaseOrderRepo;
import tn.esprit.pidev.bns.repository.omar.DelivererRepo;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IServiceIbtihel;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

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
    public Delivery addDelivery(Delivery delivery) {
        return  deliveryRepo.save(delivery);
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
    public void assignDeliveryToOrder(Integer idOrder, Integer idDelivery) {
      Delivery delivery =deliveryRepo.findById( idDelivery).get();
      PurchaseOrder purchaseOrder= purchaseOrderRepo.findById(idOrder).get();
        purchaseOrder.setDelivery(delivery);
        purchaseOrderRepo.save(purchaseOrder);

    }

    @Override
    public void assignCartToOrder(Integer idOrder, Integer idCart) {
        Cart cart =cartRepo.findById( idCart).get();
        PurchaseOrder purchaseOrder= purchaseOrderRepo.findById(idOrder).get();
        purchaseOrder.setCart(cart);
        purchaseOrderRepo.save(purchaseOrder);
    }

    @Override
    public void assignDelivererToDelivery(Integer idDelivery, Integer idDeliverer) {
        Deliverer deliverer =delivererRepo.findById( idDeliverer).get();
        Delivery delivery= deliveryRepo.findById(idDelivery).get();
        delivery.setDeliverer(deliverer);
        deliveryRepo.save(delivery);
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








}
