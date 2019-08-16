$(function () {
	// issue 생성
	$(document).on('click','.issue_new',function () {

				var new_div = $('.in').parent().parent()
				new_div.next().toggle()
				new_div.remove()
				var button_new = $(this)
				var emp = "<div class='inner temp' id='1'>"
					+ "<p><textarea class='in' cols='10' rows='5'></textarea></p>"
					+ "<input type='button' class='tiny new_go' value='만들기'></input>"
					+ "<input type='button' class='tiny new_stop' value='취소'></input>"
					+ "</div >"

				$(this).before(emp)
				$(this).toggle()
				$(".in").focus()

				$('.new_stop').on('click', function () {
					button_new.toggle()
					$(this).parent().remove()
				})

				$('.new_go')
					.on(
						'click',
						function () {
							if($('.in').val().trim() == '' || $('.in').val().trim() == null){
								alert('제목을 입력해주세요')
							}else{
							var button_go = $(this)
							var prj_num = project_num
							var board_num = $(this).parent()
								.parent().parent()
								.find('p').eq(0).prop('id')
							var issue_title = $('.in').val()
							$
								.ajax({
									url: "project.do?command=issue_new&prj_num="
										+ prj_num
										+ "&board_num="
										+ board_num
										+ "&issue_title="
										+ issue_title,
									method: "post",
									success: function () {
										button_new.toggle()
										$('.in')
											.parent()
											.text(
												issue_title)
										$('.inner.temp').prop('class', 'inner issue')
										$('.in').remove()
										$('.new_go')
											.remove()
										$('.new_stop')
											.remove()
									},
									error: function () {
										alert('error')
									}
								})
							}
						})
			})

	// issue_detail
	$(document).on('click', '.inner.issue', function () {
		//		$('.inner.issue').unbind('click')
		var issue_num = $(this).prop('id')

		$.ajax({
			url: "project.do?command=issue_detail&issue_num=" + issue_num,
			method: "post",
			dataType: "json",
			success: function (data) {
				$('.layer').css('display', 'block')
				$('#pop').css('display', 'block')
				$('#priority').val(data["ISSUE_PRIORITY"])
				$('#title').val(data["ISSUE_TITLE"])
				$('#text').val(data["ISSUE_CONTENT"])
				$('#require').val(data["ISSUE_REQUIRE"])
				$('#charger').val(data["ISSUE_CHARGER"])
				$('#deadline').val(data["ISSUE_DEADLINE"])
				$('table').prop('id', data["ISSUE_NUM"])
			},
			error: function () {
				alert('issue_detail_error')
			}
		})
	})

	$('#detail_back').on('click', function () {
		$('.layer').css('display', 'none')
		$('#pop').css('display', 'none')
		$('.is_update').remove()
	})

	$('.2click').dblclick(function () {
		$('.2click').prop('readonly', true)
		$('.is_update').remove()
		$(this).prop('readonly', false)
		$(this).parent().append("<button class='tiny is_update'>수정</button>")
		$(this).parent().append("<button class='tiny is_update'>취소</button>")

		$('.is_update').on('click', function () {
			var text = $(this).text()
			var issue_num = $('table').prop('id')
			var input_tag = $(this).prev()
			var column = $(this).prev().prop('id')
			var content = $(this).prev().val()

			var map = {
				issue_num: issue_num,
				column: column,
				content: content
			}
			var sendData = JSON.stringify(map)
			if (text === '수정') {
				$.ajax({
					url: "project.do?command=issue_update",
					data: {
						issue_update: sendData
					},
					method: "post",
					success: function () {
						input_tag.prop('readonly', true)
						$('.is_update').remove()
					},
					error: function () {
						alert('error')
					}
				})
			} else if (text === '취소') {
				$('.2click').prop('readonly', true)
				$('.is_update').remove()
			}
		})
	})

	$('#issue_del').on('click', function () {
		var bool = confirm("삭제하시겠습니까?")
		var issue_num = $('table').prop('id')
		if (bool) {
			$.ajax({
				url: "project.do?command=issue_del&issue_num=" + issue_num,
				method: "post",
				success: function () {
					$('#' + issue_num).remove()
					$('.layer').css('display', 'none')
					$('#pop').css('display', 'none')
				},
				error: function () {
					alert('error')
				}
			})
		}
	})
	
	 // backboardSortable
    sort()

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
                    + "</strong></p><input type='button' class='tiny issue_new' value='+'></div ></section ></article > ")
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

