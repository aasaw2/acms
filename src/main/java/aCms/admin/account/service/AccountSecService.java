package aCms.admin.account.service;

import aCms.admin.account.dao.AccountDao;
import aCms.admin.account.domain.Account;
import aCms.admin.account.domain.dto.AccountDto;
import aCms.admin.authority.dao.AuthorityDao;
import aCms.admin.authority.domain.Authority;
import aCms.admin.division.Dao.DivisionDao;
import aCms.admin.division.domain.Division;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountSecService {

    private AccountDao accountDao;
    private DivisionDao divisionDao;
    private AuthorityDao authorityDao;
    private ModelMapper modelMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AccountSecService(AccountDao accountDao, DivisionDao divisionDao, AuthorityDao authorityDao, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountDao = accountDao;
        this.divisionDao = divisionDao;
        this.authorityDao = authorityDao;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Account join(AccountDto.AccountWrite accountWrite) {

        Division division = new Division(accountWrite);
        Authority authority = new Authority(accountWrite);

        Account account = Account.builder()
                .email(accountWrite.getEmail())
                .passowrd(bycrypt(accountWrite.getPassword()))
                .name(accountWrite.getAccountName())
                .division(division)
                .authority(authority)
                .build();

        return accountDao.save(account);
    }

    public PageImpl<AccountDto.AccountList> accountPageable(Pageable pageable, ModelMapper modelMapper) {
        List<AccountDto.AccountList> accountList;
        Page<Account> accountPage = accountDao.findAllAccount(pageable);
        accountList = accountPage.getContent().parallelStream()
                .map(account -> modelMapper.map(account, AccountDto.AccountList.class))
                .collect(Collectors.toList());
        PageImpl<AccountDto.AccountList> result = new PageImpl<>(accountList, pageable, accountPage.getTotalElements());
        return result;
    }

    public List<Division> findDivisionAll() {
        return divisionDao.findAllDivision();
    }

    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    public AccountDto.AccountView update(long id) {
        Account account = accountDao.findOne(id);
        account.setCmd("update");
        System.out.println("what the : " + account.getAuthority().getId());
        AccountDto.AccountView accountView = modelMapper.map(account, AccountDto.AccountView.class);
        return accountView;
    }

    public Account update(AccountDto.AccountUpdate accountUpdate, Long id) {
        Account account = accountDao.findOne(accountUpdate.getId());
        accountUpdate.setDivision(divisionDao.findById(Long.valueOf(accountUpdate.getDivisionId())));
        accountUpdate.setAuthority(authorityDao.findOne(Long.valueOf(accountUpdate.getAuthorityId())));
        AccountDto.AccountUpdate accountUpdate1 = updateBCrypt(accountUpdate);
        account.update(accountUpdate1);
        return accountDao.save(account);
    }

    private String bycrypt(String password) {
        String changePassword = bCryptPasswordEncoder.encode(password);
        return changePassword;
    }

    private AccountDto.AccountUpdate updateBCrypt(AccountDto.AccountUpdate accountUpdate) {
        String password = bCryptPasswordEncoder.encode(accountUpdate.getPassword());
        accountUpdate.setPassword(password);
        return accountUpdate;
    }

    public void delete(Long id) {
        accountDao.delete(id);
    }

    public List<Division> findDivision() {
        return divisionDao.findAll();
    }

    public List<Authority> findAuthority() {
        return authorityDao.findAll();
    }

    public Account findAccountByContextHolder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String email = user.getUsername();
        Account account = accountDao.findByEmail(email);
        return account;
    }
}
