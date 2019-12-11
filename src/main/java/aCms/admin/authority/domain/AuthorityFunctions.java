package aCms.admin.authority.domain;

public enum AuthorityFunctions {

    C("생성"),
    U("업데이트"),
    R("조회"),
    D("삭제");

    private String name;

    AuthorityFunctions(String name) {
        this.name = name;
    }
}
