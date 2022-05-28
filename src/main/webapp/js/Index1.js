$(document).ready(function () {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var context_path = pathName.substr(0, index + 1);
    var wid = (window.innerWidth - 30) / 2;

    $.ajax({
            url: context_path+"/usr/brief-inf",
            type: "get",
            async: true,
            data: {
                 type: "sights",
            },
            dataType: "json",

            success: function (data, textStatus) {



                if(data.state == 50000){
                    var area = document.getElementById("jingdian");
                    var n = data.sights_list.length;
                    var div3 = new Array(n);
                    var heading4 = new Array(n);
                    var div4 = new Array(n);
                    var img4 = new Array(n);
                    var div5 = new Array(n);
                    var ul4 = new Array(n);
                    var li4 = new Array(n * 5);
                    var span4 = new Array(n * 5);
                    var div6 = new Array(n);
                    var div7 = new Array(n);
                    var heading5 = new Array(n);
                    var a4 = new Array(n);
                    var pp4 = new Array(n);
                    var pp40 = new Array(n);
                    //初始化上面的信息
                    for (var i = 0; i < n; i++) {
                        div3[i] = document.createElement("div");
                        div3[i].classList.add("col-md-6");
                        div3[i].classList.add("col-sm-6");
                        div3[i].classList.add("col-6");
                        div3[i].classList.add("destinations-grids");
                        div3[i].classList.add("text-center");
                        area.appendChild(div3[i]);

                        heading4[i] = document.createElement("h4");
                        heading4[i].classList.add("mb-3");
                        heading4[i].classList.add("destination");
                        //heading4[i].innerHTML = sightsarray[i].sightname ;            //获取景点名称
                        div3[i].appendChild(heading4[i]);

                        div4[i] = document.createElement("div");
                        div4[i].classList.add("image-position");
                        div4[i].classList.add("position-relative");
                        div3[i].appendChild(div4[i]);

                        img4[i] = document.createElement("img");
                        //img4[i].classList.add("img-fluid");
                        img4[i].style.width = wid + "pt";
                        img4[i].style.height = "250pt";
                        //img4[i].src = sightsarray[i].sighturl;            //获取景点图片路径
                        img4[i].style.alt = "";
                        div4[i].appendChild(img4[i]);

                        div5[i] = document.createElement("div");
                        div5[i].classList.add("rating");
                        div4[i].appendChild(div5[i]);

                        ul4[i] = document.createElement("ul");
                        div5[i].appendChild(ul4[i]);

                        for (var j = 0; j < 5; j++) {
                            li4[i * 5 + j] = document.createElement("li");
                            ul4[i].appendChild(li4[i * 5 + j]);
                            span4[i * 5 + j] = document.createElement("span");
                            span4[i * 5 + j].classList.add("fa");
                            span4[i * 5 + j].classList.add("fa-star");
                            li4[i * 5 + j].appendChild(span4[i * 5 + j]);
                        }

                        div6[i] = document.createElement("div");
                        div6[i].classList.add("destinations-info");
                        div3[i].appendChild(div6[i]);

                        div7[i] = document.createElement("div");
                        div7[i].classList.add("caption");
                        div7[i].classList.add("mb-lg-3");
                        div6[i].appendChild(div7[i]);

                        heading5[i] = document.createElement("h4");
                        //heading5[i].innerHTML = "sightsarray[i].sightname";         //弹出黑色区域的设置
                        div7[i].appendChild(heading5[i]);

                        a4[i] = document.createElement("a");
                        //a4[i].id = sightsarray[i].sightid;                              //加了一个id
                        //a4[i].href = "sightsDetail.html?id="+a4[i].id;
                        a4[i].innerHTML = "Details";                                   //我们缺少这个页面
                        div7[i].appendChild(a4[i]);

                        if (i % 2 !== 0) {
                            pp4[i] = document.createElement("div");
                            pp4[i].classList.add("col-md-6");
                            pp4[i].classList.add("col-sm-6");
                            pp4[i].classList.add("col-6");
                            pp4[i].classList.add("destinations-grids");
                            pp4[i].classList.add("text-center");
                            area.appendChild(pp4[i]);
                            pp4[i].appendChild(document.createElement("br"));
                            pp4[i].appendChild(document.createElement("br"));

                            pp40[i] = document.createElement("div");
                            pp40[i].classList.add("col-md-6");
                            pp40[i].classList.add("col-sm-6");
                            pp40[i].classList.add("col-6");
                            pp40[i].classList.add("destinations-grids");
                            pp40[i].classList.add("text-center");
                            area.appendChild(pp40[i]);
                            pp40[i].appendChild(document.createElement("br"));
                            pp40[i].appendChild(document.createElement("br"));
                        }
                    }


                    for(let i=0;i<n;i++){
                        heading4[i].innerHTML = data.sights_list[i].sightName;
                        img4[i].src = data.sights_list[i].sightPho;
                        heading5[i].innerHTML = data.sights_list[i].sightName;
                        a4[i].id = data.sights_list[i].sightID;
                        a4[i].href = "sightsDetail.html?type=sights&id="+a4[i].id;
                    }
                }else{
                    alert("在加载过程中出现了一些问题，请重试！");
                    window.location.href = "index.html";
                }

            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("在加载过程中出现了一些问题，请重试！");
                window.location.href = "index.html";
            },
    });

    $.ajax({
            url: context_path+"/usr/brief-inf",
            type: "get",
            async: true,
            data: {
                 type: "hotel",
            },
            dataType: "json",

            success: function (data, textStatus) {
                var areal = document.getElementById("lvguan");
                var nl = data.hotel_list.length;
                console.log(nl)
                var div3l = new Array(nl);
                var heading4l = new Array(nl);
                var div4l = new Array(nl);
                var img4l = new Array(nl);
                var div6l = new Array(nl);
                var div7l = new Array(nl);
                var heading5l = new Array(nl);
                var a4l = new Array(nl);
                var pp4l = new Array(nl);
                var pp40l = new Array(nl);
                //初始化元素
                for (var i = 0; i < nl; i++) {
                    div3l[i] = document.createElement("div");
                    div3l[i].classList.add("col-md-6");
                    div3l[i].classList.add("col-sm-6");
                    div3l[i].classList.add("col-6");
                    div3l[i].classList.add("destinations-grids");
                    div3l[i].classList.add("text-center");
                    areal.appendChild(div3l[i]);

                    heading4l[i] = document.createElement("h4");
                    heading4l[i].classList.add("mb-3");
                    heading4l[i].classList.add("destination");
                    //heading4l[i].innerHTML = hotelsarray[i].hotelname;                    //同上
                    div3l[i].appendChild(heading4l[i]);

                    div4l[i] = document.createElement("div");
                    div4l[i].classList.add("image-position");
                    div4l[i].classList.add("position-relative");
                    div3l[i].appendChild(div4l[i]);

                    img4l[i] = document.createElement("img");
                    //img4[i].classList.add("img-fluid");
                    img4l[i].style.width = wid + "pt";
                    img4l[i].style.height = "250pt";
                    //img4l[i].src = hotelsarray[i].hotelurl;                  //同上
                    img4l[i].style.alt = "";
                    div4l[i].appendChild(img4l[i]);

                    div6l[i] = document.createElement("div");
                    div6l[i].classList.add("destinations-info");
                    div3l[i].appendChild(div6l[i]);

                    div7l[i] = document.createElement("div");
                    div7l[i].classList.add("caption");
                    div7l[i].classList.add("mb-lg-3");
                    div6l[i].appendChild(div7l[i]);

                    heading5l[i] = document.createElement("h4");
                    //heading5l[i].innerHTML = hotelsarray[i].hotelname;                 //同上
                    div7l[i].appendChild(heading5l[i]);

                    a4l[i] = document.createElement("a");
                    //a4l[i].id = hotelsarray[i].hotelid;                                         //id
                    //a4l[i].href = "sightsDetail.html?id="+a4l[i].id;
                    a4l[i].innerHTML = "Details";                      //缺少
                    div7l[i].appendChild(a4l[i]);

                    if (i % 2 !== 0) {
                        pp4l[i] = document.createElement("div");
                        pp4l[i].classList.add("col-md-6");
                        pp4l[i].classList.add("col-sm-6");
                        pp4l[i].classList.add("col-6");
                        pp4l[i].classList.add("destinations-grids");
                        pp4l[i].classList.add("text-center");
                        areal.appendChild(pp4l[i]);
                        pp4l[i].appendChild(document.createElement("br"));
                        pp4l[i].appendChild(document.createElement("br"));

                        pp40l[i] = document.createElement("div");
                        pp40l[i].classList.add("col-md-6");
                        pp40l[i].classList.add("col-sm-6");
                        pp40l[i].classList.add("col-6");
                        pp40l[i].classList.add("destinations-grids");
                        pp40l[i].classList.add("text-center");
                        areal.appendChild(pp40l[i]);
                        pp40l[i].appendChild(document.createElement("br"));
                        pp40l[i].appendChild(document.createElement("br"));
                    }
                }

                if(data.state == 50000){
                    for(var i=0;i<nl;i++){
                        heading4l[i].innerHTML = data.hotel_list[i].houseName;
                        img4l[i].src = data.hotel_list[i].housePho;
                        heading5l[i].innerHTML = data.hotel_list[i].houseName;
                        a4l[i].id = data.hotel_list[i].houseID;
                        a4l[i].href = "hotelDetail.html?type=hotel&id="+a4l[i].id;
                    }
                }else{
                    alert("在加载过程中出现了一些问题，请重试！");
                    window.location.href = "index.html";
                }

            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("在加载过程中出现了一些问题，请重试！");
                window.location.href = "index.html";
            },
    });

});