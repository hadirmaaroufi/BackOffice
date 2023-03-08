package tn.esprit.pidev.bns.service.ibtihel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.pidev.bns.entity.hadir.Category;
import tn.esprit.pidev.bns.entity.hadir.Product;
import tn.esprit.pidev.bns.entity.ibtihel.Cart;
import tn.esprit.pidev.bns.entity.ibtihel.CommandLine;
import tn.esprit.pidev.bns.repository.hadir.ProductRep;
import tn.esprit.pidev.bns.repository.ibtihel.CartRepo;
import tn.esprit.pidev.bns.repository.ibtihel.CommandLineRepo;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.ICommandeLine;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CommandeLineService implements ICommandeLine {
    @Autowired
    CommandLineRepo commandLineRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductRep productRep;



    // ////commandLine //////
    @Override
    public CommandLine addCommandLine(CommandLine commandLine,Integer idCart) {
        Cart cart = cartRepo.findById(idCart).orElseThrow(() -> new NotFoundException("Catégorie non trouvée"));
        cart.getCommandLines();
        commandLine.setCart(cart);
        cartRepo.save(cart);
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
    public void assignProductToCommandeL(Integer LigneCommande, List<Integer> idProduct) {
        CommandLine commandLine = commandLineRepo.findById(LigneCommande).get();
        List<Product> products = productRep.findAllById(idProduct);
        commandLine.getProducts().addAll(products);
        commandLineRepo.save(commandLine);
    }


}
