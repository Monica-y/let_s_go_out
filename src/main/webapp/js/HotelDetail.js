function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null) {
        return decodeURI(r[2]);
    }
    return null;
}

$(document).ready(function () {
    var type = getUrlParam("type");
    var id = getUrlParam("id");

    var pinglun = document.getElementById("lgpinglun");

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);
    $.ajax({
        url: context_path + "/usr/inf",
        type: "get",
        async: true,
        data: {
            id: id,
            type: type
        },
        dataType: "json",

        success: function (data, textStatus) {

            if (data.state == 50000) {
                var n = data.comment.length;

                var div1 = new Array(n);
                var div2 = new Array(n);
                var hh5 = new Array(n);
                var pp1 = new Array(n);
                var div21 = new Array(n);
                var pp11 = new Array(n);
                //var img1 = new Array(n);

                for (var i = 0; i < n; i++) {
                    div1[i] = document.createElement("div");
                    div1[i].classList.add("tour-details__review-comment-single");
                    pinglun.appendChild(div1[i]);
                    console.log(i);
                    div2[i] = document.createElement("div");
                    //div2[i].classList.add("tour-details__review-comment-top");
                    div1[i].appendChild(div2[i]);


                    hh5[i] = document.createElement("h5");
                    //hh5[i].innerHTML="Christine Eve";
                    //hh5[i].appendChild(document.createTextNode("Christine Eve"));   //用户名
                    div2[i].appendChild(hh5[i]);

                    pp1[i] = document.createElement("p");
                    //pp1[i].innerHTML="06 Dec, 2019";
                    //pp1[i].appendChild(document.createTextNode("06 Dec, 2019"));    //评论时间
                    div2[i].appendChild(pp1[i]);

                    div21[i] = document.createElement("div");
                    div21[i].classList.add("tour-details__review-comment-content");
                    div1[i].appendChild(div21[i]);

                    pp11[i] = document.createElement("p");
                    //pp11[i].innerHTML="Lorem ipsum is simply free text used by copytyping refreshing.";
                    //pp11[i].appendChild(document.createTextNode("Lorem ipsum is simply free text used by copytyping refreshing."));
                    div21[i].appendChild(pp11[i]);

                }
                data.hotel=JSON.parse( data.hotel)
                document.getElementById("lujinglvguanming").innerHTML = data.hotel.houseName;
                document.getElementById("lvguanming").innerHTML = data.hotel.houseName;
                document.getElementById("lg_detail_pho").src = data.hotel.housePho;
                document.getElementById("lgmiaoshu").innerHTML = data.hotel.houseInfo;
                document.getElementById("lgaddress").innerHTML = data.hotel.houseAddress;
                for (var i = 0; i < n; i++) {
                    hh5[i].innerHTML = data.comment[i].userName;
                    pp1[i].innerHTML = data.comment[i].date;
                    pp11[i].innerHTML = data.comment[i].comment;
                }
            } else {
                alert("在加载过程中出现了一些问题，请重试！");
                window.location.href = "index.html";
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            window.location.href = "index.html";
        },


    });
});

function subhotelpl() { var id = getUrlParam("id");
    var userid = "";
    let flag=false;
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);
    $.ajax({
        url: context_path+"/usr/getMes",
        type: "get",
        async: false,
        dataType: "json",
        success: function (data, textStatus) {
            if(data.state == 50000){
                userid=data.user_id;
                flag=true;
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("在加载过程中出现了一些问题，请重试！");
            window.location.href = "index.html";
        },
    });
    if(!flag){
        alert("未登录无法发表评论！");
        return;
    }
    var userreview = document.getElementById("hoteluserreview").value;
    $.ajax({
        url: context_path + "/usr/comment",
        data: {
            user_id: userid,
            id: id,
            comment: userreview,
            type: "hotel"
        },
        async: true,
        type: "post",
        dataType: "json",
        success: function (data, textStatus) {
            if (data.state == 50000) {
                alert("发表成功");
                window.location.href = "hotelDetail.html?type=hotel&id="+id;

            } else {
                alert("出现错误");
                window.location.href = "index.html";
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("发生错误，请返回");
            window.location.href = "index.html";
        },
    });


}