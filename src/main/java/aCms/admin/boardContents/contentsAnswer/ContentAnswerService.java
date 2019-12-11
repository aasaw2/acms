package aCms.admin.boardContents.contentsAnswer;

import aCms.admin.account.domain.Account;
import aCms.admin.account.service.AccountSecService;
import aCms.admin.boardContents.BoardContents;
import aCms.admin.boardContents.BoardContentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentAnswerService {

    private ContentAnswerDao contentAnswerDao;
    private BoardContentsDao contentsDao;
    private AccountSecService accountSecService;

    @Autowired
    public ContentAnswerService(ContentAnswerDao contentAnswerDao, BoardContentsDao contentsDao, AccountSecService accountSecService) {
        this.contentAnswerDao = contentAnswerDao;
        this.contentsDao = contentsDao;
        this.accountSecService = accountSecService;
    }


    public ContentAnswerDto.create create(ContentAnswerDto.create answerDto, long id) {
        ContentAnswer contentAnswer = null;
        try {
            BoardContents boardContent = contentsDao.findOne(id);
            Account account = accountSecService.findAccountByContextHolder();
            contentAnswer = new ContentAnswer(answerDto, boardContent, account);
            contentAnswerDao.save(contentAnswer);
            answerDto.setAccountName(account.getAccountName());
        }catch (Exception e){
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
        return answerDto;
    }

    public ContentAnswer findAnswer(long id) {
        ContentAnswer contentAnswer = contentAnswerDao.findOne(id);
        System.out.println(contentAnswer.getComment());
        return contentAnswer;
    }

    public void update(ContentAnswerDto.create answerDto, long id) {
        ContentAnswer contentAnswer = findAnswer(id);
        contentAnswer.update(answerDto);
        contentAnswerDao.save(contentAnswer);
    }
}
