


$(function main() {
    //#是找id，找到id是content的元素
    //当这个元素发生了mouseover（鼠标越过）事件时
    //执行我们传入的方法
    //把id是content的元素内部html内容替换成（孙悟空）
    //当这个元素发生了mouseover（鼠标越过）事件时,执行我们传入的方法
    //把id是content的元素内部html内容替换回（猪八戒）
    $("#content").on("mouseover",function () {
        $("#content").html("孙悟空");
    });
    $("#content").on("mouseout",function () {
        $("#content").html("猪八戒");
    });
});