$(function () {

    $("body").prop("class", "")

    // Sidebar
    $('.toggle').on("click", function () {
        if ($("body").prop("class") === "") {
            $("body").prop("class", "sidebar-visible")
        } else {
            $("body").prop("class", "")
        }

    })

})