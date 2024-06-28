package software.kasunkavinda.ticket_service.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.kasunkavinda.ticket_service.dto.ResponseDTO;
import software.kasunkavinda.ticket_service.dto.TicketDTO;
import software.kasunkavinda.ticket_service.service.TicketService;

@RestController
@RequestMapping("/api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final ResponseDTO responseDTO;

    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createTicket(@RequestBody TicketDTO ticketDTO) {

        logger.info("Saving Ticket details");
        try {
            String opt = ticketService.newTicket(ticketDTO);
            if (opt.equals("Ticket id already exists")) {
                responseDTO.setCode("400");
                responseDTO.setMessage("Ticket already exists");
                responseDTO.setContent(ticketDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.MULTI_STATUS);
            } else {
                responseDTO.setCode("200");
                responseDTO.setMessage("Ticket saved successfully");
                responseDTO.setContent(ticketDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception exception) {
            logger.error("Error saving Ticket: ", exception);
            responseDTO.setCode("500");
            responseDTO.setMessage("Internal server error");
            responseDTO.setContent(exception.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateTicket(@RequestBody TicketDTO ticketDTO) {
        logger.info("Updating Ticket details");

        ResponseEntity<ResponseDTO> responseEntity = new ResponseEntity<>(responseDTO,HttpStatus.OK);

        try {
            String resp = ticketService.updateTicket(ticketDTO);
            if (resp.equals("Tick updated successfully")) {
                responseDTO.setCode("200");
                responseDTO.setMessage("Ticket updated successfully");
                responseDTO.setContent(ticketDTO);
               responseEntity =  new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        } catch (Exception exception) {
            logger.error("Error updating ticket: ", exception);
            responseDTO.setCode("500");
            responseDTO.setMessage("Internal server error");
            responseDTO.setContent(exception.getMessage());
            responseEntity= new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSelectedTicket(@PathVariable String id) {
        logger.info("Fetching ticket with ID: {}", id);
        try {
            TicketDTO ticketDTO = ticketService.getTicket(id);
            return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
        } catch (Exception exception) {
            logger.error("Error fetching ticket by ID: {}", id, exception);
            responseDTO.setCode("500");
            responseDTO.setMessage("Internal server error");
            responseDTO.setContent(exception.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
