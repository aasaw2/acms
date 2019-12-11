
var banner = document.querySelector('#banner');
var menu = document.querySelector('#menu');
var fill = document.querySelector('#fill');
var a_link = document.querySelector('#a_link');
var button = document.querySelector('#button');

$('#a_link_modify').click(function () {
    var value = $('#a_link_modify').val();
    console.log('a_link value : ' + value);
    var modify = $('#a_link_modify').val("soop");
    console.log(modify);
   alert("수정")
});

$('#button').dblclick(function () {
    putElementToEmpty(button);
    $('#button').css('left', 5);
    $('#button').css('top', 5);
    $('#button').css('position', 'relative');
    $('#button').css('float', 'left');
});

$('#a_link').dblclick(function () {
    putElementToEmpty(a_link);
    $('#a_link').css('left', 5);
    $('#a_link').css('top', 5);
    $('#a_link').css('position', 'relative');
    $('#a_link').css('float', 'left');
});

$('#fill').dblclick(function () {
    putElementToEmpty(fill);
    $('#fill').css('left', 5);
    $('#fill').css('top', 5);
    $('#fill').css('position', 'relative');
    $('#fill').css('float', 'left');
});

$('#banner').dblclick(function () {
    var banner = document.querySelector('#banner');
    putElementToEmpty(banner);
    $('#banner').css('left', 5);
    $('#banner').css('top', 5);
    $('#banner').css('position', 'relative');
    $('#banner').css('float', 'left');
});

$('#menu').dblclick(function () {
    alert('double click');
    var menu = document.querySelector('#menu');
    putElementToEmpty(menu);
    $('#menu').css('left', 5);
    $('#menu').css('top', 5);
    $('#menu').css('position', 'relative');
    $('#menu').css('float', 'left');
});

function putElementToEmpty(element) {
    alert('function working');
    $('.empty').append(element)
}

$('#button').draggable({
    start: function (event, ui) {
        localStorage.setItem('menu', 'button');
        console.log('start button draggable function working')
    },
    stop: function () {
        console.log('a_link drag stop');
        $('#button').css('left', 0);
        $('#button').css('top', 0);
    }
});

$('#a_link').draggable({
    start: function (event, ui) {
        localStorage.setItem('menu', 'a_link');
        console.log('start a_link draggable function working')
    },
    stop: function () {
        console.log('a_link drag stop');
        $('#a_link').css('left', 0);
        $('#a_link').css('top', 0);
    }
});

$("#fill").draggable({
    start: function (event, ui) {     //드래그를 시작했을때 이벤트 발생
        currentObj = $(".ui-draggable-dragging");
        localStorage.setItem('menu', 'fill');
        console.log('start fill draggable function working')
    },
    stop: function (event, ui) {
        console.log("dragend working");
        $('#fill').css('left', 0);
        $('#fill').css('top', 0);
    }
});

$("#banner").draggable({
    start: function (event, ui) {     //드래그를 시작했을때 이벤트 발생
        currentObj = $(".ui-draggable-dragging");
        localStorage.setItem('menu', 'banner');
        console.log('start fill draggable function working')
    },
    stop: function (event, ui) {
        console.log("dragend working")
        $('#banner').css('left', 0);
        $('#banner').css('top', 0);

    }
});

$('#menu').draggable({
    start: function (event, ui) {     //드래그를 시작했을때 이벤트 발생
        currentObj = $(".ui-draggable-dragging");
        localStorage.setItem('menu', 'menu');
        console.log('start fill draggable function working')
    },
    stop: function (event, ui) {
        console.log("dragend working")
        $('#menu').css('left', 0);
        $('#menu').css('top', 0);
    }
});
// Controller, Service, Dao, Domain, html 생성 버튼

$('.html_button').click(making);

function making(e) {
    // alert(form.toHTML());
    e.preventDefault();
    console.log("html making success");
    alert("success");
    var dirName = $('#dirName').val();
    // var element = document.getElementById('wrapper');
    var element = $('#mainWrapper').html();
    var elements = new Object();
    elements.html = element;
    console.log(element);
    var url = '/makeFile/' + dirName;
    $.ajax({
        type: 'post',
        url: url,
        data: JSON.stringify(elements),
        contentType: 'application/json',
        success: function (data) {
            alert('success');
            console.log(data);
        }
    })
}

// 게시판 객체들에 Droppable


$('#boardRightside').droppable({
    drop: function (event, ui) {
        console.log('Right side drop working');
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        var a_link = document.querySelector('#a_link');
        if (storage == 'fill') {
            $('#boardRightOfRightside').append(fill);
            $('#fill').css('float', 'right');
            $('#fill').css('position', 'relative');
            console.log('fuck you mother fucker')
        } else if (storage == 'banner') {
            $('#boardRightOfRightside').append(banner);
            $('#banner').css('float', 'right');
            $('#banner').css('position', 'relative');
            console.log('fuck you mother fuckerX')
        } else if (storage == 'menu') {
            $('#boardRightOfRightside').append(menuSelect);
            $('#menu').css('float', 'right');
            $('#menu').css('position', 'relative');
            console.log('fuck you mother fucker')
        } else if (storage == 'a_link') {
            $('#boardRightOfRightside').append(a_link);
            $('#a_link').css('float', 'right');
            $('#a_link').css('position', 'relative');
        } else if (storage == 'button') {
            $('#boardRightOfRightside').append(button);
            $('#button').css('float', 'right');
            $('#button').css('position', 'relative');
        }
    }
});

$('#boardLeftside').droppable({
    drop: function (event, ui) {
        console.log('Left side drop working');
        var storage = localStorage.getItem('menu');
        var menuSelect = document.querySelector('#menu');

        if (storage == 'fill') {
            $(this).append(fill);
            $('#fill').css('float', 'none');
            $('#fill').css('position', 'relative');
        } else if (storage == 'banner') {
            $(this).append(banner);
            $('#banner').css('float', 'none');
            $('#banner').css('position', 'relative');
        } else if (storage == 'menu') {
            $(this).append(menuSelect);
            $('#menu').css('float', 'none');
            $('#menu').css('position', 'relative');
        } else if (storage == 'a_link') {
            $(this).append(a_link);
            $('#a_link').css('float', 'none');
            $('#a_link').css('position', 'relative');
        } else if (storage == 'button') {
            $(this).append(button);
            $('#button').css('float', 'none');
            $('#button').css('position', 'relative');
        }
    }
});

$('.empty').droppable({
    drop: function (event, ui) {
        console.log("Footer End drop working");
        var storage = localStorage.getItem('menu');
        var waiting = $(this);
        parseMenuLeft(storage, waiting)
    }
});

$('#board_main_content').droppable({
    drop: function (event, ui) {
        console.log('Main drop working');
        var storage = localStorage.getItem('menu');
        var headerMiddle = $('#board_main_content');
        parseMenuLeft(storage, headerMiddle);
    }
});

$('#boardHeaderMiddle').droppable({
    drop: function (event, ui) {
        console.log("Footer Middle drop working");
        var storage = localStorage.getItem('menu');
        var headerMiddle = $('#boardHeaderMiddleHeightCenter');
        parseMenuLeft(storage, headerMiddle);
    }
});

$('#boardHeaderFront').droppable({
    drop: function (event, ui) {
        console.log("Footer Front drop working");
        var storage = localStorage.getItem('menu');
        var headerFront = $("#boardHeaderFrontHeightCenter");
        parseMenuLeftCenter(storage, headerFront);
    }
});

//요기
function parseMenuLeftCenter(storage, element) {
    var menuSelect = document.querySelector('#menu');
    if (storage == 'fill') {
        $(element).append(fill);
        $("#fill").css('float', 'none');
    } else if (storage == 'banner') {
        $(element).append(banner);
        $('#banner').css('float', 'none');
    } else if (storage == 'menu') {
        $(element).append(menuSelect);
        $('#menu').css('float', 'none');
    } else if (storage == 'a_link') {
        $(element).append(a_link);
        $('#a_link').css('float', 'none');
    } else if (storage == 'button') {
        $(element).append(button);
        $('#button').css('float', 'none');
    }

}

$('#boardHeaderEnd').droppable({
    drop: function (event, ui) {
        console.log("Footer End drop working");
        var storage = localStorage.getItem('menu');
        var headerEnd = $('#boardHeaderEndHeightCenter');
        parseMenuRight(storage, headerEnd)
    }
});

$('#boardFooterMiddle').droppable({
    drop: function (event, ui) {
        console.log("Footer Middle drop working");
        var storage = localStorage.getItem('menu');
        var footerMiddle = $('#boardFooterMiddleHeightCenter');
        parseMenuLeft(storage, footerMiddle);
    }
});

$('#boardFooterFront').droppable({
    drop: function (event, ui) {
        console.log("Footer Front drop working");
        var storage = localStorage.getItem('menu');
        var footerFront = $('#boardFooterFrontHeightCenter');
        parseMenuLeft(storage, footerFront);
    }
});

$('#boardFooterEnd').droppable({
    drop: function (event, ui) {
        console.log("Footer End drop working");
        var storage = localStorage.getItem('menu');
        var footerEnd = $('#boardFooterEndHeightCenter');
        parseMenuRight(storage, footerEnd);
    }
});

function parseMenuLeft(storage, element) {
    var menuSelect = document.querySelector('#menu');
    if (storage == 'fill') {
        $(element).append(fill);
        $("#fill").css('float', 'left');
    } else if (storage == 'banner') {
        $(element).append(banner);
        $('#banner').css('float', 'left');
    } else if (storage == 'menu') {
        $(element).append(menuSelect);
        $('#menu').css('float', 'left');
    } else if (storage == 'a_link') {
        $(element).append(a_link);
        $('#a_link').css('float', 'left');
    } else if (storage == 'button') {
        $(element).append(button);
        $('#button').css('float', 'left');
    }
}

function parseMenuRight(storage, element) {
    var menuSelect = document.querySelector('#menu');
    if (storage == 'fill') {
        $(element).append(fill);
        $("#fill").css('float', 'right');
    } else if (storage == 'banner') {
        $(element).append(banner);
        $('#banner').css('float', 'right');
    } else if (storage == 'menu') {
        $(element).append(menuSelect);
        $('#menu').css('float', 'right');
    } else if (storage == 'a_link') {
        $(element).append(a_link);
        $('#a_link').css('float', 'right');
    } else if (storage == 'button') {
        $(element).append(button);
        $('#button').css('float', 'right');
    }
}


// 게시판 객체들 resizable(사이즈 조절)

function middleHeight() {
    var mainHeight = $('#board_main_content').height();
    var rightHeight = $("#boardRightside").height();
    var leftHeight = $('#boardLeftside').height();
    var middleHeight = 0;
    if (mainHeight > middleHeight) {
        middleHeight = mainHeight;
    }
    if (leftHeight > middleHeight) {
        middleHeight = leftHeight;
    }
    if (rightHeight > middleHeight) {
        middleHeight = rightHeight;
    }
    return middleHeight;
}

function totalHeight() {
    var headerHeight = $('#boardHeader').height();
    var footerHeight = $('#boardFooter').height();
    var middle = middleHeight();
    return headerHeight + footerHeight + middle + 50;
}

function resizeWrapperHeight() {
    var bottom = totalHeight();
    var wrapperHeight = $('#boardWrapper').height();
    if (wrapperHeight < bottom) {
        $('#boardWrapper').css('height', bottom);
        console.log('wrapper height success! bottom size : ' + bottom);
    } else if (bottom < wrapperHeight) {
        console.log("bottom size : " + bottom);
        if (bottom > 430) {
            console.log("nice nice nice");
            $('#boardWrapper').css('height', bottom);
        }
    }

}

function leftRightHeight() {

}

$('#boardHeader').resizable({
    handles: 's, w, e',
    containment: '#wrapper',
    resize: function (e, ui) {
        var headerHeight = $('#boardHeader').height();
        $('#boardWrapperTop').css('height', headerHeight);
        resizeWrapperHeight();
        var height = headerHeight / 2 - 10 - 25;
        console.log('header size : ' + headerHeight);
        $('#boardHeaderFrontHeightCenter').css('margin-top', height);
        $('#boardHeaderMiddleHeightCenter').css('margin-top', height);
        $('#boardHeaderEndHeightCenter').css('margin-top', height);
    },
    stop: function () {
        console.log('header stop is working');
        var headerWidth = $('#boardHeader').width();
        var wrapperWidth = $('#boardWrapper').width();
        var header = headerWidth / wrapperWidth * 100 - 0.3;
        $('#boardHeader').width(header + '%');
    }
});

$('#boardFooter').resizable({
    handles: 'w, e, s',
    resize: function (e, ui) {
        console.log("footer resize");
        var footerHeight = $('#boardFooter').height();
        resizeWrapperHeight();
        var wrapperBottom = $('#boardWrapperBottom');
        var bottom = totalHeight() + 50;
        console.log('bottom : ' + wrapperBottom + ' footerHeight : ' + footerHeight);
        wrapperBottom.css('height', footerHeight);
        var height = footerHeight / 2 - 25;
        console.log('footers height : ' + height)
        $('#boardFooterFrontHeightCenter').css('margin-top', height);
        $('#boardFooterMiddleHeightCenter').css('margin-top', height);
        $('#boardFooterEndHeightCenter').css('margin-top', height);
    },
    stop: function () {
        console.log('footer stop is working');
        var footerWidth = $('#boardFooter').width();
        var wrapperWidth = $('#boardWrapper').width();
        var footer = footerWidth / wrapperWidth * 100 - 0.3;
        $('#boardFooter').width(footer + '%');
    }
});

$("#board_main_content").resizable({
    handles: "s",
    resize: function (e, ui) {
        resizeWrapperHeight();
    }
});

$("#boardLeftside").resizable({
    handles: "e, s",
    maxWidth: 400,
    resize: function (e, ui) {
        var wrapperWidth = $('#boardWrapper').width();
        var leftWidth = $('#boardLeftside').width();
        var rightWidth = $('#boardRightside').width();
        var mainWidth = $('#board_main_content').width();
        var space = wrapperWidth - rightWidth - leftWidth;
        console.log("space : " + space);
        $('#board_main_content').css("width", space - 28);
        console.log("WrapperWidth : " + wrapperWidth + ", LeftWidth : " + leftWidth + ", RightWidth : " + rightWidth + 'mainWidth : ' + mainWidth);
        resizeWrapperHeight();
    },
    stop: function () {
        console.log("stop function is working");
        var mainWidth = $('#board_main_content').width();
        var leftWidth = $('#boardLeftside').width();
        var wrapperWidth = $('#boardWrapper').width();
        var mainPercentage = mainWidth / wrapperWidth * 100 - 0.2;
        var leftPercentage = leftWidth / wrapperWidth * 100 - 0.1;
        var rightWidth = $('#boardRightside').width();
        var right = rightWidth / wrapperWidth * 100;
        console.log('percentage main : ' + mainPercentage + ' right : ' + right + ' left : ' + leftPercentage);
        console.log("WrapperWidth : " + wrapperWidth + ", LeftWidth : " + leftWidth + ", RightWidth : " + rightWidth + 'mainWidth : ' + mainWidth);
        $('#board_main_content').width(mainPercentage + '%');
        $('#boardLeftside').width(leftPercentage + '%');
    }
});

$("#boardRightside").resizable({
    handles: 'w, s',
    maxWidth: 400,
    resize: function (e, ui) {
        var mainWidth = $('#board_main_content').width();
        var wrapperWidth = $('#boardWrapper').width();
        var leftWidth = $('#boardLeftside').width();
        var rightWidth = $('#boardRightside').width();
        var rightHeight = $('#boardRightside').height();
        var leftHeight = $('#boardLeftside').height();
        var mainHeight = $('#board_main_content').height();
        var headerHeight = $('#boardHeader').height();
        var footerHeight = $('#boardFooter').height();
        var middleHeight = 0;
        var space = wrapperWidth - rightWidth - leftWidth;
        console.log("WrapperWidth : " + wrapperWidth + ", LeftWidth : " + leftWidth + ", RightWidth : " + rightWidth + 'mainWidth : ' + mainWidth);
        console.log("space : " + space);
        $('#board_main_content').css("width", space - 28);
        $('#boardRightside').css("left", 0);


        var totalheight = rightHeight + footerHeight + headerHeight;
        console.log('Total Height : ' + totalheight + " , Wrapper Height : " + wrapperHeight);
        console.log('right height : ' + rightHeight + ' , footer height : ' + footerHeight + ' , header height : ' + headerHeight);
        var minusHeight = wrapperHeight - footerHeight - headerHeight - 45;
        if (wrapperHeight - 35 < totalheight) {
            $('#boardRightside').css('height', minusHeight);
            console.log('right height working~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')
        }

        if (mainHeight > middleHeight) {
            middleHeight = mainHeight;
        }
        if (leftHeight > middleHeight) {
            middleHeight = leftHeight;
        }
        if (rightHeight > middleHeight) {
            middleHeight = rightHeight;
        }
        console.log('middle : ' + middleHeight);
        var bottom = middleHeight + headerHeight + footerHeight + 50;
        var wrapperHeight = $('#boardWrapper').height();
        console.log('bottom : ' + bottom);
        if (bottom > wrapperHeight) {
            $('#boardWrapper').css('height', bottom);
            console.log("풋터 되냐?")
        } else if (bottom < wrapperHeight) {
            console.log("nice nice wrapperHeight : " + wrapperHeight);
            if (bottom > 430) {
                console.log("nice nice nice");
                $('#boardWrapper').css('height', bottom);
            } else if (bottom < 430) {

            }
        }
    },
    stop: function () {
        var mainWidth = $('#board_main_content').width();
        var rightWidth = $('#boardRightside').width();
        var wrapperWidth = $('#boardWrapper').width();
        var leftWidth = $('#boardLeftside').width();
        var mainPercentage = mainWidth / wrapperWidth * 100 - 0.2;
        var rightPercentage = rightWidth / wrapperWidth * 100 - 0.1;
        var left = leftWidth / wrapperWidth * 100;
        console.log('percentage main : ' + mainPercentage + ' right : ' + rightPercentage + ' left : ' + left);

        console.log('right stop is wor  king');
        $('#board_main_content').width(mainPercentage + '%');
        $('#boardRightside').width(rightPercentage + '%');
    }
});