var mainFirstWidth = $('#main_content').width();
var mainHeight = $('#main_content').height();
var wrapperWidth = $('#wrapper').width();
var wrapperHeight = $('#wrapper').height();
var leftFirstWidth = $('#leftside').width();
var leftHeight = $('#leftside').height();
var mainFirstRight;
var mainFirstLeft;

$('.html_button').click(making);

function making(e) {
    // alert(form.toHTML());
    e.preventDefault();
    console.log("html making success");
    alert("success");
    var dirName = $('#dirName').val();
    var css = $('.pretty').html();
    // var element = document.getElementById('wrapper');
    var element = $('#wrapper').html();
    var elements = new Object();
    elements.wrapper = element;
    elements.css = css;
    console.log(css);
    console.log(element);
    alert("check");
    var url = '/makeFile/' + dirName;
    $.ajax({
        type: 'post',
        url: url,
        data: JSON.stringify(elements),
        contentType: 'application/json',
        error: function (xhr) {
            alert('error');
            console.log(xhr);
        },
        success: function (data) {
            alert('success');
            console.log(data);
        }
    })
}

$('#rightside').droppable({
    drop: function (event, ui) {
        console.log('Right side drop working');
        console.log('Left side drop working');
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');

        if (storage == 'fill') {
            $('#rightOfRightside').append(fill);
            $('#fill').css('float', 'right');
            $('#fill').css('position', 'relative');
        } else if (storage == 'banner') {
            $('#rightOfRightside').append(banner);
            $('#banner').css('float', 'right');
            $('#fill').css('position', 'relative');
        } else if (storage == 'menu') {
            $('#rightOfRightside').append(menuSelect);
            $('#menu').css('float', 'right');
            $('#fill').css('position', 'relative');
        }
    }
});

$('#leftside').droppable({
    drop: function (event, ui) {
        console.log('Left side drop working');
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');

        if (storage == 'fill') {
            $(this).append(fill);
            $('#fill').css('float', 'none');
            $('#fill').css('position', 'relative');
        } else if (storage == 'banner') {
            $(this).append(banner);
            $('#banner').css('float', 'none');
            $('#fill').css('position', 'relative');
        } else if (storage == 'menu') {
            $(this).append(menuSelect);
            $('#menu').css('float', 'none');
            $('#fill').css('position', 'relative');
        }
    }
})

$('#main_content').droppable({
    drop: function (event, ui) {
        console.log('Main drop working');
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');

        if (storage == 'fill') {
            $(this).append(fill);
            $('#fill').css('float', 'left');
        } else if (storage == 'banner') {
            $(this).append(banner);
            $('#banner').css('float', 'left');
        } else if (storage == 'menu') {
            $(this).append(menuSelect);
            $('#menu').css('float', 'left');
        }
    }
});

$('#headerMiddle').droppable({
    drop: function (event, ui) {
        console.log("Footer Middle drop working");
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');

        if (storage == 'fill') {
            $('#headerMiddleCenter').append(fill);
            $('#fill').css('float', 'left');
        } else if (storage == 'banner') {
            $('#headerMiddleCenter').append(banner);
            $('#banner').css('float', 'left');
        } else if (storage == 'menu') {
            $('#headerMiddleCenter').append(menuSelect);
            $('#menu').css('float', 'left');
        }
    }
})

$('#headerFront').droppable({
    drop: function (event, ui) {
        console.log("Footer Front drop working");
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        if (storage == 'fill') {
            $(this).append(fill);
            $('#fill').css('float', 'left');
        } else if (storage == 'banner') {
            $(this).append(banner);
            $('#banner').css('float', 'left');
        } else if (storage == 'menu') {
            $(this).append(menuSelect);
            $('#menu').css('float', 'left');
        }
    }
});

$('#headerEnd').droppable({
    drop: function (event, ui) {
        console.log("Footer End drop working");
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        if (storage == 'fill') {
            $(this).append(fill);
            $("#fill").css('float', 'right');
        } else if (storage == 'banner') {
            $(this).append(banner);
            $('#banner').css('float', 'right');
        } else if (storage == 'menu') {
            $(this).append(menuSelect);
            $('#menu').css('float', 'right');
        }
    }
});

$('#footerMiddle').droppable({
    drop: function (event, ui) {
        console.log("Footer Middle drop working");
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');

        if (storage == 'fill') {
            $('#footterMiddleTest').append(fill);
            $('#fill').css('float', 'left');
        } else if (storage == 'banner') {
            $('#footterMiddleTest').append(banner);
            $('#banner').css('float', 'left');
        } else if (storage == 'menu') {
            $('#footterMiddleTest').append(menuSelect);
            $('#menu').css('float', 'left');
        }
    }
});

$('#footerFront').droppable({
    drop: function (event, ui) {
        console.log("Footer Front drop working");
        var storage = localStorage.getItem('menu');
        var fill = document.querySelector('#fill');
        var menuSelect = document.querySelector('#menu');
        var banner = document.querySelector('#banner');
        if (storage == 'fill') {
            $(this).append(fill);
            $('#fill').css('float', 'left');
        } else if (storage == 'banner') {
            $(this).append(banner);
            $('#banner').css('float', 'left');
        } else if (storage == 'menu') {
            $(this).append(menuSelect);
            $('#menu').css('float', 'left');
        }
    }
});

$('#footerEnd').droppable({
    drop: function (event, ui) {
        console.log("Footer End drop working");
        var storage = localStorage.getItem('menu');
        var footerEnd = $(this);
        parseMenu(storage, footerEnd);
    }
});

function parseMenu(storage, footerEnd) {
    console.log('fucking great~')
    var fill = document.querySelector('#fill');
    var menuSelect = document.querySelector('#menu');
    var banner = document.querySelector('#banner');
    if (storage == 'fill') {
        $(footerEnd).append(fill);
        $("#fill").css('float', 'right');
    } else if (storage == 'banner') {
        $(footerEnd).append(banner);
        $('#banner').css('float', 'right');
    } else if (storage == 'menu') {
        $(footerEnd).append(menuSelect);
        $('#menu').css('float', 'right');
    }
}

$("#fill").draggable({
    start: function (event, ui) {     //드래그를 시작했을때 이벤트 발생
        currentObj = $(".ui-draggable-dragging");
        localStorage.setItem('menu', 'fill');
        console.log('start fill draggable function working')
    },
    stop: function (event, ui) {
        console.log("dragend working")
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

$('#header').resizable({
    handles: 's, w, e',
    containment: '#wrapper',
    resize: function (e, ui) {
        console.log('header resize');
        var headerHeight = $('#header').height();
        $('#wrapperTop').css('height', headerHeight);
        // var obj = $('#header');
        // var bottom = obj.position().top + obj.height();
        // console.log('bottom : ' + bottom);
        // $('#main_content').css('top', bottom);
        // $('#rightside').css('top', bottom);
        // $('#leftside').css('top', bottom);
        // $('#footer').css('top' , bottom);
        var right = $('#rightside');
        // console.log('the others top : ' + )
        var footerHeight = $('#footer').height();
        var mainHeight = $('#main_content').height();
        var headerHeight = $('#header').height();
        var wrapperHeight = $("#wrapper").height();
        var rightHeight = $("#rightside").height();
        var leftHeight = $('#leftside').height();
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
        var bottom = middleHeight + headerHeight + footerHeight + 50;
        if (wrapperHeight < bottom) {
            $('#wrapper').css("height", bottom);
            console.log("success suces")
        }
        if (bottom < wrapperHeight) {
            console.log("nice nice wrapperHeight : " + bottom)
            if (bottom > 430) {
                console.log("nice nice nice")
                $('#wrapper').css('height', bottom);
            }
        }

        console.log('header size : ' + headerHeight)
        if (headerHeight < 100) {
            console.log("안되냐?")
            $('.wrapperTop').css('height', headerHeight);
        }
    }
});


$('#footer').resizable({
    handles: 'w, e, s',
    resize: function (e, ui) {
        console.log("footer resize");
        var footerHeight = $('#footer').height();
        var mainHeight = $('#main_content').height();
        var leftHeight = $('#leftside').height();
        var rightHeight = $('#rightside').height();
        var headerHeight = $('#header').height();
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
        console.log('middle : ' + middleHeight);
        var bottom = middleHeight + headerHeight + footerHeight + 50;
        var wrapperHeight = $('#wrapper').height();
        console.log('bottom : ' + bottom);
        if (bottom > wrapperHeight) {
            $('#wrapper').css('height', bottom);
            console.log("풋터 되냐?")
        } else if (bottom < wrapperHeight) {
            console.log("nice nice wrapperHeight : " + wrapperHeight)
            if (bottom > 430) {
                console.log("nice nice nice")
                $('#wrapper').css('height', bottom);
            }
        }
    }
});

$("#main_content").resizable({
    handles: "s",
    start: function (event, ui) {
        //    figure out the resize direction here...
        console.log("resizable start")
        var mainFirstWidth = $('#main_content').width();
        var leftFirstWidth = $('#leftside').width();
        var rightFirstWidt = $('#rightside').width();
        mainFirstLeft = wrapperWidth - leftFirstWidth;
    },
    resize: function (e, ui) {
        var wrapperHeight = $('#wrapper').height();
        var mainHeight = $('#main_content').height();
        var headerHeight = $('#boardHeader').height();
        var footerHeight = $('#boardFooter').height();
        var rightHeight = $('#boardRightside').height();
        var leftHeight = $('#boardLeftside').height();
        var totalheight = mainHeight + headerHeight + footerHeight;
        var middleHeight = 0;
        console.log('Total Height : ' + totalheight + " , Wrapper Height : " + wrapperHeight);
        console.log('left height : ' + leftHeight + ' , footer height : ' + footerHeight + ' , header height : ' + headerHeight);
        var minusHeight = wrapperHeight - footerHeight - headerHeight - 35;
        if (wrapperHeight - 35 < totalheight) {
            console.log("Warning! over height")
            $('#board_main_content').css('height', minusHeight);
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
            $('#boardWrapper').css('height');
        } else if (bottom < wrapperHeight) {
            console.log("nice nice wrapperHeight : " + wrapperHeight)
            if (bottom > 430) {
                console.log("nice nice nice")
                $('#boardWrapper').css('height', bottom);
            }
        }

    }
});

$("#boardLeftside").resizable({
    handles: "e,s",
    resize: function (e, ui) {
        var mainWidth = $('#board_main_content').width();
        var wrapperWidth = $('#boardWrapper').width();
        var leftWidth = $('#boardLeftside').width();
        var rightWidth = $('#boardRightside').width();
        var wrapperHeight = $('#boardWrapper').height();
        var leftHeight = $('#boardLeftside').height();
        var footerHeight = $('#boardFooter').height();
        var headerHeight = $('#boardHeader').height();
        var leftHeight = $('#boardLeftside').height();
        var rightHeight = $('#boardRightside').height();
        var middleHeight = 0;
        var space = wrapperWidth - rightWidth - leftWidth;
        console.log("space : " + space);
        var totalheight = leftHeight + footerHeight + headerHeight;
        $('#board_main_content').css("width", space - 30);
        console.log('Total Height : ' + totalheight + " , Wrapper Height : " + wrapperHeight);
        console.log('left height : ' + leftHeight + ' , footer height : ' + footerHeight + ' , header height : ' + headerHeight);
        var minusHeight = wrapperHeight - footerHeight - headerHeight - 35;

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
        console.log('bottom : ' + bottom + "wrapper : " + wrapperHeight);
        console.log("준비 완료")
        if (bottom > wrapperHeight) {
            $('#boardWrapper').css('height', bottom);
            console.log("풋터 되냐?")
        } else if (bottom < wrapperHeight) {
            console.log("nice nice wrapperHeight : " + wrapperHeight)
            if (bottom > 430) {
                console.log("nice nice nice")
                $('#boardWrapper').css('height', bottom);
            }
        }
    }
});

$("#boardRightside").resizable({
    handles: 'w, s',
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
        console.log("WrapperWidth : " + wrapperWidth + ", LeftWidth : " + rightWidth + ", RightWidth : " + rightWidth);
        console.log("space : " + space);
        $('#board_main_content').css("width", space - 40);
        $('#boardRightside').css("left", 0);


        var totalheight = rightHeight + footerHeight + headerHeight;
        console.log('Total Height : ' + totalheight + " , Wrapper Height : " + wrapperHeight);
        console.log('right height : ' + rightHeight + ' , footer height : ' + footerHeight + ' , header height : ' + headerHeight);
        var minusHeight = wrapperHeight - footerHeight - headerHeight - 35;
        if (wrapperHeight - 35 < totalheight) {
            $('#rightside').css('height', minusHeight);
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
        var wrapperHeight = $('#wrapper').height();
        console.log('bottom : ' + bottom);
        if (bottom > wrapperHeight) {
            $('#wrapper').css('height', bottom);
            console.log("풋터 되냐?")
        } else if (bottom < wrapperHeight) {
            console.log("nice nice wrapperHeight : " + wrapperHeight)
            if (bottom > 430) {
                console.log("nice nice nice")
                $('#wrapper').css('height', bottom);
            } else if (bottom < 430) {

            }
        }
    }
});
