$(function () {
    setTimeout(function() {
        $.get("message-list.json", function (data) {
            // 怎么遍历 js 的数组
            let tbody = $("tbody");
            for (i in data) {
                let message = data[i];
                // message.id
                // message["id"]   这两个等价
                // message["hello-world"]  message.hello-world
                let html = "<tr>" +
                    "<td>" + message.id + "</td>" +
                    "<td>" + message.when + "</td>" +
                    "<td>" + message.who + "</td>" +
                    "<td>" + message.what + "</td>" +
                    "</tr>";
                tbody.append(html);
            }
        });
    }, 3000);
});
// $(function () {
//
//     setTimeout(function () {
//         $.get("../message-list.json",function (data) {
//
//             //怎么遍历js的数组
//             let tbody = $("tbody");
//
//             for (i in data) {
//                 let message = data[i];
//
//                 //message.id等价于message["id"]
//                 //如message["hello-world"]只能用形式二表示，不能用点
//                 let html = "<tr>" +
//                     "<td>"+message.id+"</td>" +
//                     "<td>"+message.who+"</td>" +
//                     "<td>"+message.what+"</td>" +
//                     "<td>"+message.when+"</td>" +
//                     "</tr>"
//
//                 tbody.append(html);
//             }
//
//         });
//     },3000);
//
// });