package aCms.admin.account.controller;

import aCms.admin.account.domain.Account;
import aCms.admin.account.domain.dto.AccountDto;
import aCms.admin.account.service.AccountSecService;
import aCms.admin.common.annotation.LogExecutionTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/admin/Account")
public class AccountSecController {

    private AccountSecService accountSecService;
    private ModelMapper modelMapper;

    @Autowired
    public AccountSecController(AccountSecService accountSecService, ModelMapper modelMapper) {
        this.accountSecService = accountSecService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @LogExecutionTime
    public String AccountList(@PageableDefault(size = 10, sort = "regDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        PageImpl<AccountDto.AccountList> result = accountSecService.accountPageable(pageable, modelMapper);
        model.addAttribute("resultList", result);
        return "AccountList";
    }

    @RequestMapping(value = "/JoinMember", method = GET)
    public String AccountSignUp(Model model) {
        model.addAttribute("divisionList", accountSecService.findDivision());
        model.addAttribute("authorityList", accountSecService.findAuthority());
        return "JoinMember";
    }

    @ResponseBody
    @RequestMapping(value = "/JoinMemberProcessing", method = POST)
    public ResponseEntity JoinMember(@Valid AccountDto.AccountWrite accountWrite, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Account account = accountSecService.join(accountWrite);
        return new ResponseEntity<>(modelMapper.map(account, AccountDto.AccountView.class), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method = GET)
    public String AccountUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("account", accountSecService.update(id));
        model.addAttribute("divisionList", accountSecService.findDivision());
        model.addAttribute("authorityList", accountSecService.findAuthority());
        return "JoinMember";
    }

    @ResponseBody
    @RequestMapping(value = "/UpdateMemperProcessing/{id}", method = POST)
    public ResponseEntity UpdateMemperProcessing(@PathVariable Long id,
                                                 @Valid AccountDto.AccountUpdate accountUpdate, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Account account =  accountSecService.update(accountUpdate, id);
        return new ResponseEntity<>(account.getId(),HttpStatus.OK);
    }

    @RequestMapping(value = "/DeleteAccountMember.ap/{id}", method = POST)
    @ResponseBody
    private ResponseEntity DeleteAccountMember(@PathVariable Long id) {
        accountSecService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}