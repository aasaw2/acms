package aCms.admin.division.Controller;

import aCms.admin.division.Service.DivisionService;
import aCms.admin.division.domain.dto.DivisionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class ApiDivisionController {

    private DivisionService divisionService;

    @Autowired
    public ApiDivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @RequestMapping(value = "/division/create", method = RequestMethod.POST)
    public ResponseEntity write(@RequestBody DivisionDto.divisionWrite divisionDto) {
        divisionService.create(divisionDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/division/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity urpdate(@PathVariable long id, @RequestBody DivisionDto.divisionWrite divisionDto) {
        divisionService.update(id, divisionDto);
        return new ResponseEntity(HttpStatus.OK);
    }


}
