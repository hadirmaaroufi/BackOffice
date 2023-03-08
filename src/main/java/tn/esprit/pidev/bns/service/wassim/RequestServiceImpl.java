package tn.esprit.pidev.bns.service.wassim;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.wassim.Request;
import tn.esprit.pidev.bns.repository.wassim.RequestRepository;
import tn.esprit.pidev.bns.serviceInterface.wassim.RequestService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RequestServiceImpl  implements RequestService
{
   // private final RequestRepository requestRepository;
    @Autowired
    private final RequestRepository requestRepository;

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Optional<Request> getRequestById(int idRequest) {
        return requestRepository.findById(idRequest);
    }

    @Override
    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Request updateRequest(int idRequest, Request requestDetails) {
        Optional<Request> optionalRequest = requestRepository.findById(idRequest);
        if (optionalRequest.isPresent()) {
            Request request  = optionalRequest.get();
            request.setTitle(requestDetails.getTitle());
            request.setContent(requestDetails.getContent());
            request.setEvidence(requestDetails.getEvidence());
            return requestRepository.save(request);
        }
        return null;
    }

    @Override
    public String deleteRequest(int idRequest) {
        requestRepository.deleteById(idRequest);
        return "Request supprimer";
    }
}
