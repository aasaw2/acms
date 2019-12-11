package aCms.admin.system.code.controller;

import aCms.admin.system.code.domain.Code;
import aCms.admin.system.code.domain.dto.CodeDetailDto;
import aCms.admin.system.code.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/code")
public class ApiCodeController {

    private CodeService codeService;

    @Autowired
    public ApiCodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Code code) {
        System.out.println("check code create");
        codeService.create(code);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity update(@PathVariable long id, @RequestBody Code code) {
        codeService.update(code, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        codeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/create", method = RequestMethod.POST)
    public ResponseEntity createCodeDetail(@PathVariable long id, @RequestBody CodeDetailDto.Create codeDetail) {
        codeService.codeDetailCreate(codeDetail, id);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/update/{detailId}", method = RequestMethod.PUT)
    public ResponseEntity updateCodeDetail(@PathVariable long id, @PathVariable long detailId, @RequestBody CodeDetailDto.Create codeDetailDto) {
        System.out.println("update workingDASdfjabsd");
        codeService.codeDetailupdate(codeDetailDto, detailId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/codeDetail/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCodeDetail(@PathVariable long id) {
        System.out.println("come come!");
        codeService.codeDetailDelete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
