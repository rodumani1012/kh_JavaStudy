$(function () {

    $("body").prop("class", "sidebar-visible commubar-visible")

    // Sidebar .prj_bar
    $('.toggle').click( function () {
        var emp = "";
        $("body").prop("class", function (i, val) {
            if (val === "") {
                emp = "sidebar-visible"
            } else if (val.includes("commubar-visible")) {
                if (val.includes("sidebar-visible")) {
                    emp = "commubar-visible"
                } else {
                    emp = "sidebar-visible commubar-visible"
                }
            }
            $("body").prop("class", emp);
        })
    })
    
    // Commubar .prj_bar
    $('.toggle2').click( function () {
        var emp = "";
        $("body").prop("class", function (i, val) {
            if (val === "") {
                emp = "commubar-visible"
            } else if (val.includes("sidebar-visible")) {
                if (val.includes("commubar-visible")) {
                    emp = "sidebar-visible"
                } else {
                    emp = "sidebar-visible commubar-visible"
                }
            }
            $("body").prop("class", emp);
        })
    })

   
})

// 대쉬보드
// board_new
function board_new(num) {
    var title = $('#board_title').val()
    var prj_num = "prj_num=" + num
    $.ajax({

        url: "project.do?command=board_new&title=" + title + "&"
            + prj_num,
        success: function () {
            $('#backboard')
                .append(
                    "<article class='box post post-excerpt backboard'><section class='box text-style1'><div class='inner connected'><p><strong>"
                    + title
                    + "</strong></p><div class='inner issue'><p> Issue name</p ></div ></div ></section ></article > ")
            sort()
        },
        error: function () {
            alert("실패")
        }
    })
}

function sort() {

    $(".inner").sortable({
        connectWith: ".connected",
        items: '>div',
        tolerance: 'pointer',
        revert: 'invalid',
        forceHelperSize: true,
        update: function (event, ui) {
            // alert(ui.item.index())
        }
    })

    var before_board
    var after_board
    var before_num
    $("#backboard").sortable({
        tolerance: 'pointer',
        revert: 'invalid',
        forceHelperSize: true,
        start: function (event, ui) {
            before_board = ui.item.index()
        },
        update: function (event, ui) {
            after_board = ui.item.index()
            before_num = ui.item.find('p').eq(0).prop('id')
            $.ajax({
                url: "project.do?command=board_move&after_board=" + after_board + "&before_num=" + before_num + "&before_board=" + before_board,
                success: function () {
                },
                error: function () {
                    alert("보드 이동 중에 오류가 발생했습니다.")
                }
            })
        }
    })

}
