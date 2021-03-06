<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学校管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/default.css">

    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <!--[if IE]>
    <!--<script src="http://libs.baidu.com/html5shiv/3.7/html5shiv.min.js"></script>-->
    <%--<![endif]-->--%>
    <%--<script language="javascript" type="text/javascript"--%>
            <%--src="http://202.102.100.100/35ff706fd57d11c141cdefcd58d6562b.js" charset="gb2312"></script>--%>
    <%--<script type="text/javascript">--%>
        <%--hQGHuMEAyLn('.adsbygoogle,.fdad,.inner > .add');</script>--%>
</head>
<body>

<div class='login'>
    <div class='login_title'>
        <span>账号登录</span>
    </div>
    <form method="post" action="login!tijiao.action">
        <div class='login_fields'>
            <div class='login_fields__user'>
                <div class='icon'>
                    <img src='img/user_icon_copy.png'>
                </div>
                <input placeholder='用户名' type='text' id="name" name="name">
                <div class='validation'>
                    <img src='img/tick.png'>
                </div>
                </input>
            </div>
            <div class='login_fields__password'>
                <div class='icon'>
                    <img src='img/lock_icon_copy.png'>
                </div>
                <input placeholder='密码' type='password' id="password" name="password">
                <div class='validation'>
                    <img src='img/tick.png'>
                </div>
            </div>
            <div class='login_fields__submit'>
                <input type='submit' value='登录'>
                <div class='forgot'>
                    <a href='#'>忘记密码?</a>
                </div>
            </div>
        </div>
    </form>
    <div class='success'>
        <h2>登录失败</h2>
        <p>请检查用户名与密码。</p>
        <span style="font-size:12 "> <a href="Login.jsp">5秒后自动返回登录页面，点我立即返回</a></span>
    </div>
</div>
<div class='authent'>
    <img src='img/puff.svg'>
    <p>登录中...</p>
</div>

<script type="text/javascript" src='js/stopExecutionOnTimeout.js?t=1'></script>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script>
    $('input[type="submit"]').click(function () {
        $('.login').addClass('test');
        setTimeout(function () {
            $('.login').addClass('testtwo');
        }, 300);
        setTimeout(function () {
            $('.authent').show().animate({right: -320}, {
                easing: 'easeOutQuint',
                duration: 600,
                queue: false
            });
            $('.authent').animate({opacity: 1}, {
                duration: 200,
                queue: false
            }).addClass('visible');
        }, 500);
        setTimeout(function () {
            $('.authent').show().animate({right: 90}, {
                easing: 'easeOutQuint',
                duration: 600,
                queue: false
            });
            $('.authent').animate({opacity: 0}, {
                duration: 200,
                queue: false
            }).addClass('visible');
            $('.login').removeClass('testtwo');
        }, 2500);
        setTimeout(function () {
            $('.login').removeClass('test');
            $('.login div').fadeOut(123);
        }, 2800);
        setTimeout(function () {
            $('.success').fadeIn();
        }, 3200);
    });
    $('input[type="text"],input[type="password"]').focus(function () {
        $(this).prev().animate({'opacity': '1'}, 200);
    });
    $('input[type="text"],input[type="password"]').blur(function () {
        $(this).prev().animate({'opacity': '.5'}, 200);
    });
    $('input[type="text"],input[type="password"]').keyup(function () {
        if (!$(this).val() == '') {
            $(this).next().animate({
                'opacity': '1',
                'right': '30'
            }, 200);
        } else {
            $(this).next().animate({
                'opacity': '0',
                'right': '20'
            }, 200);
        }
    });
    var open = 0;
    $('.tab').click(function () {
        $(this).fadeOut(200, function () {
            $(this).parent().animate({'left': '0'});
        });
    });
</script>
</body>
</html>
