$(function () {

    // 초기화
    $("body").prop("class", "")

    //프로젝트 입장

    $(".prj_in").on("click", function () {
        var prj_num = $(this).children(".prj_num").val()
        location.href = "project.do?command=project_board&prj_num=" + prj_num
    })

    //프로젝트 생성 버튼
    $("#prj_plus").on("click", function () {
        location.href = "http://localhost:8787/TOY_Semiproject/project/project_new.jsp"
    })

    // Sidebar .prj_bar
    $('.toggle').on("click", function () {
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
    
    // 댓글 textarea display
    $(".comment").on("click", function () {
        $(this).siblings().css("display", "block")
    })

})