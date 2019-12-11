<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form  role="form" action="/Login" method="post">
                        <fieldset>
                            <c:if  test = "$ {param.error! = null}" >
                                <p>
                                    사용자 이름과 비밀번호가 잘못되었습니다.
                                </p>
                            </c : if>
                            <c : if  test = "$ {param.logout! = null}" >
                                <p>
                                    로그 아웃되었습니다.
                                </p>
                            </c:if>

                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" id="username" name="username" <%--type="email"--%> value="admin">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" id="password" name="password" type="password" value="test">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                                <input name="submit" class="btn btn-lg btn-success btn-block" type="submit" value="Login"/>
                                <input name="_csrf" type="hidden" value="f98464af-a6b6-4d23-ac69-6a6cc0f7d0a8" />
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>