package tn.esprit.pidev.bns.serviceInterface.ibtihel;

import tn.esprit.pidev.bns.entity.ibtihel.Cart;
import tn.esprit.pidev.bns.entity.ibtihel.CommandLine;

import java.util.List;

public interface ICommandeLine {

    //commandline
    public CommandLine addCommandLine(CommandLine commandLine, Integer idCart);
    public CommandLine updateCommandLine(CommandLine commandLine);
    public CommandLine deleteCommandLine(Integer idCommandLine);
    List<CommandLine> ListCommandLine();

    public CommandLine ListCommanLineById(Integer idCommandLine);
    public void assignProductToCommandeL(Integer LigneCommende, List<Integer> idProduct);
}
