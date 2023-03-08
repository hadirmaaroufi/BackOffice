package tn.esprit.pidev.bns.controller.wassim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.wassim.Request;
import tn.esprit.pidev.bns.repository.wassim.RequestRepository;
import tn.esprit.pidev.bns.serviceInterface.wassim.RequestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/read")
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/getRequest/idRequest")
    public Optional<Request> getRequestById(@PathVariable(value="idRequest") int id) {
        return requestService.getRequestById(id);
    }

    @PostMapping("/create")
    public Request createRequest(@RequestBody Request request) {
        return requestService.createRequest(request);
    }

    @PutMapping("updateRequest/{idRequest}")
    public Request updateRequest(@PathVariable int idRequest, @RequestBody Request requestDetails) {
        return requestService.updateRequest(idRequest,requestDetails );
    }

    @DeleteMapping("/delete/{idRequest}")
    public void deleteRequest(@PathVariable  int idRequest) {

        requestService.deleteRequest(idRequest);
    }
}
