

$(function main() {
    $("button").on("click", function () {
        let e = $("h1");

        e.html("玉鼎张");

        setTimeout(function () {
            console.log("变身");
            e.html("张丁玉");
        }, 3000);
    });
});