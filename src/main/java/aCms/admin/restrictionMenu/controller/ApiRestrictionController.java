package aCms.admin.restrictionMenu.controller;

import aCms.admin.restriction.service.RestrictionService;
import aCms.admin.restrictionMenu.domain.dto.RestrictionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restriction")
public class ApiRestrictionController {

    private RestrictionService restrictionService;

    @Autowired
    public ApiRestrictionController(RestrictionService restrictionService) {
        this.restrictionService = restrictionService;
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody RestrictionDto.create restrictionDto) {
        restrictionService.create(restrictionDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable long id, @RequestBody RestrictionDto.create restrictionDto) {
        restrictionService.update(id, restrictionDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        restrictionService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
