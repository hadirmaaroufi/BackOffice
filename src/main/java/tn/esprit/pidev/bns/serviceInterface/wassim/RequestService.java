package tn.esprit.pidev.bns.serviceInterface.wassim;

import tn.esprit.pidev.bns.entity.wassim.Request;

import java.util.List;
import java.util.Optional;

public interface RequestService {
    List<Request> getAllRequests();

    Optional<Request> getRequestById(int idRequest);

    Request createRequest(Request request);

    Request updateRequest(int idRequest, Request requestDetails);

    String deleteRequest(int idRequest);

}
